package screens;

import java.awt.event.*;
import javax.swing.*;

import com.formdev.flatlaf.*;

import java.awt.*;
public class User2 extends JFrame implements ActionListener{
    JPanel contentPane=new JPanel();
    
    JTabbedPane tabbedPane=new JTabbedPane(JTabbedPane.LEFT);
    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub
        
    }
    public static void main(String[] args){
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());

        } catch (UnsupportedLookAndFeelException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        new User2();
    }
    User2(){
        //Properties of the frame are
        setBounds(400,100,900,700);
        
        
        //Creating Components
        contentPane.setLayout(new GridLayout(1,2,0,9));
        JPanel userPanel=new JPanel();
        //JTab contents 
        DefaultListModel <String>listModel=new DefaultListModel<String>();
        JPanel jp=new JPanel();
        jp.setBackground(Color.red);
        for(int i=0;i<200;i++){

            listModel.addElement("jp");
        }
        JList<String> list=new JList<String>(listModel);
        JScrollPane scrollPane1=new JScrollPane();
        JPanel panel1=new JPanel();
        scrollPane1.setViewportView(list);
        panel1.setLayout(new BorderLayout());
        JPanel foodPanel=new JPanel();
        
        panel1.add(scrollPane1, BorderLayout.CENTER);
        panel1.add(foodPanel, BorderLayout.EAST);
 
        JPanel panel2=new JPanel();
        JPanel panel3=new JPanel();
        JPanel panel4=new JPanel();
        tabbedPane.addTab("Order",null,panel1,"Put your Food Order here...");
        tabbedPane.setFont(new Font("Yu Gothic UI", Font.PLAIN, 24));
        // tabbedPane.setAlignmentX(0);
        // tabbedPan
        // tabbedPane.setAlignmentX(3);
        tabbedPane.addTab("Status",null,panel2,null);
        tabbedPane.addTab("Complain",null,panel3,null);
        tabbedPane.addTab("Here...",null,panel4,null);
        contentPane.add(tabbedPane);
        contentPane.add(userPanel);
        getContentPane().add(contentPane);
        
        setVisible(true);
        

        
    }
}
