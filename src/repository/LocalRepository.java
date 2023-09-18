package repository;

import utils.Logger;

import java.nio.file.Path;

public class LocalRepository
        implements Repository
{
    private final Logger LOGGER = new Logger(this.getClass());
    // This variable is the path of where the LocalRepository is initialized
    private Path directory;

    public LocalRepository(Path directory)
    {
        this.directory = directory;
    }


    @Override
    public void init()
    {
        LOGGER.info("created empty repository");
    }

    @Override
    public void add()
    {

    }

    @Override
    public void commit()
    {

    }

    @Override
    public void log()
    {

    }

    @Override
    public void branch()
    {

    }

    @Override
    public void checkout()
    {

    }

    @Override
    public void merge()
    {

    }

    @Override
    public void status()
    {

    }

    @Override
    public void diff()
    {

    }

    @Override
    public void rm()
    {

    }

    @Override
    public void cloneRepository()
    {

    }

    @Override
    public void pull()
    {

    }

    @Override
    public void push()
    {

    }

    @Override
    public void setGlobalConfig()
    {

    }

    @Override
    public void help()
    {

    }

}
