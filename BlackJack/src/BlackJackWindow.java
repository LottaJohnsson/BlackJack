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
	private JLabel resultTwo = new JLabel();
	private JLabel resultThree = new JLabel();
	private JLabel resultFour = new JLabel();
	private JLabel resultFive = new JLabel();
	
	private JButton cardButton = new JButton ("MORE CARDS");
	private JButton startButton = new JButton("START");
	private JButton finishButton = new JButton("FINISH TURN");
	private JButton restartButton = new JButton("RESTART");
	
	private JPanel topLabels = new JPanel(new GridLayout(1,2,5,15));
	private JPanel buttons = new JPanel(new GridLayout(1,2,5,15));
	private JPanel picturesOfCards = new JPanel(new GridLayout(1,2,1,1));//kolla hur det funkar
	private JPanel centerLabels = new JPanel(new GridLayout(5,0,15,15));
	/*
	 1 & 2, rows and columns, 3 & 4, v gap & h gap 
	*/
	
	//test ImageIcons	
	private ImageIcon test = new ImageIcon("2S.png");
	private ImageIcon test3 = new ImageIcon("10H.png");
	private JLabel test2 = new JLabel(test);
	//private JLabel test4 = new JLabel(prov2);

		
	// test resize
	 Image scaleImage = test.getImage().getScaledInstance(100, 150, Image.SCALE_DEFAULT);
	 Image scaleImage2 = test3.getImage().getScaledInstance(100, 150, Image.SCALE_DEFAULT);
	 ImageIcon prov = new ImageIcon(scaleImage);
	 ImageIcon prov2 = new ImageIcon(scaleImage2);
	 
	 // test ImageIcon to Jlabels
	 private JLabel test4 = new JLabel(prov2);
	 private JLabel test5 = new JLabel(prov);
	 
	 //testin testarray
	 private JLabel arrayImage = new JLabel(TestArray.picOfCards(3,3));
	 
	 
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
		//	picturesOfCards.add(test10);
		picturesOfCards.add(test4);
		picturesOfCards.add(test5);
		picturesOfCards.add(arrayImage);
		
											//  Röd, Grön, Blå (0-255) = RGB
		picturesOfCards.setBackground(new Color(105, 149, 73));
		
		
		topLabels.add(activePlayer);
		topLabels.add(sum);
		topLabels.add(finishedGame);
		
topLabels.setBackground(Color.green);
		
		centerLabels.add(resultOne);
		centerLabels.add(resultTwo);
		centerLabels.add(resultThree);
		centerLabels.add(resultFour);
		centerLabels.add(resultFive);		
		
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
			
				resultOne.setText("Results for player 1:  " + game.decideWinner(game.getPlayer(0)));
				resultTwo.setText("Results for player 2:  " + game.decideWinner(game.getPlayer(1)));
				resultThree.setText("Results for player 3:  " + game.decideWinner(game.getPlayer(2)));
				resultFour.setText("Results for player 4:  " + game.decideWinner(game.getPlayer(3)));
				resultFive.setText("Results for player 5:  " + game.decideWinner(game.getPlayer(4)));
				
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
