package bms;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;



@SuppressWarnings("serial")
public class FastCash extends JFrame implements ActionListener{

    JLabel l1,l2;
    JButton b1,b2,b3,b4,b5,b6,b7,b8;
    JTextField t1;
    
    FastCash(){
        
    	super("FAST CASH");
    	setSize(800,800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
   
        
        l1 = new JLabel("SELECT WITHDRAWL AMOUNT");
        l1.setFont(new Font("opensans", Font.BOLD, 40));
        
        l2 = new JLabel("Enter PIN");
        l2.setFont(new Font("opensans", Font.BOLD, 20));
        
        t1 = new JTextField();
        t1.setFont(new Font("opensans", Font.BOLD, 20));
    
       
        b1 = new JButton("Rs 100");
        b1.setFont(new Font("opensans", Font.BOLD, 20));
        b1.setBackground(new Color(59, 89, 182));

    
        b2 = new JButton("Rs 500");
        b2.setFont(new Font("opensans", Font.BOLD, 20));
        b2.setBackground(new Color(59, 89, 182));

        
        b3 = new JButton("Rs 1000");
        b3.setFont(new Font("opensans", Font.BOLD, 20));
        b3.setBackground(new Color(59, 89, 182));

        
        b4 = new JButton("Rs 2000");
        b4.setFont(new Font("opensans", Font.BOLD, 20));
        b4.setBackground(new Color(59, 89, 182));
  
        
        b5 = new JButton("Rs 5000");
        b5.setFont(new Font("opensans", Font.BOLD, 20));
        b5.setBackground(new Color(59, 89, 182));

        
        b6 = new JButton("Rs 10000");
        b6.setFont(new Font("opensans", Font.BOLD, 20));
        b6.setBackground(new Color(59, 89, 182));

        
        b7 = new JButton("BACK");
        b7.setFont(new Font("opensans", Font.BOLD, 20));
        b7.setBackground(new Color(59, 89, 182));

        
        b7 = new JButton("EXIT");
        b7.setFont(new Font("opensans", Font.BOLD, 20));
        b7.setBackground(new Color(59, 89, 182));

        
        
        setLayout(null);
        
        l2.setBounds(270,10,120,50);
        add(l2);
        
        t1.setBounds(380,10,120,40);
        add(t1);
        
        l1.setBounds(80,100,700,40);
        add(l1);
        
        b1.setBounds(40,250,300,60);
        add(b1);
        
        b2.setBounds(440,250,300,60);
        add(b2);
        
        b3.setBounds(40,360,300,60);
        add(b3);
        
        b4.setBounds(440,360,300,60);
        add(b4);
        
        b5.setBounds(40,470,300,60);
        add(b5);
        
        b6.setBounds(440,470,300,60);
        add(b6);
        
        b7.setBounds(240,600,300,60);
        add(b7);
        
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        
        
        setVisible(true);
        
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
       
            try{        
           
            String a = t1.getText();
            double balance = 0;
            
            if(ae.getSource()==b1){
                
                    conn c1 = new conn();
                    
                    ResultSet rs = c1.s.executeQuery(" select * from bank where pin = '"+a+"' ");
                    
                    
                    if(rs.next()){
                        String pin = rs.getString("pin");
                        while(rs.next()) {
                        balance = rs.getDouble("balance");
                        }
                        balance-=100;
                        if(balance > 0) {
                        String q1= "insert into bank values('"+pin+"',null,100,'"+balance+"')";
                        c1.s.executeUpdate(q1);
                        JOptionPane.showMessageDialog(null, "Rs. "+100+" Debited Successfully");
                        new Transcations().setVisible(true);
                        setVisible(false);
                        }
                        
                        else {
                        	JOptionPane.showMessageDialog(null, "Insufficient Balance");
                        }
                        
                    }             
                    
            }
                
            
            else if(ae.getSource()==b2){
                
                    conn c1 = new conn();
                    
                    ResultSet rs = c1.s.executeQuery(" select * from bank where pin = '"+a+"' ");
                    
                    
                    if(rs.next()){
                        String pin = rs.getString("pin");
                        
                        while(rs.next()) {
                            balance = rs.getDouble("balance");
                            }
                     
                        balance-=500;
                        String q1= "insert into bank values('"+pin+"',null,500,'"+balance+"')";
                    
                        c1.s.executeUpdate(q1);
                    }
                    
                    
                    
                    JOptionPane.showMessageDialog(null, "Rs. "+500+" Debited Successfully");
                    
                    new Transcations().setVisible(true);
                    setVisible(false);
                    
                    
                    
                }
            else if(ae.getSource()==b3){
                
                    conn c1 = new conn();
                    
                    ResultSet rs = c1.s.executeQuery(" select * from bank where pin = '"+a+"' ");
                    
                    
                    if(rs.next()){
                        String pin = rs.getString("pin");
                        
                        while(rs.next()) {
                            balance = rs.getDouble("balance");
                            }
                     
                        balance-=1000;
                        String q1= "insert into bank values('"+pin+"',null,1000,'"+balance+"')";
                    
                        c1.s.executeUpdate(q1);
                    }
                    
                    
                    
                    JOptionPane.showMessageDialog(null, "Rs. "+1000+" Debited Successfully");
                    
                    new Transcations().setVisible(true);
                    setVisible(false);
                    
                    
                    
                }
            else if(ae.getSource()==b4){
                
                    conn c1 = new conn();
                    
                    ResultSet rs = c1.s.executeQuery(" select * from bank where pin = '"+a+"' ");
                    
                    
                    if(rs.next()){
                        String pin = rs.getString("pin");
                        
                        while(rs.next()) {
                            balance = rs.getDouble("balance");
                            }
                     
                        balance-=2000;
                        String q1= "insert into bank values('"+pin+"',null,2000,'"+balance+"')";
                    
                        c1.s.executeUpdate(q1);
                    }
                    
                    
                    
                    JOptionPane.showMessageDialog(null, "Rs. "+2000+" Debited Successfully");
                    
                    new Transcations().setVisible(true);
                    setVisible(false);
                    
                    
                    
                }
            else if(ae.getSource()==b5){
                
                    conn c1 = new conn();
                    
                    ResultSet rs = c1.s.executeQuery(" select * from bank where pin = '"+a+"' ");
                    
                    
                    if(rs.next()){
                        String pin = rs.getString("pin");
                        
                        while(rs.next()) {
                            balance = rs.getDouble("balance");
                            };
                     
                        balance-=5000;
                        String q1= "insert into bank values('"+pin+"',null,5000,'"+balance+"')";
                    
                        c1.s.executeUpdate(q1);
                    }
                    
                    
                    
                    JOptionPane.showMessageDialog(null, "Rs. "+5000+" Debited Successfully");
                    
                    new Transcations().setVisible(true);
                    setVisible(false);
                    
                    
                    
                }
            else if(ae.getSource()==b6){
                
                    conn c1 = new conn();
                    
                    ResultSet rs = c1.s.executeQuery(" select * from bank where pin = '"+a+"' ");
                    
                    
                    if(rs.next()){
                        String pin = rs.getString("pin");
                        
                        while(rs.next()) {
                            balance = rs.getDouble("balance");
                            }
                     
                        balance-=10000;
                        String q1= "insert into bank values('"+pin+"',null,10000,'"+balance+"')";
                    
                        c1.s.executeUpdate(q1);
                    }
                    
                    
                    
                    JOptionPane.showMessageDialog(null, "Rs. "+10000+" Debited Successfully");
                    
                    new Transcations().setVisible(true);
                    setVisible(false);
                    
                    
                    
                }
                
            
            else if(ae.getSource()==b7){
                
                System.exit(0);
                
            }
        }catch(Exception e){
                e.printStackTrace();
                System.out.println("error: "+e);
        }
            
    }

    
    public static void main(String[] args){
        new FastCash().setVisible(true);
    }
}