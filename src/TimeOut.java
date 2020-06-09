import java.util.concurrent.TimeoutException;

public class TimeOut implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
            throw new TimeoutException();
        } catch (InterruptedException | TimeoutException e) {
            e.printStackTrace();
        }
    }
}
