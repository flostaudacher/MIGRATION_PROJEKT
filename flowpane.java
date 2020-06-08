
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;

public class flowpane extends Application {
	Button vers[] = new Button[3];
	final int versInt[] = {0,1,2};
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		init(primaryStage);
	}
	private void init(Stage primaryStage) {
		/**
		 * setup our flowpane
		 */
		FlowPane flowpaneButtons = new FlowPane();
		Scene scene = new Scene (flowpaneButtons, 385, 120);
		primaryStage.setTitle("Choose the Version of the Diagramm !");
		/**
		 * creating 3 Versions 
		 */
		for (int i = 0; i < vers.length; i++) {

			vers[i] = mybutton.buttonCreate(i);
			/**
			 * adding some Information for the user
			 */
			displayInformation(vers[i],i+1);
		}
		/**
		 * just a name which will be displayed
		 */
		vers[0].setText("\tCreate Diagramm for small communities! (less than  5k people)\t");
		vers[1].setText("\tCreate Diagramm for big communities! (more than  5k people)\t");
		vers[2].setText("\tCreate Diagramm for the total population of Lower Austria!\t\t");
		/**
		 * adding an Action event displaying a new stage on interaction with a button
		 */
		for (int i = 0; i < vers.length; i++) {
			final int x = versInt[i] + 1 ;
			vers[i].addEventHandler(ActionEvent.ACTION, (e) ->  {
				setVersion(x,primaryStage); 
				e.consume();
			});
		}
		/**
		 * setup our data per translating our csv file into a 2 D array
		 */
		flowpaneButtons.getChildren().addAll(vers[0], vers[1], vers[2]);

		flowpaneButtons.setVgap(20);

		primaryStage.setTitle("Option Select | Choose your version !");
		primaryStage.setScene(scene);
		primaryStage.show();  
	}
	/**
	 * displays the groups chosen if you click on the button per hover function
	 */
	private void displayInformation(Button v, int i ) {
		// TODO Auto-generated method stub
		v.setTooltip(
				new Tooltip("Group 1 ="+ barchartMethods.getVArray(0,i)+" \n Group 2 ="+ barchartMethods.getVArray(1,i)+" \n Group 3 = " + barchartMethods.getVArray(2,i)+ " \n Group 4 ="+ barchartMethods.getVArray(3,i)+" \n Group 5 ="+ barchartMethods.getVArray(4,i)+" \n Group 6 = " + barchartMethods.getVArray(5,i) )
				);
	}
	/**
	 * visualize
	 */
	public static void main(String[] args) {
		launch(args);
	}
	/**
	 * choose the Version you will be using 
	 */
	void setVersion(int Version, Stage s) {
		barchartMethods.getVArray(0,Version);
		flowpaneDiagramm.getdata();
	}
}