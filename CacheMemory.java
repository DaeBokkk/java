public class CacheMemory {
    int size;
    int[] addresses;
    byte[] values;
    int nextIndex = 0;

    public CacheMemory(int size) {
        this.size = size;
        addresses = new int[size];
        values = new byte[size];

        for(int i = 0; i < size; i++){
            addresses[i] = -1;
        }
    }

    public void write(int address, byte data) {
        for(int i = 0; i < size; i++){
            if(addresses[i] == address){
                values[i] = data;
                return;
            }
        }

        addresses[nextIndex] = address;
        values[nextIndex] = data;
        nextIndex = (nextIndex + 1) % size;
    }

    public byte read(int address) {
        for(int i = 0; i < size; i++){
            if(addresses[i] == address){
                return values[i];
            }
        }
        System.out.println("캐시 미스 발생");
        return -1;
    }

    public int getSize() {
        return size;
    }
}
