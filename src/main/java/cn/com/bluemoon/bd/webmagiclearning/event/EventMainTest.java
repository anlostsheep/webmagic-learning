package cn.com.bluemoon.bd.webmagiclearning.event;

/**
 * <b><code>EventMainTest</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2021/9/3.
 *
 * @author dengzhen
 * @since webmagic-learning
 */
public class EventMainTest {

    public static void main(String[] args) {
        BusinessEventSource<TestEvent, BusinessEventListener<TestEvent>> eventSource = new BusinessEventSource<>();
        BusinessEventListener<TestEvent> businessEventListener = new TestEventListener();
        eventSource.register(businessEventListener);
        eventSource.publishEvent(new TestEvent(eventSource, "测试事件发布, 测试信息:test"));
    }
}
