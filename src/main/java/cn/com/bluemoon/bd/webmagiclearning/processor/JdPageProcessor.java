package cn.com.bluemoon.bd.webmagiclearning.processor;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

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

    private final Site site = Site.me()
            .setDomain("www.search.jd.com")
            .setRetryTimes(3)
            .setSleepTime(100);

    private static final String JD_URL = "https://search.jd.com/Search?keyword=iphone12&wq=iphone12";
    private static final String CONCATENATION = "&page=";

    @Override
    public void process(Page page) {
        page.putField("title",
                page.getHtml()
                        .xpath("//div[@id='J_goodsList']/ul/li/div/div[1]/a/@title").all());

        page.putField("money",
                page.getHtml()
                        .xpath("//div[@id='J_goodsList']/ul/li/div/div[3]/strong/i/text()").all());

        String pageSize = page.getHtml()
                .xpath("//span[@class='p-skip']/em/b/text()").get();
        log.info("pageSize:{}", pageSize);

        List<String> pageUrls = new ArrayList<>();
        IntStream.range(2, 6)
                .forEach(i -> pageUrls.add(JdPageProcessor.JD_URL + JdPageProcessor.CONCATENATION + i));
        log.info("pageUrls:{}", JSON.toJSONString(pageUrls));

        page.addTargetRequests(pageUrls);
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {

        Spider.create(new JdPageProcessor())
                .addUrl(JdPageProcessor.JD_URL)
                .addPipeline(new ConsolePipeline())
                .thread(3)
                .run();

    }
}
