public class Ram {
    int size;
    byte[] memoryArray;

    public Ram(int size) {
        this.size = size;
        memoryArray = new byte[size];
    }

    public void write(int address, byte data) {
        if (address >= 0 && address < size) {
            memoryArray[address] = data;
        } else {
            System.out.println("주소 범위를 벗어났습니다.");
        }
    }

    public byte read(int address) {
        if (address >= 0 && address < size) {
            return memoryArray[address];
        } else {
            System.out.println("주소 범위를 벗어났습니다.");
            return -1;
        }
    }

    public int getSize() {
        return size;
    }
}
