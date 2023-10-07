package actors;

import akka.actor.AbstractActor;
import akka.actor.Props;

public class InfoActor extends AbstractActor {
    public static Props props(){
        return Props.create(InfoActor.class);

    }

    @Override
    public Receive createReceive() {
        return null;
    }
}
