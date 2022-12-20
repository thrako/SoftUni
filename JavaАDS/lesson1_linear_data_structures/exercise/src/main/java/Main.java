import implementations.ReversedList;

public class Main {
    public static void main(String[] args) {

        ReversedList<Integer> reversedList = new ReversedList<Integer>();
        reversedList.add(0);
        reversedList.add(1);
        reversedList.add(2);
        reversedList.add(3);
        reversedList.add(4);


        reversedList.removeAt(1);
        reversedList.forEach(System.out::println);

    }
}
