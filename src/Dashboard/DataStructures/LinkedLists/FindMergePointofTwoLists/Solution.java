int getCount(Node n) {
    int ctr = 0;
    while (n != null) {
        ctr++;
        n = n.next;
    }
    return ctr;
}

int getNodeData(int diff, Node lg, Node sm) {
    int data = 0;
    Node currLg = lg;
    Node currSm = sm;
    
    for (int i = 0; i < diff; i++) {
        currLg = currLg.next;    
    }
    
    while (currLg != currSm) {
        currLg = currLg.next;
        currSm = currSm.next;
    }
    return currLg.data;
}

int FindMergeNode(Node headA, Node headB) {
    Node currA = headA;
    Node currB = headB;
    
    int cntA = getCount(headA);
    int cntB = getCount(headB);
    
    if (cntA > cntB) {
        return getNodeData(cntA - cntB, headA, headB);
    } else {
        return getNodeData(cntB - cntA, headB, headA);
    }
}
