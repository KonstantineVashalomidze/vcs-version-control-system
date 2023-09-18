package repository;

import file_system.FileSystem;
import file_system.LocalFileSystem;
import utils.Logger;

import java.io.File;
import java.nio.file.Path;

public class LocalRepository
        implements Repository
{
    private final Logger LOGGER = new Logger(this.getClass());

    // This variable is the path of where the LocalRepository is initialized
    private Path directory;

    private final FileSystem fileSystem = new LocalFileSystem();

    public LocalRepository()
    {
        LOGGER.setShowDate(false);
    }


    @Override
    public void init()
    {
        directory = Path.of(fileSystem.currentDirectoryName());
        // create .ozurgit folder
        fileSystem.createDirectory(Path.of(directory + ".ozurgit"));
        fileSystem.createFile(Path.of("romani.html"));
    }

    @Override
    public void add()
    {
        LOGGER.info("added files");
    }

    @Override
    public void commit()
    {
        LOGGER.info("committed files");
    }

    @Override
    public void log()
    {
        LOGGER.info("log");
    }

    @Override
    public void branch()
    {
        LOGGER.info("branch");
    }

    @Override
    public void checkout()
    {
        LOGGER.info("checkout");
    }

    @Override
    public void merge()
    {
        LOGGER.info("merge");
    }

    @Override
    public void status()
    {
        LOGGER.info("status");
    }

    @Override
    public void diff()
    {
        LOGGER.info("diff");
    }

    @Override
    public void rm()
    {
        LOGGER.info("rm");
    }

    @Override
    public void cloneRepository()
    {
        LOGGER.info("clone");
    }

    @Override
    public void pull()
    {
        LOGGER.info("pull");
    }

    @Override
    public void push()
    {
        LOGGER.info("push");
    }

    @Override
    public void setGlobalConfig()
    {
        LOGGER.info("cofing");
    }

    @Override
    public void help()
    {
        LOGGER.info("config");
    }

}
