import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

public class MainApp {

    private static final Logger logger = LogManager.getLogger(MainApp.class);


    public static void main(String[] args) throws Exception {

        Account account1 = new Account("A1", 10000);
        Account account2 = new Account("A2", 10000);
        Account account3 = new Account("A3", 10000);
        Account account4 = new Account("A4", 10000);

        Random random = new Random();

        int numberOfTransactions = 0;
        int numberOfThreads = 2;
        while (numberOfTransactions < 30 && !Thread.interrupted()) {

            Thread thread1 = new TransactionThread(account1, account2, random.nextInt(1000));
            Thread thread2 = new TransactionThread(account3, account4, random.nextInt(1000));

            thread1.start();
            thread2.start();

            try {
                thread1.join();
                thread2.join();
                numberOfTransactions += numberOfThreads;
            } catch (InterruptedException e) {
                logger.error("Thread interrupted: " + e.getMessage());
            }
        }

        System.out.println(account1.getCurrentMoney());
        System.out.println(account2.getCurrentMoney());
        System.out.println(account3.getCurrentMoney());
        System.out.println(account4.getCurrentMoney());
        System.out.println("sum: " + (account1.getMoney()+account2.getMoney()+account3.getMoney() + account4.getMoney()));
    }
}