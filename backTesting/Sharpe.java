/*
 * Sharpe Ratio class
 * requires a sharpeable object to return the incremental values of a portfolio or single stock etc.
 */

interface Sharpeable {
	double[] incrementalValues();
}

public class Sharpe {
	
	private double[] values;
	
	
	private double averageIncrementReturn = Double.NaN;
	private double stdevIncrementReturn = Double.NaN;

	public Sharpe(Sharpeable sharpe){
		this.values = sharpe.incrementalValues();
	}
	
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
