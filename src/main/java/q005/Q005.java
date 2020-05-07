package q005;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Q005 データクラスと様々な集計
 *
 * 以下のファイルを読み込んで、WorkDataクラスのインスタンスを作成してください。
 * resources/q005/data.txt
 * (先頭行はタイトルなので読み取りをスキップする)
 *
 * 読み込んだデータを以下で集計して出力してください。
 * (1) 役職別の合計作業時間
 * (2) Pコード別の合計作業時間
 * (3) 社員番号別の合計作業時間
 * 上記項目内での出力順は問いません。
 *
 * 作業時間は "xx時間xx分" の形式にしてください。
 * また、WorkDataクラスは自由に修正してください。
 *
[出力イメージ]
部長: xx時間xx分
課長: xx時間xx分
一般: xx時間xx分
Z-7-31100: xx時間xx分
I-7-31100: xx時間xx分
T-7-30002: xx時間xx分
（省略）
194033: xx時間xx分
195052: xx時間xx分
195066: xx時間xx分
（省略）
 */
public class Q005 {
    /**
     * データファイルを開く
     * resources/q003/data.txt
     */
    private static InputStream openDataFile() {
        return Q005.class.getResourceAsStream("data.txt");
    }

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(openDataFile()));
        List<WorkData> workDataList = new ArrayList<>();
        bufferedReader.lines().skip(1).forEach(line -> {
            String[] outputList = line.split(",");
            WorkData workData = new WorkData(
                    outputList[0],
                    outputList[1],
                    outputList[2],
                    outputList[3],
                    Integer.parseInt(outputList[4]));
            workDataList.add(workData);
        });

        // 役職別の合計作業時間
        workDataList.stream()
                .collect(Collectors.groupingBy(WorkData::getPosition, Collectors.summingInt(WorkData::getWorkTime)))
                .forEach((position, workTimeTotal) -> System.out.println(position + ":" + convertTime(workTimeTotal)));

        // Pコード別の合計作業時間
        workDataList.stream()
                .collect(Collectors.groupingBy(WorkData::getPCode, Collectors.summingInt(WorkData::getWorkTime)))
                .forEach((pCode, workTimeTotal) -> System.out.println(pCode + ": " + convertTime(workTimeTotal)));

        // 社員番号別の合計作業時間
        workDataList.stream()
                .collect(Collectors.groupingBy(WorkData::getNumber, Collectors.summingInt(WorkData::getWorkTime)))
                .forEach((number, workTimeTotal) -> System.out.println(number + ": " + convertTime(workTimeTotal)));
    }

    private static String convertTime(int workTimeTotal) {
        int hour = workTimeTotal/60;
        int minutes = workTimeTotal%60;
        return hour + "時間" + minutes + "分";
    }


}
// 完成までの時間: xx時間 60分