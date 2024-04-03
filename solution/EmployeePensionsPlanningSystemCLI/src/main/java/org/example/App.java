package org.example;

import org.example.entities.Employee;
import org.example.service.EmployeeManagementService;
import org.example.utility.EmployeesCreator;


import java.util.List;

public class App {
    private static EmployeeManagementService cli = new EmployeeManagementService();


    public static void main( String[] args ) {
        List<Employee> employees = EmployeesCreator.getEmployees();
        System.out.println("Printing out the list of all the Employees in JSON format:");
        cli.printEmployeesInJsonFormat(employees);

        System.out.println("\nCheck employee with pension plan:");
        for(Employee employee : employees){
            System.out.println(cli.hasPensionPlan(employee));
        }

    }
}
