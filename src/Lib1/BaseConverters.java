package Lib1;

public class BaseConverters {

	public static String BaseConvert(int input, int to){
		int holdVal = input;
		StringBuilder outp = new StringBuilder();
		while(holdVal>=to){
			String hold = Integer.toString(holdVal % to);
			if(Integer.parseInt(hold)>9){
				int iHold = Integer.parseInt(hold);
				hold = toLetter(iHold);
			}
			outp.append(hold);
			holdVal =holdVal/to;
		}
		
		String hold = Integer.toString(holdVal % to);
		if(Integer.parseInt(hold)>9){
			int iHold = Integer.parseInt(hold);
			hold = toLetter(iHold);
		}
		outp.append(hold);
		outp.reverse();
		String outpString = outp.toString();
		return outpString;
	}
	
	//------------------------------------------------------------------------------------
	
	//only converts up to base 16, to add more, simply add more case statements.
	//for example...
	//	case 16:
	//		s = "G";
	//	break;
	//	case 17:
	//		s = "H";
	//	break;
	//	....
	
	
	public static String toLetter(int i){
		String s = "";
		switch(i){
		
			case 10:
				s="A";	
			break;
			
			case 11:
				s="B";
			break;
				
			case 12:
				s="C";
			break;
				
			case 13:
				s="D";
				break;
			case 14:
				s="E";
				break;
			case 15:
				s="F";
				break;
			
			
		}
		return s;
	}
	
	//---------------------------------------------------------------------------------------
	
	public static void main(String[]args){
		String i = BaseConvert(123456789,15);
		System.out.println(i);
	}
}
