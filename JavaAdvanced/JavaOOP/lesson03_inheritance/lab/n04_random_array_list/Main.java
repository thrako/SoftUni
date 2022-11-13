package lesson03_inheritance.lab.n04_random_array_list;

public class Main {

    public static void main(String[] args) {
        RandomArrayList<Integer> randomArrayList = new RandomArrayList<>();
        randomArrayList.add(100);
        randomArrayList.add(101);
        randomArrayList.add(102);
        randomArrayList.add(103);
        randomArrayList.add(104);
        randomArrayList.add(105);
        randomArrayList.add(106);
        randomArrayList.add(107);
        randomArrayList.add(108);
        randomArrayList.add(109);
        System.out.println(randomArrayList.getRandomElement());
        System.out.println(randomArrayList.getRandomElement());
        System.out.println(randomArrayList.getRandomElement());
    }

}
