package bms;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

@SuppressWarnings("serial")
public class Login extends JFrame implements ActionListener{
    JLabel l1,l2,l3;
    JTextField tf1;
    JPasswordField pf2;
    JButton b1,b2,b3;
  
    Login(){
    	super("ATM");
    	setSize(852,480);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        
        l1 = new JLabel("WELCOME TO ATM");
        l1.setFont(new Font("opensans", Font.BOLD, 40));
        
        l2 = new JLabel("Card No:");
        l2.setFont(new Font("opensans", Font.BOLD, 30));
        
        l3 = new JLabel("PIN:");
        l3.setFont(new Font("opensans", Font.BOLD, 30));
        
        tf1 = new JTextField(15);
        pf2 = new JPasswordField(15);
        
        b1 = new JButton("SIGN IN");
        b1.setBackground(new Color(59, 89, 182));

        
        b2 = new JButton("CLEAR");
        b2.setBackground(new Color(59, 89, 182));

        
        b3 = new JButton("SIGN UP");
        b3.setBackground(new Color(59, 89, 182));
        
        setLayout(null);
        
        l1.setBounds(220,20,450,90);
        add(l1);
        
        l2.setBounds(180,150,300,40);
        add(l2);
        
        tf1.setBounds(330,150,250,40);
        add(tf1);
        
        l3.setBounds(250,200,300,40);
        add(l3);
        
        tf1.setFont(new Font("opensans", Font.BOLD, 14));
       
        
        pf2.setFont(new Font("opensans", Font.BOLD, 14));
        pf2.setBounds(330,200,250,40);
        add(pf2);
        
        b1.setFont(new Font("opensans", Font.BOLD, 14));
        b1.setBounds(260,300,120,50);
        add(b1);
        
        b2.setFont(new Font("opensans", Font.BOLD, 14));
        b2.setBounds(460,300,120,50);
        add(b2);
        
        b3.setFont(new Font("opensans", Font.BOLD, 14));
        b3.setBounds(260,350,320,50);
        add(b3);
        
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
  
        setVisible(true);
        

        
    }
    public void actionPerformed(ActionEvent ae) {
       
        if(ae.getSource() == b1) {
	    	try{        
	            conn c1 = new conn();
	            String a  = tf1.getText();
	            @SuppressWarnings("deprecation")
				String b  = pf2.getText();
	            String q  = "select * from login where cardno = '"+a+"' and pin = '"+b+"'";
	            ResultSet rs = c1.s.executeQuery(q);
	            
	          
	            if(rs.next()){
	            	new Transcations().setVisible(true);
	            	setVisible(false); 
	            }
	            else{
	                JOptionPane.showMessageDialog(null, "Incorrect Card Number or Password");  
	            }
	    	}
	    	catch(Exception e){
	    		e.printStackTrace();
	            System.out.println("error: "+e);
	        }
        }
	   else if(ae.getSource()==b2){
           tf1.setText("");
          pf2.setText("");
       }
	   else if(ae.getSource()==b3){
          new Signup().setVisible(true);
          setVisible(false);
      }
 }
 
              
    public static void main(String[] args){
        new Login().setVisible(true);
    }

    
}



