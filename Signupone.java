package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class Signupone extends JFrame implements ActionListener {

    long random;
    JTextField nameTextField, FnameTextField, EmailTextField, AddressTextField, PincodeTextField, StateTextField, CityTextField;
    JButton text;
    JRadioButton male, Female, married, unmarried, Other;
    JDateChooser datechooser;

    Signupone() {
        setLayout(null);

        Random ran = new Random();
        random = Math.abs((ran.nextInt() % 9000L) + 1000L);

        getContentPane().setBackground(Color.WHITE);

        JLabel formno = new JLabel("Application Form No" + " " + random);
        formno.setFont(new Font("OSWARD", Font.BOLD, 38));
        formno.setBounds(140, 20, 600, 40);
        add(formno);
        
        
        //1 Personal Details

        
        JLabel PersonalDetails = new JLabel("Page 1 : Personal Details");
        PersonalDetails.setFont(new Font("OSWARD", Font.BOLD, 22));
        PersonalDetails.setBounds(290, 80, 400, 30);
        add(PersonalDetails);

             JLabel name = new JLabel("Name:");
             name.setFont(new Font("OSWARD", Font.BOLD, 20));
             name.setBounds(100, 140, 100, 30);
             add(name);

                nameTextField = new JTextField();
                nameTextField.setBounds(300, 140, 400, 30);
                nameTextField.setFont(new Font("OSWARD", Font.BOLD, 16));
                add(nameTextField);
                
                
        //2 Fathers name
                

        JLabel fname = new JLabel("Father's Name:");
        fname.setFont(new Font("OSWARD", Font.BOLD, 20));
        fname.setBounds(100, 190, 200, 30);
        add(fname);

            FnameTextField = new JTextField();
            FnameTextField.setBounds(300, 190, 400, 30);
            FnameTextField.setFont(new Font("OSWARD", Font.BOLD, 16));
            add(FnameTextField);

            
        //3 Date of birth
        
            
        JLabel dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("OSWARD", Font.BOLD, 20));
        dob.setBounds(100, 240, 200, 30);
        add(dob);

            datechooser = new JDateChooser();
            datechooser.setBounds(300, 240, 400, 30);
            datechooser.setForeground(Color.BLACK);
            add(datechooser);
            
            
        //4 Gender
        

        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("OSWARD", Font.BOLD, 20));
        gender.setBounds(100, 290, 200, 30);
        add(gender);

            male = new JRadioButton("MALE");
            male.setBounds(300, 290, 60, 30);
            male.setBackground(Color.WHITE);
            add(male);

            Female = new JRadioButton("FEMALE");
            Female.setBounds(450, 290, 120, 30);
            Female.setBackground(Color.WHITE);
            add(Female);

            ButtonGroup gendergroup = new ButtonGroup();
            gendergroup.add(male);
            gendergroup.add(Female);
            
            
        //5 Email Address
        
            
        JLabel Email = new JLabel("Enter your Email:");
        Email.setFont(new Font("OSWARD", Font.BOLD, 20));
        Email.setBounds(100, 340, 200, 30);
        add(Email);

            EmailTextField = new JTextField();
            EmailTextField.setBounds(300, 340, 400, 30);
            EmailTextField.setFont(new Font("OSWARD", Font.BOLD, 16));
            add(EmailTextField);

            
         //6 Marital Status
            
         
        JLabel MaritalStatus = new JLabel("Marital Status:");
        MaritalStatus.setFont(new Font("OSWARD", Font.BOLD, 20));
        MaritalStatus.setBounds(100, 390, 200, 30);
        add(MaritalStatus);

                married = new JRadioButton("MARRIED");
                married.setBounds(300, 390, 100, 30);
                married.setBackground(Color.WHITE);
                add(married);

                unmarried = new JRadioButton("UNMARRIED");
                unmarried.setBounds(450, 390, 100, 30);
                unmarried.setBackground(Color.WHITE);
                add(unmarried);

                Other = new JRadioButton("OTHERS");
                Other.setBounds(630, 390, 100, 30);
                Other.setBackground(Color.WHITE);
                add(Other);

                ButtonGroup Maritalstatus = new ButtonGroup();
                Maritalstatus.add(married);
                Maritalstatus.add(unmarried);
                Maritalstatus.add(Other);
        
                
         //7 Address 
                
        JLabel Address = new JLabel("Address:");
        Address.setFont(new Font("OSWARD", Font.BOLD, 20));
        Address.setBounds(100, 440, 200, 30);
        add(Address);

                AddressTextField = new JTextField();
                AddressTextField.setBounds(300, 440, 400, 30);
                AddressTextField.setFont(new Font("OSWARD", Font.BOLD, 16));
                add(AddressTextField);

                
        //8 City 
        
        
        
        JLabel City = new JLabel("City:");
        City.setFont(new Font("OSWARD", Font.BOLD, 20));
        City.setBounds(100, 490, 200, 30);
        add(City);

                CityTextField = new JTextField();
                CityTextField.setBounds(300, 490, 400, 30);
                CityTextField.setFont(new Font("OSWARD", Font.BOLD, 16));
                add(CityTextField);
                
         //9 State 
         
         
         
        JLabel State = new JLabel("State:");
        State.setFont(new Font("OSWARD", Font.BOLD, 20));
        State.setBounds(100, 540, 200, 30);
        add(State);

                StateTextField = new JTextField();
                StateTextField.setBounds(300, 540, 400, 30);
                StateTextField.setFont(new Font("OSWARD", Font.BOLD, 16));
                add(StateTextField);

         //10 Pincode 
         
         
        JLabel Pincode = new JLabel("Pincode:");
        Pincode.setFont(new Font("OSWARD", Font.BOLD, 20));
        Pincode.setBounds(100, 590, 200, 30);
        add(Pincode);

                PincodeTextField = new JTextField();
                PincodeTextField.setBounds(300, 590, 400, 30);
                PincodeTextField.setFont(new Font("OSWARD", Font.BOLD, 16));
                add(PincodeTextField);

         //11 Next Button 

            text = new JButton("Next");
            text.setBackground(Color.BLACK);
            text.setForeground(Color.WHITE);
            text.setFont(new Font("OSWARD", Font.BOLD, 14));
            text.setBounds(620, 660, 70, 30);
            text.addActionListener(this);
            add(text);

        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String formno = "" + random;
        String name = nameTextField.getText();
        String Fname = FnameTextField.getText();
        String dob = ((JTextField) datechooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if (male.isSelected()) {
            gender = "Male";
        } else if (Female.isSelected()) {
            gender = "Female";
        }

        String Email = EmailTextField.getText();
        String MaritalStatus = null;
        if (married.isSelected()) {
            MaritalStatus = "Married";
        } else if (unmarried.isSelected()) {
            MaritalStatus = "Unmarried";
        } else if (Other.isSelected()) {
            MaritalStatus = "Other";
        }

        String Address = AddressTextField.getText();
        String City = CityTextField.getText();
        String State = StateTextField.getText();
        String Pincode = PincodeTextField.getText();

        try {
            if (name.equals("") || Fname.equals("") || dob.equals("")  || Email.equals("") || Address.equals("") || City.equals("") || State.equals("") ||Pincode.equals("")) {
                JOptionPane.showMessageDialog(null, "Required Fields Missing");
            } else {
                Conn c = new Conn();
                String query = "insert into signup values('" + formno + "', '" + name + "', '" + Fname + "', '" + dob + "', '" + gender + "', '" + Email + "', '" + MaritalStatus + "', '" + Address + "', '" + City + "', '" + Pincode + "', '" + State + "')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new Signuptwo(formno).setVisible(true);
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new Signupone();
    }
}
