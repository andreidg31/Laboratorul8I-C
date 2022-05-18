/**
 * Class that for a circular linked list
 */
public class CircularLinkedList {
    private Node head = null;
    private Node tail = null;

    /**
     * Adds a node to the list
     * @param value value to be added
     */
    public void addNode(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
        } else {
            tail.nextNode = newNode;
        }

        tail = newNode;
        tail.nextNode = head;
    }

    /**
     * Checks if the list contains a node
     * @param searchValue value to be searched for
     * @return true or false
     */
    public boolean containsNode(int searchValue) {
        Node currentNode = head;

        if (head == null) {
            return false;
        } else {
            do {
                if (currentNode.value == searchValue) {
                    return true;
                }
                currentNode = currentNode.nextNode;
            } while (currentNode != head);
            return false;
        }
    }

    /**
     * Deletes a node from the list
     * @param valueToDelete value to be deleted
     */
    public void deleteNode(int valueToDelete) {
        Node currentNode = head;
        if (head == null) {
            return;
        }
        do {
            Node nextNode = currentNode.nextNode;
            if (nextNode.value == valueToDelete) {
                if (tail == head) {
                    head = null;
                    tail = null;
                } else {
                    currentNode.nextNode = nextNode.nextNode;
                    if (head == nextNode) {
                        head = head.nextNode;
                    }
                    if (tail == nextNode) {
                        tail = currentNode;
                    }
                }
                break;
            }
            currentNode = nextNode;
        } while (currentNode != head);
    }

    /**
     * Gets the next node based on the input node
     * @param currentNode node to be searched for
     * @return the next node after the current one or null if it doesn't exist
     */
    public Node getNextNode(Node currentNode) {
        Node myNode = head;
        if (head == null) {
            return null;
        }
        if (head.value == currentNode.value) {
            return head.nextNode;
        }
        do {
            Node nextNode = myNode.nextNode;
            if (nextNode.value == currentNode.value) {
                return nextNode.nextNode;
            }
            myNode = nextNode;
        } while (myNode != tail);
        return null;
    }
}