import java.time.LocalTime;

public class Fireman implements Runnable {

    private final Message msg;

    public Fireman(Message msg) {
        this.msg = msg;
    }

    public void run() {
        String name = Thread.currentThread().getName();
        synchronized (msg) {
            try {
                System.out.println(name + " is on duty and waiting for administrator call " + LocalTime.now());
                msg.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + " accept incoming call from administrator " + LocalTime.now());
            System.out.println(name + " : I'm going to the fire! " + LocalTime.now());
        }
    }
}
