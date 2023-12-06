package ait.printer.thread;

public class PrinterThread implements Runnable{
    int number;
    private static int portions = 10;
    Thread nextThread;


    public PrinterThread(int number) {
        this.number = number;
    }

    public void setNextThread(Thread nextThread) {
        this.nextThread = nextThread;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                for (int i = 0; i < portions; i++) {
                    System.out.print(number);
                }
                nextThread.interrupt();
            }
        }
    }
}
