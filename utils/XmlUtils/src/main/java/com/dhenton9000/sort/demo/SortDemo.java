/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.sort.demo;

import java.util.Arrays;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * Demonstration of selection sort from
 * http://www.geekpedia.com/tutorial288_Selection-Sort-Algorithm-in-Java.html
 *
 * @author dyh
 *
 */
public class SortDemo {

    private static Logger log = LogManager.getLogger(SortDemo.class);
    private static int[] selectionSampleArray = {21, 6, 88, 23, 2, 100, 75};
    int nElemsforSelection = selectionSampleArray.length;
    private static int[] bubbleSampleArray = {768, 3, 76, 21, 32,9};
    int nElemsforBubble = bubbleSampleArray.length;

    /**
     * For each element in the array (0 to N) set min to latest sorted element
     * for each unsorted element remaining if element is less than min its a new
     * min so swap it into the latest sorted element position
     *
     * end for each unsorted element end each element in array
     */
    public void selectionSort() {
        int out, in, min;
        for (out = 0; out < nElemsforSelection - 1; out++) // outer loop
        {
            min = out; // minimum
            for (in = out + 1; in < nElemsforSelection; in++) // inner loop
            {
                if (selectionSampleArray[in] < selectionSampleArray[min]) {
                    min = in; // we have a new min
                }
            }
            swap(out, min, selectionSampleArray); // swap them
        } // end for(out)
    } // end selectionSort()

    /**
     * take the element indexed by one and push it onto two push two onto one
     *
     * @param one
     * @param two
     * @param a
     */
    private void swap(int one, int two, int[] a) {
        int temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }

    public void bubbleSort() {
        int out, in;
        for (out = nElemsforBubble - 1; out > 1; out--) {
            // outer loop (backward)
            for (in = 0; in < out; in++) {
                // inner loop (forward)
                // out of order?
                if (bubbleSampleArray[in] > bubbleSampleArray[in + 1]) {
                    swap(in, in + 1, bubbleSampleArray);
                }
            }
            
            log.debug("out "+out+" array "+ displayArray(bubbleSampleArray));
        }
    } // end bubbleSort()

    
    public String displayArray(int[] t)
    {
        String z = "";
        for (int i :t)
        {
            z += i+",";
        }
        return z;
    }
    
    
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        SortDemo sL = new SortDemo();
        sL.selectionSort();
        sL.bubbleSort();
        String disp = "";
        for (int k : selectionSampleArray) {
            disp += k + " ";
        }

        log.debug("Bubble Sorted Array: " + disp);
        disp = "";
        for (int k : bubbleSampleArray) {
            disp += k + " ";
        }
        log.debug("bubble Sorted Array: " + disp);
    }
}
