package com.jawwal.iws.jawwalIWS.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "service_request_paths")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServiceRequestPath {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String aEnd;
    private String bEnd;

    private Boolean isSubpath = false;

    @ManyToOne
    @JoinColumn(name = "service_request_id")
    private ServiceRequest serviceRequest;
}