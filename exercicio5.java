public class exercicio5 {
	
public static void smallestDistance(int [] array){

	int smallest = Math.abs(array[0]-array[1]);
        int index = 0;


	for(int i=1; i<array.length-1; i++){
      
	int value = Math.abs(array[i]-array[i+1]);


       	if(value < smallest){
       	smallest = value;
       	index = i;
           
	}


	}

	System.out.println("Positions:");
        System.out.println(index);
	System.out.println(index+1);


}
   
	public static void main(String [] args){
	int []arr= new int[]{0, 5, 1209, 6, 110, 111, 1132, 33};
        smallestDistance(arr);
   
   
    }
	
}



