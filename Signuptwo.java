package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Signuptwo extends JFrame implements ActionListener {

    JTextField categoryTextField, PanTextField,AadharTextField;
    JButton text;
    JRadioButton Govt,Privatee,Business,Yes,No;
    JComboBox religion,income,Education;
    String formno;

    Signuptwo(String formno) {
        this.formno = formno;
        setLayout(null);
       
       setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        
        JLabel AdditionalDetails = new JLabel("Page 2 : Additional Details");
        AdditionalDetails.setFont(new Font("OSWARD", Font.BOLD, 22));
        AdditionalDetails.setBounds(290, 80, 400, 30);
        add(AdditionalDetails);

        
        //1 Religion Details
        
             JLabel rel = new JLabel("Religion:");
             rel.setFont(new Font("OSWARD", Font.BOLD, 20));
             rel.setBounds(100, 140, 100, 30);
             add(rel);
                
              String valReligion[] = {"Hindu","Muslim","Sikh","Christian","other"};
              religion= new JComboBox(valReligion);
              religion.setBounds(300, 140, 400, 30);
              religion.setBackground(Color.WHITE);
              add(religion);
          
                
                
        //2 Category
                

        JLabel category = new JLabel("Category:");
        category.setFont(new Font("OSWARD", Font.BOLD, 20));
        category.setBounds(100, 190, 200, 30);
        add(category);

            categoryTextField = new JTextField();
            categoryTextField.setBounds(300, 190, 400, 30);
            categoryTextField.setFont(new Font("OSWARD", Font.BOLD, 16));
            add(categoryTextField);

            
        //3 Income
        
            
        JLabel inc = new JLabel("Income:");
        inc.setFont(new Font("OSWARD", Font.BOLD, 20));
        inc.setBounds(100, 240, 200, 30);
        add(inc);

            String incomecategory[] = {"NULL","<5,00,00","<10,00,000","<15,00,000",">15,00,000"};
              income= new JComboBox(incomecategory);
              income.setBounds(300, 240, 400, 30);
              income.setBackground(Color.WHITE);
              add(income);
            
              
              
        //4 Pan card No    
              
              
         JLabel Pancard = new JLabel("Pan Number");
         Pancard.setFont(new Font("OSWARD", Font.BOLD, 20));
         Pancard.setBounds(100, 290, 200, 30);
         add(Pancard);

            PanTextField = new JTextField();
            PanTextField.setBounds(300, 290, 400, 30);
            PanTextField.setFont(new Font("OSWARD", Font.BOLD, 16));
            add(PanTextField);
            
        //5 Aadhar card 
            
         JLabel Aadharcard = new JLabel("Aadhar Number");
         Aadharcard.setFont(new Font("OSWARD", Font.BOLD, 20));
         Aadharcard.setBounds(100, 340, 200, 30);
         add(Aadharcard);

            AadharTextField = new JTextField();
            AadharTextField.setBounds(300, 340, 400, 30);
            AadharTextField.setFont(new Font("OSWARD", Font.BOLD, 16));
            add(AadharTextField);
            
            
        //6 Occupation
        

        JLabel occupation = new JLabel("Occupation:");
        occupation.setFont(new Font("OSWARD", Font.BOLD, 20));
        occupation.setBounds(100, 390, 200, 30);
        add(occupation);

            Govt = new JRadioButton("Government Employee");
            Govt.setBounds(300, 390, 170, 30);
            add(Govt);

            Privatee = new JRadioButton("Private Employee");
            Privatee.setBounds(470, 390, 130, 30);
            add(Privatee);
            
            
            Business = new JRadioButton("Business");
            Business.setBounds(600, 390, 80, 30);
            add(Business);
            
            
            ButtonGroup occupationn = new ButtonGroup();
            occupationn.add(Govt);
            occupationn.add(Privatee);
            occupationn.add(Business);
            
            
            
        //7 Educational Qulification
        
           JLabel EducationalQualification = new JLabel("Educ Qualifications:");
           EducationalQualification.setFont(new Font("OSWARD", Font.BOLD, 20));
           EducationalQualification.setBounds(100, 440, 200, 30);
           add(EducationalQualification);
                
                String valEducationQualification[] = {"Graduate","Post Graduate","Non-Graduation","High School","Doctorate","other"};
                Education= new JComboBox(valEducationQualification);
                Education.setBounds(300, 440, 400, 30);
                Education.setBackground(Color.WHITE);
                add(Education);
        
            
            
         //8 Senior Citizen 
         
            JLabel senior = new JLabel("Senior Citizen:");
            senior.setFont(new Font("OSWARD", Font.BOLD, 20));
            senior.setBounds(100, 490, 200, 30);
            add(senior);

                Yes = new JRadioButton("YES");
                Yes.setBounds(300, 490, 60, 30);
                add(Yes);

                No = new JRadioButton("No");
                No.setBounds(370, 490, 120, 30);
                add(No);


                ButtonGroup Seniorgroup = new ButtonGroup();
                Seniorgroup.add(Yes);
                Seniorgroup.add(No);
            
         //9 Existing Customer

            
            JLabel Existing = new JLabel("Existing Customer:");
            Existing.setFont(new Font("OSWARD", Font.BOLD, 20));
            Existing.setBounds(100, 540, 200, 30);
            add(Existing);

                    Yes = new JRadioButton("YES");
                    Yes.setBounds(300, 540, 60, 30);
                    add(Yes);

                    No = new JRadioButton("No");
                    No.setBounds(370, 540, 120, 30);
                    add(No);


                    ButtonGroup Existinggroup = new ButtonGroup();
                    Existinggroup.add(Yes);
                    Existinggroup.add(No);                
       
         //8 Next Button 

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
        String rel = (String) religion.getSelectedItem();
        String category = categoryTextField.getText();
        String  Aadharcard= AadharTextField.getText();
        String inc = (String) income.getSelectedItem();
        String  Pancard= (String) PanTextField.getText();
        String EducationalQualification = (String) Education.getSelectedItem();
        String occupation = null;
        if(Govt.isSelected()){
            occupation = "Govt Employee";
        }
        else if(Privatee.isSelected()){
            occupation = "Private Employee";
        } else if(Business.isSelected()){
            occupation = "Business";
        }
        String senior = null;
        if (Yes .isSelected()) {
            senior = "Yes";
        } else if (No.isSelected()) {
            senior = "No";
        }
         String Existing = null;
        if (Yes .isSelected()) {
            Existing = "Yes";
        } else if (No.isSelected()) {
            Existing = "No";
        }

        try {
                Conn c = new Conn(); 
                String query1 = "insert into signuponee values('" + formno + "','" + category + "','" + rel + "', '" + inc + "', '" + EducationalQualification + "', '" + occupation + "', '" + Pancard + "', '" + Aadharcard + "', '" + Existing  + "')";
                c.s.executeUpdate(query1);
                
                setVisible(false);
                new SignupThree(formno).setVisible(true);
                
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new Signuptwo("");
    }
}
