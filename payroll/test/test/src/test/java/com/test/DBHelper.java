package com.test;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.test.Entities.Employee;
import com.test.Entities.Event;
import com.test.dbAccess.BaseDataAccess;

public class DBHelper extends BaseDataAccess {

	// clear database
	public void deleteData() throws Exception {


        String query1 = "truncate pps.employees";
        String query2 = "truncate pps.events";

        Connection conn = null;
        PreparedStatement preparedStatement1 = null;
        PreparedStatement preparedStatement2 = null;
         
        try {
            conn = super.getConnection();
            preparedStatement1 = conn.prepareStatement(query1);
            preparedStatement1.executeUpdate();
            
            preparedStatement2 = conn.prepareStatement(query2);
            preparedStatement2.executeUpdate();

        } catch (Exception ex) {
            System.out.println(ex.toString());
            throw ex;
        } finally {
            preparedStatement1.close();
            preparedStatement2.close();
            conn.close();
        }
    }
	
	// return employee data
	public Employee employeeData() throws Exception {

		String query = "select * from pps.employees limit 1";
	    Connection conn = null;
	    PreparedStatement preparedStatement = null;
	    
	    try {
	        conn = super.getConnection();
	        preparedStatement = conn.prepareStatement(query);
	        ResultSet resultSet = preparedStatement.executeQuery();
	        Employee employee = new Employee();
	        
	        if(resultSet.next()) {
	        	employee.setEmpId(resultSet.getString("EmpId"));  
	        	employee.setEmpFName(resultSet.getString("EmpFName"));  
	        	employee.setEmpLName(resultSet.getString("EmpLName"));  
	        	employee.setDesignationId(resultSet.getLong("DesignationId"));  
	        }

	        return employee;
	        
	    } catch (Exception ex) {
	        System.out.println(ex.toString());
	        throw ex;
	    } finally {
	        preparedStatement.close();
	        conn.close();
	    }
	}
	
	
	// return event data
	public Event eventsData() throws Exception {

    String query = "select * from pps.events limit 1";
    Connection conn = null;
    PreparedStatement preparedStatement = null;
    
    try {
        conn = super.getConnection();
        preparedStatement = conn.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
       Event event = new Event();
        if(resultSet.next()) {
        	event.setSeqId(resultSet.getString("Sequence"));
        	event.setEmpId(resultSet.getLong("EmpId"));
        	event.setEventType(resultSet.getLong("EventTypeId"));
        	event.setValue(resultSet.getString("Value"));
        	event.setEventDate(resultSet.getString("EventDate"));
        	event.setNotes(resultSet.getString("Notes"));
        }

        return event;
    } catch (Exception ex) {
        System.out.println(ex.toString());
        throw ex;
    } finally {
        preparedStatement.close();
        conn.close();
    }
}
	
}
