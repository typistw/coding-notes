package com.effective.chapterVI;

public enum Ensemble {
    SOLO(1),
    DUET(2),
    TRIO(3),
    QUARTER(4)
    ;

    private final int numberOfMusicians;
    Ensemble(int size){
        numberOfMusicians = size;
    }

    public int numberOfMusicians(){
        return numberOfMusicians;
    }
}
