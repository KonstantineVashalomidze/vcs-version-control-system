package cli.commands.command_pattern;

import cli.commands.*;
import file_system.FileSystem;
import file_system.LocalFileSystem;
import repository.LocalRepository;
import repository.Repository;
import utils.Logger;

import java.nio.file.Path;
import java.util.Arrays;

public class CommandFactory
{
    private static Repository repository = new LocalRepository();


    public static Command createCommand(String userInput)
    {
        String[] tokens = userInput.trim().split("\\s+");

        if (tokens.length == 0)
        {
            // Handle empty input gracefully
            return null;
        }


        String commandName = tokens[0];
        String[] arguments = Arrays.copyOfRange(tokens, 1, tokens.length);

        switch (commandName)
        {
            case "vcs":
                return createVcsCommand(arguments);
            default:
                // Handle unknown commands gracefully
                return null;
        }
    }

    private static Command createVcsCommand(String[] arguments)
    {
        if (arguments.length == 0) {
            // Handle the case where the 'vcs' command is provided without subcommands
            return null;
        }

        String subcommand = arguments[0];

        switch (subcommand)
        {
            case "init":
                return new InitCommand(repository);
            case "add":
                return new AddCommand(repository, Arrays.copyOfRange(arguments, 1, arguments.length));
            case "commit":
                return new CommitCommand(repository, Arrays.copyOfRange(arguments, 1, arguments.length));
            case "log":
                return new LogCommand(repository);
            case "branch":
                return new BranchCommand(repository, Arrays.copyOfRange(arguments, 1, arguments.length));
            case "checkout":
                return new CheckoutCommand(repository, Arrays.copyOfRange(arguments, 1, arguments.length));
            case "merge":
                return new MergeCommand(repository, Arrays.copyOfRange(arguments, 1, arguments.length));
            case "status":
                return new StatusCommand(repository);
            case "diff":
                return new DiffCommand(repository, Arrays.copyOfRange(arguments, 1, arguments.length));
            case "rm":
                return new RemoveCommand(repository, Arrays.copyOfRange(arguments, 1, arguments.length));
            case "clone":
                return new CloneCommand(repository, Arrays.copyOfRange(arguments, 1, arguments.length));
            case "pull":
                return new PullCommand(repository);
            case "push":
                return new PushCommand(repository);
            case "config":
                if (arguments.length >= 3 && "--global".equals(arguments[1]))
                {
                    if ("user.name".equals(arguments[2]))
                    {
                        return new SetUserNameCommand(repository, arguments[3]);
                    }
                    else if ("user.email".equals(arguments[2]))
                    {
                        return new SetUserEmailCommand(repository, arguments[3]);
                    }
                }
                break;
            case "help":
                return new HelpCommand(repository, Arrays.copyOfRange(arguments, 1, arguments.length));
            default:
                // Handle unknown subcommands gracefully
                return null;
        }

        return null;
    }
}
