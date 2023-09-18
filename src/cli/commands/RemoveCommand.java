package cli.commands;

import cli.commands.command_pattern.Command;
import repository.Repository;

public class RemoveCommand
    implements Command
{
    private Repository receiver;

    public RemoveCommand(Repository repository, String[] arguments)
    {
        receiver = repository;
    }

    @Override
    public void execute()
    {
        // TODO: i need the implementation of the remove button
        System.out.println("REMOVE NOT WORKING");
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
