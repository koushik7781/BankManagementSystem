package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {  // Login Frame.Interface.We use swings.JFrames
    
    JButton login, signup, clear;
    JTextField cardTextField;
    JPasswordField PinNo;
      
    Login() {
        setTitle("Automated teller machine");
        setLayout(null);
        
        // getContentPane().setBackground(Color.yellow);
        // BackgroundPanel background = new BackgroundPanel(new ImageIcon(ClassLoader.getSystemResource("icons/back.jpg")).getImage());
        // background.setLayout(null);
        // setContentPane(background);
        
        // ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        // Image i2=i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        // ImageIcon i3= new ImageIcon(i2);
        // JLabel label = new JLabel(i3);
        // label.setBounds(70,10,100,100);
        // add(label);  // But this gives the images all over the frame.To make it fit we should scale the icon.refer Image i2.

        JLabel text = new JLabel("WELCOME TO ATM");
        text.setFont(new Font("OSWARD", Font.BOLD, 38));
        text.setForeground(Color.BLACK);
        text.setBounds(200, 55, 400, 40);
        add(text);
       
        JLabel Cardno = new JLabel("Card No:");
        Cardno.setFont(new Font("RALEWAY", Font.BOLD, 34));
        Cardno.setForeground(Color.BLACK);
        Cardno.setBounds(90, 150, 150, 30);
        add(Cardno);
       
        cardTextField = new JTextField();
        cardTextField.setBounds(250, 150, 230, 30);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 16));
        add(cardTextField);
        
        JLabel Pin = new JLabel("PIN:");
        Pin.setFont(new Font("RALEWAY", Font.BOLD, 34));
        Pin.setBounds(90, 220, 250, 30);  
        Pin.setForeground(Color.BLACK);
        add(Pin);
       
        PinNo = new JPasswordField();
        PinNo.setBounds(250, 220, 230, 30);
        PinNo.setFont(new Font("Arial", Font.BOLD, 16));
        add(PinNo);
       
        /// Now onto Buttons
       
        login = new JButton("SIGN IN");
        login.setBounds(250, 280, 100, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
      
        clear = new JButton("CLEAR");
        clear.setBounds(390, 280, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
      
        signup = new JButton("SIGN UP");
        signup.setBounds(250, 330, 230, 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);
      
        setSize(800, 480);
        setVisible(true);
        setLocation(350, 200);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == clear) {
            cardTextField.setText("");
            PinNo.setText("");
        } else if (ae.getSource() == login) {
            Conn conn = new Conn();
            String cardno = cardTextField.getText();
            String pin = PinNo.getText();  // Corrected variable name to match case.
            String query = "SELECT * FROM loginn WHERE cardno = '"+cardno+"' AND pin = '"+pin+"'";
            try {
                ResultSet rs = conn.s.executeQuery(query);
                if (rs.next()) {
                    setVisible(false);
                    new Transactions(pin).setVisible(true);  // Move inside the if block.
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (ae.getSource() == signup) {
            setVisible(false);
            new Signupone().setVisible(true);
        }
    }

    public static void main(String args[]) {
        new Login();
    }
}

// class BackgroundPanel extends JPanel {
//     private Image backgroundImage;
//
//     public BackgroundPanel(Image backgroundImage) {
//         this.backgroundImage = backgroundImage;               // Background image
//     }
//
//     @Override
//     protected void paintComponent(Graphics g) {
//         super.paintComponent(g);
//         g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
//     }
// }
