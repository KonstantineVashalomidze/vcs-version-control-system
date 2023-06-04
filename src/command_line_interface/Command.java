package command_line_interface;

import utils.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Command {

    private String command;
    private final Logger LOGGER = new Logger(this.getClass());


    // Create a map to store commands and their corresponding actions
    private Map<String, Runnable> commandMap = new HashMap<>();
    {
        this.commandMap.put(Commands.INIT.getCommand(), this::init);
        this.commandMap.put(Commands.ADD.getCommand(), this::add);
        this.commandMap.put(Commands.COMMIT.getCommand(), this::commit);
        this.commandMap.put(Commands.LOG.getCommand(), this::log);
        this.commandMap.put(Commands.BRANCH.getCommand(), this::branch);
        this.commandMap.put(Commands.CHECKOUT.getCommand(), this::checkout);
        this.commandMap.put(Commands.MERGE.getCommand(), this::merge);
        this.commandMap.put(Commands.STATUS.getCommand(), this::status);
        this.commandMap.put(Commands.DIFF.getCommand(), this::diff);
        this.commandMap.put(Commands.RM.getCommand(), this::rm);
        this.commandMap.put(Commands.CLONE.getCommand(), this::cloneRepository);
        this.commandMap.put(Commands.PULL.getCommand(), this::pull);
        this.commandMap.put(Commands.PUSH.getCommand(), this::push);
        this.commandMap.put(Commands.GLOBAL_NAME.getCommand(), this::globalName);
        this.commandMap.put(Commands.GLOBAL_EMAIL.getCommand(), this::globalEmail);
        this.commandMap.put(Commands.HELP.getCommand(), this::help);
    }

    public Command(String command){
        this.command = command;
        execute(command);



    }


    /**
     * This function is executing the command while it is given
     *
     */
    private void execute(String command){

        var commandSplit = command.split(" ");
        // Process the command
        try{
            // Get the command type
            String commandKey = commandSplit[0] + " " + commandSplit[1];
            // Check if the commandMap contains key
            if (this.commandMap.containsKey(commandKey)) {
                Runnable action = this.commandMap.get(commandKey);
                action.run();
            } else {
                this.LOGGER.warning("Unknown command: " + command);
            }
        } catch (Exception e){
            this.LOGGER.error("Error: " + e.getMessage());
        }
    }

    /**
     *  This command initializes a new version control system repository in the current directory.
     *  It creates a hidden directory (e.g., .vcs) to store the
     *  repository data, including file versions, commit history, and branches.
     */
    private void init(){
        // Check if the command is valid
        if(this.command.equals("vcs init")) {
            System.out.println("Initialized empty vcs repository");
        } else {
            this.LOGGER.warning("Unknown command: " + this.command);
        }
    }

    /**
     * This command adds one or more files to the repository's tracking list.
     * The specified files will be included in the next commit.
     */
    private void add(){
        // Files to add to the staging area
        // Note that it the file names is starting from index 2;
        String[] fileNamesToAddToTheStagingArea = this.command.split(" ");

        // Validates if the files exist to add to the staging area
        // TODO




    }

    /**
     * This command creates a new commit containing the current state of all tracked files.
     * The -m option allows the user to provide a descriptive message for the commit.
     */
    private void commit(){
    }

    /**
     * This command displays the commit history for the current branch,
     * showing commit identifiers, author information, commit messages, and timestamps.
     */
    private void log(){
    }

    /**
     * This command creates a new branch with the specified name, starting from the current commit.
     */
    private void branch(){
    }

    /**
     * This command changes the working directory to the specified branch,
     * updating the tracked files to match the latest commit in that branch.
     */
    private void checkout(){
    }

    /**
     * This command merges the changes from the source branch into the target
     * branch (or the current branch if the target branch is not specified).
     * If there are conflicts, the user is prompted to resolve them.
     */
    private void merge(){

    }

    /**
     * This command shows the current status of the repository, including any modified, untracked, or staged files.
     * It also displays the current and any pending changes.
     */
    private void status(){
    }

    /**
     * This command shows the differences between the specified commits (or between the working directory and the latest commit
     * if no commits are specified). If a file is specified, the differences are shown only for that file.
     */
    private void diff(){
    }

    /**
     * This command removes the specified file from the repository and deletes it from the working directory.
     * The file's history is preserved in previous commits.
     */
    private void rm(){
    }

    /**
     * This command creates a copy of an existing repository, including its commit history and branches,
     * in the specified destination directory (or the current directory if no destination is specified).
     */
    private void cloneRepository(){
    }

    /**
     * This command fetches changes from the remote repository and merges them into the current branch.
     */
    private void pull(){
    }

    /**
     * This command pushes the local changes (commits that are not in the remote repository) to the remote repository.
     */
    private void push(){
    }

    /**
     * These command set the global user name, which is used for commit author information.
     */
    private void globalName(){
    }

    /**
     * These command set the global user email, which is used for commit author information.
     */
    private void globalEmail(){
    }

    /**
     * This command shows usage information and a brief description
     * for the specified command (or for all commands if no command is specified).
     */
    private void help(){
    }



}
