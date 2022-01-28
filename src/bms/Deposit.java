package bms;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


@SuppressWarnings("serial")
public class Deposit extends JFrame implements ActionListener{
    
    JTextField t1,t2;
    JButton b1,b2,b3;
    JLabel l1,l2,l3;
    
    Deposit(){
        
    	super("DEPOSIT");
    	setSize(852,480);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        
        l1 = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        l1.setFont(new Font("opensans", Font.BOLD, 35));
        
        
        l3 = new JLabel("Enter Pin");
        l3.setFont(new Font("opensans", Font.BOLD, 20));
        
        t1 = new JTextField();
        t1.setFont(new Font("opensans", Font.BOLD, 20));
        
        t2 = new JTextField();
        t2.setFont(new Font("opensans", Font.BOLD, 20));
        
        b1 = new JButton("DEPOSIT");
        b1.setFont(new Font("opensans", Font.BOLD, 18));
        b1.setBackground(new Color(59, 89, 182));
    
    
        b2 = new JButton("BACK");
        b2.setFont(new Font("opensans", Font.BOLD, 18));
        b2.setBackground(new Color(59, 89, 182));
  
        
        b3 = new JButton("EXIT");
        b3.setFont(new Font("opensans", Font.BOLD, 18));
        b3.setBackground(new Color(59, 89, 182));

        setLayout(null);
        
        l3.setBounds(270,10,120,50);
        add(l3);
        
        t2.setBounds(380,10,120,40);
        add(t2);
        
        l1.setBounds(40,120,800,50);
        add(l1);
        
        
        t1.setBounds(260,200,300,50);
        add(t1);
        
        b1.setBounds(260,300,150,50);
        add(b1);
        
        b2.setBounds(410,300,150,50);
        add(b2);
        
        b3.setBounds(260,350,300,50);
        add(b3);
        
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
              
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
       
        try{        
           
            String a = t1.getText();
            String b = t2.getText();
            
            
            
            
            if(ae.getSource()==b1){
                if(t1.getText().equals("")){
                    
                    JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Deposit");
                
                }
                else{
                    
                    conn c1 = new conn();
                    
                    
                    
                    ResultSet rs = c1.s.executeQuery(" select * from bank where pin = '"+b+"'");
                    
                    double balance = 0;
                   
                   if(rs.next()) {
               
                	   balance = rs.getDouble("balance");
                       String pin = rs.getString("pin");
                       double d = Double.parseDouble(a);
                       balance+=d;
                       String q1= "insert into bank values('"+pin+"','"+d+"',null,'"+balance+"')";
                       c1.s.executeUpdate(q1);
                       
                    }
                   JOptionPane.showMessageDialog(null, "Rs. "+a+" Deposited Successfully");
                    new Transcations().setVisible(true);
                    setVisible(false);
                             
                }
                
            }
            else if(ae.getSource()==b2){
                
                new Transcations().setVisible(true);
                setVisible(false); 
                
            }
            else if(ae.getSource()==b3){
                
                System.exit(0);
                
            }
        }
        catch(Exception e){
                e.printStackTrace();
                System.out.println("error: "+e);
        }
            
    }
    
    public static void main(String[] args){
        new Deposit().setVisible(true);
    }

    
}
