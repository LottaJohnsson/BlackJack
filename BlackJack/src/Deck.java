
public class Deck {
	private Card[] cards;
	private int index;
	
	public Deck(int numberOfCards){
		cards = new Card[numberOfCards];
		index = 0;
		
		initDeck();
		shuffle();
	}
	
	private void initDeck(){
		String[] colors = {"Hjärter", "Spader", "Klöver","Ruter"};
		
		int k = 0;
		for(int value = 2; value <= 14; value++){
			for(String color : colors){
				cards[k] = new Card(color, value);
				k++;
			}
		}
	}
	
	public int getSize() {
		int length = cards.length - index;
		return length; 
	}
	
	public Card removeTopCard(){
		index++;
		return cards[index-1];
	}
	
	/*  based on https://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle
	 * */
	public void shuffle(){
		for(int size = cards.length-1; size>0; size--){
			int randomNumber = (int)(Math.random() * (size));
			Card tempCard = cards[randomNumber];
			cards[randomNumber] = cards[size];
			cards[size] = tempCard;
		}	
	}
	
	public void redoDeck(){
		index = 0;
		shuffle();
	}

	public static void main(String[] args){
		Deck deck = new Deck(52);
		
		deck.shuffle();

		for (int i = 0 ; i < deck.cards.length ; ) {
			for (int n = 0 ; n < 4 && i < deck.cards.length ; n++, i++) {
				System.out.print(deck.cards[i] + " | ");
			}
			System.out.println();
		}
	}
}