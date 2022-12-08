package archeologicalExcavations;

public class Main {
    public static void main(String[] args) {
        Excavation excavation = new Excavation("Pliska", 10);
        Archaeologist nullArchaeologist = null;
        excavation.addArchaeologist(nullArchaeologist);
        System.out.println(excavation.getCount());
    }
}
