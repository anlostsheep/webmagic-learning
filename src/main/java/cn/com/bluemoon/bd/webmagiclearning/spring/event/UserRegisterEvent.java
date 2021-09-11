package cn.com.bluemoon.bd.webmagiclearning.spring.event;

import org.springframework.context.ApplicationEvent;

/**
 * <b><code>UserRegisterEvent</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2021/9/11.
 *
 * @author dengzhen
 * @since webmagic-learning
 */
public class UserRegisterEvent extends ApplicationEvent {
    
    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public UserRegisterEvent(Object source) {
        super(source);
    }
}
