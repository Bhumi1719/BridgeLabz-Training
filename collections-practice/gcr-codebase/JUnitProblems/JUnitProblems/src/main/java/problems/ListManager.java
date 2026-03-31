package problems;

import java.util.List;

public class ListManager {

    // Adding element to list
    public void addElement(List<Integer> list, int element) {
        list.add(element);
    }

    // Removing element from list
    public boolean removeElement(List<Integer> list, int element) {
        return list.remove(Integer.valueOf(element));
    }

    // Getting size of list
    public int getSize(List<Integer> list) {
        return list.size();
    }
}
