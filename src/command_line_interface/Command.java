package command_line_interface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Command {

    // Create a map to store commands and their corresponding actions
    private Map<String, Runnable> commandMap = new HashMap<>();
    {
        this.commandMap.put("vcs init", Command::init);
        this.commandMap.put("vcs add", Command::add);
        this.commandMap.put("vcs commit -m", Command::commit);
        this.commandMap.put("vcs log", Command::log);
        this.commandMap.put("vcs branch", Command::branch);
        this.commandMap.put("vcs checkout", Command::checkout);
        this.commandMap.put("vcs merge", Command::merge);
        this.commandMap.put("vcs status", Command::status);
        this.commandMap.put("vcs diff", Command::diff);
        this.commandMap.put("vcs rm", Command::rm);
        this.commandMap.put("vcs clone", Command::cloneRepository);
        this.commandMap.put("vcs pull", Command::pull);
        this.commandMap.put("vcs push", Command::push);
        this.commandMap.put("vcs config --global user.name", Command::globalName);
        this.commandMap.put("vcs config --global user.email", Command::globalEmail);
        this.commandMap.put("vcs help", Command::help);
    }

    public Command(String command){
        var commandSplit = command.split(" ");
        // Process the command
        try{
            // Get the command type
            String commandKey = commandSplit[0] + " " + commandSplit[1];
            if (commandMap.containsKey(commandKey)) {
                Runnable action = commandMap.get(commandKey);
                action.run();
            } else {
                System.out.println("Unknown command");
            }
        } catch (Exception e){
            System.out.println("Unknown command");
        }



    }



    private static void init(){
        System.out.println("init command was given");
    }

    private static void add(){

    }

    private static void commit(){

    }

    private static void log(){

    }

    private static void branch(){

    }

    private static void checkout(){

    }

    private static void merge(){

    }

    private static void status(){

    }

    private static void diff(){

    }

    private static void rm(){

    }

    private static void cloneRepository(){

    }

    private static void pull(){

    }

    private static void push(){

    }

    private static void globalName(){

    }

    private static void globalEmail(){

    }

    private static void help(){

    }



}
