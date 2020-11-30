package sample;

import java.util.ArrayList;
import java.util.List;

public class Test {

    static ArrayList<String> hearts = new ArrayList<>();
    static ArrayList<String> clubs = new ArrayList<>();
    static ArrayList<String> spades = new ArrayList<>();
    static ArrayList<String> diamonds = new ArrayList<>();

    static ArrayList<ArrayList<String>> deck = new ArrayList<>();



    static void Initialize(){

        for (int i = 1; i < 14; i++) {
            hearts.add("Hearts:" + i);
            clubs.add("Clubs:" + i);
            spades.add("Spades:" + i);
            diamonds.add("Diamonds:"+ i);
        }

        deck.add(hearts);
        deck.add(clubs);
        deck.add(spades);
        deck.add(diamonds);

    }

    static void drawRandomCard(){

        int suite = (int) (Math.random()*deck.size());
        int value = (int) (Math.random()*deck.get(suite).size());

        String pickedCard = deck.get(suite).get(value);

        System.out.println(pickedCard);

        System.out.println(deck);

        deck.get(suite).remove(value);

        if (deck.get(suite).size() == 0) {

            deck.remove(suite);

        }

    }



    public static void main(String[] args) {

        Initialize();

        for (int i = 0; i < 52; i++) {

            drawRandomCard();

        }

    }


}
