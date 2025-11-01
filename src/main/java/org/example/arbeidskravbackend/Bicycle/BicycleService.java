package org.example.arbeidskravbackend.Bicycle;

import org.example.arbeidskravbackend.Manufacturer.ManufacturerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BicycleService {

    private final BicycleRepo repo;
    private final ManufacturerService manufacturerService;


    public BicycleService(BicycleRepo repo, ManufacturerService manufacturerService) {
        this.repo = repo;
        this.manufacturerService = manufacturerService;
    }

    public Bicycle getBicycleById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public List<Bicycle> getAllBicycles() {
        return repo.findAll();
    }

    public Bicycle addBicycle(BicycleDto bicycle) {

        return repo.save(new Bicycle(
                bicycle.name(),
                bicycle.color(),
                bicycle.model(),
                bicycle.inStock(),
                manufacturerService.getManufacturerById(bicycle.manufacturerId())
        ));
    }

    public void removeBicycle(Long id) {
        repo.deleteById(id);
    }

    public List<Bicycle> getAllBicyclesInStock() {
        return repo.findAll().stream()
                .filter( b -> b.getInStock() > 0)
                .toList();
    }

    public List<Bicycle> getAllBicyclesOutOfStock() {
        return repo.findAll().stream().filter( b -> b.getInStock() == 0)
                .toList();
    }
}
