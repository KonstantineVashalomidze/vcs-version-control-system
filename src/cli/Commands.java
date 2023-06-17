package cli;

public enum Commands {
    INIT("vcs init"),
    ADD("vcs add"),
    COMMIT("vcs commit -m"),
    LOG("vcs log"),
    BRANCH("vcs branch"),
    CHECKOUT("vcs checkout"),
    MERGE("vcs merge"),
    STATUS("vcs status"),
    DIFF("vcs diff"),
    RM("vcs rm"),
    CLONE("vcs clone"),
    PULL("vcs pull"),
    PUSH("vcs push"),
    GLOBAL_NAME("vcs config --global user.name"),
    GLOBAL_EMAIL("vcs config --global user.email"),
    HELP("vcs help");

    private final String command;

    Commands(String command){
        this.command = command;
    }

    public String getCommand() {
        return this.command;
    }


}
