package de.hsrm.ads;

import java.util.Arrays;

public class LogicSolverDivideAndConquer {

    static boolean satisfies(short[] assignment, short[] clause) {
        for (int i=0; i<clause.length; ++i)
            if(assignment[i]*clause[i]==1)
                return true;
        return false;
    }

    // Bei Bedarf können Sie hierhin andere
    // satisfies() / satisfiable() - Methoden
    // aus LogicSolverGreedy kopieren.


    static short[][] solutionsForClause(short[] clause) {
        return null;
        // FIXME
    }

    static short[][] solveDivideAndConquer(short[][] formula) {
        return null;
        // FIXME
    }

}
