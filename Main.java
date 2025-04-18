public class Main {
    public static void main(String[] args) {
        StorageDevice SSD = new StorageDevice("samsung", 100, "SSD");
        StorageDevice HDD = new StorageDevice("Sandisk", 500, "HDD");

        SSD.installProgram("games", 20);
        SSD.installProgram("tools", 80);
        SSD.installProgram("tools", 80);
        SSD.uninstallProgram("games");
        SSD.printInfo();
        SSD.installProgram("roo", 10);
        SSD.installProgram("r", 190);
    }
}