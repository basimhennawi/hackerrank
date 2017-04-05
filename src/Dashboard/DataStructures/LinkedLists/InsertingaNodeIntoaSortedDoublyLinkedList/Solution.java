Node SortedInsert(Node head,int data) {
    Node newNode = new Node();
    newNode.data = data;
    
    if (head == null) {
        return newNode;
    } else if (data <= head.data) {
        newNode.next = head;
        head.prev = newNode;
        return newNode;
    } else {
        Node before = null;
        Node after = head;
        while (after != null && data > after.data) {
            before = after;
            after = after.next;
        }
        newNode.prev = before;
        newNode.next = after;
        
        before.next = newNode;
        newNode.prev = before;

        if (after != null) {
            after.prev = newNode;
            newNode.next = after;
        }

        return head;
    }
}
