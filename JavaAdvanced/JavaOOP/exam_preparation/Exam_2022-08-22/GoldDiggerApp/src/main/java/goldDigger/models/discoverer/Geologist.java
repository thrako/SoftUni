package goldDigger.models.discoverer;

public class Geologist extends BaseDiscoverer {

    public static final double INITIAL_ENERGY = 100.00;

    public Geologist(String name) {
        super(name, INITIAL_ENERGY);
    }
}
