package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.EmployeeJpa;
import com.example.demo.models.enums.Charge;
import com.example.demo.models.enums.EmployeeState;
import com.example.demo.repository.EmployeeJpaRepository;

@Service
public class EmployeeInitializerService {
    private EmployeeJpaRepository repository;
    
    @Autowired
    public EmployeeInitializerService(EmployeeJpaRepository repository) {
        this.repository = repository;
    }
    
    public String deleteAllUsers() {
        repository.deleteAll(repository.findAll());

        return "Deleted all Employees" ;
    }
        public List<EmployeeJpa> createEmployees() {

        List<EmployeeJpa> employees = new ArrayList<>();
        employees.add(EmployeeJpa.builder()
            .name("Diego")
            .phoneNumber(2617558823L)
            .hourlySalary(2000D)
            .absences(0)
            .charge(Charge.DELIVERY)
            .state(EmployeeState.ACTIVO)
            .build()
            );
        employees.add(EmployeeJpa.builder()
            .name("Angel")
            .phoneNumber(2614899627L)
            .hourlySalary(2000D)
            .absences(0)
            .charge(Charge.DELIVERY)
            .state(EmployeeState.ACTIVO)
            .build()
            );
        employees.add(EmployeeJpa.builder()
            .name("Tobias")
            .phoneNumber(2615874431L)
            .hourlySalary(2000D)
            .absences(0)
            .charge(Charge.DELIVERY)
            .state(EmployeeState.ACTIVO)
            .build()
            );
        employees.add(EmployeeJpa.builder()
            .name("Damian")
            .phoneNumber(2614578912L)
            .hourlySalary(4000D)
            .absences(0)
            .charge(Charge.CHEF)
            .state(EmployeeState.ACTIVO)
            .build()
            );
        employees.add(EmployeeJpa.builder()
            .name("Roberto")
            .phoneNumber(2614226678L)
            .hourlySalary(6000D)
            .absences(0)
            .charge(Charge.MANAGER)
            .state(EmployeeState.ACTIVO)
            .build()
            );
        employees.add(EmployeeJpa.builder()
            .name("Ricardo")
            .phoneNumber(2613362959L)
            .hourlySalary(3500D)
            .absences(0)
            .charge(Charge.CAJERO)
            .state(EmployeeState.ACTIVO)
            .build()
            );
        return repository.saveAll(employees);

    }
}
