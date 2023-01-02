package com.dataorb.dataorb.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dataorb.dataorb.repository.DesignationsRepository;

@Service
public class DataOrbService { 

	@Autowired
	private DesignationsRepository designationsRepository;

	
	/**
	 * This method use to get total number of employees
	 * 
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> getAllEmployees() throws Exception {
		return designationsRepository.getAllEmployees();
	}
 

	/**
	 * This method use to get total employees joined details monthly
	 * 
	 * @return
	 */
	public List<Map<String, Object>> getmonthlyWiseJoinedEmployees(){
		return designationsRepository.monthlyWiseJoinedEmployees();
	}
 
	
	/**
	 * This method use to get total employees exit details monthly
	 * 
	 * @return
	 */
	public List<Map<String, Object>> getmonthlyWiseExitEmployees() {
		return designationsRepository.monthlyWiseExitEmployees(); 
	}

	
	/**
	 * This method use to get monthly salary Report
	 * 
	 * @return
	 */
	public List<Map<String, Object>> getmonthlySalaryReport() {
		return designationsRepository.monthlySalaryReport();
	}
 
	
	/**
	 * This method use to get employee wise Financial Report
	 * 
	 * @return
	 */
	public List<Map<String, Object>> getemployeeWiseFinancialReport()  {
		return designationsRepository.employeeWiseFinancialReport();
	}

	
	/**
	 * This method use to get monthly Amount Released
	 * 
	 * @return
	 */
	public List<Map<String, Object>> getmonthlyAmountReleased() {
		return designationsRepository.monthlyAmountReleased();
	}
	
	
	/**
	 * This method is use to get the financial report yearly wise
	 * @param month
	 * @return
	 */
	public List<Map<String, Object>> getfinancialReport(String month) {
		return designationsRepository.financialReport(month);
	}

}
