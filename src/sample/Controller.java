package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class Controller extends DataLists{

    @FXML
    private TextArea bugfixing;

    @FXML
    private Text playerBust;

    @FXML
    private Text compBust;


    @FXML
    private Button playerBustButton;

    @FXML
    private Button compBustButton;

    @FXML
    private Button hitButton;

    @FXML
    private ImageView Card1;

    @FXML
    private ImageView Card2;

    @FXML
    private ImageView Card3;

    @FXML
    private ImageView Card4;

    @FXML
    private ImageView Card5;


    @FXML
    private ImageView Computer5;

    @FXML
    private ImageView Computer4;

    @FXML
    private ImageView Computer3;

    @FXML
    private ImageView Computer2;

    @FXML
    private ImageView Computer1;



    @FXML
    private Button newGameButton;



    @FXML
    void initialize(ActionEvent event) {

        bugfixing.clear();

        hearts.clear();
        clubs.clear();
        spades.clear();
        diamonds.clear();

        deck.clear();
        playerCards.clear();
        computerCards.clear();
        intPlayerCards.clear();
        intComputerCards.clear();

        counter = 0;
        AIcounter = 0;

        for (int i = 1; i < 14; i++) {
            hearts.add(i + "_H");
            clubs.add(i + "_C");
            spades.add(i + "_S");
            diamonds.add(i + "_D");
        }

        deck.add(hearts);
        deck.add(clubs);
        deck.add(spades);
        deck.add(diamonds);


        Card1.setImage(null);
        Card2.setImage(null);
        Card3.setImage(null);
        Card4.setImage(null);
        Card5.setImage(null);

        Computer1.setImage(null);
        Computer2.setImage(null);
        Computer3.setImage(null);
        Computer4.setImage(null);
        Computer5.setImage(null);

        compBust.setText(null);
        playerBust.setText(null);

    }


    @FXML
    void drawCard(ActionEvent event) {

        image = null;

        int suite = rand.nextInt((deck.size() - 1) + 1);
        int value = rand.nextInt((deck.get(suite).size() - 1) + 1);
        counter += 1;

        String pickedCard = deck.get(suite).get(value);
        playerCards.add(pickedCard);

        imageURL = "file:C:\\Users\\mikma\\IdeaProjects\\BlackJack\\src\\PNG\\" + pickedCard + ".png";
        image = new Image(imageURL);

        deck.get(suite).remove(value);

        if (deck.get(suite).size() == 0) {

            deck.remove(suite);

        }


        switch (counter) {
            case 1 -> {
                Card1.setImage(image);
            }
            case 2 -> {
                Card2.setImage(image);
            }
            case 3 -> {
                Card3.setImage(image);
            }
            case 4 -> {
                Card4.setImage(image);
            }
            case 5 -> {
                Card5.setImage(image);
            }
        }

        checkPlayerScore();
        computerTurn();
        checkComputerScore();

    }


    void computerTurn(){

        image = null;

        int suite = rand.nextInt((deck.size() - 1) + 1);
        int value = rand.nextInt((deck.get(suite).size() - 1) + 1);
        AIcounter += 1;

        String pickedCard = deck.get(suite).get(value);
        computerCards.add(pickedCard);

        imageURL = "file:C:\\Users\\mikma\\IdeaProjects\\BlackJack\\src\\PNG\\" + pickedCard + ".png";
        image = new Image(imageURL);

        deck.get(suite).remove(value);

        if (deck.get(suite).size() == 0) {

            deck.remove(suite);

        }

        switch (counter) {
            case 1 -> {
                Computer1.setImage(image);
            }
            case 2 -> {
                Computer2.setImage(image);
            }
            case 3 -> {
                Computer3.setImage(image);
            }
            case 4 -> {
                Computer4.setImage(image);
            }
            case 5 -> {
                Computer5.setImage(image);
            }
        }

    }

    void checkPlayerScore(){

        int playerScore = 0;

        String tmpCard = playerCards.get(counter-1);

        String[] cardString = tmpCard.split("_");

        int cardVal = Integer.parseInt(cardString[0]);

        if ((cardVal > 10)&&(cardVal < 14)){
            cardVal = 10;
        }

        intPlayerCards.add(cardVal);

        bugfixing.appendText(intPlayerCards.toString() + "\n");


        for (Integer intPlayerCard : intPlayerCards) {
            playerScore += intPlayerCard;
        }

        if (playerScore > 21){
            playerBust.setText("Player Bust!");
        }

        bugfixing.appendText(Integer.toString(playerScore));

    }

    void checkComputerScore(){

        int computerScore = 0;

        String tmpCard = computerCards.get(AIcounter-1);

        String[] cardString = tmpCard.split("_");

        int cardVal = Integer.parseInt(cardString[0]);

        if ((cardVal > 10)&&(cardVal < 14)){
            cardVal = 10;
        }

        intComputerCards.add(cardVal);


        for (Integer intComputerCard : intComputerCards) {
            computerScore += intComputerCard;
        }

        if (computerScore > 21){
            compBust.setText("Computer Bust!");
        }

    }





    @FXML
    void compBust(ActionEvent event) {
        compBust.setText("Computer Bust!");
    }

    @FXML
    void playerBust(ActionEvent event) {
        playerBust.setText("Player Bust!");
    }

}
