Node MergeLists(Node currA, Node currB) {
    if (currA == null) {
        return currB;
    } else if (currB == null) {
        return currA;
    }
    Node head = null;
    if (currA.data < currB.data) {
        head = currA;
        currA = currA.next;
    } else {
        head = currB;
        currB = currB.next;
    }
    Node n = head;
    while (currA != null && currB != null) {
        if (currA.data < currB.data) {
            n.next = currA;
            currA = currA.next;
        } else {
            n.next = currB;
            currB = currB.next;
        }
        n = n.next;
    }
    if (currA == null) {
        n.next = currB;
    } else {
        n.next = currA;
    }
    return head;
}
