package app;

public class Main {

    public static final int MAX_SHARES = 30;
    public static void main(String[] args) throws InterruptedException{
        Broker broker = new Broker(MAX_SHARES);

        Client Pedro = new Client("Pedro", broker);
        Client Patricia = new Client("Patricia", broker);
        Client Elena = new Client("Helena", broker);
        Client Jesus = new Client("Jesus", broker);

        System.out.println("Welcome, clients.");
        Pedro.start();
        Patricia.start();
        Elena.start();
        Jesus.start();


        System.out.println("Joining...");
        Pedro.join();
        Patricia.join();
        Elena.join();
        Jesus.join();

        System.out.println("Interrupt");
        Pedro.interrupt();
        Patricia.interrupt();
        Elena.interrupt();
        Jesus.interrupt();

        System.out.println("Done.");
    }
}
