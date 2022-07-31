package screens;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import ClassFiles.Customer;
import FilesClass.DataFile;

import java.awt.Window.Type;
import javax.swing.*;
import javax.swing.BorderFactory;
public class CreateAccount extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
    private JPasswordField passwordField_1;
    private JButton bSubmit;
    private JLabel userLabel;
    private JLabel conLabel;
    private JLabel passLabel;
    private JLabel nameLabel;
    
	
	public CreateAccount() {
		setForeground(new Color(169, 169, 169));
		setBackground(new Color(119, 136, 153));
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 385);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(119, 136, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
        setVisible(true);
        setContentPane(contentPane);
        
        textField = new JTextField();
        textField.addActionListener(this);
        textField.setForeground(new Color(248, 248, 255));
        textField.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
        textField.setBounds(164, 20, 247, 35);
        textField.setBackground(new Color(255,255,255,60));
        contentPane.add(textField);
        textField.setColumns(10);
        // Border tBorder= BorderFactory.createLineBorder( Color.RED,1);
        // textField.setBorder(tBorder);
        JLabel lblNewLabel = new JLabel("Full Name");
        lblNewLabel.setFont(new Font("Ubuntu", Font.PLAIN, 16));
        lblNewLabel.setForeground(new Color(248, 248, 255));
        lblNewLabel.setBounds(25, 30, 120, 14);
        contentPane.add(lblNewLabel);
        
        nameLabel = new JLabel("");
        nameLabel.setForeground(new Color(220, 20, 60));
        nameLabel.setBounds(154, 60, 135, 14);
        contentPane.add(nameLabel);
        
        textField_1 = new JTextField();
        textField_1.setForeground(new Color(248, 248, 255));
        textField_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
        textField_1.setBounds(164, 80, 247, 35);
        textField_1.setBackground(new Color(255,255,255,60));
        textField_1.addActionListener(this);
        contentPane.add(textField_1);
        textField_1.setColumns(10);
        
        JLabel lblNewLabel_2 = new JLabel("User Name");
        lblNewLabel_2.setFont(new Font("Ubuntu", Font.PLAIN, 16));
        lblNewLabel_2.setForeground(new Color(248, 248, 255));
        lblNewLabel_2.setBounds(25, 90, 120, 14);
        contentPane.add(lblNewLabel_2);
        
        userLabel = new JLabel("");
        userLabel.setBounds(154, 115, 200, 14);
        userLabel.setForeground(new Color(220, 20, 60));
        contentPane.add(userLabel);
        
        JLabel lblNewLabel_4 = new JLabel("Password");
        lblNewLabel_4.setFont(new Font("Ubuntu", Font.PLAIN, 16));
        lblNewLabel_4.setForeground(new Color(248, 248, 255));
        lblNewLabel_4.setBounds(25, 140, 72, 14);
        contentPane.add(lblNewLabel_4);

        passwordField = new JPasswordField();
        passwordField.setBounds(164, 130, 247, 35);
        passwordField.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
        passwordField.addActionListener(this);
        
        passwordField.setBackground(new Color(255,255,255,60));
        passwordField.setForeground(new Color(248, 248, 255));
        contentPane.add(passwordField);
        
        passLabel = new JLabel("");
        passLabel.setForeground(new Color(220, 20, 60));
        passLabel.setBounds(154, 163, 135, 14);
        contentPane.add(passLabel);
        
        JLabel lblNewLabel_6 = new JLabel("Confirm password");
        lblNewLabel_6.setFont(new Font("Ubuntu", Font.PLAIN, 16));
        lblNewLabel_6.setForeground(new Color(248, 248, 255));
        lblNewLabel_6.setBounds(25, 190, 140, 14);
        contentPane.add(lblNewLabel_6);
        
        passwordField_1 = new JPasswordField();
        passwordField_1.setForeground(new Color(248, 248, 255));
        passwordField_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
        passwordField_1.addActionListener(this);
        passwordField_1.setBounds(164, 180, 247, 35);
        passwordField_1.setBackground(new Color(255,255,255,60));
        contentPane.add(passwordField_1);
        passwordField_1.setColumns(10);

        conLabel = new JLabel("");
        conLabel.setBounds(154, 215, 100, 14);
        conLabel.setForeground(new Color(220, 20, 60));
        conLabel.setBackground(new Color(255,255,255,60));
        contentPane.add(conLabel);
        
        bSubmit = new JButton("Submit");
        bSubmit.addActionListener(this);
        bSubmit.setBounds(320, 240, 89, 23);
        contentPane.add(bSubmit);
        
        JLabel bg1 = new JLabel("New label");
        bg1.setIcon(new ImageIcon("C:\\Users\\A One Trick Pony\\eclipse-workspace\\oop\\src\\images\\food.jpg"));
        bg1.setBounds(0, 0, 426, 253);
        contentPane.add(bg1);
        
        
	}


    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==bSubmit){
            if(textField.getText().isEmpty()){
                nameLabel.setText("Name cannot be empty");
            }
            else if(textField_1.getText().isEmpty()){
                userLabel.setText("Username cannot be empty");

            }
            else if(passwordField.getPassword().length==0){
                passLabel.setText("Password cannot be empty");


            }
            else {
                DataFile cc= DataFile.getInstance();
                // String user=String.valueOf(passwordField.getPassword());
                Customer  cus=new Customer(textField.getText(),textField_1.getText(),String.valueOf(passwordField.getPassword()));
                if(cc.search(cus)==-1){
                    if(String.valueOf(passwordField_1.getPassword()).equals(String.valueOf(passwordField.getPassword()))){
                        cc.addToCollection(cus);
                        System.out.println("problemsssssss");
                        this.dispose();
                    }
                    else{
                        conLabel.setText("Confirm password");
                        System.out.println(passwordField.getPassword());
                        System.out.println(passwordField_1.getPassword());
                    }
                }
                else{
                    userLabel.setText("Username is taken choose another...");
                }


            }



        }
    }
}
