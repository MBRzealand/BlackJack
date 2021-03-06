package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import java.io.*;

public class Controller extends DataLists{

    //-----------------------------------------------{ text fields }----------------------------------------------------


    @FXML
    private Text winner;

    @FXML
    private Text displayWinCounter;

    @FXML
    private TextArea turnInfo;

    @FXML
    private Text playerBust;

    @FXML
    private Text compBust;

    @FXML
    private Text displayWinCounter2;

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

    @FXML
    private Button loadButton;


    //--------------------------------------------{ Framework Functions }-----------------------------------------------

    public Controller() throws FileNotFoundException {
    }

    public void initialize(){

        refillDeck();
        displayWinCounter.setText("0");
        displayWinCounter2.setText("0");

    }

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

    void clearStoredData() throws FileNotFoundException {

        playerWon = false;
        computerWon = false;

        enableButtons();

        turnInfo.setText(null);

        winner.setText(null);

        hearts.clear();
        clubs.clear();
        spades.clear();
        diamonds.clear();

        deck.clear();
        playerCards.clear();
        computerCards.clear();
        intPlayerCards.clear();
        intComputerCards.clear();
        playerMoves.clear();
        computerMoves.clear();

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

        saveStringToFile();
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
            playerWon = true;
            compBust.setText("Computer Bust!");
            disableButtons();
        }

        if (playerScore > 21){
            computerWon = true;
            playerBust.setText("Player Bust!");
            disableButtons();
        }

    }

    void checkForWin(){

        if(playerMoves.get(playerMoves.size()-1).equals("Stand")
        && (computerMoves.get(computerMoves.size()-1).equals("Stand") )){

            if (playerScore >= computerScore){
                playerWon = true;
            }

            if (computerScore > playerScore){
                computerWon = true;
            }

        }


        if(playerWon){
            winner.setText("Player Won!");
            disableButtons();
        }

        if(computerWon){
            winner.setText("Computer Won!");
            disableButtons();
        }

    }

    void disableButtons(){
        playerHitButton.setDisable(true);
        playerStandButton.setDisable(true);
        playerHitButton.setVisible(false);
        playerStandButton.setVisible(false);
    }

    void enableButtons(){
        playerHitButton.setDisable(false);
        playerStandButton.setDisable(false);
        playerHitButton.setVisible(true);
        playerStandButton.setVisible(true);
        loadButton.setDisable(false);
        loadButton.setVisible(true);
    }

    void updateWinCount(){

        if (winner.getText().equals("Player Won!")){

            playerWinCount += 1;

            displayWinCounter.setText(Integer.toString(playerWinCount));

        }

        if (winner.getText().equals("Computer Won!")){

            computerWinCount += 1;

            displayWinCounter2.setText(Integer.toString(computerWinCount));

        }

    }

    void saveStringToFile() throws FileNotFoundException {

        try (PrintStream out = new PrintStream(new FileOutputStream("currentScore.txt"))) {
            out.print(displayWinCounter.getText()+"\n");
            out.print(displayWinCounter2.getText()+"\n");

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

    void computerHit() {

        computerMoves.add("Hit");

        computerTakesCardFromDeck();

        displayComputerCard();

        checkComputerScore();
        checkPlayerScore();
        checkForBust();
        checkForWin();



        turnInfo.appendText("Computer Hits!\n");

    }

    void computerStand() {

        checkComputerScore();
        checkPlayerScore();
        checkForBust();
        checkForWin();

        computerMoves.add("Stand");

        turnInfo.appendText("Computer Stands!\n");

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
        checkForBust();
        checkForWin();

        if(!playerWon && !computerWon) {
            if (computerScore >= 17) {
                computerStand();
            } else if (((playerScore > computerScore) && (playerScore <= 21)) || (computerScore < 17)) {
                computerHit();
            }
        }

        checkPlayerScore();
        checkComputerScore();
        checkForBust();
        checkForWin();

    }

    //-----------------------------------------------{ In-app functions }-----------------------------------------------


    @FXML
    void newGame(ActionEvent event) throws FileNotFoundException {

        updateWinCount();
        clearStoredData();
        refillDeck();

    }

    @FXML
    void playerHit(ActionEvent event) {

        playerMoves.add("Hit");

        if (!playerWon && !computerWon) {

            playerTakesCardFromDeck();

            displayPlayerCard();
        }

        checkPlayerScore();
        checkComputerScore();
        checkForBust();
        checkForWin();

        think();

    }

    @FXML
    void playerStand(ActionEvent event) {

        playerMoves.add("Stand");

        checkPlayerScore();
        checkComputerScore();
        checkForBust();
        checkForWin();

        if (!playerWon && !computerWon) {
            think();
        }

    }

    @FXML
    void loadScore(ActionEvent event) throws IOException {
        displayWinCounter.setText(in.readLine());
        displayWinCounter2.setText(in.readLine());
        loadButton.setDisable(true);
        loadButton.setVisible(false);
    }


}
