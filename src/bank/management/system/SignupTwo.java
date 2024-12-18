package bank.management.system;


import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.demo.DateChooserPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.util.Random;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;



public class SignupTwo extends JFrame implements ActionListener{

    long random;
    JTextField pan, aadhar;
    JButton next;
    JRadioButton syes, sno, eyes, eno;
  
    JComboBox religion,category,occuption,education,income;
    String formno;
    SignupTwo(String form) {
        this.formno = formno;
        setLayout(null);
        
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
         //change size of image
         Image i2 =i1.getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT);
         ImageIcon i3 = new ImageIcon(i2);
         JLabel label1 = new JLabel(i3);
        
         //lopcation change of icon
         label1.setBounds(160, 20, 100, 100);
         
         add(label1);
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
        
        
        JLabel additionalDetails = new JLabel("page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        additionalDetails.setBounds(290, 50, 400, 40);
        add(additionalDetails);
        
        JLabel religion1 = new JLabel("Religion:");
        religion1.setFont(new Font("Raleway",Font.BOLD,20));
        religion1.setBounds(100, 140, 200, 30);
        add(religion1);
        
        String valReligion[] = {"Hindu","Muslim","Christen","Sikh","Other"};
         religion = new JComboBox(valReligion);
        religion.setFont(new Font("raleway",Font.BOLD,14));
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.white);
        add(religion);
        
        
        
        
        
        
        JLabel category1 = new JLabel("Category:");
        category1.setFont(new Font("Raleway",Font.BOLD,20));
        category1.setBounds(100, 190, 200, 30);
        add(category1);
        
        String valcategory[] = {"General", "OBC", "SC", "ST",  "Other"};
        category = new JComboBox(valcategory);
        category.setBounds(300, 190, 400, 30);
        category.setBackground(Color.white);
        add(category);
        
        
        
        JLabel income1 = new JLabel("Income:");
        income1.setFont(new Font("Raleway",Font.BOLD,20));
        income1.setBounds(100, 240, 200, 30);
        add(income1);
        
        String incomecategory[] = {"Null", "<1,50,000", "<2,50,000", "<5,00,000",  "<10,00,000"  };
        income = new JComboBox(incomecategory);
        income.setBounds(300, 240, 400, 30);
        income.setBackground(Color.white);
        add(income);
        
        
       
        
        JLabel education1 = new JLabel("Educational");
        education1.setFont(new Font("Raleway",Font.BOLD,20));
        education1.setBounds(100, 290, 200, 30);
        add(education1);
        
        
        
         JLabel qualification1 = new JLabel("Qualification:");
        qualification1.setFont(new Font("Raleway",Font.BOLD,20));
        qualification1.setBounds(100, 310, 200, 30);
        add(qualification1);
        
        String educationlavel[] = {"Non-Graduation", "Graduate", "Post-Graduation", "Doctrate",  "Other"  };
         education = new JComboBox(educationlavel);
        education.setBounds(300, 315, 400, 30);
        education.setBackground(Color.white);
        add(education);
        
        
        
        
         JLabel occuption1 = new JLabel("Occuption:");
        occuption1.setFont(new Font("Raleway",Font.BOLD,20));
        occuption1.setBounds(100, 390, 200, 30);
        add(occuption1);
        
        String occuptionvalues[] = {"Salarized", "self-Employee", "Bussiness", "Student",  "Retired" , "Other"  };
         occuption = new JComboBox(occuptionvalues);
        occuption.setBounds(300, 390, 400, 30);
        occuption.setBackground(Color.white);
        add(occuption);
        
         
        
        
        
         JLabel pan1 = new JLabel("PAN Number:");
        pan1.setFont(new Font("Raleway",Font.BOLD,20));
        pan1.setBounds(100, 440, 200, 30);
        add(pan1);
        
         pan = new JTextField();
        pan.setFont(new Font("raleway",Font.BOLD,14));
        pan.setBounds(300, 440, 400, 30);
        add(pan);
        
        
         JLabel aadhar1 = new JLabel("Aadhar Number:");
        aadhar1.setFont(new Font("Raleway",Font.BOLD,20));
        aadhar1.setBounds(100, 490, 200, 30);
        add(aadhar1);
        
         aadhar = new JTextField();
        aadhar.setFont(new Font("raleway",Font.BOLD,14));
        aadhar.setBounds(300, 490, 400, 30);
        add(aadhar);
        
        
         JLabel seniorcitizen1 = new JLabel("Senior Citizen:");
        seniorcitizen1.setFont(new Font("Raleway",Font.BOLD,20));
        seniorcitizen1.setBounds(100, 540, 200, 30);
        add(seniorcitizen1);
        
        syes = new JRadioButton("yes");
        syes.setBounds(300, 540, 100, 30);
        syes.setBackground(Color.WHITE);
        add(syes);
        
        sno = new JRadioButton("No");
        sno.setBounds(450, 540, 100, 30);
        sno.setBackground(Color.WHITE);
        add(sno);
        
         ButtonGroup occu = new ButtonGroup();
        occu.add(syes);
        occu.add(sno);
       
        
         JLabel existingaccount1 = new JLabel("Existing Account:");
        existingaccount1.setFont(new Font("Raleway",Font.BOLD,20));
        existingaccount1.setBounds(100, 590, 200, 30);
        add(existingaccount1);
        
        eyes = new JRadioButton("yes");
        eyes.setBounds(300, 590, 100, 30);
        eyes.setBackground(Color.white);
        add(eyes);
        
        eno = new JRadioButton("No");
        eno.setBounds(450, 590, 100, 30);
        eno.setBackground(Color.white);
        add(eno);
        
         ButtonGroup existingaccount = new ButtonGroup();
        existingaccount.add(eyes);
        existingaccount.add(eno);
        
        
        
         next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.white);
        next.setFont(new Font("raleway",Font.BOLD,14));
        next.setBounds(620, 625, 80, 30);
        next.addActionListener(this);
        add(next);
        
        
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(900, 900);
        setLocation(350, 10);
        setVisible(true);
    }
    
    
     

    @Override
    public void actionPerformed(ActionEvent ae) {
        String formno = ""; //long
        String sreligion= (String)religion.getSelectedItem();
        String scategory = (String)category.getSelectedItem();
        String sincome = (String)income.getSelectedItem();
        String seducation = (String)education.getSelectedItem();
        String soccuption = (String)occuption.getSelectedItem();
       
        String seniorcitizen = null;
        if(syes.isSelected()){
            seniorcitizen = "yes";
        }
        else if(sno.isSelected()){
            seniorcitizen = "No";
        }
        
        String existingaccount=null;
        if (eyes.isSelected()){
            existingaccount = "Yes";
            
        }
        else if (eno.isSelected()){
            existingaccount = "No";
        }
       
        
        String span = pan.getText();
        String saadhar = aadhar.getText();
       
        
        
        try{
            Conn c = new Conn();
            String quary = "insert into signuptwo values('"+formno+"', '"+sreligion+"', '"+scategory+"', '"+sincome+"', '"+seducation+"', '"+soccuption+"', '"+span+"', '"+saadhar+"', '"+seniorcitizen+"', '"+existingaccount+"')";
            c.s.executeUpdate(quary);
            
            setVisible(false);
            new Signupthree(formno).setVisible(true);
            
            //signup3 object
        }
        catch(Exception e){
            System.out.println(e);
        }
         }
   
    public static void main(String[] args) {
        new SignupTwo("");
      
    }
}
