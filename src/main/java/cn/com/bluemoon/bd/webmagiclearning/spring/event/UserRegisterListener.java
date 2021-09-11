package cn.com.bluemoon.bd.webmagiclearning.spring.event;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.stereotype.Component;

/**
 * <b><code>UserRegisterListener</code></b>
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
public class UserRegisterListener implements SmartApplicationListener {

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
        return 0;
    }

    @SneakyThrows
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        User source = (User) event.getSource();
        log.info("正在将用户对象[{}]写入数据库...", source);
        Thread.sleep(2000);
        log.info("写入完成...");
    }
}
