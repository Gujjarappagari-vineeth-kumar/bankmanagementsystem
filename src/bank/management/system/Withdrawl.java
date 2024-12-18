package bank.management.system;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Withdrawl extends JFrame implements ActionListener{
    JButton withdraw,back;
    String pinnumber;
    JTextField amount;

     Withdrawl(String pinnumber) {
        this.pinnumber = pinnumber;
        
        setLayout(null);
        
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
         Image i2 = i1.getImage().getScaledInstance(750, 750, Image.SCALE_DEFAULT);
         ImageIcon i3 = new ImageIcon(i2);
         JLabel image =new JLabel(i3);
         image.setBounds(0, 0, 750, 750);
         add(image);
         
         JLabel text = new JLabel("Enter the Amount you Want to Withdraw");
         text.setBounds(130, 240, 700, 35);
         text.setForeground(Color.WHITE);
         text.setFont(new Font("System", Font.BOLD,16));
         image.add(text);
         
          amount = new JTextField();
         amount.setFont(new Font("Raleway",Font.BOLD,22));
         amount.setBounds(130, 290, 300, 25);
         image.add(amount);
         
         
         
          withdraw = new JButton("Withdraw");
         withdraw.setBounds(290, 405, 145, 25);
         withdraw.addActionListener(this);
         image.add(withdraw);
         
          back = new JButton("Back");
         back.setBounds(290, 435, 145, 25);
         back.addActionListener(this);
         image.add(back);
         
        setSize(750,750);
         setLocation(300, 0);
         setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == withdraw){
           String number = amount.getText();
           Date date = new Date();
           if (number.equals("")){
               
               JOptionPane.showMessageDialog(null, "Please enter the amount you want to Withdraw");
               
           }
           else{
               try{
                Conn conn = new Conn();
               String quary = "insert into bank values('"+pinnumber+"', '"+date+"', 'withdraw','"+number+"')";
               conn.s.executeUpdate(quary);
               JOptionPane.showMessageDialog(null, "Rs "+number+" Deposited Successfully");
                   setVisible(false);
                   new Transcations(pinnumber).setVisible(true);
               }
               catch(Exception e){
                   System.out.println(e);
               }
           }
        }else if(ae.getSource() == back) {
            setVisible(false);
            new Transcations(pinnumber).setVisible(true);
        }
         }
    
    public static void main(String[] args) {
        new Withdrawl("");
    }

    
}