import java.util.*;

public class Find_free_slot_in_time_table {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        List<List<Integer>> timetable = new ArrayList<>();

    
        for (int i = 0; i < 6; i++) {
            String input = scanner.nextLine();
            timetable.add(parseTimeSlots(input));
        }

      
        for (int i = 0; i < 6; i++) {
            for (int j = 1; j <= 10; j++) {
                if (j == 6) continue; 
                if (!timetable.get(i).contains(j)) {
                    System.out.println(days[i] + " " + j);
                    return;
                }
            }
        }

        System.out.println("No Free Slots");
    }

    private static List<Integer> parseTimeSlots(String input) {
        List<Integer> slots = new ArrayList<>();
        String[] parts = input.split("\\[|\\]");
        for (String part : parts) {
            if (part.isEmpty()) continue;
            if (part.contains("-")) {
                String[] range = part.split("-");
                int start = Integer.parseInt(range[0]);
                int end = Integer.parseInt(range[1]);
                for (int i = start; i <= end; i++) {
                    slots.add(i);
                }
            } else {
                slots.add(Integer.parseInt(part));
            }
        }
        return slots;
    }
}
