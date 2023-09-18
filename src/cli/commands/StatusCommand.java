package cli.commands;

import cli.commands.command_pattern.Command;
import repository.Repository;

public class StatusCommand
    implements Command
{

    private Repository receiver;

    public StatusCommand(Repository repository)
    {
        receiver = repository;
    }

    @Override
    public void execute()
    {
        this.receiver.status();
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
