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
        //Pendiente randomizar acciones
        while(true){
            try {
                Thread.sleep((int)(Math.random()*2000-1000)+1000);
                if (_broker.buy(6, this))
                this._acciones += 6;
            } catch (InterruptedException e) {
                System.out.println("Transacción no completada.");
                System.out.println("Acciones actuales de " + _name + " : " + _acciones);
                break;
            }
        }
    }

    @Override
    public String toString() {
        return _name;
    }
}
