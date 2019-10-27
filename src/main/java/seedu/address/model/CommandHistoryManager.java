package seedu.address.model;

import java.util.Stack;

public class CommandHistoryManager implements CommandHistory {
    private Stack<String> prev;
    private Stack<String> next;

    public CommandHistoryManager() {
        this.prev = new Stack<>();
        this.next = new Stack<>();
    }

    public void saveCommandExecutionString(String commandInputString) {
        this.next.clear();
        this.prev.push(commandInputString);
        System.out.println("PrevStack: " + this.prev.size() + " | NextStack: " + this.next.size());
    }

    public String getPrevCommandString() {
        if (!this.prev.empty()) {
            this.next.push(this.prev.peek());
            System.out.println("PrevStack: " + this.prev.size() + " | NextStack: " + this.next.size());
            return this.prev.pop();
        } else {
            System.out.println("PrevStack: " + this.prev.size() + " | NextStack: " + this.next.size());
            return this.next.peek();
        }
    }

    public String getNextCommandString() {
        if (!this.next.empty()) {
            this.prev.push(this.next.peek());
            System.out.println("PrevStack: " + this.prev.size() + " | NextStack: " + this.next.size());
            return this.next.pop();
        } else {
            System.out.println("PrevStack: " + this.prev.size() + " | NextStack: " + this.next.size());
            return "";
        }
    }
}
