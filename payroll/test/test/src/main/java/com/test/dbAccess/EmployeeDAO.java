package com.test.dbAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.test.Entities.Employee;

public class EmployeeDAO extends BaseDataAccess {

    private PreparedStatement preparedStatement;

    public long insertEmployee(Employee employee) throws Exception {
        String query = "Insert Into Employees (EmpId,EmpFName, EmpLName, DesignationId) Values ('" + employee.getEmpId()
                + "','" + employee.getEmpFName() + "','" + employee.getEmpLName() + "',"
                + employee.getDesignationId() + ")";

        String queryGetEmployeeId = "Select Id From Employees where EmpId = '" + employee.getEmpId() + "'";

        Connection conn = null;
        preparedStatement = null;
        try {
            conn = super.getConnection();
            System.out.println("Creating Employee");
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.executeUpdate();

            // next get emp id
            preparedStatement = conn.prepareStatement(queryGetEmployeeId);
            ResultSet rs = preparedStatement.executeQuery();

            long id = -1;

            if (rs.next()) {
                id = rs.getLong("Id");
            }

            return id;

        } catch (Exception ex) {
            System.out.println(ex.toString());
            throw ex;
        } finally {
            preparedStatement.close();
            conn.close();
        }
    }

    public long getSystemEmployeeId(String empNumber) throws Exception {

        String queryGetEmployeeId = "Select Id From Employees where EmpId = '" + empNumber + "'";

        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            conn = super.getConnection();

            // next get emp id
            preparedStatement = conn.prepareStatement(queryGetEmployeeId);
            ResultSet rs = preparedStatement.executeQuery();

            long id = -1;

            if (rs.next()) {
                id = rs.getLong("Id");
            }

            return id;

        } catch (Exception ex) {
            System.out.println(ex.toString());
            throw ex;
        } finally {
            preparedStatement.close();
            conn.close();
        }
    }
}