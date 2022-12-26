package com.dataorb.dataorb.repository;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dataorb.dataorb.entity.DesignationsEntity;

@Repository 
@Transactional
public interface DesignationsRepository extends JpaRepository<DesignationsEntity, Integer> {

	/**
	 * This method use to get total number of employees
	 * 
	 * @return
	 * @throws Exception
	 */
	@Query(value = "select (count(distinct(EmpId))-(select count(distinct(EmpId)) from Events where EventTypeId =4)) as totalEmployees from Events", nativeQuery = true)
	public Map<String, Object> getAllEmployees() throws Exception;


	/**
	 * This method use to get all employees exit details monthly
	 * 
	 * @return
	 */
	@Query(value = "Select Emp.Id, Emp.EmpId, Emp.EmpFName, Emp.EmpLName, d.Designation From PPS.Employees Emp inner join PPS.Events Ev on Emp.Id = Ev.EmpId inner join PPS.Designations d on Emp.DesignationId = d.Id Where Ev.EventTypeId = 1", nativeQuery = true)
	public List<Map<String, Object>> monthlyWiseJoinedEmployees();
	
	
	/**
	 * This method use to get all employees exit details monthly
	 * 
	 * @return
	 */
	@Query(value = "Select Emp.Id, Emp.EmpId,Emp.EmpFName,Emp.EmpLName, d.Designation From PPS.Employees Emp inner join PPS.Events Ev on Emp.Id = Ev.EmpId inner join PPS.Designations d on Emp.DesignationId = d.Id Where Ev.EventTypeId = 4", nativeQuery = true)
	public List<Map<String, Object>> monthlyWiseExitEmployees();

	
	/**
	 * This method use to get monthly salary report
	 * 
	 * @return
	 */
	@Query(value = "Select Sum(A.Value) As Salary , Count(EmpId) As Count_Of_Employees, Mnth, Yr From (	Select Value,Ev.EmpId, Month(Ev.EventDate) As Mnth,Year(Ev.EventDate) as Yr From PPS.Employees Emp inner join PPS.Events Ev on Emp.Id = Ev.EmpId Where Ev.EventTypeId = 2) A Group By A.Yr, A.Mnth", nativeQuery = true)
	public List<Map<String, Object>> monthlySalaryReport();

	
	/**
	 * This method use to get employee wise Financial Report
	 * 
	 * @return
	 */
	@Query(value = "Select Emp.EmpId, Sum(Value) as Amount From PPS.Employees Emp inner join PPS.Events Ev on Emp.Id = Ev.EmpId	Where Ev.EventTypeId in (2,3,5)	Group by Emp.EmpId", nativeQuery = true)
	public List<Map<String, Object>> employeeWiseFinancialReport();

	
	/**
	 * This method use to get monthly Amount Released details
	 * 
	 * @return
	 */
	@Query(value = "Select Sum(A.Value) As Salary ,Mnth, Yr, Count(EmpId) as Number_Of_Employees From (	Select Value,Ev.EmpId, Month(Ev.EventDate) As Mnth,Year(Ev.EventDate) as Yr From PPS.Employees Emp inner join PPS.Events Ev on Emp.Id = Ev.EmpId Where Ev.EventTypeId = 2) A Group By A.Yr, A.Mnth", nativeQuery = true)
	public List<Map<String, Object>> monthlyAmountReleased();

	
	/**
	 * This method use to get financial report
	 * 
	 * @return
	 * @param month
	 */
	@Query(value = "select  e3.Event as event, e2.EmpId as empId, EventDate as eventDate,Value as value from Events e1 join Employees e2 on e2.id = e1.EmpId join EventType e3 on e1.EventTypeId=e3.id where Year(EventDate) = :month", nativeQuery = true)
	public List<Map<String, Object>> financialReport(String month);
}
