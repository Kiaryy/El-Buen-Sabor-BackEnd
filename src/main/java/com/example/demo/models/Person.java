package com.example.demo.models;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Discriminator")

@AllArgsConstructor
@NoArgsConstructor

@Table(name = "Person")
public class Person extends Base{
    protected String name;
    protected Long phoneNumber;
}
