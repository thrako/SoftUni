package zoo.core;

import zoo.common.ConstantMessages;
import zoo.common.ExceptionMessages;
import zoo.entities.animals.Animal;
import zoo.entities.animals.AquaticAnimal;
import zoo.entities.animals.TerrestrialAnimal;
import zoo.entities.areas.Area;
import zoo.entities.areas.LandArea;
import zoo.entities.areas.WaterArea;
import zoo.entities.foods.Food;
import zoo.entities.foods.Meat;
import zoo.entities.foods.Vegetable;
import zoo.repositories.FoodRepository;
import zoo.repositories.FoodRepositoryImpl;

import java.util.*;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {
    
    private FoodRepository foodRepository;
    private Collection<Area> areas;
    private Map<String, String> areasAnimals;
    
    public ControllerImpl() {
        this.foodRepository = new FoodRepositoryImpl();
        this.areas = new ArrayList<>();
        this.areasAnimals = new HashMap<>();
        areasAnimals.put("WaterArea", "AquaticAnimal");
        areasAnimals.put("LandArea", "TerrestrialAnimal");
    }
    
    @Override
    public String addArea(String areaType, String areaName) {
        Area area = getNewArea(areaType, areaName);
    
        this.areas.add(area);
    
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_AREA_TYPE, areaType);
    }
    
    @Override
    public String buyFood(String foodType) {
        Food food = getNewFood(foodType);
    
        this.foodRepository.add(food);
    
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_FOOD_TYPE, foodType);
        
    }
    
    @Override
    public String foodForArea(String areaName, String foodType) {
        String exMessage = String.format(ExceptionMessages.NO_FOOD_FOUND, foodType);
        Food food = Optional.ofNullable(foodRepository.findByType(foodType))
                .orElseThrow(() -> new IllegalArgumentException(exMessage));
    
        getAreaByName(areaName).addFood(food);
    
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_FOOD_IN_AREA, foodType, areaName);
    }
    
    @Override
    public String addAnimal(String areaName,
                            String animalType,
                            String animalName,
                            String kind,
                            double price) {
    
        Area area = getAreaByName(areaName);
        Animal animal = getNewAnimal(animalType, animalName, kind, price);
    
        if (!areasAnimals.get(area.getClass().getSimpleName()).equals(animalType)) {
            return "The external living environment is not suitable.";
        }
    
        try {
            area.addAnimal(animal);
        } catch (IllegalStateException e) {
            return e.getMessage();
        }
    
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_ANIMAL_IN_AREA, animalType, areaName);
    }
    
    @Override
    public String feedAnimal(String areaName) {
        Area area = getAreaByName(areaName);
        Collection<Animal> animals = area.getAnimals();
        
        animals.forEach(Animal::eat);
        
        return String.format(ConstantMessages.ANIMALS_FED, animals.size());
    }
    
    @Override
    public String calculateKg(String areaName) {
        double sum = getAreaByName(areaName).getAnimals().stream()
                                                        .mapToDouble(Animal::getKg)
                                                        .sum();
 
        return String.format(ConstantMessages.KILOGRAMS_AREA, areaName, sum);
    }
    
    @Override
    public String getStatistics() {
        return areas.stream()
                .map(Area::getInfo)
                .collect(Collectors.joining(System.lineSeparator()));
    }
    
    private Food getNewFood(String type) {
        Food food;
        
        switch (type) {
            case "Vegetable":
                food = new Vegetable();
                break;
            case "Meat":
                food = new Meat();
                break;
            
            default:
                throw new IllegalArgumentException (ExceptionMessages.INVALID_FOOD_TYPE);
        }
        return food;
    }
    
    private Area getNewArea(String type, String name) {
        Area area;
        
        switch (type) {
            case "WaterArea":
                area = new WaterArea(name);
                break;
            case "LandArea":
                area = new LandArea(name);
                break;
            default:
                throw new NullPointerException(ExceptionMessages.INVALID_AREA_TYPE);
        }
        return area;
    }
    
    private Area getAreaByName(String areaName) {
        return areas.stream()
                .filter(a -> a.getName().equals(areaName))
                .findFirst().orElse(null);
    }
    
    private Animal getNewAnimal(String type, String name, String kind, double price) {
        switch (type) {
            case "AquaticAnimal":
                return new AquaticAnimal(name, kind, price);
            case "TerrestrialAnimal":
                return new TerrestrialAnimal(name, kind, price);
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_ANIMAL_TYPE);
        }
    }
}
