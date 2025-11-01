package org.example.arbeidskravbackend.testData;

import com.github.javafaker.Faker;
import org.example.arbeidskravbackend.Bicycle.Bicycle;
import org.example.arbeidskravbackend.Bicycle.BicycleDto;
import org.example.arbeidskravbackend.Bicycle.BicycleRepo;
import org.example.arbeidskravbackend.Manufacturer.Manufacturer;
import org.example.arbeidskravbackend.Manufacturer.ManufacturerRepo;
import org.example.arbeidskravbackend.Manufacturer.ManufacturerService;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class TestData {

    private final BicycleRepo bicycleRepo;
    private final ManufacturerRepo manufacturerRepo;
    private final Faker faker = new Faker();
    private final ManufacturerService manufacturerService;

    public TestData(BicycleRepo bicycleRepo, ManufacturerRepo manufacturerRepo, ManufacturerService manufacturerService) {
        this.bicycleRepo = bicycleRepo;
        this.manufacturerRepo = manufacturerRepo;
        this.manufacturerService = manufacturerService;
    }
    public void createTestData() {
        createManufacturers();

        for (int i = 0; i < 50; i++) {
            var randomManufacturer = new Random().nextLong(20);
            bicycleRepo.save(new Bicycle(
                    faker.name().name(),
                    faker.color().name(),
                    faker.ancient().god().toUpperCase(),
                    new Random().nextLong(11),
                    manufacturerService.getManufacturerById(randomManufacturer)
            ));

        }
    }

    private void createManufacturers(){
        for (int i = 1; i <= 20; i++) {
            manufacturerRepo.save(new Manufacturer(
                    faker.internet().emailAddress(),
                    faker.phoneNumber().phoneNumber(),
                    faker.name().name(),
                    null
                    ));
        }
    }
}
