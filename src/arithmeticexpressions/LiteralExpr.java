package arithmeticexpressions;

public class LiteralExpr implements Expr {

  private final int value;

  public LiteralExpr(int value) {
    this.value = value;
  }

  @Override
  public int eval() {
    return value;
  }

  @Override
  public int literalCount() {
    return 1;
  }

  @Override
  public int depth() {
    return 0;
  }

  @Override
  public String toString() {
    return Integer.toString(value);
  }
}
