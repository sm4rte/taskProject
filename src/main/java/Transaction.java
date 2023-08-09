import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Transaction {
    private Account sourceAccount;
    private Account targetAccount;
    private int amount;

    Logger logger = LogManager.getLogger(Transaction.class);

    public Transaction(Account sourceAccount, Account targetAccount, int amount){
        this.sourceAccount = sourceAccount;
        this.targetAccount = targetAccount;
        if (amount>0){
            this.amount = amount;
        }
    }
    public void execute(){

        logger.info("Transaction initiated: Transfer " + amount + "$ from Account " + sourceAccount.getID() + " to Account " +
                targetAccount.getID());
        sourceAccount.transferTo(targetAccount,amount);
    }
}
