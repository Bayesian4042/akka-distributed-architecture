import actors.BalanceActor;
import actors.CashActor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.routing.RoundRobinPool;
import dao.FakeDB;
import msg.BalanceRequestMessage;
import msg.CashOutRequestMessage;

public class App {
    public static void main(String[] args) {
        FakeDB.balanceSheet.put(1, 100.0);
        FakeDB.balanceSheet.put(2, 200.0);
        FakeDB.balanceSheet.put(3, 300.0);
        FakeDB.balanceSheet.put(4, 400.0);
        FakeDB.balanceSheet.put(5, 500.0);
        FakeDB.balanceSheet.put(6, 600.0);
        FakeDB.balanceSheet.put(7, 700.0);
        FakeDB.balanceSheet.put(8, 800.0);
        FakeDB.balanceSheet.put(9, 900.0);

        ActorSystem system = ActorSystem.create("ATM system");
        ActorRef balanceActor = system.actorOf(BalanceActor.props().withRouter(new RoundRobinPool(3)), "balanceActor");
        ActorRef cashActor = system.actorOf(CashActor.props(), "cashActor");

        BalanceRequestMessage bMsg = new BalanceRequestMessage(1, "Bora");

        for(int i = 0; i<9; i++){
            balanceActor.tell(
                    new BalanceRequestMessage(i + 1, "Customer" + String.valueOf(i)),
                    ActorRef.noSender());
        }
        System.out.println("All 9 messages has been sent to Balance Actor");
    }

    public static void singleActor(){
        FakeDB.balanceSheet.put(1, 100.0);
        FakeDB.balanceSheet.put(2, 200.0);
        FakeDB.balanceSheet.put(3, 300.0);
        ActorSystem system = ActorSystem.create("ATM system");
        ActorRef balanceActor = system.actorOf(BalanceActor.props(), "balanceActor");
        ActorRef cashActor = system.actorOf(CashActor.props(), "cashActor");

        BalanceRequestMessage bMsg = new BalanceRequestMessage(1, "Bora");
        balanceActor.tell(bMsg, ActorRef.noSender());

        CashOutRequestMessage cMsg = new CashOutRequestMessage(1, 100);
        cashActor.tell(cMsg, ActorRef.noSender());

    }
}
