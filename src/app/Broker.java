package app;

public class Broker {
    private int _acciones;

    public Broker(int acciones) {
        _acciones = acciones;
    }

    public boolean buy(int compra, Client client) {
        //Pendiente añadir modulo para memorizar acciones de los clientes
        boolean ventarealizada = false;
        System.out.println("There's " + _acciones + " available shares.");
        if (_acciones <= 0)
            return false;
            if (_acciones - compra >= 0) {
                System.out.println(client.toString() + " is about to buy " + compra + " shares.");
                _acciones = _acciones - compra;
                //¿Seter acciones del cliente?
                System.out.println("Now there's " + _acciones + " available shares.");
                ventarealizada = true;
            } else {
                System.out.println(client.getName() + " could not buy " + compra + " shares.");
                ventarealizada = false;
            }
        return ventarealizada;
    }

    public synchronized void waitUntilNoSharesAvailable() throws InterruptedException {
        while (_acciones == 0) {
            System.out.println("waiting");
            wait();
        }
    }
}
