package cli;

import repository.LocalRepository;

import java.util.Scanner;

public class CommandLineInterface {

    private Scanner scanner = new Scanner(System.in);
    private String inputCommand;

    private LocalRepository localRepository;

    private CommandLine command = new CommandLine();

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
                command.setCommand(this.inputCommand);
                takeCommands();
            } else {
                this.scanner.close();
            }
        }
    }

}
