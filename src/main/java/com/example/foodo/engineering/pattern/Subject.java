package com.example.foodo.engineering.pattern;

import java.util.List;
import java.util.Vector;

public abstract class Subject {
    private final List<Observer> observerList;

    protected Subject(List<Observer> observerList) {
        this.observerList = observerList;
    }

    protected Subject (Observer observer){
        this (new Vector<>());
        if (observer != null){
            this.register(observer);
        }
    }

    private void register(Observer observer) {
        observerList.add(observer);
    }
    private void unregister (Observer observer){
        observerList.remove(observer);
    }

    public void notifyObservers(Object object){
        for(Observer observer: observerList){
            observer.updateRecipeList(object);
        }
    }
}
