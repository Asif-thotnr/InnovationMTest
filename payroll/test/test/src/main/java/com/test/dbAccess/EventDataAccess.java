package com.test.dbAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.test.Entities.Event;

public class EventDataAccess extends BaseDataAccess {

    public void createEvent(Event event) throws Exception {

        String[] date = event.getEventDate().split("-");
        String eventDate = date[2] + "-" + date[1] + "-" + date[0];

        String query = "INSERT INTO Events (Sequence, EmpId, EventTypeId, Value, EventDate,Notes) Values ('"
                + event.getSeqId()
                + "'," + event.getEmpId() + "," + event.getEventType() + ",'"
                + event.getValue() + "','" + eventDate + "','" + event.getNotes() + "')";
        // System.out.println(query);

        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            conn = super.getConnection();
            // System.out.println("Creating Event");
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.executeUpdate();

        } catch (Exception ex) {
            System.out.println(ex.toString());
            throw ex;
        } finally {
            preparedStatement.close();
            conn.close();
        }
    }
}
