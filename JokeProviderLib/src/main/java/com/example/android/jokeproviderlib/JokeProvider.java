package com.example.android.jokeproviderlib;

import java.util.ArrayList;
import java.util.Random;

public class JokeProvider {

    private static ArrayList<String> jokeList = new ArrayList<String>() {{
        add("O que é, o que é? Feito para andar e não anda?\nR: A Rua.");
        add("O que é, o que é? Que dá muitas voltas e não sai do lugar?\nR: O relogio.");
        add("O que é, o que é? Tem cabeça, tem dente, tem barba, não é bicho e nem é gente?\nR: O Alho.");
        add("O que é, o que é? Que anda com os pés na cabeça?\nR: O Piolho.");
    }};

    public static String getJoke(){

        Random random = new Random();
        return jokeList.get(random.nextInt(4));
    }
}
