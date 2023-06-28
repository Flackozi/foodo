package com.example.foodo.engineering.pattern.observer;


import java.util.List;
import java.util.Vector;

public abstract class Subject {
    private final List<Observer> observerList;

    protected Subject(){
        this((Observer) null);
    }
    protected Subject(List<Observer> observerList) {
        this.observerList = observerList;
    }

    protected Subject (Observer observer){
        this (new Vector<>());
        if (observer != null){
            this.register(observer);
        }
    }

    public void register(Observer observer) {
        observerList.add(observer);
    }
    public void notifyObservers(){
        for(Observer observer: observerList){
            observer.updateProductList();
        }
    }
}
