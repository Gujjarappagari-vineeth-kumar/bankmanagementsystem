
package bank.management.system;

import com.mysql.cj.protocol.Resultset;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Date;


public class FastCash extends JFrame implements ActionListener{
    
    JButton deposit,fastcash,withdrawal,ministstement,balenceenquiry,pinchange,exit;
    String pinnumber;
    FastCash(String pinnumber){
        this.pinnumber = pinnumber;
        
        setLayout(null);
        
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
         Image i2 = i1.getImage().getScaledInstance(750, 750, Image.SCALE_DEFAULT);
         ImageIcon i3 = new ImageIcon(i2);
         JLabel image =new JLabel(i3);
         image.setBounds(0, 0, 750, 750);
         add(image);
         
         JLabel text = new JLabel("Select Withdrawal Amount");
         text.setBounds(170, 230, 700, 35);
         text.setForeground(Color.WHITE);
         text.setFont(new Font("System", Font.BOLD,16));
         image.add(text);
         
          deposit = new JButton("Rs 100");
         deposit.setBounds(130, 345, 120, 25);
         deposit.addActionListener(this);
         image.add(deposit);
         
          withdrawal = new JButton("Rs 500");
         withdrawal.setBounds(290, 345, 145, 25);
         withdrawal.addActionListener(this);
         image.add(withdrawal);
         
          fastcash = new JButton("Rs 1000");
         fastcash.setBounds(130, 375, 120, 25);
         fastcash.addActionListener(this);
         image.add(fastcash);
         
          ministstement = new JButton("Rs 2000");
         ministstement.setBounds(290, 375, 145, 25);
         ministstement.addActionListener(this);
         image.add(ministstement);
         
          pinchange = new JButton("Rs 5000");
         pinchange.setBounds(130, 405, 120, 25);
         pinchange.addActionListener(this);
         image.add(pinchange);
         
          balenceenquiry = new JButton("Rs 10000");
         balenceenquiry.setBounds(290, 405, 145, 25);
         balenceenquiry.addActionListener(this);
         image.add(balenceenquiry);
         
          exit = new JButton("Back");
         exit.setBounds(290, 435, 145, 25);
         exit.addActionListener(this);
         image.add(exit);
        
        setSize(750,750);
        setLocation(300, 0);
       // setUndecorated(true);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == exit){
            setVisible(false);
            new Transcations(pinnumber).setVisible(true);
            
        }else {
            String amount = ((JButton)ae.getSource()).getText().substring(3); //500
            Conn c = new Conn();
            try{
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"' ");
                int balance = 0;
                while (rs.next()) {
                  if (rs.getString("type").equals("Deposit"))  {
                      balance += Integer.parseInt(rs.getString("amount"));
                  } else{
                      balance -= Integer.parseInt(rs.getString("amount"));
                  }
                    
                }
               if (ae.getSource() != exit && balance < Integer.parseInt(amount) ) {
                   JOptionPane.showMessageDialog(null,"Insufficient Balance");
                   return;
               }
               Date date = new Date();
               String quary = "insert into bank values('"+pinnumber+"', '"+date+"', 'Fastcash','"+amount+"')";
               c.s.executeUpdate(quary);
               JOptionPane.showMessageDialog(null, "Rs " +amount+" Debited successfully");
               
                setVisible(false);
                new Transcations(pinnumber).setVisible(true);
                
            }
            catch(Exception e){
                System.out.println(e);
            }
        } 
         }
    
    public static void main(String[] args) {
        new FastCash("");
    }

    
}
