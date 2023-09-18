package cli.commands;

import cli.commands.command_pattern.Command;
import repository.Repository;

public class InitCommand
        implements Command
{
    private Repository receiver;

    public InitCommand(Repository repository)
    {
        receiver = repository;
    }

    @Override
    public void execute()
    {
        this.receiver.init();
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
