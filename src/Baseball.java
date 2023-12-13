import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Baseball {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] comNumArr = generateRandomNumbers();

        System.out.println("컴퓨터가 숫자를 생성하였습니다. 답을 맞춰보세요!");

        int count = 1;
        while (true) {
            System.out.print(count + "번째 시도 : ");
            int myNum = sc.nextInt();
            int[] myNumArr = {myNum / 100, (myNum % 100) / 10, myNum % 10};
            int strike = 0;
            int ball = 0;
            for (int i = 0; i < comNumArr.length; i++) {
                for (int j = 0; j < myNumArr.length; j++) {
                    if (comNumArr[i] == myNumArr[j]) {
                        if (i == j) {
                            strike++;
                        } else {
                            ball++;
                        }
                    }
                }
            }

            if (ball == 3) {
                System.out.println(ball + "B");
            } else if (strike == 3) {
                System.out.println(strike + "S");
            } else {
                System.out.println(ball + "B" + strike + "S");
            }

            if (strike == 3) {
                sc.close();
                System.out.println(count + "번만에 맞히셨습니다.");
                System.out.println("게임을 종료합니다.");
                break;
            }
            count++;
        }
    }

    private static int[] generateRandomNumbers() {
        Random random = new Random();
        Set<Integer> randomNumbers = new HashSet<>();

        while (randomNumbers.size() < 3) {
            int randomNumber = random.nextInt(10);
            randomNumbers.add(randomNumber);
        }

        int[] result = new int[3];
        int index = 0;
        for (int number : randomNumbers) {
            result[index++] = number;
        }

        return result;
    }
}