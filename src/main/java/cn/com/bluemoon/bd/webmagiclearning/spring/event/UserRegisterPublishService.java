package cn.com.bluemoon.bd.webmagiclearning.spring.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

/**
 * <b><code>UserRegisterPublishService</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2021/9/11.
 *
 * @author dengzhen
 * @since webmagic-learning
 */
@Service
public class UserRegisterPublishService implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher applicationEventPublisher;
    
    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void userRegister(User user) {
        UserRegisterEvent userRegisterEvent = new UserRegisterEvent(user);
        applicationEventPublisher.publishEvent(userRegisterEvent);
    }
}
