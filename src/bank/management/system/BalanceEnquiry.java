package bank.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;
import java.sql.*;
public class BalanceEnquiry extends JFrame implements ActionListener{
    JButton back;
    String pinnumber;
    
   BalanceEnquiry(String pinnumber){
       this.pinnumber = pinnumber;
       
       setLayout(null);
       
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
         Image i2 = i1.getImage().getScaledInstance(750, 750, Image.SCALE_DEFAULT);
         ImageIcon i3 = new ImageIcon(i2);
         JLabel image =new JLabel(i3);
         image.setBounds(0, 0, 750, 750);
         add(image);
         
         back = new JButton("Back");
         back.setBounds(290, 435, 145, 25);
         back.addActionListener(this);
         image.add(back);
         
         Conn c = new Conn();
         int balance = 0;
            try{
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"' ");
                
                while (rs.next()) {
                  if (rs.getString("type").equals("Deposit"))  {
                      balance += Integer.parseInt(rs.getString("amount"));
                  } else{
                      balance -= Integer.parseInt(rs.getString("amount"));
                  }
                    
                }
            }catch (Exception e){
              System.out.println(e);
            }   
         
            
            JLabel text = new JLabel("Your current Account Balance is Rs "+balance);
            text.setForeground(Color.white);
            text.setBounds(140, 260, 700, 35);
            text.setFont(new Font("System", Font.BOLD,13));

            image.add(text);
            
            
         setSize(750,750);
         setLocation(300, 0);
         setUndecorated(true);
         setVisible(true);
       
   } 
    
   
    @Override
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transcations(pinnumber).setVisible(true);

    }
    public static void main(String[] args) {
      new BalanceEnquiry("");
    }

   
}
