package screens;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatLightLaf;

import ClassFiles.Customer;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.JList;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class User extends JFrame {
	private JPanel contentPane;
	private DefaultListModel listModel=new DefaultListModel();
	private Customer customer;

	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
	// 	try {
	// 		UIManager.setLookAndFeel (new FlatLightLaf());
    //         UIManager.put( "Button.arc", 999 );
    //         UIManager.put( "Component.arc", 999 );
    //         UIManager.put( "ProgressBar.arc", 999 );
    //         UIManager.put( "TextComponent.arc", 999 );
    //         UIManager.put( "TabbedPane.selectedBackground", new Color(10,230,230) );
    //         UIManager.put( "TabbedPane.tabSeparatorsFullHeight", true );
    //         UIManager.put( "TabbedPane.showTabSeparators", true );
	// 	}catch(Exception e) {
			
	// 	}
	// 	EventQueue.invokeLater(new Runnable() {
	// 		public void run() {
	// 			try {
	// 				User frame = new User();
	// 				frame.setVisible(true);
	// 			} catch (Exception e) {
	// 				e.printStackTrace();
	// 			}
	// 		}
	// 	});
	// }

	/**
	 * Create the frame.
	 */
	public User(Customer customer) {
		this.customer = customer;
	    setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 993, 694);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 969, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 636, Short.MAX_VALUE))
		);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Order here", null, panel, null);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel_3 = new JPanel();
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.LIGHT_GRAY);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 523, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(24, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 616, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 618, GroupLayout.PREFERRED_SIZE)
							.addComponent(panel_3, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 618, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		
		JLabel userFullName = new JLabel(customer.getFullName());
		userFullName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		JLabel userName = new JLabel("@"+customer.getUsername());
		userName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_5 = new JLabel("Full Name");
		lblNewLabel_5.setFont(new Font("Yu Gothic", Font.PLAIN, 16));
		
		JLabel lblNewLabel_6 = new JLabel("User Name");
		lblNewLabel_6.setFont(new Font("Yu Gothic", Font.PLAIN, 16));
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_5.createSequentialGroup()
							.addGap(21)
							.addGroup(gl_panel_5.createParallelGroup(Alignment.TRAILING)
								.addComponent(userFullName, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
								.addComponent(userName, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_5.setVerticalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addGap(74)
					.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(userFullName, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(userName, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(408, Short.MAX_VALUE))
		);
		panel_5.setLayout(gl_panel_5);
		
		JLabel foodLabel = new JLabel("New label");
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		
		JLabel lblNewLabel = new JLabel("New label");
		
		JLabel priceLabel = new JLabel("New label");
		
		JButton btnNewButton = new JButton("Add to Order");
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_panel_3.createSequentialGroup()
							.addComponent(priceLabel, GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_panel_3.createSequentialGroup()
							.addComponent(foodLabel, GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
							.addContainerGap())))
				.addGroup(gl_panel_3.createSequentialGroup()
					.addComponent(btnNewButton)
					.addContainerGap(39, Short.MAX_VALUE))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(50)
					.addComponent(foodLabel, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(priceLabel, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addGap(48)
					.addComponent(btnNewButton)
					.addContainerGap(295, Short.MAX_VALUE))
		);
		panel_3.setLayout(gl_panel_3);
		//Populate List by the data From the file
		for(int i=0;i<200;i++) {
			listModel.addElement("Hello");
		}
		JList statusList = new JList(listModel);
		scrollPane.setViewportView(statusList);
		
		JLabel lblNewLabel_2 = new JLabel("Set Your Food Order here");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 24));
		scrollPane.setColumnHeaderView(lblNewLabel_2);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Status", null, panel_1, null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(24)
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 519, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(352, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 620, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		JList list_1 = new JList();
		scrollPane_1.setViewportView(list_1);
		
		JLabel lblNewLabel_3 = new JLabel("View My Status ");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 24));
		scrollPane_1.setColumnHeaderView(lblNewLabel_3);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Complaint", null, panel_2, null);
		
		JTextArea textArea = new JTextArea();
		textArea.setColumns(10);
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 18));
		
		JLabel lblNewLabel_4 = new JLabel("What seems to be the problem?");
		lblNewLabel_4.setFont(new Font("Yu Gothic UI", Font.PLAIN, 26));
		
		JButton btnNewButton_1 = new JButton("Submit");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
							.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE)
							.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 726, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(159, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(93)
					.addComponent(lblNewLabel_4)
					.addGap(19)
					.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
					.addGap(48)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(242, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Todo", null, panel_4, null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(65)
					.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 480, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(37)
					.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 605, GroupLayout.PREFERRED_SIZE))
		);
		
		JPanel panel_6 = new JPanel();
		scrollPane_2.setViewportView(panel_6);
		GroupLayout gl_panel_6 = new GroupLayout(panel_6);
		gl_panel_6.setHorizontalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGap(0, 478, Short.MAX_VALUE)
		);
		gl_panel_6.setVerticalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGap(0, 603, Short.MAX_VALUE)
		);
		panel_6.setLayout(gl_panel_6);
		panel_4.setLayout(gl_panel_4);
		contentPane.setLayout(gl_contentPane);
	}
}
