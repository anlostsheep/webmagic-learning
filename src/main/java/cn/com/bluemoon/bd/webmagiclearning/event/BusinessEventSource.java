package cn.com.bluemoon.bd.webmagiclearning.event;

import org.assertj.core.util.Lists;

import java.util.List;

/**
 * <b><code>EventSource</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2021/9/2.
 *
 * @author dengzhen
 * @since webmagic-learning
 */
public class BusinessEventSource<T extends BusinessEvent, V extends BusinessEventListener<T>> {

    private final List<BusinessEventListener<T>> listeners = Lists.newArrayList();

    public void register(V eventListener) {
        listeners.add(eventListener);
    }

    public void publishEvent(T t) {
        listeners.forEach(l -> l.handleBusinessEvent(t));
    }
}
