package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Random;

public class Controller extends DataLists{

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
    private Button newGameButton;


    @FXML
    private TextArea TextField;


    @FXML
    void initialize(ActionEvent event) {

        counter = 0;

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

        TextField.clear();

    }



    @FXML
    void drawCard(ActionEvent event) {

        String imageURL;
        Image image;

        Random rand = new Random();

        int suite = rand.nextInt((deck.size()-1)+1) ;
        int value = rand.nextInt((deck.get(suite).size()-1)+1);
        counter += 1;

        String pickedCard = deck.get(suite).get(value);

        TextField.appendText(pickedCard + " ");

        deck.get(suite).remove(value);

        if (deck.get(suite).size() == 0) {

            deck.remove(suite);

        }


        switch (counter) {
            case 1 -> {
                imageURL = "file:C:\\Users\\mikma\\IdeaProjects\\BlackJack\\src\\PNG\\" + pickedCard + ".png";
                image = new Image(imageURL);
                Card1.setImage(image);
            }
            case 2 -> {
                imageURL = "file:C:\\Users\\mikma\\IdeaProjects\\BlackJack\\src\\PNG\\" + pickedCard + ".png";
                image = new Image(imageURL);
                Card2.setImage(image);
            }
            case 3 -> {
                imageURL = "file:C:\\Users\\mikma\\IdeaProjects\\BlackJack\\src\\PNG\\" + pickedCard + ".png";
                image = new Image(imageURL);
                Card3.setImage(image);
            }
            case 4 -> {
                imageURL = "file:C:\\Users\\mikma\\IdeaProjects\\BlackJack\\src\\PNG\\" + pickedCard + ".png";
                image = new Image(imageURL);
                Card4.setImage(image);
            }
            case 5 -> {
                imageURL = "file:C:\\Users\\mikma\\IdeaProjects\\BlackJack\\src\\PNG\\" + pickedCard + ".png";
                image = new Image(imageURL);
                Card5.setImage(image);
            }
        }


    }
}
