package ui;

import domain.Employee;
import exception.EmployeeNotFoundException;
import exception.InsufficientTextException;
import exception.InvalidIdException;
import exception.InvalidInputException;
import service.EmployeeService;
import service.IEmployeeService;

import java.util.List;

public class EmployeeDemo {
    EmployeeService employeeService = new EmployeeService();

    public static void main(String[] args) {
        EmployeeDemo demo = new EmployeeDemo();
        demo.runApp();
    }

    void runApp() {
        System.out.println("Register your employee:");
        registerAndDisplay("Kushal", "Gowda");
        registerAndDisplay("Santhosh", "Hebbar");
        registerAndDisplay("Sushma", "Nayak");
        registerAndDisplay("Anjali", "Choudary");

        System.out.println("-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/" );

        System.out.println("Find The Employee using  id:");
        findById(5);
        findById(20);
        findById(0);

        System.out.println("-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-");
        System.out.println("Employees by Id in Ascending");
        findEmployeeByFirstNameAscendingId("kush");
        findEmployeeByFirstNameAscendingId("su");

    }
    void registerAndDisplay(String firstName, String lastName) {
        try {
            Employee employee = employeeService.register(firstName, lastName);
            System.out.println(employee);
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
        }
    }

    void findEmployeeByFirstNameAscendingId(String search){
        try {
            List<Employee> list = employeeService.findEmployeesByFirstNameAscending(search);
            employeeService.display(list);

        } catch (EmployeeNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (InsufficientTextException e) {
            System.out.println(e.getMessage());
        }
    }

    void findById(Integer id){
        try{
            Employee employee = employeeService.findById(id);
            System.out.println(employee);
        } catch (EmployeeNotFoundException | InvalidIdException e) {
            System.out.println(e.getMessage());
        }
    }
}
