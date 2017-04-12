public static int B;
public static int H;
public static boolean flag;
        
static {
    Scanner scan = new Scanner(System.in);
    B = scan.nextInt();
    H = scan.nextInt();
    if (B <= 0 || H <= 0) System.out.println("java.lang.Exception: Breadth and height must be positive");
    else flag = true;
    scan.close();
}
