import java.util.*;

public class WordBreak {
    static Map<String, List<String>> memo;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        while (T-- > 0) {
            int N = sc.nextInt();
            sc.nextLine();
            String[] dictArr = sc.nextLine().trim().split(" ");
            Set<String> dict = new HashSet<>(Arrays.asList(dictArr));
            String s = sc.nextLine().trim();
            memo = new HashMap<>();
            List<String> results = wordBreak(s, dict);
            Collections.sort(results);
            if (results.isEmpty()) {
                System.out.println("No possible sentence");
            } else {
                for (String sentence : results) {
                    System.out.println(sentence);
                }
            }
        }
        sc.close();
    }

    static List<String> wordBreak(String s, Set<String> dict) {
        if (memo.containsKey(s)) return memo.get(s);
        List<String> res = new ArrayList<>();
        if (s.length() == 0) {
            res.add("");
            return res;
        }
        List<String> sortedDict = new ArrayList<>(dict);
        Collections.sort(sortedDict);
        for (String word : sortedDict) {
            if (s.startsWith(word)) {
                List<String> subList = wordBreak(s.substring(word.length()), dict);
                for (String sub : subList) {
                    if (sub.isEmpty())
                        res.add(word);
                    else
                        res.add(word + " " + sub);
                }
            }
        }
        memo.put(s, res);
        return res;
    }
}
