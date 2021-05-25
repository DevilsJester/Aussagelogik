package de.hsrm.ads;

public class LogicSolverGreedy {

    //servus min jung

    static boolean satisfies(short[] assignment, short[] clause) {
        for (int i=0; i<clause.length; ++i)
            if(assignment[i]*clause[i]==1)
                return true;
        return false;
    }

    static boolean satisfies(short[] assignment, short[][] formula) {
        int c = 0;
        for(int i = 0; i < formula.length; i++) {
            for(int j = 0; j < formula[i].length;j++) {
                if(assignment[i]*formula[i][j]==1) c++;
            }
        }
        if(c == formula.length) return true;
        return false;
        // FIXME
    }

    static boolean satisfiable(short[] assignment, short[] clause) {
        return false;
        // FIXME
    }

    static boolean satisfiable(short[] assignment, short[][] formula) {
        return false;
        // FIXME
    }
    //test ronny
    static short[] solveGreedy(short[][] formula) {
        return null;
        // FIXME
    }

}
