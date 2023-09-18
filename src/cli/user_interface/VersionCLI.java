package cli.user_interface;

import cli.user_interface.comman_line_display.MainPanel;
import file_system.FileSystem;
import file_system.LocalFileSystem;
import utils.Logger;

import javax.swing.*;
import java.awt.*;

public class VersionCLI
        extends JFrame
{
    private static final Toolkit kit = Toolkit.getDefaultToolkit();

    private static final Dimension userScreenSize = kit.getScreenSize();
    public static final int DEFAULT_WIDTH = userScreenSize.width / 2;
    public static final int DEFAULT_HEIGHT = userScreenSize.height / 3;

    private static final Image cliIcon = new ImageIcon("src/cli/CJnewYear.jpg").getImage();

    private final Logger LOGGER = new Logger(this.getClass());


    private static final FileSystem fileSystem = LocalFileSystem.getInstance();
    // TODO: should implement the currentDirectoryName() function it is causing nullPointerException!!!!

    private MainPanel mainPanel;




    public VersionCLI(){
        // make mainPanel scrollable
        mainPanel = new MainPanel();
        // Add JScroll Pane to the window
        add(mainPanel);

        // set current directory name
        MainPanel.getDirectoryComponent().setText(fileSystem.currentDirectoryName());



        setTitle("VCS");
        setIconImage(cliIcon);
        setSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }



}
