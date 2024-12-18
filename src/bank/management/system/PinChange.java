
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;
public class PinChange extends JFrame implements ActionListener{
    JPasswordField pin,repin;
    JButton change, back;
    String pinnumber;
    
    PinChange(String pinnumber){
        this.pinnumber = pinnumber;
            
        setLayout(null);
        
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
         Image i2 = i1.getImage().getScaledInstance(750, 750, Image.SCALE_DEFAULT);
         ImageIcon i3 = new ImageIcon(i2);
         JLabel image =new JLabel(i3);
         image.setBounds(0, 0, 750, 750);
         add(image);
         
         JLabel text = new JLabel("Change your PIN");
         text.setBounds(210, 240, 700, 35);
         text.setForeground(Color.WHITE);
         text.setFont(new Font("System", Font.BOLD,16));
         image.add(text);
         
          JLabel pintext = new JLabel("New PIN:");
         pintext.setBounds(130, 280, 180, 25);
         pintext.setForeground(Color.WHITE);
         pintext.setFont(new Font("System", Font.BOLD,16));
         image.add(pintext);
         
         pin = new JPasswordField();
        pin.setFont(new Font("raleway",Font.BOLD,14));
        pin.setBounds(280, 280, 140, 25);
        image.add(pin);
        
          JLabel repintext = new JLabel("Re-Enter new PIN:");
         repintext.setBounds(130, 310, 700, 25);
         repintext.setForeground(Color.WHITE);
         repintext.setFont(new Font("System", Font.BOLD,16));
         image.add(repintext);
         
          repin = new JPasswordField();
        repin.setFont(new Font("raleway",Font.BOLD,14));
        repin.setBounds(280, 310, 140, 25);
        image.add(repin);
        
         change = new JButton("Change");
         change.setBounds(290, 405, 145, 25);
         change.addActionListener(this);
         image.add(change);
         
          back = new JButton("Back");
         back.setBounds(290, 435, 145, 25);
         back.addActionListener(this);
         image.add(back);
         
        setSize(750,750);
        setLocation(300, 0);
       // setUndecorated(true);
        setVisible(true);
    
    }
     @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==change){
            
        
         try {
             String npin = pin.getText();
             String rpin = repin.getText();
             
             if(!npin.equals(rpin)){
                 JOptionPane.showMessageDialog(null, "Entered pin does not match");
                 return;
             }
             if (npin.equals("")){
                 JOptionPane.showMessageDialog(null, "Please enter New PIN");
                 return;
             }
             if (rpin.equals("")){
                 JOptionPane.showMessageDialog(null, "Please Re-enter New PIN");
                 return;
             }
             Conn conn = new Conn();
             String quary1 = "update bank set pin ='"+rpin+"' where pin = '"+pinnumber+"'";
             String quary2 = "update login set pin ='"+rpin+"' where pin = '"+pinnumber+"'";
             String quary3 = "update signupthree set pin ='"+rpin+"' where pin = '"+pinnumber+"'";
             
             conn.s.executeUpdate(quary1);
             conn.s.executeUpdate(quary2);
             conn.s.executeUpdate(quary3);
             
             JOptionPane.showMessageDialog(null, "PIN changed successfully");
             
             setVisible(false);
             new Transcations(pinnumber).setVisible(true);
             

             
         } catch (Exception e) {
             System.out.println(e);
         }
         
        
        }else{
            setVisible(false);
            new Transcations(pinnumber).setVisible(true);
        }
    }
    
    public static void main(String[] args) {
        new PinChange("").setVisible(true);
    }

   

    
}
