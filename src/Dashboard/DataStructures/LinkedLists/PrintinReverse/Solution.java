void ReversePrint(Node head) {
  if (head == null) return;
  ArrayList<Integer> a = new ArrayList<Integer>();
  Node current = head;
  while (current != null) {
    a.add(current.data);
    current = current.next;
  }
  for (int i = a.size() - 1; i >= 0 ; i--){
    System.out.println(a.get(i));
  }
}
