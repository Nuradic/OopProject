package screens;
import java.util.ArrayList;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.formdev.flatlaf.FlatLightLaf;

import ClassFiles.Customer;
import ClassFiles.Food;
import FilesClass.DataFile;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.*;

public class AdminFrame extends JFrame implements ActionListener ,ListSelectionListener{

	private JPanel contentPane;
	private JTextField name;
	private JTextField username;
	private JTextField phone;
	private JTextField password;
	private JTextField address;
	private JTextField txtFieldPhone;
	private JTextField textField_3;
	private JTextField txtAmount;
	private JTextField txtFieldPrice;
	private JTextField txtFoodName;
	private JTextField txtaddName;
	private JTextField txtaddPrice;
	private JTextField txtaddAmount;
	private JTextField textField_12;
	private ArrayList<Food> foods;
	private JButton submitBtn;
	ArrayList<Customer>users;
	private JList<String> list_1;
	private JList<String> list;
	DataFile dt=  DataFile.getInstance();
	private DefaultListModel<String> foodModel;
	// public static void main(String[]args ) {
	// 	try {
	// 		UIManager.setLookAndFeel (new FlatLightLaf());
	// 	}catch(Exception e) {}
	// 	new AdminFrame();
	// }

	
	public AdminFrame() {
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
		
		JButton btnNewButton_1 = new JButton("Update");
		btnNewButton_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		btnNewButton_1.setBounds(10, 287, 124, 23);
		panel_4.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Restrict Account");
		btnNewButton.setBounds(10, 253, 124, 23);
		panel_4.add(btnNewButton);
		
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(191, 68, 397, 529);
		panel.add(scrollPane);
		DefaultListModel<String> model= new DefaultListModel<String>();
		for(int i=0;i<users.size();i++){
			model.addElement(users.get(i).getUsername());
		}
		list = new JList<String>(model);
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
		
		txtFieldPhone = new JTextField();
		txtFieldPhone.setText("Phone:-0928808587");
		txtFieldPhone.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		txtFieldPhone.setColumns(10);
		txtFieldPhone.setBounds(0, 171, 191, 26);
		panel_4_1.add(txtFieldPhone);
		
		textField_3 = new JTextField();
		textField_3.setText("Phone:-0928808587");
		textField_3.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		textField_3.setColumns(10);
		textField_3.setBounds(0, 134, 191, 26);
		panel_4_1.add(textField_3);
		
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
		
		JButton btnDeleteFood = new JButton("Delete Food");
		btnDeleteFood.setBounds(10, 239, 124, 23);
		panel_4_1.add(btnDeleteFood);
		
		JButton btnNewButton_4 = new JButton("Update");
		btnNewButton_4.setBounds(10, 208, 124, 23);
		panel_4_1.add(btnNewButton_4);
		
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
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(65, 206, 111, 34);
		actionPanel_1.add(textField_12);
		
		submitBtn = new JButton("Submit");
		submitBtn.addActionListener(this);
		submitBtn.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		submitBtn.setBounds(34, 274, 124, 34);
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
		
		// JScrollPane scrollPane_1 = new JScrollPane();
		// scrollPane_1.setBounds(192, 591, 384, -529);
		// scrollPane_1.setViewportView(list_1);
		// panel_1.add(scrollPane_1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(202, 69, 381, 528);
		scrollPane_2.setViewportView(list_1);
		panel_1.add(scrollPane_2);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Orders", null, panel_2, null);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Complaints", null, panel_3, null);
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
		}
	}catch(NumberFormatException e){

	}
		
		
	}
	
	
	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		int selectedFood=list_1.getSelectedIndex();
		int selectedUser=list.getSelectedIndex();
		if(selectedFood!=-1){
			txtFoodName.setText(""+foods.get(selectedFood).getName());
			txtFieldPrice.setText("$"+foods.get(selectedFood).getPrice());
			txtAmount.setText(""+foods.get(selectedFood).getAmount());
		}
		if(selectedUser!=-1){
			name.setText(""+users.get(selectedUser).getFullName());
			username.setText(""+users.get(selectedUser).getUsername());
			phone.setText(""+users.get(selectedUser).getPhoneNumber());
			password.setText(""+users.get(selectedUser).getPassword());
			address.setText(""+users.get(selectedUser).getAddress());
		}
	}
}