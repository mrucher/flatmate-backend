package com.company.flatmate.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@Accessors(chain = true)
@Entity
@Table(name = "\"user\"")
public class User {

    @Column(name = "user_id")
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(name = "login", nullable = false)
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "firstname", nullable = false)
    private String firstname;

    @Column(name = "city")
    private String city;

    @Column(name = "email")
    private String email;

    @OneToMany(targetEntity = Renter.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "user_id"))
    private List<Renter> renters;

//    @Column(name = "renter_id")
//    private UUID renterId;

    @OneToMany(targetEntity = Landlord.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "user_id"))
    private List<Landlord> landlords;

//    @Column(name = "landlord_id")
//    private UUID landlordId;

    @Lob
    @Type(type = "org.hibernate.type.BinaryType")
    @Column(name = "photo", columnDefinition = "bytea")
    private byte[] photo;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

}