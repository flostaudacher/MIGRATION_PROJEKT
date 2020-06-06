import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;

public class barchartMethods {

	private static final int GROUPARR[] = {500, 1000, 5000, 12500, 25000, 45000};
	private static final float VALUEARR[] = new float [6];
	/**
	 * @param s is the series of our XYChart (year) we will fill with data 
	 * @param sy is the year we are dealing with
	 * @return we are returning the XYchart
	 */
	static Series<String, Number> create(Series<String, Number> s, int sy) {
		s.setName("" + sy);
		getWertPerYear(sy);
		for (int i = 0; i < 6 ;  i++) {
			s.getData().add(new XYChart.Data<>("GROUP " + (i + 1), VALUEARR[i]));
		}
		reset();
		return s;
	}
	/**
	 * reseting the our array because we need our XYChart for multiple groups 
	 */
	private static void reset() {
		for(int i = 0; i < VALUEARR.length; i++) {
			VALUEARR[i] = 0;
		}
	}
	/**
	 * this methode sets the value of our Wert Array => of each group
	 * @param year: the year we are currently dealing with
	 */
	private static void getWertPerYear(int year) {
		int arr[] = new int [6];
		for (int Rowc = 1; Rowc < Import.anzahlZeilen; Rowc++) {
			if (getWert(Import.arr[Rowc][11]) == year) 
			{
				check(arr,Rowc);

			}	
		}
		for (int i = 0 ; i < 6; i++) {
			VALUEARR[i] = VALUEARR[i]/arr[i]*100;
		}
	}
	/**
	 * check checks which groups Value should be count up
	 */
	private static void check(int[] arr, int Rowc) {
		if (getWert(Import.arr[Rowc][5]) < GROUPARR[0]) {
			arr[0]++;
			ValueOffArray(0,getWert(Import.arr[Rowc][10]),getWert(Import.arr[Rowc][5]));
		}
		for (int x  = 1; x < 6; x++ ) {
			if (getWert(Import.arr[Rowc][5]) > GROUPARR[x-1] && getWert(Import.arr[Rowc][5]) < GROUPARR[x]) {
				arr[x]++;
				ValueOffArray(x,getWert(Import.arr[Rowc][10]),getWert(Import.arr[Rowc][5]));
			}
		}
	}
	/**
	 * @param i = which group
	 * @param wert = count Migration
	 * @param wert2 = count of total citizens
	 */
	private static void ValueOffArray(int i, float wert, float wert2) {
		VALUEARR[i] = VALUEARR[i] + wert/wert2;
	}
	/**
	 * translating string to float
	 */
	private static float getWert(String string) {
		int Wert;
		Wert = Integer.parseInt(string);
		float Wertx=Wert;
		return Wertx;
	}
}
