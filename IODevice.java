import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IODevice {
    private List<String> devices;
    private final String SAVE_FILE = "devices.txt";

    public IODevice() {
        devices = new ArrayList<>();
        loadDevices(); // 프로그램 시작 시 장치 목록 불러오기
    }

    public void addDevice(String device) {
        if (!devices.contains(device)) {
            devices.add(device);
            saveDevices(); // 장치 추가 시 저장
            System.out.println("장치 연결됨: " + device);
        } else {
            System.out.println("이미 연결된 장치입니다: " + device);
        }
    }

    public void removeDevice(String device) {
        if (devices.remove(device)) {
            saveDevices(); // 장치 제거 시 저장
            System.out.println("장치 제거됨: " + device);
        } else {
            System.out.println("해당 장치는 연결되어 있지 않습니다: " + device);
        }
    }

    public void displayInfo() {
        System.out.println("현재 입출력 장치 목록:");
        if (devices.isEmpty()) {
            System.out.println("(연결된 장치 없음)");
        } else {
            for (String device : devices) {
                System.out.println("- " + device);
            }
        }
    }

    public String receiveInput(String input) {
        System.out.println("입력 받음: " + input);
        return input;
    }

    public void displayOutput(String output) {
        System.out.println("출력됨: " + output);
    }

    public boolean hasDevice(String device) {
        return devices.contains(device);
    }

    // 장치 목록 저장
    private void saveDevices() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(SAVE_FILE))) {
            for (String device : devices) {
                writer.println(device);
            }
        } catch (IOException e) {
            System.out.println("장치 저장 실패: " + e.getMessage());
        }
    }

    // 장치 목록 불러오기
    private void loadDevices() {
        File file = new File(SAVE_FILE);
        if (!file.exists()) return;

        try (Scanner reader = new Scanner(file)) {
            while (reader.hasNextLine()) {
                String line = reader.nextLine().trim();
                if (!line.isEmpty() && !devices.contains(line)) {
                    devices.add(line);
                }
            }
        } catch (IOException e) {
            System.out.println("장치 불러오기 실패: " + e.getMessage());
        }
    }

    // 메인 함수
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
