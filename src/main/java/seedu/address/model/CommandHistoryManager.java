package seedu.address.model;

import java.util.LinkedList;

public class CommandHistoryManager implements CommandHistory {
    private LinkedList<String> history;
    private int currIndex;

    public CommandHistoryManager() {
        this.history = new LinkedList<>();
        this.currIndex = 0;
    }

    public void saveCommandExecutionString(String commandInputString) {
        //Every execution of a new command will cause the currIndex to be reset
        //to the right-most index of the `history` + 1
        this.history.add(commandInputString);
        this.currIndex = this.history.size();
    }

    public String getPrevCommandString() {
        if (this.history.size() == 0) {
            return "";
        }

        if (this.currIndex <= 0) {
            return this.history.get(0);
        }

        this.currIndex -= 1;
        return this.history.get(this.currIndex);
    }

    public String getNextCommandString() {
        if (this.history.size() == 0) {
            return "";
        }

        if (this.currIndex >= (this.history.size()-1)) {
            return "";
        }

        this.currIndex += 1;
        return this.history.get(this.currIndex);
    }
}
