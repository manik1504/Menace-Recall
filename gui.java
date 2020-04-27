import javax.swing.*;    

import java.awt.event.*;    
class first extends JFrame implements ActionListener{    
JRadioButton rb1,rb2,rb3;  
private JFrame f = new JFrame("Select the Risk Assessment Model");
JButton b;    
first(){    
f.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
rb1=new JRadioButton("FAIR Model");    
rb1.setBounds(100,50,100,30);      
rb2=new JRadioButton("EMV Model");    
rb2.setBounds(100,100,100,30);
rb3=new JRadioButton("Hybrid");
rb3.setBounds(100,150,100,30);
ButtonGroup bg=new ButtonGroup();    
bg.add(rb1);bg.add(rb2);bg.add(rb3);    
b=new JButton("next");    
b.setBounds(100,180,80,30);    
b.addActionListener(this); 
add(rb1);add(rb2);add(rb3);add(b);    
setSize(300,300);    
setLayout(null);    
setVisible(true);    
}    
public void actionPerformed(ActionEvent e){    
if(rb1.isSelected()){    
f.dispose();
new SecondFrame();
}    
if(rb2.isSelected()){    
f.dispose();
new ThirdFrame();
}    
if(rb3.isSelected()){    
f.dispose();
new HybridFrame();
}    
}    
public static void main(String args[]){    
new first();    
}}