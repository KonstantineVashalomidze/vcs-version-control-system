import cli.user_interface.VersionCLI;

import java.awt.*;

public class Main {
    public static void main(String[] args) {

        EventQueue.invokeLater(() ->
        {
            var frame = new VersionCLI();
            frame.setVisible(true);
        });

    }
}