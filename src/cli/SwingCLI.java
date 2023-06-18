package cli;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;


public class SwingCLI extends JFrame {
    private JTextArea outputTextArea;
    private JTextField inputTextField;
    private CommandLine commandLine;

    private static List<SwingCLI> listOfCLIs = new ArrayList<>();

    public SwingCLI() {
        this.commandLine = new CommandLine();
        setTitle("Swing CLI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);

        this.outputTextArea = new JTextArea();
        this.outputTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(this.outputTextArea);

        this.inputTextField = new JTextField();
        this.inputTextField.addActionListener(e -> {
            processCommand(this.inputTextField.getText());
            this.inputTextField.setText("");
        });

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(this.inputTextField, BorderLayout.SOUTH);
        add(panel);

        setVisible(true);
    }

    public void addCLI(SwingCLI cli){
        listOfCLIs.add(cli);
    }

    private void processCommand(String command) {
        // Execute the command and update the outputTextArea accordingly
        // You can implement your logic to handle different commands here
        this.outputTextArea.append("> " + command + "\n");
        this.commandLine.setCommand(command);
    }


    public JTextArea getOutputTextArea(){
        return this.outputTextArea;
    }

    public void setOutputTextArea(String out){
        this.outputTextArea.append(out + "\n");
    }

    public JTextField getInputTextField(){
        return this.inputTextField;
    }

    public static SwingCLI getSwingCLIWithIndex(int index){
        return listOfCLIs.get(index);
    }

}

