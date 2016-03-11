package Lib1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;

public class IPPFix {
	
	
	//---------------------------------------------------------

	objRemove<String> filter;
	ArrayList<String> inputArr;
	
	//-----------------------------------------------------------
	
	public IPPFix(String input){
		inputArr = new ArrayList<String>(Arrays.asList(input.split("")));
		
	}
	
	//---------------------------------------------------------------------

	public void postToInfix(){
		
		filter = new objRemove<String>();
		filter.var1 = "(";
		inputArr.removeIf(filter);
		filter.var1 = ")";
		inputArr.removeIf(filter);
		filter.var1 = " ";
		inputArr.removeIf(filter);
		
		int count = 0;
		
		for(int i = 0;i<inputArr.size();i++){
			if(isOperator(inputArr.get(i))){
				count ++;
			}
		}
		
		while(count>0){
			
			int sizeHold = inputArr.size();
			for(int i = 0; i < sizeHold-2;i++){
				String hold1,hold2,hold3;
				hold1 = inputArr.get(i);
				hold2 = inputArr.get(i+1);
				hold3 = inputArr.get(i+2);
				if(!isOperator(hold1)&&!isOperator(hold2)&&isOperator(hold3)){
					inputArr.set(i, "("+hold1 + hold3 + hold2+")");
					inputArr.remove(i+1);
					inputArr.remove(i+1);
					count--;
					sizeHold -=2;
				}	
			}
		}
	}
	
	
	//------------------------------------------------------------------------------
	
public void preToInfix(){
		
		filter = new objRemove<String>();
		filter.var1 = "(";
		inputArr.removeIf(filter);
		filter.var1 = ")";
		inputArr.removeIf(filter);
		filter.var1 = " ";
		inputArr.removeIf(filter);
		
		int count = 0;
		
		for(int i = 0;i<inputArr.size();i++){
			if(isOperator(inputArr.get(i))){
				count ++;
			}
		}
		
		while(count>0){
			
			int sizeHold = inputArr.size();
			for(int i = 0; i < sizeHold-2;i++){
				String hold1,hold2,hold3;
				hold1 = inputArr.get(i);
				hold2 = inputArr.get(i+1);
				hold3 = inputArr.get(i+2);
				if(isOperator(hold1)&&!isOperator(hold2)&&!isOperator(hold3)){
					inputArr.set(i, "("+hold2 + hold1 + hold3+")");
					inputArr.remove(i+1);
					inputArr.remove(i+1);
					count--;
					sizeHold -=2;
				}
				
			}
			System.out.println(inputArr);
		}
	}
	
	
	//----------------------------------------------------------------------------------------

	
	public static boolean isOperator(String s){
		if(s.equals("/")||
				s.equals("*")||
				s.equals("+")||
				s.equals("-")){
			return true;
		}
		return false;
	}
	
	//------------------------------------------------------------------------------------
	
	
	public class objRemove<T>implements Predicate<T>{
		
		T var1;

		@Override
		public boolean test(T arg0) {
			if(var1.equals(arg0)){
				return true;
			}
			else{
				return false;
			}
		}	
	}
	
	//------------------------------------------------------------------------------------
	
	
	public ArrayList<String> getArr(){
		return inputArr;
	}
	
	
	//-----------------------------------------------------------------------------------
	
	// create a new object "IPPFix" with the parameter in infix
	// call upon the method "preToInfix" or "postToInfix"
	//use "getArr() to print out the new thing.
	
	public static void main(String[] args) {
		IPPFix arr = new IPPFix("(+ (* A B) (/ C D) )");
		arr.preToInfix();
		System.out.println(arr.getArr());
		IPPFix arr2 = new IPPFix("(A (B (C D /) +) *)");
		arr2.postToInfix();
		System.out.println(arr2.getArr());
		
	}
	
	
}
