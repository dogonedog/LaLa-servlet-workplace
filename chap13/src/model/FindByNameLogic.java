package model;

import java.util.ArrayList;
import java.util.List;

import dao.EmployeeDAO;

public class FindByNameLogic {
	public List<Employee> execute(String name) {//Employeeのリストが返ってくる　検索して
		
		List<Employee> empList = new ArrayList<>();//空のリストを作る
		
		EmployeeDAO dao = new EmployeeDAO();
		empList = dao.findByName(name);
		
	return empList;
	}
}
