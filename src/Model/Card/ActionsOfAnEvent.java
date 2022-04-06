package Model.Card;

import Model.Card.Event.Event;
import java.util.ArrayList;

//it is like a struct
public class ActionsOfAnEvent {

    private ArrayList<Action> actions=new ArrayList<>();
    private Event event;

    public ActionsOfAnEvent(Event inTheSameRow, ArrayList<Action> actions) {
        this.event=inTheSameRow;
        this.actions=actions;
    }

    public ArrayList<Action> getActions() {
        return actions;
    }

    public Event getEvent() {
        return event;
    }
}
