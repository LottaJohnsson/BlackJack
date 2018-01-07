

import java.awt.Image;

import javax.swing.*;


public class TestArray {
	
	private static ImageIcon[][] pictureArray = new ImageIcon[4][13];	
	private static String nameOfPic;
	private static ImageIcon ImagetoScale;
	private static Image scaleImage;
	
	static {
		for(int n = 0; n < 11; n++){
			for(int i= 0; i<4; i++){
				char suit;
				if(i==0){
					suit = 'D';
				}
				else if(i==1){
					suit = 'H';
				}
				else if(i==2){
					suit = 'S';
				}
				else {
					suit = 'C';
				}
				nameOfPic = ((n+2) + "" + suit + ".png");
				ImagetoScale = new ImageIcon(nameOfPic);
				scaleImage = ImagetoScale.getImage().getScaledInstance(100, 150, Image.SCALE_DEFAULT);
				pictureArray[i][n]= new ImageIcon (scaleImage);
			}
		}
		for (int n = 11; n < 13;  n++){
			
			char Vletter;
			if(n==11){
				Vletter = 'J';
			}
			else if(n==12){
				Vletter = 'Q';
			}
			else if(n==13){
				Vletter = 'K';
			}
			else {
				Vletter = 'A';
			}
			
			for (int k=1; k<4; k++){
				char suit;
				if(k==0){
					suit = 'D';
				}
				else if(k==1){
					suit = 'H';
				}
				else if(k==2){
					suit = 'S';
				}
				else {
					suit = 'C';
				}
				
				nameOfPic = Vletter+ suit + ".png";
				ImagetoScale = new ImageIcon(nameOfPic);
				scaleImage = ImagetoScale.getImage().getScaledInstance(100, 150, Image.SCALE_DEFAULT);
				pictureArray[k][n]= new ImageIcon (scaleImage);
			}
		}
		
	}
	
	public static ImageIcon picOfCards(int Color, int value){
		return pictureArray[Color][value];
	}
			

	public static void main(String[] args) {
		
	}	
}
