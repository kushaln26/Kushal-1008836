package service;

import domain.Employee;

import java.util.Comparator;

public class IdKeyComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee employee1, Employee employee2) {
        return (int)(employee1.getId()-employee2.getId());
    }
}
