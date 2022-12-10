package christmasPastryShop.core;

import christmasPastryShop.common.ExceptionMessages;
import christmasPastryShop.common.OutputMessages;
import christmasPastryShop.core.interfaces.Controller;
import christmasPastryShop.entities.booths.interfaces.OpenBooth;
import christmasPastryShop.entities.booths.interfaces.PrivateBooth;
import christmasPastryShop.entities.cocktails.interfaces.Hibernation;
import christmasPastryShop.entities.cocktails.interfaces.MulledWine;
import christmasPastryShop.entities.delicacies.interfaces.Delicacy;
import christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import christmasPastryShop.entities.booths.interfaces.Booth;
import christmasPastryShop.entities.delicacies.interfaces.Gingerbread;
import christmasPastryShop.entities.delicacies.interfaces.Stolen;
import christmasPastryShop.repositories.interfaces.BoothRepository;
import christmasPastryShop.repositories.interfaces.CocktailRepository;
import christmasPastryShop.repositories.interfaces.DelicacyRepository;

import java.util.Optional;

public class ControllerImpl implements Controller {
    
    private DelicacyRepository<Delicacy> delicacyRepository;
    private CocktailRepository<Cocktail> cocktailRepository;
    private BoothRepository<Booth> boothRepository;
    private double income;
    

    public ControllerImpl(DelicacyRepository<Delicacy> delicacyRepository,
                          CocktailRepository<Cocktail> cocktailRepository,
                          BoothRepository<Booth> boothRepository) {
        this.delicacyRepository = delicacyRepository;
        this.cocktailRepository = cocktailRepository;
        this.boothRepository = boothRepository;
        this.income = 0;
    }


    @Override
    public String addDelicacy(String type, String name, double price) {
        if (delicacyRepository.getByName(name) != null) {
            final String exceptionMessage = String.format(ExceptionMessages.FOOD_OR_DRINK_EXIST, type, name);
            throw new IllegalArgumentException(exceptionMessage);
        }
    
        Delicacy delicacy;
        switch (type) {
            case "Gingerbread":
                delicacy = new Gingerbread(name, price);
                break;
            case "Stolen":
                delicacy = new Stolen(name, price);
                break;
            default:
                return null;
        }
    
        delicacyRepository.add(delicacy);
    
        return String.format(OutputMessages.DELICACY_ADDED, name, type);
    }

    @Override
    public String addCocktail(String type, String name, int size, String brand) {
        if (cocktailRepository.getByName(name) != null) {
            final String exceptionMessage = String.format(ExceptionMessages.FOOD_OR_DRINK_EXIST, type, name);
            throw new IllegalArgumentException(exceptionMessage);
        }
        
        Cocktail cocktail;
        switch (type) {
            case "MulledWine":
                cocktail = new MulledWine(name, size, brand);
                break;
            case "Hibernation":
                cocktail = new Hibernation(name, size, brand);
                break;
            default:
                return null;
        }
        
        cocktailRepository.add(cocktail);
        
        return String.format(OutputMessages.COCKTAIL_ADDED, name, brand);
    }

    @Override
    public String addBooth(String type, int boothNumber, int capacity) {
        if (boothRepository.getByNumber(boothNumber) != null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.BOOTH_EXIST, boothNumber));
        }
        
        Booth booth;
        switch (type) {
            case "OpenBooth":
                booth = new OpenBooth(boothNumber, capacity);
                break;
            case "PrivateBooth":
                booth = new PrivateBooth(boothNumber, capacity);
                break;
            default:
                return null;
        }
        
        boothRepository.add(booth);
    
        return String.format(OutputMessages.BOOTH_ADDED, boothNumber);
    }

    @Override
    public String reserveBooth(int numberOfPeople) {
        Optional<Booth> optionalBooth = boothRepository.getAll().stream()
                .filter(booth -> !booth.isReserved() && booth.getCapacity() >= numberOfPeople)
                .findFirst();
        
        if (optionalBooth.isEmpty()) {
            return String.format(OutputMessages.RESERVATION_NOT_POSSIBLE, numberOfPeople);
        }
    
        Booth booth = optionalBooth.get();
        booth.reserve(numberOfPeople);
    
        return String.format(OutputMessages.BOOTH_RESERVED, booth.getBoothNumber(), numberOfPeople);
    }

    @Override
    public String leaveBooth(int boothNumber) {
        Booth booth = boothRepository.getByNumber(boothNumber);
        
        final double bill = booth.getBill();
        this.income += bill;
        
        booth.clear();
        
        return String.format(OutputMessages.BILL, boothNumber, bill);
    }

    @Override
    public String getIncome() {
        return String.format(OutputMessages.TOTAL_INCOME, this.income);
    }
}
