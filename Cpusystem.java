public class Cpusystem {
    private String modelName;
    private int coreCount; //코어수
    private int threadCount; //스레드수
    private double clockSpeedGHz; //클럭 속도
    private double usagePercent; //현재 사용률

    public Cpusystem(String modelName, int coreCount, int threadCount, double clockSpeedGHz) {
        this.modelName = modelName;
        this.coreCount = coreCount;
        this.threadCount = threadCount;
        this.clockSpeedGHz = clockSpeedGHz;
        this.usagePercent = 0.0;
    }

    public void processTask(String taskName) {
        System.out.println("Processing task: " + taskName + "...");
        usagePercent += 10;
        if (usagePercent > 100) usagePercent = 100;
    }

    public void simulateMultithreading(String[] tasks) {
        System.out.println("Simulating multithreading with " + tasks.length + " tasks...");
        for (String task : tasks) {
            System.out.println(">> Executing task: " + task);
        }
        usagePercent += tasks.length * 5;
        if (usagePercent > 100) usagePercent = 100;
    }

    public void decreaseLoad(double percent) {
        usagePercent -= percent;
        if (usagePercent < 0) usagePercent = 0;
    }

    public void getStatus() {
        System.out.println("Model: " + modelName);
        System.out.println("Cores: " + coreCount);
        System.out.println("Threads: " + threadCount);
        System.out.println("Clock: " + clockSpeedGHz + "GHz");
        System.out.println("Usage: " + usagePercent + "%");
    }
}
