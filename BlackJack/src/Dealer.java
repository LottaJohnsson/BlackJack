
public class Dealer {
	private Player dealerPlayer;
	private Deck dealerDeck;

	public Dealer(Deck deck){
		dealerPlayer = new Player();
		dealerDeck = deck;
		
	}
	
	public void giveCardToSelf(){
		dealerPlayer.getNewCard(this); //jag vill ge kort till mig själv alltså denna dealer
	}

	public Card getCardToGive(){
		return dealerDeck.removeTopCard();
	}
	/* 
	 The dealer may not get more cards when the sum of the cards has reached 17 or higher
	 */
	public boolean hasReachedMaximumCardsAllowed(){
		return calculateDealersCardHand() >= 17;
	}
	
	public void resetDeckAndCards(){
		dealerPlayer.emptyCardHand();
		dealerDeck.redoDeck();
	}
	public int calculateDealersCardHand(){
		return dealerPlayer.calculateCardHand();
	}

	public static void main(String[] args) {
		
	}

}
