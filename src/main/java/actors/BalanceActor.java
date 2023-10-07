package actors;

import akka.actor.AbstractActor;
import akka.actor.Props;
import dao.FakeDB;
import msg.BalanceRequestMessage;

public class BalanceActor extends AbstractActor {
    public static Props props(){
        return Props.create(BalanceActor.class);

    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(BalanceRequestMessage.class, this::balanceEnquiry)
                .matchAny((Object o) -> System.out.println("Unexcepted input!") )
                .build();
    }

    public void balanceEnquiry(BalanceRequestMessage message){
        Integer id = message.getCustomerId();
        Double balance = FakeDB.balanceSheet.get(id);
        System.out.println("Customer with id" + id + "has balance" + balance);
    }
}
