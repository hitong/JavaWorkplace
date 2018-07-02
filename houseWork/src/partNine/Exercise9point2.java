package partNine;

public class Exercise9point2 {
	public static void main(String[] args){
	Stock m = new Stock("ORCL" , "Orcl Corporation");
	m.previousClosingPrice = 34.5;
	m.currentPrice = 34.35;
	System.out.print("Stock market volatility is " + m.getChangePercent());
	}
}

class Stock{
	String symbol ;
	String name ;
	double previousClosingPrice ;
	double currentPrice;
	
	Stock(){			
	}
	
	Stock(String symbol , String name){
		this.symbol = symbol;
		this.name = name;
	}
	
	String getChangePercent(){
		return ((currentPrice - previousClosingPrice ) / 
				previousClosingPrice 
				 +"%");
	}
}