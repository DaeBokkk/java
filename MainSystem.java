public class MainSystem {
    public static void main(String[] args) {
        // CPU 사용
        Cpusystem cpu = new Cpusystem("Intel i7", 8, 16, 3.6);
        cpu.getStatus();
        cpu.processTask("윈도우 부팅");
        cpu.simulateMultithreading(new String[]{"게임 실행", "음악 재생"});
        cpu.getStatus();

        System.out.println();

        // 입출력장치 사용
        IODevice io = new IODevice();
        io.addDevice("마우스");
        io.addDevice("키보드");
        io.displayInfo();
        io.displayOutput("모니터에 'Hello World' 출력");
        String input = io.receiveInput("유저 입력값");
        System.out.println(">> 처리된 입력: " + input);

        System.out.println();

        // 메모리 사용
        Ram ram = new Ram(1024);
        CacheMemory cache = new CacheMemory(5);

        ram.write(100, (byte) 42);
        System.out.println("RAM에서 읽은 값: " + ram.read(100));

        cache.write(1, (byte) 10);
        cache.write(2, (byte) 20);
        System.out.println("Cache에서 읽은 값(1): " + cache.read(1));
        System.out.println("Cache에서 읽은 값(3): " + cache.read(3));

        System.out.println();

        // 저장장치 사용
        HDD hdd = new HDD("WesternDigital", 500);
        hdd.installProgram("MS Word", 10);
        hdd.uninstallProgram("MS Word");

        System.out.println();

        SSD ssd = new SSD("Samsung SSD", 256);
        ssd.installProgram("Chrome", 2);
        ssd.installProgram("VSCode", 4);
        ssd.uninstallProgram("Chrome");
    }
}

