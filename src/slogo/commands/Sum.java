package slogo.commands;

import slogo.controller.Turtle;
import slogo.utility.MathOps;

import java.util.ArrayList;
import java.util.Arrays;

public class Sum implements ICommand{

    Turtle myTurtle;
    int myArgs = 2;
    private ArrayList<ICommand> arguments = new ArrayList<ICommand>();

    public Sum (Turtle turtle) {
        myTurtle = turtle;
    }


    /**
     * Checks to see if the number of arguments available are sufficient
     * to run the command
     * @return
     */
    public boolean enoughArgs () {
        return check_arg() == myArgs;
    }

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
        return MathOps.sum(arguments.get(0).returnVal(),arguments.get(1).returnVal());

    }

    @Override
    public void clearArgs() { arguments.clear(); }

    private void add_arg(ICommand arg){
        arguments.add(arg);
    }

    private int check_arg(){
        return arguments.size();
    }
}
