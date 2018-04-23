public class Main {

    public static void main(String[] args) {
        Message msg = new Message("Emergency");
        Fireman fireman = new Fireman(msg);
        new Thread(fireman, "Fireman").start();
        Administrator administrator = new Administrator(msg);
        new Thread(administrator, "Administrator").start();
    }
}