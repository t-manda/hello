package kazuate.src.main;

import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;

public class NumberHitGame {

    public static int correctNumber;// 正解の番号

    public static void main(String[] args) throws Exception {

        // 初期設定
        setRandomCorrectNumber();
        int number;
        Boolean isCorrect = false;// 正解したかどうか

        System.out.println("数当てゲームを始めます。");
        System.out.printf("0-99の数字を当ててみてください(正解：%d)\n", correctNumber);

        for (int i = 1; i <= 5; i++) {
            System.out.printf("%d回目 1-99の数値を入力：", i);
            number = inputNumber();

            // 正解か判定
            if (number == correctNumber) {
                // 数値があっていた場合
                System.out.printf("入力：%d 当たりです！\n", number);
                isCorrect = true;
                break;

            } else {// 不正解の場合
                if (number > correctNumber) {// 正解より大きい数値を入力した場合
                    System.out.printf("入力：%d はずれです...もっと小さい値を入力してください\n", number);
                } else {// 正解より小さい数値を入力した場合
                    System.out.printf("入力：%d はずれです...もっと大きい値を入力してください\n", number);
                }

                // 20以上離れていれば、その旨を出力する
                if (Math.abs(number - correctNumber) >= 20) {
                    System.out.printf("正解から20以上外れています\n");
                }
            }
        }

        // 正解したか判定する
        if (isCorrect) {
            // 正解の場合
            System.out.println("正解おめでとうございます！");

        } else {
            // 不正解の場合
            System.out.println("残念ながら、あなたは正解出来ませんでした...");
        }

        System.out.println("システムを終了します。");
        return;

    }

    // 0-99のランダムな数値を作成し、correctNumberに代入する
    public static void setRandomCorrectNumber() {
        Random r = new Random();
        correctNumber = r.nextInt(100);
    }

    // 数値を入力させる
    public static int inputNumber() {
        // 初期設定
        Scanner scanner = new Scanner(System.in);
        int input = 0;

        // 正しい入力がされるまでループ
        while (true) {
            try {
                // 数値を入力
                input = scanner.nextInt();

                // 範囲外なら例外を投げる
                if (input < 0 || 99 < input) {
                    throw new InputMismatchException();
                }
                break;

                // 入力例外
            } catch (InputMismatchException e) {
                System.out.println("0-99の数字を入力してください");
                scanner.next();
            }
        }
        return input;
    }
}
