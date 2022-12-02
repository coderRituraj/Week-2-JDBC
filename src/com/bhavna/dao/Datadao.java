package com.bhavna.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import com.bhavna.bean.Department;
import com.bhavna.bean.Employee;
import com.bhavna.service.Operations;

public class Datadao {
	Scanner sc = new Scanner(System.in);

	public void takeEmpData() {
		try {
			System.out.print("Enter the employee id: ");
			int eId = sc.nextInt();
			System.out.print("Enter employee name: ");
			String eName = sc.next();
			System.out.print("Enter the joining date: ");
			String sDate = sc.next();
			java.util.Date date1=new SimpleDateFormat("yyyy-mm-dd").parse(sDate);
			java.sql.Date date = new java.sql.Date(date1.getTime());

			System.out.print("Enter the department id: ");
			int depId = sc.nextInt();
			System.out.print("Enter the salary: ");
			int sal = sc.nextInt();

			Operations.insertEmpData(new Employee(eId, eName, date, depId, sal));
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
	}
	public void takeDepData() {
			try {
				System.out.print("Enter the department id: ");
				int dId = sc.nextInt();
				System.out.print("Enter department name: ");
				String dName = sc.next();
				System.out.print("Enter the location: ");
				String location = sc.next();

				Operations.insertDepData(new Department(dId, dName, location));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public void updateEData() {
		try {
			System.out.print("Enter the employee id of the employee whose data needs to updated: ");
			int eId = sc.nextInt();
			System.out.print("Enter updated employee name: ");
			String eName = sc.next();
			System.out.print("Enter the joining date: ");
			String sDate = sc.next();
			java.util.Date date1=new SimpleDateFormat("yyyy-mm-dd").parse(sDate);
			java.sql.Date date = new java.sql.Date(date1.getTime());

			System.out.print("Enter the department id: ");
			int depId = sc.nextInt();
			System.out.print("Enter the salary: ");
			int sal = sc.nextInt();
			
			Operations.updateEmpData(new Employee(eId,eName,date,depId,sal));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
