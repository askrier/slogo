package slogo.commands;

import slogo.controller.Turtle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BlockCommand implements ICommand {

    //private Turtle myTurtle;
    private ArrayList<ICommand> myCommands = new ArrayList<>();
    private ArrayList<Double> myReturnVals = new ArrayList<>();
    private double returnValue;

    public BlockCommand() {
        // Should be empty for now
    }

    @Override
    public boolean enoughArgs() {
        return true;
    }

    @Override
    public void setArgument(ICommand command) {
        // Blocks should not have arguments, therefore this should be used to add commands
        // to the command list
        myCommands.add(command);
    }

    @Override
    public void execute() {
        //ArrayList<ICommand> copyCommands = new ArrayList<>();
        Manager blockManager = new Manager();
        for (ICommand command : myCommands) {
            blockManager.addCommand(command);
        }
        System.out.println(myCommands.toString());
        //System.out.println(copyCommands.toString());
        returnValue = myCommands.get(0).returnVal();
        for (ICommand command : myCommands) {
            myReturnVals.add(command.returnVal());
            command.clearArgs();
        }
    }

    @Override
    public double returnVal() {
        return 0.0;
    }

    @Override
    public void clearArgs() {
        // Should be empty
    }

    public double getRetVals (int index) {
        return myReturnVals.get(index);
    }

    public Variables getVar (int index) {
        if (myCommands.get(index) instanceof Variables) {
            return (Variables) myCommands.get(index);
        } else { return null; }
    }
}