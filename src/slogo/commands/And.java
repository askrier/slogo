package slogo.commands;

import slogo.controller.Turtle;
import slogo.controller.TurtleController;
import slogo.utility.MathOps;

import java.util.ArrayList;
import java.util.Arrays;

public class And implements ICommand{

    TurtleController myTurtle;
    int myArgs = 2;
    private ArrayList<ICommand> arguments = new ArrayList<ICommand>();

    public And (TurtleController turtle) {
        myTurtle = turtle;
    }


    /**
     * Checks to see if the number of arguments available are sufficient
     * to run the command
     * @return
     */
    public boolean enoughArgs () { return arguments.size() == myArgs; }

    /**
     * Gives the command an argument
     * Manager will check if sufficient and run if needed
     * @param arg
     */
    public void setArgument (ICommand arg) {
        arguments.add(arg);
    }

    /**
     * Either uses setters on the turtle or calls other commands with the turtle
     * and arguments already provided
     */
    public void execute () {

    }

    /**
     * Is the output value that has to be present for every command
     * @return value designated by type of command
     */
    public double returnVal () {
        if (arguments.get(0).returnVal() >0 && arguments.get(1).returnVal() > 0){
            return 1.0;
        }
        else{
            return 0.0;
        }

    }

    public void clearArgs() { arguments.clear(); }
}