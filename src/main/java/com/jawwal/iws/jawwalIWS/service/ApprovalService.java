package com.jawwal.iws.jawwalIWS.service;

import com.jawwal.iws.jawwalIWS.entities.Approval;
import com.jawwal.iws.jawwalIWS.entities.ServiceRequest;
import com.jawwal.iws.jawwalIWS.entities.User;
import com.jawwal.iws.jawwalIWS.repository.ApprovalRepository;
import com.jawwal.iws.jawwalIWS.repository.ServiceRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApprovalService {

    private final ApprovalRepository approvalRepository;
    private final ServiceRequestRepository serviceRequestRepository;

    public ApprovalService(ApprovalRepository approvalRepository, ServiceRequestRepository serviceRequestRepository) {
        this.approvalRepository = approvalRepository;
        this.serviceRequestRepository = serviceRequestRepository;
    }

    public Approval approveRequest(Long requestId, User approver, String status, String comments) {
        ServiceRequest req = serviceRequestRepository.findById(requestId)
                .orElseThrow(() -> new RuntimeException("Request not found"));

        Approval approval = Approval.builder()
                .serviceRequest(req)
                .approver(approver)
                .status(status)
                .comments(comments)
                .build();

        // Update request status also
        req.setStatus(status);
        serviceRequestRepository.save(req);

        return approvalRepository.save(approval);
    }

    public List<Approval> getApprovalsByRequest(Long requestId) {
        return approvalRepository.findAll()
                .stream()
                .filter(a -> a.getServiceRequest().getId().equals(requestId))
                .toList();
    }
}
