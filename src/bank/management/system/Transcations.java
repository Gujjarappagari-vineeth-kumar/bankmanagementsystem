
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Transcations extends JFrame implements ActionListener{
    
    JButton deposit,fastcash,withdrawal,ministstement,balenceenquiry,pinchange,exit;
    String pinnumber;
    Transcations(String pinnumber){
        this.pinnumber = pinnumber;
        
        setLayout(null);
        
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
         Image i2 = i1.getImage().getScaledInstance(750, 750, Image.SCALE_DEFAULT);
         ImageIcon i3 = new ImageIcon(i2);
         JLabel image =new JLabel(i3);
         image.setBounds(0, 0, 750, 750);
         add(image);
         
         JLabel text = new JLabel("Please Select your Transaction");
         text.setBounds(170, 230, 700, 35);
         text.setForeground(Color.WHITE);
         text.setFont(new Font("System", Font.BOLD,16));
         image.add(text);
         
          deposit = new JButton("Deposit");
         deposit.setBounds(130, 345, 120, 25);
         deposit.addActionListener(this);
         image.add(deposit);
         
          withdrawal = new JButton("Cash Withdrawal");
         withdrawal.setBounds(290, 345, 145, 25);
         withdrawal.addActionListener(this);
         image.add(withdrawal);
         
          fastcash = new JButton("Fast Cash");
         fastcash.setBounds(130, 375, 120, 25);
         fastcash.addActionListener(this);
         image.add(fastcash);
         
          ministstement = new JButton("Mini Statement");
         ministstement.setBounds(290, 375, 145, 25);
         ministstement.addActionListener(this);
         image.add(ministstement);
         
          pinchange = new JButton("PIN Change");
         pinchange.setBounds(130, 405, 120, 25);
         pinchange.addActionListener(this);
         image.add(pinchange);
         
          balenceenquiry = new JButton("Balence Enquiry");
         balenceenquiry.setBounds(290, 405, 145, 25);
         balenceenquiry.addActionListener(this);
         image.add(balenceenquiry);
         
          exit = new JButton("Exit");
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
            System.exit(0);
        }else if (ae.getSource() == deposit) {
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
            
        }else if (ae.getSource() == withdrawal) {
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
            
        }
        else if (ae.getSource() == fastcash) {
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
            
        } 
        else if (ae.getSource() == pinchange) {
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
            
        } 
        else if (ae.getSource() == balenceenquiry) {
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
            
        } 
        else if (ae.getSource() == ministstement) {
            setVisible(false);
            new MiniStatement(pinnumber).setVisible(true);
            
        } 
         }
    
    public static void main(String[] args) {
        new Transcations("");
    }

    
}
