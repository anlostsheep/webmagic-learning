package cn.com.bluemoon.bd.webmagiclearning.event;

/**
 * <b><code>TestEvent</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2021/9/2.
 *
 * @author dengzhen
 * @since webmagic-learning
 */
public class TestEvent extends BusinessEvent {

    public TestEvent(Object source, String eventMessage) {
        super(source);
        this.eventMessage = eventMessage;
    }

    @Override
    public String getMessage() {
        return this.eventMessage;
    }
}
