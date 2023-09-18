package cli.commands;

import cli.commands.command_pattern.Command;
import repository.Repository;

public class HelpCommand
    implements Command
{
    private Repository receiver;

    public HelpCommand(Repository repository, String[] copyOfRange)
    {
        receiver = repository;
    }

    @Override
    public void execute()
    {
        receiver.help();
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
