import java.util.ArrayList;
import java.util.List;

public class IODevice {
    private List<String> devices;

    public IODevice() {
        devices = new ArrayList<>();
    }

    // 장치 추가
    public void addDevice(String device) {
        if (!devices.contains(device)) {
            devices.add(device);
            System.out.println("장치 연결됨: " + device);
        } else {
            System.out.println("이미 연결된 장치입니다: " + device);
        }
    }

    // 장치 제거
    public void removeDevice(String device) {
        if (devices.remove(device)) {
            System.out.println("장치 제거됨: " + device);
        } else {
            System.out.println("해당 장치는 연결되어 있지 않습니다: " + device);
        }
    }

    // 장치 목록 출력
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

    // 입력 시뮬레이션
    public String receiveInput(String input) {
        System.out.println("입력 받음: " + input);
        return input;
    }

    // 출력 시뮬레이션
    public void displayOutput(String output) {
        System.out.println("출력됨: " + output);
    }

    // 장치 존재 여부 확인
    public boolean hasDevice(String device) {
        return devices.contains(device);
    }
}
