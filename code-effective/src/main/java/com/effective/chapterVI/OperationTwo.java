package com.effective.chapterVI;

public enum OperationTwo {
    PLUS("+"){
        double applay(double x, double y) {
            return x + y;
        }
    },
    MINUS("-"){
        @Override
        double applay(double x, double y) {
            return x - y;
        }
    },
    TIMES("*"){
        @Override
        double applay(double x, double y) {
            return x * y;
        }
    },
    DIVIDE("/"){
        @Override
        double applay(double x, double y) {
            return x / y;
        }
    }
    ;

    private final String symbol;
    OperationTwo(String symbol){
        this.symbol = symbol;
    }

    @Override
    public String toString(){
        return symbol;
    }

   abstract double applay(double x, double y);

}
