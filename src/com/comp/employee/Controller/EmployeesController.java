/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comp.employee.Controller;

import com.comp.employee.DAO.EmployeeDAO;
import java.util.Scanner;
import com.comp.employee.entity.Employee;
import com.comp.employee.DAO.EmployeeSalaryDAO;
import com.comp.employee.entity.Salary;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Pradip Hamal
 */
public class EmployeesController {
    
    private Scanner input;
    private EmployeeDAO employeedao;
    private EmployeeSalaryDAO employeesalarydao;

    public EmployeesController(Scanner input, EmployeeDAO employeedao, EmployeeSalaryDAO employeesalarydao) {
        this.input = input;
        this.employeedao = employeedao;
        this.employeesalarydao = employeesalarydao;
    }
    
    public void menu() {
        System.out.println("\n\n");
        System.out.println("-----------Menu-------------");
        System.out.println("1. Employee Actions");
        System.out.println("2. Add Salary");
        System.out.println("3. Get Report");
        System.out.println("4. Exit");
        System.out.println("Enter your choice: [1-4]");
    }
    
    public void subMenu() {
        System.out.println("\n\n");
        System.out.println("1. Add Employee");
        System.out.println("2. Delete by code");
        System.out.println("3. Show all employess");
        System.out.println("4. Search by code");
        System.out.println("5. Go back");
        System.out.println("Enter your choice: [1-5]");
    }
    
    public void addEmployee() {
        Employee e = new Employee();
        Salary s = new Salary();
        System.out.println("\n\n");
        System.out.println("Enter first name of employee: ");
        e.setfName(input.next());
        System.out.println("Enter last name of employee: ");
        e.setlName(input.next());
        System.out.println("Enter employee code: ");
        e.setCode(input.nextInt());
        System.out.println("Enter salary of employee: ");
        s.setSalary(input.nextInt());
        s.setEmployee(e);
        employeesalarydao.insert(s);
        employeedao.insert(e);
    }
    
    public void fireEmployee() {
        System.out.println("\n\n");
        System.out.println("Enter code of employee record to delete: ");
        if(employeedao.deleteByCode(input.nextInt())) {
            System.out.println("Record deleted. ");
        } else {
            System.out.println("Record not found. ");
        }
    }
    
    public void allEmployees() {
        System.out.println("\n\n");
        for(Employee e: employeedao.getAll()) {
            System.out.println("First Name: " + e.getfName());
            System.out.println("Last Name: " + e.getlName());
            System.out.println("Code: " + e.getCode());
            for(Salary s: employeesalarydao.getAll()) {
                if(s.getEmployee() == e) {
                    System.out.println("Salary " + s.getSalary());
                }
            }
        }
    }
    
    public void searchCode() {
        System.out.println("\n\n");
        System.out.println("Enter code to search for employee: ");
        Employee e = employeedao.searchByCode(input.nextInt());
        if(e != null) {
            System.out.println("First Name: " + e.getfName());
            System.out.println("Last Name: " + e.getlName());
            System.out.println("Code: " + e.getCode());
            for(Salary s: employeesalarydao.getAll()) {
                if(s.getEmployee() == e) {
                    System.out.println("Salary " + s.getSalary());
                }
            }
        } else {
            System.out.println("Record not found. ");
        }
    }
    
    public void addSalary() {
        System.out.println("\n\n");
        System.out.println("Enter code to add salary for employee: ");
        int ch = input.nextInt();
        employeesalarydao.addCode(ch, new Date());
    }
    
    public void showRecord() {
        System.out.println("\n\n");
        for (int i = 0; i <= employeesalarydao.getAllDates().size(); i++) {
            System.out.println("Transaction " + (i + 1) + ": ");
            Salary as = employeesalarydao.getByCode(employeesalarydao.getAllCodes().get(i));
            System.out.println("First Name: " + as.getEmployee().getfName());
            System.out.println("Last Name: " + as.getEmployee().getlName());
            System.out.println("Code: " + as.getEmployee().getCode());
            System.out.println("Date: " + employeesalarydao.getDateByIndex(i));
        }
    }
    
    public void process() {
        menu();
        switch(input.nextInt()) {
            case 1:
                subMenu();
                switch(input.nextInt()) {
                    case 1:
                        addEmployee();
                        break;
                    case 2:
                        fireEmployee();
                        break;
                    case 3: 
                        allEmployees();
                        break;
                    case 4:
                        searchCode();
                        break;
                    case 5:
                        menu();
                        break;
                }
                break;
            case 2:
                addSalary();
                break;
            case 3:
                showRecord();
                break;
            case 4: 
                System.exit(0);
                break;
        }
    }
}
