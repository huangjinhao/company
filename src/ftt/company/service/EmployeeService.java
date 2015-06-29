package ftt.company.service;

import java.util.List;

import ftt.company.dao.EmployeeDao;
import ftt.company.domain.Employee;

public class EmployeeService {
	private EmployeeDao employeeDao;
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	public List<Employee> getAll(){
		return employeeDao.getAll();
	}
	
	public void delete(int id){
		employeeDao.delete(id);
	}
	
	public Employee getEmployeeById(Integer id){
		return employeeDao.getEmployeeById(id);
	}
}
