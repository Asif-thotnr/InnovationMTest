package com.dataorb.dataorb.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dataorb.dataorb.service.DataOrbService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/data/orb/")
public class DataOrbController {

	@Autowired
	private DataOrbService dataOrbService;

	
	/**
	 * This api is used to get total number of employees
	 * 
	 * @return
	 * @throws ResourceNotFoundException
	 * @throws Exception
	 */
	@GetMapping("/all/employees")
	public Map<String, Object> getAllEmployeesQuestion1() throws Exception {

		return dataOrbService.getAllEmployees();
	}


	/**
	 * This method is use to get total employees joined monthly wise
	 * 
	 * @return
	 * @throws ResourceNotFoundException
	 * @throws Exception
	 */
	@GetMapping("/all/employees/join")
	public  List<Map<String, Object>> empJoinedQuestion2a() throws Exception {

		return dataOrbService.getmonthlyWiseJoinedEmployees();
	}

 
	/**
	 * This method is use to get total employees exit monthly wise
	 * 
	 * @return
	 * @throws ResourceNotFoundException
	 * @throws Exception
	 */
	@GetMapping("/all/employees/exit")
	public List<Map<String, Object>> empExitQuestion2b() throws Exception {

		return dataOrbService.getmonthlyWiseExitEmployees();
	}

	/**
	 * This method is use to get monthly salary Report
	 * 
	 * @return
	 * @throws ResourceNotFoundException
	 * @throws Exception
	 */
	@GetMapping("/SalaryReport")
	public List<Map<String, Object>> getmonthlySalaryReportQuestion3() throws Exception {

		return dataOrbService.getmonthlySalaryReport();
	}


	/**
	 * This method is use to get employee wise Financial Report
	 * 
	 * @return
	 * @throws ResourceNotFoundException
	 * @throws Exception
	 */
	@GetMapping("/all/employeeReport")
	public List<Map<String, Object>> getEmpReportQuestion4() throws Exception {

		return dataOrbService.getemployeeWiseFinancialReport();
	}


	/**
	 * This method is use to get monthly Amount Released
	 * 
	 * @return
	 * @throws ResourceNotFoundException
	 * @throws Exception
	 */
	@GetMapping("/amountReleased")
	public List<Map<String, Object>> getmonthlyAmountQuestion5() throws Exception {

		return dataOrbService.getmonthlyAmountReleased();
	}


	/**
	 * This Api use to get the financial details on the basis of year
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/all/financial/{year}")
	public List<Map<String, Object>> getYearlyFinancialQuestion6(@PathVariable String year) throws Exception {

		return dataOrbService.getfinancialReport(year);
	}
	
}
