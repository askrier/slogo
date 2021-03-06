package slogo.commands;

import slogo.controller.Turtle;

import java.util.ArrayList;

public class SetHeading implements ICommand{

    Turtle myTurtle;
    int myArgs = 1;
    double myAngle;
    private ArrayList<ICommand> arguments = new ArrayList<>();

    public SetHeading (Turtle turtle) {
        myTurtle = turtle;
    }

    public SetHeading (Turtle turtle, double angle) {
        this(turtle);
        myAngle = angle;
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
     * @param command
     */
    public void setArgument (ICommand command) {
        arguments.add(command);
    }

    /**
     * Either uses setters on the turtle or calls other commands with the turtle
     * and arguments already provided
     */
    public void execute () {
        // TODO: Call on turtle to move it forward the given distance
        arguments.get(0).returnVal();
        myTurtle.setHeading(arguments.get(0).returnVal());
    }

    /**
     * Is the output value that has to be present for every command
     * @return value designated by type of command
     */
    public double returnVal () {
        return myAngle;
    }

    @Override
    public void clearArgs() {
        arguments.clear();
    }

    public void add_arg(ICommand arg){
        arguments.add(arg);
    }

    public int check_arg(){
        return arguments.size();
    }
}

