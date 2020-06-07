
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class flowpane extends Application {
	Button vers1;
	Button vers2;
	Button vers3;
	AreaChart<Number, Number> areaChart;
	BarChart<String, Number> barChart;

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


		vers1 = mybutton.buttonCreate(1);
		vers2 = mybutton.buttonCreate(2);
		vers3 = mybutton.buttonCreate(3);
		
		vers1.setText("\tCreate Diagramm for small communities! (less than  5k people)\t");
		vers2.setText("\tCreate Diagramm for big communities! (more than  5k people)\t");
		vers3.setText("\tCreate Diagramm for the total population of Lower Austria!\t\t");
		
		vers1.addEventHandler(ActionEvent.ACTION, (e) ->  {
			setVersion(1,primaryStage); 
			e.consume();
		});
		vers2.addEventHandler(ActionEvent.ACTION, (e) -> {
			setVersion(2,primaryStage); 
			e.consume();
		});
		vers3.addEventHandler(ActionEvent.ACTION, (e) -> {
			setVersion(3,primaryStage); 
			e.consume();
		});
		/**
		 * setup our data per translating our csv file into a 2 D array
		 */

		flowpaneButtons.getChildren().addAll(vers1,vers2,vers3);
		
		flowpaneButtons.setVgap(20);
		
		primaryStage.setTitle("Balkendiagramm meiner Corona Arbeit");
		primaryStage.setScene(scene);
		primaryStage.show();  
	}
	/**
	 * visualize
	 */
	public static void main(String[] args) {
		launch(args);
	}
	void getdata() {
		/**
		 * creating our charts
		 */

		Import.setup();
		
		Stage st = new Stage();
		FlowPane flowpane = new FlowPane();
		Scene sce = new Scene(flowpane, 1250, 500);
		System.out.println("Creating barchart ...");
		barChart = barchart.barchart();
		System.out.println("Creating areaChart ...");
		areaChart = areachart.areachart();

		flowpane.getChildren().addAll(barChart, areaChart);
		/**
		 * filling our flowpane
		 */
		System.out.println("Filling the Flowpane ...");
		flowpane.setVgap(500);

		st.setTitle("Balkendiagramm meiner Corona Arbeit");
		st.setScene(sce);
		st.show();  
		reset.resetAllValuesForNewRun();
	}
	/**
	 * choose the Version you will be using 
	 */
	void setVersion(int Version, Stage s) {
		barchartMethods.setVersion(Version);
		getdata();
		
	}
}