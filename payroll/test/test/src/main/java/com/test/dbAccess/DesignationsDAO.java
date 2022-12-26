package com.test.dbAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DesignationsDAO extends BaseDataAccess {

    public long getDesignationId(String designation) throws Exception {
        Connection conn = null;
        PreparedStatement s = null;
        try {
            // System.out.println("getting designation for " + designation);
            conn = super.getConnection();
            String query = "SELECT * FROM PPS.Designations where Designation ='" + designation.trim() + "'";

            s = conn.prepareStatement(query);
            ResultSet rs = s.executeQuery();

            long designationId = -1;
            // System.out.println("number of rows" + rs.getRow());

            if (rs.next()) {
                System.out.println("Inside has next");
                designationId = rs.getLong("Id");
            }
            // System.out.println("getting designation for " + designation + " ==> " +
            // designationId);
            return designationId;

        } catch (Exception ex) {
            System.out.println(ex.toString());
            throw ex;
        } finally {
            s.close();
            conn.close();
        }
    }
}
