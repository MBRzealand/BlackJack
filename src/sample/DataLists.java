package sample;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Random;

public class DataLists{

    Random rand = new Random();

    String imageURL = "fuck";
    String pickedCard = "fuck";

    int counter = 0;
    int AIcounter = 0;
    int suite = 0;
    int value = 0;

    Image image;

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
