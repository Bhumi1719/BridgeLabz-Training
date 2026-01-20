import java.util.Stack;

public class BrowserBuddy {

    History history = new History();
    Stack<String> closedTabs = new Stack<>();

    public void open(String url) {
        history.visit(url);
    }

    public void back() {
        history.back();
    }

    public void forward() {
        history.forward();
    }

    public void closeTab() {
        String closed = history.closeTab();
        if(closed != null) {
            closedTabs.push(closed);
            System.out.println("Closed Tab: " + closed);
        } else {
            System.out.println("No tab to close.");
        }
    }

    public void restoreTab() {
        if(closedTabs.isEmpty()) {
            System.out.println("No closed tabs to restore.");
        } else {
            String url = closedTabs.pop();
            history.visit(url);
            System.out.println("Restored Tab: " + url);
        }
    }

    public void show() {
        history.showCurrent();
    }
}
