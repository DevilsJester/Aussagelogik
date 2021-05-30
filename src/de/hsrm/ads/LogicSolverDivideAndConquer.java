package de.hsrm.ads;

import java.util.Arrays;

public class LogicSolverDivideAndConquer {


    /* Redundant, unused class
    static class ShortLinkedList {
        int level = 0;
        short head = Short.MIN_VALUE; //using min_value as a alternative to "null"
        ShortLinkedList tail = null;

        ShortLinkedList(short hd,int lv){
            this.head = hd;
            this.level = lv;
        }
        ShortLinkedList(short hd,short[] tl,int lv){
            this.head = hd;
            this.level = lv;
            if(tl.length > 1) {
                short[] tmp = new short[tl.length - 1];
                for (int i = 1; i < tl.length; i++) tmp[i - 1] = tl[i];
                this.tail = new ShortLinkedList(tl[0], tmp, level+1);
            }
            else {
                this.tail = new ShortLinkedList(tl[0],level+1);
            }
        }

        short head(){
            return head;
        }
        ShortLinkedList tail(){
            return tail;
        }
        int length(){
            if(tail == null)return 0;
            return 1 + tail.length();
        }

        ShortLinkedList last(){
            if(tail == null)return this;
            return tail().last();
        }

        short[] toShortArray(){ //unfinished
            if(tail == null){
                short[] t = new short[1];
                t[0] = head;
                return t;
            }
            short[] re = new short[length()];
            short[] tmp = tail.toShortArray();
            System.out.println(Arrays.toString(tmp));
            for(int i = 1;i <= tmp.length;i++){
                if(i == 1){
                    re[0] = head;
                    continue;
                }
                re[i] = tmp[i];
            }
            return re;
        }
    }
     */

    static boolean satisfies(short[] assignment, short[] clause) {
        for (int i=0; i<clause.length; ++i)
            if(assignment[i]*clause[i]==1)
                return true;
        return false;
    }

    static short[] getNextBit(short[] input){
        short[] result = input.clone();
        result[0] += 1;
        getNextBit(result,0);
        return result;
    }

    static private void getNextBit(short[] input,int pos){
        if(pos >= input.length-1)return;
        if(input[pos] == 2){
            input[pos+1] += 1;
            input[pos] = 0;
            getNextBit(input,pos+1);
        }
    }


    static short[][] solutionsForClause(short[] clause) {
        short[][] solution = new short[0][clause.length];
        short[] bits = new short[clause.length];

        for(int i = 0;i < bits.length*bits.length && bits[bits.length-1] != 2;i++){
            short[] temp = new short[bits.length];
            for(int j = 0; j < temp.length; j++){ //interpret bits into 1 and -1
                if(bits[j] == 0)temp[j] = -1;
                else temp[j] = 1;
            }
            if(satisfies(temp,clause)){
                solution = appendToMatrix(solution,temp);
            }
            bits = getNextBit(bits);
        }
        return solution;
    }

    static short[][] appendToMatrix(short[][] target,short[] array){ //target[0].length and array.length need to be the same
        short[][] re = new short[target.length+1][array.length];
        for(int i = 0; i < target.length+1; i++){
            if(i == target.length){
                re[i] = array;
                break;
            }
            re[i] = target[i];
        }
        return re;
    }

     static short[][] merge(short[][] solution1,short[][] solution2) {
         short[][] re = new short[][]{}; //resolution array returns nothing if no solution found

         short[][] Z = solution1.clone();//current clause solutions
         short[][] z = solution2.clone();//next clause to compare to

         for (int j = 0; j < z.length; j++) { //for loops to  compare the first clause to the second
             for (short[] ind : Z) {
                 if (Arrays.equals(ind, z[j])) {
                     re = appendToMatrix(re,ind);
                 }
             }
         }
         return re;
     }



    static short[][] solveDivideAndConquer(short[][] formula) {

        if(formula.length == 0)return new short[][]{};
        short[][] solution = new short[0][formula[0].length];

        if(formula.length == 1){ // return solution if there is no merging necessary
            return solutionsForClause(formula[0]);
        }

        for(int i = 1;i < formula.length;i++){
            if(i==1){ //get first two solutions and merge them
                solution = merge(solutionsForClause(formula[0]),solutionsForClause(formula[1]));
            }
            else{ //merge the rest of the clauses with solution from before
                solution = merge(solution,solutionsForClause(formula[i]));
            }
        }

        return solution;
    }
}
