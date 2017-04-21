class Printer<T> {
    public void printArray(T[] arr) {
        for (T e : arr) {
            System.out.println(e.toString());
        }
    }
}
