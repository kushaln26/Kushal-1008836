package service;

import domain.Employee;
import exception.EmployeeNotFoundException;
import exception.InsufficientTextException;
import exception.InvalidIdException;
import exception.InvalidInputException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeService implements  IEmployeeService{
    Map<Long, Employee> store = new HashMap<>();
    private long generatedId;

    private long generateId() {
        return (++generatedId)*10;
    }
    @Override
    public Employee register(String firstName, String lastName) throws InvalidInputException {
        validateName(firstName);
        validateName(lastName);
        long newId = generateId();
        Employee employee = new Employee(newId, firstName, lastName);
        store.put(newId, employee);
        return employee;
    }

    @Override
    public Employee findById(long id) throws InvalidIdException, EmployeeNotFoundException{
        validateId(id);

        Employee employee = store.get(id);
        if (employee == null) throw new EmployeeNotFoundException("Employee not found");
        return employee;
    }

    @Override
    public List<Employee> findEmployeesByFirstNameAscending(String firstName) throws EmployeeNotFoundException, InsufficientTextException {
        validateSearch(firstName);
        List<Employee> employeelist = new ArrayList<>();
        for(Employee employee: store.values()){
            if(employee.getFirstName().toLowerCase().startsWith(firstName.toLowerCase())){
                employeelist.add(employee);
            }
        }

        if (employeelist.isEmpty()) throw new EmployeeNotFoundException("No employee found");
        employeelist.sort(new IdKeyComparator());
        return employeelist;
    }


    public void validateName(String name) throws InvalidInputException {
        if (name == null || name.length() < 2 || name.length() > 10) {
            throw new InvalidInputException("invalid input");
        }
    }


    public void validateId(Long id) throws InvalidIdException{
        if (id < 1) throw new InvalidIdException("invalid id");

    }

    private void validateSearch(String firstName) throws InsufficientTextException {
        if (firstName.length() < 3) throw new InsufficientTextException("Insufficient text for search");
    }

    public void display(List<Employee> employees) {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

}
