package prj;
import java.text.DecimalFormat;
import java.util.Scanner;
public class Project {
				static String[] tens= {""," ten"," twenty"," thirty"," forty"," fifty"," sixty"," seventy"," eighty"," ninety"};

				  private static final String[] num1_19 = {""," one"," two"," three"," four"," five"," six"," seven"," eight"," nine"," ten"," eleven"," twelve"," thirteen"," fourteen"," fifteen",
				    " sixteen"," seventeen"," eighteen"," nineteen"};
				  private static String convert1000(int number) 
				  {
				    String n;
				    if (number % 100 < 20)
				    	{
				    		n= num1_19[number % 100];
				    		number /= 100;
				    	}
				    else 
				    	{
				    		n = num1_19[number % 10];
				    		number /= 10;
				    		n = tens[number % 10] + n;
				    		number /= 10;
				    	}
				    if (number == 0) 
				    	{
				    		return n;
				    	}
				    		return num1_19[number] + " hundred" + n;
				  }


				  public static String convert(long number) {
				    if (number == 0) 
				    {
				    	return "zero"; 
				    }

				    String snumber = Long.toString(number);
				    DecimalFormat df = new DecimalFormat("000000000000");
				    snumber = df.format(number);
				    int billions = Integer.parseInt(snumber.substring(0,3));
				    int millions  = Integer.parseInt(snumber.substring(3,6));
				    int hundredThousands = Integer.parseInt(snumber.substring(6,9));
				    int thousands = Integer.parseInt(snumber.substring(9,12));
				    String tradBillions;
				    switch (billions) {
				    case 0:
				      tradBillions = "";
				      break;
				    case 1 :
				      tradBillions = convert1000(billions)
				      + " billion ";
				      break;
				    default :
				      tradBillions = convert1000(billions)
				      + " billion ";
				    }
				    String result =  tradBillions;

				    String tradMillions;
				    switch (millions) {
				    case 0:
				      tradMillions = "";
				      break;
				    case 1 :
				      tradMillions = convert1000(millions)
				         + " million ";
				      break;
				    default :
				      tradMillions = convert1000(millions)
				         + " million ";
				    }
				    result =  result + tradMillions;

				    String tradHundredThousands;
				    switch (hundredThousands) {
				    case 0:
				      tradHundredThousands = "";
				      break;
				    case 1 :
				      tradHundredThousands = "one thousand ";
				      break;
				    default :
				      tradHundredThousands = convert1000(hundredThousands)
				         + " thousand ";
				    }
				    result =  result + tradHundredThousands;

				    String tradThousand;
				    tradThousand = convert1000(thousands);
				    result =  result + tradThousand;
				    return result.replaceAll("^\\s+", "").replaceAll("\\b\\s{2,}\\b", " ");
				  }

		public static void main(String[] args) {
		boolean aa=true;
		while(aa)
		{
			int n=new Scanner(System.in).nextInt();
			if(n<=0)
			{
				
				aa=false;
				if(n!=0)
				System.out.println("Invalid number");
			}
			else
			{
		System.out.println(new Project().convert(n));//new Scanner(System.in).nextInt());
			}
		}}


	}


