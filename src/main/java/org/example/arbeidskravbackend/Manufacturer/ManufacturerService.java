package org.example.arbeidskravbackend.Manufacturer;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufacturerService {

    private ManufacturerRepo repo;

    public ManufacturerService(ManufacturerRepo repo) {
        this.repo = repo;
    }

    public Manufacturer getManufacturerById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public List<Manufacturer> getAllManufacturers() {
        return repo.findAll();
    }

    public Manufacturer addManufacturer(Manufacturer manufacturer) {
        return repo.save(manufacturer);
    }

    public void removeManufacturer(Long id) {repo.deleteById(id);}
}
