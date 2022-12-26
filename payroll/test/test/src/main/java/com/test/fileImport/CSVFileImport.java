package com.test.fileImport;

import java.io.BufferedReader;
import java.io.FileReader;
import com.test.Entities.Employee;
import com.test.Entities.Event;
import com.test.dbAccess.DesignationsDAO;
import com.test.dbAccess.EmployeeDAO;
import com.test.dbAccess.EventDataAccess;

public class CSVFileImport implements IFileImport {

    private final String DELIMITER = ",";

    public void importFile(String filePath) throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = "";
            //Scan file line by line
            while ((line = br.readLine()) != null) {
                System.out.println("Importing Line ===> " + line);

                //Store all values seperated by commas
                String[] lineItems = line.split(DELIMITER);

                // New employee onboard insert into employees table and events table
                if (line.contains("ONBOARD")) {
                    this.processOnboardEvent(lineItems);
                } else {
                    // Employee already exist all we have to insert into events table
                    this.processOtherEvent(lineItems);
                }
            }
        }
    }

// Already given events are 5 types 1 is ONBOARD which is seperately handled
    private long getEventType(String eventType) {
        if (eventType.equals("SALARY")) {
            return 2;
        }

        if (eventType.equals("BONUS")) {
            return 3;
        }

        if (eventType.equals("EXIT")) {
            return 4;
        }

        if (eventType.equals("REIMBURSEMENT")) {
            return 5;
        }
        return -1;
    }

    // Events "SALARY", "BONUS", "EXIT" and "REIMBURSEMENT" handled by this method
    private void processOtherEvent(String[] lineItems) throws Exception {
        // find id of emplyee based on EmpId
        String empId = lineItems[1];
        long empSystemId = new EmployeeDAO().getSystemEmployeeId(empId.trim());

        // make an event entity
        Event event = new Event();
        event.setEmpId(empSystemId);
        event.setEventType(this.getEventType(lineItems[2].trim()));
        event.setSeqId(lineItems[0]);
        event.setValue(lineItems[3].trim());
        event.setEventDate(lineItems[4].trim());
        event.setNotes(lineItems[5].trim());
        // insert into event 
        System.out.println("Going to create a non Onboarding Event");
        new EventDataAccess().createEvent(event);
    }

    // Event "ONBOARD" is handled by this method
    private void processOnboardEvent(String[] lineItems) throws Exception {
        System.out.println("Processing Onboarding Event");

        DesignationsDAO designationDAO = new DesignationsDAO();
        // Get the fields for Employee
        // make an emplyee entity
        Employee emp = new Employee();
        emp.setEmpId(lineItems[1].trim());
        emp.setEmpFName(lineItems[2].trim());
        emp.setEmpLName(lineItems[3].trim());
        long designationId = designationDAO.getDesignationId(lineItems[4]);
        emp.setDesignation(lineItems[4].trim());
        emp.setDesignationId(designationId);
        // Insert into employee
        long id = new EmployeeDAO().insertEmployee(emp);
        // Find the id of the employee
        emp.setId(id);
        // System.out.println("Importing Employee --> " + emp.toString());

        // Create Event Entity
        Event event = new Event();
        event.setEmpId(id);
        event.setSeqId(lineItems[0].trim());
        event.setEventType(1);
        event.setValue(lineItems[6].trim());
        event.setEventDate(lineItems[7].trim());
        event.setNotes(lineItems[8].trim());
        // insert into event
        new EventDataAccess().createEvent(event);
    }

}
