import java.util.Arrays;
import javafx.collections.FXCollections;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.Pane;

public class barchart extends Pane {
	public static BarChart<String, Number> barchart() {
		/**
		 *  creating our categoryAxis and fill it with different groups we want to use
		 */
		CategoryAxis xAxis = new CategoryAxis();  
		xAxis.setCategories(FXCollections.<String>
		observableArrayList(Arrays.asList("GROUP 1", "GROUP 2", "GROUP 3", "GROUP 4", "GROUP 5", "GROUP 6")));
		xAxis.setLabel("Anteil in den Verschiedenen Jahren");
		/**
		 * the yAxis shows us the percentage of Migration in different groups
		 */
		NumberAxis yAxis = new NumberAxis();
		yAxis.setLabel("Anteil des Migrationsantiel in %");
		/**
		 * creating our barchart with the parameters we previously created
		 */
		BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis); 
		barChart.setTitle("Werte des % Ausländeranteils bei jeweiliger Bevölkerung in Niederösterreich");		
		/**
		 * filling our barchart with data, all methods needed can be found in the barchartMethods class
		 */
		for (int i = 2012; i <= 2019; i++) {
			barChart.getData().addAll(barchartMethods.create(new XYChart.Series<String, Number>(),i));	
		}
		barChart.setCategoryGap(20);
		/**
		 * returning our barchart to our flowpane
		 */
		return barChart;
	}	
}


