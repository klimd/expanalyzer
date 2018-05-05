import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;
import java.lang.reflect.InvocationTargetException;
import org.bson.Document;
import com.mongodb.*;
import com.mongodb.client.*;


/**
 *
 * @author Adit
 */
public class EOGMainScreen extends JFrame {
        
    //Variable Initialization
    int NumOfExplanations;
    
    //Variable Initialization
    int pageCounter=1;
    int pageCounter2=0;
    
    
    public EOGMainScreen() throws Exception
    {
        initComponents();
    	System.out.println("initComponents");
        getNumExp();
        System.out.println("NumOfExplanations: "  + NumOfExplanations);
        SetExpLabel();
        System.out.println("SetExpLabel");
        SetDerivProb();
        SetRootProb();
        SetFinalState();
        SetRoots();
        //Jpanel();
    }
private void initComponents()
{

        jColorChooser1 = new JColorChooser();
        jColorChooser2 = new JColorChooser();
        
        jMenuBar = new JMenuBar();
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1 = new JPanel();
        jPanel1.setLayout(new OverlayLayout(jPanel1));
        jPanel1.setBounds(80, 60, 100, 490);
        getContentPane().add(jPanel1);
       
        jPanel3 = new JPanel();
        jPanel3.setBounds(180, 60, 100, 490);
        getContentPane().add(jPanel3);
        
        jPanel2 = new JPanel();
        jPanel2.setLayout(null);
        jPanel2.setBounds(0, 60, 80, 490);
        getContentPane().add(jPanel2);        

        jPanel4 = new JPanel();
        jPanel4.setBounds(300, 60, 120, 490);
        getContentPane().add(jPanel4);
        
        jPanel5 = new JPanel();
        jPanel5.setBounds(420, 60, 100, 490);
        getContentPane().add(jPanel5);

        
        //DerivProb
        jLabel3 = new JLabel("DerivProb", JLabel.CENTER); 
        jLabel3.setFont(new Font("Ubuntu", 1, 15)); // NOI18N
        jLabel3.setBounds(80, 40, 100, 20);
        getContentPane().add(jLabel3);
        
        //RootProb
        jLabel2 = new JLabel("RootProb", JLabel.CENTER); 
        jLabel2.setFont(new Font("Ubuntu", 1, 15)); // NOI18N
        jLabel2.setBounds(180, 40, 100, 19);
        getContentPane().add(jLabel2);
        
        //Previous Button
        jButton2 = new JButton("Previous"); 
        jButton2.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent evt) 
            {
                jButton2ActionPerformed(evt);
            }
        });
        jButton2.setBounds(310, 20, 97, 29);
        getContentPane().add(jButton2);
        
        //Next Button
        jButton3 = new JButton("Next");
        jButton3.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt) 
            {
                jButton3ActionPerformed(evt);
            }
        });
        jButton3.setBounds(410, 20, 100, 29);
        getContentPane().add(jButton3);

        //File Tab
        jMenu1 = new JMenu("\t\tFile\t\t");
        //New File
        jMenuItem10 = new JMenuItem("New File");
        jMenuItem10.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent evt)
            {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem10);
        //Save
        jMenuItem11 = new JMenuItem("Save");
        jMenu1.add(jMenuItem11);
        //Exit
        jMenuItem12 = new JMenuItem("Exit"); 
        jMenuItem12.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent evt) 
            {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem12);
        //Add everything to the menu	
        jMenuBar.add(jMenu1);

        //Definitions Tab
        ActAction = new JMenu("\t\tDefinitions\t\t");
        //Types
        MenuType = new JMenuItem("Types");
        MenuType.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent evt)
            {
                MenuTypeActionPerformed(evt);
            }
        });
        ActAction.add(MenuType);
        //Objects
        MenuObj = new JMenuItem("Objects");
        MenuObj.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent evt) 
            {
                MenuObjActionPerformed(evt);
            }
        });
        ActAction.add(MenuObj);
        //Predicates
        MenuPred = new JMenuItem("Predicates");
        MenuPred.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent evt) 
            {
                MenuPredActionPerformed(evt);
            }
        });
        ActAction.add(MenuPred);
        //Cats
        MenuCat = new JMenuItem("Cats");
        MenuCat.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent evt)
            {
                MenuCatActionPerformed(evt);
            }
        });
        ActAction.add(MenuCat);
        //Categories
        MenuCateg = new JMenuItem("Category");
        MenuCateg.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt) 
            {
                MenuCategActionPerformed(evt);
            }
        });
        ActAction.add(MenuCateg);
        //Actions
        MenuAct = new JMenuItem("Actions");
        MenuAct.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent evt)
            {
                MenuActActionPerformed(evt);
            }
        });
        ActAction.add(MenuAct);
        //Add everything to the menu
        jMenuBar.add(ActAction);
        
        //Statistics Tab 
        jMenu4 = new JMenu("\t\tStatistics\t\t");
        //View Statistics
        jMenuItem2 = new JMenuItem("View Statistics");
        jMenuItem2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt) 
            {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem2);
        //Add everything to the menu
        jMenuBar.add(jMenu4);
        
        //Initial State Tab
        jMenu2 = new JMenu("\t\tInitial State\t\t"); 
        //View Initial State
        jMenuItem1 = new JMenuItem("View Initial State");
        jMenuItem1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt) 
            {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);
        //Add everything to the menu
        jMenuBar.add(jMenu2);

        setJMenuBar(jMenuBar);
        setSize(new Dimension(531, 622));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void MenuTypeActionPerformed(ActionEvent evt) 
    {//GEN-FIRST:event_MenuTypeActionPerformed
        // TODO add your handling code here:
        MenuDefTyp exp = new MenuDefTyp();
        exp.setVisible(true);
        exp.getTypes();
    }//GEN-LAST:event_MenuTypeActionPerformed

    private void MenuObjActionPerformed(ActionEvent evt) 
    {//GEN-FIRST:event_MenuObjActionPerformed
        // TODO add your handling code here:
        MenuDefObj exp = new MenuDefObj();
        exp.setVisible(true);
        exp.getObjects();
                 
    }//GEN-LAST:event_MenuObjActionPerformed

    private void MenuPredActionPerformed(ActionEvent evt) 
    {//GEN-FIRST:event_MenuPredActionPerformed
        // TODO add your handling code here:
        MenuDefPred exp = new MenuDefPred();
        exp.setVisible(true);
        exp.getPreds();
    }//GEN-LAST:event_MenuPredActionPerformed

    private void MenuActActionPerformed(ActionEvent evt) 
    {//GEN-FIRST:event_MenuActActionPerformed
        // TODO add your handling code here:
        MenuDefAct exp = new MenuDefAct();
        exp.setVisible(true);
        exp.getActions();
        
    }//GEN-LAST:event_MenuActActionPerformed

    private void MenuCategActionPerformed(ActionEvent evt) 
    {//GEN-FIRST:event_MenuCategActionPerformed
        // TODO add your handling code here:
        MenuDefCateg exp = new MenuDefCateg();
        exp.setVisible(true);
        exp.getCategories();
        
    }//GEN-LAST:event_MenuCategActionPerformed

    private void MenuCatActionPerformed(ActionEvent evt) 
    {//GEN-FIRST:event_MenuCatActionPerformed
        // TODO add your handling code here:
        MenuDefCats exp = new MenuDefCats();
        exp.setVisible(true);
        exp.getCats();
        
    }//GEN-LAST:event_MenuCatActionPerformed

    private void jMenuItem2ActionPerformed(ActionEvent evt) 
    {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        MenuProb exp = new MenuProb();
        exp.setVisible(true);
        exp.getProbability();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem10ActionPerformed(ActionEvent evt) 
    {//GEN-FIRST:event_jMenuItem10ActionPerformed
        // TODO add your handling code here:
        StartScreen exp = new StartScreen();
        exp.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem12ActionPerformed(ActionEvent evt) 
    {//GEN-FIRST:event_jMenuItem12ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
       
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem1ActionPerformed(ActionEvent evt) 
    {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        
        MenuIS exp = new MenuIS();
        exp.setVisible(true);
        exp.getIS();
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    
    
    
     public int getNumExp() throws Exception {
        
     //System.out.println(StartScreen.pathField.getText());
        
        
        FileReader file = new FileReader(StartScreen.pathField.getText()); //depotsOutput.txt
		BufferedReader reader = new BufferedReader(file);
		String line = reader.readLine();
                
                while (line != null){
                    //System.out.println("entered while");
                    if (line.contains("Found")){
                       // System.out.println("entered if");
                                int startingIndexOfFound;
				String found = "Found ";
				startingIndexOfFound = line.indexOf("Found");
				int endingIndexOfFound = line.indexOf("Explanations.");
				String NumOfExp = line.substring
                                                          (startingIndexOfFound + found.length(), endingIndexOfFound-2);
                                
                                 NumOfExplanations = Integer.parseInt(NumOfExp);
                                 
                                 //System.out.println(NumOfExplanations);
                             
                    }
                    line = reader.readLine();
                }
                  return NumOfExplanations;  
                
    }
    
    
    
    
    
  
    
    
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        
         if (NumOfExplanations > 15) 
        {
           
             //Clearing out JPannels 
             // jPanel1.removeAll();
            jPanel2.removeAll();
             //jPanel3.removeAll();
             //jPanel4.removeAll();
             //jPanel5.removeAll();
            jPanel1.revalidate();
            jPanel1.repaint();
            jPanel2.revalidate();
            jPanel2.repaint();
            jPanel3.revalidate();
            jPanel3.repaint();
            jPanel4.revalidate();
            jPanel4.repaint();
            jPanel5.revalidate();
            jPanel5.repaint();
            
            
                    //To update the label index numbers 

        //int multiplied = multiplyingFactor * updateLabelBy;
 
//        if(pageCounter*16>NumOfExplanations){
//            return;
//        }


/*

sudo Code: We want to be able to change the button labels to whatever it is plus 16 
we need a changing int. When we press the next button, we want the int value to go up by one everytime 





*/




         int temp=16*pageCounter2;
         for ( int i=temp ; i < temp+16 ; i++ )
         {
            JLabel label = new JLabel( "Exp " + i  );
            label.setSize(100,35);
            label.setMaximumSize(new Dimension (140,40));
            label.setMinimumSize(new Dimension (100,30));
            label.setFont(new Font("Serif", Font.BOLD, 15));
           
            jPanel2.setLayout(new BoxLayout(jPanel2, BoxLayout.Y_AXIS));
            jPanel2.setBorder(BorderFactory.createEmptyBorder(10, 10, 15, 0));
            label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jPanel2.add(label);
            //pageCounter++;
            //System.out.println(pageCounter);        
        }pageCounter2--;

        }
        else if(NumOfExplanations <= 15) 
            {
            final JFrame parent = new JFrame();
            JButton button = new JButton();

            button.setText("This document only contains " + NumOfExplanations + " explanations" );
            parent.add(button);
            parent.pack();
            parent.setVisible(true);
            parent.setSize(400,200);
            parent.setLocationRelativeTo(null);

        }
         
        
        
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    
    
    //public static int updateLabelBy = 16;
    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        //When this button is pressed, JPanel2,3,4,5 will all show the next instance of solutions 
        
        if (NumOfExplanations > 15) 
        {
           
             //Clearing out JPannels 
             // jPanel1.removeAll();
            jPanel2.removeAll();
             //jPanel3.removeAll();
             //jPanel4.removeAll();
             //jPanel5.removeAll();
            jPanel1.revalidate();
            jPanel1.repaint();
            jPanel2.revalidate();
            jPanel2.repaint();
            jPanel3.revalidate();
            jPanel3.repaint();
            jPanel4.revalidate();
            jPanel4.repaint();
            jPanel5.revalidate();
            jPanel5.repaint();
            
            
                    //To update the label index numbers 

        //int multiplied = multiplyingFactor * updateLabelBy;
 
//        if(pageCounter*16>NumOfExplanations){
//            return;
//        }


/*

sudo Code: We want to be able to change the button labels to whatever it is plus 16 
we need a changing int. When we press the next button, we want the int value to go up by one everytime 





*/




         int temp=16*pageCounter;
         for ( int i=temp ; i < temp+16 ; i++ )
         {
            JLabel label = new JLabel( "Exp " + i  );
            label.setSize(100,35);
            label.setMaximumSize(new Dimension (140,40));
            label.setMinimumSize(new Dimension (100,30));
            label.setFont(new Font("Serif", Font.BOLD, 15));
           
            jPanel2.setLayout(new BoxLayout(jPanel2, BoxLayout.Y_AXIS));
            jPanel2.setBorder(BorderFactory.createEmptyBorder(10, 10, 15, 0));
            label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jPanel2.add(label);
            
            //pageCounter++;
            //System.out.println(pageCounter);        
        }pageCounter++;

        }
        else if(NumOfExplanations <= 15) 
            {
            final JFrame parent = new JFrame();
            JButton button = new JButton();

            button.setText("This document only contains " + NumOfExplanations + " explanations" );
            parent.add(button);
            parent.pack();
            parent.setVisible(true);
            parent.setSize(400,200);
            parent.setLocationRelativeTo(null);

        }
         
        
        
        
        
       
    }//GEN-LAST:event_jButton3ActionPerformed

   
    
    
    
 
    
    private void SetExpLabel(){

        ArrayList<JLabel> labels;
        labels = new ArrayList<JLabel>(NumOfExplanations);
        
        for ( int i = 0; i < NumOfExplanations; i++ )
        {
            JLabel label = new JLabel(( "Exp " + i )  );
            
            label.setSize(100,35);
            label.setMaximumSize(new Dimension (140,40));
            label.setMinimumSize(new Dimension (100,30));
            label.setFont(new Font("Serif", Font.BOLD, 15));
            
            
          
            labels.add( label );
            
            jPanel2.setLayout(new BoxLayout(jPanel2, BoxLayout.Y_AXIS));
            jPanel2.setBorder(BorderFactory.createEmptyBorder(10, 10, 15, 0));
            label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jPanel2.add(label);
            
        }// end for loop
        
        
        
    }//end SetExpLabel()
    
    
    private void SetDerivProb()   
    {
    	MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase db = mongoClient.getDatabase("database");
        MongoCollection<Document> elexirCollection = db.getCollection("test");
    
        FindIterable<Document> results = elexirCollection.
        find(new BasicDBObject("derivProb", new BasicDBObject("$gt", "0")));
        //FindIterable<Document> iter = elexirCollection.find(new BasicDBObject("derivProb", 2));
        for (Document doc : results) 
        {
        	List<String> conv  = (List<String>) doc.get("derivProb");
        	{
        		JLabel label = new JLabel(conv.get(0) );
        		label.setSize(100,35);
        		label.setMaximumSize(new Dimension (140,40));
        		label.setMinimumSize(new Dimension (100,30));
        		label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        		label.setFont(new Font("Serif", Font.PLAIN, 13));


        		jPanel1.setLayout(new BoxLayout(jPanel1, BoxLayout.Y_AXIS));
        		jPanel1.setBorder(BorderFactory.createEmptyBorder(11, 10, 15, 0));
        		jPanel1.add(label);
            	
        	}
        }
        
    }//SetDerivProb
    
    private void SetRootProb()
    {
    	MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase db = mongoClient.getDatabase("database");
        MongoCollection<Document> elexirCollection = db.getCollection("test");
    
        FindIterable<Document> results = elexirCollection.
        find(new BasicDBObject("rootProb", new BasicDBObject("$gt", "0")));
        //FindIterable<Document> iter = elexirCollection.find(new BasicDBObject("derivProb", 2));
        for (Document doc : results) 
        {
        	List<String> conv  = (List<String>) doc.get("derivProb");
        	{
        		JLabel label = new JLabel(conv.get(0) );
        		label.setSize(100,35);
        		label.setMaximumSize(new Dimension (140,40));
        		label.setMinimumSize(new Dimension (100,30));
        		label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        		label.setFont(new Font("Serif", Font.PLAIN, 13));


        		jPanel3.setLayout(new BoxLayout(jPanel3, BoxLayout.Y_AXIS));
        		jPanel3.setBorder(BorderFactory.createEmptyBorder(11, 10, 15, 0));
        		jPanel3.add(label);
            	
        	}
        }
        
    }

    private void SetFinalState(){
        
         MongoClient mongoClient = new MongoClient("localhost", 27017);
        
	MongoDatabase db = mongoClient.getDatabase("database"); 
        MongoCollection<Document> elexirCollection = db.getCollection("test");
    
        FindIterable<Document> results = elexirCollection.
               find(new BasicDBObject("derivProb", new BasicDBObject("$gt", "0")));
			//FindIterable<Document> iter = elexirCollection.find(new BasicDBObject("derivProb", 2));

			
			for (Document doc : results) {
				
                            List<String> conv  = (List<String>) doc.get("finalState");
                                    //conv.get(0)
                            {
                                JButton button = new JButton("Final State" );
            
                                     button.setSize(100,35);
                                     button.setMaximumSize(new Dimension (140,40));
                                     button.setMinimumSize(new Dimension (100,30));
                                   
                                    jPanel4.setLayout(new BoxLayout(jPanel4, BoxLayout.Y_AXIS));
                                    jPanel4.setBorder(BorderFactory.createEmptyBorder(10, 5, 15, 5));
                                    jPanel4.add(button);
                                    
                                    
                                 button.addActionListener(new ActionListener() {
 
                                  public void actionPerformed(ActionEvent e)
                                  {
                                        //Execute when button is pressed
                                        
                                        //System.out.println(conv.get(0));
                                       ButtonDisplay exp = new ButtonDisplay();
                                        
                                        exp.setText(conv.get(0));
                                        exp.setVisible(true);
                                  }
                                  });      
 
                                
                            }
                            
                               
                        }
   
        
        
        
    }
    
    
    private void SetRoots(){
        
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        
	MongoDatabase db = mongoClient.getDatabase("database");
        MongoCollection<Document> elexirCollection = db.getCollection("test");
    
        FindIterable<Document> results = elexirCollection.
               find(new BasicDBObject("derivProb", new BasicDBObject("$gt", "0")));
			//FindIterable<Document> iter = elexirCollection.find(new BasicDBObject("derivProb", 2));

			
			for (Document doc : results) 
			{
				
				List<String> conv  = (List<String>) doc.get("Roots");
				//conv.get(0)
                            {
                                JButton button = new JButton("Roots" );
            
                                     button.setSize(100,35);
                                     button.setMaximumSize(new Dimension (140,40));
                                     button.setMinimumSize(new Dimension (100,30));
                                    
                                    jPanel5.setLayout(new BoxLayout(jPanel5, BoxLayout.Y_AXIS));
                                    jPanel5.setBorder(BorderFactory.createEmptyBorder(10, 5, 15, 5));
                                    jPanel5.add(button);
                                    
                                    
                                  button.addActionListener(new ActionListener() {
 
                                  public void actionPerformed(ActionEvent e)
                                  {
                                        //Execute when button is pressed                                   
                                        //System.out.println(conv);
                                           
                                        ButtonDisplay exp = new ButtonDisplay();
                                        
                                        exp.setText(conv.toString());
                                        exp.setVisible(true);
                                  }
                                  }); 
                                
                                
                            }
                            
                               
			}
                        
   
    }//end SetRoots
    
    String listToString(List<String> lst)
    {
        StringBuilder bld = new StringBuilder();
        for(String str : lst)
        {
            bld.append(str + ", ");
        }
        return bld.toString();
    }
   
int NumExpOnPage;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    
    
    private JButton jButton2;
    private JButton jButton3;
    private JColorChooser jColorChooser1;
    private JColorChooser jColorChooser2;
    private JLabel jLabel2;
    private JLabel jLabel3;
    
    private JMenuBar jMenuBar;  // Menu Bar
    
    private JMenu jMenu1;	//File
    private JMenuItem jMenuItem10; //New File
    private JMenuItem jMenuItem11; //Save
    private JMenuItem jMenuItem12; //Exit
    
    private JMenu ActAction; //Definitions
    private JMenuItem MenuAct; //Actions
    private JMenuItem MenuCat; //Cats
    private JMenuItem MenuCateg; //Categories
    private JMenuItem MenuObj; //Objects
    private JMenuItem MenuPred; //Predicates
    private JMenuItem MenuType; //Types 
    
    private JMenu jMenu4;	//Statistics    
    private JMenuItem jMenuItem2; //View Statistics
     
    private JMenu jMenu2;	//Initial State
    private JMenuItem jMenuItem1;  //View Initial State

    private JPanel jPanel1; 
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    // End of variables declaration//GEN-END:variables
}
