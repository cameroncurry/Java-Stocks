/*
 * Sharpe Ratio class
 * requires a sharpeable object to return the incremental values of a portfolio or single stock etc.
 */

interface Sharpeable {
	String[] dates();
	double[] incrementalReturns();
}

public class Sharpe {
	
	private double[] values;
	
	//single asset sharpe ratio
	public Sharpe(Sharpeable sharpe){
		this.values = sharpe.incrementalReturns();
	}
	
	//sharpe ratio relative to constant rate in % (eg. risk free rate)
	public Sharpe(Sharpeable sharpe, double riskFreeRate){
		this.values = sharpe.incrementalReturns();
		for(int i=0;i<values.length;i++){
			values[i] -= (riskFreeRate/100.);
		}
	}
	
	//sharpe ratio relative to bench mark
	public Sharpe(Sharpeable a, Sharpeable b){
		String[] aDates = a.dates();
		String[] bDates = b.dates();
		
		double[] aVals = a.incrementalReturns();
		double[] bVals = b.incrementalReturns();
		
		//a and b vals should be same length
		this.values = new double[aVals.length];
		
		//System.out.println(aVals.length+" "+bVals.length);
		
		//must check date at every point to avoid bias
		for(int i=0; i<aVals.length;i++){
			
			
			if(aDates[i].matches(bDates[i])){
				values[i] = aVals[i] - bVals[i];
			}
			else {
				throw new RuntimeException("Dates must be identical at every data point");
			}
			
		}
		
	}
	
	
	//optimization by only calculating average once
	private double averageIncrementReturn = Double.NaN;
	private double stdevIncrementReturn = Double.NaN;
	
	
	public double sharpeRatio(){
		return averageIncrementalReturn() / stdevIncrementalReturn();
	}
	
	public double averageIncrementalReturn(){
		if(Double.isNaN(averageIncrementReturn)){
			double sum = 0;
			for(int i=0;i<values.length;i++){
				sum += values[i];
			}
			averageIncrementReturn =  sum / (double)values.length;
		}
		return averageIncrementReturn;
	}
	
	
	public double stdevIncrementalReturn(){
		if(Double.isNaN(stdevIncrementReturn)){
			double average = averageIncrementalReturn();
		
			double sum = 0;
			for(int i=0;i<values.length;i++){
				sum += Math.pow(values[i] - average, 2);
			}
			stdevIncrementReturn = Math.sqrt(sum / (double)(values.length-1));
		}
		return stdevIncrementReturn;
	}
	
}
