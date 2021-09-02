package cn.com.bluemoon.bd.webmagiclearning.event;

import java.util.EventObject;

/**
 * <b><code>BusinessEvent</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2021/9/2.
 *
 * @author dengzhen
 * @since webmagic-learning
 */
public abstract class BusinessEvent extends EventObject {
    
    protected String eventMessage;
    
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    protected BusinessEvent(Object source) {
        super(source);
    }

    /**
     * 事件信息
     * @return 事件信息 
     */
    public abstract String getMessage();
}
