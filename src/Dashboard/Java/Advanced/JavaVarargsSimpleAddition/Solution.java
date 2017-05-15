class Add {
    void add(int... args){
        int sum = 0;
        String s = "";
        for (int i : args){
            sum += i;
            s += i + "+";
        }
        System.out.println(s.substring(0, s.length() - 1) + "=" + sum);
    }
}
