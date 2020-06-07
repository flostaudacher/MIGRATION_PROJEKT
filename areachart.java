
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.Pane;

public class areachart extends Pane{
	
	public static AreaChart<Number, Number> areachart() {
		/**
		 * creating our xAxis therefore we had to override the classic numberAxis and make it scale logarithmic, which shows us the current size of our community
		 */
		LogarithmicNumberAxis xAxis= new LogarithmicNumberAxis();
		xAxis.setLabel("Ortsgröße/ Einwohnerzahl");
		/**
		 * creating a standard numberAxis, which shows us the percentage of migration
		 */
		NumberAxis yAxis= new NumberAxis();
		yAxis.setLabel("Migartionsanteil des Ortes in  %");
		/**
		 * creating an areaChart with the parameters we previously created
		 */
		AreaChart<Number, Number> areaChart = new AreaChart<Number,Number>(xAxis,yAxis);
		areaChart.setTitle("Orte mit Anteile an Ausländern");
		
		XYChart.Series<Number, Number> data = new XYChart.Series<>();
		data.setName("Werte des % Ausländeranteils bei jeweiliger Bevölkerung in Niederösterreich");
		
		/**
		 * creating the areachart and filling it with data, all methods needed to create the areachart can be found in the areachartmethods class
		 */
		areachartMethods.create(data);
		/**
		 * making some adjustments and returning it to the flowpane
		 */
		areaChart.setCreateSymbols(false);
		areaChart.getData().add(data);
		return areaChart;
		
	}
	
}
