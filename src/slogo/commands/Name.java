package slogo.commands;

public class Name implements ICommand {
    @Override
    public boolean enoughArgs() {
        return false;
    }

    @Override
    public void setArgument(ICommand command) {

    }

    @Override
    public void execute() {

    }

    @Override
    public double returnVal() {
        return 0;
    }

    @Override
    public void clearArgs() {

    }
}
