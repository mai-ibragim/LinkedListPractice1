package com.company;

import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Animal> animals = new LinkedList<>();
        List<Cat> cats = new LinkedList<>();
        for (int i = 0; i <= 50; i++) {
            animals.add(new Cat(i));
            animals.add(new Dog(i));
            animals.add(new Mouse(i));
        }
        int catCounter = 0;
        int dogCounter = 0;
        int mouseAge = 1;
        for (int i = 0; i < animals.size(); i++) {
            if(animals.get(i) instanceof Cat) {
                catCounter++;
                if(catCounter == 5) {
                    animals.remove(animals.get(i));
                    catCounter = 0;
                }
            }
            if(animals.get(i) instanceof Dog) {
                dogCounter++;
                if(dogCounter == 3) {
                    animals.add(i + 1, new Mouse(mouseAge));
                    dogCounter = 0;
                }
            }
        }
        for (int i = 0; i < animals.size(); i++) {
            if(animals.get(i) instanceof Mouse) {
                if(animals.get(i+1) instanceof Cat) {
                    cats.add((Cat) animals.get(i+1));
                    animals.remove(animals.get(i+1));
                }
            }
        }
        animals.forEach(System.out::println);
    }
}
