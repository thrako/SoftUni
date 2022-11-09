package lesson05_lists.exercise;

import java.util.*;

public class N10SoftUniCoursePlanning {
    private static final String END = "course start";
    private static List<List<String>> schedule = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> initials = new ArrayList<>(Arrays.asList(scanner.nextLine().split(", ")));
        for (String initial : initials) {
            if (!"".equals(initial)) schedule.add(new ArrayList<>(Collections.singleton(initial)));
        }

        String[] tokens = scanner.nextLine().split(":");
        while (!END.equals(tokens[0])) {
            String command = tokens[0];
            switch (command) {
                case "Add":
                    add(tokens[1]);
                    break;
                case "Insert":
                    add(tokens[1], Integer.parseInt(tokens[2]));
                    break;
                case "Remove":
                    remove(tokens[1]);
                    break;
                case "Swap":
                    swap(tokens[1], tokens[2]);
                    break;
                case "Exercise":
                    addExercise(tokens[1]);
                    break;
            }
            tokens = scanner.nextLine().split(":");
        }

        printEnumerated(schedule);
    }

    private static void add(String lessonTitle) {
        if (exists(lessonTitle)) return;
        List<String> course = new ArrayList<>(Collections.singleton(lessonTitle));
        schedule.add(course);
    }

    private static void add(String lessonTitle, int idx) {
        if (exists(lessonTitle) || !isInBounds(idx)) return;
        List<String> course = new ArrayList<>(Collections.singleton(lessonTitle));
        schedule.add(idx, course);
    }

    private static void remove(String lessonTitle) {
        int idx = indexOf(lessonTitle);
        if (idx != -1) schedule.remove(idx);
    }

    private static void swap(String firstLesson, String secondLesson) {
        int idx1 = indexOf(firstLesson);
        int idx2 = indexOf(secondLesson);

        if (!isInBounds(idx1) || !isInBounds(idx2)) return;
        List<String> tempList = schedule.get(idx1);
        schedule.set(idx1, schedule.get(idx2));
        schedule.set(idx2, tempList);
    }

    private static void addExercise(String lessonTitle) {
        int idx = indexOf(lessonTitle);
        if (idx != -1) {
            if (schedule.get(idx).size() == 1) schedule.get(idx).add(lessonTitle.concat("-Exercise"));
        } else {
            List<String> tempList = new ArrayList<>(2);
            tempList.add(lessonTitle);
            tempList.add(lessonTitle.concat("-Exercise"));
            schedule.add(tempList);
        }
    }

    private static void printEnumerated(List<List<String>> schedule) {
        List<String> tempList = new ArrayList<>(schedule.size() * 2);
        int counter = 0;
        for (List<String> stringList : schedule) {
            for (String string : stringList) {
                tempList.add(String.valueOf(++counter).concat(".").concat(string));
            }
        }
        for (String str : tempList) {
            System.out.println(str);
        }
    }

    private static boolean exists(String lessonTitle) {
        for (List<String> strList : schedule) {
            if (strList.get(0).equals(lessonTitle)) return true;
        }
        return false;
    }

    private static int indexOf(String lessonTitle) {

        for (int i = 0, size = schedule.size(); i < size; i++) {
            List<String> strList = schedule.get(i);
            if (strList.get(0).equals(lessonTitle)) return i;
        }
        return -1;
    }

    private static boolean isInBounds(int idx) {
        int size = schedule.size();
        return idx >= 0 && idx < size;
    }
}
