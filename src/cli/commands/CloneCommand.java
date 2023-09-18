package cli.commands;

import cli.commands.command_pattern.Command;
import repository.Repository;

public class CloneCommand
    implements Command
{
    private Repository receiver;

    public CloneCommand(Repository repository, String[] arguments)
    {
        receiver = repository;
    }

    @Override
    public void execute()
    {
        this.receiver.cloneRepository();
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
