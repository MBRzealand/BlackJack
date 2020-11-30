package sample;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Random;

public class DataLists{

    Random rand = new Random();
    String imageURL;
    Image image;

    ArrayList<String> hearts = new ArrayList<>();
    ArrayList<String> clubs = new ArrayList<>();
    ArrayList<String> spades = new ArrayList<>();
    ArrayList<String> diamonds = new ArrayList<>();

    ArrayList<ArrayList<String>> deck = new ArrayList<>();

    int counter = 0;
    int AIcounter = 0;

}
