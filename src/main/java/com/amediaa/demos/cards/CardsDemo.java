package com.amediaa.demos.cards;

import com.amediaa.common.Demo;

import java.util.*;

public class CardsDemo implements Demo {

    @Override
    public void execute() {
        List<Card> deck = Card.getStandardDeck();
        Card.printDeck(deck);

        Card[] cardArray = new Card[13];
        Card aceOfHearts = Card.getFaceCard(Card.Suit.HEART, 'A');
        Arrays.fill(cardArray, aceOfHearts);
        Card.printDeck(Arrays.asList(cardArray), "Ace of Hearts", 1); // 13 Aces of Hearts printed

        List<Card> cards = new ArrayList<>(52); // 52 capacity, not size
        // Filling a size zero Collection results in an empty Collection
        Collections.fill(cards, aceOfHearts);
        System.out.println(cards); // []
        System.out.println("cards.size() = " + cards.size()); // 0

        Card kingOfClubs = Card.getFaceCard(Card.Suit.CLUB, 'K');
        List<Card> kingsOfClubs = Collections.nCopies(13, kingOfClubs);
        Card.printDeck(kingsOfClubs, "King of Clubs", 1); // 13 Kings of Clubs printed

        Collections.addAll(cards, cardArray); // adding array of cards to List of cards (13 total)
        Collections.addAll(cards, cardArray); // adding array of cards to List of cards (26 total)
        Card.printDeck(cards, "Card Collection with Aces added", 2); // 26 Aces of Hearts printed, 2 rows

        // Prior to uncommenting two lines above...
        // Number of elements in source List is greater than number of elements in destination List
        Collections.copy(cards, kingsOfClubs); // Throws exception, similar issue to fill method on Collections
        Card.printDeck(cards, "Card Collection with Kings copied", 1);

        // un-modifiable copy, pass to a List constructor for modifiable
        cards = List.copyOf(kingsOfClubs);
        Card.printDeck(cards, "List Copy of Kings", 1);

        // Collections.sort example
        var sortingAlgorithm = Comparator.comparing(Card::rank)
                .thenComparing(Card::suit);
        Collections.sort(deck, sortingAlgorithm);
        Card.printDeck(deck, "Standard Deck sorted by rank, suit", 13);

        Collections.reverse(deck);
        Card.printDeck(deck, "Sorted by rank, suit reversed: ", 13);

        List<Card> kings = new ArrayList<>(deck.subList(4, 8));
        Card.printDeck(kings, "Kings in deck", 1);

        List<Card> tens = new ArrayList<>(deck.subList(16, 20));
        Card.printDeck(tens, "Tens in deck", 1);

        // shuffle, indexOfSubList, containsAll
        Collections.shuffle(deck);
        int subListIndex = Collections.indexOfSubList(deck, tens);
        System.out.println("sublist index for tens = " + subListIndex);
        System.out.println("Contains = " + deck.containsAll(tens));

        // disjoint
        boolean disjoint = Collections.disjoint(deck, tens);
        System.out.println("disjoint = " + disjoint);

        boolean disjoint2 = Collections.disjoint(tens, kings);
        System.out.println("disjoint = " + disjoint2);

        // Binary Search
//        Collections.sort(deck, sortingAlgorithm);
        deck.sort(sortingAlgorithm);
        Card tenOfHearts = Card.getNumericCard(Card.Suit.HEART, 10);
        int foundIndex = Collections.binarySearch(deck, tenOfHearts, sortingAlgorithm);
        System.out.println("foundIndex = " + foundIndex);
        System.out.println("foundIndex = " + deck.indexOf(tenOfHearts));
        System.out.println(deck.get(foundIndex)); // Could throw an exception if not sorted

        // replaceAll
        Card tenOfClubs = Card.getNumericCard(Card.Suit.CLUB, 10);
        Card.printDeck(deck.subList(32, 36), "Tens row", 1);
        Collections.replaceAll(deck, tenOfHearts, tenOfClubs);
        Card.printDeck(deck.subList(32, 36), "Tens row", 1);

        // replaceAll returns a boolean
        if(Collections.replaceAll(deck, tenOfHearts, tenOfClubs)) {
            System.out.println("Tens of hearts replaced with tens of clubs");
        } else {
            System.out.println("No tens of hearts found in the list");
        }

        // frequency
        System.out.println("Ten of Clubs Cards = " + Collections.frequency(deck, tenOfClubs));

        // Highest and lowest
        System.out.println("Best Card = " + Collections.max(deck, sortingAlgorithm));
        System.out.println("Worst Card = " + Collections.min(deck, sortingAlgorithm));

        // Comparator w/method references
        var sortBySuit = Comparator.comparing(Card::rank)
                .thenComparing(Card::suit);
//        deck.sort(sortBySuit);
        deck.sort((s1, s2) -> s1.rank() - s2.rank());
        Card.printDeck(deck, "Sorted By Rank, Suit", 4);

        // rotate
        List<Card> copied = new ArrayList<>(deck.subList(0, 13));
        Collections.rotate(copied, 2);
        System.out.println("Unrotated: " + deck.subList(0, 13));
        System.out.println("Rotated 2: " + copied);

        // swap
        copied = new ArrayList<>(deck.subList(0, 13));
        for(int i=0; i<copied.size()/2; i++) {
            Collections.swap(copied, i, copied.size()-i-1);
        }
        System.out.println("Manual reverse: " + copied);

        // reverse
        copied = new ArrayList<>(deck.subList(0, 13));
        Collections.reverse(copied);
        System.out.println("Reverse: " + copied);
    }

}
