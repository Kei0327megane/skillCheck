package qizawayu;

/**
 * 数あてゲーム（ヌメロン）を作ってください。
 * 　数あてゲームのルール
 * 　1.答となる数字の重複しない3桁の数字を生成
 * 　2.数字の重複しない3桁の数字を入力させます
 * 　3.以下のルールで入力値を判定
 * 　　3-1.数値、桁共にあっている場合「EAT」とします
 * 　　3-2.数値はあっているが桁が違う場合「BITE」とします
 * 　4.「EAT」と「BITE」の数を出力
 * 　5.「3EAT」になるまで 2～4をループ
 *
 * 条件
 * ・アイテムなどの特殊なルールはなし
 * ・入力値エラーは考慮しない（数字の重複の確認はする）
 *
 * おまけ
 * ・桁数を変更しやすいコードにしてください
 * ・最後に正解までの入力数を表示させてください
 *
 * 完成までの目安: 1時間ぐらい
 * --以下出力例--
 Please enter 3 digit number
 Input > 012
 turn1: 0eat, 0bite
 Input > 345
 turn2: 1eat, 1bite
 Input > 678
 turn3: 0eat, 1bite
 Input > 356
 turn4: 2eat, 0bite
 Input > 357
 turn5: 3eat, 0bite
 answer = 357
 TotalTurn = 5
 */
public class Qizawayu {
}
