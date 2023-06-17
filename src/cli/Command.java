package cli;

public interface Command {
    /**
     * This method is typically used to execute the command.
     * It contains the logic that defines what the command does when it is invoked.
     */
    void execute();

    /**
     *  revert the changes made by the command.
     *  Not all commands may have an undo capability, so this method could be optional.
     *
     */
    void undo();


    /**
     * redo the changes made by the command.
     */
    void redo();

    /**
     *  used to check if the command is currently eligible for execution.
     */
    boolean canExecute();

    /**
     *  getDescription()
     */
    String getDescription();
}
