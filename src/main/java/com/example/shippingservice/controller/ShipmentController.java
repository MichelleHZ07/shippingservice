package com.example.shippingservice.controller;

import com.example.shippingservice.model.Shipment;
import com.example.shippingservice.service.ShipmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shipments")
public class ShipmentController {

    private final ShipmentService shipmentService;

    public ShipmentController(ShipmentService shipmentService) {
        this.shipmentService = shipmentService;
    }

    @GetMapping
    public List<Shipment> getAll() {
        return shipmentService.getAll();
    }

    @GetMapping("/{id}")
    public Shipment getOne(@PathVariable Long id) {
        return shipmentService.getById(id);
    }

    @PostMapping
    public Shipment create(@RequestBody Shipment s) {
        return shipmentService.create(s);
    }

    @PutMapping("/{id}")
    public Shipment update(@PathVariable Long id, @RequestBody Shipment s) {
        return shipmentService.update(id, s);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        shipmentService.delete(id);
    }
}
