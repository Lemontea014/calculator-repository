/* Generated By:JavaCC: Do not edit this line. SimpleCalculatorParserVisitor.java Version 7.0.12 */
package rei;

public interface SimpleCalculatorParserVisitor
{
  public Object visit(SimpleNode node, Object data);
  public Object visit(ASTRoot node, Object data);
  public Object visit(ASTExpr node, Object data);
  public Object visit(ASTAddExpr node, Object data);
  public Object visit(ASTMulExpr node, Object data);
  public Object visit(ASTUnaryExpr node, Object data);
  public Object visit(ASTDecimal node, Object data);
}
/* JavaCC - OriginalChecksum=e5d2f41246543511a9f23e9ec2ea1cda (do not edit this line) */
