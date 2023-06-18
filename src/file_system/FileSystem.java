package file_system;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.util.List;

public interface FileSystem {
    /**
     * Checks if a file or directory exists at the specified path.
     *
     * @param path The path to check for existence.
     * @return {@code true} if the file or directory exists, {@code false} otherwise.
     */
    boolean exists(Path path);

    /**
     * Checks if the item at the specified path is a regular file.
     *
     * @param path The path to check.
     * @return {@code true} if the item is a regular file, {@code false} otherwise.
     */
    boolean isFile(Path path);

    /**
     * Checks if the item at the specified path is a directory.
     *
     * @param path The path to check.
     * @return {@code true} if the item is a directory, {@code false} otherwise.
     */
    boolean isDirectory(Path path);

    /**
     * Creates a new file at the specified path.
     *
     * @param path The path at which to create the file.
     * @return {@code true} if the file is created successfully, {@code false} otherwise.
     */
    boolean createFile(Path path);

    /**
     * Creates a new directory at the specified path.
     *
     * @param path The path at which to create the directory.
     * @return {@code true} if the directory is created successfully, {@code false} otherwise.
     */
    boolean createDirectory(Path path);

    /**
     * Deletes the file or directory at the specified path.
     *
     * @param path The path of the file or directory to delete.
     * @return {@code true} if the file or directory is deleted successfully, {@code false} otherwise.
     */
    boolean delete(Path path);

    /**
     * Opens an input stream to read data from the file at the specified path.
     *
     * @param path The path of the file to open for reading.
     * @return An InputStream to read the file data.
     * @throws IOException If an I/O error occurs while opening the input stream.
     */
    InputStream openInputStream(Path path) throws IOException;

    /**
     * Opens an output stream to write data to the file at the specified path.
     *
     * @param path The path of the file to open for writing.
     * @return An OutputStream to write the file data.
     * @throws IOException If an I/O error occurs while opening the output stream.
     */
    OutputStream openOutputStream(Path path) throws IOException;

    /**
     * Returns a list of all files in the specified directory.
     *
     * @param directory The path of the directory.
     * @return A list of Paths representing the files in the directory.
     */
    List<Path> listFiles(Path directory);

    /**
     * Returns a list of all subdirectories in the specified directory.
     *
     * @param directory The path of the directory.
     * @return A list of Paths representing the subdirectories in the directory.
     */
    List<Path> listDirectories(Path directory);

    /**
     * Copies a file or directory from the source path to the destination path.
     *
     * @param source      The path of the file or directory to copy.
     * @param destination The destination path.
     * @return {@code true} if the copy is successful, {@code false} otherwise.
     */
    boolean copy(Path source, Path destination);

    /**
     * Moves a file or directory from the source path to the destination path.
     *
     * @param source      The path of the file or directory to move.
     * @param destination The destination path.
     * @return {@code true} if the move is successful, {@code false} otherwise.
     */
    boolean move(Path source, Path destination);

    /**
     * Renames a file or directory at the specified path with a new name.
     *
     * @param path    The path of the file or directory to rename.
     * @param newName The new name for the file or directory.
     * @return {@code true} if the rename is successful, {@code false} otherwise.
     */
    boolean rename(Path path, String newName);

    /**
     * Returns the size of the file at the specified path in bytes.
     *
     * @param path The path of the file.
     * @return The size of the file in bytes.
     */
    long size(Path path);

    /**
     * Changes the current directory to the specified directory.
     *
     * @param directory The directory to change to.
     * @return {@code true} if the directory change is successful, {@code false} otherwise.
     */
    boolean changeDirectory(Path directory);

    /**
     * Navigates to the parent directory of the current directory.
     *
     * @return {@code true} if the navigation to the parent directory is successful, {@code false} otherwise.
     */
    boolean navigateToParentDirectory();

}
