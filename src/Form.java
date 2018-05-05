import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.*;

import javax.swing.*;

public class Form extends JFrame
{
	private JPanel buttonPanel = new JPanel();
	private JPanel viewPanel = new JPanel();
	private JButton next = new JButton("Next");
	private JButton previous = new JButton ("Previous");
	private JButton last = new JButton("Last");
	private JButton first = new JButton("First");
	private JTextArea search = new JTextArea();
	
	private ExplanationModel m_model = new ExplanationModel();
	private ExplanationView m_view = new ExplanationView(m_model);
	ExplanationController controller = new ExplanationController(m_model, m_view);
	
	private ExplanationModel m_model1 = new ExplanationModel();
	private ExplanationView m_view1 = new ExplanationView(m_model1);
	ExplanationController controller1 = new ExplanationController(m_model1, m_view1);
	
	Form()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(1500, 1000));
		setLayout(null);
		
		//Add the buttons
		buttonPanel.setLayout(null);
		first.setBounds(100, 50, 100, 50);
		buttonPanel.add(first);
		previous.setBounds(300, 50, 100, 50);
		buttonPanel.add(previous);
		next.setBounds(500, 50, 100, 50);
		buttonPanel.add(next);
		last.setBounds(700, 50, 100, 50);
		buttonPanel.add(last);
		add(buttonPanel);
		buttonPanel.setBounds(0, 0, 1500, 150);
		buttonPanel.setBackground(new Color(41, 62, 106));

		viewPanel.setLayout(null);
		viewPanel.setBackground(new Color(41, 62, 106));
		viewPanel.setBounds(0, 150, 1500, 650);
		viewPanel.add(m_view);
		m_view1.setBounds(100, 350, 600, 300);
		viewPanel.add(m_view1);
		add(viewPanel);
		//m_view.setBounds(0, 150, 1500, 300);
		//getContentPane().add(m_view);
	
		//pack();
		setBackground(new Color(41, 62, 106));
	    setVisible(true);
	    setLocationRelativeTo(null);
	}
	public static void main( String[] args ) throws InterruptedException, InvocationTargetException, Exception
    {
		try 
        {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName()))
                {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) 
        {
            Logger.getLogger(EOGMainScreen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
        	
            Logger.getLogger(EOGMainScreen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) 
        {
            Logger.getLogger(EOGMainScreen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) 
        {
            Logger.getLogger(EOGMainScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        // START SCREEN /
       EventQueue.invokeLater(new Runnable()
        {
    	   public void run() 
            {
    		   	ExplanationModel m_model = new ExplanationModel();
          		ExplanationView m_view = new ExplanationView(m_model);
          		ExplanationController controller = new ExplanationController(m_model, m_view);
          		
          		ExplanationModel m_model1 = new ExplanationModel();
          		ExplanationView m_view1 = new ExplanationView(m_model1);
          		ExplanationController controller1 = new ExplanationController(m_model1, m_view1);
          		          		
          		new Form().setVisible(true);
            }
        });
         	
       		
       		
    } //end of main*/

}
