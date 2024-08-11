package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {
    JButton deposit, Fastcash, PinChange, CashWithdrawl, Ministatement, Balanceenquiry, exit;
    JLabel info;
    
    String pin;
    FastCash(String pin) {
        this.pin = pin;
        setLayout(null);
         
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image); 
         
        info = new JLabel("Select Withdrawl Amount:");
        info.setFont(new Font("OSWARD", Font.BOLD, 20));
        info.setBounds(200, 280, 700, 35);
        info.setForeground(Color.WHITE);
        image.add(info);
             
        // 1. Deposit button 
        deposit = new JButton("Rs 100");
        deposit.setBounds(150, 390, 185, 25);
        deposit.addActionListener(this);
        deposit.setFont(new Font("OSWARD", Font.ITALIC, 15));
        image.add(deposit);
          
        // 2. Fast Cash
        Fastcash = new JButton("Rs 500");
        Fastcash.setBounds(150, 425, 185, 25);
        Fastcash.setFont(new Font("OSWARD", Font.ITALIC, 15));
        Fastcash.addActionListener(this);
        image.add(Fastcash);
            
        // 3. Pin Change
        PinChange = new JButton("Rs 1000");
        PinChange.setBounds(150, 460, 185, 25);
        PinChange.setFont(new Font("OSWARD", Font.ITALIC, 15));
        PinChange.addActionListener(this);
        image.add(PinChange);
            
        // 4. Cash Withdrawal
        CashWithdrawl = new JButton("Rs 2000");
        CashWithdrawl.setBounds(150, 495, 185, 25);
        CashWithdrawl.setFont(new Font("OSWARD", Font.ITALIC, 15));
        CashWithdrawl.addActionListener(this);
        image.add(CashWithdrawl);
            
        // 5. Mini Statement
        Ministatement = new JButton("Rs 5000");
        Ministatement.setBounds(350, 390, 160, 25);
        Ministatement.setFont(new Font("OSWARD", Font.ITALIC, 15));
        Ministatement.addActionListener(this);
        image.add(Ministatement);
                    
        // 6. Balance Enquiry
        Balanceenquiry = new JButton("Rs 10000");
        Balanceenquiry.setBounds(350, 425, 160, 25);
        Balanceenquiry.setFont(new Font("OSWARD", Font.ITALIC, 15));
        Balanceenquiry.addActionListener(this);
        image.add(Balanceenquiry);
                    
        // 7. Exit
        exit = new JButton("Back");
        exit.setBounds(350, 460, 160, 25);
        exit.setFont(new Font("OSWARD", Font.ITALIC, 15));
        exit.addActionListener(this);
        image.add(exit);
            
        setSize(900, 900);
        setLocation(300, 0);
        setVisible(true);
        setUndecorated(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == exit) {
            setVisible(false);
            new Transactions(pin).setVisible(true);
        } else {
            String amount = ((JButton)ae.getSource()).getText().substring(3); // Rs 500
            Conn c = new Conn();
            try {
                ResultSet rs = c.s.executeQuery("Select * from bank where pin = '" + pin + "'");
                int balance = 0;
                while (rs.next()) {
                    if (rs.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if (ae.getSource() != exit && balance < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null, "Insufficient balance");
                    return;
                }
                Date date = new Date();
                String query = "insert into bank values('" + pin + "','" + date + "','Withdrawl','" + amount + "')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs " + amount + " Debited Successfully");
                   
                setVisible(false);
                new Transactions(pin).setVisible(true);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    } // <-- Added closing curly brace here

    public static void main(String[] args) {
        new FastCash("");
    }
}

