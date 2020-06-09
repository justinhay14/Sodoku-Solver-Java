import java.util.concurrent.TimeoutException;

public class TimeOut implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
            System.out.println("ended");
        } catch (InterruptedException e) {
            System.out.println("succeeded");
        }
    }
}
