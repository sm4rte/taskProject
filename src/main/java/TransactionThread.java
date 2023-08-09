import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class TransactionThread extends Thread{
    private Account sourceAccount;
    private Account targetAccount;
    private int amount;

    Logger logger = LogManager.getLogger(TransactionThread.class);

    public TransactionThread(Account sourceAccount, Account targetAccount, int amount) throws Exception {
        this.sourceAccount = sourceAccount;
        this.targetAccount = targetAccount;
        if (amount>0){
            this.amount = amount;
        }
        else {
            throw new Exception("incorrect amount of funds");
        }
    }

    @Override
    public void run() {
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(1000,2000));
            Transaction transaction = new Transaction(sourceAccount,targetAccount,amount);
            transaction.execute();
        }
        catch (InterruptedException e){
            logger.error("Thread interrupted " + e.getMessage());
        }
    }
}
