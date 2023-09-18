package cli.commands;

import cli.commands.command_pattern.Command;
import repository.Repository;

public class CheckoutCommand
    implements Command
{

    private Repository receiver;

    public CheckoutCommand(Repository receiver, String[] arguments)
    {
        this.receiver = receiver;
    }

    @Override
    public void execute()
    {
        this.receiver.checkout();
    }

    @Override
    public void undo()
    {

    }

    @Override
    public void redo()
    {

    }

    @Override
    public boolean canExecute() {
        return true;
    }

    @Override
    public String getDescription() {
        return null;
    }

}
