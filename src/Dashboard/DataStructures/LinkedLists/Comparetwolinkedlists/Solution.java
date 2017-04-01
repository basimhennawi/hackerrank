int CompareLists(Node headA, Node headB) {
    while (headA != null && headB != null) {
        if (headA.data != headB.data) return 0;
        headA = headA.next;
        headB = headB.next;
    }
    return headA == headB ? 1 : 0;
}
