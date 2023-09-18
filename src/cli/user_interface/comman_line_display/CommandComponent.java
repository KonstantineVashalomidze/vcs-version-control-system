package cli.user_interface.comman_line_display;

import cli.commands.BranchCommand;
import cli.commands.InitCommand;
import cli.commands.command_pattern.Command;
import cli.commands.command_pattern.Invoker;
import file_system.FileSystem;
import file_system.LocalFileSystem;
import repository.LocalRepository;
import repository.Repository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;


public class CommandComponent
    extends JTextField
{
    private Map<String, Command> commandMap = new HashMap<>();
    private FileSystem fileSystem = LocalFileSystem.getInstance();
    private Invoker commandInvoker = new Invoker();

    private Repository repository = new LocalRepository(Path.of(fileSystem.currentDirectoryName()));



    {
        commandMap.put("vcs init", new InitCommand(repository));

        // TODO: i should put other command maps when i implement command classes

    }



    public CommandComponent()
    {
        setFont(Constants.CUSTOM_FONT);
        var titledBorder = BorderFactory.createTitledBorder("Command");
        titledBorder.setTitleColor(new Color(63, 41, 18));
        setBorder(titledBorder);
        addKeyListener(
                new KeyAdapter()
                {
                    @Override
                    public void keyPressed(KeyEvent e)
                    {
                        super.keyPressed(e);
                        if (e.getKeyCode() == KeyEvent.VK_ENTER)
                        {
                            setText("");
                            setCommand(initCommand);
                            executeCommand();

                        }
                    }
                }
        );

    }


}
