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
			AVERAGEARR[0]=calc(Rowc,0,5);
			AVERAGEARR[1]=calc(Rowc,1,10);
			Number NumPop=(AVERAGEARR[0]);
			Number percent=(AVERAGEARR[1]/AVERAGEARR[0])*100;
			data.getData().add(new XYChart.Data<Number, Number>(NumPop,percent));
		}
	}
	/**
	 * calculate the the values
	 */
	private static float calc(int rowc, int i, int where) {
		// TODO Auto-generated method stub
		for (int runV= 0;  runV <= STEPLENGTH; runV++) {
			AVERAGEARR[i]=AVERAGEARR[i]+getWert(Import.arr[rowc][where]);
		}
		Number x = AVERAGEARR[i]/STEPLENGTH;
		return AVERAGEARR[i]/STEPLENGTH;
	}	
}
