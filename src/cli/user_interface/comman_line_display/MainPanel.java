package cli.user_interface.comman_line_display;



import cli.user_interface.VersionCLI;

import javax.swing.*;
import java.awt.*;



public class MainPanel
    extends JPanel
{
    private static OutputComponent outputComponent;

    private static DirectoryComponent directoryComponent;
    private static CommandComponent commandComponent;

    private JPanel outputPanel;

    public MainPanel()
    {

        setLayout(null);

        outputPanel = new JPanel();


        directoryComponent = new DirectoryComponent();
        commandComponent = new CommandComponent();
        outputComponent = new OutputComponent();

        directoryComponent.setBounds(0, 0, VersionCLI.DEFAULT_WIDTH - 14, VersionCLI.DEFAULT_HEIGHT / 7);
        commandComponent.setBounds(0, VersionCLI.DEFAULT_HEIGHT / 7, VersionCLI.DEFAULT_WIDTH - 14, VersionCLI.DEFAULT_HEIGHT / 7);

        directoryComponent.setBackground(Constants.DIRECTORY_COLOR);
        commandComponent.setBackground(Constants.COMMAND_COLOR);

        add(directoryComponent);
        add(commandComponent);

        outputPanel.add(outputComponent);
        outputPanel.setBackground(Constants.WINDOW_COLOR);

        var outputPanelScrollable = new JScrollPane(outputPanel);
        outputPanelScrollable.setBounds(0, 2 * (VersionCLI.DEFAULT_HEIGHT / 7)
                , (VersionCLI.DEFAULT_WIDTH) - 13
                , VersionCLI.DEFAULT_HEIGHT - 2 * (VersionCLI.DEFAULT_HEIGHT / 7) - 20);
        outputPanelScrollable.getVerticalScrollBar().setUnitIncrement(16);
        outputPanelScrollable.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        add(outputPanelScrollable);

    }


    public static DirectoryComponent getDirectoryComponent()
    {
        return directoryComponent;
    }

    public static CommandComponent getCommandComponent()
    {
        return commandComponent;
    }

    public static OutputComponent getOutputComponent()
    {
        return outputComponent;
    }



}
