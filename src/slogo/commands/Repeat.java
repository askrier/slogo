package slogo.commands;

import slogo.controller.Turtle;

import java.util.ArrayList;

public class Repeat implements ICommand {

    private Turtle myTurtle;
    int myArgs = 3;
    private ArrayList<ICommand> arguments = new ArrayList<>();
    private Variables repcount = new Variables(":repcount");
    private static ArrayList<Double> repcountTracker;
    private int repcountIndex;

    public Repeat (Turtle turtle) {
        myTurtle = turtle;
        if(repcountTracker == null) { repcountTracker = new ArrayList<>(); }
        repcountIndex = repcountTracker.size();
        if(repcountTracker.size() != 0) {
            repcountTracker.set(repcountTracker.size() - 1, repcount.returnVal());
        }
        repcountTracker.add(1.0);
        System.out.println(repcountTracker);
        repcount.setVal(1.0);
        setArgument(repcount);
    }

    @Override
    public boolean enoughArgs() { return checkArgs() == myArgs; }

    @Override
    public void setArgument(ICommand command) { arguments.add(command); }

    @Override
    public void execute() {
        arguments.get(1).execute();

        if (arguments.get(2) instanceof BlockCommand) {
            while (arguments.get(0).returnVal() <= arguments.get(1).returnVal()) {
                System.out.println("Calling repeated block");
                arguments.get(2).execute();
                //repcount.setVal(repcount.returnVal() + 1.0);
                double iter = repcountTracker.get(repcountIndex) + 1;
                repcountTracker.set(repcountIndex, iter);
                System.out.println(repcountTracker);
                repcount.setVal(iter);
            }
            repcountTracker.remove(repcountIndex);
        }
    }

    @Override
    public double returnVal() { return arguments.get(2).returnVal(); }

    @Override
    public void clearArgs() {
        arguments.clear();
    }

    private int checkArgs() { return arguments.size(); }
}
