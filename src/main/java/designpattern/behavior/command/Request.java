package designpattern.behavior.command;

/**
 * @description:
 * @create: 2020/5/31
 * @author: altenchen
 */
public class Request {
    private Event event;

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
