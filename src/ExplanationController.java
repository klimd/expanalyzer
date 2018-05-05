import java.lang.*;
import java.util.*;
import javax.swing.*;

public class ExplanationController
{
	private ExplanationView m_view;
	private ExplanationModel m_model;
	private DataAccessObject DAO;
	
	//private List<ExplanationModel> ExplanationModels = new ArrayList<ExplanationModel>();
	ExplanationController( ExplanationModel model, ExplanationView view ) 
	{      
		m_view = view;
		m_model = model;
		
		//List<ExplanationModel> ExplanationModels = DAO.getPage();
		
		//sample of data
		String derivProb = "8.31668e-18";
		String rootProb = "9.997e-11";
		String finalState = "<html>robotAtP( pit0 ), bombAtP( pit0 ), laserAtP( pit0 ), hasSoftRockP( pit3 ),<br />hasHardRockP( pit1 ), hasHardRockP( pit2 ), goldAtP( pit3 ), isConnectedP( pit0, pit1 ), <br />isConnectedP( pit1, pit2 ), isConnectedP( pit2, pit3 ), armFreeP() ]<br />obsindex: 12 root:[robotAtC( pit1 )] root:[clearC( pit2 )] root:[hasNoLaserC()] <br />root:[robotAtC( pit0 )] root:[robotAtC( pit1 )] root:[robotAtC( pit2 )] root:[clearC( pit3 )] <br />root:[hasGoldC()]</html>";
		
		m_model.setDerivProb(derivProb);
		m_model.setRootProb(rootProb);
		m_model.setFinalState(finalState);
		//m_model.setDerivProb();
		//m_model.setRootProb();
		//m_model.setFinalState();
		m_view.setDerivProbField(m_model.getDerivProb());
		m_view.setRootProbField(m_model.getRootProb());
		m_view.setFinalStateField(m_model.getFinalState());
		m_model.setRoots();
		m_view.setRootsField(m_model.getRoots());
	}
	public void main( String[] args ) throws Exception
    {
		try 
		{
			//DAO.insertMongo();
			ExplanationModel m_model = new ExplanationModel();
	        ExplanationView m_view = new ExplanationView(m_model);
	            
		} catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
