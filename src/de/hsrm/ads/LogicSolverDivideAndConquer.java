package de.hsrm.ads;

import java.util.Arrays;

public class LogicSolverDivideAndConquer {


    /* Redundant class
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

        short[] toShortArray(){
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
        if(pos >= input.length)return;
        if(input[pos] == 2){
            input[pos+1] += 1;
            input[pos] = 0;
            getNextBit(input,pos+1);
        }
    }


    static short[][] solutionsForClause(short[] clause) {

        short[][] solution = new short[clause.length*clause.length-1][clause.length];
        short[] bits = new short[clause.length];




        return null;
        // FIXME
    }

    static short[][] solveDivideAndConquer(short[][] formula) {
        return null;
        // FIXME
    }

}
