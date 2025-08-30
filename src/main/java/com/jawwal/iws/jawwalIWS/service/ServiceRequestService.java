package com.jawwal.iws.jawwalIWS.service;

import com.jawwal.iws.jawwalIWS.entities.ServiceRequest;
import com.jawwal.iws.jawwalIWS.repository.ServiceRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceRequestService {

    private final ServiceRequestRepository serviceRequestRepository;

    public ServiceRequestService(ServiceRequestRepository serviceRequestRepository) {
        this.serviceRequestRepository = serviceRequestRepository;
    }


    public ServiceRequest create(ServiceRequest request) {
        return serviceRequestRepository.save(request);
    }

    public ServiceRequest update(Long id, ServiceRequest updated) {
        return serviceRequestRepository.findById(id).map(req -> {
            req.setClientName(updated.getClientName());
            req.setServiceType(updated.getServiceType());
            req.setBandwith(updated.getBandwith());
            req.setMarginPercentage(updated.getMarginPercentage());
            req.setJustification(updated.getJustification());
            req.setTotalPrice(updated.getTotalPrice());
            req.setProfit(updated.getProfit());
            req.setStatus(updated.getStatus());
            return serviceRequestRepository.save(req);
        }).orElseThrow(() -> new RuntimeException("Service Request not found"));
    }

    public List<ServiceRequest> findAll() {
        return serviceRequestRepository.findAll();
    }

    public ServiceRequest findById(Long id) {
        return serviceRequestRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Service Request not found"));
    }
}
