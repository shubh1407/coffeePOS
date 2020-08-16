package com.coffeePos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import java.awt.BorderLayout;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Label;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.table.DefaultTableModel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class AddItemsUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public void launchWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddItemsUI window = new AddItemsUI();
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
	public AddItemsUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 650, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		DefaultTableModel dm = new DefaultTableModel(0, 0);
		frame.setSize(542,505);    
		
		ArrayList<String> strList= new ArrayList<>();
		
		HashMap<String, Items> itemMap = ItemUtils.getItemsList();
		
		for(String name : itemMap.keySet())
		{
			strList.add(name);
		}
		
		String [] str= new String[strList.size()];
		
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
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel label = new JLabel("ml");
		label.setEnabled(false);
		label.setBounds(379, 123, 46, 14);
		panel.add(label);
		
		JComboBox comboBox = new JComboBox(strList.toArray(str));
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
				String name = comboBox.getSelectedItem().toString();
				if(itemMap.get(name).getCategory().equals("Drinks"))
				{
					label.setText("ml");
				}
				else if(itemMap.get(name).getCategory().equals("Cakes"))
				{
					label.setText("Pieces");
				}
				else
				{
					label.setText("Gms");
				}
			}
		});
		comboBox.setBounds(264, 76, 167, 20);
		panel.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Select Items");
		lblNewLabel.setBounds(115, 79, 81, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Quantity");
		lblNewLabel_1.setBounds(115, 123, 46, 14);
		panel.add(lblNewLabel_1);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner.setBounds(270, 120, 99, 20);
		panel.add(spinner);
		
		
		JButton btnNewButton_1 = new JButton("ADD");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String name = comboBox.getSelectedItem().toString();
				int addQuant = Integer.parseInt(spinner.getValue().toString());
				ItemUtils.addQuant(name, addQuant);
				ItemUtils.getItemsList();
			}
		});
		btnNewButton_1.setBounds(205, 193, 89, 23);
		panel.add(btnNewButton_1);
		
		
		
		
		
	}
}
