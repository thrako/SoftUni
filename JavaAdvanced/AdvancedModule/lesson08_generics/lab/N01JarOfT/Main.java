package lesson08_generics.lab.N01JarOfT;

public class Main {
    public static void main(String[] args) {
        Jar<String> jarOfStrings = new Jar<>();
        jarOfStrings.add("Something");
        jarOfStrings.add("Something Else");
        jarOfStrings.add("Yet Another Nonsense");
        String nonsense = jarOfStrings.remove();
    }
}
