package utils;

import java.util.Objects;

public class VersionIdentifier {

    private Logger logger = new Logger(this.getClass());

    private int major;
    private int minor;
    private int patch;


    /**
     * Use when there is minor version update
     */
    public void minorUpdate(){
        this.minor++;
    }

    /**
     * Use when there is major version update
     */
    public void majorUpdate(){
        this.major++;
    }

    /**
     * Use when there is patch version update
     */
    public void patchUpdate(){
        this.patch++;
    }


    @Override
    public String toString(){
        return "v" + this.major + "." + this.minor + "." + this.patch;
    }

    @Override
    public boolean equals(Object obj){

        if (obj == null) {
            return false;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        VersionIdentifier identifierObject;
        try {
            identifierObject = (VersionIdentifier) obj;
        } catch (Exception e){
            logger.error(e.getMessage());
            return false;
        }


        return this.minor == identifierObject.minor && this.major == identifierObject.major && this.patch == identifierObject.patch;
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.major, this.minor, this.patch);
    }

}
