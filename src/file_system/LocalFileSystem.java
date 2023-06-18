package file_system;

import utils.Logger;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class LocalFileSystem implements FileSystem{

    private Logger logger = new Logger(this.getClass());



    @Override
    public boolean exists(Path path) {

        if (Files.exists(path)){
            this.logger.info("Specified file exists");
            return true;
        } else {
            this.logger.error("Specified file does not exists");
            return false;
        }
    }

    @Override
    public boolean isFile(Path path) {

        if (Files.isRegularFile(path)){
            this.logger.info(path + " Is file");
            return true;
        } else {
            this.logger.info(path + " Is not file");
            return false;
        }

    }

    @Override
    public boolean isDirectory(Path path) {

        if (Files.isDirectory(path)){
            this.logger.info(path + " Is directory");
            return true;
        } else {
            this.logger.info(path + " Is not directory");
            return false;
        }

    }

    @Override
    public boolean createFile(Path path) {
        try{
            Files.createFile(path);
            this.logger.info("Created file: " + path);
            return true;
        } catch (Exception e){
            this.logger.error(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean createDirectory(Path path) {

        try{
            Files.createDirectory(path);
            this.logger.info("Created directory: " + path);
            return true;
        } catch (Exception e){
            this.logger.error(e.getMessage());
            return false;
        }

    }

    @Override
    public boolean delete(Path path) {
        try {
            Files.delete(path);
            this.logger.info("Deleted file/directory: " + path);
            return true;  // Deletion succeeded
        } catch (IOException e) {
            this.logger.error(e.getMessage());
            return false; // Deletion failed
        }
    }

    @Override
    public InputStream openInputStream(Path path) throws IOException {
        return Files.newInputStream(path);
    }

    @Override
    public OutputStream openOutputStream(Path path) throws IOException {
        return Files.newOutputStream(path);
    }

    @Override
    public List<Path> listFiles(Path directory) {
        return null;
    }

    @Override
    public List<Path> listDirectories(Path directory) {
        return null;
    }

    @Override
    public boolean copy(Path source, Path destination) {
        return false;
    }

    @Override
    public boolean move(Path source, Path destination) {
        return false;
    }

    @Override
    public boolean rename(Path path, String newName) {
        return false;
    }

    @Override
    public long size(Path path) {
        return 0;
    }

    @Override
    public Path getCurrentDirectory() {
        Path currentDirectory = Paths.get(System.getProperty("user.dir"));
        this.logger.info("Current Directory: " + currentDirectory);
        return currentDirectory;
    }

    @Override
    public boolean changeDirectory(Path directory) {

    }

    @Override
    public boolean navigateToParentDirectory() {
        return false;
    }


}
