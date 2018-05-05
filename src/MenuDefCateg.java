import com.mongodb.*;
import com.mongodb.client.*;
import java.awt.event.*;
import java.util.List;
import javax.swing.*;
import org.bson.Document;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author adit
 * @revised Klimentina
 */
public class MenuDefCateg extends JFrame {

    /**
     * Creates new form MenuDefCateg
     */
    public MenuDefCateg()
    {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() 
    {
    	setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        BackToHome2 = new JButton("Back");
        BackToHome2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt) 
            {
                BackToHome2ActionPerformed(evt);
            }
        });
        getContentPane().add(BackToHome2);
        BackToHome2.setBounds(0, 0, 72, 29);

        CategTextArea = new JTextArea();
        CategTextArea.setColumns(20);
        CategTextArea.setRows(5);
        
        jScrollPane1 = new JScrollPane();
        jScrollPane1.setViewportView(CategTextArea);
        jScrollPane1.setBounds(70, 30, 500, 180);
        getContentPane().add(jScrollPane1);

        setSize(new java.awt.Dimension(627, 267));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BackToHome2ActionPerformed(ActionEvent evt)
    {//GEN-FIRST:event_BackToHome2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_BackToHome2ActionPerformed

      public static void getCategories()
    {
        
    	  MongoClient mongoClient = new MongoClient("localhost", 27017);
    	  MongoDatabase db = mongoClient.getDatabase("database");
    	  MongoCollection<Document> elexirCollection = db.getCollection("test");
    	  FindIterable<Document> results = elexirCollection.find(new BasicDBObject("Types", new BasicDBObject("$gt", "0")));
    	  //FindIterable<Document> iter = elexirCollection.find(new BasicDBObject("derivProb", 2));
    	  for (Document doc : results) 
    	  {	
    		  List<String> conv  =  (List<String>)doc.get("Category");
    		  String [] convArr = new String[conv.size()];
    		  convArr = conv.toArray(convArr);
    		  for(String s: convArr)
    			  CategTextArea.append(s + "\n" );
    	  }
    	  mongoClient.close();
    }
     // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton BackToHome2;
    private static JTextArea CategTextArea;
    private JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
