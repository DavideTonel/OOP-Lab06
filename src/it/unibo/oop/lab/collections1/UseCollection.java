package it.unibo.oop.lab.collections1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Example class using {@link java.util.List} and {@link java.util.Map}.
 * 
 */
public final class UseCollection {
	
	private final static int START = 1000;
	private final static int STOP = 2000;
	private final static int ELEMS = 100_000;
	private static final int TO_MS = 1_000_000;
	private static final int TO_READ = 10_000;
	
	private static final long AFRICA_POP = 1_110_635_000L;
    private static final long AMERICAS_POP = 972_005_000L;
    private static final long ANTARCTICA_POP = 0L;
    private static final long ASIA_POP = 4_298_723_000L;
    private static final long EUROPE_POP = 742_452_000L;
    private static final long OCEANIA_POP = 38_304_000L;

    private UseCollection() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
    	final List<Integer> list = new ArrayList<>(1000);
    	for (int i = START; i < STOP; i++) {
    		list.add(i);
    	}
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
    	final List<Integer> linkedList = new LinkedList<>(list);
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
    	int tmp = list.get(0);
    	list.set(0, list.get(list.size()-1));
    	list.set(list.size()-1, tmp);
    	System.out.println(list);
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
    	for (int el : list) {
    		System.out.println(el);
    	}
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        long time = System.nanoTime();
    	for (int i = 0; i < ELEMS; i++) {
    		list.add(0, i);
    	}    	
    	time = System.nanoTime() - time;
        System.out.println("Adding " + ELEMS
                + " int elements in the head of an ArrayList took " + time
                + "ns (" + time / TO_MS + "ms)");
        
        time = System.nanoTime();
        for (int i = 0; i < ELEMS; i++) {
        	linkedList.add(0, i);
        }
        time = System.nanoTime() - time;
        System.out.println("Adding " + ELEMS
                + " int elements in the head of a LinkedList took " + time
                + "ns (" + time / TO_MS + "ms)");
        
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        time = System.nanoTime();
        for (int i = 0; i < TO_READ; i++) {
        	list.get(list.size() / 2);
        }
        time = System.nanoTime() - time;
        System.out.println("Reading " + TO_READ
                + " elements in the middle of an ArrayList took " + time
                + "ns (" + time / TO_MS + "ms)");
        
        time = System.nanoTime();
        for (int i = 0; i < TO_READ; i++) {
        	linkedList.get(linkedList.size() / 2);
        }
        time = System.nanoTime() - time;
        System.out.println("Reading " + TO_READ
                + " elements in the middle of a LinkedList took " + time
                + "ns (" + time / TO_MS + "ms)");
        
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         * 
         * Africa -> 1,110,635,000
         * 
         * Americas -> 972,005,000
         * 
         * Antarctica -> 0
         * 
         * Asia -> 4,298,723,000
         * 
         * Europe -> 742,452,000
         * 
         * Oceania -> 38,304,000
         */
        final Map<String, Long> world = new HashMap<>();
        world.put("Africa", AFRICA_POP);
        world.put("Americas", AMERICAS_POP);
        world.put("Antarctica", ANTARCTICA_POP);
        world.put("Asia", ASIA_POP);
        world.put("Europe", EUROPE_POP);
        world.put("Oceania", OCEANIA_POP);
        /*
         * 8) Compute the population of the world
         */
        long totalPop = 0;
        for (final long pop : world.values()) {
        	totalPop += pop;
        }
        System.out.println("Total population = " + totalPop);
    }
}
