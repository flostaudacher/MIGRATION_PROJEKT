import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class flowpaneDiagramm {
	public static void getdata() {
		/**
		 * creating our charts
		 */
		AreaChart<Number, Number> areaChart;
		BarChart<String, Number> barChart;
		/**
		 * setting up our data
		 */
		Import.setup();
		/**
		 * creating a second stage which will be shown after a button click
		 */
		Stage st = new Stage();
		FlowPane flowpane = new FlowPane();
		/**
		 * creating the charts for our second stage
		 */
		Scene sce = new Scene(flowpane, 1050, 500);
		System.out.println("Creating barchart ...");
		barChart = barchart.barchart();
		System.out.println("Creating areaChart ...");
		areaChart = areachart.areachart();
		/**
		 * filling the flowpane
		 */
		flowpane.getChildren().addAll(barChart, areaChart);
		/**
		 * filling our flowpane
		 */
		System.out.println("Filling the Flowpane ...");
		flowpane.setVgap(500);
		
		st.setTitle("Diagramms of your chosen Version");
		st.setScene(sce);
		st.show();  
		reset.resetAllValuesForNewRun();
	}
}
