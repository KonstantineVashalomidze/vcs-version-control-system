package cli.commands;

import cli.commands.command_pattern.Command;
import repository.Repository;

public class PullCommand
    implements Command
{
    private Repository receiver;

    public PullCommand(Repository repository)
    {
        receiver = repository;
    }

    @Override
    public void execute()
    {
        this.receiver.pull();
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
