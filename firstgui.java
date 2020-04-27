import javax.print.DocFlavor.STRING;
import javax.swing.*;    
import java.awt.event.*;    
public class SecondFrame {    
JFrame f;    
SecondFrame(){    
    f=new JFrame("FAIR");   
    final JLabel labell = new JLabel("Select the following Values:");          
    labell.setBounds(200,50,200,20);
    f.add(labell);
    final JLabel label = new JLabel("Threat Event Frequency");          
    label.setBounds(20,100,200,20); 
    JLabel label1 = new JLabel("Threat Capability");          
    label1.setBounds(20,150,200,20);
    JLabel label2 = new JLabel("Control Strength");          
    label2.setBounds(20,200,200,20);
    JLabel label3 = new JLabel("Probable Loss Magnitude");          
    label3.setBounds(20,250,200,20);
    
    
    String TEF[]={"Very Low(less than .1 times per year)","Low(Between .1 and 1 times per year)",
    		"Medium(Between 1 and 10 times per year)","High(Between 10 and 100 times per year)",
    		"Very High(more than 100 times per year)"};        
    final JComboBox cb=new JComboBox(TEF);    
    cb.setBounds(180,100,350,20); 
    String TCap[]={"Very Low(Bottom 2% in overall threat population)"
    		,"Low(Bottom 16% in overall threat population)",
    		"Medium(Between bottom 16% and top 16% in overall threat population)",
    		"High(Top 16% in overall threat population)",
    		"Very High(Top 2% in overall threat population)"};        
    final JComboBox cb1=new JComboBox(TCap);    
    cb1.setBounds(180, 150,350,20); 
    String CS[]={"Very Low(Only protects againist bottom 2% of overall threat)"
    		,"Low(Only protects againist bottom 16% of overall threat)",
    		"Medium(Protects againist average threat agent)",
    		"High(Protects againist all but top 16% of overall threat)",
    		"Very High(Protects againist all but top 2% of overall threat)"};        
    final JComboBox cb2=new JComboBox(CS);    
    cb2.setBounds(180, 200,350,20); 
    String PLM[]={"Very Low(Loss between $0-$999)",
    		"Low(Loss between $1000-$9999)",
    		"Moderate(Loss between $10000-$99999)",
    		"Significant(Loss between $100000-$999999)",
    		"High(Loss between $1000000-$9999999)","Severe(Loss more than or equal to 10000000"};        
    final JComboBox cb3=new JComboBox(PLM);    
    cb3.setBounds(180, 250,350,20); 
    JButton b=new JButton("Calculate Risk");  
    b.setBounds(230,350,150,20); 
    final JLabel result = new JLabel("");          
    result.setBounds(230,300,200,20);
    f.add(result);
    f.add(cb); f.add(label); f.add(b); f.add(label1); f.add(label2); f.add(label3); f.add(cb1); f.add(cb2); f.add(cb3);    
    f.setLayout(null);    
    f.setSize(570,450);    
    f.setVisible(true);       
    b.addActionListener(new ActionListener() {  
        public void actionPerformed(ActionEvent e) {       
int tef = cb.getSelectedIndex();
//label.setText(Integer.toString(tef));
int tcap = cb1.getSelectedIndex();
int cs = cb2.getSelectedIndex();
int plm = cb3.getSelectedIndex();
String data="The Risk calculated is: " +calculateRisk(cs,tcap,tef,plm);
result.setText(data);  
}  
});           
}    
public static void main(String[] args) {    
    new SecondFrame();    
}
private static String calculateRisk(int cs,int tcap,int tef,int plm) {
	// TODO Auto-generated method stub
	int riskm[][]={{0,0,1,1,1},{0,0,1,1,1},{0,1,1,2,2},{1,1,2,2,3},{1,2,2,3,3},{2,2,3,3,3}};
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