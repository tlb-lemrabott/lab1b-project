package org.example.service;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.NoArgsConstructor;
import org.example.entities.Employee;
import org.example.entities.PensionPlan;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@NoArgsConstructor
public class EmployeeManagementService {
    List<Employee> employees = new ArrayList<>();

    public void printEmployeesInJsonFormat(List<Employee> employees){
        List<Employee> sortedEmployees = sortEmployees(employees);
        String json = convertToJson(sortedEmployees);
        if (json != null) {
            System.out.println(json);
        }
    }

    public boolean hasPensionPlan(Employee employee){
        return employee.hasPensionPlan();
    }

    private List<Employee> sortEmployees(List<Employee> employees){
        employees.sort((e1, e2) -> {
            if (e1.getLastName().equals(e2.getLastName())) {
                return Double.compare(e2.getYearlySalary(), e1.getYearlySalary());
            }
            return e1.getLastName().compareTo(e2.getLastName());
        });
        return employees;
    }

    private String convertToJson(Object object) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        try{
            return mapper.writeValueAsString(object);
        }catch (Exception e) {
            System.err.println("Error converting to JSON: " + e.getMessage());
            return null;
        }
    }
}
