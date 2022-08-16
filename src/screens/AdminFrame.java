package screens;
import java.util.ArrayList;
import java.awt.*;

import ClassFiles.*;
import FilesClass.DataFile;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;
import javax.swing.event.*;
import javax.swing.*;
import java.awt.event.*;

public class AdminFrame extends JFrame implements ActionListener ,ListSelectionListener{

	private JPanel contentPane;
	private JTextField name;
	private JTextField username;
	private JTextField phone;
	private JTextField password;
	private JTextField address;
	private JTextField txtAmount;
	private JTextField txtFieldPrice;
	private JTextField txtFoodName;
	private JTextField txtaddName;
	private JTextField txtaddPrice;
	private JTextField txtaddAmount;
	private ArrayList<Food> foods;
	private JButton submitBtn;
	ArrayList<Customer>users;
	private JList<String> list_1;
	private JList<String> list;
	DataFile dt=  DataFile.getInstance();
	private DefaultListModel<String> foodModel;
	private ArrayList<Complaint> compList=DataFile.getInstance().complaintList;
	private JTextField txtfield;
	private JTextField txtfield2;
	private JTextArea textArea;
	private JButton deleteFoodbtn;
	private JButton updateFoodbtn;
	private JButton updatebtn ;
	private JButton deletebtn;
	private JButton restrictbtn;
	private JButton deleteOrder;
	JList<String> complaintList ;
	private JTextField orderBy;
	private JTextField orderDate;
	private JTextField pricefield;

