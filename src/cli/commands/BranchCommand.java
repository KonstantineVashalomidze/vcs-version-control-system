package cli.commands;

import cli.commands.command_pattern.Command;
import repository.Repository;

public class BranchCommand
    implements Command
{
    private Repository receiver;

    public BranchCommand(Repository receiver, String[] arguments)
    {
        this.receiver = receiver;
    }

    @Override
    public void execute()
    {
        this.receiver.branch();
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
