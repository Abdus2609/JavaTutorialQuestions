package treenodes;

public class BinaryTreeNode<E> extends AbstractTreeNode<E> {

  private TreeNode<E> firstChild;
  private TreeNode<E> secondChild;

  @Override
  public TreeNode<E> getChild(int childIndex) {
    if (childIndex == 0) {
      return firstChild;
    }
    if (childIndex == 1) {
      return secondChild;
    }
    assert false;
    return null;
  }

  @Override
  public int getNumberOfChildren() {
    return 2;
  }

  @Override
  public void setChild(int childIndex, TreeNode<E> child) {
    if (childIndex == 0) {
      firstChild = child;
    } else if (childIndex == 1) {
      secondChild = child;
    } else {
      assert false;
    }
  }

  @Override
  public BinaryTreeNode<E> clone() {
    BinaryTreeNode<E> newNode = new BinaryTreeNode<>();
    newNode.setKey(getKey());
    for (int i = 0; i < getNumberOfChildren(); i++) {
      newNode.setChild(i, getChild(i).clone());
    }

    return newNode;
  }
}
