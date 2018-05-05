	import java.awt.*;
	import javax.swing.*;

	public class ExplanationView extends JPanel
	{
		private ExplanationModel model;
		
		private JLabel jLabelExp = new JLabel("Exp: ", JLabel.CENTER);
		private JPanel jPanelNum = new JPanel();
		private JPanel jPanelDerivProb = new JPanel(); 
		private JPanel jPanelRootProb = new JPanel();
		private JPanel jPanelFinalState = new JPanel();
		private JPanel jPanelRoots = new JPanel();
	
		private JLabel jLabelNum = new JLabel("Num ", JLabel.CENTER);
		private JLabel jLabelRootProb = new JLabel("RootProb ", JLabel.CENTER);
		private JLabel jLabelDerivProb = new JLabel("DerivProb", JLabel.CENTER);
		private JLabel jLabelFinalState = new JLabel("FinalState ", JLabel.CENTER);
		private JLabel jLabelRoots = new JLabel("Roots ", JLabel.CENTER);
		
		ExplanationView(ExplanationModel model)
		{
			this.model = model;
			setLayout(null);
		    
			//Exp
		    jLabelExp.setFont(new Font("Ubuntu", 1, 15)); 
		    jLabelExp.setBounds(0, 0, 100, 20);
		    add(jLabelExp);
		    
		    //Num
		    JLabel jLabelExplanationNumber = new JLabel(model.getExplanationNumber());
		    jPanelNum.add(jLabelExplanationNumber);
		    jPanelNum.setBackground(new Color(99, 155, 241));
		    jPanelNum.setFont(new Font("Ubuntu", 1, 15)); 
		    jPanelNum.setBounds(100, 0, 100, 20);
		    add(jPanelNum);
		    			
		    //DerivProb
		    JLabel jLabelDerivProb = new JLabel(model.getDerivProb(), JLabel.CENTER); 
		    jPanelDerivProb.add(jLabelDerivProb);
		    jPanelDerivProb.setBackground(new Color(119, 186, 155));
		    jPanelDerivProb.setFont(new Font("Ubuntu", 1, 15)); 
	        jPanelDerivProb.setBounds(250, 0, 100, 20);
	        add(jPanelDerivProb); 
	        
	        //RootProb
	        jLabelRootProb = new JLabel(model.getRootProb(), JLabel.CENTER);
	        jPanelRootProb.add(jLabelRootProb);
	        jPanelRootProb.setBackground(new Color(182, 167, 84));
	        jPanelRootProb.setFont(new Font("Ubuntu", 1, 15)); 
	        jPanelRootProb.setBounds(400, 0, 100, 20);
	        add(jPanelRootProb);
	        
	        //Final State
	        jLabelFinalState = new JLabel(model.getFinalState(), JLabel.CENTER);
	        jPanelFinalState.add(jLabelFinalState);
	        jPanelFinalState.setBackground(new Color(99, 155, 241));
	        jPanelFinalState.setFont(new Font("Ubuntu", 1, 15)); 
	        jPanelFinalState.setBounds(50, 50, 500, 100);
	        add(jPanelFinalState);
	        
	        //Roots
	        jLabelRoots = new JLabel(model.getRoots(), JLabel.CENTER);
	        jPanelRoots.add(jLabelRoots);
	        jPanelRoots.setBackground(new Color(119, 186, 155));
	        jPanelRoots.setFont(new Font("Ubuntu", 1, 15)); 
	        jPanelRoots.setBounds(50, 180, 500, 100);
	        add(jPanelRoots);
	        	    	    
	        setBackground(new Color(59, 89, 152));
	        setBounds(100, 0, 600, 300);
		    setSize(new Dimension(600, 300));
		    setVisible(true);	
		      
	    }
		/*
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
	                new MainScreenView().setVisible(true);
	            }
	        });
		} //end of main*/
		public void setNumField(String field)
		{
			jLabelNum.setText(field);
		}
		public void setDerivProbField(String field)
		{
			jLabelDerivProb.setText(field);
		}
		public void setRootProbField(String field)
		{
			jLabelRootProb.setText(field);
		}
		public void setFinalStateField(String field)
		{
			jLabelFinalState.setText(field);
		}
		public void setRootsField(String field)
		{
			jLabelRoots.setText(field);
		}
	}