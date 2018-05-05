import java.util.*;

public class ExplanationModel
{
	private int ExplanationNumber;
	private String DerivProb;
	private String RootProb;
	private String FinalState;
	private ArrayList<String> Roots = new ArrayList<String>() ;
	
	/*String derivProb = "8.31668e-18";
	String rootProb = "9.997e-11";
	String finalState = "<html>robotAtP( pit0 ), bombAtP( pit0 ), laserAtP( pit0 ), hasSoftRockP( pit3 ),<br />hasHardRockP( pit1 ), hasHardRockP( pit2 ), goldAtP( pit3 ), isConnectedP( pit0, pit1 ), <br />isConnectedP( pit1, pit2 ), isConnectedP( pit2, pit3 ), armFreeP() ]<br />obsindex: 12 root:[robotAtC( pit1 )] root:[clearC( pit2 )] root:[hasNoLaserC()] <br />root:[robotAtC( pit0 )] root:[robotAtC( pit1 )] root:[robotAtC( pit2 )] root:[clearC( pit3 )] <br />root:[hasGoldC()]</html>";
	*/
	public void setExplanationNumber(int number)
	{
		ExplanationNumber = number;
	}
	public String getExplanationNumber()
	{
		return Integer.toString(ExplanationNumber);
	}
	public void setDerivProb(String derivProb)
	{		
		DerivProb = derivProb;
	}
	public String getDerivProb()
	{
		return DerivProb;
	}
	public void setRootProb(String rootProb)
	{
		RootProb = rootProb;
	}
	public String getRootProb()
	{
		return RootProb;
	}
	public void setFinalState(String finalState)
	{
		FinalState = finalState; 
	}
	public String getFinalState()
	{
		return FinalState;
	}
	public void setRoots ()
	{
		//List <String> roots = {"robotAtC( pit1 )", "clearC( pit2 )", "hasNoLaserC()", "robotAtC( pit0 )", "robotAtC( pit1 )", "robotAtC( pit2 )", "clearC( pit3 )", "hasGoldC()"};
		//ArrayList<String> Roots = new ArrayList<String>();
		String root1 = "robotAtC( pit1 )";
		String root2 = "clearC( pit2 )";
		String root3 = "hasNoLaserC()";
		Roots.add(root1);
		Roots.add(root2);
		Roots.add(root3);
	}
	public String getRoots()
	{
		StringBuilder buf = new StringBuilder();
		for(int i = 0; i < Roots.size(); i++)
		{
		    buf.append(Roots.get(i));
		    if(i < Roots.size() -1)
		    {
		        buf.append(" ");
		    }
		}
		return buf.toString();
	}
}
