package com.example.shippingservice.service;

import com.example.shippingservice.exception.ShipmentNotFoundException;
import com.example.shippingservice.model.Shipment;
import com.example.shippingservice.repository.ShipmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class ShipmentService {
    private final ShipmentRepository shipmentRepository;
    public ShipmentService(ShipmentRepository shipmentRepository){
        this.shipmentRepository = shipmentRepository;
    }
    public List<Shipment> getAll() { return shipmentRepository.findAll(); }
    public Shipment getById(Long id) {
        Shipment s = shipmentRepository.findById(id);
        if (s == null) {
            throw new ShipmentNotFoundException(id);
        }
        return s;
    }
    public Shipment create(Shipment s) {
        s.setId(null);
        s.setStatus("CREATED");
        s.setCreatedAt(LocalDateTime.now());
        Shipment saved = shipmentRepository.save(s);
        log.info("Created shipment {} for order {}", saved.getId(), saved.getOrderId());
        return saved;
    }

    public Shipment update(Long id, Shipment s) {
        Shipment existing = shipmentRepository.findById(id);
        if (existing == null) {
            throw new ShipmentNotFoundException(id);
        }
        s.setId(id);
        s.setCreatedAt(existing.getCreatedAt());
        return shipmentRepository.save(s);
    }
    public void delete(Long id) {
        if (!shipmentRepository.existsById(id)) {
            throw new ShipmentNotFoundException(id);
        }
        shipmentRepository.deleteById(id);
    }
}
