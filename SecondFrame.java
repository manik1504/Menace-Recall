import javax.print.DocFlavor.STRING;
import javax.swing.*;    
import java.awt.event.*;    
public class SecondFrame {    
JFrame f;    
SecondFrame(){    
    f=new JFrame("FAIR");   
    final JLabel label = new JLabel("Select TEF");          
    label.setBounds(20,100,90,20); 
    JLabel label1 = new JLabel("Select TCap");          
    label1.setBounds(20,130,90,20);
    JLabel label2 = new JLabel("Select CS");          
    label2.setBounds(20,160,90,20);
    JLabel label3 = new JLabel("Select PLM");          
    label3.setBounds(20,190,90,20);
    
    
    String TEF[]={"Very Low","Low","Medium","High","Very High"};        
    final JComboBox cb=new JComboBox(TEF);    
    cb.setBounds(120, 100,90,20); 
    String TCap[]={"Very Low","Low","Medium","High","Very High"};        
    final JComboBox cb1=new JComboBox(TCap);    
    cb1.setBounds(120, 130,90,20); 
    String CS[]={"Very Low","Low","Medium","High","Very High"};        
    final JComboBox cb2=new JComboBox(CS);    
    cb2.setBounds(120, 160,90,20); 
    String PLM[]={"Very Low","Low","Moderate","Significant","High","Severe"};        
    final JComboBox cb3=new JComboBox(PLM);    
    cb3.setBounds(120, 190,90,20); 
    JButton b=new JButton("Show");  
    b.setBounds(150,250,75,20);  
    f.add(cb); f.add(label); f.add(b); f.add(label1); f.add(label2); f.add(label3); f.add(cb1); f.add(cb2); f.add(cb3);    
    f.setLayout(null);    
    f.setSize(350,350);    
    f.setVisible(true);       
    b.addActionListener(new ActionListener() {  
        public void actionPerformed(ActionEvent e) {       
int tef = cb.getSelectedIndex();
//label.setText(Integer.toString(tef));
int tcap = cb1.getSelectedIndex();
int cs = cb2.getSelectedIndex();
int plm = cb3.getSelectedIndex();
String data=calculateRisk(cs,tcap,tef,plm);
label.setText(data);  
}  
});           
}    
public static void main(String[] args) {    
    new SecondFrame();    
}
private static String calculateRisk(int cs,int tcap,int tef,int plm) {
	// TODO Auto-generated method stub
	int riskm[][]={{0,0,1,1,1,0},{0,1,1,1,0,1},{1,2,2,1,1,2},{2,3,1,2,2,3},{3,2,2,3,3,3}};
	int vulnm[][]={{2,1,0,0,0},{3,2,1,0,0},{4,3,2,1,0},{4,4,3,2,1},{4,4,4,3,2}};
	int lefm[][]={{0,0,0,0,0},{0,0,1,1,1},{0,1,2,2,2},{1,2,3,3,3},{2,3,4,4,4}};
	    int vuln=0;
	    vuln= vulnm[tcap][cs]; //taking value from vuln matrix
	    int lef=0;
	    lef= lefm[tef][vuln]; //taking value from loss event freqiuency matrix

	  
	    int risk=0;
	    risk=riskm[plm][lef];
	    String riskval="null";

	    if(risk==0)
	    {
	        riskval="Low";
	    }
	    else if(risk==1)
	    {
	        riskval="Medium";
	    }
	    else if(risk==2)
	    {
	        riskval="High";
	    }
	    else if(risk==3)
	    {
	        riskval="Critical";
	    }

	    return riskval;
	
}    
}