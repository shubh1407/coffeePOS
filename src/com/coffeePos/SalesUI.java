package com.coffeePos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import java.awt.BorderLayout;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.GridLayout;
import java.sql.Date;
import java.util.HashMap;

import javax.swing.table.DefaultTableModel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SalesUI {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public void launchWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SalesUI window = new SalesUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SalesUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 650, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		table = new JTable();
		table.setEnabled(false);
		DefaultTableModel dm = new DefaultTableModel(0, 0);
		
		HashMap<String, Sales> hashMap = ItemUtils.getSalesItems();
		Sales sale = null;
		int i=0;
		dm.setColumnIdentifiers(new String[] {
				"Date of Sales","Name", "Price", "Quantity", "Amount"
			});
		table.setModel(dm);
		if(hashMap!=null && !hashMap.isEmpty())
		{
			for (String name : hashMap.keySet())
			{
				sale = hashMap.get(name);
				if(sale!=null)
				{
					dm.addRow(new Object[] {sale.getSalesDate(), sale.getName(), sale.getPrice(),
							sale.getQuantity(), sale.getAmount() });
				}
			}
		}
		JScrollPane sp=new JScrollPane(table);  
		frame.getContentPane().add(sp);          
		frame.setSize(542,505);    
		//frame.setVisible(true);  
		/*
		 * frame.getContentPane().setLayout(new BorderLayout(0, 0));
		 * frame.setBounds(600,600,1600,809);
		 * 
		 * JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		 * 
		 * JSplitPane sp1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		 * 
		 * JSplitPane sp2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		 * 
		 * JPanel panel = new JPanel(); panel.setBackground(Color.WHITE);
		 * sp.setResizeWeight(0.7); sp.setEnabled(false); sp.setDividerSize(0);
		 * 
		 * sp1.setResizeWeight(0.21); sp1.setEnabled(false); sp1.setDividerSize(0);
		 * 
		 * sp2.setResizeWeight(0.1); sp2.setEnabled(false); sp2.setDividerSize(0);
		 * 
		 * // frame.getContentPane().add(panel);
		 * 
		 * 
		 * table.setToolTipText("salesTable");
		 * 
		 * 
		 * 
		 * //frame.getContentPane().add(table);
		 * 
		 * JPanel panel_1 = new JPanel(); panel_1.setBackground(Color.WHITE);
		 * 
		 * JPanel panel_2 = new JPanel(); panel_2.setBackground(Color.WHITE); //
		 * frame.getContentPane().add(panel_1);
		 * 
		 * sp2.add(panel_2); panel_2.setLayout(null); sp2.add(table);
		 * 
		 * sp1.add(panel_1); panel_1.setLayout(null); sp1.add(sp2);
		 * 
		 * 
		 * 
		 * 
		 * sp.add(sp1); sp.add(panel); panel.setLayout(null);
		 */
		JPanel panel_1 = new JPanel(); 
		frame.getContentPane().add(panel_1, BorderLayout.SOUTH);
		panel_1.setBackground(Color.WHITE);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frame.setVisible(false); 
				frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE); 
				frame.dispose(); 
				MainUILayout jfrm2= new MainUILayout(); 
	            jfrm2.openMainUI();
			}
			
		});
		btnNewButton.setBounds(10, 357, 100, 23);
		panel_1.add(btnNewButton);
		
	}

}
