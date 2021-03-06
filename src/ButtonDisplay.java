import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author adit
 * @revised Klimentina
 */
public class ButtonDisplay extends JFrame 
{

    /**
     * Creates new form ButtonDisplay
     */
    public ButtonDisplay() 
    {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    private void initComponents() 
    {
    	setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);
        
        //Back Button
        BackToMain = new JButton("Back");
        BackToMain.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent evt) 
            {
                BackToMainActionPerformed(evt);
            }
        });
        BackToMain.setBounds(0, 0, 72, 29);
        getContentPane().add(BackToMain);

        //Text Area
        BDTextArea = new JTextArea();
        BDTextArea.setColumns(20);
        BDTextArea.setRows(5);
        
        //Scroller
        jScrollPane1 = new JScrollPane();
        jScrollPane1.setViewportView(BDTextArea);
        jScrollPane1.setBounds(70, 30, 500, 180);
        getContentPane().add(jScrollPane1);

        setSize(new Dimension(627, 267));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BackToMainActionPerformed(ActionEvent evt) 
    {//GEN-FIRST:event_BackToMainActionPerformed
        
    	this.dispose();

    }//GEN-LAST:event_BackToMainActionPerformed

      
    public void setText(String text)
    {
        BDTextArea.setText(text);
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JTextArea BDTextArea;
    private JButton BackToMain;
    private JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
