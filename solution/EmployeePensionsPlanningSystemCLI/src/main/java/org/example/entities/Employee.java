package org.example.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;


@NoArgsConstructor
@Data
@ToString

public class Employee {
    private long employeeId;
    private String firstName;
    private String lastName;
    private LocalDate employmentDate;
    double yearlySalary;
    private PensionPlan pensionPlan;

    public Employee(long employeeId, String firstName, String lastName, LocalDate employmentDate, double yearlySalary) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.employmentDate = employmentDate;
        this.yearlySalary = yearlySalary;
    }

    public boolean hasPensionPlan() {
        LocalDate currentDate = LocalDate.now();
        LocalDate employmentPlus5Years = employmentDate.plusYears(5).plusDays(1);
        LocalDate employmentPlus5YearsAnd29Days = employmentDate.plusYears(5).plusDays(29);

        return currentDate.isAfter(employmentPlus5Years) && currentDate.isBefore(employmentPlus5YearsAnd29Days);
    }
}
