package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class Controller extends DataLists{

    //-----------------------------------------------{ text fields }----------------------------------------------------

//    @FXML
//    private TextArea bugfixing;

    @FXML
    private Text playerBust;

    @FXML
    private Text compBust;

    //----------------------------------------------{ card displays }---------------------------------------------------

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

    //----------------------------------------------------{ Buttons }---------------------------------------------------

    @FXML
    private Button playerHitButton;

    @FXML
    private Button playerStandButton;

    @FXML
    private Button newGameButton;

    //--------------------------------------------{ Framework Functions }-----------------------------------------------

    void refillDeck(){

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

    }

    void clearStoredData(){

//        bugfixing.clear();

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

        playerScore = 0;
        computerScore = 0;

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

    void pickCard(){

        suite = rand.nextInt((deck.size() - 1) + 1);
        value = rand.nextInt((deck.get(suite).size() - 1) + 1);

    }

    void faceCardToTen(){

        if ((cardNumVal > 10)&&(cardNumVal < 14)){

            cardNumVal = 10;

        }
    }

    void checkForBust(){

        if (computerScore > 21){
            compBust.setText("Computer Bust!");
        }

        if (playerScore > 21){
            playerBust.setText("Player Bust!");
        }

    }

    //----------------------------------------------{ Player Functions }------------------------------------------------

    void playerTakesCardFromDeck(){

        pickCard();

        pickedCard = deck.get(suite).get(value);
        playerCards.add(pickedCard);

        deck.get(suite).remove(value);

        if (deck.get(suite).size() == 0) {

            deck.remove(suite);

        }

    }

    void displayPlayerCard(){

        counter += 1;

        image = null;

        imageURL = "file:C:\\Users\\mikma\\IdeaProjects\\BlackJack\\src\\PNG\\" + pickedCard + ".png";
        image = new Image(imageURL);

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

    }

    void checkPlayerScore(){

        playerScore = 0;
        intPlayerCards.clear();

        for (int i = 0; i < playerCards.size(); i++) {

            tmpCard = playerCards.get(i);
            splitCardName = tmpCard.split("_");
            cardNumVal = Integer.parseInt(splitCardName[0]);

            faceCardToTen();

            intPlayerCards.add(cardNumVal);

            playerScore += intPlayerCards.get(i);

        }

        checkForBust();

    }

    //-------------------------------------------------{ AI functions }-------------------------------------------------

    void computerTakesCardFromDeck(){

        pickCard();

        pickedCard = deck.get(suite).get(value);
        computerCards.add(pickedCard);

        deck.get(suite).remove(value);

        if (deck.get(suite).size() == 0) {

            deck.remove(suite);

        }

    }

    void displayComputerCard(){

        AIcounter += 1;

        image = null;

        imageURL = "file:C:\\Users\\mikma\\IdeaProjects\\BlackJack\\src\\PNG\\" + pickedCard + ".png";
        image = new Image(imageURL);

        switch (AIcounter) {
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

    void checkComputerScore(){

        computerScore = 0;
        intComputerCards.clear();

        for (int i = 0; i < computerCards.size(); i++) {

            tmpCard = computerCards.get(i);
            splitCardName = tmpCard.split("_");
            cardNumVal = Integer.parseInt(splitCardName[0]);

            faceCardToTen();

            intComputerCards.add(cardNumVal);

            computerScore += intComputerCards.get(i);

        }

        checkForBust();

    }

    void think(){

        checkPlayerScore();
        checkComputerScore();

        if ((playerScore > computerScore) && (playerScore<=21)) {
            computerHit();
        } else {
            computerStand();
        }

    }

    //-----------------------------------------------{ In-app functions }-----------------------------------------------


    @FXML
    void newGame(ActionEvent event) {

        clearStoredData();
        refillDeck();

    }



    @FXML
    void playerHit(ActionEvent event) {

        playerTakesCardFromDeck();

        displayPlayerCard();

        checkPlayerScore();

        think();

    }

    @FXML
    void playerStand(ActionEvent event) {

        checkPlayerScore();
        checkComputerScore();

        think();

    }

    void computerHit() {

        computerTakesCardFromDeck();

        displayComputerCard();

        checkComputerScore();

    }

    void computerStand() {

        checkComputerScore();
        checkPlayerScore();

    }








}
