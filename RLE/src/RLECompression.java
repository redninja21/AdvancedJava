import java.util.ArrayList;


public class RLECompression {
	public static int[] encode (int[] source){
		ArrayList <Integer> encoded = new ArrayList <Integer>();

		// loop through the source array
		// read and store the first value in x
		// initialize a counter to 1
		// read next value in the source array and do the comparision
		// if next value = x , then increment y
		// if next value !=x , then store the x and counter to the encoded array list
		// now reset x to next value and counter to 1
		for(int a = 1; a < source.length-2; a++){

			for(int x = source[0], y = 0 ; x == source[1] ; y++ ){
				encoded.add(x);
				encoded.add(y+1);
				y = 0;
				x = source[x+2];

			}
			
		}
		return toArray(encoded);
	}

	public static int[] decode(int[] source){
		ArrayList <Integer> decoded = new ArrayList <Integer>();

		for( int x = source[0], y = source[1],z=0;z<y; z++){
			decoded.add(x);
			if(z==y){
				x = source[y+1];
				y = source[y+2];
				z = 0;
			}
		}



		return toArray(decoded);
	}

	public static int[] toArray(ArrayList <Integer> list){
		int [] output = new int [list.size()];
		for(int i = 0; i< list.size(); i++){
			output[i] = list.get(i);

			System.out.println("output :" +output[i]);

		}
		return output;

	} 


}
