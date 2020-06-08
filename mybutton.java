
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
/**
 * 
 * @author flost
 * this class is needed because a flowpane can only be filled with nodes, therefore the class, where the button is created can not be extended by application -> we choose pane as our parent 
 */
public class mybutton extends Pane {
	public static Button buttonCreate(int i) {
		/**
		 * creating a button and returning it
		 */
	Button mybutton = new Button();
	System.out.println("create button ");
	return mybutton;
	}
}
