package com.example.demo.service;

import com.example.demo.DTO.request.EmployeeRequestDTO;
import com.example.demo.models.EmployeeJpa;
import com.example.demo.repository.EmployeeJpaRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EmployeeService {
    
    //JPA repository
    @Autowired
    private EmployeeJpaRepository employeeJpaRepository;

    public EmployeeService(EmployeeJpaRepository employeeJpaRepository) {
        this.employeeJpaRepository = employeeJpaRepository;
    }


    public List<EmployeeJpa> getAllEmployees() {
        return employeeJpaRepository.findAll();
    }

        public EmployeeJpa findById(Long id){
        Optional<EmployeeJpa> entityOptional = employeeJpaRepository.findById(id);
        return entityOptional.get();
    }

    public String addEmployee(EmployeeRequestDTO employeeDTO) {

        EmployeeJpa employee = EmployeeJpa.builder()
                .name(employeeDTO.name())
                .phoneNumber(employeeDTO.phoneNumber())
                .hourlySalary(employeeDTO.hourlySalary())
                .absences(employeeDTO.absences())
                .charge(employeeDTO.charge())
                .state(employeeDTO.state())
                .shift(employeeDTO.charge().getShift())
                .build();


        // Here we save in dataBase
        employeeJpaRepository.save(employee);
        return "Employee added";
    }

    public EmployeeJpa update(Long id, EmployeeRequestDTO entity){
        Optional<EmployeeJpa> entityOptional = employeeJpaRepository.findById(id); 
        EmployeeJpa employee = entityOptional.get();
        // We convert the DTO entity to an object
        employee.setName(entity.name());
        employee.setPhoneNumber(entity.phoneNumber());
        employee.setHourlySalary(entity.hourlySalary());
        employee.setAbsences(entity.absences());
        employee.setCharge(entity.charge());
        employee.setShift(entity.charge().getShift());
        employee.setState(entity.state());
        // Saves updated entity to database
        
        return employeeJpaRepository.save(employee);
    }

    public boolean delete(Long id){
        if(employeeJpaRepository.existsById(id)){
            employeeJpaRepository.deleteById(id);
            return true;
        } else{
            return false;
        }
    }
}
