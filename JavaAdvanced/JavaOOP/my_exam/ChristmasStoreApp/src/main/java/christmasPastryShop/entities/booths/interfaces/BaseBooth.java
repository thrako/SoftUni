package christmasPastryShop.entities.booths.interfaces;

import christmasPastryShop.common.ExceptionMessages;
import christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import christmasPastryShop.entities.delicacies.interfaces.Delicacy;

import java.util.ArrayList;
import java.util.Collection;

public abstract class BaseBooth implements Booth {
    
    private Collection<Delicacy> delicacyOrders;
    private Collection<Cocktail> cocktailOrders;
    private int boothNumber;
    private int capacity;
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReserved;
    private double price;
    
    public BaseBooth(int boothNumber, int capacity, double pricePerPerson) {
        this.delicacyOrders = new ArrayList<>();
        this.cocktailOrders = new ArrayList<>();
        this.boothNumber = boothNumber;
        this.setCapacity(capacity);
        this.pricePerPerson = pricePerPerson;
    }
    
    public void setCapacity(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_TABLE_CAPACITY);
        }
        
        this.capacity = capacity;
    }
    
    public void setNumberOfPeople(int numberOfPeople) {
        if (numberOfPeople <= 0) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_NUMBER_OF_PEOPLE);
        }
        
        this.numberOfPeople = numberOfPeople;
    }
    
    @Override
    
    public int getBoothNumber() {
        return this.boothNumber;
    }
    
    @Override
    public int getCapacity() {
        return this.capacity;
    }
    
    @Override
    public boolean isReserved() {
        return this.isReserved;
    }
    
    @Override
    public double getPrice() {
        return this.price;
    }
    
    @Override
    public void reserve(int numberOfPeople) {
        this.setNumberOfPeople(numberOfPeople);
        this.isReserved = true;
        this.price = this.numberOfPeople * pricePerPerson;
    }
    
    @Override
    public double getBill() {
        return this.price + getCocktailsSum() + getDelicaciesSum();
    }
    
    private double getDelicaciesSum() {
        return this.delicacyOrders.stream().mapToDouble(Delicacy::getPrice).sum();
    }
    
    private double getCocktailsSum() {
        return this.cocktailOrders.stream().mapToDouble(Cocktail::getPrice).sum();
    }
    
    @Override
    public void clear() {
        this.delicacyOrders.clear();
        this.cocktailOrders.clear();
        this.numberOfPeople = 0;
        this.isReserved = false;
        this.price = 0;
    }
}
