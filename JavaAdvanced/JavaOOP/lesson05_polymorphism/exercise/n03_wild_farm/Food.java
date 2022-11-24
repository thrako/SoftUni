package lesson05_polymorphism.exercise.n03_wild_farm;

public abstract class Food {
    Integer quantity;

    public Food(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
