package ar.fiuba.tdd.tp0;

import java.util.Hashtable;

public class RPNCalculator {

    private Hashtable<String,PolishOperation> operations;

    private boolean isInt(String value){                //FIXME
        return String.matches("-?\\d+(\\.\\d+)?");
    }

    private RPNCalculator(){
        operations = new Hashtable<String,PolishOperation>();
    }

    public float eval(String expression) {
        String[] tokens = expression.split(" ");
        for (String token:tokens){

        }
    }

}
