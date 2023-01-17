package org.example;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.util.Date;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws IOException {
//        Document document = Jsoup.connect("https://www.baidu.com").get();
//        System.out.println(getTextFromHTML(String.valueOf(document.getElementsByTag("title"))));


        Document document = Jsoup.connect("http://rsks.hrss.tj.gov.cn/ks/file.do?method=read&path=/resource/portalWeb/1673948627643.html").get();

        Elements body = document.body().getElementsByTag("tbody");
        Element list = body.get(2);
        Date start = new Date();
        for (String selectId : input()) {
            for (Element one : list.getElementsByTag("tr")) {
                if (selectId.equals(one.getElementsByTag("td").get(3).text())) {
                    output(one);
                }
            }
        }
        Date end = new Date();
        System.out.println(end.getTime() - start.getTime());
    }

    public static String[] input() {
        return new String[]{"1010101", "1040201", "1130301", "1140203", "1180101", "1240102", "1250401", "2020801", "2021902", "2030301", "2030601", "2031401", "2031601", "2032201", "2032202", "2032301", "2032402", "2032603", "2032701", "2033301", "2033302", "2033801", "2034403", "2034601", "2035001", "2035002", "2042501", "2054201", "2054601", "2061401", "2071801", "2080101", "2080401", "2081401", "2081705", "2082202", "2082401", "2082702", "2083601", "2090301", "2090401", "2092201", "2092301", "2093101", "2094001", "2094401", "2102001", "2102101", "2102502", "2103703", "2110101", "2111004", "2111103", "2111204", "2111302"};
    }

    public static void output(Element one) {
        Elements info = one.getElementsByTag("td");
        String company = String.format("%-30s", info.get(0).text());
        String department = String.format("%-30s", info.get(1).text());
        String jobId = String.format("%-16s", info.get(3).text());
        String num = String.format("%-6s", info.get(4).text());
        String curr = String.format("%-8s", info.get(5).text());
        System.out.println(jobId + num + curr + company + department);
    }

    public static String escapeHtml(String htmlContent) {
        if (StringUtils.isBlank(htmlContent)) {
            return htmlContent;
        }
        return Jsoup.parse(htmlContent).text();
    }


//    public static String getTextFromHTML(String htmlStr) {
//        Document doc = Jsoup.parse(htmlStr);
//        String text = doc.text();
//        //删除多余的空白
//        StringBuilder builder = new StringBuilder(text);
//        int index = 0;
//        while(builder.length()>index){
//            char tmp = builder.charAt(index);
//            if(Character.isSpaceChar(tmp) || Character.isWhitespace(tmp)){
//                builder.setCharAt(index, ' ');
//            }
//            index++;
//        }
//        text = builder.toString().replaceAll(" +", " ").trim();
//        return text;
//    }

    //历史1.16 http://rsks.hrss.tj.gov.cn/ks/file.do?method=read&path=/resource/portalWeb/1673862340319.html
}
