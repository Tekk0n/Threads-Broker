package app;

public class Broker {
    private int _acciones;

    public Broker(int acciones) {
        _acciones = acciones;
    }

    public synchronized boolean buy(int compra, Client client) {
        boolean ventarealizada;
        System.out.println("There's " + _acciones + " available shares.");

        if (_acciones - compra >= 0) {
            System.out.println(client.toString() + " is about to buy " + compra + " shares.");
            _acciones = _acciones - compra;
            System.out.println("Now there's " + _acciones + " available shares.");
            ventarealizada = true;
        } else {
            System.out.println(client.toString() + " could not buy " + compra + " shares.");
            ventarealizada = false;
        }
        return ventarealizada;
    }

//        public synchronized void waitUntilNoSharesAvailable() throws InterruptedException {
//        while (_acciones > 0) {
//            System.out.println("waiting");
//            wait();
//        }
//  }
}
