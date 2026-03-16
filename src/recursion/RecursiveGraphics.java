package recursion;

import oop1.SimpleCanvas;

public class RecursiveGraphics {
    public static void main(String[] args) {
        squares();
    }

    public static void squares() {
        SimpleCanvas canvas = new SimpleCanvas(800, 800);
        canvas.show();
        drawSquare(canvas, 400, 400, 400);
        canvas.update();

    }

    public static void drawSquare(SimpleCanvas canvas, int centerX, int centerY, int size) {
        if (size >= 100) {
            canvas.drawRectangle(centerX - size/2, centerY - size/2, size, size);
            drawSquare(canvas, centerX - size/2, centerY - size/2, size/2);
            drawSquare(canvas, centerX + size/2, centerY - size/2, size/2);
            drawSquare(canvas, centerX + size/2, centerY + size/2, size/2);
            drawSquare(canvas, centerX - size/2, centerY + size/2, size/2);
        }
    }
}
