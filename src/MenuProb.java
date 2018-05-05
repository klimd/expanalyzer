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
public class MenuProb extends JFrame 
{
    /**
     * Creates new form MenuProb
     */
    public MenuProb()
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

        BackToMain3 = new JButton("Back");
        BackToMain3.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent evt)
            {
                BackToMain3ActionPerformed(evt);
            }
        });
        getContentPane().add(BackToMain3);
        BackToMain3.setBounds(0, 0, 72, 29);

        ProbTextArea = new JTextArea();
        ProbTextArea.setColumns(20);
        ProbTextArea.setRows(5);
        
        jScrollPane1 = new JScrollPane();
        jScrollPane1.setViewportView(ProbTextArea);
        jScrollPane1.setBounds(70, 30, 500, 180);
        getContentPane().add(jScrollPane1);
        
        setSize(new Dimension(627, 267));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BackToMain3ActionPerformed(ActionEvent evt) 
    {//GEN-FIRST:event_BackToMain3ActionPerformed
        this.dispose();
    }//GEN-LAST:event_BackToMain3ActionPerformed

    public static void getProbability()
	{
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase db = mongoClient.getDatabase("database");
		MongoCollection<Document> elexirCollection = db.getCollection("test");

		FindIterable<Document> results = elexirCollection.
		find(new BasicDBObject("Probability", new BasicDBObject("$gt", "0")));
		//FindIterable<Document> iter = elexirCollection.find(new BasicDBObject("derivProb", 2));

		for (Document doc : results) 
		{
			List<String> conv  =  (List<String>)doc.get("Probability");
			String [] convArr = new String[conv.size()];
			convArr = conv.toArray(convArr);
			
			for(String s: convArr)
				ProbTextArea.append(s + "\n");
		} 
		 mongoClient.close();
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton BackToMain3;
    private static JTextArea ProbTextArea;
    private JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
