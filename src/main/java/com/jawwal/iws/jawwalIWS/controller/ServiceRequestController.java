package com.jawwal.iws.jawwalIWS.controller;

import com.jawwal.iws.jawwalIWS.entities.ServiceRequest;
import com.jawwal.iws.jawwalIWS.service.ServiceRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/requests")
@RequiredArgsConstructor
public class ServiceRequestController {

    private final ServiceRequestService serviceRequestService;

    @PostMapping
    public ServiceRequest create(@RequestBody ServiceRequest request) {
        return serviceRequestService.create(request);
    }

    @PutMapping("/{id}")
    public ServiceRequest update(@PathVariable Long id, @RequestBody ServiceRequest request) {
        return serviceRequestService.update(id, request);
    }

    @GetMapping
    public List<ServiceRequest> findAll() {
        return serviceRequestService.findAll();
    }

    @GetMapping("/{id}")
    public ServiceRequest findById(@PathVariable Long id) {
        return serviceRequestService.findById(id);
    }
}
