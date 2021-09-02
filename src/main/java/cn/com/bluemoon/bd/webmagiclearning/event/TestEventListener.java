package cn.com.bluemoon.bd.webmagiclearning.event;

import lombok.extern.slf4j.Slf4j;

/**
 * <b><code>TestEventListener</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2021/9/2.
 *
 * @author dengzhen
 * @since webmagic-learning
 */
@Slf4j
public class TestEventListener implements BusinessEventListener<TestEvent> {

    @Override
    public void handleBusinessEvent(TestEvent testEvent) {
        log.info("testEvent handle message:{}", testEvent.getMessage());
    }
}
