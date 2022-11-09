package lesson01_working_with_abstraction.exercise.n06_greedy_times;

import java.util.LinkedHashMap;
import java.util.Map;

public class Bag {
    Map<String, Map<String, Long>> items = new LinkedHashMap<>();
    long capacity;

    public Bag(long capacity) {
        this.capacity = capacity;
    }

    public void addItem(String type, String name, long quantity) {
        items.putIfAbsent(type, new LinkedHashMap<>());
        if (isPermitted(type, quantity)) {
            items.get(type).putIfAbsent(name, 0L);
            items.get(type).put(name, items.get(type).get(name) + quantity);
        }
    }

    private boolean isPermitted(String type, long quantity) {
        long totalGold = getTotal("Gold");
        long totalGem = getTotal("Gem");
        long totalCash = getTotal("Cash");

        if (capacity < (totalGold + totalGem + totalCash + quantity)) return false;
        if (type.equals("Gem") && (totalGem + quantity > totalGold)) return false;
        //noinspection RedundantIfStatement reason: clarity
        if (type.equals("Cash") && (totalCash + quantity > totalGem)) return false;
        return true;
    }

    private long getTotal(String type) {
        if (items.get(type) == null) return 0L;
        else return items.get(type).values().stream().reduce(Long::sum).orElse(0L);
    }

    public void printContents() {
        StringBuilder strBld = new StringBuilder();
        items.entrySet().stream()
                .filter(type -> !type.getValue().isEmpty())
                .sorted((e1, e2) -> Long.compare(getTotal(e2.getKey()), getTotal(e1.getKey())))
                .forEach(entry -> appendInfo(strBld, entry));
        System.out.print(strBld);
    }

    private void appendInfo(StringBuilder strBld, Map.Entry<String, Map<String, Long>> entry) {
        strBld.append(String.format("<%s> $%d%n", entry.getKey(), getTotal(entry.getKey())));
        entry.getValue().entrySet().stream()
                .sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey()))
                .forEach(e -> strBld.append(String.format("##%s - %d%n", e.getKey(), e.getValue())));
    }

}
