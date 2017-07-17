package cwl.ekkel.c21;

/**
 * Created by vadim.tishenko
 * on 17.07.2017 22:51.
 */
public class E2 {
    public static void main(String[] args) {
        for(int i=0;i<10;i++){
            Thread t = new Thread(new Fibonacci(20));
            t.start();
        }

    }
}

class Fibonacci implements Runnable {
    static int count=0;
    long max;
    int id;

    Fibonacci(long n) {
        id=count++;
        max = n;
    }

    @Override
    public void run() {
        long fn = 1;
        long fp = 0;
        print(fp);
        for (int i = 0; i < max; i++) {
            print(fn);
            long next = fn + fp;
            fp = fn;
            fn = next;
            Thread.yield();
        }

    }

    void print(long n) {
        System.out.printf("#%d(%d) ", id, n);
    }
}
