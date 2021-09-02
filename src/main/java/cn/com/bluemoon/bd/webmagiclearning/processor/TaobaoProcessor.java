package cn.com.bluemoon.bd.webmagiclearning.processor;

import lombok.extern.slf4j.Slf4j;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <b><code>TaobaoProcessor</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2020/10/23 17:18.
 *
 * @author dengzhen
 * @since webmagic-learning 1.0.0
 */
@Slf4j
public class TaobaoProcessor implements PageProcessor {

    private Site site = Site.me()
            .setRetryTimes(3)
            .setDomain("www.list.tmall.com/");

    @Override
    public void process(Page page) {
        page.putField("title",
                page.getHtml()
                        .xpath("//div[@id='J_ItemList'/div/div/p[2]/a/@title")
                        .all());

        page.putField("price",
                page.getHtml()
                        .xpath("//div[@id='J_ItemList'/div/div/p[1]/em/b/text()")
                        .all());
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        String regex = "https://search\\.jd\\.com/Search\\?keyword=iphone12&wq=iphone12&page=\\d{1,3}&s=\\d{1,3}&click=\\d{1,3}";
        Pattern pattern = Pattern.compile(regex);

        String line = "https://search.jd.com/Search?keyword=iphone12&wq=iphone12&page=11&s=291&click=0";
        Matcher matcher = pattern.matcher(line);
        log.info("if of not :{}", matcher.matches());
    }
}
