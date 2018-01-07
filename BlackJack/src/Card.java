
public class Card {
	private int value;
	private String color;
	
	public Card(String color,int value){
		this.value = value;
		this.color = color;
	}
	public String getColor(){
		return color;
	}
	public int getValue(){
		return value;
	}
	public String toString(){
		return color + " " + value;
	}
	
	public static void main(String[] args) {
		Card newCard = new Card("hjärter", 3);
		Card secondCard = new Card("klöver", 7);
		System.out.println(newCard.getColor() + " " + newCard.getValue());
		System.out.println(secondCard.getColor() + " " + secondCard.getValue());

	}

}
