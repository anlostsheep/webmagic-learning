package cn.com.bluemoon.bd.webmagiclearning;

import cn.com.bluemoon.bd.webmagiclearning.spring.event.User;
import cn.com.bluemoon.bd.webmagiclearning.spring.event.UserRegisterPublishService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class WebmagicLearningApplicationTests {

    @Resource
    private UserRegisterPublishService userRegisterPublishService;

    @Test
    void contextLoads() {
    }

    @Test
    void testPublish() {
        User user = User.builder().userName("张三").password("zhangsan").build();
        userRegisterPublishService.userRegister(user);
    }

}
