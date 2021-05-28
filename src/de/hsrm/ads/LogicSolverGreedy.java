package de.hsrm.ads;

import java.util.Arrays;

public class LogicSolverGreedy {


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

    static boolean satisfiable(short[] assignment, short[] clause) { //todo fix this, this is absolutely terrible.
        if(satisfies(assignment,clause)) return true;
        boolean res = false;

        int c = 0;
        for(var ass:assignment) {
            if(ass == 0)c++;
        }
        for(int i = 0; i < c; i++) {
            short[] temp = assignment.clone();
            for(int j = 0, p = 0; j < assignment.length; j++) {
                if(temp[j] == 0 && i==p) {
                    temp[j] = 1;
                    p=0;
                }
                else if(temp[j]==0){
                    temp[j] = -1;
                    p++;
                }
            }
            if(satisfies(temp,clause)) res = true;
        }

        for(int i = 0; i < c; i++) {
            short[] temp = assignment.clone();
            for(int j = 0, p = 0; j < assignment.length; j++) {
                if(temp[j] == 0 && i==p) {
                    temp[j] = -1;
                    p=0;
                }
                else if(temp[j]==0){
                    temp[j] = 1;
                    p++;
                }
            }
            if(satisfies(temp,clause)) res = true;
        }
        return res;
        // FIXME
    }

    static boolean satisfiable(short[] assignment, short[][] formula) {
        for(int i = 0; i < formula.length; i++) {
            short[] temp = formula[i];
            if(!satisfiable(assignment,temp)) return false;
        }
        return true;
    }

    static short[] solveGreedy(short[][] formula) {

        System.out.println("Input Formula: " + Arrays.deepToString(formula) + "\nSolutions for Clauses:"); //FIXME only for testing, remove in build
        short[] assignment = new short[formula[0].length];

        for(int i = 0; i < formula.length ; i++){

            short[] temp = assignment.clone();//new short[formula[i].length];
            for(int j = 0; j < temp.length; j++){
                if(satisfies(temp,formula[i]))break;
                if(formula[i][j] != 0) temp[j] = formula[i][j];
                else {
                    temp[j] = 0;
                    //continue;
                }
                if(temp[j] != 0) assignment[j] = temp[j];

                System.out.println("  ["+i+"]"+"["+j+"] = " + Arrays.toString(temp));
                //if(satisfies(temp,formula[i]))break;
            }
            System.out.println("   Assignment=>" + Arrays.toString(assignment));
            if(satisfies(assignment,formula)){
                System.out.println("Solution found, returning: " + Arrays.toString(assignment));
                return assignment;
            }
        }

        System.out.println("No Solution was found, final state was: " + Arrays.toString(assignment));
        return new short[formula[0].length];
    }
}
