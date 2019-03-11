package com.alpha.util;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.List;

public class Table extends TagSupport {
    private String items;
    private String var;
    private String heads;
    private List itemList;
    private List headList;
    private int index;

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public String getVar() {
        return var;
    }

    public void setVar(String var) {
        this.var = var;
    }

    public String getHeads() {
        return heads;
    }

    public void setHeads(String heads) {
        this.heads = heads;
    }

    @Override
    public int doStartTag() throws JspException {
        index = 0;
        itemList = (List) pageContext.getAttribute(items, PageContext.REQUEST_SCOPE);
        if (itemList!=null) {
            headList = (List) pageContext.getAttribute(heads, PageContext.REQUEST_SCOPE);
            try {
                JspWriter writer = pageContext.getOut();
                writer.write("<table>\n" + "<tr>");
                StringBuilder headStr = new StringBuilder();
                headList.forEach(head -> {
                    headStr.append("<th>" + head + "</th>\n");
                });
                writer.write(headStr.toString());
                writer.write("</tr>");
            } catch (IOException e) {
                e.printStackTrace();

            }
            pageContext.setAttribute(var, itemList.get(0));

            return EVAL_BODY_INCLUDE;
        }
        return SKIP_BODY;
    }

    @Override
    public int doEndTag() throws JspException {
        if (itemList!=null) {
            if (index == itemList.size() - 1) {
                try {
                    JspWriter writer = pageContext.getOut();
                    writer.write("</table>");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return super.doEndTag();
    }

    @Override
    public int doAfterBody() throws JspException {
        index++;
        if (index < itemList.size()) {
            pageContext.setAttribute(var, itemList.get(index));
            return EVAL_BODY_AGAIN;
        }
        return SKIP_BODY;
    }
}
