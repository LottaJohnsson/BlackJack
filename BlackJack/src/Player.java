import java.util.Arrays;

public class Player {
	private Card[] cardHand;
	private int cardNumber;
	 
	
	public Player(){
		cardHand = new Card[12];
		cardNumber = 0;
	}
	
	public void getNewCard(Dealer dealer){
		cardHand[cardNumber] = dealer.getCardToGive();
		cardNumber++;
	}
	
	public int getNumberOfCards(){
		return cardNumber;
	}
	
	public Card getCardFromCardHand(int index){
		return cardHand[index];
	}
	
	public int calculateCardHand(){
		int sumOfCards = 0;
		int numberOfAces = 0;
		for(int n = 0; n < cardNumber; n++){
			if (cardHand[n].getValue() < 11){
				sumOfCards += cardHand[n].getValue();
			}
			else if(cardHand[n].getValue() <= 13){
				sumOfCards += 10;
			}
			else if(cardHand[n].getValue() == 14){
				sumOfCards += 11;
				numberOfAces++;
			}
		}
		while(sumOfCards > 21 && numberOfAces > 0){
			sumOfCards -= 10;
			numberOfAces--;
		}
		return sumOfCards;
	}
	
	public void emptyCardHand(){
		Arrays.fill(cardHand, null);
		cardNumber = 0;
	}
	
	
	
	public String toString() {
		return "Player";
	}
	
	public static void main(String[] args) {
		

	}

}
