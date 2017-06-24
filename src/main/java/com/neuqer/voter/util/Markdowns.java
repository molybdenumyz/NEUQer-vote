package com.neuqer.voter.util;

import com.vladsch.flexmark.ast.Node;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.profiles.pegdown.Extensions;
import com.vladsch.flexmark.profiles.pegdown.PegdownOptionsAdapter;

import com.vladsch.flexmark.util.options.DataHolder;
import org.apache.commons.lang.StringUtils;
import org.b3log.latke.util.Strings;



/**
 * Created by yinzhe on 17/6/16.
 */
public final class Markdowns {


    /**
     * Built-in MD engine options.
     */

    private static final DataHolder OPTIONS = PegdownOptionsAdapter.flexmarkOptions(
            Extensions.ALL_OPTIONALS | Extensions.ALL_WITH_OPTIONALS
    );

    /**
     * Built-in MD engine parser.
     */
    private static final com.vladsch.flexmark.parser.Parser PARSER =
            com.vladsch.flexmark.parser.Parser.builder(OPTIONS).build();

    /**
     * Built-in MD engine HTML renderer.
     */
    private static final HtmlRenderer RENDERER = HtmlRenderer.builder(OPTIONS).build();

    /**
     * Private constructor.
     */
    private Markdowns() {
    }

    /**
     * Converts the specified markdown text to HTML.
     *
     * @param markdownText the specified markdown text
     * @return converted HTML, returns {@code null} if the specified markdown text is "" or {@code null}, returns
     * "Markdown error" if exception
     */
    public static String toHTML(final String markdownText) {
        if (Strings.isEmptyOrNull(markdownText)) {
            return "";
        }

        final Node document = PARSER.parse(markdownText);
        String ret = RENDERER.render(document);
        if (!StringUtils.startsWith(ret, "<p>")) {
            ret = "<p>" + ret + "</p>";
        }

        return ret;
    }
}
