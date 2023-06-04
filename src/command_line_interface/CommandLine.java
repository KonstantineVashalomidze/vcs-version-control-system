package command_line_interface;

import repository.LocalRepository;
import utils.Logger;

import java.util.HashMap;
import java.util.Map;

public class CommandLine {

    private String command;
    private final Logger LOGGER = new Logger(this.getClass());

    private LocalRepository localRepository;


    // Create a map to store commands and their corresponding actions
    private Map<String, Runnable> commandMap = new HashMap<>();
    {
        this.commandMap.put(Commands.INIT.getCommand(), this::init);
    }

    public CommandLine(){

    }


    /**
     * This function is executing the command while it is given
     *
     */
    private void execute(){

        var commandSplit = this.command.split(" ");
        // Process the command
        try{
            if (this.localRepository == null && !this.command.equals("vcs init")){
                this.LOGGER.error("Is not vcs repository");
                return;
            }
            // Get the command type
            String commandKey = commandSplit[0] + " " + commandSplit[1];
            // Check if the commandMap contains key
            if (this.commandMap.containsKey(commandKey)) {
                Runnable action = this.commandMap.get(commandKey);
                action.run();
            } else {
                this.LOGGER.warning("Unknown command: " + this.command);
            }
        } catch (Exception e){
            this.LOGGER.error("Error: " + e.getMessage());
        }
    }



    /**
     *  Initializes an empty repository in the current directory.
     *  Create a new instance of LocalFileSystem, and set up the necessary folder structure for the version control system.
     */
    private void init(){
        // Check if the command is valid

        if(this.localRepository != null){
            this.LOGGER.error("Already initialized repository");
        } else {
            this.LOGGER.info("Initialized empty vcs repository");
            this.localRepository = new LocalRepository(this);
            this.addCommandsToCommandMap();
        }

    }

    // Add commands to the commandMap
    private void addCommandsToCommandMap(){
        this.commandMap.put(Commands.ADD.getCommand(), this.localRepository::add);
        this.commandMap.put(Commands.COMMIT.getCommand(), this.localRepository::commit);
        this.commandMap.put(Commands.LOG.getCommand(), this.localRepository::log);
        this.commandMap.put(Commands.BRANCH.getCommand(), this.localRepository::branch);
        this.commandMap.put(Commands.CHECKOUT.getCommand(), this.localRepository::checkout);
        this.commandMap.put(Commands.MERGE.getCommand(), this.localRepository::merge);
        this.commandMap.put(Commands.STATUS.getCommand(), this.localRepository::status);
        this.commandMap.put(Commands.DIFF.getCommand(), this.localRepository::diff);
        this.commandMap.put(Commands.RM.getCommand(), this.localRepository::rm);
        this.commandMap.put(Commands.CLONE.getCommand(), this.localRepository::cloneRepository);
        this.commandMap.put(Commands.PULL.getCommand(), this.localRepository::pull);
        this.commandMap.put(Commands.PUSH.getCommand(), this.localRepository::push);
        this.commandMap.put(Commands.GLOBAL_NAME.getCommand(), this.localRepository::setGlobalConfig);
        this.commandMap.put(Commands.GLOBAL_EMAIL.getCommand(), this.localRepository::setGlobalConfig);
        this.commandMap.put(Commands.HELP.getCommand(), this.localRepository::help);
    }

    // Get command
    public String getCommand(){
        return this.command;
    }

    // Set command
    public void setCommand(String command){
        this.command = command;
        execute();
    }

    // Set local repository
    public void setLocalRepository(LocalRepository localRepository) {
        this.localRepository = localRepository;
    }
}
