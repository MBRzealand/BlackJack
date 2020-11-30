package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class Controller extends DataLists{

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

        hearts.clear();
        clubs.clear();
        spades.clear();
        diamonds.clear();

        deck.clear();

        counter = 0;
        AIcounter = 0;

        for (int i = 1; i < 14; i++) {
            hearts.add(i + "H");
            clubs.add(i + "C");
            spades.add(i + "S");
            diamonds.add(i + "D");
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

        computerTurn();

    }


    void computerTurn(){

        image = null;

        int suite = rand.nextInt((deck.size() - 1) + 1);
        int value = rand.nextInt((deck.get(suite).size() - 1) + 1);
        AIcounter += 1;

        String pickedCard = deck.get(suite).get(value);

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

    @FXML
    void compBust(ActionEvent event) {
        compBust.setText("Computer Bust!");
    }

    @FXML
    void playerBust(ActionEvent event) {
        playerBust.setText("Player Bust!");
    }

}
