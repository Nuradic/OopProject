package screens;
import java.awt.BorderLayout;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

import javax.swing.border.EmptyBorder;
import javax.swing.event.AncestorListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import ClassFiles.*;
import FilesClass.*;

import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
public class SecondScreen extends JFrame implements ActionListener, ListSelectionListener {

	private JPanel contentPane;
	private JList list;
	private DefaultListModel listModel;
	private JScrollPane scrollPane;
	ArrayList<Customer>names=( DataFile.getInstance()).customerCollection;
	public SecondScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 991, 662);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane_3 = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane_3.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 24));
		tabbedPane_3.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(tabbedPane_3, GroupLayout.DEFAULT_SIZE, 997, Short.MAX_VALUE)
					.addGap(0))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(tabbedPane_3)
					.addContainerGap())
		);
		
		JPanel orderPanel = new JPanel();
		tabbedPane_3.addTab("Order here", null, orderPanel, null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(119, 136, 153));
		GroupLayout gl_orderPanel = new GroupLayout(orderPanel);
		gl_orderPanel.setHorizontalGroup(
			gl_orderPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_orderPanel.createSequentialGroup()
					.addGap(98)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 679, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(44, Short.MAX_VALUE))
		);
		gl_orderPanel.setVerticalGroup(
			gl_orderPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_orderPanel.createSequentialGroup()
					.addGap(48)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 488, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(52, Short.MAX_VALUE))
		);
		
		listModel=new DefaultListModel(); 
		for(int i=0;i<200;i++){
			listModel.addElement(i);
		}
		list = new JList(listModel);
		list.addListSelectionListener(this);
		scrollPane=new JScrollPane(list);
		
		JScrollBar scrollBar = new JScrollBar();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(list, GroupLayout.PREFERRED_SIZE, 339, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(323))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(list, GroupLayout.PREFERRED_SIZE, 488, GroupLayout.PREFERRED_SIZE)
						.addComponent(scrollBar, GroupLayout.PREFERRED_SIZE, 488, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		orderPanel.setLayout(gl_orderPanel);
		
		JPanel statusPanel = new JPanel();
		tabbedPane_3.addTab("Status", null, statusPanel, null);
		JPanel menuPanel_2 = new JPanel();
		tabbedPane_3.addTab("Food Menu", null, menuPanel_2, null);
		
		JPanel complaintPanel = new JPanel();
		tabbedPane_3.addTab("Complaint", null, complaintPanel, null);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 18));
		
		JLabel lblNewLabel = new JLabel("What seems to be the problem?");
		lblNewLabel.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 18));
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		JLabel lblNewLabel_1 = new JLabel("Complaint About Orders");
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1.setIcon(null);
		GroupLayout gl_complaintPanel = new GroupLayout(complaintPanel);
		gl_complaintPanel.setHorizontalGroup(
			gl_complaintPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_complaintPanel.createSequentialGroup()
					.addGap(41)
					.addGroup(gl_complaintPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_complaintPanel.createParallelGroup(Alignment.LEADING)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 418, GroupLayout.PREFERRED_SIZE)
							.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 721, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 329, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(59, Short.MAX_VALUE))
		);
		gl_complaintPanel.setVerticalGroup(
			gl_complaintPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_complaintPanel.createSequentialGroup()
					.addGap(20)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addGap(142)
					.addComponent(lblNewLabel)
					.addGap(18)
					.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(82, Short.MAX_VALUE))
		);
		complaintPanel.setLayout(gl_complaintPanel);
		
	
		contentPane.setLayout(gl_contentPane);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
			 new SecondScreen();
		}
	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		//Todo finish this
	}
	}


