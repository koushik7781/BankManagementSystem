
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class Withdrawl extends JFrame implements ActionListener{
    JButton withdraw ,Back;
    JTextField amount;
    JLabel text ;
    String pin;
   
    
    Withdrawl(String pin){
        this.pin = pin;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        
        text = new JLabel("Enter the amount you want to Withdraw:");
        text.setBounds(170,300,400,20);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        
            amount = new JTextField();
            amount.setFont(new Font("Raleway",Font.BOLD,22));
            amount.setBounds(170,350,320,25);
            image.add(amount);
        
            
             withdraw = new JButton("Withdrawl");
             withdraw.setBounds(355,485,150,30);
             withdraw.addActionListener(this);
             image.add(withdraw);

             Back = new JButton("Back");
             Back.setBounds(355,520,150,30);
             Back.addActionListener(this);
             image.add(Back);
        
        
        
        setSize(900, 900);
        setLocation(300, 0);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == withdraw){
            String number = amount.getText();
            Date date = new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter the amount you want to Withdraw");
                
            }else {
                try {
                    Conn conn = new Conn();
                String query = "Insert into bank values ('"+pin+"','"+date+"','Withdrawl','"+number+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs "+number+ "Withdraw Success");
                setVisible(false);
                new Transactions(pin).setVisible(true);
                }catch(Exception e){
                    System.out.println(e);
                }
               
                
            }
        }else if(ae.getSource()== Back){
            setVisible(false);
            new Transactions(pin).setVisible(true);
        }
    }
    public static void main(String args[]){
        new Withdrawl("");
    }
}
