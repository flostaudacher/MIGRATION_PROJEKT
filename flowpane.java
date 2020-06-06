import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class flowpane extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		init(primaryStage);
	}
	private void init(Stage primaryStage) {
		
		primaryStage.setTitle("Flowpane Layout");
		
		FlowPane flowpane = new FlowPane();
		
		Scene scene = new Scene(flowpane, 1050, 400);
		
		Import.setup();
		
		BarChart<String, Number> barChart = barchart.barchart();
		AreaChart<Number, Number> areaChart = areachart.areachart();
		
		flowpane.getChildren().addAll(barChart, areaChart);
		flowpane.setVgap(500);

		primaryStage.setTitle("Balkendiagramm meiner Corona Arbeit");
		primaryStage.setScene(scene);
		primaryStage.show();  
		
	}
	public static void main(String[] args) {
		launch(args);
	}

}
