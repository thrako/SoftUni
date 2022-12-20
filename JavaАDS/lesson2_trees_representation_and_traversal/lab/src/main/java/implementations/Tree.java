package implementations;

import interfaces.AbstractTree;

import java.util.*;

public class Tree<E> implements AbstractTree<E> {

    private static final String NO_TREE_WITH_SUCH_KEY_MSG_FORMAT = "Tree with key: %s does not exists!";

    private Tree<E> parent;
    private E key;
    private List<Tree<E>> children;

    public Tree(E key, Tree<E>... children) {
        this.parent = null;
        this.key = key;
        this.children = new ArrayList<>();
        for (Tree<E> child : children) {
            this.children.add(child);
            child.setParent(this);
        }
    }

    @Override
    public List<E> orderBfs() {
        final List<E> returnList = new ArrayList<>();
        if (this.getKey() == null) {
            return returnList;
        }

        final Queue<Tree<E>> queue = new ArrayDeque<>();
        queue.offer(this);
        while (!queue.isEmpty()) {
            final Tree<E> polled = queue.poll();
            returnList.add(polled.getKey());
            polled.getChildren().forEach(queue::offer);
        }

        return returnList;
    }

    @Override
    public List<E> orderDfs() {
        final List<E> returnList = new ArrayList<>();
        if (this.getKey() == null) {
            return returnList;
        }

        doOrderDFS(this, returnList);

        return returnList;
    }

    @Override
    public void addChild(E parentKey, Tree<E> child) {
        Tree<E> parentTree = findByKey(parentKey);
        parentTree.getChildren().add(child);
        child.setParent(parentTree);
    }

    @Override
    public void removeNode(E nodeKey) {
        final Tree<E> forRemoval = findByKey(nodeKey);

        if (forRemoval.isRoot()) {
            forRemoval.getChildren().forEach(child -> child.setParent(null));
            forRemoval.children.clear();
            forRemoval.key = null;
            return;
        }

        forRemoval.getParent().getChildren().remove(forRemoval);
    }


    @Override
    public void swap(E firstKey, E secondKey) {
        final Tree<E> firstNode = findByKey(firstKey);
        final Tree<E> secondNode = findByKey(secondKey);

        if (firstNode.isAncestorOf(secondNode)) {
            firstNode.replaceWith(secondNode);

        } else if (secondNode.isAncestorOf(firstNode)) {
            secondNode.replaceWith(firstNode);

        } else {
            firstNode.swapWith(secondNode);
        }
    }

    private void swapWith(Tree<E> otherNode) {
        final Tree<E> thisParent = this.getParent();
        final List<Tree<E>> thisSiblings = thisParent.getChildren();
        final int thisIndex = thisSiblings.indexOf(this);

        final Tree<E> otherParent = otherNode.getParent();
        final List<Tree<E>> otherSiblings = otherParent.getChildren();
        final int otherIndex = otherSiblings.indexOf(otherNode);

        this.setParent(otherParent);
        otherSiblings.set(otherIndex, this);

        otherNode.setParent(thisParent);
        thisSiblings.set(thisIndex, otherNode);
    }

    public E getKey() {
        return key;
    }

    public Tree<E> getParent() {
        return parent;
    }

    public List<Tree<E>> getChildren() {
        return children;
    }

    public void setParent(Tree<E> parent) {
        this.parent = parent;
    }

    private void doOrderDFS(Tree<E> tree, List<E> list) {
        tree.getChildren().forEach(child -> child.doOrderDFS(child, list));
        list.add(tree.getKey());
    }

    private Tree<E> findByKey(E key) {
        final Queue<Tree<E>> queue = new ArrayDeque<>();
        queue.offer(this);
        while (!queue.isEmpty()) {
            final Tree<E> polled = queue.poll();
            if (polled.getKey().equals(key)) {
                return polled;
            }
            polled.getChildren().forEach(queue::offer);
        }

        throw new IllegalArgumentException(String.format(NO_TREE_WITH_SUCH_KEY_MSG_FORMAT, key));
    }

    private boolean isRoot() {
        return this.getParent() == null;
    }

    private boolean isAncestorOf(Tree<E> otherNode) {
        Tree<E> parent = otherNode.getParent();
        while (parent != null) {
            if (parent.equals(this)) {
                return true;
            }
            parent = parent.getParent();
        }
        return false;
    }

    private void replaceWith(Tree<E> otherNode) {
        final Tree<E> parent = this.getParent();
        otherNode.setParent(parent);

        if (this.isRoot()) {
            this.key = otherNode.getKey();
            this.children = otherNode.getChildren();

        } else {
            final List<Tree<E>> siblings = parent.getChildren();
            final int index = siblings.indexOf(this);
            siblings.set(index, otherNode);
        }
    }
}



