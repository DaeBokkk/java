public class StorageDevice {
    private String name; // 장치이름
    private int totalGB; // 용량
    private String type; // SSD, HDD, nvme
    private int usedGB = 0;

    private String[] programNames = new String[100];
    private int[] programSizes = new int[100];
    private int count = 0;

    public StorageDevice(String name, int totalGB, String type) {
        this.name = name;
        this.totalGB = totalGB;
        this.type = type;
        printInfo();
    }

    public void installProgram(String programName, int programSize) { // 프로그램 설치 메서드
        if (isProgramInstalled(programName)) {
            System.out.println("이미 설치되었습니다.");
            return;
        }

        if (usedGB + programSize > totalGB) {
            System.out.println(programName + " 설치 실패: 저장 공간이 부족합니다.");
            return;
        }

        programNames[count] = programName;
        programSizes[count] = programSize;
        usedGB += programSize;
        count++;
        System.out.println(programName + " 설치 완료");
    }

    public void uninstallProgram(String programName) { // 프로그램 삭제 메서드
        for (int i = 0; i < count; i++) {
            if (programName.equals(programNames[i])) {
                int size = programSizes[i];
                usedGB -= size;

                for (int j = i; j < size - 1; j++) { // 삭제할 부분부터 앞으로 댕기면서 덮어 씌우기
                    programSizes[j] = programSizes[j + 1];
                    programNames[j] = programNames[j + 1];
                }
                programSizes[size] = 0;
                programNames[size] = null;
                count--;
                System.out.println("삭제 완료");
                return;
            }
        }
        System.out.println("설치되지 않은 프로그램입니다.");
    }

    public void printInfo() { // 정보 출력
        System.out.println("저장장치 이름: " + name + ", 용량: " + totalGB + "GB, 장치 종류: " + type );
    }

    private boolean isProgramInstalled(String programName) { // 설치가 되있으면 true 안되있으면 false
        for (int i = 0; i < count; i++) {
            if(programName.equals(programNames[i])) {
                return true;
            }
        }
        return false;
    }
}
