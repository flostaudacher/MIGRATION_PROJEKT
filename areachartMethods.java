import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;

public class areachartMethods {
	/*
	 * Variables needed in the entire class
	 */
	private static final int STEPLENGTH=9;
	private static final float AVERAGEARR[] = new float[2];
	/*
	 * create the Chart
	 */
	public static void create(Series<Number, Number> data) {
		createTheChart(data);
	}
	/*
	 * String gets translated to an Integer
	 */
	private static int getWert(String string) {
		int Wert;
		Wert = Integer.parseInt(string);
		return Wert;
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
			AVERAGEARR[i]=AVERAGEARR[i]+getWert(Import.arr[rowc][where]);
		}
		AVERAGEARR[i] = AVERAGEARR[i]/STEPLENGTH;
		return AVERAGEARR[i];
	}	
}
