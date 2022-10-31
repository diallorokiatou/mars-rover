package src.com.lacombe.main;

import src.com.lacombe.command.Rover;
import src.com.lacombe.model.Command;
import src.com.lacombe.model.Coordinate;
import src.com.lacombe.model.Grid;
import src.com.lacombe.model.Position;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        try {
            System.out.println("Enter grid capacity : ");
            int capacity = inputScanner.nextInt();
            Grid grid = new Grid(capacity);

            System.out.println("Enter command sequence (f,b,l,r) exemple ffff  : ");
            String commands = inputScanner.next(Pattern.compile("(f|l|b|r)+"));
            char[] moves = commands.toCharArray();
            Command command = new Command(moves);

            System.out.println("Enter starting position (int,int,(N|E|S|W)  : ");
            String positionIn = inputScanner.next(Pattern.compile("[0-9]+,[0-9]+,(N|S|E|W)"));
            String[] positionChar = positionIn.split(",");
            Position position = new Position(Integer.parseInt(positionChar[0]), Integer.parseInt(positionChar[1]), positionChar[2].charAt(0));

            System.out.println("Do you want to put some obstacles ? (y|n)  : ");
            positionIn = inputScanner.next(Pattern.compile("y|n"));
            if(positionIn.equals("y")) {
                do {
                    System.out.println("Enter position (int,int); enter exit to finish  : ");
                    positionIn = inputScanner.next(Pattern.compile("([0-9]{1},[0-9]{1})|exit"));
                    if(positionIn.equals("exit")) break;
                    positionChar = positionIn.split(",");
                    grid.setObstacle(new Coordinate(Integer.parseInt(positionChar[0]), Integer.parseInt(positionChar[1])));
                }while (true);
            }

            Rover rover = new Rover(grid);
            rover.move(position, command);

            System.out.println("The current position of rover is : " + rover.getCurrentPosition());
        }
        catch (InputMismatchException e){
            System.err.println("Wrong input");
            e.printStackTrace();
        }

    }
}
