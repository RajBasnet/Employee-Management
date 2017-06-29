/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comp.employee.DAOImpl;

import com.comp.employee.DAO.EmployeeDAO;
import com.comp.employee.entity.Employee;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pradip Hamal
 */
public class EmployeeDAOImpl implements EmployeeDAO{
    private List<Employee> employees = new ArrayList<>();
    @Override
    public boolean insert(Employee employee) {
        return employees.add(employee);
    }

    @Override
    public List<Employee> getAll() {
        return employees;
    }

    @Override
    public Employee searchByCode(int code) {
        for(Employee e: employees) {
            if(e.getCode() == code) {
                return e;
            }
        }
        return null;
    }

    @Override
    public boolean deleteByCode(int code) {
        for(Employee e: employees) {
            if(e.getCode() == code) {
                employees.remove(e);
                return true;
            }
        }
        return false;
    }
    
}
