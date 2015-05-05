/*
 * Stock object for the purposes of back testing
 */

public class BTStock implements Sharpeable {
	
	public StockData data;

	public BTStock(StockData data) {
		this.data = data;
	}
	
	
	public BTStock(String query){
		
	}
	
	//latest price / initial price
	public double totalReturn(){
		double latest = data.adj_close()[data.adj_close().length-1];
		double purchase = data.adj_close()[0];
		
		return latest/purchase - 1;
	}
	
	public double[] incrementalValues(){
		double[] increments = new double[data.adj_close().length-1];
		
		for(int i=0;i<increments.length;i++){
			increments[i] = data.adj_close()[i+1] / data.adj_close()[i] - 1;
		}
		
		return increments;
	}
	
	
	
}
