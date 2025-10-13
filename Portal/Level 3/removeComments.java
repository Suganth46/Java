public class removeComments {
    public static void main(String[] args) {
        String inputCode = "#include <stdio.h> int main() { printf(,Hello /* not a comment */ world,);  /* actual comment */ printf(,Another // fake comment,);}// fake comment ";

        StringBuilder result = new StringBuilder();
        boolean inSingleLineComment = false;
        boolean inMultiLineComment = false;
        boolean inString = false;

        for (int i = 0; i < inputCode.length(); i++) {
            char curr = inputCode.charAt(i);

            // Toggle string state if not in comment
            if (!inSingleLineComment && !inMultiLineComment) {
                if (curr == ',' && (i == 0 || inputCode.charAt(i - 1) != '\\')) {
                    inString = !inString;
                }
            }

            if (!inString) {
               if (inSingleLineComment) {
                if (inputCode.charAt(i) == '\n') {
                    inSingleLineComment = false;
                    result.append('\n');
                }
            } else if (inMultiLineComment) {
                if (inputCode.charAt(i) == '*' && i + 1 < inputCode.length() && inputCode.charAt(i + 1) == '/') {
                    inMultiLineComment = false;
                    i++; // skip '/'
                } else if (inputCode.charAt(i) == '\n') {
                    // skip newline from comment to avoid blank lines
                }
            } else {
                if (inputCode.charAt(i) == '/' && i + 1 < inputCode.length()) {
                    if (inputCode.charAt(i + 1) == '/') {
                        inSingleLineComment = true;
                        i++; // skip second '/'
                    } else if (inputCode.charAt(i + 1) == '*') {
                        inMultiLineComment = true;
                        i++; // skip '*'
                    } else {
                        result.append(inputCode.charAt(i));
                    }
                } else {
                    result.append(inputCode.charAt(i));
                }
            }

            // Add valid character
            result.append(curr);
        }

        // Remove extra blank lines
        String finalOutput = result.toString().replaceAll("(?m)^\\s*\n", "");

        System.out.println("Output without comments:\n");
        System.out.println(finalOutput.trim());
    }
}
}