import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        IODevice io = new IODevice();
        Scanner scanner = new Scanner(System.in);

        System.out.println("입출력 장치 추가 (exit 입력 시 종료)");

        while (true) {
            System.out.print("추가할 장치 이름 입력: ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            io.addDevice(input);
        }

        System.out.println();
        io.displayInfo();

        scanner.close();
    }
}
