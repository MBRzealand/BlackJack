package sample;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Random;

public class DataLists{

    Random rand = new Random();
    Image image;

    String imageURL = "fuck";  // excuse my french, just useful for bugfixing :)
    String pickedCard = "fuck";
    String tmpCard;

    String[] splitCardName;

    int counter = 0;
    int AIcounter = 0;
    int suite = 0;
    int value = 0;

    int cardNumVal;

    int playerScore = 0;
    int computerScore = 0;



    ArrayList<String> hearts = new ArrayList<>();
    ArrayList<String> clubs = new ArrayList<>();
    ArrayList<String> spades = new ArrayList<>();
    ArrayList<String> diamonds = new ArrayList<>();

    ArrayList<ArrayList<String>> deck = new ArrayList<>();

    ArrayList<String> playerCards = new ArrayList<>();
    ArrayList<String> computerCards = new ArrayList<>();

    ArrayList<Integer> intPlayerCards = new ArrayList<>();
    ArrayList<Integer> intComputerCards = new ArrayList<>();




}
