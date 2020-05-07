package q006.value;

import java.math.BigDecimal;
import java.util.Stack;

/**
 * 数値を保持するクラス
 */
public class DecimalValue implements IValue {
    /**
     * 保持する値
     */
    private BigDecimal value;

    public DecimalValue(String text) {
        value = new BigDecimal(text);
    }

    @Override
    public void execute(Stack<BigDecimal> values) {
        // スタックに値を積む
        values.push(value);
    }
}
