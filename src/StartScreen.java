import javax.swing.*;
import javax.swing.filechooser.*;
import java.util.*;
import java.util.List;
import java.io.*;
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
 *
 * @author adit
 * @revised Klimentina
 */
public class StartScreen extends JFrame 
{
	 	private JLabel jLabel1 = new JLabel("ELEXIR EXPLANATION GUI", JLabel.CENTER);;
	    private JLabel jLabel2 = new JLabel("Enter File Destination Below", JLabel.CENTER);
	    private JPanel jPanel1 = new JPanel();
	    
	    public  JTextField m_pathField = new JTextField("File Path");
	    
	    private Model m_model;
	    private JButton m_BrowseButton = new JButton("Browse");
	    private JButton m_StartButton = new JButton("START");
	    
	    

	StartScreen (Model model) 
    {
		this.m_model = model;
       
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new Dimension(500, 241));
        getContentPane().setLayout(null);
        
        // Title
        jLabel1.setFont(new Font("Ubuntu", 1, 24)); // NOI18N
        jLabel1.setBounds(0, 0, 500, 40);
        getContentPane().add(jLabel1);
        
        // Header
        jLabel2.setBounds(0, 70, 500, 16);
        getContentPane().add(jLabel2);
                
        //Text box for file path
        m_pathField.setBounds(10, 110, 480, 30);
        getContentPane().add(m_pathField);
        
         
        //Browse Button
        getContentPane().add(m_BrowseButton);
        m_BrowseButton.setBounds(120, 160, 110, 40);
        getContentPane().add(m_StartButton);
        m_StartButton.setBounds(280, 160, 110, 40);
             
       
        /*
         * CHANGE COLORS HERE!!!
         */
        jPanel1.setBackground(new Color(119, 186, 155));
        jPanel1.setMaximumSize(new Dimension(600, 300));
        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 600, 300);
        setSize(new Dimension(510, 272));
        
        setLocationRelativeTo(null);
               
    }
	void addBrowseButtonListener(ActionListener mal)
    {
    	m_BrowseButton.addActionListener(mal);
    }
	void addStartButtonListener(ActionListener mal)
    {
    	m_StartButton.addActionListener(mal);
    }
	public String getPathField()
	{
		return m_pathField.getText();
	}
	public void setPathField(String pathfield)
	{
		m_pathField.setText(pathfield);
	}
	
	
}
