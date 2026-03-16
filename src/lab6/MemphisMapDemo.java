package lab6;

public class MemphisMapDemo {

    public static void main(String[] args)
    {
        SimpleCanvas canvas = new SimpleCanvas(700, 700);
        canvas.show();
        MemphisMap map = new MemphisMap(canvas);
        map.draw();
    }

}
