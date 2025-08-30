package com.jawwal.iws.jawwalIWS.controller;

import com.jawwal.iws.jawwalIWS.entities.Approval;
import com.jawwal.iws.jawwalIWS.entities.User;
import com.jawwal.iws.jawwalIWS.service.ApprovalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/approvals")
@RequiredArgsConstructor
public class ApprovalController {

    private final ApprovalService approvalService;

    @PostMapping("/{requestId}")
    public Approval approve(@PathVariable Long requestId,
                            @RequestParam String status,
                            @RequestParam String comments,
                            @RequestBody User approver) {
        return approvalService.approveRequest(requestId, approver, status, comments);
    }

    @GetMapping("/{requestId}")
    public List<Approval> getApprovals(@PathVariable Long requestId) {
        return approvalService.getApprovalsByRequest(requestId);
    }
}
