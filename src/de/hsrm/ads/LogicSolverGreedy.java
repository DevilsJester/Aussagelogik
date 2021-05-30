package de.hsrm.ads;

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

    static short[] solveGreedy(short[][] formula) {

        short[] assignment = new short[formula[0].length];

        for(int i = 0; i < formula.length ; i++){ //iterate through all clauses of the formula
            for(int j = 0; j < assignment.length; j++){ //iterate through all variables of clauses
                if(satisfies(assignment,formula[i]))continue;
                if(formula[i][j] != 0 && assignment[j] == 0) assignment[j] = formula[i][j];
            }
            if(satisfies(assignment,formula)){
                return assignment;
            }
        }

        return new short[formula[0].length]; //if no solution was found, return 0 array
    }
}
