import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ListSelectionEvent; 
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
class MyFrame extends JFrame implements ActionListener,ListSelectionListener,MouseListener,KeyListener{
	    Container c;
	    JLabel lRollNo,lName,lDOB,lGender,lAddress,lStream,lCity;
	    JTextField tRollNo,tName,tFind;
	    JFormattedTextField tDOB;
	    JRadioButton rMale,rFemale;
	    ButtonGroup bg;
	    JTextArea tAddress;
	    DefaultComboBoxModel mStream;
	    JComboBox cbStream;
	     DefaultListModel mCity;
	    JList jlcity;
	    JButton bAdd,bNew,bUpdate,bFind,bDelete,bExit,bClearAll;
	    DefaultTableModel mStudents;
	    JTable tStudents;
	      MyFrame(){
	         	c=getContentPane();
	         	setTitle("Student");
	         	setSize(Toolkit.getDefaultToolkit().getScreenSize());
	         	setLayout(null);
	            c.setBackground(Color.darkGray);
	            
	         	
	         	lRollNo=new JLabel("RollNo");
	         	lRollNo.setBounds(100,50,100,30);
	         	lRollNo.setBackground(Color.lightGray);
	         	
	         	 lRollNo.setOpaque(true);
	         	  c.add(lRollNo);
	         	  
	         	tRollNo=new JTextField();
	         	tRollNo.setBounds(200,50,100,30);
	         	    c.add(tRollNo);  
	         	    	
	         	 	lName=new JLabel("Name");
	         	
	         	
	         	lName.setBounds(100,100,100,30);
	         	 lName.setBackground(Color.lightGray);
	         	 lName.setForeground(Color.black);
	         	 lName.setOpaque(true);
	         	  c.add(lName);
	         	  
	         	tName=new JTextField( );
	         	tName.setBounds(200,100,100,30);
	         	
	         	   c.add(tName);   	
	         	  
	         	lDOB=new JLabel("DOB");
	         	lDOB.setBounds(100,150,100,30);
	         	lDOB.setBackground(Color.lightGray);
	         	
	         	 lDOB.setOpaque(true);
	         	   c.add(lDOB);
	         	   
	           try{
	           	tDOB=new JFormattedTextField(new javax.swing.text.MaskFormatter("##-##-####"));
	           	 tDOB.setBounds(200,150,100,30);
	           	 c.add(tDOB);
	           }
	           catch(Exception ex){
	           	
	           }
	             lGender=new JLabel("GENDER");
	         	 lGender.setBounds(100,200,50,30);
	         	 lGender.setBackground(Color.lightGray);
	             lGender.setOpaque(true);
	         	     c.add(lGender);
	         	     
	         	  rMale=new JRadioButton("Male");
	         	  rMale.setBounds(180,200,60,30);
	         	   c.add(rMale);
	         	   
	         	   rFemale=new JRadioButton("Female");
	         	   rFemale.setBounds(250,200,80,30);
	         	    c.add(rFemale); 
	         	    	
	         	   bg=new ButtonGroup();
	         	   bg.add(rMale);
	         	   bg.add(rFemale);
	         	   
	         	   lAddress=new JLabel("Address");
	         	   lAddress.setBounds(100,250,100,30);
	         	   lAddress.setBackground(Color.lightGray);
	         	   lAddress.setOpaque(true);
	         	   c.add(lAddress);
	         	   	
	         	   tAddress=new JTextArea();
	         	   JScrollPane jspAddress=new JScrollPane(tAddress);
	         	   jspAddress.setBounds(200,250,100,100);
	         	   c.add(jspAddress);
	         	   
	         	   lStream=new JLabel("Stream");
	         	   lStream.setBounds(100,350,100,30);
	         	   lStream.setBackground(Color.lightGray);
	         	   lStream.setOpaque(true);
	         	    c.add(lStream);
	         	    
	         	    mStream=new DefaultComboBoxModel();
	         	    cbStream=new JComboBox(mStream);
	         	    cbStream.setBounds(200,360,100,25);
	         	      c.add(cbStream);
	         	       fillStream();
	         	       
	         	       
	         	    lCity=new JLabel("City");
	         	    lCity.setBounds(100,400,100,30);
	         	    lCity.setBackground(Color.lightGray);
	         	    lCity.setOpaque(true);
	         	       c.add(lCity);
	         	       
	         	       
	         	    mCity=new DefaultListModel();
	         	    jlcity=new JList(mCity);
	         	    JScrollPane jspCity=new JScrollPane(jlcity);
	         	    jspCity.setBounds(200,400,100,100);
	         	    jspCity.setForeground(Color.lightGray);
	         	    jspCity.setOpaque(true); 
	         	      c.add(jspCity);
	                   fillCity();
	                   
	         	   String headers[]={"RollNo","Name","DOB","Gender","Address","Stream","City"};
	         	   mStudents=new DefaultTableModel(headers,0);
	         	   tStudents=new JTable(mStudents);
	         	   JScrollPane jspStudents=new JScrollPane(tStudents);
	         	   jspStudents.setBounds(350,50,600,400);
	         	   c.add(jspStudents);
	         	   fillStudents();
	         	    
	         	   
	         	     
	         	      
	         	  bAdd=new JButton("Add");
	         	  bAdd.setBounds(100,520,100,30);
	         	  bAdd.setBackground(Color.lightGray);
	         	  
	         	    c.add(bAdd);
	         	    
	              bNew=new JButton("New");
	              bNew.setBounds(210,520,100,30);
	              bNew.setBackground(Color.lightGray);
	              
	                c.add(bNew);
	                
	               bUpdate=new JButton("Update");
	               bUpdate.setBounds(320,520,100,30);
	               bUpdate.setBackground(Color.lightGray);
	       
	               
	                  c.add(bUpdate);	 
	                  	
	               bDelete=new JButton("Delete");
	               bDelete.setBounds(100,580,100,30);
	               bDelete.setBackground(Color.lightGray);
	              
	                  c.add(bDelete); 
	         	    
	         	    bFind=new JButton("Find");
	         	    bFind.setBounds(210,580,100,30);
	         	    bFind.setBackground(Color.lightGray);
	         	   
	         	      c.add(bFind);
	         	      
	         	   bExit=new JButton("EXIT");
	         	   bExit.setBounds(320,580,100,30);
	         	   bExit.setBackground(Color.lightGray);
	               c.add(bExit); 
	               	
	               bClearAll=new JButton("ClearAll");
	         	   bClearAll.setBounds(450,520,100,30);
	         	   bClearAll.setBackground(Color.lightGray);
	         	        c.add(bClearAll);    
	         	        	
	         	   tFind=new JTextField();
	         	   tFind.setBounds(580,520,100,30);
	         	    c.add(tFind);     	
	         	         	
	         	        	
	         	    	
	         	    bAdd.addActionListener(this); 	
	         	    bNew.addActionListener(this);	
	         	    bUpdate.addActionListener(this);
	         	    bDelete.addActionListener(this);
	         	  
	         	    bFind.addActionListener(this);
	         	    bClearAll.addActionListener(this);
           		    bExit.addActionListener(this);
           		    jlcity.addListSelectionListener(this);
           		    tStudents.addMouseListener(this);
           		    tFind.addKeyListener(this);
           		    
           	        setVisible(true);
	         	        
	         	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      }
	    
