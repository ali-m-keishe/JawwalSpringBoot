package com.jawwal.iws.jawwalIWS.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "service_requests")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServiceRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String clientName;
    private String serviceType;
    private String bandwith;
    private BigDecimal marginPercentage;

    @Lob
    private String justification;
    private BigDecimal totalPrice;
    private BigDecimal profit;

    private String status = "Draft";

    @ManyToOne
    @JoinColumn(name = "created_by")
    private User createdBy;

    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();

    @OneToMany(mappedBy = "serviceRequest", cascade = CascadeType.ALL)
    private List<ServiceRequestPath> paths;

    @OneToMany(mappedBy = "serviceRequest", cascade = CascadeType.ALL)
    private List<ThirdPartyDetail> thirdPartyDetails;

    @OneToOne(mappedBy = "serviceRequest", cascade = CascadeType.ALL)
    private JawwalDetail jawwalDetail;

}
