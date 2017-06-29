/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comp.employee.DAOImpl;

import com.comp.employee.DAO.EmployeeSalaryDAO;
import com.comp.employee.entity.Salary;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Pradip Hamal
 */
public class EmployeeSalaryDAOImpl implements EmployeeSalaryDAO{
    
    private List<Salary> salaries = new ArrayList<>();
    private List<Date> dates = new ArrayList<>();
    private List<Integer> codes = new ArrayList<>();
    
    @Override
    public boolean insert(Salary salary) {
        return salaries.add(salary);
    }

    @Override
    public List<Salary> getAll() {
        return salaries;
    }

    @Override
    public Salary getByCode(int code) {
        for(Salary s: salaries) {
            if(s.getCode() == code) {
                return s;
            }
        }
        return null;
    }

    @Override
    public void addCode(int code, Date date) {
        codes.add(code);
        dates.add(date);
    }

    @Override
    public List<Date> getAllDates() {
        return dates;
    }

    @Override
    public List<Integer> getAllCodes() {
        return codes;
    }

    @Override
    public Date getDateByIndex(int index) {
        return dates.get(index);
    }

    
    
}
