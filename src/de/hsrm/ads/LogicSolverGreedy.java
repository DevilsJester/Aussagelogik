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
        int c = 0;
        for(int i = 0; i < formula.length; i++) {
            short temp[] = formula[i];
            if(!satisfies(assignment,temp)) return false;
            for(int j = 0; j < formula[i].length;j++) {
                if(assignment[i]*formula[i][j]==1) c++;
            }
        }

        return true;
        // FIXME
    }

    static boolean satisfiable(short[] assignment, short[] clause) {
        if(satisfies(assignment,clause)) return true;
        boolean res = false;
        //short[] copy = assignment.clone();

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
        // FIXME
    }
    //test ronny
    static short[] solveGreedy(short[][] formula) {

        System.out.println(Arrays.deepToString(formula));
        short[] assignment = new short[formula[0].length];

        /*for(int i = 0; i < assignment.length; i++){ //fill array with -1 (cannot use Arrays.fill())
            assignment[i] = -1;
        }*/

        for(int i = 0; i < assignment.length; i++){
            short[] temp = assignment.clone();
            for(int j = i; j < assignment.length; j++){

            }
        }

        return null;
        // FIXME
    }
}
