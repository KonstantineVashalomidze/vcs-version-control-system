package cli.commands;

import cli.commands.command_pattern.Command;
import repository.Repository;

public class AddCommand
    implements Command
{

    private Repository receiver;

    public AddCommand(Repository receiver, String[] arguments)
    {
        this.receiver = receiver;
    }

    @Override
    public void execute()
    {
        this.receiver.add();
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
