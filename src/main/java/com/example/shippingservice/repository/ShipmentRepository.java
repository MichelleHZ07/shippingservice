package com.example.shippingservice.repository;

import com.example.shippingservice.model.Shipment;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ShipmentRepository {

    private final Map<Long, Shipment> shipments = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(5000);

    public boolean existsById(Long id) {
        return shipments.containsKey(id);
    }

    public Shipment save(Shipment shipment){
        if (shipment.getId() == null){
            Long id = idGenerator.incrementAndGet();
            shipment.setId(id);
        }
        shipments.put(shipment.getId(),shipment);
        return shipment;
    }
    // Read
    public List<Shipment> findAll(){
        return new ArrayList<>(this.shipments.values());
    }

    public Shipment findById(Long id){
        return this.shipments.get(id);
    }

    //Delete
    public void deleteById(Long id){
        shipments.remove(id);
    }
}
