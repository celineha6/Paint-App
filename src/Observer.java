package src;

import java.util.Stack;

public interface Observer {
    void update(Stack<DrawAction> currentStack);
}
