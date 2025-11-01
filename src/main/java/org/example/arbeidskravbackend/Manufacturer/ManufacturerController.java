package org.example.arbeidskravbackend.Manufacturer;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/manufacturer")
public class ManufacturerController {

    private final ManufacturerService manufacturerService;

    public ManufacturerController(ManufacturerService manufacturerService) {
        this.manufacturerService = manufacturerService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Manufacturer> getManufacturer(@PathVariable Long id) {
        var result = manufacturerService.getManufacturerById(id);
        if (result == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(result);
    }

    @GetMapping()
    public ResponseEntity<List<Manufacturer>> getAllManufacturers() {
        var result = manufacturerService.getAllManufacturers();
        if (result == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(result);
    }

    @PostMapping()
    public ResponseEntity<Manufacturer> addManufacturer(@RequestBody Manufacturer manufacturer) {
        var result = manufacturerService.addManufacturer(manufacturer);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteManufacturer(@PathVariable Long id) {
        manufacturerService.removeManufacturer(id);
        return ResponseEntity.ok("Manufacturer " + id + " has been removed.");
    }


}
