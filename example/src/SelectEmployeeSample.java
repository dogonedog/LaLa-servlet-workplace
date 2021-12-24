import java.util.List;

import dao.EmployeeDAO;
import model.Employee;

public class SelectEmployeeSample {

	public static void main(String[] args) {
		
		EmployeeDAO empDAO = new EmployeeDAO();
		List<Employee> empList = empDAO.findAll();
		
		for (Employee emp : empList) {
	
		System.out.println("ID:" + emp.getId());
		System.out.println("名前:" + emp.getName());
		System.out.println("年齢:" + emp.getAge() + "\n");//空の１行を出力する  ここまでが１県目の処理　終わったら２件目の処理にいく　次がなくなったら(rs.next()) はfalse
		System.out.println();//"\n"と同じ意味
		
//		try (Connection conn = DriverManager.getConnection(
//				"jdbc:h2:tcp://localhost/~/example", "sa", "")) {
//			
//			//String sql = "SELECT * FROM employee";大文字はデータベースの命令文　ユーザーの設定は小文字
//			String sql = "SELECT ID,NAME,AGE FROM EMPLOYEE";
//			PreparedStatement pStmt = conn.prepareStatement(sql);//セットする　準備された命令　データベースへの接続情報持っているインスタンスconn
//			
//			ResultSet rs = pStmt.executeQuery();//受け皿　SQLが実行　実行結果がrsにセット
//			
//			while (rs.next()) {
//				String id = rs.getString("ID");
//				String name = rs.getString("NAME");
//				int age = rs.getInt("AGE");
//				
//
//			}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
		
		
		}

	}

}
