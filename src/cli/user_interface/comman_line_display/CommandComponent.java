package cli.user_interface.comman_line_display;

import cli.commands.command_pattern.CommandFactory;
import cli.commands.command_pattern.Invoker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class CommandComponent
    extends JTextField
{
    private Invoker commandInvoker = new Invoker();








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

                            commandInvoker.setCommand(CommandFactory.createCommand(getText()));
                            commandInvoker.executeCommand();

                            // clear the input field after executing the command
                            setText("");
                        }
                    }
                }
        );

    }



}
