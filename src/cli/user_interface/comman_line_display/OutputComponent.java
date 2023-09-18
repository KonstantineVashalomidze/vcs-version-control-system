package cli.user_interface.comman_line_display;

import cli.user_interface.VersionCLI;

import javax.swing.*;
public class OutputComponent
    extends JTextArea
{
    public OutputComponent()
    {
        setEditable(false);
        setFont(Constants.CUSTOM_FONT);
        setBackground(Constants.WINDOW_COLOR);
        setLineWrap(true);
        setBounds(0, 0, (VersionCLI.DEFAULT_WIDTH) - 25
                , VersionCLI.DEFAULT_HEIGHT - 2 * (VersionCLI.DEFAULT_HEIGHT / 7) - 20);

    }

}
