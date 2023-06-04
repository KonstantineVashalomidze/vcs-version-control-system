package command_line_interface;

import java.util.Scanner;

public class CommandLineInterface {

    private Scanner scanner = new Scanner(System.in);
    private String inputCommand;

    public CommandLineInterface(){
        takeCommands();
    }

    public void takeCommands(){
        try{
            this.inputCommand = this.scanner.nextLine();
        } catch (Exception e){
            System.out.println("Error occurred while reading the input.");
        } finally {
            // if command is exit exit from the terminal otherwise call it again
            if (!this.inputCommand.equals("exit")){
                // handle the command
                new Command(this.inputCommand);
                takeCommands();
            } else {
                this.scanner.close();
            }
        }
    }

}
