package goldDigger.core;

import goldDigger.common.ConstantMessages;
import goldDigger.common.ExceptionMessages;
import goldDigger.models.discoverer.Anthropologist;
import goldDigger.models.discoverer.Archaeologist;
import goldDigger.models.discoverer.Discoverer;
import goldDigger.models.discoverer.Geologist;
import goldDigger.models.operation.OperationImpl;
import goldDigger.models.spot.Spot;
import goldDigger.models.spot.SpotImpl;
import goldDigger.repositories.DiscovererRepository;
import goldDigger.repositories.SpotRepository;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {

    private static final int MINIMUM_ENERGY_REQUIRED = 45;

    private final DiscovererRepository discovererRepository;
    private final SpotRepository spotRepository;
    private int inspectedSpots;


    public ControllerImpl() {
        this.discovererRepository = new DiscovererRepository();
        this.spotRepository = new SpotRepository();
        this.inspectedSpots = 0;
    }

    @Override
    public String addDiscoverer(String kind, String discovererName) {
        Discoverer discoverer = getDiscoverer(kind, discovererName);
        this.discovererRepository.add(discoverer);
        return String.format(ConstantMessages.DISCOVERER_ADDED, kind, discovererName);
    }

    @Override
    public String addSpot(String spotName, String... exhibits) {
        Spot spot = new SpotImpl(spotName);
        spot.getExhibits().addAll(List.of(exhibits));
        spotRepository.add(spot);

        return String.format(ConstantMessages.SPOT_ADDED, spotName);
    }

    @Override
    public String excludeDiscoverer(String discovererName) {

        final String exceptionMessage = String.format(ExceptionMessages.DISCOVERER_DOES_NOT_EXIST, discovererName);

        final Discoverer excludedDiscoverer = discovererRepository.getCollection().stream()
                .filter(d -> d.getName().equals(discovererName))
                .findFirst().orElseThrow(() -> new IllegalArgumentException(exceptionMessage));

        discovererRepository.remove(excludedDiscoverer);

        return String.format(ConstantMessages.DISCOVERER_EXCLUDE, excludedDiscoverer.getName());
    }

    @Override
    public String inspectSpot(String spotName) {

        final List<Discoverer> spotDiscoverers = getSpotDiscoverers();
        final Spot spot = spotRepository.byName(spotName);

        new OperationImpl().startOperation(spot, spotDiscoverers);

        this.inspectedSpots++;

        final long exhaustedDiscoverersCount = getExhaustedDiscoverersCount(spotDiscoverers);

        return getInspectedSpotMessage(spotName, exhaustedDiscoverersCount);
    }

    @Override
    public String getStatistics() {

        final StringBuilder strBld = new StringBuilder();
        final String newLine = System.lineSeparator();

        strBld
                .append(String.format(ConstantMessages.FINAL_SPOT_INSPECT, inspectedSpots))
                    .append(newLine)
                .append(ConstantMessages.FINAL_DISCOVERER_INFO)
                    .append(newLine);

        strBld.append(discovererRepository.getCollection().stream()
                .map(this::getInfo)
                .collect(Collectors.joining(newLine)));

        return strBld.toString();
    }

    private Discoverer getDiscoverer(String kind, String discovererName) {

        Discoverer discoverer;
        switch (kind) {
            case "Anthropologist":
                discoverer = new Anthropologist(discovererName);
                break;
            case "Archaeologist":
                discoverer = new Archaeologist(discovererName);
                break;
            case "Geologist":
                discoverer = new Geologist(discovererName);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.DISCOVERER_INVALID_KIND);
        }
        return discoverer;
    }

    private List<Discoverer> getSpotDiscoverers() {
        final List<Discoverer> spotDiscoverers = discovererRepository.getCollection().stream()
                .filter(d -> d.getEnergy() > MINIMUM_ENERGY_REQUIRED)
                .collect(Collectors.toList());
        if (spotDiscoverers.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.SPOT_DISCOVERERS_DOES_NOT_EXISTS);
        }
        return spotDiscoverers;
    }

    private long getExhaustedDiscoverersCount(List<Discoverer> spotDiscoverers) {
        return spotDiscoverers.stream()
                .filter(d -> d.getEnergy() == 0)
                .count();
    }

    private String getInspectedSpotMessage(String spotName, long exhaustedDiscoverersCount) {
        return String.format(ConstantMessages.INSPECT_SPOT,
                spotName, exhaustedDiscoverersCount);
    }

    private String getInfo(Discoverer discoverer) {
        final StringBuilder strBld = new StringBuilder();
        final String newLine = System.lineSeparator();

        return strBld
                .append(getNameInfo(discoverer))
                    .append(newLine)
                .append(getEnergyInfo(discoverer))
                    .append(newLine)
                .append(getExhibitsInfo(discoverer))
                .toString();
    }

    private String getNameInfo(Discoverer discoverer) {
        return String.format(ConstantMessages.FINAL_DISCOVERER_NAME, discoverer.getName());
    }

    private String getEnergyInfo(Discoverer discoverer) {
        return String.format(ConstantMessages.FINAL_DISCOVERER_ENERGY, discoverer.getEnergy());
    }

    private String getExhibitsInfo(Discoverer discoverer) {
        final Collection<String> exhibits = discoverer.getMuseum().getExhibits();
        final String exhibitsString = exhibits.isEmpty()
                ? "None"
                : String.join(ConstantMessages.FINAL_DISCOVERER_MUSEUM_EXHIBITS_DELIMITER, exhibits);

        return String.format(ConstantMessages.FINAL_DISCOVERER_MUSEUM_EXHIBITS, exhibitsString);
    }

}
