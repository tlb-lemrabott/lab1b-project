package org.example.utility;

import org.example.entities.Employee;
import org.example.entities.PensionPlan;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeesCreator {
    public static List<Employee> getEmployees(){
        List<Employee> employees = new ArrayList<>();
        Employee emp1 = new Employee(1, "Daniel", "Agar", LocalDate.of(2019, 03, 10), 105945.50);
        Employee emp2 = new Employee(2, "Benard", "Shaw", LocalDate.of(2016, 01, 19), 197750.00);
        Employee emp3 = new Employee(3, "Carly", "Agar", LocalDate.of(2019, 03, 8), 842000.75);
        Employee emp4 = new Employee(4, "Wesley", "Schneider", LocalDate.of(2022, 04, 13), 74500.00);

        emp1.setPensionPlan(new PensionPlan("EX1089", LocalDate.now(), 100.00));
        emp3.setPensionPlan(new PensionPlan("SM2307", LocalDate.now(), 1555.50));
        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);
        employees.add(emp4);
        return employees;
    }
}
