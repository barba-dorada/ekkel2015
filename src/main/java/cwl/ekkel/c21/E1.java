package cwl.ekkel.c21;

/**
 * Created by vadim.tishenko
 * on 17.07.2017 22:28.
 */
public class E1 implements Runnable {
    int id = 0;
    static int count = 0;

    public E1() {

        id = count++;
    }

    public static void main(String[] args) {
        System.out.println("app start");
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(new E1());
            t.start();
        }
        System.out.println("app finish");
    }

    public void run() {
        for (int c = 0; c < 10; c++) {
            System.out.printf("#%d(%d) ", id, c);
            Thread.yield();
        }
    }
}
