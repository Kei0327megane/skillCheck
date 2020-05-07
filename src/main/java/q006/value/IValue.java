package q006.value;

import java.math.BigDecimal;
import java.util.Stack;

/**
 * 値のインタフェース
 */
public interface IValue {
    /**
     * 計算を実行する
     *
     * @param values 値の保存されたスタック
     */
    void execute(Stack<BigDecimal> values);
}
