
public class StockData {

	//arrays of data from yahoo
	//will be null if data was not requested
	public String[] dates;
	public double[] open;
	public double[] high;
	public double[] low;
	public double[] close;
	public double[] volume;
	public double[] adj_close;
	
	
	//construct class with dates array, all other array will be set separately
	public StockData(String[] dates){
		this.dates = dates;
	}
	
	public void set(int i, double[] array){
		if(i==1){
			open = array;
		}
		else if(i==2){
			high = array;
		}
		else if(i==3){
			low = array;
		}
		else if(i==4){
			close = array;
		}
		else if(i==5){
			volume = array;
		}
		else if(i==6){
			adj_close = array;
		}
		else{
			throw new IllegalArgumentException();
		}
	}
	
	public void print(){
		for(int i=0; i<dates.length;i++){
			System.out.printf("%s %f %f %f %f %f %f\n",dates[i],open[i],high[i],low[i],close[i],volume[i],adj_close[i]);
		}
		
	}
}
