package screens;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import ClassFiles.*;
import FilesClass.*;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;

public class MainFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblNewLabel_1;
	private JPasswordField passwordField;
	private String[] chooseUsers;
	private JButton bRegister;
	private JButton bLogin;
	private JLabel userValidLabel;
	private JLabel passValidLabel;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel restrauntLabel;
	private JLabel lblNewLabel;
	private JButton bReset;
	private  JComboBox<String> comboBox;
	private boolean isRemoved=false;

	
	public MainFrame() {
		
		ImageIcon photo= new ImageIcon("src\\images\\food.jpg");
		setForeground(Color.LIGHT_GRAY);
		getContentPane().setBackground(new Color(255,255,255,0));
		
		setResizable(false);
		chooseUsers = new String[] {"Admin","Customer"};
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(450, 200, 720, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(10, 119, 153,80));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("User name");
		lblNewLabel.setFont(new Font("Ubuntu", Font.PLAIN, 16));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(177, 92, 109, 23);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setForeground(new Color(248, 248, 255));
		textField.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		textField.setBackground(new Color(211, 211, 211,60));
		textField.setToolTipText("Enter username of your account");
		textField.setBounds(177, 117, 247, 35);
		textField.addActionListener(this);
		contentPane.add(textField);
		textField.setColumns(30);
		
		lblNewLabel_1 = new JLabel("password");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(177, 170, 109, 23);
		contentPane.add(lblNewLabel_1);
		
		bLogin = new JButton("Login");
		bLogin.setBounds(258, 251, 83, 23);
		bLogin.addActionListener(this);
		contentPane.add(bLogin);
		
		passwordField = new JPasswordField();
		passwordField.setForeground(new Color(248, 248, 255));
		passwordField.setToolTipText("Enter password of your Accunt");
		passwordField.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		passwordField.setBackground(new Color(211, 211, 211,60));
		
		passwordField.setBounds(177, 195, 247, 35);
		passwordField.addActionListener(this);
		contentPane.add(passwordField);
		
		comboBox = new JComboBox<String>(chooseUsers);
		comboBox.addActionListener(this);
		comboBox.setBackground(new Color(248, 248, 255,60));
		comboBox.setForeground(new Color(248, 248, 255));
		comboBox.setEditable(false);
		comboBox.setSelectedIndex(1);
		comboBox.setMaximumRowCount(4);
		comboBox.setBounds(10, 11, 109, 22);
		contentPane.add(comboBox);
		

		bRegister = new JButton("Create");
		bRegister.addActionListener(this);
		bRegister.setBounds(334, 285, 90, 23);
		contentPane.add(bRegister);
		
		userValidLabel = new JLabel(" ");
		userValidLabel.setForeground(Color.RED);
		userValidLabel.setBounds(187, 154, 237, 14);
		contentPane.add(userValidLabel);
		
		passValidLabel = new JLabel(" ");
		passValidLabel.setForeground(Color.RED);
		passValidLabel.setBounds(188, 231, 236, 14);
		contentPane.add(passValidLabel);
		
		lblNewLabel_2 = new JLabel("Don't have account yet?");
		lblNewLabel_2.setForeground(new Color(245, 255, 250));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(177, 289, 147, 14);
		contentPane.add(lblNewLabel_2);
		
		
		restrauntLabel = new JLabel("Restraunt");
		restrauntLabel.setForeground(new Color(10, 10, 10));
		restrauntLabel.setFont(new Font("Viner Hand ITC", Font.PLAIN, 24));
		restrauntLabel.setBounds(0, 0, 706, 489);
		contentPane.add(restrauntLabel);
		restrauntLabel.setIcon(photo);
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		try{
			if(e.getSource()==comboBox){
				if(comboBox.getSelectedIndex()==0){
					lblNewLabel.setText("Admin ID");
					remove();
				}
				else if(comboBox.getSelectedIndex()==1){
					lblNewLabel.setText("User name");
					if(isRemoved){
						add();
					}
				}
				else if(comboBox.getSelectedIndex()==2){
					lblNewLabel.setText("Delivery ID");
					remove();
				}
				else if(comboBox.getSelectedIndex()==3){
					lblNewLabel.setText("Restraunt ID");
					remove();				
				}
			}
			if((comboBox.getSelectedIndex()==1)){
				verifyUser(e);
			}
			else if(comboBox.getSelectedIndex()==0){
				verifyAdmin(e);
			}
		}
	catch(Exception Ae){
		Ae.printStackTrace();
		}
	}
	void add(){
		this.add(bReset);
	    this.add(lblNewLabel_3); 
		this.repaint();
		isRemoved=false;
	}
	void remove(){
		userValidLabel.setText("");
		passValidLabel.setText("");
		this.remove(bReset);
		this.remove(lblNewLabel_3);
		this.repaint();
		isRemoved=true;
	}
	// verifies the inputs  from
	int  verifyUser(ActionEvent e){
		if(e.getSource()==bLogin) {
			userValidLabel.setText(" ");
			passValidLabel.setText(" ");
			if(textField.getText().length()==0){
				userValidLabel.setText("User cannot be empty");
			}
			if(passwordField.getPassword().length==0){
				passValidLabel.setText("password cannot be empty");
				return 1;
			}
			DataFile cc=  DataFile.getInstance();
			String user =textField.getText();
			Customer cus=cc.search(user);
			String password=String.valueOf(passwordField.getPassword());
			if(cus==null){
				userValidLabel.setText("User not found");
				return 5;
			}
			if(password.equals(cus.getPassword())){
				if(cus.getIsBanned()){
					JOptionPane.showMessageDialog(this,"You are restricted by adminstrator");
				}else{
					new LabFrame(cus);
					this.dispose();

					}
				
			}
			else{
				passValidLabel.setText("Invalid password");
				return 56;
			}
		}
		else if(e.getSource()==bRegister){
			new CreateAccount();
		}
		return 9;
	}
	int verifyAdmin(ActionEvent e){
		try{
	    if(e.getSource()==bLogin){
			userValidLabel.setText("");
			userValidLabel.setText("");
			if(textField.getText().length()==0){
				userValidLabel.setText("Admin ID cannot be empty");
			}
			if(passwordField.getPassword().length==0){
				passValidLabel.setText("password cannot be empty");
				return 1;
			}
			DataFile cc=  DataFile.getInstance();
			String user =textField.getText();
			int index=cc.search(Integer.parseInt(user));
			
			String password=String.valueOf(passwordField.getPassword());

			if(index==-1){
				userValidLabel.setText("Admin not found");
				return 5;
			}
			if(password.equals(cc.adminList.get(index).getPassword())){
				
				System.out.println(cc.adminList.get(index).getPassword());
				this.dispose();
				new AdminFrame();
		
			}
			else{
				passValidLabel.setText("Invalid password");
				return 56;
			}}
		}catch(NumberFormatException Ae){
			userValidLabel.setText("Invalid ID number");
			Ae.printStackTrace();
		}catch(Exception ze){
			userValidLabel.setText("Something went wrong");

		}
		return 200;


	}
}
