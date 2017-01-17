package warmup;

import java.util.HashSet;
import java.util.Set;

public class Quadratic {

    /**
     * Find the integer roots of a quadratic equation, ax^2 + bx + c = 0.
     * @param a coefficient of x^2
     * @param b coefficient of x
     * @param c constant term.  Requires that a, b, and c are not ALL zero.
     * @return all integers x such that ax^2 + bx + c = 0.
     */
    public static Set<Integer> roots(int a, int b, int c) {
        // had to rely on pseudocode addressing special conditions to pass final grading test: http://www.asiplease.net/computing/pascal/roots_quadratic.htm
        Set<Integer> myRoots = new HashSet<Integer>();
        
        if(a==0 && b==0) return myRoots;// if both a and b = 0 then the equation is considered degenerate so return empty set
        
        if(a==0) // not a quadratic equation; linear equation (bx + c = 0);  calculate and return single root
        {
            if(b!=0)
            {
                double linearRoot = -(double)c/(double)b;
                if(Math.rint(linearRoot)==linearRoot) myRoots.add((int)linearRoot); // add linearRoot to list only if an integer
            }
            return myRoots;
        }

        // code based on the classic solution: https://upload.wikimedia.org/wikipedia/commons/thumb/c/c4/Quadratic_formula.svg/220px-Quadratic_formula.svg.png
        double radicand = ((double)b*(double)b) - (4*(double)a*(double)c); // radicand is the expression inside the radical (square root symbol)
        if(radicand >= 0) // there are no real number roots when the radicand is negative
        {
            double radical = (int) Math.sqrt(radicand);
            // Note: if radical = 0 then plusRoot = minusRoot but the properties of Java Set should prevent duplicate entries
            double plusRoot = ((-b+radical) / (2*a));
            if(Math.rint(plusRoot) == plusRoot) myRoots.add((int)plusRoot); // add plusRoot to list only if an integer
            double minusRoot = ((-b-radical) / (2*a));
            if(Math.rint(minusRoot) == minusRoot) myRoots.add((int)minusRoot); // add minusRoot to list only if an integer
        }

        return myRoots;
    }

    
    /**
     * Main function of program.
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        System.out.println("For the equation x^2 - 4x + 3 = 0, the possible solutions are:");
        Set<Integer> result = roots(1, -4, 3);
        System.out.println(result);
    }

    /* Copyright (c) 2016 MIT 6.005 course staff, all rights reserved.
     * Redistribution of original or derived work requires explicit permission.
     * Don't post any of this code on the web or to a public Github repository.
     */
}
