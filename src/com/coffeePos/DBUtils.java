package com.coffeePos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import javax.swing.text.TabExpander;

import org.h2.command.Prepared;

public class DBUtils 
{
	private static DBUtils dbUtils = null;
	private static Connection conn = null;
	private static final String JDBC_DRIVER = "org.h2.Driver";   
	private static final String DB_URL = "jdbc:h2:~/test";  
	
	private static final String USER = "sa"; 
	private static final String PASS = ""; 
	
	private DBUtils()
	{
		try {
			Class.forName ("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static DBUtils getInstance()
	{
		if(dbUtils==null)
		{
			dbUtils=new DBUtils();
		}
		return dbUtils;
	}
	
	
	public void tableExist(HashMap<String, Items> hashMap)
	{
		boolean tableExists = false;

		try {
			conn = DriverManager.getConnection ("jdbc:h2:~/test", "sa","");
			ResultSet rset = conn.getMetaData().getTables(null, null, "STOCKITEMS", null);
			if (rset.next())
			{
			  tableExists = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			}
		}
		if(!tableExists)
		{
			createTable();
			addItems(hashMap);
		}
	}
	
	private static void createTable()
	{
		
		 Statement stmt=null; 
		try {
		 conn = DriverManager.getConnection ("jdbc:h2:~/test", "sa","");	
		 stmt = conn.createStatement();
         String sql1 =  "CREATE TABLE StockItems " + 
            "(name VARCHAR(255) not NULL, " + 
            " price DOUBLE, " +
            " quantity INTEGER, "+
            " category VARCHAR(255), "+
            " PRIMARY KEY ( name ))";  
         
         String sql2 =  "CREATE TABLE   Sales " + 
                 "(name VARCHAR(255) not NULL, " + 
                 " price DOUBLE, " +
                 " quantity INTEGER, "+
                 " Amount double, "+
                 " salesDate DATE," +
                 " PRIMARY KEY ( name,salesDate ))"; 
         
         stmt.executeUpdate(sql1);
         stmt.executeUpdate(sql2);
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally
		{
			if(conn!=null) {
			if(stmt!=null)
			{
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			}
		}
		
         System.out.println("Created table in given database..."); 
	}
	
	public HashMap<String, Items> getStockItems() throws SQLException
	{
		HashMap<String, Items> hashMap = new HashMap<>();
		Statement st=null;
		try {
			conn = DriverManager.getConnection ("jdbc:h2:~/test", "sa","");
			st = conn.createStatement();
		
			String sql = "SELECT name, price, quantity,category FROM StockItems"; 
	        ResultSet rs = st.executeQuery(sql); 
	        
	        Items item = null;
	        while(rs.next()) { 
	            // Retrieve by column name 
	            String name  = rs.getString("name"); 
	            double price = rs.getDouble("price"); 
	            int quant = rs.getInt("quantity");  
	            String category = rs.getString("category");
	            
	            if(category.equals("Drinks"))
	            {
	            	item = new Drinks(name,price,quant);
	            }
	            if(category.equals("IceCreams"))
	            {
	            	item = new IceCreams(name,price,quant);
	            }
	            if(category.equals("Cakes"))
	            {
	            	item = new Cakes(name,price,quant);
	            }
	            hashMap.put(name, item);
	         } 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally
		{
			if(conn!=null) {
			if(st!=null)
			{
				st.close();
				
			}
			conn.close(); 
			}
		}
		return hashMap;
		
	}
	
	
	public HashMap<String, Sales> getSaleItems() 
	{
		HashMap<String, Sales> hashMap = new HashMap<>();
		Sales sale=null;
		Statement st=null;
		try {
			conn = DriverManager.getConnection ("jdbc:h2:~/test", "sa","");
			
			
			String sql = "SELECT name, price, quantity,amount,salesDate FROM Sales where salesDate>(sysdate-1)"; 
			st = conn.createStatement();
	        ResultSet rs = st.executeQuery(sql); 
	        
	        while(rs.next()) {
	        	System.out.println(rs.toString());
	            // Retrieve by column name 
	            String name  = rs.getString("name"); 
	            double price = rs.getDouble("price"); 
	            int quant = rs.getInt("quantity");  
	            double amount = rs.getDouble("amount");
	            Date salesDate = rs.getDate("salesDate");
	            
	            sale = new Sales(name,price,quant,salesDate,amount);
	            hashMap.put(name, sale);
	         } 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally
		{
			if(conn!=null) {
			if(st!=null)
			{
				try {
					st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			}
		}
		return hashMap;
		
	}
	
	public int updateQuant(HashMap<String, Items> hashMap)
	{
		PreparedStatement updateSt=null;
		//PreparedStatement insertSt=null;
		Items item = null;
		int row=0;
		
		String sql1= "Update StockItems set quantity=? where name=?"; 
		
		try {
			 conn = DriverManager.getConnection ("jdbc:h2:~/test", "sa","");
			if(hashMap!=null && ! hashMap.isEmpty())
			{
				for(String name : hashMap.keySet())
				{
					item = hashMap.get(name);
					if(item!=null)
					{
						System.out.println(item.toString());
						updateSt = conn.prepareStatement(sql1);
						updateSt.setInt(1, item.getQuantity());
						updateSt.setString(2, item.getName());
						int rows = updateSt.executeUpdate(); 
					}
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally
		{
			if(conn!=null) {
			if(updateSt!=null)
			{
				try {
					updateSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			}
		}
		return row;
	}
	
	public void insertSales(HashMap<String, Items> hashMap) 
	{
		PreparedStatement updateSt=null;
		PreparedStatement insertSt=null;
		Items item = null;
		
		//String sql1= "Update StockItems set quantity=? where name=?"; 
		String sql3 = "Update Sales set quantity=? , amount=? where name=? and salesdate>(sysdate-1)";
		//String sql3 = "delete from Sales";
		String sql2 = "INSERT INTO Sales " + "VALUES (?,?,?,?,sysdate)"; 
		
		HashMap<String, Sales> saleItem=this.getSaleItems();
		
		try {
			 conn = DriverManager.getConnection ("jdbc:h2:~/test", "sa","");
			if(hashMap!=null && ! hashMap.isEmpty())
			{
				for(String name : hashMap.keySet())
				{
					item = hashMap.get(name);
					if(item!=null)
					{
						
							if(saleItem.containsKey(item.getName()))
							{
								int quant=saleItem.get(item.getName()).getQuantity();
								updateSt=conn.prepareStatement(sql3); 
								updateSt.setInt(1,quant+item.getQuantity());
								updateSt.setDouble(2, (item.getPrice()*(quant+item.getQuantity())));
								updateSt.setString(3,item.getName());
								updateSt.executeUpdate(); 
								
							}
							else
							{
							insertSt = conn.prepareStatement(sql2);
							insertSt.setInt(3, item.getQuantity());
							insertSt.setString(1, item.getName());
							insertSt.setDouble(2, item.getPrice());
							insertSt.setDouble(4, (item.getPrice()*item.getQuantity()));
							int row = insertSt.executeUpdate(); 
							}
						}
						
					}
				}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally
		{
			if(conn!=null) {
			if(updateSt!=null)
			{
				try {
					updateSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			if(insertSt!=null)
			{
				try {
					insertSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			}
		}
	}

	public void addItems(HashMap<String, Items> hashMap) {
		
		PreparedStatement updateSt=null;
		PreparedStatement insertSt=null;
		Items item = null;
		String sql2 = "INSERT INTO StockItems " + "VALUES (?,?,?,?)"; 
		
		try {
			 conn = DriverManager.getConnection ("jdbc:h2:~/test", "sa","");
			if(hashMap!=null && ! hashMap.isEmpty())
			{
				for(String name : hashMap.keySet())
				{
					item = hashMap.get(name);
					if(item!=null)
					{
						insertSt = conn.prepareStatement(sql2);
						insertSt.setInt(3, item.getQuantity());
						insertSt.setString(1, item.getName());
						insertSt.setDouble(2, item.getPrice());
						insertSt.setString(4, item.getCategory());
						int row = insertSt.executeUpdate(); 
					}
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally
		{
			if(conn!=null) {
			if(updateSt!=null)
			{
				try {
					updateSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			if(insertSt!=null)
			{
				try {
					insertSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			}
		}
		
	}
	
}
