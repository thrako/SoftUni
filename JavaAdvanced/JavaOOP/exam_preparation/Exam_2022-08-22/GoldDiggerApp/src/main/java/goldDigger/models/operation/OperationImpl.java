package goldDigger.models.operation;

import goldDigger.models.discoverer.Discoverer;
import goldDigger.models.spot.Spot;

import java.util.Collection;

public class OperationImpl implements Operation {

    @Override
    public void startOperation(Spot spot, Collection<Discoverer> discoverers) {
        final Collection<String> exhibits = spot.getExhibits();

        for (Discoverer discoverer : discoverers) {
            while (discoverer.canDig() && !exhibits.isEmpty()) {
                discoverer.dig();
                final var exhibit = exhibits.iterator().next();
                discoverer.getMuseum().getExhibits().add(exhibit);
                exhibits.remove(exhibit);
            }
        }
    }

}
