package com.neuqer.voter;

import com.neuqer.voter.util.Markdowns;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by yinzhe on 17/6/16.
 */

public class MarkdownTest {
    @Test
    public void toHtml(){
        String markdownText = "";
        String html = Markdowns.toHTML(markdownText);

        Assert.assertEquals(html, "");

        markdownText = "![](https://waffle.io/b3log/solo/metrics/throughput)";
        html = Markdowns.toHTML(markdownText);

        System.out.println(html);
    }
}
