package repository;

import cli.CommandLine;
import utils.Logger;

public class LocalRepository implements Repository{
    private final Logger LOGGER = new Logger(this.getClass());
    private final CommandLine commandLine;

    private boolean isInitialized = false;


    public LocalRepository(CommandLine commandLine){
        this.commandLine = commandLine;
    }


    @Override
    public void add() {
        // Files to add to the staging area
        // Note that it the file names is starting from index 2;
        String[] fileNamesToAddToTheStagingArea = this.commandLine.getCommand().split(" ");
        this.LOGGER.info("Added files: ");
        for (int i = 2; i < fileNamesToAddToTheStagingArea.length; i++) {
            System.out.print(fileNamesToAddToTheStagingArea[i]);
            if (i != fileNamesToAddToTheStagingArea.length - 1){
                System.out.print(", ");
            }
        }
        // Validates if the files exist to add to the staging area
        // TODO
    }

    @Override
    public void commit() {

    }

    @Override
    public void log() {

    }

    @Override
    public void branch() {

    }

    @Override
    public void checkout() {

    }

    @Override
    public void merge() {

    }

    @Override
    public void status() {

    }

    @Override
    public void diff() {

    }

    @Override
    public void rm() {

    }

    @Override
    public void cloneRepository() {

    }

    @Override
    public void pull() {

    }

    @Override
    public void push() {

    }

    @Override
    public void setGlobalConfig() {

    }

    @Override
    public void help() {

    }
}
