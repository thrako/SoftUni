package lesson04_interfaces.exercise.n07_collections;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        final Scanner scanner = new Scanner(System.in);

        final AddCollection addCol = new AddCollection();
        final AddRemoveCollection addRemoveCol = new AddRemoveCollection();
        final MyListImpl myList = new MyListImpl();

        final List<Addable> addables = new ArrayList<>(List.of(addCol, addRemoveCol, myList));
        final List<AddRemovable> removables = new ArrayList<>(List.of(addRemoveCol, myList));

        final List<String> elements = getElements(scanner);
        final Map<String, List<Integer>> additionsMap = addElements(addables, elements);
        printAdditions(additionsMap);

        int removalsCount = Integer.parseInt(scanner.nextLine());
        final Map<String, List<String>> removalsMap = removeElements(removalsCount, removables);
        printRemovals(removalsMap);
    }

    private static List<String> getElements(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());
    }

    private static Map<String, List<Integer>> addElements(List<Addable> collections, List<String> elements) {
        Map<String, List<Integer>> additionsMap = new LinkedHashMap<>();

        collections.forEach(collection -> {
            final String simpleName = collection.getClass().getSimpleName();
            additionsMap.put(simpleName, new ArrayList<>());
            elements.forEach(element -> additionsMap.get(simpleName).add(collection.add(element)));
        });

        return additionsMap;
    }

    private static Map<String, List<String>> removeElements(int removalsCount, List<AddRemovable> collections) {
        Map<String, List<String>> removalsMap = new LinkedHashMap<>();

        collections.forEach(collection -> {
            String simpleName = collection.getClass().getSimpleName();
            removalsMap.put(simpleName, new ArrayList<>());
        });

        while (removalsCount-- > 0) {
            collections.forEach(collection -> {
                String simpleName = collection.getClass().getSimpleName();
                removalsMap.get(simpleName).add(collection.remove());
            });
        }

        return removalsMap;
    }

    private static void printAdditions(Map<String, List<Integer>> map) {
        map.values().forEach(collection -> System.out.println(collection.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" "))));
    }

    private static void printRemovals(Map<String, List<String>> map) {
        map.values().forEach(collection -> System.out.println(String.join(" ", collection)));
    }

}
