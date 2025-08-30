package com.jawwal.iws.jawwalIWS.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "third_party_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ThirdPartyDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String thirdPartyName;
    private BigDecimal cost;
    private String notes;

    @ManyToOne
    @JoinColumn(name = "service_request_id")
    private ServiceRequest serviceRequest;
}