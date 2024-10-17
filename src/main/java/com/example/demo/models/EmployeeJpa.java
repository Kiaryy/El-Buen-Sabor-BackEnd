package com.example.demo.models;

import com.example.demo.models.enums.Charge;
import com.example.demo.models.enums.EmployeeState;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@DiscriminatorValue("E")
@EqualsAndHashCode(callSuper=true)
@AllArgsConstructor
@NoArgsConstructor

public class EmployeeJpa extends Person{
    private Double hourlySalary;
    private int absences;
    private Charge charge;
    private EmployeeState state;
    private String shift;
    @Builder
    public EmployeeJpa(String name, Long phoneNumber, Double hourlySalary, int absences, Charge charge,
            EmployeeState state, String shift) {
        super(name, phoneNumber);
        this.hourlySalary = hourlySalary;
        this.absences = absences;
        this.charge = charge;
        this.state = state;
        this.shift = shift;
    }
    
    
}