	       private void nextRollnumber(){
	        try{
	             //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	            //Connection con=DriverManager.getConnection("jdbc:odbc:DRIVER=Microsoft Access Driver(*.mdb);DBQ=student.mdb");
	          //    Connection con=DriverManager.getConnection("jdbc:ucanaccess://yogita.mdb");
	          Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	      	  Connection con=DriverManager.getConnection("jdbc:odbc:DRIVER=Microsoft Access Driver (*.mdb);DBQ=student.mdb");
	      	    
	          PreparedStatement ps=con.prepareStatement("Select Max(RollNo) from Student");
	          ResultSet rs=ps.executeQuery();
	             int RollNo=0;
             if(rs.next()) 
	              RollNo=rs.getInt(1);
	              ++RollNo;
	              tRollNo.setText(String.valueOf(RollNo));
	             con.close();	 
	        }
         catch(Exception ex){
                  JOptionPane.showMessageDialog(c,ex.toString());
	         }
         }
	        private void fillStudents(){
	          try{	         
	            	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	      	    	Connection con=DriverManager.getConnection("jdbc:odbc:DRIVER=Microsoft Access Driver (*.mdb);DBQ=student.mdb");
	      	      //  Connection con=DriverManager.getConnection("jdbc:ucanaccess://yogita.mdb");
	      	    	PreparedStatement ps=con.prepareStatement("Select * from Student");
	      	    	ResultSet rs=ps.executeQuery();
	      	    	Vector<Object>v;
	      	    	while(rs.next()){
		      	    	v=new Vector<Object>();
		      	    	v.add(rs.getInt(1));
		      			v.add(rs.getString(2));
		      			java.util.Date d=rs.getDate(3);
		      			v.add(String.format("%td-%tm-%tY",d,d,d));
		      			v.add(rs.getString(4));
		      			v.add(rs.getString(5)); 
		      			v.add(rs.getString(6));
		      			v.add(rs.getString(7));
		      			mStudents.addRow(v); 
	      	   
	      	   	}
	           	con.close();
				}
				catch(Exception ex){
	      	     JOptionPane.showMessageDialog(c,ex.toString());
	          }
	       }           
	   	 private void fillStream(){
	      	mStream.addElement("CSE");
	      	mStream.addElement("ECE");
	        mStream.addElement("IT");
	        mStream.addElement("Civil");
	        mStream.addElement("Mechanical");
	        mStream.addElement("ECE");
	        mStream.addElement("EIE");	         		  
	         
	   }
           private void fillCity(){
           	mCity.addElement("Panipat");
         	mCity.addElement("Sonepat");
           	mCity.addElement("Karnal");		
           	mCity.addElement("Delhi");
           	mCity.addElement("Rishikesh");
           	mCity.addElement("Pune");
      		mCity.addElement("Jaipur");
         }  
         private void insert(){
			try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    		Connection con=DriverManager.getConnection("jdbc:odbc:DRIVER=Microsoft Access Driver (*.mdb);DBQ=student.mdb");
    	  //  Connection con=DriverManager.getConnection("jdbc:ucanaccess://yogita.mdb");
    		PreparedStatement ps=con.prepareStatement("insert into Student values(?,?,?,?,?,?,?)");
    		ps.setInt(1,Integer.parseInt(tRollNo.getText()));
    		ps.setString(2,tName.getText());
    		ps.setString(3,tDOB.getText());
    		if(rMale.isSelected())
    			ps.setString(4,"Male");
    		else
    			ps.setString(4,"Female");
    		ps.setString(5,tAddress.getText());
    		ps.setString(6,cbStream.getSelectedItem().toString());
    		ps.setString(7,jlcity.getSelectedValue().toString());
    		int count=ps.executeUpdate();
    		if(count>0)
    			JOptionPane.showMessageDialog(c,"Saved");
    		else
    			JOptionPane.showMessageDialog(c,"Sorry");
    			
    		
    		con.close();
    		  
		}
		catch (Exception ex) {
			JOptionPane.showMessageDialog(c,ex.toString());
		}
	}
	        private void Delete(){
	            try{
	            
	               	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    		        Connection con=DriverManager.getConnection("jdbc:odbc:DRIVER=Microsoft Access Driver (*.mdb);DBQ=student.mdb");
	                PreparedStatement ps=con.prepareStatement("Delete from Student where RollNo=?");
	                ps.setInt(1,Integer.parseInt(tRollNo.getText()));
	                int count=ps.executeUpdate();
	                  if(count>0)            
	                     JOptionPane.showMessageDialog(c,"Record Deleted");
	                 else
	                   	 JOptionPane.showMessageDialog(c,"Record Not Found");
	                con.close();
	            }
	            catch(Exception ex){
	            	 JOptionPane.showMessageDialog(c,ex.toString());
	            } 
	         }   
	 private void Update(){
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    		Connection con=DriverManager.getConnection("jdbc:odbc:DRIVER=Microsoft Access Driver (*.mdb);DBQ=student.mdb");
    	  //  Connection con=DriverManager.getConnection("jdbc:ucanaccess://yogita.mdb");
    		PreparedStatement ps=con.prepareStatement("Update Student set Name=?,dob=?,Gender=?,Address=?,Stream=?,City=? where RollNo=?");
    	
    		ps.setString(1,tName.getText());
    		ps.setString(2,tDOB.getText());
    		if(rMale.isSelected())
    			ps.setString(3,"Male");
    		else
    			ps.setString(3,"Female");
    		ps.setString(4,tAddress.getText());
    		ps.setString(5,cbStream.getSelectedItem().toString());
    		ps.setString(6,jlcity.getSelectedValue().toString());
    		ps.setInt(7,Integer.parseInt(tRollNo.getText()));
    		int count=ps.executeUpdate();
    		if(count>0)
    			JOptionPane.showMessageDialog(c,"Updated");
    		else
    			JOptionPane.showMessageDialog(c,"Sorry");
    			
    		
    		con.close();
    		  
		}
		catch (Exception ex) {
			JOptionPane.showMessageDialog(c,ex.toString());
		}
	}	
     
		 private void ClearStudents(){
	         	while(mStudents.getRowCount()>0)
	            mStudents.removeRow(0);
	       }
    	 		
    		 public void actionPerformed(ActionEvent ae){
           
                   Object o=ae.getSource();
	                if(o.equals(bAdd)){
	       	     	insert();
	       	        ClearStudents();
	       	     	fillStudents();
	       	     
	                }
	                else if(o.equals(bNew)){
	                	setTitle("New");
	                	nextRollnumber();
	                	tName.setText("");
	                	tDOB.setText("");
	                	bg.clearSelection();
	                	tAddress.setText("");
	                 	//t.setText("Hello");
	                }
	                else if(o.equals(bUpdate)){
	                	setTitle("UPDATE");
	                      Update();
	                	 ClearStudents();
	                	 fillStudents();
	                //	tName.setText("Hey");
	                }  	
	               else if(o.equals(bDelete)){
	               	    setTitle("Delete");
	               	    Delete();
	               	    ClearStudents();
	               	    fillStudents();
	               	  //  tName.setText("Hello");
	               }
	               else if(o.equals(bFind)){
                         setTitle("Find");
                        // tName.setText("find");
	               }
	               else if(o.equals(bClearAll)){
	               	      ClearStudents();
	               }
	               else if(o.equals(bExit)){
	               	     System.exit(0);
	               }
     	 }      
     public void valueChanged(ListSelectionEvent ae){
     
     	Object o=ae.getSource();
     	if(o.equals(jlcity)){
     	setTitle((String)jlcity.getSelectedValue());
     	}	 
     }	

	    public void mouseEntered(MouseEvent me){
	     }
		 public void mouseExited(MouseEvent me){
		}
		public void mousePressed(MouseEvent me){
		}
		public void mouseReleased(MouseEvent me){
		     Object o=me.getSource();
             if(o.equals(tStudents)){
             int r=tStudents.getSelectedRow();
             tRollNo.setText(String.valueOf((Integer)mStudents.getValueAt(r,0)));
             tName.setText(String.valueOf(mStudents.getValueAt(r,1)));
             tDOB.setText(String.valueOf(mStudents.getValueAt(r,2)));
             String gender=String.valueOf(mStudents.getValueAt(r,3));
             if(gender.equals("Male"))
				rMale.setSelected(true);
		     else
				rFemale.setSelected(true);
             tAddress.setText(String.valueOf(mStudents.getValueAt(r,4)));
             cbStream.setSelectedItem(mStudents.getValueAt(r,5));
             jlcity.setSelectedValue(mStudents.getValueAt(r,6),true); 
           }
		}       
      public void mouseClicked(MouseEvent me){
 
      }
 
       public void keyTyped(KeyEvent ke){
       }
       public void keyPressed(KeyEvent ke){
       }
       public void keyReleased(KeyEvent ke){
       
     	Object o=ke.getSource();
         if(o.equals(tFind)){ 
           try{
            	ClearStudents();
                	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	      	    	Connection con=DriverManager.getConnection("jdbc:odbc:DRIVER=Microsoft Access Driver (*.mdb);DBQ=student.mdb");
	      	      //  Connection con=DriverManager.getConnection("jdbc:ucanaccess://yogita.mdb");
	      	    	PreparedStatement ps=con.prepareStatement("Select * from Student where Name like '"+tFind.getText()+"%'");
	      	    	ResultSet rs=ps.executeQuery();
	      	    	Vector<Object>v;
	      	    	while(rs.next()){
		      	    	v=new Vector<Object>();
		      	    	v.add(rs.getInt(1));
		      			v.add(rs.getString(2));
		      			java.util.Date d=rs.getDate(3);
		      			v.add(String.format("%td-%tm-%tY",d,d,d));
		      			v.add(rs.getString(4));
		      			v.add(rs.getString(5)); 
		      			v.add(rs.getString(6));
		      			v.add(rs.getString(7));
		      			mStudents.addRow(v); 
	      	   
	      	   	}
	           	con.close();
				}
			catch(Exception ex){
	      	        JOptionPane.showMessageDialog(c,ex.toString());
	         }
	     }  // end of if         	
     }
}

class DemoFrame{
	public static void main (String[] args) {
		  new MyFrame();
         }
} 	 


