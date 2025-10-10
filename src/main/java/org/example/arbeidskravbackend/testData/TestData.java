package org.example.arbeidskravbackend.testData;

import com.github.javafaker.Faker;
import org.example.arbeidskravbackend.Bicycle.Bicycle;
import org.example.arbeidskravbackend.Bicycle.BicycleRepo;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class TestData {

    private final BicycleRepo bicycleRepo;
    private final Faker faker = new Faker();

    public TestData(BicycleRepo bicycleRepo) {
        this.bicycleRepo = bicycleRepo;
    }

    public void createTestData() {
        for (int i = 0; i < 50; i++) {
            bicycleRepo.save(new Bicycle(
                    faker.name().name(),
                    faker.color().name(),
                    "Bike-01",
                    new Random().nextLong(20) + 1,
                    faker.name().name()));
        }

    }
}
