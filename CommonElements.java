import java.util.Arrays;

public class CommonElements{

	public static void main(String [] args)
	{
		
	}
	public static Comparable[][] insertionSort(Comparable[][] objArray) //Sorting algorithm to sort the 2d array
	{
		for (int j=0; j<objArray.length; j++)
		{
			for (int i=1; i< objArray[j].length; i++)
			{
				Comparable firstUnsorted=objArray[j][i];
				int index=i-1;
				while (index >=0 && firstUnsorted.compareTo(objArray[j][index])<0)
				{
					objArray[j][index+1]=objArray[j][index];
					index--;
				}
				objArray[j][index+1]=firstUnsorted;
			}
		
		}
		return objArray;
	}
	static int counter=0;
	public static int getComparisons() //get method to get the amount of times the query was compareed against other arrays items
	{
		return counter;
	}
	public static Comparable[] findCommonElements(Comparable [][] collections) //Method to find the common elements
	{
		
		int common=0;
		int match=0;
		Comparable[] matched;
		
		Comparable[] commonElements;
		Comparable [][] sortedArray=insertionSort(collections);
		matched= new Comparable[sortedArray[0].length];
		

		
		for (int outterindex=0; outterindex<sortedArray[0].length; outterindex++) //searches every item inside first array
		{
			
			outer:
			for (int arrayindex=1; arrayindex<sortedArray.length; arrayindex++) //searches all the other arrays
			{
				

				for (int innerindex=0; innerindex<sortedArray[arrayindex].length; innerindex++) //everything inside current array
				{
					counter++;
					if (sortedArray[0][outterindex].compareTo(sortedArray[arrayindex][innerindex])==0) //if match then cut array to where match was found until end of array break loop
					{
						
						common=1;
						int lengthOfArray=sortedArray[arrayindex].length;
						Comparable [] newArray=Arrays.copyOfRange(sortedArray[arrayindex], (innerindex+1), lengthOfArray);
						sortedArray[arrayindex]=newArray;
						
						
					
						break;
					}
					else if (sortedArray[0][outterindex].compareTo(sortedArray[arrayindex][innerindex])<0){ //if search item is larger than in the other array then break loop because not common and cut length of array
						common=0;
						int lengthOfArray=sortedArray[arrayindex].length;
						Comparable [] newArray=Arrays.copyOfRange(sortedArray[arrayindex], innerindex, lengthOfArray);
						sortedArray[arrayindex]=newArray;
						break outer;
					}
					else{
						common=0;
					}
					
				}
			}
			
			if (common==1) //if still common after all arrays then match
			{
				
				matched[match]=sortedArray[0][outterindex]; //add to array
				match++;
					
			}
		
		}
		commonElements=Arrays.copyOfRange(matched,0,match); //cut array to only matched values
		return commonElements; //return matched array

	}
}
