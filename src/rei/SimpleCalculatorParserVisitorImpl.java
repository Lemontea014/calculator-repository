package rei;

import java.util.List;

public class SimpleCalculatorParserVisitorImpl implements
        SimpleCalculatorParserVisitor {

    @Override
    public Object visit(SimpleNode node, Object data) {
        // 普通は使わない。
        return null;
    }

    @Override
    public Object visit(ASTRoot node, Object data) {
        // 自分の子どものノードを訪れる。子どもが1つのみ存在することは構文定義からわかる。
        return node.jjtGetChild(0).jjtAccept(this, null);
    }

    @Override
    public Object visit(ASTExpr node, Object data) {
        // 自分の子どものノードを訪れる。子どもが1つのみ存在することは構文定義からわかる。
        return node.jjtGetChild(0).jjtAccept(this, null);
    }

    @Override
    public Object visit(ASTAddExpr node, Object data) {
        List<Token> ops = (List<Token>) node.jjtGetValue();
        // 子どもの数を取得
        int size = node.jjtGetNumChildren();
        Double x = (Double) node.jjtGetChild(0).jjtAccept(this, null);
        // 演算子と値を回しながら演算を行う。セットにしながら演算を進める。例) x0 (+ x1) (+ x2) ・・・
        for (int i = 1; i < size; i++) {
            switch (ops.get(i - 1).toString()) {
            case "+":
                x = x + (Double) node.jjtGetChild(i).jjtAccept(this, null);
                break;
            case "-":
                x = x - (Double) node.jjtGetChild(i).jjtAccept(this, null);
                break;
            }
        }
        return x;
    }

    @Override
    public Object visit(ASTMulExpr node, Object data) {
        // jjtGetValue()でjjtSetValue(Object)した値を取得できる。
        List<Token> ops = (List<Token>) node.jjtGetValue();
        int size = node.jjtGetNumChildren();
        Double x = (Double) node.jjtGetChild(0).jjtAccept(this, null);
        // 演算子と値を回しながら演算を行う。セットにしながら演算を進める。例) x0 (* x1) (* x2) ・・・
        for (int i = 1; i < size; i++) {
            switch (ops.get(i - 1).toString()) {
            case "*":
                x = x * (Double) node.jjtGetChild(i).jjtAccept(this, null);
                break;
            case "/":
                x = x / (Double) node.jjtGetChild(i).jjtAccept(this, null);
                break;
            case "%":
                x = x % (Double) node.jjtGetChild(i).jjtAccept(this, null);
                break;
            }
        }
        return x;
    }

    @Override
    public Object visit(ASTUnaryExpr node, Object data) {
        // 子どもが1つでDoubleを返却してくるのでそのまま返却。
        return node.jjtGetChild(0).jjtAccept(this, null);
    }

    @Override
    public Object visit(ASTDecimal node, Object data) {
        // 字句をDouble型に変換して返却。
        return Double.valueOf(((Token) node.jjtGetValue()).toString());
    }

}

