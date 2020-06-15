import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;

public class areachartMethods {
	/*
	 * Variables needed in the entire class
	 */
	private static final int STEPLENGTH=9;
	public static  float averageArr[] = new float[2];
	/*
	 * create the Chart
	 */
	public static void create(Series<Number, Number> data) {
		createTheChart(data);
	}
	/*
	 * String gets translated to an Integer
	 */
	private static int getValue(String string) {
		int Value;
		Value = Integer.parseInt(string);
		return Value;
	}
	/**
	 * fill the chart with data
	 */
	public static void createTheChart(Series<Number, Number> data) {
		for (int Rowc = 1; Rowc < Import.anzahlZeilen + 1; Rowc=Rowc+5) {	
			/**
			 * calculate our values for the x and the y Axis (Numpop (Number of population) and percent (percentage of emigrants in our community))
			 */
			Number NumPop=(calc(Rowc,0,5));
			Number percent=(calc(Rowc,1,10)/calc(Rowc,0,5))*100;
			/**
			 * add the data to our XY Chart 
			 */
			data.getData().add(new XYChart.Data<Number, Number>(NumPop,percent));
		}
	}
	/**
	 * calculate the the values
	 */
	private static float calc(int rowc, int i, int where) {
		for (int runV= 0;  runV <= STEPLENGTH; runV++) {
			averageArr[i]=averageArr[i]+getValue(Import.arr[rowc][where]);
		}
		averageArr[i] = averageArr[i]/STEPLENGTH;
		return averageArr[i];
	}	
}
