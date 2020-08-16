package com.coffeePos;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.print.PrinterException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class MainUILayout {

	private JFrame frame;
	
	ArrayList<Items> items = new ArrayList<>();
	JButton btnNewButton_1 = null;
	JFrame f = new JFrame();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ItemUtils.initialize();
					
					MainUILayout window = new MainUILayout();
					window.resetField();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void openMainUI()
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ItemUtils.initialize();
					
					MainUILayout window = new MainUILayout();
					window.resetField();
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
	public MainUILayout() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(1, 4, 3, 0));
		frame.setBounds(600,600,1600,809);
		frame.addWindowListener(new WindowAdapter() {
			public void windowActivated(WindowEvent event) {
				
			}
		});
		
		JTextArea textArea_1 = new JTextArea();
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(1, 4, 3, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Expresso");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 13));
		lblNewLabel.setBounds(20, 53, 115, 26);
		panel_1.add(lblNewLabel);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner.setToolTipText("Expresso");
		spinner.setBounds(206, 53, 124, 33);
		spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				
				if(!checkAvailability(spinner.getToolTipText(),100*Integer.parseInt(spinner.getValue().toString()))){
					
					 JOptionPane.showMessageDialog(f,"Product is not available","Alert",JOptionPane.WARNING_MESSAGE); 
					 spinner.setValue(Integer.parseInt(spinner.getValue().toString())-1);
				}
			}
		});
		
		panel_1.add(spinner);
		
		JLabel lblNewLabel_1 = new JLabel("Jasmine Tea");
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNewLabel_1.setBounds(20, 106, 115, 26);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Americano");
		lblNewLabel_1_1.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(20, 159, 115, 26);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Cappuccino");
		lblNewLabel_1_1_1.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNewLabel_1_1_1.setBounds(20, 212, 115, 26);
		panel_1.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("Hot Chocolate");
		lblNewLabel_2.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNewLabel_2.setBounds(20, 265, 115, 33);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Mocha");
		lblNewLabel_2_1.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNewLabel_2_1.setBounds(20, 319, 93, 26);
		panel_1.add(lblNewLabel_2_1);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner_1.setToolTipText("Jasmine Tea");
		spinner_1.setBounds(206, 106, 124, 33);
		spinner_1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				
				if(!checkAvailability(spinner_1.getToolTipText(),250*Integer.parseInt(spinner_1.getValue().toString()))){	
					 JOptionPane.showMessageDialog(f,"Product is not available","Alert",JOptionPane.WARNING_MESSAGE); 
					 spinner_1.setValue(Integer.parseInt(spinner_1.getValue().toString())-1);
				}
			}
		});
		
		panel_1.add(spinner_1);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner_2.setToolTipText("Americano");
		spinner_2.setBounds(206, 159, 124, 33);
		spinner_2.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				
				if(!checkAvailability(spinner_2.getToolTipText(),250*Integer.parseInt(spinner_2.getValue().toString()))){
					
					 JOptionPane.showMessageDialog(f,"Product is not available","Alert",JOptionPane.WARNING_MESSAGE); 
					 spinner_2.setValue(Integer.parseInt(spinner_2.getValue().toString())-1);
				}
			}
		});
		
		panel_1.add(spinner_2);
		
		JSpinner spinner_3 = new JSpinner();
		spinner_3.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner_3.setToolTipText("Cappuccino");
		spinner_3.setBounds(206, 212, 124, 33);
		spinner_3.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				
				if(!checkAvailability(spinner_3.getToolTipText(),250*Integer.parseInt(spinner_3.getValue().toString()))){
					
					 JOptionPane.showMessageDialog(f,"Product is not available","Alert",JOptionPane.WARNING_MESSAGE); 
					 spinner_3.setValue(Integer.parseInt(spinner_3.getValue().toString())-1);
				}
			}
		});
		
		panel_1.add(spinner_3);
		
		JSpinner spinner_4 = new JSpinner();
		spinner_4.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner_4.setToolTipText("Hot Chocolate");
		spinner_4.setBounds(206, 265, 124, 33);
		spinner_4.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				
				if(!checkAvailability(spinner_4.getToolTipText(),250*Integer.parseInt(spinner_4.getValue().toString()))){
					
					 JOptionPane.showMessageDialog(f,"Product is not available","Alert",JOptionPane.WARNING_MESSAGE); 
					 spinner_4.setValue(Integer.parseInt(spinner_4.getValue().toString())-1);
				}
			}
		});
		
		panel_1.add(spinner_4);
		
		JSpinner spinner_5 = new JSpinner();
		spinner_5.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner_5.setToolTipText("Mocha");
		spinner_5.setBounds(206, 318, 124, 37);
		spinner_5.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				
				if(!checkAvailability(spinner_5.getToolTipText(),250*Integer.parseInt(spinner_5.getValue().toString()))){
					
					 JOptionPane.showMessageDialog(f,"Product is not available","Alert",JOptionPane.WARNING_MESSAGE); 
					 spinner_5.setValue(Integer.parseInt(spinner_5.getValue().toString())-1);
				}
			}
		});
		
		panel_1.add(spinner_5);
		
		JLabel lblDrinks = new JLabel("DRINKS");
		lblDrinks.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblDrinks.setBounds(101, 11, 110, 31);
		panel_1.add(lblDrinks);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel.add(panel_1_1);
		
		JLabel lblNewLabel_3 = new JLabel("3-layer Cheese");
		lblNewLabel_3.setFont(new Font("Verdana", Font.BOLD, 13));
		lblNewLabel_3.setBounds(20, 53, 125, 19);
		panel_1_1.add(lblNewLabel_3);
		
		JSpinner spinner_6 = new JSpinner();
		spinner_6.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner_6.setToolTipText("3-layer Cheese");
		spinner_6.setBounds(206, 53, 124, 33);
		spinner_6.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				
				if(!checkAvailability(spinner_6.getToolTipText(),Integer.parseInt(spinner_6.getValue().toString()))){
					
					 JOptionPane.showMessageDialog(f,"Product is not available","Alert",JOptionPane.WARNING_MESSAGE); 
					 spinner_6.setValue(Integer.parseInt(spinner_6.getValue().toString())-1);
				}
			}
		});
		
		panel_1_1.add(spinner_6);
		
		JLabel lblNewLabel_1_2 = new JLabel("Chocolate Mousse");
		lblNewLabel_1_2.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNewLabel_1_2.setBounds(20, 106, 135, 14);
		panel_1_1.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("White Macadamia");
		lblNewLabel_1_1_2.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNewLabel_1_1_2.setBounds(20, 159, 125, 14);
		panel_1_1.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Signature Tiramisu");
		lblNewLabel_1_1_1_1.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNewLabel_1_1_1_1.setBounds(20, 212, 125, 14);
		panel_1_1.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Red Velvet");
		lblNewLabel_2_2.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNewLabel_2_2.setBounds(20, 265, 95, 14);
		panel_1_1.add(lblNewLabel_2_2);
		
		JSpinner spinner_1_1 = new JSpinner();
		spinner_1_1.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner_1_1.setToolTipText("Chocolate Mousse");
		spinner_1_1.setBounds(206, 106, 124, 33);
		spinner_1_1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				
				if(!checkAvailability(spinner_1_1.getToolTipText(),Integer.parseInt(spinner_1_1.getValue().toString()))){
					
					 JOptionPane.showMessageDialog(f,"Product is not available","Alert",JOptionPane.WARNING_MESSAGE); 
					 spinner_1_1.setValue(Integer.parseInt(spinner_1_1.getValue().toString())-1);
				}
			}
		});
		
		panel_1_1.add(spinner_1_1);
		
		JSpinner spinner_2_1 = new JSpinner();
		spinner_2_1.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner_2_1.setToolTipText("White Macadamia");
		spinner_2_1.setBounds(206, 159, 124, 33);
		spinner_2_1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				
				if(!checkAvailability(spinner_2_1.getToolTipText(),Integer.parseInt(spinner_2_1.getValue().toString()))){
					
					 JOptionPane.showMessageDialog(f,"Product is not available","Alert",JOptionPane.WARNING_MESSAGE); 
					 spinner_2_1.setValue(Integer.parseInt(spinner_2_1.getValue().toString())-1);
				}
			}
		});
		
		panel_1_1.add(spinner_2_1);
		
		JSpinner spinner_3_1 = new JSpinner();
		spinner_3_1.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner_3_1.setToolTipText("Signature Tiramisu");
		spinner_3_1.setBounds(206, 210, 124, 33);
		spinner_3_1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				
				if(!checkAvailability(spinner_3_1.getToolTipText(),Integer.parseInt(spinner_3_1.getValue().toString()))){
					
					 JOptionPane.showMessageDialog(f,"Product is not available","Alert",JOptionPane.WARNING_MESSAGE); 
					 spinner_3_1.setValue(Integer.parseInt(spinner_3_1.getValue().toString())-1);
				}
			}
		});
		
		panel_1_1.add(spinner_3_1);
		
		JSpinner spinner_4_1 = new JSpinner();
		spinner_4_1.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner_4_1.setToolTipText("Red Velvet");
		spinner_4_1.setBounds(206, 263, 124, 33);
		spinner_4_1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				
				if(!checkAvailability(spinner_4_1.getToolTipText(),Integer.parseInt(spinner_4_1.getValue().toString()))){
					
					 JOptionPane.showMessageDialog(f,"Product is not available","Alert",JOptionPane.WARNING_MESSAGE); 
					 spinner_4_1.setValue(Integer.parseInt(spinner_4_1.getValue().toString())-1);
				}
			}
		});
		
		panel_1_1.add(spinner_4_1);
		
		JLabel lblDrinks_1_1 = new JLabel("CAKES");
		lblDrinks_1_1.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblDrinks_1_1.setBounds(75, 11, 110, 31);
		panel_1_1.add(lblDrinks_1_1);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel.add(panel_1_2);
		
		JLabel lblNewLabel_4 = new JLabel("Strawberry");
		lblNewLabel_4.setFont(new Font("Verdana", Font.BOLD, 13));
		lblNewLabel_4.setBounds(20, 66, 95, 26);
		panel_1_2.add(lblNewLabel_4);
		
		JSpinner spinner_7 = new JSpinner();
		spinner_7.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner_7.setToolTipText("Strawberry");
		spinner_7.setBounds(206, 59, 124, 33);
		spinner_7.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				
				if(!checkAvailability(spinner_7.getToolTipText(),70*Integer.parseInt(spinner_7.getValue().toString()))){
					
					 JOptionPane.showMessageDialog(f,"Product is not available","Alert",JOptionPane.WARNING_MESSAGE); 
					 spinner_7.setValue(Integer.parseInt(spinner_7.getValue().toString())-1);
				}
			}
		});
		
		panel_1_2.add(spinner_7);
		
		JLabel lblNewLabel_1_3 = new JLabel("Chocolate");
		lblNewLabel_1_3.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNewLabel_1_3.setBounds(20, 113, 115, 25);
		panel_1_2.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Green Tea");
		lblNewLabel_1_1_3.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNewLabel_1_1_3.setBounds(20, 157, 95, 25);
		panel_1_2.add(lblNewLabel_1_1_3);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("Vanilla");
		lblNewLabel_1_1_1_2.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNewLabel_1_1_1_2.setBounds(20, 212, 95, 25);
		panel_1_2.add(lblNewLabel_1_1_1_2);
		
		JSpinner spinner_1_2 = new JSpinner();
		spinner_1_2.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner_1_2.setToolTipText("Chocolate");
		spinner_1_2.setBounds(206, 105, 124, 33);
		spinner_1_2.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				
				if(!checkAvailability(spinner_1_2.getToolTipText(),70*Integer.parseInt(spinner_1_2.getValue().toString()))){
					
					 JOptionPane.showMessageDialog(f,"Product is not available","Alert",JOptionPane.WARNING_MESSAGE); 
					 spinner_1_2.setValue(Integer.parseInt(spinner_1_1.getValue().toString())-1);
				}
			}
		});
		
		panel_1_2.add(spinner_1_2);
		
		JSpinner spinner_2_2 = new JSpinner();
		spinner_2_2.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner_2_2.setToolTipText("Green Tea");
		spinner_2_2.setBounds(206, 154, 124, 33);
		spinner_2_2.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				
				if(!checkAvailability(spinner_2_2.getToolTipText(),70*Integer.parseInt(spinner_2_2.getValue().toString()))){
					
					 JOptionPane.showMessageDialog(f,"Product is not available","Alert",JOptionPane.WARNING_MESSAGE);
					 spinner_2_2.setValue(Integer.parseInt(spinner_1_1.getValue().toString())-1);
				}
			}
		});
		
		panel_1_2.add(spinner_2_2);
		
		JSpinner spinner_3_2 = new JSpinner();
		spinner_3_2.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner_3_2.setToolTipText("Vanilla");
		spinner_3_2.setBounds(206, 209, 124, 33);
		spinner_3_2.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				
				if(!checkAvailability(spinner_3_2.getToolTipText(),70*Integer.parseInt(spinner_3_2.getValue().toString()))){
					
					 JOptionPane.showMessageDialog(f,"Product is not available","Alert",JOptionPane.WARNING_MESSAGE); 
					 spinner_3_2.setValue(Integer.parseInt(spinner_1_1.getValue().toString())-1);
				}
			}
		});
		
		panel_1_2.add(spinner_3_2);
		
		JLabel lblDrinks_1 = new JLabel("ICE-CREAM");
		lblDrinks_1.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblDrinks_1.setBounds(102, 11, 110, 31);
		panel_1_2.add(lblDrinks_1);
		
		btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.setBounds(66, 622, 196, 31);
		panel_1_2.add(btnNewButton_1);
		
		JTextArea textArea_1_1 = new JTextArea();
		textArea_1_1.setForeground(Color.WHITE);
		textArea_1_1.setBackground(Color.BLACK);
		textArea_1_1.setLineWrap(true);
		textArea_1_1.setFont(new Font("Arial", Font.BOLD, 16));
		textArea_1_1.setEnabled(false);
		textArea_1_1.setEditable(false);
		textArea_1_1.setBounds(0, 77, 330, 510);
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				textArea_1.setText("");
				spinner.setValue(0);
				spinner_1.setValue(0);
				spinner_1_1.setValue(0);
				spinner_1_2.setValue(0);
				spinner_2.setValue(0);
				spinner_2_1.setValue(0);
				spinner_2_2.setValue(0);
				spinner_3.setValue(0);
				spinner_3_1.setValue(0);
				spinner_3_2.setValue(0);
				spinner_4.setValue(0);
				spinner_4_1.setValue(0);
				spinner_5.setValue(0);
				spinner_6.setValue(0);
				spinner_7.setValue(0);
				textArea_1_1.setText("");
			}
		});
		btnNewButton_1.setFont(new Font("Arial Black", Font.BOLD, 18));
		
		JButton btnNewButton = new JButton("Sales Report");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false); 
				frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE); 
				frame.dispose(); 
				SalesUI jfrm2= new SalesUI(); 
	            jfrm2.launchWindow();
			}
		});
		btnNewButton.setFont(new Font("Arial Black", Font.BOLD, 18));
		btnNewButton.setBounds(10, 664, 320, 45);
		panel_1_2.add(btnNewButton);
		
		JButton btnAddItems = new JButton("ADD ITEMS");
		btnAddItems.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false); 
				frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE); 
				frame.dispose(); 
				AddItemsUI jfrm2= new AddItemsUI(); 
	            jfrm2.launchWindow();
				
			}
		});
		btnAddItems.setFont(new Font("Arial Black", Font.PLAIN, 18));
		btnAddItems.setBounds(71, 564, 176, 34);
		panel_1_2.add(btnAddItems);
		
		JPanel panel_1_2_1 = new JPanel();
		panel_1_2_1.setLayout(null);
		panel.add(panel_1_2_1);
		
		
		textArea_1.setFont(new Font("Arial Black", Font.BOLD, 16));
		textArea_1.setEnabled(false);
		textArea_1.setEditable(false);
		textArea_1.setBounds(101, 22, 132, 31);
		panel_1_2_1.add(textArea_1);
		
		JLabel lblNewLabel_5_1 = new JLabel("Total Bill");
		lblNewLabel_5_1.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblNewLabel_5_1.setBounds(10, 23, 81, 26);
		panel_1_2_1.add(lblNewLabel_5_1);
		
		JButton btnNewButton_1_1 = new JButton("Print");
		btnNewButton_1_1.setBounds(133, 664, 101, 31);
		panel_1_2_1.add(btnNewButton_1_1);
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					textArea_1_1.print();
					if(items!=null && items.size()>0)
					{
						for(Items item : items)
						{
							if(item instanceof Drinks)
							{
								
								if(spinner.getToolTipText().equals("Expresso"))
								{
									ItemUtils.insertIntoSales(item.getName(),-100*item.getQuantity());
								}
								else
								{
									ItemUtils.insertIntoSales(item.getName(),-250*item.getQuantity());
								}
							}
							if(item instanceof IceCreams)
							{
								ItemUtils.insertIntoSales(item.getName(),-70*item.getQuantity());
							}
							if(item instanceof Cakes)
							{
								ItemUtils.insertIntoSales(item.getName(),-item.getQuantity());
							}
							
						}
					}
					ItemUtils.insertSales();
					resetField();
					ItemUtils.getItemsList();
				} catch (PrinterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1_1.setFont(new Font("Arial Black", Font.BOLD, 18));
		
		textArea_1_1.setFont( new Font("monospaced", Font.PLAIN, 12) );
		panel_1_2_1.add(textArea_1_1);
		
		
		JButton btnNewButton_2 = new JButton("Generate Bill");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Integer totalAmount=0;
				items.clear();
				
				items.add(createItems(new Drinks(),spinner));
				
				items.add(createItems(new Drinks(),spinner_1));
				
				items.add(createItems(new Drinks(),spinner_2));
				
				items.add(createItems(new Drinks(),spinner_3));
			
				items.add(createItems(new Drinks(),spinner_4));
				
				items.add(createItems(new Drinks(),spinner_5));
				
				items.add(createItems(new Cakes(),spinner_6));
				
				items.add(createItems(new Cakes(),spinner_1_1));
				
				items.add(createItems(new Cakes(),spinner_2_1));
				
				items.add(createItems(new Cakes(),spinner_3_1));
				
				items.add(createItems(new Cakes(),spinner_4_1));
				
				items.add(createItems(new IceCreams(),spinner_7));
				
				items.add(createItems(new IceCreams(),spinner_1_2));
				
				items.add(createItems(new IceCreams(),spinner_2_2));
				
				items.add(createItems(new IceCreams(),spinner_3_2));
				
				totalAmount = ItemUtils.totalBills(items);
				
				textArea_1.setText(totalAmount.toString());
				
				textArea_1_1.setText("*********************************************\n");
				textArea_1_1.append("*                   POST BILL                *\n");
				textArea_1_1.append("**********************************************\n");
				textArea_1_1.append("Product                        Price    Amount\n");
										   
				
				for (Items item : items)
				{
					int count=0;
					if(item!=null) {
						count=26-item.getName().length();
						System.out.println(count);
						textArea_1_1.append(item.getName());
						for(int i=1;i<=count;i++)
						{
							textArea_1_1.append(" ");
						}
						textArea_1_1.append("      "+item.getPrice()+"    "+(item.getQuantity()*item.getPrice())+"\n");
					}
				}
				
				textArea_1_1.append("\n\n                               SubTotal :"+totalAmount+"\n");
				textArea_1_1.append("*********************************************\n");
				textArea_1_1.append("*                  Thanking You               *\n");
				textArea_1_1.append("**********************************************\n");
				
				/*strBuilder.append("Product                   Price  Amount\n");
				if(item.getName().equals("Expresso"))
					strBuilder.append("Expresso                   "+item+"  "++"  \n");
				if(item.getName().equals("Jasmine Tea"))
					strBuilder.append("Jasmine Tea                            \n");
				if(item.getName().equals("Americano"))
					strBuilder.append("Americano                              \n");
				if(item.getName().equals("Cappuccino"))
					strBuilder.append("Cappuccino                             \n");
				if(item.getName().equals("Hot Chocolate"))
					strBuilder.append("Hot Chocolate                          \n");
				if(item.getName().equals("Mocha"))
					strBuilder.append("Mocha                                  \n");
				if(item.getName().equals("3-layer Cheese"))
					strBuilder.append("3-layer Cheese                         \n");
				if(item.getName().equals("Chocolate Mousse"))
					strBuilder.append("Chocolate Mousse                       \n");
				if(item.getName().equals("White Macadamia"))
					strBuilder.append("White Macadamia                        \n");
				if(item.getName().equals("Signature Tiramisu"))
					strBuilder.append("Signature Tiramisu                     \n");
				if(item.getName().equals("Red Velvet"))
					strBuilder.append("Red Velvet                             \n");
				if(item.getName().equals("Strawberry"))
					strBuilder.append("Strawberry                             \n");
				if(item.getName().equals("Chocolate"))
					strBuilder.append("Chocolate                              \n");
				if(item.getName().equals("Green Tea"))
					strBuilder.append("Green Tea                              \n");
				if(item.getName().equals("Vanilla"))
					strBuilder.append("Vanilla                                \n");*/
				
				//textArea_1_1.setText(strBuilder.toString());
				
			}
		});
		btnNewButton_2.setFont(new Font("Arial Black", Font.BOLD, 18));
		btnNewButton_2.setBounds(69, 611, 219, 31);
		panel_1_2_1.add(btnNewButton_2);
		
		
		
		
	}
	
	private boolean checkAvailability(String toolTipText, int parseInt) {
		
		System.out.println("toolTipText");
		int available=ItemUtils.getAvailableQuant(toolTipText)-parseInt;
		
		System.out.println(available);
		if(available>=0)
			return true;
		return false;
	}



	private Items createItems(Items item,JSpinner spinner)
	{
		if(Integer.parseInt(spinner.getValue().toString())>0)
		{
			item.setName(spinner.getToolTipText());
			item.setQuantity(Integer.parseInt(spinner.getValue().toString()));
			item.setPrice(ItemUtils.getPrice(spinner.getToolTipText()));
			//item.setQuantity(quant);
			return item;
		}
		return null;
	}
	
	private void resetField() {
		
		btnNewButton_1.doClick();
	}
}
