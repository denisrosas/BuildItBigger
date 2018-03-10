package com.example.android.jokeproviderlib;

import java.util.ArrayList;
import java.util.Random;

public class JokeProvider {

    private static ArrayList<String> jokeList = new ArrayList<String>() {{
        add("O que eh, o que eh? Feito para andar e nao anda?\nR: A Rua.");
        add("O que eh, o que eh? Que da muitas voltas e nao sai do lugar?\nR: O relogio.");
        add("O que eh, o que eh? Tem cabeca, tem dente, tem barba, nao eh bicho e nem eh gente?\nR: O Alho.");
        add("O que eh, o que eh? Que anda com os pes na cabeca?\nR: O Piolho.");
    }};

    public static String getJoke(){

        Random random = new Random();
        return jokeList.get(random.nextInt(jokeList.size()));
    }
}
