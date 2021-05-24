package de.hsrm.ads;

public class LogicSolverBacktracking {

    static boolean satisfies(short[] assignment, short[] clause) {
        for (int i=0; i<clause.length; ++i)
            if(assignment[i]*clause[i]==1)
                return true;
        return false;
    }

    // Bei Bedarf können Sie hierhin andere
    // satisfies() / satisfiable() - Methoden
    // aus LogicSolverGreedy kopieren.

    static short[] solveBacktracking(short[][] formula) {
        return null;
        // FIXME
    }

}
