package service;

import domain.Employee;
import exception.EmployeeNotFoundException;
import exception.InsufficientTextException;
import exception.InvalidIdException;
import exception.InvalidInputException;

import java.util.List;

public interface IEmployeeService {
    Employee register(String firstName, String lastName) throws InvalidInputException;
    Employee findById(long id) throws InvalidIdException, EmployeeNotFoundException;
    List<Employee> findEmployeesByFirstNameAscending(String firstName) throws EmployeeNotFoundException, InsufficientTextException;
}



