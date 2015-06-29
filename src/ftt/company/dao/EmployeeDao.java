package ftt.company.dao;

import java.util.List;

import ftt.company.domain.Employee;

public class EmployeeDao extends BaseDao{
	public List<Employee> getAll(){
		String hql = "FROM Employee e LEFT OUTER JOIN FETCH e.department";
		return getSession().createQuery(hql).list();
	}
	
	public void delete(int id){
		String hql = "DELETE FROM Employee e WHERE e.id = ?";
		getSession().createQuery(hql).setInteger(0, id).executeUpdate();
	}
	
	public Employee getEmployeeById(Integer id){
		return (Employee) getSession().get(Employee.class, id);
	}
}
