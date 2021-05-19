package treenodes;

public class TreeNodeIncorrect<E> {

  private final TreeNodeIncorrect<E>[] children;
  private E key;

  @SuppressWarnings("unchecked")
  public TreeNodeIncorrect(int numberOfChildren) {
    children = (TreeNodeIncorrect<E>[]) new TreeNodeIncorrect[numberOfChildren];
  }

  public int getNumberOfChildren() {
    return children.length;
  }

  public TreeNodeIncorrect<E> getChild(int childIndex) {
    return children[childIndex];
  }

  public void setChild(int childIndex, TreeNodeIncorrect<E> child) {
    children[childIndex] = child;
  }

  public E getKey() {
    return key;
  }

  public void setKey(E key) {
    this.key = key;
  }
}
