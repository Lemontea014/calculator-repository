/* Generated By:JJTree: Do not edit this line. ASTUnaryExpr.java Version 7.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package rei;

public
class ASTUnaryExpr extends SimpleNode {
  public ASTUnaryExpr(int id) {
    super(id);
  }

  public ASTUnaryExpr(SimpleCalculatorParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(SimpleCalculatorParserVisitor visitor, Object data) {

    return
    visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=f11e6f1adb2bd8947fa276bb4bb86429 (do not edit this line) */