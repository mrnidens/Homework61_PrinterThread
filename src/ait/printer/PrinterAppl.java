package ait.printer;

import ait.printer.thread.PrinterThread;

public class PrinterAppl {
    public static void main(String[] args) {

        PrinterThread[] printers = new PrinterThread[4];
        for (int i = 0; i < printers.length; i++) {
            printers[i] = new PrinterThread(i);
        }

        Thread[] threads = new Thread[printers.length];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(printers[i]);
        }

        for (int i = 0; i < threads.length; i++) {

            if (i == threads.length - 1) {
                printers[i].setNextThread(threads[0]);
                threads[i].start();

            } else {
                printers[i].setNextThread(threads[i + 1]);
                threads[i].start();

            }
        }


    }
}
