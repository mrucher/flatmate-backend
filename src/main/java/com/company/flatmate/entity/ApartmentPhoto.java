package com.company.flatmate.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Arrays;
import java.util.UUID;

@Entity
@Table(name = "apartment_photo")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ApartmentPhoto {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "apartment_photo_id")
    private UUID id;

    @Column(name = "apartment_id")
    private UUID apartmentId;

    @Lob
    @Type(type="org.hibernate.type.BinaryType")
    @Column(name = "photo", columnDefinition = "bytea")
    private byte[] photo;

    @Override
    public String toString() {
        return "ApartmentPhoto{" +
                "id=" + id +
                ", apartmentId=" + apartmentId +
                ", photo=" + Arrays.toString(photo) +
                '}';
    }
}
