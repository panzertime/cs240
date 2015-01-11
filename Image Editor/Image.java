import java.util.*;
import java.io.*;

public class Image {
	
	public Image(Scanner src){
		System.out.println("Constructing image");
		while(src.hasNext()){
			if (src.hasNextInt()){
				width = src.nextInt();
				break;
			}
			
		}
		while(src.hasNext()){
			if(src.hasNextInt()){
				height = src.nextInt();
				break;
			}
		}
		
		pixels = new Pixel[width][height];
		
	//	while(src.hasNext()){
			if (src.next() == "255"){
				// break! we're done with skipping
				// the crap
	//			break;
			}
	//	}
		while(src.hasNextInt()){
				// I guess the listed pixels go 
				// in order of rows, then in 
				// columns... so should be plenty
				// to just fill in rows
			for (int y = 0; y < height; y++){
				for (int x = 0; x < width; x++){
					pixels[x][y] = 
							new Pixel(src.nextInt(), src.nextInt(), src.nextInt());
				}
			}
		}
	}
	
	private int width;
	private int height;
	private Pixel[][] pixels;
	
	public void toFile(File target)
		throws FileNotFoundException{
		PrintWriter p = new PrintWriter(target);
		p.print("P3\n" + width + "\n" + height + "\n" + "255" + "\n" );
		for (int y = 0; y < height; y++){
			for (int x = 0; x < width; x++){
				p.print(pixels[x][y]);
			}
		}
		p.close();
	}
	
	public void invert(){
		for (int y = 0; y < height; y++){
			for (int x = 0; x < width; x++){
				pixels[x][y].inverse();
			}
		}
	}
	
	public void grayscale(){
		for (int y = 0; y < height; y++){
			for (int x = 0; x < width; x++){
				pixels[x][y].gray();
			}
		}
	}
	
	public void emboss(){
	//	Pixel ded = new Pixel(128,128,128);
		for (int y = 0; y < height; y++){
			pixels[0][y].kill();
		}
		for (int x = 1; x < width; x++){
			pixels[x][0].kill();
		}
		for (int y = 1; y < height; y++){
			for (int x = 0; x < width; x++){
				pixels[x][y].emboss(pixels[x-1][y-1]);
			}
		}
	}
	
	public void blur(int r){
		//
	}
}

