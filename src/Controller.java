import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Controller 
{
	private DataAccessObject m_data;
	private Model StartScreenModel;
    private StartScreen  StartScreenView;
    private String fileDirectory;
    
    public String getPathField()
    {
    	return fileDirectory;
    }
    Controller (Model model, StartScreen view) 
	{
		StartScreenModel = model;
		StartScreenView = view;
		
		view.addBrowseButtonListener(new BrowseButtonListener()); 
		view.addStartButtonListener(new StartButtonListener());
	}
	
	class BrowseButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent evt)
        {
			JFileChooser chooser = new JFileChooser();
	    	FileNameExtensionFilter filter = new FileNameExtensionFilter("Text File", "txt");
	    	chooser.setFileFilter(filter);
			chooser.addChoosableFileFilter(filter);
			chooser.setFileSelectionMode( JFileChooser.FILES_AND_DIRECTORIES ); 
			chooser.setDialogTitle("Choose an ELEXIR output file");
			chooser.setCurrentDirectory(new File("."));
			chooser.setAcceptAllFileFilterUsed(true);
				
			int returnVal = chooser.showOpenDialog(null) ;
			if (returnVal == JFileChooser.APPROVE_OPTION)
			{
			  //String fileDirectory = chooser.getSelectedFile().toString();
			  fileDirectory = chooser.getSelectedFile().toString();
			  StartScreenModel.setPathField(fileDirectory);
			  StartScreenView.setPathField(StartScreenModel.getPathField());
			} 
			else
			{
			  System.out.println(" No Selection ");
			} 
        }
	}
	
	class StartButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent evt)
        {
			 try
		        {       
				//new Form().setVisible(true);
				 		StartScreenModel.insertMongo();
		        		EOGMainScreen exp = new EOGMainScreen();
		        		exp.setVisible(true);
		                StartScreenView.dispose(); 
		         } catch (Exception e) 
		        	{
		        	 	System.err.println("Exception: " + e.getMessage()); 
		         	}
        }
	}

}

