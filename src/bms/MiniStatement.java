package bms;

import javax.swing.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

@SuppressWarnings("serial")
public class MiniStatement extends JFrame implements ActionListener  {
 
    JTable t1;
    JButton b1;
    String x[] = {"Pin","Deposit","Withdraw","Balance"};
    String y[][] = new String[20][4];
    int i=0, j=0;
    
    MiniStatement() {
        super("Mini Statement");
        setSize(1080,650);
        setLocationRelativeTo(null);
     	String pinn = JOptionPane.showInputDialog("Enter PIN");
     	setLayout(null);

        
        try{
            conn c1  = new conn();
            ResultSet rs = c1.s.executeQuery("SELECT * FROM bank where pin = '"+pinn+"'");
            while(rs.next()){
                y[i][j++]=rs.getString("pin");
                y[i][j++]=rs.getString("deposit");
                y[i][j++]=rs.getString("withdraw");
                y[i][j++]=rs.getString("balance");
                i++;
                j=0;
            }
            t1 = new JTable(y,x);
            
        }catch(Exception e){
            e.printStackTrace();
        }
        JScrollPane sp = new JScrollPane(t1);
        sp.setBounds(10,10,1060,500);
        add(sp);
        

        b1=new JButton("Cancel");   
        b1.setBackground(new Color(59, 89, 182));
        b1.setBounds(900,550,100,50);
        add(b1);
        b1.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent ae){
    	if(ae.getSource() == b1) {
	        try{
                new Transcations().setVisible(true);
                setVisible(false);
                
	        }catch(Exception e){JOptionPane.showMessageDialog(null,"Data not found");}
    	}
    }
    
    public static void main(String[] args){
        new MiniStatement().setVisible(true);
    }
    
}
