import java.time.LocalTime;

public class Administrator implements Runnable {

    private final Message msg;

    public Administrator(Message msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name + " is waiting for emergency call " + LocalTime.now());
        try {
            Thread.sleep(5000);
            synchronized (msg) {
                msg.notify();
                System.out.println("Incoming emergency call " + LocalTime.now());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
