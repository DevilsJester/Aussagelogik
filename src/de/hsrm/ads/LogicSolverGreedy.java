package de.hsrm.ads;

public class LogicSolverGreedy {

    //testcomment

    static boolean satisfies(short[] assignment, short[] clause) {
        for (int i=0; i<clause.length; ++i)
            if(assignment[i]*clause[i]==1)
                return true;
        return false;
    }

    static boolean satisfies(short[] assignment, short[][] formula) {
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

    static short[] solveGreedy(short[][] formula) {
        return null;
        // FIXME
    }

}
