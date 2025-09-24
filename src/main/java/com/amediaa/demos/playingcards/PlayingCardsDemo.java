package com.amediaa.demos.playingcards;

import com.amediaa.common.Demo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Demonstrates HashSet
public class PlayingCardsDemo implements Demo {

    @Override
    public void execute() {

        PlayingCard aceHearts = new PlayingCard("Hearts", "Ace");
        PlayingCard kingClubs = new PlayingCard("Clubs", "King");
        PlayingCard queenSpades = new PlayingCard("Spades", "Queen");

        List<PlayingCard> cards = Arrays.asList(aceHearts, kingClubs, queenSpades);
        cards.forEach(s -> System.out.println(s + ": " + s.hashCode()));

        Set<PlayingCard> deck = new HashSet<>();
        for (PlayingCard c : cards) {
            if (!deck.add(c)) {
                System.out.println("Found a duplicate for " + c);
            }
        }
        System.out.println(deck);
    }
}
