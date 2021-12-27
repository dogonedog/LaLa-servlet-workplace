package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Employee;

public class EmployeeDAO {
	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/example";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";

	/**
	 * 全従業員のリストを返してくれる
	 *   <Employee>
	 *     String id
	 *     String name
	 *     int    age
	 * <使い方>
	 *   EmployeeDAO dao = new EmployeeDAO();
	 *   List<Employee> emplist = dao.findAll();
	 * @param なし。
	 * @return List<Employee>
	 * @author "Seiichi Nukayama"
	 */
	public List<Employee> findAll() {
		List<Employee> empList = new ArrayList<>();

		try (Connection conn = 
				DriverManager.getConnection
				(JDBC_URL, DB_USER, DB_PASS)) {

			String sql = "SELECT id, name, age FROM employee";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			ResultSet rs = pStmt.executeQuery();

			// Employee employee; <== ここで宣言してはダメ
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");

				Employee employee = new Employee(id, name, age);
				empList.add(employee);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		return empList;
	}
	
	public boolean create(Employee emp) {
		try (Connection conn = 
				DriverManager.getConnection
				(JDBC_URL, DB_USER, DB_PASS)) {

			String sql = "INSERT INTO employee (id, name, age) VALUES (?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, emp.getId());
			pStmt.setString(2, emp.getName());
			pStmt.setInt(3, emp.getAge());

			int result = pStmt.executeUpdate();

			if (result != 1) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
