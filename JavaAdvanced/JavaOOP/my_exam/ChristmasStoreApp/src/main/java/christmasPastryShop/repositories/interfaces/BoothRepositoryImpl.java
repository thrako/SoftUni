package christmasPastryShop.repositories.interfaces;

import christmasPastryShop.entities.booths.interfaces.Booth;

import java.util.ArrayList;
import java.util.Collection;

public class BoothRepositoryImpl implements BoothRepository<Booth> {
    
    Collection<Booth> booths;
    
    public BoothRepositoryImpl() {
        this.booths = new ArrayList<>();
    }
    
    @Override
    public Booth getByNumber(int number) {
        return this.booths.stream()
                .filter(booth -> booth.getBoothNumber() == number)
                .findFirst().orElse(null);
    }
    
    @Override
    public Collection<Booth> getAll() {
        return this.booths;
    }
    
    @Override
    public void add(Booth booth) {
        this.booths.add(booth);
    }
}
