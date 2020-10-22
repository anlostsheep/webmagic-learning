package cn.com.bluemoon.bd.webmagiclearning.processor;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.List;

/**
 * <b><code>JdPageProcessor</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2020/10/22 9:23.
 *
 * @author dengzhen
 * @since webmagic-learning 1.0.0
 */
@Slf4j
public class JdPageProcessor implements PageProcessor {

    private Site site = Site.me()
            .setRetryTimes(3)
            .setSleepTime(100);

    @Override
    public void process(Page page) {
        page.putField("title",
                page.getHtml()
                        .xpath("//div[@id='J_goodsList']/ul/li/div/div[1]/a/@title").all());

        page.putField("money",
                page.getHtml()
                        .xpath("//div[@id='J_goodsList']/ul/li/div/div[3]/strong/i/text()").all());

        List<String> urls = page.getHtml()
                .links()
                .regex("https://search\\.jd\\.com/Search\\?keyword=iphone12&wq=iphone12&page=\\d&s=[0-9][0-9]*&click=\\d")
                .all();
        log.info("urls:{}", JSON.toJSONString(urls));

        page.addTargetRequests(urls);
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {

        Spider.create(new JdPageProcessor())
                .addUrl("https://search.jd.com/Search?keyword=iphone12&wq=iphone12")
                .addPipeline(new ConsolePipeline())
                .thread(3)
                .run();
    }
}
