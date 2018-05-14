public class test {
    public static void main(String[] args)
    {
        String fuckYou = "HELLO";
        String s1 = fuckYou;
        String s2 = fuckYou;
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
    }
}