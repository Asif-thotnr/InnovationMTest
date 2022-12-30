package com.test;


import com.test.Entities.Employee;
import com.test.Entities.Event;

import junit.framework.Test;

import junit.framework.TestCase;
import junit.framework.TestSuite;
//import com.mysql.cj.exceptions.AssertionFailedException;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{	 
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
   
    /*
     *  @before annotation is not working 
     *  function called separately
     */
    @org.junit.Before
    public void setup() throws Exception{
	 System.out.println(" before called ");
	 //clear data from databases
    	new DBHelper().deleteData();
    }
    
    
    /**
     * @return this test cases is use to submit data from file
     */
    @org.junit.Test
    public void testSubmitData() throws Exception 
    {
    	setup();
    	new Options().importFile("C:\\Users\\Asif\\Desktop\\test_assignment\\payroll\\test\\Events.csv");
    	
    	// testing employee data
    	Employee empData =  new DBHelper().employeeData();

    	assertEquals("emp910", empData.getEmpId());
    	assertEquals("vikas", empData.getEmpFName());
    	assertEquals("sharma", empData.getEmpLName());
    	assertEquals(3, empData.getDesignationId());
    	
    	
    	//testing events data
    	Event eventData = new DBHelper().eventsData();
    	
    	assertEquals("1", eventData.getSeqId());
    	assertEquals(1, eventData.getEmpId());
    	assertEquals(1, eventData.getEventType());
    	assertEquals("10-8-2022", eventData.getValue());
    	assertEquals("2022-10-10", eventData.getEventDate());
    	assertEquals("vikas sharma is going to join SE", eventData.getNotes());
    	
    }
    
    @org.junit.Test(expected =java.sql.SQLIntegrityConstraintViolationException.class ) 
    public void testDoubleSubmit() throws Exception{
    	setup();
    	new Options().importFile("C:\\Users\\Asif\\Desktop\\test_assignment\\payroll\\test\\Events.csv");
    	try {
    		new Options().importFile("C:\\Users\\Asif\\Desktop\\test_assignment\\payroll\\test\\Events.csv");
    		
    		// expecting exception is not working hence work around
    		fail("expecting SQLIntegrityConstraintViolationException ");
		} catch (Exception e) {
			// TODO: handle exception
		}
    	
    }
 
   
}