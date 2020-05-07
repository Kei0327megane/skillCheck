package q003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Q003 集計と並べ替え
 *
 * 以下のデータファイルを読み込んで、出現する単語ごとに数をカウントし、アルファベット辞書順に並び変えて出力してください。
 * resources/q003/data.txt
 * 単語の条件は以下となります
 * - "I"以外は全て小文字で扱う（"My"と"my"は同じく"my"として扱う）
 * - 単数形と複数形のように少しでも文字列が異れば別単語として扱う（"dream"と"dreams"は別単語）
 * - アポストロフィーやハイフン付の単語は1単語として扱う（"isn't"や"dead-end"）
 *
 * 出力形式:単語=数
 *
[出力イメージ]
（省略）
highest=1
I=3
if=2
ignorance=1
（省略）

 * 参考
 * http://eikaiwa.dmm.com/blog/4690/
 */
public class Q003 {
    /**
     * データファイルを開く
     * resources/q003/data.txt
     */
    private static InputStream openDataFile() {
        return Q003.class.getResourceAsStream("data.txt");
    }

    public static void main(String[] args) {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(openDataFile()));

        StringBuilder stringBuilder = new StringBuilder();
        Map<String, Integer> wordMap = new HashMap<>();
        bufferedReader.lines().forEach(line -> {
            String[] wordList = line.split("[,;. ]");
            Arrays.stream(wordList)
                    .filter(word -> !"".equals(word))
                    .forEach(value -> {
                        convertWordMap(wordMap, value);
                    });
            stringBuilder.append(line);
        });

        Map<String, Integer> sortMap = new TreeMap<>(wordMap);
        sortMap.keySet().stream().forEach(word -> System.out.println(word + "=" + sortMap.get(word)));
    }

    private static void convertWordMap(Map<String, Integer> wordMap, String value) {
        String word = convertWord(value);
        if (wordMap.containsKey(word)) {
            wordMap.put(word, wordMap.get(word) + 1);
        } else {
            wordMap.put(word, 1);
        }
    }

    private static String convertWord(String word) {
        return "I".equals(word) ? word : word.toLowerCase();
    }

}
// 完成までの時間: xx時間 60分