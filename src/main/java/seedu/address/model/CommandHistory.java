package seedu.address.model;

public interface CommandHistory {
    void saveCommandExecutionString(String commandInputString);

    String getPrevCommandString();

    String getNextCommandString();
}
