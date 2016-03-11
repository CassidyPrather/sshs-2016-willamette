package Lib1;

import java.util.ArrayList;

//Creates some 2 dimensional and 3 dimensional ArrayLists
//Can also define the size of the x, y, and z dimensions, filling all
//empty values with zeros
//Don't know if y'all will use this but I use it to solve my problems pretty
//often so I made some code for it :V 


public class ArrayListInit {
	
	static ArrayList<ArrayList<Integer>>endArr2d;
	static ArrayList<ArrayList<ArrayList<Integer>>>endArr3d;
	
	//--------------------------------------------------------------
	
	public static ArrayList<ArrayList<Integer>> zero2dArr(int xDim, int yDim){
	
		endArr2d = new ArrayList<ArrayList<Integer>>();
		
		for(int i = 0; i < yDim; i++){
			ArrayList<Integer> holdArr = new ArrayList<Integer>();
			for(int j = 0; j < xDim; j++){
				int num = 0;
				holdArr.add(num);
			}
			endArr2d.add(holdArr);
			
		}
		return endArr2d;
	}
	
	//---------------------------------------------------------------------------
	
	public static ArrayList<ArrayList<ArrayList<Integer>>> zero3dArr(int xDim, int yDim, int zDim){
		endArr3d = new ArrayList<ArrayList<ArrayList<Integer>>>();
		
		for(int i = 0; i < zDim; i++){
			ArrayList<ArrayList<Integer>> holdArr = new ArrayList<ArrayList<Integer>>();
			for(int j = 0; j < yDim; j++){
				ArrayList<Integer> holdArr2 = new ArrayList<Integer>();
				for(int k = 0; k < xDim; k++){
					holdArr2.add(0);
				}
				holdArr.add(holdArr2);
			}
			endArr3d.add(holdArr);
			
		}
		return endArr3d;
	}
	
	
	//----------------------------------------------------------------------------
	
	public static ArrayList<Integer> getIntegerArray(ArrayList<String> stringArray) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(String stringValue : stringArray) {
            try {
                //Convert String to Integer, and store it into integer array list.
                result.add(Integer.parseInt(stringValue));
            } catch(NumberFormatException nfe) {
               System.out.println("Could not parse " + nfe);
               
            } 
        }       
        return result;
    }
	
	//---------------------------------------------------------------------
	
	public static ArrayList<String> getStringArray(ArrayList<Integer> intArray) {
        ArrayList<String> result = new ArrayList<String>();
        for(int intValue : intArray) {
            try {
                //Convert String to Integer, and store it into integer array list.
                result.add(Integer.toString(intValue));
            } catch(NumberFormatException nfe) {
               System.out.println("Could not parse " + nfe);
               
            } 
        }       
        return result;
    }
	
	//--------------------------------------------------------------------------
	
	public ArrayList<ArrayList<Integer>> get2dArr(){
		return endArr2d;
	}
	
	public ArrayList<ArrayList<ArrayList<Integer>>>get3dArr(){
		return endArr3d;
	}
	
	//----------------------------------------------------------------------------------
	
	public static boolean allElementsTheSame(ArrayList<String>array) {
        String first = array.get(0);
        if(first.equals(".")){
        	return false;
        }
        for (String element : array) {
            if (!element.equals(first)) {
                return false;
            }
        }
        return true;
}
	
	//------------------------------------------------------------------------------------
	
	public static void main(String[] args) {
		ArrayListInit dArr = new ArrayListInit();
		ArrayListInit.zero2dArr(2, 5);
		System.out.println(dArr.get2dArr());
		ArrayListInit.zero3dArr(2, 3, 4);
		System.out.println(dArr.get3dArr());
	}
	
}
