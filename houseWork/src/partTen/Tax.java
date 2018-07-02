package partTen;

public class Tax {
	public static final int SINGLE_FILER = 0;
	public static final int MARRIED_JOINTLY_OR_QUALIFYING_WINDOW = 1;
	public static final int MARRIED_SEPARATELY = 2;
	public static final int HEAD_OF_HOUSEHOLD = 3;
	double taxableIncome;
	private int filingStatus = -1;
	private static int[][] brackets={
				{8350,33950,82250,171550,372950,27050,65550,136750,297350},
				{16700,67900,137050,208850,372950,45200,109250,166500,297350},
				{8350,33950,68525,104425,186475,22600,54625,83250,148675},
				{11950,45500,117450,190200,372950,36250,93650,151650,297350}	
				};//5-8
	private static double[] rates = { 0.1 , 0.15, 0.25 , 0.28, 0.33, 0.35
						,0.15 , 0.275, 0.305, 0.355 , 0.391
						};//6-10
			 
	Tax(){		
		while(filingStatus < 3){
			filingStatus++;
			new Tax(filingStatus, brackets, rates, taxableIncome);
		}
	}
	

	Tax(int filingStatus , int[][] brackets ,
			double[] rates , double taxableIncome){	
		if(filingStatus == SINGLE_FILER){
			System.out.println("SINGLE_FILER:");
		}
		else if(filingStatus == MARRIED_JOINTLY_OR_QUALIFYING_WINDOW){
			System.out.println("MARRIED_JOINTLY_OR_QUALIFYING_WINDOW:");
		}
		else if(filingStatus == MARRIED_SEPARATELY)
			System.out.println("MARRIED_SEPARATELY");
		else if(filingStatus == HEAD_OF_HOUSEHOLD)
			System.out.println("HEAD_OF_HOUSEHOLD");
		
		
	int  i = 50000;	
	while(i <= 60000){
		if (i <= brackets[filingStatus][5])
			 taxableIncome = i * rates[6];
		
		else if (i <= brackets[filingStatus][6])
			 taxableIncome = brackets[filingStatus][5] * rates[6] + 
			 (i - brackets[filingStatus][5]) * rates[7];
		
		else if (i <= brackets[filingStatus][7])
			 taxableIncome = brackets[filingStatus][5] * rates[6] +
			 (brackets[filingStatus][6] - brackets[filingStatus][5]) * rates[7]	+ 
			 (i - brackets[filingStatus][6]) * rates[8];
		
		else if (i <= brackets[filingStatus][8])
			 taxableIncome = brackets[filingStatus][5] * rates[6] + 
			 (brackets[filingStatus][6] - brackets[filingStatus][5]) * rates[7] + 
			 (brackets[filingStatus][7] - brackets[filingStatus][6]) * rates[8] +
			 (i - brackets[filingStatus][7]) * rates[9];
		
		else 
			 taxableIncome = brackets[filingStatus][5] * rates[6] + 
			 (brackets[filingStatus][6] - brackets[filingStatus][5]) * rates[7] +
			 (brackets[filingStatus][7] - brackets[filingStatus][6]) * rates[8] + 
		     (brackets[filingStatus][8] - brackets[filingStatus][7]) * rates[9] +
			 (i - brackets[filingStatus][8]) * rates[10];
			
		System.out.printf("%d's tax income is %7.2f in 2001   ", i,taxableIncome);
			
		
		
		if (i <= brackets[filingStatus][0])
			 taxableIncome = i * rates[0];
		
		else if (i <= brackets[filingStatus][1])
			 taxableIncome = brackets[filingStatus][0] * rates[0] + 
			 (i - brackets[filingStatus][0]) * rates[1];
		
		else if (i <= brackets[filingStatus][2])
			 taxableIncome = brackets[filingStatus][0] * rates[0] +
			 (brackets[filingStatus][1] - brackets[filingStatus][0]) * rates[1]	+ 
			 (i - brackets[filingStatus][1]) * rates[2];
		
		else if (i <= brackets[filingStatus][3])
			 taxableIncome = brackets[filingStatus][0] * rates[0] + 
			 (brackets[filingStatus][1] - brackets[filingStatus][0]) * rates[1] + 
			 (brackets[filingStatus][2] - brackets[filingStatus][1]) * rates[2] +
			 (i - brackets[filingStatus][2]) * rates[3];
		
		else if (i <= brackets[filingStatus][4])
			 taxableIncome = brackets[filingStatus][0] * rates[0] + 
			 (brackets[filingStatus][1] - brackets[filingStatus][0]) * rates[1] +
			 (brackets[filingStatus][2] - brackets[filingStatus][1]) * rates[2] + 
			 (brackets[filingStatus][3] - brackets[filingStatus][2]) * rates[3] +
			(i - brackets[filingStatus][3]) * rates[4];
		
		else
			taxableIncome = brackets[filingStatus][0] * rates[0] + 
			(brackets[filingStatus][1] - brackets[filingStatus][0]) * rates[1] + 
			(brackets[filingStatus][2] - brackets[filingStatus][1])	* rates[2] + 
			(brackets[filingStatus][3] - brackets[filingStatus][2]) * rates[3] + 
			(brackets[filingStatus][4] - brackets[filingStatus][3]) * rates[4] +
			(i - brackets[filingStatus][4]) * rates[5];
		
		System.out.printf("%d's tax income is %7.2f in 2009\n" , i,taxableIncome);
		
		i += 1000;
		}
		
	}


	public double getTaxableIncome() {
		return taxableIncome;
	}


	public void setTaxableIncome(double taxableIncome) {
		this.taxableIncome = taxableIncome;
	}


	public int getFilingStatus() {
		return filingStatus;
	}


	public void setFilingStatus(int filingStatus) {
		this.filingStatus = filingStatus;
	}


	public static int[][] getBrackets() {
		return brackets;
	}


	public static void setBrackets(int[][] brackets) {
		Tax.brackets = brackets;
	}


	public static double[] getRates() {
		return rates;
	}


	public static void setRates(double[] rates) {
		Tax.rates = rates;
	}


	public static int getSingleFiler() {
		return SINGLE_FILER;
	}


	public static int getMarriedJointlyOrQualifyingWindow() {
		return MARRIED_JOINTLY_OR_QUALIFYING_WINDOW;
	}


	public static int getMarriedSeparately() {
		return MARRIED_SEPARATELY;
	}


	public static int getHeadOfHousehold() {
		return HEAD_OF_HOUSEHOLD;
	}

}
