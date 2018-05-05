import javax.swing.*;
import java.util.List;
import java.awt.*;
import java.awt.event.*;
import com.mongodb.*;
import com.mongodb.client.*;
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
public class MenuDefAct extends JFrame 
{
    /**
     * Creates new form MenuDefAct
     */
    public MenuDefAct() 
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

        BackToMain1 = new JButton("Back");
        BackToMain1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt) 
            {
                BackToMain1ActionPerformed(evt);
            }
        });
        getContentPane().add(BackToMain1);
        BackToMain1.setBounds(0, 0, 72, 29);

        ActTextArea = new JTextArea();
        ActTextArea.setColumns(20);
        ActTextArea.setRows(5);
        
        jScrollPane1 = new JScrollPane();
        jScrollPane1.setViewportView(ActTextArea);
        jScrollPane1.setBounds(70, 30, 500, 180);
        getContentPane().add(jScrollPane1);
        
        setSize(new Dimension(627, 267));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BackToMain1ActionPerformed(ActionEvent evt)
    {//GEN-FIRST:event_BackToMain1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_BackToMain1ActionPerformed

    public static void getActions()
	{
    	MongoClient mongoClient = new MongoClient("localhost", 27017);
    	MongoDatabase db = mongoClient.getDatabase("database");
    	MongoCollection<Document> elexirCollection = db.getCollection("test");

    	FindIterable<Document> results = elexirCollection.
    		find(new BasicDBObject("Types", new BasicDBObject("$gt", "0")));
    		//FindIterable<Document> iter = elexirCollection.find(new BasicDBObject("derivProb", 2));

    	for (Document doc : results) 
    	{
    		List<String> conv  =  (List<String>)doc.get("Actions");
    		String [] convArr = new String[conv.size()];
    		convArr = conv.toArray(convArr);

    		for(String s: convArr)
    			ActTextArea.append(s + "\n");
    	}
    	mongoClient.close();
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static JTextArea ActTextArea;
    private JButton BackToMain1;
    private JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
