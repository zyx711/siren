package edu.hnzj.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
//	 public static final String JDBC_DRIVER="com.mysql.jdbc.Driver";
	public static final String JDBC_DRIVER="com.mysql.cj.jdbc.Driver";
//     public static final String DB_URL="jdbc:mysql://localhost:3306/school?serverTimezone=Asia/Shanghai";
	 public static final String DB_URL="jdbc:mysql://localhost:3306/exam?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai";
	 public static Connection getConnection() {
		 Connection conn=null;
		 try {
			Class.forName(JDBC_DRIVER);
			conn=DriverManager.getConnection(DB_URL,"root","root");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;		
	 }
	 public static ResultSet query(String sql) {
		 Connection conn=null;
		 Statement st=null;
		 ResultSet rs=null;
		 conn=getConnection();
		 try {
			st=conn.createStatement();
			rs=st.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//�����Դ
		}		 
		return rs;	 
		 
	 }
	 public static int update(String sql) {
		 Connection conn=null;
		 Statement st=null;
		 int result=0;
		 conn=getConnection();
		 try {
			st=conn.createStatement();
			result=st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//�����Դ
		}		 
		return result;
	 }
	 public static void main(String[] args) throws SQLException {
		String sql="select * from user";
		ResultSet rSet=DBUtil.query(sql);
		while(rSet.next()) {
			System.out.println(rSet.getString("name"));
		}
	}

}
