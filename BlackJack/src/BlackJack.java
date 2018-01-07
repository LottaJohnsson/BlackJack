
public class BlackJack {
	private Dealer dealer;
	private Player[]arrayOfPlayers;
	//private int playerNumber;

	public BlackJack(int numberOfPlayers, int numberOfCards){
		arrayOfPlayers = new Player[numberOfPlayers];
		for(int n = 0; n < numberOfPlayers; n++){
			arrayOfPlayers[n]= new Player();
		}
		
		Deck gameDeck = new Deck(numberOfCards);
		dealer = new Dealer(gameDeck);
		//playerNumber = 0;
	}
	public String decideWinner(Player player){	

		if (dealer.calculateDealersCardHand() > 21 && player.calculateCardHand() > 21){
			return("Nobody wins");
		}
		else if (dealer.calculateDealersCardHand() > 21){
			return("the player is the winner");
		}
		else if (player.calculateCardHand() > 21){
			return("the dealer is the winner");
		}
		else if(dealer.calculateDealersCardHand() > player.calculateCardHand()){
			return("the dealer is the winner");
		}
		else if(player.calculateCardHand() > dealer.calculateDealersCardHand() ){
			return("the player is the winner");
		}
		else{
			return("LIKA");
		}
	}
	public void initialDeal(){
		for(int n = 0; n < arrayOfPlayers.length; n++){
			arrayOfPlayers[n].getNewCard(dealer);
			arrayOfPlayers[n].getNewCard(dealer);
			}
		//dealer.giveCardToSelf();
		//dealer.giveCardToSelf();
	}
	
	public void giveCardToActivePlayer(int index){
		arrayOfPlayers[index].getNewCard(dealer);
	}
	public void giveCardToDealer(){
		while(dealer.hasReachedMaximumCardsAllowed()==false){
			dealer.giveCardToSelf();
		}
	}
	public Player getPlayer(int index){
		return arrayOfPlayers[index];
	}
	
	public int getPlayersSum(int index){
		return arrayOfPlayers[index].calculateCardHand();
	}
	
	public int getDealersSum(){
		return dealer.calculateDealersCardHand();
	}
	
	public void resetGame(int numberOfPlayers){
		dealer.resetDeckAndCards();		
		for(int n = 0; n < numberOfPlayers; n++){
			arrayOfPlayers[n].emptyCardHand();
		}
	}

	public static void main(String[] args) {
		
		
		int numberOfCards = 52;
		int numberOfPlayers = 3;
		
		BlackJack game = new BlackJack(numberOfPlayers,numberOfCards);
		game.initialDeal();
		

		game.arrayOfPlayers[0].getNewCard(game.dealer);
		game.arrayOfPlayers[1].getNewCard(game.dealer);
		
		while(game.dealer.hasReachedMaximumCardsAllowed()==false){
			game.dealer.giveCardToSelf();
		}
		
    System.out.println(game.dealer.calculateDealersCardHand());
    System.out.println(game.arrayOfPlayers[0].calculateCardHand());
		
		for ( int i = 0; i < numberOfPlayers; i++){
			System.out.println(game.decideWinner(game.arrayOfPlayers[i]));
		}
				
		// om spelaren vill köra flera rundor --> knapp i guess?
		game.dealer.resetDeckAndCards();
		
		for(int n = 0; n < numberOfPlayers; n++){
			game.arrayOfPlayers[n].emptyCardHand();
		}
		

	}

}
