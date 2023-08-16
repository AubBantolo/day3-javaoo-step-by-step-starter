package ooss;

import java.util.ArrayList;
import java.util.List;

public abstract class EventManager {
    private List<EventListener> listenerList = new ArrayList<>();

    public List<EventListener> getListenerList() {
        return listenerList;
    }

    public void subscribe(EventListener eventListener) {
        this.listenerList.add(eventListener);
    }
    public abstract void notifyLeaderUpdate(Klass klass, Student student);
}
