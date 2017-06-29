/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comp.employee.DAO;

import com.comp.employee.entity.Salary;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Pradip Hamal
 */
public interface EmployeeSalaryDAO {
    boolean insert(Salary salary);
    List<Salary> getAll();
    Salary getByCode(int code);
    void addCode(int code, Date date);
    List<Date> getAllDates();
    List<Integer> getAllCodes();
    Date getDateByIndex(int index);
}
