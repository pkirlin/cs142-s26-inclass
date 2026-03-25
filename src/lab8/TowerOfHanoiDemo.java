package lab8;

public class TowerOfHanoiDemo {
    public static void main(String[] args) {
        // You can modify the number of disks below,
        // as well as the pause time between moves (milliseconds).
        TowerOfHanoi game = new TowerOfHanoi(64, 5);
        game.run();
    }
}
