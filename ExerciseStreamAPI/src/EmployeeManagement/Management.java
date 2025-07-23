package EmployeeManagement;

import java.util.*;
import java.util.stream.Collectors;

public class Management {
    public static Map<String, Double> calculateTotalSalaryByDepartment(List<Employee> employees) {
        if (employees == null || employees.isEmpty()) return Collections.emptyMap();
        return employees.stream().collect(Collectors.groupingBy(
                employee -> employee.getDepartment(),
                Collectors.summingDouble(employee -> employee.getSalary())
        ));
    }

    public static Map<String, Optional<Employee>> findHighestSalaryEmployeeByDepartment(List<Employee> employees) {
        if (employees == null || employees.isEmpty()) return Collections.emptyMap();

        return employees.stream()
                .collect(Collectors.groupingBy(
                        employee -> employee.getDepartment(),
                        Collectors.maxBy(Comparator.comparing(employee -> employee.getSalary()))
                ));
    }

    public static List<Employee> findEmployeesWithSalaryGreaterThanAverage(List<Employee> employees) {
        if (employees == null || employees.isEmpty()) return Collections.emptyList();

        double averageSalary = employees.stream().mapToDouble(Employee::getSalary).average().getAsDouble();

        return employees.stream().filter(employee -> employee.getSalary() > averageSalary).toList();
    }

    public static List<Employee> getEmployeesData() {
        List<Employee> employees = new ArrayList<>();

        Employee lily = new Employee();
        lily.setId("E01");
        lily.setName("Lily");
        lily.setDepartment("HR");
        lily.setSalary(800);

        Employee james = new Employee();
        james.setId("E02");
        james.setName("James");
        james.setDepartment("HR");
        james.setSalary(950);

        Employee charlotte = new Employee();
        charlotte.setId("E03");
        charlotte.setName("Charlotte");
        charlotte.setDepartment("IT");
        charlotte.setSalary(1200);

        Employee alice = new Employee();
        alice.setId("E04");
        alice.setName("Alice");
        alice.setDepartment("IT");
        alice.setSalary(1300);

        Employee ava = new Employee();
        ava.setId("E05");
        ava.setName("Ava");
        ava.setDepartment("Sales");
        ava.setSalary(1100);

        employees.add(lily);
        employees.add(james);
        employees.add(charlotte);
        employees.add(alice);
        employees.add(ava);

        return employees;
    }

    public static void main(String[] args) {
        List<Employee> employees = getEmployeesData();

        System.out.println("All employees:");
        employees.forEach(System.out::println);

        System.out.println("\nTotal salary by department of employees:");
        Map<String, Double> salaryByDepartment = calculateTotalSalaryByDepartment(employees);
        salaryByDepartment.forEach((dept, total) ->
                System.out.println("Department: " + dept + ", Total Salary: " + total));

        System.out.println("\nEmployee with the highest salary by department:");
        Map<String, Optional<Employee>> highestEmployeeByDepartment = findHighestSalaryEmployeeByDepartment(employees);
        highestEmployeeByDepartment.forEach((department, optionalEmployee) -> {
            System.out.println("Department: " + department);
            optionalEmployee.ifPresent(employee -> System.out.println("Name: " + employee.getName() + ", Salary: " + employee.getSalary()));
        });

        System.out.println("Employees with above average salary:");
        List<Employee> employeesAboveAverageSalary= findEmployeesWithSalaryGreaterThanAverage(employees);
        employeesAboveAverageSalary.forEach(System.out::println);
    }
}
