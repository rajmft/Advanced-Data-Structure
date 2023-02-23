package assignment2;

/**
 * Implements a Binary Tree node.
 *
 * @author CSC330
 * @param <AnyType>
 */
public class BinaryNode<AnyType> {

    AnyType element;           // data in the node
    BinaryNode<AnyType> left;  // left child
    BinaryNode<AnyType> right; // right child

    BinaryNode(AnyType theElement) {
        this(theElement, null, null);
    }

    BinaryNode(AnyType theElement, BinaryNode<AnyType> lt,
            BinaryNode<AnyType> rt) {
        element = theElement;
        left = lt;
        right = rt;
    }

    public AnyType getElement() {
        return element;
    }

    public void setElement(AnyType element) {
        this.element = element;
    }

    public BinaryNode<AnyType> getLeft() {
        return left;
    }

    public void setLeft(BinaryNode<AnyType> left) {
        this.left = left;
    }

    public BinaryNode<AnyType> getRight() {
        return right;
    }

    public void setRight(BinaryNode<AnyType> right) {
        this.right = right;
    }

}
