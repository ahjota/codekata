package net.ahjota.praxis;

import net.ahjota.util.CircularLinkedList;
import net.ahjota.util.CircularLinkedListCircularIterator;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Flavius Josephus was a famous Jewish historian of the first century, at the
 * time of the destruction of the Second Temple. According to legend, during the
 * Jewish-Roman war he was trapped in a cave with a group of forty soldiers
 * surrounded by Romans. Preferring death to capture, the Jews decided to form a
 * circle and, proceeding around it, to kill every third person remaining until
 * no one was left. Josephus found the safe spot in the circle and thus stayed
 * alive.
 * <p/>
 * Write a function josephus(n,m) that returns a list of n people, numbered from
 * 0 to n-1, in the order in which they are executed, every mth person in turn,
 * with the sole survivor as the last person in the list. What is the value of
 * josephus(41,3)? In what position did Josephus survive?
 *
 * @author ajalon
 * @see <a href="http://programmingpraxis.com/2009/02/19/flavius-josephus/"
 * >http://programmingpraxis.com/2009/02/19/flavius-josephus/</a>
 */
public class Josephus {

    /**
     * @param args n = number of people to be executed,
     *             m = ordinal of the person who is next line to be executed
     */
    public static void main(String[] args) {
        Scanner consoleScanner = new Scanner(System.in);
        System.out.println("How many people you wanna kill?");
        int n = consoleScanner.nextInt();
        System.out.println("Each time you kill someone, it'll be the nth person in line. What is n?");
        int m = consoleScanner.nextInt();

        for (int next : josephus(n, m)) {
            System.out.println("Kill person #" + next);
        }
    }

    /**
     * @param n number of people to be executed
     * @param m number of people to skip in an execution
     * @return int array, size n, of people numbered from 0 to n-1 in the order
     * in which they are executed
     */
    public static ArrayList<Integer> josephus(int n, int m) {
        CircularLinkedList<Integer> josephusList = new CircularLinkedList<Integer>();

        int i;
        for (i = 0; i < n; ++i) {
            josephusList.addNode(i);
        }

        ArrayList<Integer> result = new ArrayList<Integer>(n);
        CircularLinkedListCircularIterator<Integer> iterator = josephusList.iterator();
        int j = 0, person = 0;


        for (i = 0; i < n; ++i) {
            j = 1;
            while (j < m) {
                person = iterator.next();
                ++j;
            }
            iterator.remove();
            result.add(person);
        }

        return result;
    }
}
