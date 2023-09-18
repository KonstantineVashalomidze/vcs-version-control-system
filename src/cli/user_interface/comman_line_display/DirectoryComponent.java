package cli.user_interface.comman_line_display;

import javax.swing.*;
import java.awt.*;

public class DirectoryComponent
    extends JTextField
{
    public DirectoryComponent()
    {
        setEditable(false);
        setFont(Constants.CUSTOM_FONT);
        var titledBorder = BorderFactory.createTitledBorder("Directory");
        titledBorder.setTitleColor(new Color(63, 41, 18));
        setBorder(titledBorder);

    }

}
