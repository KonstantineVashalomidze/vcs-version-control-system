package cli.commands;

import cli.commands.command_pattern.Command;
import repository.Repository;

public class PushCommand
    implements Command
{
    private Repository receiver;

    public PushCommand(Repository repository)
    {
        receiver = repository;
    }

    @Override
    public void execute()
    {
        this.receiver.push();
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
