package file_system;

import utils.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LocalFileSystem
        implements FileSystem
{
    private Logger logger = new Logger(this.getClass());

    private static LocalFileSystem localFileSystemInstance;

    private Path currentDirectory;


    public LocalFileSystem(){
        this.currentDirectory = this.getRootDirectory();
    }

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

        try
        {
            Files.createDirectory(path);
            this.logger.info("Created directory: " + path);
            return true;
        }
        catch (Exception e)
        {
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
        List<Path> fileList = new ArrayList<>();

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(directory)) {
            for (Path entry : stream) {
                if (Files.isRegularFile(entry)) {
                    fileList.add(entry);
                }
            }
        } catch (IOException e) {
            this.logger.error(e.getMessage());
        }

        return fileList;
    }

    @Override
    public List<Path> listDirectories(Path directory) {
        List<Path> directoryList = new ArrayList<>();

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(directory)) {
            for (Path entry : stream) {
                if (Files.isDirectory(entry)) {
                    directoryList.add(entry);
                }
            }
        } catch (IOException e) {
            this.logger.error(e.getMessage());
        }

        return directoryList;
    }

    @Override
    public boolean copy(Path source, Path destination) {
        try {
            Files.copy(source, destination);
            this.logger.info("Copied " + source + " to " + destination);
            return true;
        } catch (IOException e) {
            this.logger.error(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean move(Path source, Path destination) {
        try {
            Files.move(source, destination);
            this.logger.info("Moved " + source + " to " + destination);
            return true;
        } catch (IOException e) {
            this.logger.error(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean rename(Path path, String newName) {
        try {
            Path newPath = path.resolveSibling(newName);
            Files.move(path, newPath);
            this.logger.info("Renamed " + path + " to " + newPath);
            return true;
        } catch (IOException e) {
            this.logger.error(e.getMessage());
            return false;
        }
    }

    @Override
    public long size(Path path) {
        try {
            return Files.size(path);
        } catch (IOException e) {
            this.logger.error(e.getMessage());
            return 0;
        }
    }

    public Path getRootDirectory() {
        return Paths.get(System.getProperty("user.dir"));
    }

    @Override
    public boolean changeDirectory(Path directory) {
        if (Files.isDirectory(directory)) {
            // change directory to current directory
            this.currentDirectory = directory;
            System.setProperty("user.dir", directory.toString());
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean navigateToParentDirectory() {
        Path currentDirectory = Paths.get(System.getProperty("user.dir"));
        Path parentDirectory = currentDirectory.getParent();

        if (parentDirectory != null) {
            // set current directory to parent directory
            this.currentDirectory = parentDirectory;
            System.setProperty("user.dir", parentDirectory.toString());
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String currentDirectoryName()
    {
        Path currentDirectory = Paths.get(System.getProperty("user.dir"));
        return currentDirectory.getFileName().toString();
    }

    /**
     * <Description>
     *     is to get in what direction now it is
     * </Description>
     * @return Path object of current directory
     */
    public Path getCurrentDirectory()
    {
        return this.currentDirectory;
    }

    public static LocalFileSystem getInstance() {
        if (localFileSystemInstance == null){
            localFileSystemInstance = new LocalFileSystem();
        }
        return localFileSystemInstance;
    }


}
