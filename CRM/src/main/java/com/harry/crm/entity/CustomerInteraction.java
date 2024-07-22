package com.harry.crm.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Entity
@Data
@NoArgsConstructor
public class CustomerInteraction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String interactionType;

    @Column(nullable = false)
    private OffsetDateTime interactionDate;

    private String notes;

    @ManyToOne(optional = false)
    private Customer customer;

    // Add additional fields as needed
}
