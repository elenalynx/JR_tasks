package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses = new ArrayList<>();
    public static Hippodrome game;

    public Hippodrome(List horses){
        this.horses = horses;
    }
    public static void main(String[] args) {
        game = new Hippodrome(new ArrayList());
        Horse horseKitti = new Horse("Kitti", 3, 0);
        Horse horseLili = new Horse("Lili", 3, 0);
        Horse horsePop = new Horse("Pop", 3, 0);
        game.getHorses().add(horseKitti);
        game.getHorses().add(horseLili);
        game.getHorses().add(horsePop);

        game.run();
        game.printWinner();
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public  void run(){
        for (int i = 0; i < 100; i++) {
            move();
            print();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void move(){
        for (Horse horse: horses) {
            horse.move();
        }
    }

    public void print(){
        for (Horse horse : horses) {
            horse.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public Horse getWinner(){
        double maxDistance = 0;
        Horse winnerHorse = null;
        for (Horse horse : horses) {
            if (maxDistance < horse.getDistance()){
                maxDistance = horse.getDistance();
                winnerHorse = horse;
            }
        }
        return winnerHorse;
    }

    public void printWinner(){
        String message = String.format("Winner is %s!", getWinner().getName());
        System.out.println(message);
    }
}