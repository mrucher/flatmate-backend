package com.company.flatmate.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name="renter")
public class Renter {

    @Column(name = "renter_id")
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(name = "max_price")
    private double maxPrice;

    @Column(name = "publication_date", columnDefinition = "timestamp with time zone")
    private OffsetDateTime publicationDate;

//    @OneToOne(targetEntity = User.class)
//    @JoinColumn(name = "renter_id", foreignKey = @ForeignKey(name = "renter_id"))
//    private User user;

    @Column(name = "user_id")
    private UUID userId;

    @Column(name = "is_active")
    private boolean active;

    @Column(name = "apartment_id")
    private UUID apartmentId;
}