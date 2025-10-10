package org.example.arbeidskravbackend.Bicycle;


import org.example.arbeidskravbackend.testData.TestData;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bicycle")
public class BicycleController {

    private final BicycleService bicycleService;
    private final TestData testData;

    public BicycleController(BicycleService bicycleService, TestData testData) {
        this.bicycleService = bicycleService;
        this.testData = testData;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bicycle> getBicycle(@PathVariable Long id) {
        var result = bicycleService.getBicycleById(id);
        if (result == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(result);
    }

    @GetMapping()
    public ResponseEntity<List<Bicycle>> getAllBicycles() {
        var result = bicycleService.getAllBicycles();
        if (result == null) return ResponseEntity.notFound().build();
        return  ResponseEntity.ok(result);
    }

    @PostMapping()
    public ResponseEntity<Bicycle> addBicycle(@RequestBody Bicycle bicycle) {
        var result = bicycleService.addBicycle(bicycle);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {
        bicycleService.removeBicycle(id);
        return ResponseEntity.ok("Bicycle " + id + " has been removed");
    }

    @GetMapping("/init")
    public ResponseEntity<String> initTestData() {
        testData.createTestData();
        return ResponseEntity.ok("Books init");
    }

    @GetMapping("instock")
    public ResponseEntity<String> instock() {

    }
}
