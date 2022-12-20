import implementations.Tree;

public class Main {
    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>(7,
                                    new Tree<>(19,
                                            new Tree<>(1),
                                            new Tree<>(12),
                                            new Tree<>(31)),
                                    new Tree<>(21),
                                    new Tree<>(14,
                                            new Tree<>(23),
                                            new Tree<>(6))
        );

//        final var node19 = tree.findByKey(19);
//        final var node14 = tree.findByKey(14);
//        final var node6 = tree.findByKey(6);
//        final var node7 = tree.findByKey(7);
//        System.out.println(node6.isAncestorOf(node7));
    }
}
