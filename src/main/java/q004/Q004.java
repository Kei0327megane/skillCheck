package q004;

/**
 * Q004 ソートアルゴリズム
 *
 * ListManagerクラスをnewして、小さい順に並び変えた上でcheckResult()を呼び出してください。
 *
 * 実装イメージ:
 * ListManager data = new ListManager();
 * // TODO 並び換え
 * data.checkResult();
 *
 * - ListManagerクラスを修正してはいけません
 * - ListManagerクラスの dataList を直接変更してはいけません
 * - ListManagerクラスの比較 compare と入れ替え exchange を使って実現してください
 */
public class Q004 {
    public static void main(String[] args) {
        ListManager data = new ListManager();
        for (int x = data.size(); 0 < x; x--) {
            for (int y = 0; y < x - 1; y++) {
                if (data.compare(y, y+1) == 1) {
                    data.exchange(y, y+1);
                }
            }
        }
        data.checkResult();
    }
}
// 完成までの時間: xx時間 30分