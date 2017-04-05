void Print(Node head) {
    while (head != null) {
        System.out.println(head.data);
        head = head.next;
    }
}
