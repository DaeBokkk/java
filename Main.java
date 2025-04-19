public class Main {
    public static void main(String[] args) {
        Ram ram = new Ram(1024);
        CacheMemory cache = new CacheMemory(5);

        ram.write(100, (byte) 42);
        System.out.println("Ram에서 읽은 값: " + ram.read(100));

        cache.write(1, (byte) 10);
        cache.write(2, (byte) 20);
        System.out.println("Cache에서 읽은 값(1): " + cache.read(1));
        System.out.println("Chche에서 읽은 값(3): " + cache.read(3));
    }
}
