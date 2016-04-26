package com.emp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class EmpUnitDao {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://192.168.101.105/EMPDB";


	static final String USER = "demo29";
	static final String PASS = "demo29";




	private Connection getConnection() {

		Connection conn = null; 

		try {
			Class.forName("com.mysql.jdbc.Driver");			
			conn = DriverManager.getConnection(DB_URL, USER, PASS);		 
			System.out.println("For Demo" + conn); 
		}
		catch(SQLException se){			
			se.printStackTrace();
		}catch(Exception e){			
			e.printStackTrace();
		}
		return conn; 
	}

	public Map<String,String> getAllEmployeeAndUnits() 
	{
		Statement stmt = null;
		ResultSet rs = null;
		Connection conn = null; 
		HashMap <String, String> empUnitMap = null;
		try {

			conn = getConnection(); 
			stmt = conn.createStatement(); 
			String sql = "SELECT empid,unit FROM EMPDB.EmployeeUnit";
			rs = stmt.executeQuery(sql);
			System.out.println("For Demo" + rs); 
			String empid = null;
			String unit = null; 
			empUnitMap = new HashMap <String, String>();
			while(rs.next()){
				empid = rs.getString("empid");
				unit = rs.getString("unit");
				empUnitMap.put(empid, unit);
			}


		} catch (SQLException e) {			
			e.printStackTrace();
		}catch (Exception e) {			
			e.printStackTrace();
		}
		finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return empUnitMap;       
	}


	public String getUnit(String empid) 
	{
		Statement stmt = null;
		ResultSet rs = null;
		Connection conn = null;		
		String unit = null; 

		try {

			conn = getConnection(); 
			stmt = conn.createStatement(); 
			String sql = "SELECT unit FROM EMPDB.EmployeeUnit where empid = '" + empid + "'"; 
			rs = stmt.executeQuery(sql);			
			while(rs.next()){								
				unit = rs.getString("unit");				
			}

		} catch (SQLException e) {			
			e.printStackTrace();
		}catch (Exception e) {			
			e.printStackTrace();
		}
		finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return unit;       
	}

	public int createEmpUnit(String empid,String unit) 
	{
		Statement stmt = null;		
		Connection conn = null;
		int rows = 0; 

		try {
			conn = getConnection(); 
			stmt = conn.createStatement(); 
			String sql = "insert into EMPDB.EmployeeUnit(empid,unit) values ('" + empid + "','" + unit + "')"; 
			rows = stmt.executeUpdate(sql);
		} catch (SQLException e) {			
			e.printStackTrace();
		}catch (Exception e) {			
			e.printStackTrace();
		}
		finally {			
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return rows; 		
	}


	public int updateEmpUnit(String empid,String unit) 
	{
		Statement stmt = null;		
		Connection conn = null;
		int rows = 0; 

		try {
			conn = getConnection(); 
			stmt = conn.createStatement(); 
			String sql = "update EMPDB.EmployeeUnit set unit = '" + unit + "' where empid = '" + empid + "'";  
			rows = stmt.executeUpdate(sql);
		} catch (SQLException e) {			
			e.printStackTrace();
		}catch (Exception e) {			
			e.printStackTrace();
		}
		finally {			
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return rows; 		
	}
	public int deleteEmpUnit(String empid) 
	{
		Statement stmt = null;		
		Connection conn = null;
		int rows = 0; 

		try {
			conn = getConnection(); 
			stmt = conn.createStatement(); 
			String sql = "delete from EMPDB.EmployeeUnit where empid = '" + empid +"'";
			rows = stmt.executeUpdate(sql);
		} catch (SQLException e) {			
			e.printStackTrace();
		}catch (Exception e) {			
			e.printStackTrace();
		}
		finally {			
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return rows; 		
	}
	
	 public static void main(String[] args) {
		 
		 EmpUnitDao empUnit = new EmpUnitDao(); 
		 
		 HashMap<String, String> map3 = (HashMap<String, String>) empUnit.getAllEmployeeAndUnits(); 
		
		 String s2 = empUnit.getUnit("sudhakar_r10");
				 int s3 = empUnit.createEmpUnit("demo1233", "eng");
				 int s4 = empUnit.updateEmpUnit("demo1233", "hrd");
				 int s9 = empUnit.deleteEmpUnit("demo1233"); 
				
				 
	 }
}     















