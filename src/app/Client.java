package app;

public class Client extends Thread{

    private final String _name;
    private final Broker _broker;
    private int _acciones = 0;

    public Client(String name, Broker broker){
        _name = name;
        _broker = broker;
    }

    @Override
    public void run() {
        int  compra = ((int)(Math.random()*5-1)+1);
        while(true){
            try {
                Thread.sleep((int)(Math.random()*2000-1000)+1000);
                if (_broker.buy(compra, this))
                _acciones += compra;
            } catch (InterruptedException e) {
                System.out.println("Transacción interrumpida.");
                break;
            }
        }
    }

    @Override
    public String toString() {
        return _name;
    }
}
