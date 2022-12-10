package christmasPastryShop.entities.delicacies.interfaces;

import christmasPastryShop.common.ExceptionMessages;
import christmasPastryShop.common.OutputMessages;

public abstract class BaseDelicacy implements Delicacy {
    
    private String name;
    private double portion;
    private double price;
    
    protected BaseDelicacy(String name, double portion, double price) {
        this.setName(name);
        this.setPortion(portion);
        this.setPrice(price);
    }
    
    @Override
    public String getName() {
        return this.name;
    }
    
    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_NAME);
        }
        
        this.name = name;
    }
    
    @Override
    public double getPortion() {
        return this.portion;
    }
    
    private void setPortion(double portion) {
        if (portion <= 0) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_PORTION);
        }
        
        this.portion = portion;
    }
    
    @Override
    public double getPrice() {
        return this.price;
    }
    
    private void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_PRICE);
        }
        
        this.price = price;
    }
    
    @Override
    public String toString() {
        return String.format(OutputMessages.DELICACY_TO_STRING_FORMAT, this.name, this.portion, this.price);
    }
}
