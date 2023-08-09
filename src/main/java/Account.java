import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Account {
    private static final Logger logger = LogManager.getLogger(Account.class);
    private String ID;
    private int money;

    public Account(String ID, int money) {
        this.ID = ID;
        this.money = money;

        logger.info("Created account: ID= " + ID +", Money = " + money);
    }

    public String getID() {
        return ID;
    }

    public int getMoney() {
        return money;
    }

    public synchronized void transferTo(Account targetAccount, int amount){
        if (this.money>=amount && amount>0) {
            this.money -= amount;
            targetAccount.money += amount;
            //logger.info("Transferred " + amount + "$ from Account " + this.ID + " to Account " + targetAccount.getID());
        }
        else {
            //logger.warn("Insufficient funds in Account " + this.ID + " for transferring " + amount + "$");
        }
    }
    public String getCurrentMoney(){
        return "In the account " + this.ID + " remained " + this.getMoney()+"$";
    }
}
