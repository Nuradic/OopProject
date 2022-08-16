package screens;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


import ClassFiles.Complaint;
import ClassFiles.Customer;
import ClassFiles.Food;
import ClassFiles.Order;
import FilesClass.DataFile;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.SwingConstants;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class LabFrame extends JFrame implements ActionListener ,ListSelectionListener{

	private JPanel contentPane;
	int count;
	private JTextField txtFoodName;
	private JTextField txtPrice;
	private JButton submitbtn;
	private JButton addbtn;
	JList <String>orderList;
	Customer customer;
	private JButton orderSubmit;
	DataFile dt=DataFile.getInstance();
	ArrayList<Food>foods=dt.foodList;
	DefaultListModel<String> foodModel ;
	JList<String>foodList;
	private JTextField namehere;
	private JTextField usernamehere;
	private JTextArea textArea;
	private JButton cancelbtn ;
	private ArrayList<Food>foodOrdered=new ArrayList<Food>();
	private DefaultListModel<String> orderModel=new DefaultListModel<String>();
	private int totalPrice=0;
	private JLabel pricelbl;
	private JTextField orderDate;
	private JTextField totalPricelbl;
	private JList<String> orderedList;
	private DefaultListModel<String> myOrderModel=new DefaultListModel<String>();
	private ArrayList<Order> myorders=new ArrayList<Order>();
	private DefaultListModel<String> orderedfoodmodel=new DefaultListModel<String>();

	public LabFrame(Customer customer) {
		DataFile dt=DataFile.getInstance();
		ArrayList<Order> orders=dt.orderList;	
		for(int i=0;i<orders.size();i++){
			if(customer.getUsername().equals(((Order) orders.get(i)).getWhoOrdered().getUsername())){
				myorders.add(orders.get(i));
				myOrderModel.addElement(""+orders.get(i).getId());
			}
		}
		this.customer = customer;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 150, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Order here", null, panel, null);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(145, 34, 345, 514);
		panel.add(scrollPane);
		
		foodModel= new DefaultListModel<String>();
		foodList = new JList<String>(foodModel);
		foodList.addListSelectionListener(this);
		for(int i=0;i<foods.size();i++){
			foodModel.addElement(foods.get(i).getName());
		}		
		foodList.setFont(new Font("Lucida Sans", Font.PLAIN, 16));
		scrollPane.setViewportView(foodList);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 34, 146, 514);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 16));
		lblNewLabel_1.setBounds(10, 40, 54, 22);
		panel_4.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Price");
		lblNewLabel_1_1.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(10, 84, 54, 22);
		panel_4.add(lblNewLabel_1_1);
		
		addbtn= new JButton("Add");
		addbtn.setEnabled(false);
		addbtn.addActionListener(this);
		addbtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		addbtn.setBounds(10, 154, 54, 50);
		panel_4.add(addbtn);
		
		txtFoodName = new JTextField();
		txtFoodName.setEditable(false);
		txtFoodName.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		txtFoodName.setBounds(57, 40, 79, 22);
		panel_4.add(txtFoodName);
		txtFoodName.setColumns(10);
		
		txtPrice = new JTextField();
		txtPrice.setEditable(false);
		txtPrice.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		txtPrice.setColumns(10);
		txtPrice.setBounds(57, 88, 79, 22);
		panel_4.add(txtPrice);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 257, 136, 156);
		panel_4.add(scrollPane_1);
		
		orderList = new JList<String>(orderModel);
		
		orderList.addListSelectionListener(this);
		scrollPane_1.setViewportView(orderList);
		
		JLabel lblNewLabel_5 = new JLabel("Current Order");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(15, 213, 121, 33);
		panel_4.add(lblNewLabel_5);
		
		orderSubmit = new JButton("Order");
		orderSubmit.setEnabled(false);
		orderSubmit.addActionListener(this);
		orderSubmit.setBounds(32, 457, 104, 22);
		panel_4.add(orderSubmit);
		
		JLabel lblNewLabel_6 = new JLabel("Total Price");
		lblNewLabel_6.setBounds(10, 424, 64, 22);
		panel_4.add(lblNewLabel_6);
		
		pricelbl= new JLabel("");
		pricelbl.setBounds(84, 424, 52, 22);
		panel_4.add(pricelbl);
		
		cancelbtn = new JButton("Cancel");
		cancelbtn.addActionListener(this);
		cancelbtn.setEnabled(false);
		cancelbtn.setBounds(32, 481, 104, 22);
		panel_4.add(cancelbtn);
		
		JLabel lblNewLabel = new JLabel("Select Food to add to order");
		lblNewLabel.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 480, 24);
		panel.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Complain", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("What seems to be the issue?");
		lblNewLabel_3.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 22));
		lblNewLabel_3.setBounds(23, 100, 379, 31);
		panel_2.add(lblNewLabel_3);
		
		submitbtn= new JButton("Submit");
		submitbtn.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		submitbtn.addActionListener(this);
		submitbtn.setBounds(339, 299, 125, 37);
		panel_2.add(submitbtn);
		
		 textArea= new JTextArea();
		textArea.setRows(10);
		textArea.setColumns(20);
		textArea.setBounds(23, 142, 442, 144);
		panel_2.add(textArea);
		
		JPanel panel_1 = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 574, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
					.addGap(0))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE)
						.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 553, GroupLayout.PREFERRED_SIZE))
					.addGap(0))
		);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Status", null, panel_3, null);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 104, 239, 433);
		panel_3.add(scrollPane_2);
		
		 orderedList= new JList<String>(myOrderModel);
		//  orderedList.add
		 orderedList.addListSelectionListener(this);
		 
		scrollPane_2.setViewportView(orderedList);
		
		JPanel panel_5_1 = new JPanel();
		panel_5_1.setBounds(247, 104, 211, 433);
		panel_3.add(panel_5_1);
		panel_5_1.setLayout(null);
		
		JLabel lblNewLabel_19 = new JLabel("Order Detail");
		lblNewLabel_19.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_19.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		lblNewLabel_19.setBounds(10, 11, 198, 26);
		panel_5_1.add(lblNewLabel_19);
		
		JLabel lblNewLabel_20_1 = new JLabel("Order date");
		lblNewLabel_20_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_20_1.setBounds(10, 90, 84, 26);
		panel_5_1.add(lblNewLabel_20_1);
		
		orderDate = new JTextField();
		orderDate.setEditable(false);
		orderDate.setColumns(10);
		orderDate.setBounds(80, 90, 128, 26);
		panel_5_1.add(orderDate);
		
		totalPricelbl = new JTextField();
		totalPricelbl.setEditable(false);
		totalPricelbl.setColumns(10);
		totalPricelbl.setBounds(112, 135, 96, 26);
		panel_5_1.add(totalPricelbl);
		
		JLabel lblNewLabel_21 = new JLabel("Ordered Foods");
		lblNewLabel_21.setBounds(10, 188, 96, 26);
		panel_5_1.add(lblNewLabel_21);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(20, 225, 105, 91);
		panel_5_1.add(scrollPane_4);
		
		JList<String> orderedfoodlist = new JList<String>(orderedfoodmodel);
		scrollPane_4.setViewportView(orderedfoodlist);
		
		JLabel lblNewLabel_22 = new JLabel("Total price ");
		lblNewLabel_22.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		lblNewLabel_22.setBounds(10, 139, 84, 19);
		panel_5_1.add(lblNewLabel_22);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("delivered");
		rdbtnNewRadioButton.setBounds(97, 44, 111, 23);
		panel_5_1.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("payed");
		rdbtnNewRadioButton_1.setBounds(20, 44, 111, 23);
		panel_5_1.add(rdbtnNewRadioButton_1);
		panel_1.setLayout(null);
		
		JLabel welcomelbl = new JLabel("Welcome "+customer.getFullName());
		welcomelbl.setFont(new Font("Yu Gothic UI", Font.BOLD | Font.ITALIC, 16));
		welcomelbl.setBounds(10, 22, 256, 46);
		panel_1.add(welcomelbl);
		
		JLabel lblNewLabel_2 = new JLabel("Full Name");
		lblNewLabel_2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 85, 80, 31);
		panel_1.add(lblNewLabel_2);
		
		namehere = new JTextField();
		namehere.setText(customer.getFullName());
		namehere.setEditable(false);
		namehere.setBounds(100, 85, 158, 31);
		panel_1.add(namehere);
		namehere.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Username");
		lblNewLabel_4.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(10, 136, 80, 31);
		panel_1.add(lblNewLabel_4);
		usernamehere = new JTextField();
		usernamehere.setText("@"+customer.getUsername());
		usernamehere.setEditable(false);
		usernamehere.setBounds(101, 136, 157, 31);
		panel_1.add(usernamehere);
		usernamehere.setColumns(10);
		contentPane.setLayout(gl_contentPane);
		setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent Ae) {
		if(Ae.getSource()==submitbtn){
			if(textArea.getText().length()!=0){
				Complaint comp=new Complaint(customer,textArea.getText());
				DataFile.getInstance().addToCollection(comp);
				JOptionPane.showMessageDialog(this, "Complaint Set succesfully" );
			}
		}
		else if(Ae.getSource()==addbtn){
			int prices=0;
			orderSubmit.setEnabled(true);
			cancelbtn.setEnabled(true);
			int selected=foodList.getSelectedIndex();
			totalPrice=totalPrice+foods.get(selected).getHowMany();
			if(DataFile.getInstance().foodList.get(selected).getAmount()!=0){
				DataFile.getInstance().foodList.get(selected).updateAmount();
				foodOrdered.add(foods.get(selected));
				orderModel.addElement(foods.get(selected).getName());
				for(int i=0;i<foodOrdered.size();i++){
					prices =prices+foodOrdered.get(i).getPrice();
				}
				pricelbl.setText(""+prices);
			}else{
				JOptionPane.showMessageDialog(this,"The restraunt run out of "+foods.get(selected).getName());

			}
			System.out.println(DataFile.getInstance().foodList.get(selected).getHowMany());
			
		}
		 if(Ae.getSource()==orderSubmit){
			 orderModel.removeAllElements();
			 orderSubmit.setEnabled(false);
			 cancelbtn.setEnabled(false);
			 pricelbl.setText("");
			 Order order=new Order(foodOrdered,customer);
			 myOrderModel.addElement(""+order.getId());
			DataFile.getInstance().addToCollection(order);
			JOptionPane.showMessageDialog(this, "Your Order is Placed Succesfully");
		}
		if(Ae.getSource()==cancelbtn){
			orderModel.removeAllElements();
			orderSubmit.setEnabled(false);
			cancelbtn.setEnabled(false);
			pricelbl.setText("");
		}

	}
	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		if(arg0.getSource()==orderList){
		}
		 if(arg0.getSource()==foodList){
			addbtn.setEnabled(true);
			int selectedFood=foodList.getSelectedIndex();
			txtFoodName.setText(foods.get(selectedFood).getName());
			txtPrice.setText(""+foods.get(selectedFood).getPrice());
		}
		if(arg0.getSource()==orderedList){
			int selectedOrder=orderedList.getSelectedIndex();
			orderDate.setText(""+myorders.get(selectedOrder).getWhenOrdered());
			totalPricelbl.setText(""+myorders.get(selectedOrder).getTotalPrice());
			orderedfoodmodel.removeAllElements();
			for(int i=0;i<myorders.get(selectedOrder).getFoodNames().size();i++){
				orderedfoodmodel.addElement(myorders.get(selectedOrder).getFoodNames().get(i).getName());

			}
		}
	}
		}

class T extends Thread {

	@Override
		public void run() {
	}
	public void justRun(JLabel t1){
		for(int i = 0; i <200;i++){
			try{
				t1.setText(String.valueOf(i));
				Thread.sleep(1000);
			}
			catch(InterruptedException e){

			}

		}

	}
}