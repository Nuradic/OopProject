import javax.swing.UIManager;
import java.awt.*;
import screens.MainFrame;
import com.formdev.flatlaf.FlatLightLaf;
public class Main {
    public static void main(String[] args){
        try{
            UIManager.setLookAndFeel (new FlatLightLaf());
            UIManager.put( "Button.arc", 999 );
            UIManager.put( "Component.arc", 999 );
            UIManager.put( "ProgressBar.arc", 999 );
            UIManager.put( "TextComponent.arc", 999 );
            UIManager.put( "TabbedPane.selectedBackground", new Color(10,230,230) );
            UIManager.put( "TabbedPane.tabSeparatorsFullHeight", true );
            UIManager.put( "TabbedPane.showTabSeparators", true );
            
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new MainFrame();
                }
            });

            
        }
        catch(Exception e){
            
            e.printStackTrace();
        }
    }
    
}
