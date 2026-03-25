package lab8;

import java.awt.*;
import java.util.ArrayList;

/**
 * Tower of Hanoi simulation.
 */
public class TowerOfHanoi {
    // towers of disks
    private ArrayList<Integer> towerA;
    private ArrayList<Integer> towerB;
    private ArrayList<Integer> towerC;

    // number of total disks
    private int numDisks;

    // the canvas
    private SimpleCanvas canvas;

    // the colors of the disks, initialized randomly
    private ArrayList<Color> diskColors;

    // the pause time between disks moving
    private int pauseTime;

    public TowerOfHanoi(int numDisks, int pauseTime) {
        this.numDisks = numDisks;
        this.pauseTime = pauseTime;

        // make empty towers
        towerA = new ArrayList<Integer>();
        towerB = new ArrayList<Integer>();
        towerC = new ArrayList<Integer>();

        // make empty colors arraylist
        diskColors = new ArrayList<Color>();

        // add disks to tower A
        for (int i = numDisks; i > 0; i--) {
            towerA.add(i);
            diskColors.add(new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255)));
        }

        // create a canvas
        canvas = new SimpleCanvas(600, 500);
    }

    /**
     * Run the simulation.
     */
    public void run() {
        canvas.show();
        draw();
        canvas.setPenColor(Color.BLACK);
        canvas.drawString(20, 20, "Click screen to begin!");
        canvas.update();
        canvas.waitForClick();

        // begin simulation
        moveTopNDisks(towerA.size(), towerA, towerC, towerB);
    }

    /**
     * Recursive function that moves "n" disks from startTower to endTower,
     * using tempTower as the intermediate storage tower.
     */
    private void moveTopNDisks(int n, ArrayList<Integer> startTower, ArrayList<Integer> endTower, ArrayList<Integer> tempTower) {

        // Are we moving one disk or many disks?
        if (n == 1) { // base case
            int topDisk = startTower.getLast(); // get the disk on top of the starting tower (last disk in list)
            startTower.removeLast(); // remove top (last) disk
            endTower.add(topDisk);  // add this disk to the top of the stack it's going to

            draw();
            canvas.pause(pauseTime);
        } else { // recursive case
            moveTopNDisks(n - 1, startTower, tempTower, endTower);
            moveTopNDisks(1, startTower, endTower, tempTower);
            moveTopNDisks(n - 1, tempTower, endTower, startTower);
        }
    }


    /**
     * Draw the stacks (you can ignore this method).
     */
    private void draw() {
        canvas.clear();
        int widthOfWidestDisk = (int) ((canvas.getWidth() / 3) * .9); // divide into thirds with space for gap
        int diskWidthChange = ((widthOfWidestDisk / (numDisks + 1)));
        int diskHeight = Math.min(20, canvas.getHeight() / (numDisks + 1)); // height of one disk

        // draw stack A (left stack)
        int bottomOfDisk = canvas.getHeight() - 2;
        for (int i = 0; i < towerA.size(); i++) {
            int diskNumber = towerA.get(i);
            Color diskColor = diskColors.get(diskNumber - 1);
            int diskWidth = widthOfWidestDisk - diskWidthChange * (numDisks - diskNumber);
            int diskCenterX = canvas.getWidth() / 6;
            canvas.setPenColor(diskColor);
            canvas.drawFilledRectangle(diskCenterX - diskWidth / 2, bottomOfDisk - diskHeight, diskWidth, diskHeight - 1);

            bottomOfDisk -= diskHeight;
        }

        // draw stack B (middle stack)
        bottomOfDisk = canvas.getHeight() - 2;
        for (int i = 0; i < towerB.size(); i++) {
            int diskNumber = towerB.get(i);
            Color diskColor = diskColors.get(diskNumber - 1);
            int diskWidth = widthOfWidestDisk - diskWidthChange * (numDisks - diskNumber);
            int diskCenterX = canvas.getWidth() / 2;
            canvas.setPenColor(diskColor);
            canvas.drawFilledRectangle(diskCenterX - diskWidth / 2, bottomOfDisk - diskHeight, diskWidth, diskHeight - 1);

            bottomOfDisk -= diskHeight;
        }

        // draw stack C (right stack)
        bottomOfDisk = canvas.getHeight() - 2;
        for (int i = 0; i < towerC.size(); i++) {
            int diskNumber = towerC.get(i);
            Color diskColor = diskColors.get(diskNumber - 1);
            int diskWidth = widthOfWidestDisk - diskWidthChange * (numDisks - diskNumber);
            int diskCenterX = canvas.getWidth() * 5 / 6;
            canvas.setPenColor(diskColor);
            canvas.drawFilledRectangle(diskCenterX - diskWidth / 2, bottomOfDisk - diskHeight, diskWidth, diskHeight - 1);

            bottomOfDisk -= diskHeight;
        }
        canvas.update();
    }

    public String toString() {
        return towerA + " " + towerB + " " + towerC;
    }

}
