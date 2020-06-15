import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class flowpaneDiagramm {
	/**
	 * creating our flowpane for the diagramms
	 */
	public static void getdata() {
		AreaChart<Number, Number> areaChart;
		BarChart<String, Number> barChart;
		
		Import.setup();
		
		Stage st = new Stage();
		FlowPane flowpane = new FlowPane();
		
		Scene sce = new Scene(flowpane, 1050, 500);
		System.out.println("Creating barchart ...");
		barChart = barchart.barchart();
		System.out.println("Creating areaChart ...");
		areaChart = areachart.areachart();
		
		flowpane.getChildren().addAll(barChart, areaChart);
		
		System.out.println("Filling the Flowpane ...");
		flowpane.setVgap(500);
		
		st.setTitle("Diagramms of your chosen Version");
		st.setScene(sce);
		st.show();  
		reset.resetAllValuesForNewRun();
	}
}
