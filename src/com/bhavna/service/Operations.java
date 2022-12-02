package com.bhavna.service;

import java.sql.Connection;

import com.bhavna.bean.Department;
import com.bhavna.bean.Employee;

import java.sql.*;


public class Operations {
	public static void insertEmpData(Employee emp) {
		try {
			Connection con=ConnecClass.createConnection();
			String query="insert into employee(emp_Id, emp_Name, joining_Date, dep_Id, salary) values(?,?,?,?,?)";
			
			PreparedStatement pstmnt=con.prepareStatement(query);
			
			pstmnt.setInt(1, emp.getEmpId());
			pstmnt.setString(2, emp.getEmpName());
			pstmnt.setDate(3, (Date) emp.getJoiningDate());
			pstmnt.setInt(4, emp.getDepId());
			pstmnt.setInt(5, emp.getSalary());
			
			pstmnt.executeUpdate();
			System.out.println("Data inserted successfully");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void insertDepData(Department dep) {
		try {
			Connection con=ConnecClass.createConnection();
			String query="insert into department(dep_ID, dep_Name, dep_Location) values(?,?,?)";
			
			PreparedStatement pstmnt=con.prepareStatement(query);
			
			pstmnt.setInt(1, dep.getDepId());
			pstmnt.setString(2, dep.getDepName());
			pstmnt.setString(3, dep.getDepLocation());
			
			pstmnt.executeUpdate();
			System.out.println("Data inserted successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void updateEmpData(Employee emp) {
		try {
			Connection con=ConnecClass.createConnection();
			String query="update employee set emp_Name=?, joining_Date=?, dep_Id=?, salary=? where emp_Id=?";
			
			PreparedStatement pstmnt=con.prepareStatement(query);
			
			
			pstmnt.setString(1, emp.getEmpName());
			pstmnt.setDate(2, (Date) emp.getJoiningDate());
			pstmnt.setInt(3, emp.getDepId());
			pstmnt.setInt(4, emp.getSalary());
			pstmnt.setInt(5, emp.getEmpId());
			
			pstmnt.execute();
			
			System.out.println("Employee data has been updated");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void fetchData() {
		try {
			Connection con=ConnecClass.createConnection();
			String query="select * from employee as e inner join department as d on e.dep_ID=d.dep_Id";
			
			PreparedStatement pstmnt=con.prepareStatement(query);
			
			ResultSet res=pstmnt.executeQuery(query);
			
			System.out.println("Employee_ID\tEmployee_Name\tJoining_Date\tDep_ID\tSalary\tDepartment_Name\t\tDep_Location");
			
			while(res.next()) {
				int eId=res.getInt("emp_Id");
				String name=res.getString("emp_Name");
				Date date=res.getDate("joining_Date");
				int dId=res.getInt("dep_ID");
				int salary=res.getInt("salary");
				String dName=res.getString("dep_Name");
				String dLoc=res.getString("dep_Location");
				
				System.out.format("%s%20s%21s%10s%10s%15s%20s\n", eId, name, date, dId, salary, dName, dLoc);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void countEmployeesAbove30K() {
		try {
			Connection con=ConnecClass.createConnection();
			
            Statement statement = con.createStatement();
            
            ResultSet resultSet = statement.executeQuery("select d.dep_Name, count(*) from department d inner join employee e on e.dep_ID=d.dep_ID where e.salary > 30000 group by d.dep_ID;");
            

            while(resultSet.next()) {
                System.out.println(resultSet.getString(1) + " " + resultSet.getInt(2));
            }

        } catch (Exception e) {
        	e.printStackTrace();
        }
	}

}
