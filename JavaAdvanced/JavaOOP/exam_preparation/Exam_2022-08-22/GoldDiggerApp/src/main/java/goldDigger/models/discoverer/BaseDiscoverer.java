package goldDigger.models.discoverer;

import goldDigger.common.ExceptionMessages;
import goldDigger.models.museum.BaseMuseum;
import goldDigger.models.museum.Museum;

public abstract class BaseDiscoverer implements Discoverer {
    private static final int DIGGING_ENERGY_COST = 15;

    private String name;
    private double energy;
    private Museum museum;

    protected BaseDiscoverer(String name, double energy) {
        setName(name);
        setEnergy(energy);
        this.museum = new BaseMuseum();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        if ( name == null || name.trim().isEmpty() ) {
            throw new NullPointerException(ExceptionMessages.DISCOVERER_NAME_NULL_OR_EMPTY);
        }

        this.name = name;
    }

    public double getEnergy() {
        return energy;
    }

    public void setEnergy(double energy) {

        if ( energy < 0 ) {
            throw new IllegalArgumentException(ExceptionMessages.DISCOVERER_ENERGY_LESS_THAN_ZERO);
        }

        this.energy = energy;
    }

    public Museum getMuseum() {
        return museum;
    }

    public void dig() {
        this.energy = Math.max(this.energy - DIGGING_ENERGY_COST, 0);
    }

    public boolean canDig() {
        return this.energy > 0;
    }

}
