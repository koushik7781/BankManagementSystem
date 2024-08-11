package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener {
    JButton deposit,Fastcash,PinChange,CashWithdrawl,Ministatement,Balanceenquiry,exit;
    JLabel info;
    
    String pin;
    Transactions (String pin){
         this.pin = pin;
         setLayout(null);
         
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
         Image i2=i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
         ImageIcon i3= new ImageIcon(i2);
         JLabel image = new JLabel(i3);
         image.setBounds(0,0,900,900);
         add(image); 
         
             info = new JLabel("Enter the type of transacation:");
             info.setFont(new Font("OSWARD", Font.BOLD, 20));
             info.setBounds(200, 280, 700, 35);
             info.setForeground(Color.WHITE);
             image.add(info);
             
             
           //1 Deposit button 
          
                    deposit = new JButton("Deposit");
                    deposit.setBounds(150,390,185,25);
                    deposit.addActionListener(this);
                    deposit.setFont(new Font("OSWARD",Font.ITALIC,15));
                    image.add(deposit);
          
            
            //2 Fast Cash
            
                    Fastcash = new JButton("Fast Cash");
                    Fastcash.setBounds(150,425,185,25);
                    Fastcash.setFont(new Font("OSWARD",Font.ITALIC,15));
                    Fastcash.addActionListener(this);
                    image.add(Fastcash);
            
            
            //3 PinChange
            
            
                    PinChange = new JButton("PinChange");
                    PinChange.setBounds(150,460,185,25);
                    PinChange.setFont(new Font("OSWARD",Font.ITALIC,15));
                    PinChange.addActionListener(this);
                    image.add(PinChange);
            
            //4 CashWithdrawl 
                    
                  
                    CashWithdrawl = new JButton("Cash Withdrawl");
                    CashWithdrawl.setBounds(150,495,185,25);
                    CashWithdrawl.setFont(new Font("OSWARD",Font.ITALIC,15));
                    CashWithdrawl.addActionListener(this);
                    image.add(CashWithdrawl);
            
            
            //5 Mini Statement 
            
                    Ministatement = new JButton("Ministatement");
                    Ministatement.setBounds(350,390,160,25);
                    Ministatement.setFont(new Font("OSWARD",Font.ITALIC,15));
                    Ministatement.addActionListener(this);
                    image.add(Ministatement);
                    
            //6 Balance enquiry 
            
                    Balanceenquiry = new JButton("BalanceEnquiry");
                    Balanceenquiry.setBounds(350,425,160,25);
                    Balanceenquiry.setFont(new Font("OSWARD",Font.ITALIC,15));
                    Balanceenquiry.addActionListener(this);
                    image.add(Balanceenquiry);
                    
            //7  Exit 
            
                    exit = new JButton("Exit");
                    exit.setBounds(350,460,160,25);
                    exit.setFont(new Font("OSWARD",Font.ITALIC,15));
                    exit.addActionListener(this);
                    image.add(exit);
            
            
         
        setSize(900, 900);
        setLocation(300, 0);
        setVisible(true);
        setUndecorated(true); // It is particularly useful when you want to design a window with a unique appearance Like custom Dialog boxes

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == exit){
            System.exit(0);
        }else if(ae.getSource() == deposit){
            setVisible(false);
            new Deposit(pin).setVisible(true);
        }else if(ae.getSource() == CashWithdrawl){
            setVisible(false);
            new Withdrawl(pin).setVisible(true);
        }else if(ae.getSource() == Fastcash){
            setVisible(false);
            new FastCash(pin).setVisible(true);
        }else if(ae.getSource() == PinChange){
            setVisible(false);
            new PinChange(pin).setVisible(true);
        }else if(ae.getSource() == Balanceenquiry ){
            setVisible(false);
            new BalanceEnquiry(pin).setVisible(true);
        }else if(ae.getSource() == Ministatement){
            new MiniStatement(pin).setVisible(true);
        }
    }
    
    public static void main(String args[]){
        new Transactions("");
    }
}

