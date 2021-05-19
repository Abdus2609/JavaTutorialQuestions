package treenodes;

public class GeneralTreeNode<E> extends AbstractTreeNode<E> {

  private final TreeNode<E>[] children;

  @SuppressWarnings("unchecked")
  public GeneralTreeNode(int numberOfChildren) {
    children = (TreeNode<E>[]) new TreeNode[numberOfChildren];
  }

  @Override
  public int getNumberOfChildren() {
    return children.length;
  }

  @Override
  public TreeNode<E> getChild(int childIndex) {
    return children[childIndex];
  }

  @Override
  public void setChild(int childIndex, TreeNode<E> child) {
    children[childIndex] = child;
  }

  @Override
  public GeneralTreeNode<E> clone() {
    GeneralTreeNode<E> newNode = new GeneralTreeNode<>(getNumberOfChildren());
    newNode.setKey(getKey());
    for (int i = 0; i < getNumberOfChildren(); i++) {
      newNode.setChild(i, getChild(i).clone());
    }

    return newNode;
  }
}
