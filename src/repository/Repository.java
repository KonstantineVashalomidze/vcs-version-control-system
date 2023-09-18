package repository;


public interface Repository
{

    /**
     * Initialise empty repository in current directory
     */
    void init();

    /**
     * This command adds one or more files to the repository's tracking list.
     * The specified files will be included in the next commit.
     */
    void add();
    /**
     * This command creates a new commit containing the current state of all tracked files.
     * The -m option allows the user to provide a descriptive message for the commit.
     */
    void commit();
    /**
     * This command displays the commit history for the current branch,
     * showing commit identifiers, author information, commit messages, and timestamps.
     */
    void log();
    /**
     * This command creates a new branch with the specified name, starting from the current commit.
     */
    void branch();
    /**
     * This command changes the working directory to the specified branch,
     * updating the tracked files to match the latest commit in that branch.
     */
    void checkout();
    /**
     * This command merges the changes from the source branch into the target
     * branch (or the current branch if the target branch is not specified).
     * If there are conflicts, the user is prompted to resolve them.
     */
    void merge();
    /**
     * This command shows the current status of the repository, including any modified, untracked, or staged files.
     * It also displays the current and any pending changes.
     */
    void status();
    /**
     * This command shows the differences between the specified commits (or between the working directory and the latest commit
     * if no commits are specified). If a file is specified, the differences are shown only for that file.
     */
    void diff();
    /**
     * This command removes the specified file from the repository and deletes it from the working directory.
     * The file's history is preserved in previous commits.
     */
    void rm();
    /**
     * This command creates a copy of an existing repository, including its commit history and branches,
     * in the specified destination directory (or the current directory if no destination is specified).
     */
    void cloneRepository();
    /**
     * This command fetches changes from the remote repository and merges them into the current branch.
     */
    void pull();
    /**
     * This command pushes the local changes (commits that are not in the remote repository) to the
     * remote repository.
     */
    void push();
    /**
     * These commands set the global username and email address, which are used for commit author information.
     */
    void setGlobalConfig();
    /**
     * This command shows usage information and a brief description
     * for the specified command (or for all commands if no command is specified).
     */
    void help();

}