	private ArrayList<Order> orders=DataFile.getInstance().orderList;
	private DefaultListModel<String> orderModel =new DefaultListModel<String>();
	private JList<String> orderList_1=new JList<String>(orderModel);
	DefaultListModel<String>foodOrderedModel=new DefaultListModel<String>();
	JList<String> orderedFoods=new JList<String>(foodOrderedModel);
	DefaultListModel<String> usermodel;
	

	
	public AdminFrame() {
		orderList_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		orderList_1.addListSelectionListener(this);
		for(int i=0;i<orders.size();i++) {
			orderModel.addElement("Order by @"+orders.get(i).getWhoOrdered().getUsername());
		}
		foods=dt.foodList;
		users=dt.customerCollection;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 150, 900, 645);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 967, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 602, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Users", null, panel, null);
		panel.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 108, 191, 489);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		name = new JTextField();
		name.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		name.setBounds(77, 34, 114, 26);
		panel_4.add(name);
		name.setColumns(10);
		
		username = new JTextField();
		username.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		username.setColumns(10);
		username.setBounds(77, 71, 114, 26);
		panel_4.add(username);
		
		phone = new JTextField();
		phone.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		phone.setColumns(10);
		phone.setBounds(77, 108, 114, 26);
		panel_4.add(phone);
		
		password = new JTextField();
		password.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		password.setColumns(10);
		password.setBounds(77, 145, 114, 26);
		panel_4.add(password);
		
		address = new JTextField();
		address.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		address.setColumns(10);
		address.setBounds(77, 182, 114, 26);
		panel_4.add(address);
		
		updatebtn= new JButton("Update");
		updatebtn.setEnabled(false);
		updatebtn.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		updatebtn.setBounds(10, 287, 124, 23);
		panel_4.add(updatebtn);
		
		restrictbtn = new JButton("Restrict Account");
		restrictbtn.setEnabled(false);
		restrictbtn.addActionListener(this);
		restrictbtn.setBounds(10, 253, 124, 23);
		panel_4.add(restrictbtn);
		
		JLabel lblNewLabel_2 = new JLabel("FullName");
		lblNewLabel_2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 34, 66, 26);
		panel_4.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Username");
		lblNewLabel_3.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(11, 71, 65, 23);
		panel_4.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Phone");
		lblNewLabel_4.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(10, 108, 65, 26);
		panel_4.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Password");
		lblNewLabel_5.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(10, 145, 66, 26);
		panel_4.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Address");
		lblNewLabel_6.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(10, 182, 66, 26);
		panel_4.add(lblNewLabel_6);
		
		deletebtn = new JButton("Delete");
		deletebtn.addActionListener(this);
		deletebtn.setEnabled(false);
		deletebtn.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		deletebtn.setBounds(10, 321, 124, 23);
		panel_4.add(deletebtn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(191, 68, 397, 529);
		panel.add(scrollPane);
		usermodel= new DefaultListModel<String>();
		for(int i=0;i<users.size();i++){
			usermodel.addElement(users.get(i).getUsername());
		}
		list = new JList<String>(usermodel);
		list.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		list.addListSelectionListener(this);
		scrollPane.setViewportView(list);
		
		JLabel lblNewLabel = new JLabel("Users");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		lblNewLabel.setBounds(0, 11, 688, 46);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("User detail");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 70, 184, 32);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Foods", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblFoods = new JLabel("Foods");
		lblFoods.setHorizontalAlignment(SwingConstants.CENTER);
		lblFoods.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		lblFoods.setBounds(0, 11, 688, 46);
		panel_1.add(lblFoods);
		
		JLabel detail = new JLabel("Food detail");
		detail.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		detail.setHorizontalAlignment(SwingConstants.CENTER);
		detail.setBounds(0, 70, 184, 32);
		panel_1.add(detail);
		
		JPanel panel_4_1 = new JPanel();
		panel_4_1.setLayout(null);
		panel_4_1.setBounds(0, 108, 191, 489);
		panel_1.add(panel_4_1);
		
		txtAmount = new JTextField();
		txtAmount.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		txtAmount.setColumns(10);
		txtAmount.setBounds(67, 97, 124, 26);
		panel_4_1.add(txtAmount);
		
		txtFieldPrice = new JTextField();
		txtFieldPrice.addActionListener(this);
		txtFieldPrice.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		txtFieldPrice.setColumns(10);
		txtFieldPrice.setBounds(67, 60, 124, 26);
		panel_4_1.add(txtFieldPrice);
		
		txtFoodName = new JTextField();
		txtFoodName.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		txtFoodName.setColumns(10);
		txtFoodName.setBounds(67, 23, 124, 26);
		panel_4_1.add(txtFoodName);
		
		deleteFoodbtn= new JButton("Delete Food");
		deleteFoodbtn.addActionListener(this);
		deleteFoodbtn.setEnabled(false);
		deleteFoodbtn.addActionListener(this);
		deleteFoodbtn.setBounds(28, 197, 124, 23);
		panel_4_1.add(deleteFoodbtn);
		
		updateFoodbtn= new JButton("Update");
		updateFoodbtn.setEnabled(false);
		updateFoodbtn.setBounds(28, 166, 124, 23);
		panel_4_1.add(updateFoodbtn);
		
		JLabel lblNewLabel_7 = new JLabel("Name");
		lblNewLabel_7.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		lblNewLabel_7.setBounds(10, 23, 55, 26);
		panel_4_1.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Price");
		lblNewLabel_8.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		lblNewLabel_8.setBounds(10, 60, 54, 26);
		panel_4_1.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Amount");
		lblNewLabel_9.setBounds(8, 97, 49, 26);
		panel_4_1.add(lblNewLabel_9);
		
		JPanel actionPanel_1 = new JPanel();
		actionPanel_1.setLayout(null);
		actionPanel_1.setBounds(582, 108, 199, 489);
		panel_1.add(actionPanel_1);
		
		txtaddName = new JTextField();
		txtaddName.addActionListener(this);
		txtaddName.setBounds(65, 49, 111, 34);
		actionPanel_1.add(txtaddName);
		txtaddName.setColumns(10);
		
		txtaddPrice = new JTextField();
		txtaddPrice.addActionListener(this);
		txtaddPrice.setColumns(10);
		txtaddPrice.setBounds(65, 105, 111, 34);
		actionPanel_1.add(txtaddPrice);
		
		txtaddAmount = new JTextField();
		txtaddAmount.addActionListener(this);
		txtaddAmount.setColumns(10);
		txtaddAmount.setBounds(65, 161, 111, 34);
		actionPanel_1.add(txtaddAmount);
		
		submitBtn = new JButton("Submit");
		submitBtn.addActionListener(this);
		submitBtn.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		submitBtn.setBounds(52, 222, 124, 34);
		actionPanel_1.add(submitBtn);
		
		JLabel lblNewLabel_11 = new JLabel("Name");
		lblNewLabel_11.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		lblNewLabel_11.setBounds(10, 51, 56, 28);
		actionPanel_1.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("Price");
		lblNewLabel_12.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		lblNewLabel_12.setBounds(10, 113, 49, 14);
		actionPanel_1.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("Amount");
		lblNewLabel_13.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		lblNewLabel_13.setBounds(10, 171, 56, 20);
		actionPanel_1.add(lblNewLabel_13);
		foodModel=new DefaultListModel<String>();
		for(int i=0; i<foods.size();i++){
			foodModel.addElement(foods.get(i).getName());
		}
		
		list_1 = new JList<String>(foodModel);
		list_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		list_1.addListSelectionListener(this);
		list_1.setBounds(192, 68, 384, 528);
		
		JLabel lblNewLabel_14 = new JLabel("Add Foods");
		lblNewLabel_14.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		lblNewLabel_14.setBounds(609, 79, 128, 18);
		panel_1.add(lblNewLabel_14);
		
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(202, 69, 381, 528);
		scrollPane_2.setViewportView(list_1);
		panel_1.add(scrollPane_2);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Orders", null, panel_2, null);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(10, 58, 419, 539);
		panel_2.add(scrollPane_3);
		
		JLabel lblNewLabel_18 = new JLabel("Orders ");
		lblNewLabel_18.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_18.setFont(new Font("Tahoma", Font.PLAIN, 18));
		scrollPane_3.setColumnHeaderView(lblNewLabel_18);
		
		scrollPane_3.setViewportView(orderList_1);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(469, 58, 218, 539);
		panel_2.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_19 = new JLabel("Order Detail");
		lblNewLabel_19.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_19.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		lblNewLabel_19.setBounds(10, 11, 198, 26);
		panel_5.add(lblNewLabel_19);
		
		orderBy = new JTextField();
		orderBy.setEditable(false);
		orderBy.setBounds(80, 48, 128, 26);
		panel_5.add(orderBy);
		orderBy.setColumns(10);
		
		JLabel lblNewLabel_20 = new JLabel("Order by");
		lblNewLabel_20.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_20.setBounds(10, 48, 84, 26);
		panel_5.add(lblNewLabel_20);
		
		JLabel lblNewLabel_20_1 = new JLabel("Order date");
		lblNewLabel_20_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_20_1.setBounds(10, 90, 84, 26);
		panel_5.add(lblNewLabel_20_1);
		
		orderDate = new JTextField();
		orderDate.setEditable(false);
		orderDate.setColumns(10);
		orderDate.setBounds(80, 90, 128, 26);
		panel_5.add(orderDate);
		
		pricefield = new JTextField();
		pricefield.setEditable(false);
		pricefield.setColumns(10);
		pricefield.setBounds(112, 135, 96, 26);
		panel_5.add(pricefield);
		
		JLabel lblNewLabel_21 = new JLabel("Ordered Foods");
		lblNewLabel_21.setBounds(10, 188, 96, 26);
		panel_5.add(lblNewLabel_21);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(20, 225, 105, 164);
		panel_5.add(scrollPane_4);
		
		scrollPane_4.setViewportView(orderedFoods);
		
		JLabel lblNewLabel_22 = new JLabel("Total price ");
		lblNewLabel_22.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		lblNewLabel_22.setBounds(10, 139, 84, 19);
		panel_5.add(lblNewLabel_22);
		
		deleteOrder = new JButton("delete");
		deleteOrder.addActionListener(this);
		deleteOrder.setBounds(20, 417, 89, 23);
		panel_5.add(deleteOrder);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Complaints", null, panel_3, null);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 33, 487, 553);
		panel_3.add(scrollPane_1);
		
		JLabel compLabel = new JLabel("Complaints By Users");
		compLabel.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		compLabel.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane_1.setColumnHeaderView(compLabel);
		DefaultListModel<String>complaintModel=new DefaultListModel<String>();
		for(int i=0; i<compList.size();i++){
			complaintModel.addElement(compList.get(i).getCustomer().getUsername());
		}
		complaintList = new JList<String>(complaintModel);
		complaintList.addListSelectionListener(this);
		complaintList.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		scrollPane_1.setViewportView(complaintList);
		
		JPanel complaintPanel = new JPanel();
		complaintPanel.setBounds(507, 33, 249, 553);
		panel_3.add(complaintPanel);
		complaintPanel.setLayout(null);
		
		JLabel lblNewLabel_10 = new JLabel("Complainer Details");
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		lblNewLabel_10.setBounds(10, 11, 229, 33);
		complaintPanel.add(lblNewLabel_10);
		
		txtfield = new JTextField();
		txtfield.setEditable(false);
		txtfield.setBounds(89, 82, 150, 33);
		complaintPanel.add(txtfield);
		txtfield.setColumns(10);

		txtfield2 = new JTextField();
		txtfield2.setEditable(false);
		txtfield2.setColumns(10);
		txtfield2.setBounds(89, 141, 150, 33);
		complaintPanel.add(txtfield2);
		
		JLabel lblNewLabel_15 = new JLabel("Full Name");
		lblNewLabel_15.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_15.setBounds(10, 89, 69, 26);
		complaintPanel.add(lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel("Username");
		lblNewLabel_16.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_16.setBounds(10, 150, 75, 26);
		complaintPanel.add(lblNewLabel_16);
		
		textArea= new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(23, 245, 216, 82);
		complaintPanel.add(textArea);
		
		JLabel lblNewLabel_17 = new JLabel("Description");
		lblNewLabel_17.setBounds(23, 208, 90, 26);
		complaintPanel.add(lblNewLabel_17);
		contentPane.setLayout(gl_contentPane);
		setVisible(true);
	}


	


	@Override
	public void actionPerformed(ActionEvent Ae) {
		try{
			if(Ae.getSource()==submitBtn){
				if((txtaddAmount.getText().length()!=0&&txtaddName.getText().length()!=0)&&(txtaddPrice.getText().length()!=0)){
					Food fo=new Food(txtaddName.getText(),Integer.parseInt(txtaddAmount.getText()),Integer.parseInt(txtaddPrice.getText()));
					Boolean isAdded=dt.addToCollection(fo);
					foods.add(fo);
					if(isAdded){
						foodModel.addElement(fo.getName());
						JOptionPane.showMessageDialog(this,"Food Added Succesfully!","",JOptionPane.DEFAULT_OPTION);
					}else{
						JOptionPane.showMessageDialog(this,"The Food is already exist!","",JOptionPane.WARNING_MESSAGE);
					}
			}else{
				JOptionPane.showMessageDialog(this,"One or more field is empty  ","Error Adding Food item",JOptionPane.ERROR_MESSAGE);
			}
		}else if(Ae.getSource()==restrictbtn){
			int selected=list.getSelectedIndex();
			if(users.get(selected).getIsBanned()){
				restrictbtn.setText("restricted");		
				DataFile.getInstance().customerCollection.get(selected).setIsBanned(false);
				}else{
				restrictbtn.setText("Unrestrict");
				DataFile.getInstance().customerCollection.get(selected).setIsBanned(true);

			}
			DataFile.getInstance().writeToFile();

		}
		 if(Ae.getSource()==deletebtn){
			// System.out.println("The problem seems here");
			try{
				int selectedUser=list.getSelectedIndex();
				usermodel.removeElementAt(selectedUser);
				DataFile.getInstance().delete(DataFile.getInstance().customerCollection.get(selectedUser));
			}catch(IndexOutOfBoundsException e){

			}

		} if(Ae.getSource()==updatebtn){

		}
		
		if(Ae.getSource()==deleteFoodbtn){
			try{
				DataFile.getInstance().delete(foods.get(list_1.getSelectedIndex()));
				foodModel.removeElementAt(list_1.getSelectedIndex());
			}catch(IndexOutOfBoundsException e){

			}
		}
		if(Ae.getSource()==deleteOrder){
			try{
				DataFile.getInstance().delete(orders.get(orderList_1.getSelectedIndex()));
			    orderModel.removeElementAt(orderList_1.getSelectedIndex());
		}
			catch(IndexOutOfBoundsException e){

			}
		}
	}catch(NumberFormatException e){

	}
		
		
	}
	
	
	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		if(arg0.getSource()==list_1){
			deleteFoodbtn.setEnabled(true);
			updateFoodbtn.setEnabled(true);
			deleteFoodbtn.setEnabled(true);
			int selectedFood=list_1.getSelectedIndex();
				txtFoodName.setText(""+foods.get(selectedFood).getName());
				txtFieldPrice.setText("$"+foods.get(selectedFood).getPrice());
				txtAmount.setText(""+foods.get(selectedFood).getAmount());
			}else if(arg0.getSource()==list){
				updatebtn.setEnabled(true);
				deletebtn.setEnabled(true);

			int selectedUser=list.getSelectedIndex();
				name.setText(""+users.get(selectedUser).getFullName());
				username.setText(""+users.get(selectedUser).getUsername());
				phone.setText(""+users.get(selectedUser).getPhoneNumber());
				password.setText(""+users.get(selectedUser).getPassword());
				address.setText(""+users.get(selectedUser).getAddress());
				restrictbtn.setEnabled(true);
				if(DataFile.getInstance().customerCollection.get(selectedUser).getIsBanned()){
					restrictbtn.setText("Unrestrict");

					DataFile.getInstance().customerCollection.get(selectedUser).setIsBanned(true);
					DataFile.getInstance().writeToFile();
				}
				else{
					restrictbtn.setText("restrict");
					DataFile.getInstance().customerCollection.get(selectedUser).setIsBanned(false);
					DataFile.getInstance().writeToFile();
				}
			}
			else if(arg0.getSource()==complaintList){
			int selectedComplaint=complaintList.getSelectedIndex();
				txtfield.setText(""+compList.get(selectedComplaint).getCustomer().getFullName());
				txtfield2.setText(""+compList.get(selectedComplaint).getCustomer().getUsername());
				textArea.setText(""+compList.get(selectedComplaint).getDescription());
		}
		else if(arg0.getSource()==orderList_1){
			int selectedOrder=orderList_1.getSelectedIndex();
			orderBy.setText(""+orders.get(selectedOrder).getWhoOrdered().getFullName());
			orderDate.setText(""+orders.get(selectedOrder).getWhenOrdered());
			pricefield.setText(""+orders.get(selectedOrder).getTotalPrice());
			foodOrderedModel.removeAllElements();
			for(int i=0;i<orders.get(selectedOrder).getFoodNames().size();i++){
				foodOrderedModel.addElement(orders.get(selectedOrder).getFoodNames().get(i).getName());

			}
		}else if(arg0.getSource()==orderedFoods){
		}
	}
}