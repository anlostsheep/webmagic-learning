package cn.com.bluemoon.bd.webmagiclearning.processor;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

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
        
    }
}
