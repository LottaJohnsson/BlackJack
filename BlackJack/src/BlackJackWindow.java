import java.awt.*;
import java.awt.event.*; 
import java.util.Scanner;

import javax.swing.*;

public class BlackJackWindow extends JFrame implements ActionListener{
	
	private BlackJack game = new BlackJack(5,52);//change to number of players and number of cards, move
	private int playerTurn = 0;
	private Container contentArea;
	
	private JLabel activePlayer = new JLabel();
	private JLabel sum = new JLabel ();
	private JLabel finishedGame = new JLabel();
	private JLabel resultOne = new JLabel();
	
	private JButton cardButton = new JButton ("MORE CARDS");
	private JButton startButton = new JButton("START");
	private JButton finishButton = new JButton("FINISH TURN");
	private JButton restartButton = new JButton("RESTART");
	
	private JPanel topLabels = new JPanel(new GridLayout(1,2,5,15));
	private JPanel buttons = new JPanel(new GridLayout(1,2,5,15));
	private JPanel picturesOfCards = new JPanel(new GridLayout(1,2,1,1));//kolla hur det funkar
	private JPanel centerLabels = new JPanel();

	/*
	 1 & 2, rows and columns, 3 & 4, v gap & h gap 
	*/

	 //testin testarray 
	 /// mohaha, sneak kommentar lades in här..... och det är okej om man känner personen ish-bra
	 private JLabel arrayImage = new JLabel(TestArray.picOfCards(2,12));
	 
	 
	public BlackJackWindow () {
		super("BLACKJACK");
		setSize (500,250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible (true);
		
		contentArea = getContentPane();
		contentArea.setBackground(Color.green);
		
		//ActionListeners
		startButton.addActionListener(this);
		cardButton.addActionListener(this);
		restartButton.addActionListener(this);
		finishButton.addActionListener(this);
				
		sum.setForeground(Color.red);
			
		//panels		
		//adding labels to panels
	
		picturesOfCards.add(arrayImage);		
											//  Röd, Grön, Blå (0-255) = RGB
		picturesOfCards.setBackground(new Color(105, 149, 73));
		
		
		topLabels.add(activePlayer);
		topLabels.add(sum);
		topLabels.add(finishedGame);
		
topLabels.setBackground(Color.green);
		
		centerLabels.add(resultOne);
	
		buttons.add(startButton);
		buttons.add(finishButton);
		buttons.add(restartButton);
		buttons.add(cardButton);
			
		contentArea.add("North",topLabels);
		contentArea.add("South",buttons);
		contentArea.add("Center",picturesOfCards);
		//contentArea.add(test2);
		//contentArea.add("Center",centerLabels);
		
					
		setContentPane(contentArea);		
	}
	
	public void actionPerformed(ActionEvent event) {
		
		if (event.getSource()== startButton){
			game.initialDeal();//decide on dealer, cards or no cards?
			sum.setText("sum : " + game.getPlayersSum(playerTurn));
			activePlayer.setText("Player " + (playerTurn+1));
		 
		}
		else if(event.getSource()== cardButton){
		
			game.giveCardToActivePlayer(playerTurn);//change 0 to number of players
			sum.setText("sum : " + game.getPlayersSum(playerTurn));
			//show card?--> how?
		}
		else if(event.getSource()==finishButton){
			
			if(playerTurn < 4){//change to number of players
				playerTurn++;
				sum.setText("sum : " + game.getPlayersSum(playerTurn));
				activePlayer.setText("Player " + (playerTurn+1));
			}
			else{//finish game decide winner
			
				finishedGame.setText("The game is over");
				activePlayer.setText("Dealer");
				game.giveCardToDealer();
				sum.setText("sum : " + game.getDealersSum());	
			
				resultOne.setText("<html>Results for player 1:  " + game.decideWinner(game.getPlayer(0)) 
						 + "<br> <br>" + "Results for player 2:  " + game.decideWinner(game.getPlayer(1))
						 + "<br> <br>" + "Results for player 3:  " + game.decideWinner(game.getPlayer(2))
						 + "<br> <br>" + "Results for player 4:  " + game.decideWinner(game.getPlayer(3))
						 + "<br> <br>" + "Results for player 5:  " + game.decideWinner(game.getPlayer(4))
						 + "</html>");
//				resultTwo.setText("Results for player 2:  " + game.decideWinner(game.getPlayer(1)));
//				resultThree.setText("Results for player 3:  " + game.decideWinner(game.getPlayer(2)));
//				resultFour.setText("Results for player 4:  " + game.decideWinner(game.getPlayer(3)));
//				resultFive.setText("Results for player 5:  " + game.decideWinner(game.getPlayer(4)));
				
				contentArea.add("Center",centerLabels);
								
			}
		}
		
		else if (event.getSource()== restartButton){	//reset labels
			
			game.resetGame(5);//change to number of players
			playerTurn = 0;
			sum.setText("");
			activePlayer.setText("");
			finishedGame.setText("");
			
			contentArea.remove(centerLabels);
					
		}
	}
	
	public static void main(String[] args) {
				
		/*System.out.print("ange hur många spelare som önskas(max 5): ");
		Scanner input = new Scanner(System.in);
		int numberOfPlayers = input.nextInt();*/
		
		BlackJackWindow gameInWindow = new BlackJackWindow();
	}
}
