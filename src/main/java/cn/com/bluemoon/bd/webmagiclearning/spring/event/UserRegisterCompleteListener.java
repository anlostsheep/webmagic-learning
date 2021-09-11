package cn.com.bluemoon.bd.webmagiclearning.spring.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.stereotype.Component;

/**
 * <b><code>UserRegisterCompleteListener</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2021/9/11.
 *
 * @author dengzhen
 * @since webmagic-learning
 */
@Slf4j
@Component
public class UserRegisterCompleteListener implements SmartApplicationListener {
    

    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {
        return eventType == UserRegisterEvent.class;
    }

    @Override
    public boolean supportsSourceType(Class<?> sourceType) {
        return sourceType == User.class;
    }

    @Override
    public int getOrder() {
        return 1;
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        User source = (User) event.getSource();
        log.info("用户[{}]创建成功, 已通知", source.getUserName());
    }
}
