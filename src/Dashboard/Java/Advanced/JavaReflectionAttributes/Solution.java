public class Solution {
    public static void main(String[] args) {
        Student s = new Student();
        Class c = s.getClass();
        Method[] methods = c.getDeclaredMethods();

        ArrayList<String> methodList = new ArrayList<>();
        for(Method m : methods) {
            methodList.add(m.getName());
        }
        Collections.sort(methodList);
        for(String name: methodList) {
            System.out.println(name);
        }
    }
}
