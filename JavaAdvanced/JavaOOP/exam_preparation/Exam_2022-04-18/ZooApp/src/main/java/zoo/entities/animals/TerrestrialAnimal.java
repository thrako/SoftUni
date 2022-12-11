package zoo.entities.animals;

public class TerrestrialAnimal extends BaseAnimal {
    
    private static final double INITIAL_KILOGRAMS = 5.50;
    private static final double GAINED_WEIGHT = 5.70;
    
    public TerrestrialAnimal(String name, String kind, double price) {
        super(name, kind, INITIAL_KILOGRAMS, price);
    }
    
    @Override
    public void eat() {
        this.setKg(this.getKg() + GAINED_WEIGHT);
    }
}
