/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comp.employee;

import com.comp.employee.Controller.EmployeesController;
import com.comp.employee.DAO.EmployeeDAO;
import java.util.Scanner;
import com.comp.employee.DAOImpl.EmployeeDAOImpl;
import com.comp.employee.DAOImpl.EmployeeSalaryDAOImpl;

/**
 *
 * @author Pradip Hamal
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        EmployeeDAOImpl edaoImpl = new EmployeeDAOImpl();
        EmployeeSalaryDAOImpl esd = new EmployeeSalaryDAOImpl();
        EmployeesController ec = new EmployeesController(input, edaoImpl, esd);
        while (true) {
            ec.process();
        }
    }
}
