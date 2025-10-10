package org.example.arbeidskravbackend.Bicycle;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BicycleService {

    private final BicycleRepo repo;

    public BicycleService(BicycleRepo repo) {
        this.repo = repo;
    }

    public Bicycle getBicycleById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public List<Bicycle> getAllBicycles() {
        return repo.findAll();
    }

    public Bicycle addBicycle(Bicycle bicycle) {
        return repo.save(bicycle);
    }

    public void removeBicycle(Long id) {
        repo.deleteById(id);
    }

    public List<Bicycle> bicylesInStock() {
        return repo.findBy()
    }
}
