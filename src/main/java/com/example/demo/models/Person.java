package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Discriminator")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "Person")
public class Person extends Base{
    @Column(name = "name")
    protected String name;
    @Column(name = "phone_number")
    protected Long phoneNumber;
}
