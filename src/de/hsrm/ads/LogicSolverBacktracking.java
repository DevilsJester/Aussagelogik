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

    // Bei Bedarf können Sie hierhin andere
    // satisfies() / satisfiable() - Methoden
    // aus LogicSolverGreedy kopieren.

    static short[] solveBacktracking(short[][] formula) {
        System.out.println(Arrays.deepToString(formula)); //FIXME only for testing, remove in build
        short[] assignment = new short[formula[0].length];

        //if(satisfiable(assignment,formula))return assignment; // return zero array if no solution is possible

        for(int i = 0; i < formula.length && i < formula[0].length; i++){

            short[] temp = new short[formula[i].length];
            for(int j = 0; j < temp.length; j++){
                if(formula[i][j] == 1)temp[j] = 1;
                else if(formula[i][j] == -1)temp[j] = -1;
                else {
                    temp[j] = 0;
                    continue;
                }
                if(temp[j] != 0)assignment[j] = temp[j];

                System.out.println("Temp: " + Arrays.toString(temp));
                if(satisfies(assignment,formula)){
                    System.out.println("89: Returning: " + Arrays.toString(assignment));
                    return assignment;
                }
            }
            //System.out.println("Temp: " + Arrays.toString(temp));
        }

        System.out.println("96: Returning: " + Arrays.toString(new short[formula[0].length]));
        //if(!satisfies(assignment,formula))return new short[formula.length]; old check
        return new short[formula[0].length];
        // FIXME
    }

}
