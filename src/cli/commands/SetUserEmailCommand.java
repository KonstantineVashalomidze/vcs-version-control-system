package cli.commands;

import cli.commands.command_pattern.Command;
import repository.Repository;

public class SetUserEmailCommand
    implements Command
{

    private Repository receiver;
    public SetUserEmailCommand(Repository repository, String argument)
    {
        receiver = repository;
    }

    @Override
    public void execute()
    {
        receiver.setGlobalConfig();
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
    public boolean canExecute()
    {
        return false;
    }

    @Override
    public String getDescription()
    {
        return null;
    }
}
