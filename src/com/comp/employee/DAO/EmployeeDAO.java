/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comp.employee.DAO;

import java.util.List;
import com.comp.employee.entity.Employee;

/**
 *
 * @author Pradip Hamal
 */
public interface EmployeeDAO {
    boolean insert(Employee employee);
    List<Employee> getAll();
    Employee searchByCode(int code);
    boolean deleteByCode(int code);
}
