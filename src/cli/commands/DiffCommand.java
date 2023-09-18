package cli.commands;

import cli.commands.command_pattern.Command;
import repository.Repository;

public class DiffCommand
    implements Command
{
    private Repository receiver;

    public DiffCommand(Repository repository, String[] arguments)
    {
        receiver = repository;
    }

    @Override
    public void execute()
    {
        this.receiver.diff();
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
