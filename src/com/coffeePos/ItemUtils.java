package com.coffeePos;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class ItemUtils 
{
	private static HashMap<String, Items> itemList = new HashMap<>();
	private static HashMap<String, Items> salesItemList = new HashMap<>();
	private static DBUtils dbUtils=null;
	
	public static void initialize()
	{
		dbUtils = DBUtils.getInstance();
		
		
		
		itemList.put("Expresso",new Drinks("Expresso",11.00,1000));
		itemList.put("Jasmine Tea",new Drinks("Jasmine Tea",7.90,1000));
		itemList.put("Americano",new Drinks("Americano",9.00,1000));
		itemList.put("Cappuccino",new Drinks("Cappuccino",9.90,1000));
		itemList.put("Hot Chocolate",new Drinks("Hot Chocolate",8.50,1000));
		itemList.put("Mocha",new Drinks("Mocha",9.00,1000));
		itemList.put("3-Layer Cheese",new Cakes("3-layer Cheese",12.50,10));
		itemList.put("Chocolate Mousse",new Cakes("Chocolate Mousse",9.50,10));
		itemList.put("White Macadamia",new Cakes("White Macadamia",9.50,10));
		itemList.put("Signature Tiramisu",new Cakes("Signature Tiramisu",10.50,10));
		itemList.put("Red Velvet",new Cakes("Red Velvet",12.50,10));
		itemList.put("Strawberry",new IceCreams("Strawberry",9.00,1000));
		itemList.put("Chocolate",new IceCreams("Chocolate",9.00,1000));
		itemList.put("Green Tea",new IceCreams("Green Tea",9.00,1000));
		itemList.put("Vanilla",new IceCreams("Vanilla",9.00,1000));
		
		dbUtils.tableExist(itemList);
		
		try {
			itemList = dbUtils.getStockItems();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static int totalBills(ArrayList<Items> items)
	{
		int totalPrice = 0;
		
		if(items!=null && items.size()>0)
		{
			for(Items item : items)
			{
				if(item!=null) {
				System.out.println("Price "+item.getPrice()+" quant "+item.getQuantity());
				totalPrice+=item.getPrice()*item.getQuantity();
				}
			}
		}
		return totalPrice;
	}
	
	public static double getPrice(String name)
	{
		return itemList.get(name).getPrice();
	}
	
	
	public static void addQuant(String name, int addQuant)
	{
		Items item1=itemList.get(name);
		Items item = null;
		
		if(itemList.get(name).getCategory().equals("Drinks"))
		{
			item = new Drinks(name,item1.getPrice(),item1.getQuantity()+addQuant);
		}
		else if(itemList.get(name).getCategory().equals("Cakes"))
		{
			item = new Cakes(name,item1.getPrice(),item1.getQuantity()+addQuant);
		}
		else
		{
			item = new IceCreams(name,item1.getPrice(),item1.getQuantity()+addQuant);
		}
		salesItemList.put(name, item);
		dbUtils.updateQuant(salesItemList);
		salesItemList.clear();
	}
	
	public static void insertIntoSales(String name,int addQuant)
	{
		Items item1=itemList.get(name);
		Items item=null;
		addQuant(name,addQuant);
		
		if(salesItemList.get(name)!=null)
		{
			if(salesItemList.get(name).getCategory().equals("Drinks"))
			{
				salesItemList.get(name).setQuantity(-addQuant/100);
			}
			else if(salesItemList.get(name).getCategory().equals("Cakes"))
			{
				salesItemList.get(name).setQuantity(-addQuant);
			}
			else
			{
				salesItemList.get(name).setQuantity(-addQuant/70);
			}
		}
		else
		{
			if(itemList.get(name).getCategory().equals("Drinks"))
			{
				item = new Drinks(name,item1.getPrice(),item1.getQuantity());
				item.setQuantity(-addQuant/100);
			}
			else if(itemList.get(name).getCategory().equals("Cakes"))
			{
				item = new Cakes(name,item1.getPrice(),item1.getQuantity());
				item.setQuantity(-addQuant);
			}
			else
			{
				item = new IceCreams(name,item1.getPrice(),item1.getQuantity());
				item.setQuantity(-addQuant/70);
			}
			salesItemList.put(name, item);
		}
		
	}
	
	public static void insertSales()
	{
		dbUtils.insertSales(salesItemList);
	}
	
	public static int getAvailableQuant(String name)
	{
		System.out.println(itemList.get(name));
		return itemList.get(name).getQuantity();
	}
	
	public static HashMap<String,Sales> getSalesItems()
	{
		
	  HashMap<String,Sales> hashMap = dbUtils.getSaleItems(); 
	  return hashMap;
		
	}
	
	public static HashMap<String,Items> getItemsList()
	{
		return itemList;
	}
}
