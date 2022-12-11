package zoo.entities.animals;

import zoo.common.ExceptionMessages;

public abstract class BaseAnimal implements Animal {
    
    private String name;
    private String kind;
    private double kg;
    private double price;
    
    protected BaseAnimal(String name, String kind, double kg, double price) {
        setName(name);
        setKind(kind);
        this.kg = kg;
        setPrice(price);
    }
    
    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.ANIMAL_NAME_NULL_OR_EMPTY);
        }
        
        this.name = name;
    }
    
    @Override
    public String getName() {
        return this.name;
    }
    
    private void setKind(String kind) {
        if (kind == null || kind.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.ANIMAL_KIND_NULL_OR_EMPTY);
        }
        
        this.kind = kind;
    }
    
    public void setKg(double kg) {
        this.kg = kg;
    }
    
    @Override
    public double getKg() {
        return this.kg;
    }
    
    private void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException(ExceptionMessages.ANIMAL_PRICE_BELOW_OR_EQUAL_ZERO);
        }
        
        this.price = price;
    }
    
    @Override
    public double getPrice() {
        return this.price;
    }
    
    @Override
    public abstract void eat();
}
