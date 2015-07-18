import java.util.ArrayList;
import java.util.Arrays;


//defines portfolio position of stock and number of shares
class BTStockPosition {
	
	public BTStock stock;
	public int N;
	
	public BTStockPosition(BTStock stock, int N){
		this.stock = stock;
		this.N = N;
	}
}

public class Portfolio implements Sharpeable {
	
	//list of stocks and # of shares
	private ArrayList<BTStockPosition> stockList;

	
	public Portfolio(){
		stockList = new ArrayList<BTStockPosition>();
	}
	public Portfolio(BTStockPosition... stocks) {
		this.stockList = new ArrayList<BTStockPosition>(Arrays.asList(stocks));
	}
	
	public void add(BTStockPosition p){
		stockList.add(p);
	}

	
	public double[] incrementalReturns() {
		ArrayList<ArrayList<String>> listOfDates = getListOfStockDates();
		ArrayList<ArrayList<Double>> listOfPrices = getListOfStockPrices();
		
		while(listOfListsHasNext(listOfDates)){
			
		}
		
		
		/*
		double[][] incrementalValues = new double[stockList.size()][];
		
		//collect all incremental returns
		for(int i=0;i<incrementalValues.length;i++){
			incrementalValues[i] = stockMap[i].stock.incrementalValues();
		}
		
		//weight each incremental return for portfolio return
		
		*/
		return null;
	}
	public String[] dates(){
		//TODO
		return null;
	}
	
	//TODO
	private ArrayList<ArrayList<String>> getListOfStockDates(){
		return null;
	}
	//TODO
	private ArrayList<ArrayList<Double>> getListOfStockPrices(){
		return null;
	}
	
	
	//returns false if all lists within list of lists are empty
	//would have liked to parameterise the list as ArrayList<ArrayList<Object>> 
	//but Java won't work with me in this case
	private boolean listOfListsHasNext(ArrayList<ArrayList<String>> listOfLists){
		for(ArrayList<String> list : listOfLists){
			if(!list.isEmpty()){
				return true;
			}
		}
		return false;
	}
	
	

}
