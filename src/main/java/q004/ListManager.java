package q004;

import java.util.Random;

/**
 * リスト管理クラス
 * このクラスを変更してはいけません
 */
public class ListManager {
    private int[] dataList;
    private int compareCount;
    private int exchangeCount;

    public ListManager() {
        // データをランダムに作成する
        Random random = new Random();
        dataList = new int[100];
        for (int i = 0; i < dataList.length; i++) {
            dataList[i] = random.nextInt(10000);
        }
    }

    /**
     * 2つのデータを比較する
     *
     * @param index1
     * @param index2
     * @return -1:index1のデータが小さい, 1:index2のデータが小さい, 0:同じデータ
     */
    public int compare(int index1, int index2) {
        compareCount++;
        return (int) Math.signum(dataList[index1] - dataList[index2]);
    }

    /**
     * 2つのデータを入れ替える
     *
     * @param index1
     * @param index2
     */
    public void exchange(int index1, int index2) {
        exchangeCount++;
        int tmp = dataList[index1];
        dataList[index1] = dataList[index2];
        dataList[index2] = tmp;
    }

    /**
     * ソートが正しく行われたかをチェックする
     */
    public void checkResult() {
        int data = dataList[0];
        for (int i = 1; i < dataList.length; i++) {
            if (data > dataList[i]) {
                throw new RuntimeException("ソートされていない: [" + (i - 1) + "]=" + data + ", [" + i + "]=" + dataList[i]);
            }
            data = dataList[i];
        }
        System.out.println("ソートOK: 比較=" + compareCount + ", 入れ替え=" + exchangeCount);
    }

    /**
     * データのサイズを取得する
     *
     * @return
     */
    public int size() {
        return dataList.length;
    }
}
