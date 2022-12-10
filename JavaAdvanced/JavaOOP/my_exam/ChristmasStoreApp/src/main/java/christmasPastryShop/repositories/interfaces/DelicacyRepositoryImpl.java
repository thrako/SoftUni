package christmasPastryShop.repositories.interfaces;

import christmasPastryShop.entities.delicacies.interfaces.Delicacy;

import java.util.ArrayList;
import java.util.Collection;


public class DelicacyRepositoryImpl implements DelicacyRepository<Delicacy> {
    
    Collection<Delicacy> delicacies;
    
    public DelicacyRepositoryImpl() {
        this.delicacies = new ArrayList<>();
    }
    
    @Override
    public Delicacy getByName(String name) {
        return this.delicacies.stream()
                .filter(delicacy -> delicacy.getName().equals(name))
                .findFirst().orElse(null);
    }
    
    @Override
    public Collection<Delicacy> getAll() {
        return this.delicacies;
    }
    
    @Override
    public void add(Delicacy delicacy) {
        this.delicacies.add(delicacy);
    }
}
