
public class StockData {
	
	//arrays of data from yahoo
	//will be null if data was not requested from Data Fetcher
	public String[] dates;
	public double[] open;
	public double[] high;
	public double[] low;
	public double[] close;
	public double[] volume;
	public double[] adj_close;
	
	
	//dates array is needed for stock data, all other arrays are optional
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
			System.out.printf("%s ",dates[i]);
			
			try{
				System.out.printf("%f ",open[i]);
			}catch(NullPointerException e){
				//don't print anything
			}
			try{
				System.out.printf("%.2f ",high[i]);
			}catch(NullPointerException e){}
			try{
				System.out.printf("%.2f ",low[i]);
			}catch(NullPointerException e){}
			try{
				System.out.printf("%.2f ",close[i]);
			}catch(NullPointerException e){}
			try{
				System.out.printf("%.0f ",volume[i]);
			}catch(NullPointerException e){}
			try{
				System.out.printf("%.2f ",adj_close[i]);
			}catch(NullPointerException e){}
			
			System.out.println();
		}
		
	}
}
