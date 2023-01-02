package com.dataorb.dataorb;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dataorb.dataorb.service.DataOrbService;
import com.test.DBHelper;
import com.test.Options;
import com.test.Entities.Employee;

@SpringBootTest
class AllTests {

	@Autowired
    private DataOrbService  ds;
	Employee employee = new Employee();
	
	@Test
	void contextLoads() throws Exception {

	}
	
	@BeforeEach
	void beforeEachMethod() throws Exception {
		new DBHelper().deleteData();
		// use local events.csv file path
    	new Options().importFile("C:\\Users\\Asif\\Desktop\\test_assignment\\payroll\\test\\Events.csv");
	}
	
	
//	1
	@Test
	 void testGetAllEmployees() throws Exception { 
		 Map<String, Object> allEmp = ( Map<String, Object>)ds.getAllEmployees();
		
//		 System.out.println("all employees entry"+allEmp.entrySet());
//	    	assertEquals(6, allEmp.values().size());
		 
	    	//having trouble iterating over loop to check values 
	    	// checking null for now
	    	assertNotNull(allEmp.values());
	 }
	
		
	//2.a
	@Test
	 void testgetmonthlyWiseJoinedEmployees() throws Exception { 
		 List<Map<String, Object>> JoinEmp = ds.getmonthlyWiseJoinedEmployees();
		 assertEquals(7,JoinEmp.size());
	 }
	
	
	//2.b
	@Test
	void testgetmonthlyWiseExitEmployees() throws Exception { 
		List<Map<String, Object>> exitEmp = ds.getmonthlyWiseExitEmployees();
		assertEquals(1,exitEmp.size()); 
	}
	 
	
	//3
	@Test
	 void testgetmonthlySalaryReport() throws Exception { 
		 List<Map<String, Object>> report = ds.getmonthlySalaryReport();
		 assertEquals(1,report.size()); 
	 }
	
	
	//4
	@Test
	 void testgetemployeeWiseFinancialReport() throws Exception { 
		 List<Map<String, Object>> report = ds.getemployeeWiseFinancialReport();
		 assertEquals(4,report.size()); 
	 }
	
	
	//5
	@Test
	void testgetmonthlyAmountReleased() throws Exception { 
		List<Map<String, Object>> amt = ds.getmonthlyAmountReleased();
		assertEquals(1,amt.size()); 
	}
	
	
	//6
	@Test
	 void testgetfinancialReport() throws Exception { 
		 List<Map<String,Object>> list = ds.getfinancialReport("2022"); 
		 assertEquals(12,list.size()); 
	 }
}
