
package de.hsrm.ads;

import java.util.Arrays;

public class LogicSolverBacktracking {

    static boolean satisfies(short[] assignment, short[] clause) {
        for (int i=0; i<clause.length; ++i)
            if(assignment[i]*clause[i]==1)
                return true;
        return false;
    }

    static boolean satisfies(short[] assignment, short[][] formula) {
        for(int i = 0; i < formula.length; i++) {
            short[] temp = formula[i];
            if(!satisfies(assignment,temp)) return false;
        }
        return true;
    }

    static boolean satisfiable(short[] assignment, short[] clause) {
        if(satisfies(assignment,clause)) return true;
        boolean res = false;
        short[] z = new short[assignment.length];
        short[] Z = new short[assignment.length];
        for(int i = 0, c = 0; i <clause.length; i++) {
            if(assignment[i] == 0 && c == i) {
                z[i] = 1;
                Z[i] = -1;
                c = 0;
            }
            if(assignment[i] == 0 && c != i) {
                z[i] = -1;
                Z[i] = 1;
                c++;
            }
            if(assignment[i] != 0) {
                z[i] = assignment[i];
                Z[i] = assignment[i];
            }
            if(satisfies(z,clause) || satisfies(Z,clause)) res = true;

        }
        return res;
    }

    static boolean satisfiable(short[] assignment, short[][] formula) {
        for(int i = 0; i < formula.length; i++) {
            short[] temp = formula[i];
            if(!satisfiable(assignment,temp)) return false;
        }
        return true;
    }


    static short[] solveBacktracking(short[][] formula) {
        short[] solution = new short[formula[0].length];
        solveBacktracking(formula,0,solution);
        return solution;
    }

    static void solveBacktracking(short[][] formula, int currentLevel,short[] currentSolution) {
        if(currentLevel == formula[0].length)return; //abort if we exceed the max length of variables


        currentSolution[currentLevel] = -1;
        if(satisfiable(currentSolution,formula))solveBacktracking(formula,currentLevel+1,currentSolution); // if possible path, run function recursively, one level deeper into the tree
        else {
            currentSolution[currentLevel] = 1;
            if(satisfiable(currentSolution,formula))solveBacktracking(formula,currentLevel+1,currentSolution);
        }
        if(currentLevel == 0 && !satisfies(currentSolution,formula))Arrays.fill(currentSolution,(short) 0); //if final solution does not satisfy, fill array with 0
    }
}
