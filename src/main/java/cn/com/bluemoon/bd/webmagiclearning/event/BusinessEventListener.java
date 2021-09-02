package cn.com.bluemoon.bd.webmagiclearning.event;

import java.util.EventListener;

/**
 * <b><code>BusinessEventListener</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2021/9/2.
 *
 * @author dengzhen
 * @since webmagic-learning
 */
public interface BusinessEventListener<T extends BusinessEvent> extends EventListener {

    /**
     * 处理业务事件
     *
     * @param t 业务事件
     */
    void handleBusinessEvent(T t);
}
