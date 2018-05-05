import java.awt.EventQueue;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.*;
import javax.swing.*;

/**
*
* @author Klimentina
*/

public class Main extends JFrame
{
    
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
     /*   EventQueue.invokeLater(new Runnable()
        {
            public void run() 
            {
                new StartScreen().setVisible(true);
            }
        });
      */
        Model model = new Model();
        StartScreen view = new StartScreen(model);
        Controller controller = new Controller(model, view);
        view.setVisible(true);
    } //end of main
}
