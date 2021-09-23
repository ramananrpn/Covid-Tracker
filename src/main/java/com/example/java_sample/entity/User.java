package com.example.java_sample.entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.java_sample.constants.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = IDENTITY, generator = "native")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "pin_code", nullable = false)
    private int pinCode;

    @Column(name = "status", columnDefinition = "varchar(32) default 'negative'")
    @Enumerated(value = EnumType.ORDINAL)
    private Status status = Status.NEGATIVE;

    @Column(name = "is_admin", nullable = false)
    private boolean isAdmin = false;
}
