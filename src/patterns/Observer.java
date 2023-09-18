package patterns;

public interface Observer {
    /**
     * <description>
     *     Observable updates Observer's State
     * </description>
     * @param observable Concrete Observable
     */
    void update(Observable observable);
}
