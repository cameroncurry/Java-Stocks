import java.util.ArrayList;

public class BTPortfolio implements Sharpeable {
	
	//defines portfolio position of stock and number of shares 
	//(I don't really want to deal with the all the feature of a map) 
	private class BTStockPosition {
		
		public BTStock stock;
		public int N;
		
		public BTStockPosition(int N, BTStock stock){
			this.N = N;
			this.stock = stock;
		}
	}
	
	
	//list of stocks and # of shares
	private ArrayList<BTStockPosition> stockList;

	
	public BTPortfolio(){
		stockList = new ArrayList<BTStockPosition>(10);
	}
	
	public void add(int N, BTStock s){
		stockList.add(new BTStockPosition(N,s));
	}
	
	//dollar amount of money made in portfolio
	public double absoluteReturn(){
		double profit = 0;
		
		for(int i=0, size=stockList.size(); i<size; i++){
			profit += stockList.get(i).stock.absoluteReturn() * stockList.get(i).N;
		}
		return profit;
	}
	
	@Override
	public String[] dates() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public double[] incrementalReturns() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	public double[] incrementalReturns() {
		ArrayList<ArrayList<String>> listOfDates = getListOfStockDates();
		ArrayList<ArrayList<Double>> listOfPrices = getListOfStockPrices();
		
		while(listOfListsHasNext(listOfDates)){
			
		}
		
		
		
		double[][] incrementalValues = new double[stockList.size()][];
		
		//collect all incremental returns
		for(int i=0;i<incrementalValues.length;i++){
			incrementalValues[i] = stockMap[i].stock.incrementalValues();
		}
		
		//weight each incremental return for portfolio return
		
		
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
	*/
	

}
