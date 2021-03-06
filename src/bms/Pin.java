
package bms;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


@SuppressWarnings("serial")
public class Pin extends JFrame implements ActionListener{
    
    JPasswordField t1,t2,t3;
    JButton b1,b2;                               
    JLabel l1,l2,l3,l4;
    
    Pin(){
        
    	super("PIN CHANGE");
		setSize(852,480);
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
       
        l1 = new JLabel("CHANGE YOUR PIN");
        l1.setFont(new Font("opensans", Font.BOLD, 40));
        
        l2 = new JLabel("Current PIN:");
        l2.setFont(new Font("opensans", Font.BOLD, 22));
        
        l3 = new JLabel("New PIN:");
        l3.setFont(new Font("opensans", Font.BOLD, 22));
        
        l4 = new JLabel("Re-Enter New PIN:");
        l4.setFont(new Font("opensans", Font.BOLD, 22));
        
        t1 = new JPasswordField();
        t1.setFont(new Font("opensans", Font.BOLD, 22));
        
        t2 = new JPasswordField();
        t2.setFont(new Font("opensans", Font.BOLD, 22));
        
        t3 = new JPasswordField();
        t3.setFont(new Font("opensans", Font.BOLD, 22));
        
        b1 = new JButton("SAVE");
        b1.setFont(new Font("opensans", Font.BOLD, 18));
        b1.setBackground(new Color(59, 89, 182));

    
        b2 = new JButton("BACK");
        b2.setFont(new Font("opensans", Font.BOLD, 18));
        b2.setBackground(new Color(59, 89, 182));

        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        
        setLayout(null);
        
        l1.setBounds(200,10,800,60);
        add(l1);
        
        l2.setBounds(80,100,200,40);
        add(l2);
        
        l3.setBounds(80,150,200,40);
        add(l3);
        
        l4.setBounds(80,200,250,40);
        add(l4);
        
        t1.setBounds(310,100,360,40);
        add(t1);
        
        t2.setBounds(310,150,360,40);
        add(t2);
        
        t3.setBounds(310,200,360,40);
        add(t3);
        
        b1.setBounds(220,300,160,50);
        add(b1);
        
        b2.setBounds(400,300,160,50);
        add(b2);
        
        setVisible(true);
    
    }
    
    @SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent ae){
       
        try{        
           
            String a = t1.getText();
            String b = t2.getText();
            @SuppressWarnings({ "unused" })
			String c = t3.getText();
            
            
            
            if(ae.getSource()==b1){
                if(t1.getText().equals("")){
                    
                    JOptionPane.showMessageDialog(null, "Please Enter Current PIN");
                
                }
                if(t2.getText().equals("")){
                    
                    JOptionPane.showMessageDialog(null, "Enter New PIN");
                }
                if (t3.getText().equals("")){
                    
                    JOptionPane.showMessageDialog(null, "Re-Enter new PIN");
                }
                
                if(t2.getText().equals(t3.getText())){
                    
                    conn c1 = new conn();
                    String q1 = "update bank set pin = '"+b+"' where pin = '"+a+"' ";
                    String q2 = "update login set pin = '"+b+"' where pin = '"+a+"' ";
                    String q3 = "update signup3 set pin = '"+b+"' where pin = '"+a+"' ";
                    
                    c1.s.executeUpdate(q1);
                    c1.s.executeUpdate(q2);
                    c1.s.executeUpdate(q3);
                    
                    
                    JOptionPane.showMessageDialog(null, "PIN changed successfully");
                    
                    new Transcations().setVisible(true);
                    setVisible(false);
                    
                }else{
                    
                    JOptionPane.showMessageDialog(null, "PIN entered doesn't match");
                }
                    
                    
                    
                    
                
            }else if(ae.getSource()==b2){
                
                new Transcations().setVisible(true);
                setVisible(false);
                
            }
        }catch(Exception e){
                    e.printStackTrace();
                    System.out.println("error: "+e);
        }
            
    }

    
        
    
    public static void main(String[] args){
        new Pin().setVisible(true);
    }
}
