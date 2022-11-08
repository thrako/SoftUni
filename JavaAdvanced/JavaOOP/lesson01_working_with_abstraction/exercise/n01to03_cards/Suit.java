package lesson01_working_with_abstraction.exercise.n01to03_cards;

public enum Suit {
    CLUBS(0), DIAMONDS(13), HEARTS(26), SPADES(39);
    private final int power;

    Suit(int power) {
        this.power = power;
    }

    public int getPower() {
        return power;
    }

}
