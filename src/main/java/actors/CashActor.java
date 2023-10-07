package actors;

import akka.actor.AbstractActor;
import akka.actor.Props;
import dao.FakeDB;
import msg.CashOutRequestMessage;

public class CashActor extends AbstractActor {
    public static Props props(){
        return Props.create(BalanceActor.class);

    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(CashOutRequestMessage.class, this::cashOut)
                .matchAny((Object o) -> System.out.println("Unexcepted input!") )
                .build();
    }

    private void cashOut(CashOutRequestMessage msg) {
        int customerId=msg.getCustomerId();
        double balance= FakeDB.balanceSheet.get(customerId);
        if(balance<msg.getAmount()){
            System.out.println("Customer Id:"+String.valueOf(msg.getCustomerId()));
            System.out.println("insufficient balance");
        }
        else{
            double newBalance=balance-msg.getAmount();
            FakeDB.balanceSheet.replace(customerId,newBalance);
            System.out.println("Money out :"+String.valueOf(msg.getAmount()));
        }
    }

}
