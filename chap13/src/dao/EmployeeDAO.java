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
	private final String JDBC_URL =
			"jdbc:h2:tcp://localhost/~/example";
	private final String DB_USER ="sa";
	private final String DB_PASS ="";
	//生の数字とかは定数の形で外に出して置いたほうがいい　
	
	/**
	 * 全従業員のリストを返してくれる
	 * 	<Employee>
	 *  String id
	 *  String name
	 *  int age
	 *  <使い方>
	 *  EmployeeDAO dao = new EmployeeDAO();
	 *  List<Employee> emplist = dao.findAll();
	 * @param 引数なし
	 * @return List<Employee>
	 * @author "作者";
	 */
	public List<Employee> findAll(){
		List<Employee> empList = new ArrayList<>();//実態はArrayList　empListをリターンする
		
		try (Connection conn = DriverManager.getConnection(
				JDBC_URL, DB_USER, DB_PASS)) {
			
			//String sql = "SELECT * FROM employee";大文字はデータベースの命令文　ユーザーの設定は小文字			
			String sql = "SELECT ID,NAME,AGE FROM EMPLOYEE";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			ResultSet rs = pStmt.executeQuery();//受け皿　SQLが実行　実行結果がrsにセット
			//Employee employee; ここで宣言してはダメ　Employeeが上書きされる
			while (rs.next()) {
				String id = rs.getString("ID");
				String name = rs.getString("NAME");
				int age = rs.getInt("AGE");
				
				Employee employee = new Employee(id, name, age);
				empList.add(employee);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;//エラーがおこった時emplistの中をnullにする
		}
		
		
		return empList;//empListをリターンする
		
	}
	
	
	public  boolean create(Employee employee){
		try (Connection conn = DriverManager.getConnection(
				JDBC_URL, DB_USER, DB_PASS)) {
			
			String sql = "INSERT INTO Employee(ID, NAME, AGE) VALUES(?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(0, employee.getId());
			pStmt.setString(1, employee.getName());
			pStmt.setInt(2, employee.getAge());
			
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
