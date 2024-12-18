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



public class SignupOne extends JFrame implements ActionListener{

    long random;
    JTextField nameJTextField, fnametJTextField, dobtJTextField, emailJTextField, addressJTextField, cityJTextField, stateJTextField, pinJTextField;
    JButton next;
    JRadioButton male, trans,female,other,married,unmarried;
    JDateChooser dateChooser;
    SignupOne() {
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
         //change size of image
         Image i2 =i1.getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT);
         ImageIcon i3 = new ImageIcon(i2);
         JLabel label1 = new JLabel(i3);
        
         //lopcation change of icon
         label1.setBounds(40, 20, 100, 100);
         
         add(label1);
        
        Random ran = new Random();
        long random =(Math.abs(ran.nextLong() % 9000L)+ 1000L);
        
        JLabel formno = new JLabel("APPLICATION FORM NO. " + random);
        formno.setFont(new Font("Raleway",Font.BOLD,38));
        formno.setBounds(140, 20, 600, 40);
        add(formno);
        
        JLabel personDetails = new JLabel("page 1: Personal Details");
        personDetails.setFont(new Font("Raleway",Font.BOLD,22));
        personDetails.setBounds(300, 80, 400, 40);
        add(personDetails);
        
        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100, 140, 200, 30);
        add(name);
        
        nameJTextField = new JTextField();
        nameJTextField.setFont(new Font("raleway",Font.BOLD,14));
        nameJTextField.setBounds(300, 140, 400, 30);
        add(nameJTextField);
        
        
        JLabel fname = new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100, 190, 200, 30);
        add(fname);
        
        fnametJTextField = new JTextField();
        fnametJTextField.setFont(new Font("raleway",Font.BOLD,14));
        fnametJTextField.setBounds(300, 190, 400, 30);
        add(fnametJTextField);
        
        JLabel dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100, 240, 200, 30);
        add(dob);
        
         dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 240, 400, 30);
        dateChooser.setForeground(new Color(200, 200, 200));
        add(dateChooser);
       
        
        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100, 290, 200, 30);
        
        add(gender);
        
         male = new JRadioButton("Male");
        male.setBounds(300, 290, 60, 30);
        male.setBackground(Color.WHITE);
        add(male);
        
         female = new JRadioButton("Female");
        female.setBounds(450, 290, 90, 30);
        female.setBackground(Color.WHITE);
        add(female);
        
        trans = new JRadioButton("Trans gender");
        trans.setBounds(600, 290, 150, 30);
        trans.setBackground(Color.WHITE);
        add(trans);
        
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        
         JLabel email = new JLabel("Email Address:");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100, 340, 200, 30);
        add(email);
        
         emailJTextField = new JTextField();
        emailJTextField.setFont(new Font("raleway",Font.BOLD,14));
        emailJTextField.setBounds(300, 340, 400, 30);
        add(emailJTextField);
        
        
         JLabel marital = new JLabel("Marital Status:");
        marital.setFont(new Font("Raleway",Font.BOLD,20));
        marital.setBounds(100, 390, 200, 30);
        add(marital);
        
         married = new JRadioButton("Married");
        married.setBounds(300, 390, 100, 30);
        married.setBackground(Color.WHITE);
        add(married);
        
         unmarried = new JRadioButton("UnMarried");
        unmarried.setBounds(450, 390, 100, 30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);
        
        other = new JRadioButton("Other");
        other.setBounds(600, 390, 100, 30);
        other.setBackground(Color.WHITE);
        add(other);
        
        ButtonGroup maritelGroup = new ButtonGroup();
        maritelGroup.add(married);
        maritelGroup.add(unmarried);
        maritelGroup.add(other);
        
         JLabel address = new JLabel("Address:");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100, 440, 200, 30);
        add(address);
        
         addressJTextField = new JTextField();
        addressJTextField.setFont(new Font("raleway",Font.BOLD,14));
        addressJTextField.setBounds(300, 440, 400, 30);
        add(addressJTextField);
        
        
         JLabel city = new JLabel("City:");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100, 490, 200, 30);
        add(city);
        
         cityJTextField = new JTextField();
        cityJTextField.setFont(new Font("raleway",Font.BOLD,14));
        cityJTextField.setBounds(300, 490, 400, 30);
        add(cityJTextField);
        
        
         JLabel state = new JLabel("State:");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100, 540, 200, 30);
        add(state);
        
         stateJTextField = new JTextField();
        stateJTextField.setFont(new Font("raleway",Font.BOLD,14));
        stateJTextField.setBounds(300, 540, 400, 30);
        add(stateJTextField);
        
         JLabel pincode = new JLabel("Pincode:");
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(100, 590, 200, 30);
        add(pincode);
        
        pinJTextField = new JTextField();
        pinJTextField.setFont(new Font("raleway",Font.BOLD,14));
        pinJTextField.setBounds(300, 590, 400, 30);
        add(pinJTextField);
        
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
    public void actionperformed(ActionEvent ae){
        
    }
    
     

    @Override
    public void actionPerformed(ActionEvent ae) {
        String formno = ""+ random; //long
        String name= nameJTextField.getText();
        String fname = fnametJTextField.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()){
            gender = "Male";
        }
        else if(female.isSelected()){
            gender = "Female";
        }
        String email = emailJTextField.getText();
        String marital=null;
        if (married.isSelected()){
            marital = "Married";
            
        }
        else if (unmarried.isSelected()){
            marital = "UnMarried";
        }
        else if (other.isSelected()){
            marital = "Other";
        }
        String address = addressJTextField.getText();
        String city = cityJTextField.getText();
        String state = stateJTextField.getText();
        String pin = pinJTextField.getText();
        
        
        try{
          if (name.equals("")) { 
              JOptionPane.showMessageDialog(null, "Name is Required");
              
                   
          }
          
          else if (fname.equals("")) {
                JOptionPane.showMessageDialog(null, "Father Name is Required"); 
            }
          else if (dob.equals("")) {
                JOptionPane.showMessageDialog(null, "Date of Birth is Required is Required"); 
            }
         
          else if (email.equals("")) {
                JOptionPane.showMessageDialog(null, "EMAIL is Required"); 
            }
          
          
          else if (address.equals("")) {
                JOptionPane.showMessageDialog(null, "Address is Required"); 
            }
          else if (city.equals("")) {
                JOptionPane.showMessageDialog(null, "City is Required"); 
            }
              else if (pin.equals("")) {
                JOptionPane.showMessageDialog(null, "PIN is Required"); 
            }
                else if (state.equals("")) {
                JOptionPane.showMessageDialog(null, "State is Required"); 
            }
                

          else {
              Conn c = new Conn();
              String quary = "insert into signup values('"+formno+"', '"+name+"', '"+fname+"', '"+dob+"', '"+gender+"', '"+email+"', '"+marital+"', '"+address+"', '"+city+"', '"+pin+"', '"+state+"')";
              c.s.executeUpdate(quary);
              
              
              new SignupTwo(formno).setVisible(true);
              setVisible(false);
              
          }
        }
        catch(Exception e){
            System.out.println(e);
        }
         }
   
    public static void main(String[] args) {
        new SignupOne();
    }
}
