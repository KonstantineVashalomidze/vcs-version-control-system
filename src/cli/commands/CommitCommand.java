package cli.commands;

import cli.commands.command_pattern.Command;
import repository.Repository;

public class CommitCommand
    implements Command
{
    private Repository receiver;

    public CommitCommand(Repository receiver)
    {
        this.receiver = receiver;
    }

    public CommitCommand(Repository repository, String[] arguments)
    {
        receiver = repository;
    }

    @Override
    public void execute()
    {
        this.receiver.commit();
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
