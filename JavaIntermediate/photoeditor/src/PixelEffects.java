
public class PixelEffects {

	public static int[][] copy(int[][] source) {
		return resize(source,source.length, source[0].length);
	}
	/**
	 * Resize the array image to the new width and height
	 * You are going to need to figure out how to map between a pixel
	 * in the destination image to a pixel in the source image
	 * @param source
	 * @param newWidth
	 * @param newHeight
	 * @return
	 */
	public static int[][] resize(int[][] source, int newWidth, int newHeight) {
		int width = source.length;
		//double xRatio = width/newWidth;
		int height = source[0].length;
		//double yRatio = height/newHeight;
		int[][] output = new int [newWidth][newHeight];
		for(int x = 0; x < newWidth; x++){
			for(int y = 0; y < newHeight; y++){

				output[x][y] = source[(x*width)/newWidth][(y*height)/newHeight];	


			}
		}
		return output;
	}

	public static int[][] half(int[][] source) {
		int width = source.length;
		int height = source[0].length;

		return resize(source,width/2,height/2);
	}

	public static int[][] resize(int[][] source, int[][] reference) {
		int width = reference.length;
		int height = reference[0].length;

		return resize(source,width,height);	
	}

	/**
	 *	Flips the image over the x-axis.
	 */
	public static int[][] flip(int[][] source) {
		int width = source.length;
		int height = source[0].length;
		int [][] output = new int [width][height];
		for(int x = 0; x < width; x++){
			for(int y = 0; y < height; y++){
				output[x][y] = source[width-x-1][y];

			}

		}


		return output;
	}

	/**
	 *	Mirrors the image over the y-axis.
	 */
	public static int[][] mirror(int[][] source) {
		int width1 = source.length;
		int height1 = source[0].length;
		int [][] output1 = new int [width1][height1];
		for(int x = 0; x < width1; x++){
			for(int y = 0; y < height1; y++){
				output1[x][y] = source[x][height1-y-1];

			}

		}
		return output1;
	}

	/**
	 *	Rotates the image left.
	 */
	public static int[][] rotateLeft(int[][] source) {
		return rotate(rotate(rotate(source)));
	}

	/**
	 *	Rotates the image right.
	 */
	public static int[][] rotate(int[][] source) {
		int width2 = source.length;
		int height2 = source[0].length;
		int [][] output2 = new int [height2][width2];
		for(int x = 0; x < height2; x++){
			for(int y = 0; y < width2; y++){
				output2[x][y] = source[y][x];



			}

		}
		return flip(output2);
	}

	/** 
	 * Merge the red,blue,green components from two images.
	 */
	public static int[][] merge(int[][] sourceA, int[][] sourceB) {
		int width = sourceA.length;
		int height = sourceA[0].length;
		int [][] output = new int[width][height];
		sourceB = resize(sourceB,sourceA);
		for(int x = 0; x<width; x++){
			for(int y = 0; y<height; y++){
				int pixelA=sourceA[x][y];
				int pixelB=sourceB[x][y];
				int redA = RGB.toRed(pixelA);
				int greenA = RGB.toGreen(pixelA);
				int blueA = RGB.toBlue(pixelA);
				int redB = RGB.toRed(pixelB);
				int greenB = RGB.toGreen(pixelB);
				int blueB = RGB.toBlue(pixelB);
				int redAverage = (redA + redB)/2;
				int greenAverage = (greenA + greenB)/2;
				int blueAverage = (blueA + blueB)/2;
				output[x][y] = RGB.toRGB(redAverage, greenAverage, blueAverage);
			}

		}
		return output;
	}

	public static int[][] multiply(int[][]source){
		int width = source.length;
		int height = source[0].length;

		return resize(source,width*2,height*2);

	}

	public static int[][] enlargepixels (int[][]source){
		for(int x = 0; x < 7;x++){
			source = half(source);
		}
		for(int x = 0; x < 7;x++){
			source = multiply(source);
		}

		return source;


	}
	/**
	 * Replace the green areas of the foreground image with parts of the back
	 * image.
	 */
	public static int[][] chromaKey(int[][] foreImage, int[][] backImage) {
		int width = foreImage.length;
		int height = foreImage[0].length;
		int[][] output = new int[width][height];
		backImage = resize(backImage,foreImage);
		for( int x = 0;x < width ;x++ ){
			for( int y = 0;y < height ;y++ ){
				int rgb = foreImage[x][y];
				int red = RGB.toRed(rgb);
				int blue = RGB.toBlue(rgb);
				int green = RGB.toGreen(rgb);
				if(green > 4 * Math.max(red, blue) && green > 64  || green >= red + 47 || green >=blue+100){
					output[x][y] = backImage[x][y];
					green = green - 15;
					if(green> red+10){
						green = 0;
						
					}
				}
				else{
					output[x][y] = foreImage[x][y];

				}


			}

		}
		return output;
	}

	/** 
	 *	Remove redeye. Note that sourceB is not used.
	 */
	public static int[][] redeye(int[][] source, int[][] sourceB) {
		int width = source.length;
		int height = source[0].length;
		int[][] result = new int[width][height];
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				int rgb = source[i][j];
				int red = RGB.toRed(rgb);
				int green = RGB.toGreen(rgb);
				int blue = RGB.toBlue(rgb);
				if (red > 4 * Math.max(green, blue) && red > 64) {
					red = green = blue = 0;
				}
				result[i][j] = RGB.toRGB(red, green, blue);
			}
		}
		return result;
	}

	/**
	 *	Add some funk to the image.
	 */
	public static int[][] funky(int[][] source, int[][] sourceB) {
		int width = source.length;
		int height = source[0].length;
		int [][] output = new int[width][height];
		for( int x = 0; x<width;x++ ){
			for(int y = 0 ;y<height ;y++ ){
				int rgb = source[x][y];
				int red = RGB.toRed(rgb);
				int blue = RGB.toBlue(rgb);
				int green = RGB.toGreen(rgb);

				output[x][y] = RGB.toRGB(red*green, red*blue, red*red);

			}


		}
		return output;
	}
}
