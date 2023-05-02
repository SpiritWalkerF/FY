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
        //部分岗位指定顺序筛选
        for (String selectId : input()) {
            for (Element one : list.getElementsByTag("tr")) {
                if (selectId.equals(one.getElementsByTag("td").get(3).text())) {
                    output(one);
                    break;
                }
            }
        }
        //全部岗位，按报名人数筛选
//        for (Element one : list.getElementsByTag("tr")) {
////            if (Integer.parseInt(one.getElementsByTag("td").get(5).text()) <= 30) {
////                output(one);
//            System.out.println(String.format("%-8s", one.getElementsByTag("td").get(3).text()));
////            }
//        }


        Date end = new Date();
        System.out.println(end.getTime() - start.getTime());
    }

    public static String[] input() {
//        return new String[]{"1010101", "1040201", "1130301", "1140203", "1180101", "1240102", "1250401", "2020801", "2021902", "2030301", "2030601", "2031401", "2031601", "2032201", "2032202", "2032301", "2032402", "2032603", "2032701", "2033301", "2033302", "2033801", "2034403", "2034601", "2035001", "2035002", "2042501", "2054201", "2054601", "2061401", "2071801", "2080101", "2080401", "2081401", "2081705", "2082202", "2082401", "2082702", "2083601", "2090301", "2090401", "2092201", "2092301", "2093101", "2094001", "2094401", "2102001", "2102101", "2102502", "2103703", "2110101", "2111004", "2111103", "2111204", "2111302"};
        return new String[]{"1010101", "1020101", "1030101", "1040101", "1040201", "1040301", "1040401", "1040501", "1040601", "1040701", "1040801", "1040901", "1050101", "1060101", "1060102", "1060103", "1060104", "1060105", "1060106", "1060107", "1060108", "1060201", "1060202", "1060203", "1060204", "1060205", "1060206", "1060301", "1060302", "1060303", "1060304", "1060305", "1060401", "1060402", "1060403", "1060404", "1060405", "1060501", "1060502", "1060503", "1060504", "1060601", "1060602", "1060603", "1060604", "1060701", "1060702", "1060703", "1060704", "1060705", "1060801", "1060802", "1060803", "1060804", "1060901", "1060902", "1060903", "1061001", "1061002", "1061003", "1061004", "1061101", "1061102", "1061103", "1061201", "1061202", "1061203", "1061301", "1061302", "1061401", "1061402", "1061501", "1061502", "1061503", "1061601", "1061701", "1061801", "1061802", "1070101", "1070201", "1070301", "1070401", "1070501", "1070601", "1080101", "1080102", "1080103", "1080201", "1080202", "1080203", "1080301", "1080302", "1080303", "1080401", "1080402", "1080501", "1080502", "1080503", "1080601", "1080701", "1080801", "1080802", "1080803", "1080901", "1081001", "1081101", "1090101", "1090102", "1090103", "1100101", "1100102", "1100201", "1100301", "1100401", "1100501", "1100601", "1110101", "1110201", "1110301", "1110401", "1110501", "1110502", "1110601", "1110701", "1110702", "1110801", "1110901", "1110902", "1111001", "1111002", "1111101", "1111102", "1111201", "1120101", "1120201", "1120301", "1120401", "1120501", "1130101", "1130201", "1130301", "1130401", "1140101", "1140102", "1140103", "1140201", "1140202", "1140203", "1140204", "1150101", "1150102", "1160101", "1160201", "1160301", "1160401", "1160501", "1160601", "1160701", "1160801", "1160901", "1160902", "1160903", "1160904", "1160905", "1161001", "1161002", "1161003", "1170101", "1180101", "1180201", "1180202", "1180203", "1190101", "1200101", "1200201", "1210101", "1220101", "1220201", "1220301", "1220401", "1220402", "1220501", "1220601", "1220602", "1230101", "1230201", "1230301", "1240101", "1240102", "1240103", "1240201", "1240301", "1240401", "1240501", "1240601", "1240701", "1240801", "1240901", "1241001", "1250101", "1250201", "1250301", "1250401", "1260101", "1260102", "1260201", "1270101", "1270102", "1270103", "1270104", "1270201", "1280101", "1280102", "1280103", "1290101", "1290102", "1300101", "1310101", "1310201", "1310202", "1310301", "1310302", "1310303", "1310401", "1310501", "1310502", "1310601", "1310602", "1310603", "1310604", "1310701", "1310801", "1310901", "1310902", "1310903", "1310904", "1310905", "1311001", "1311002", "1311003", "1311101", "1311102", "1311201", "1311202", "1311301", "1311302", "1311303", "1311401", "1311402", "1311403", "1311501", "1311502", "1311601", "1311602", "1311701", "1311702", "1311801", "1311802", "1311803", "1311901", "1312001", "1312002", "1320101", "1320201", "1330101", "2010101", "2010102", "2010201", "2010301", "2010302", "2010401", "2010501", "2010502", "2010601", "2010701", "2010702", "2010801", "2010901", "2010902", "2010903", "2011001", "2011101", "2011102", "2011103", "2011104", "2011201", "2011202", "2011301", "2011401", "2011501", "2011601", "2011701", "2011801", "2011802", "2011901", "2011902", "2012001", "2012002", "2012003", "2012101", "2012102", "2012201", "2012202", "2012301", "2012401", "2012501", "2012601", "2012602", "2012603", "2012604", "2012605", "2012701", "2012801", "2012901", "2013001", "2013101", "2013201", "2013202", "2013301", "2013401", "2013501", "2013502", "2013503", "2013504", "2013601", "2013701", "2013801", "2013901", "2013902", "2014001", "2014101", "2014102", "2014201", "2014301", "2014302", "2014401", "2014402", "2014403", "2014404", "2014405", "2014406", "2014407", "2014408", "2014409", "2014601", "2014701", "2014801", "2015001", "2015002", "2015101", "2015102", "2015103", "2015201", "2015301", "2015401", "2015501", "2015601", "2015602", "2015603", "2015701", "2015801", "2015802", "2015901", "2016101", "2016102", "2016201", "2016301", "2016302", "2016303", "2016401", "2016501", "2016502", "2016601", "2016602", "2016701", "2016901", "2016902", "2016903", "2017001", "2017002", "2017101", "2017102", "2017103", "2017104", "2017105", "2017201", "2017301", "2017401", "2017402", "2017403", "2017501", "2017601", "2017602", "2017701", "2017801", "2017901", "2018001", "2018201", "2018202", "2020101", "2020102", "2020201", "2020202", "2020203", "2020301", "2020401", "2020402", "2020501", "2020502", "2020503", "2020602", "2020701", "2020702", "2020703", "2020704", "2020801", "2020803", "2020901", "2020902", "2021001", "2021101", "2021102", "2021301", "2021302", "2021303", "2021304", "2021305", "2021306", "2021307", "2021401", "2021402", "2021403", "2021501", "2021601", "2021701", "2021801", "2021802", "2021901", "2021902", "2022001", "2022002", "2022003", "2022101", "2022201", "2022202", "2022203", "2022204", "2022205", "2022301", "2022401", "2022402", "2022403", "2022404", "2022405", "2022501", "2022502", "2030101", "2030201", "2030301", "2030401", "2030501", "2030601", "2030602", "2030603", "2030701", "2030801", "2030802", "2030803", "2030804", "2030805", "2030901", "2030902", "2031001", "2031002", "2031003", "2031101", "2031102", "2031103", "2031104", "2031201", "2031202", "2031301", "2031302", "2031401", "2031402", "2031403", "2031501", "2031502", "2031601", "2031701", "2031801", "2031901", "2032001", "2032002", "2032101", "2032201", "2032202", "2032301", "2032401", "2032402", "2032501", "2032601", "2032602", "2032603", "2032701", "2032801", "2032901", "2033001", "2033101", "2033201", "2033301", "2033302", "2033401", "2033501", "2033601", "2033801", "2033901", "2033902", "2034002", "2034003", "2034101", "2034201", "2034202", "2034301", "2034302", "2034403", "2034501", "2034601", "2034602", "2034701", "2034702", "2034801", "2034802", "2034803", "2034901", "2035001", "2035002", "2035101", "2035102", "2040101", "2040201", "2040301", "2040401", "2040402", "2040403", "2040404", "2040501", "2040601", "2040701", "2040801", "2040901", "2041001", "2041101", "2041201", "2041301", "2041401", "2041501", "2041601", "2041701", "2041801", "2041802", "2041901", "2042001", "2042101", "2042102", "2042103", "2042104", "2042201", "2042301", "2042401", "2042501", "2042601", "2042801", "2042901", "2043101", "2043201", "2043301", "2043401", "2043501", "2043601", "2043602", "2043802", "2044001", "2044101", "2044201", "2044401", "2044501", "2044601", "2044701", "2044702", "2044801", "2044802", "2044901", "2045001", "2050101", "2050201", "2050301", "2050401", "2050501", "2050601", "2050701", "2050801", "2050901", "2050902", "2050903", "2050904", "2051001", "2051101", "2051201", "2051301", "2051401", "2051501", "2051601", "2051701", "2051702", "2051801", "2051802", "2051803", "2051804", "2051901", "2052001", "2052002", "2052101", "2052201", "2052301", "2052401", "2052402", "2052501", "2052601", "2052701", "2052801", "2052901", "2052902", "2053001", "2053101", "2053201", "2053301", "2053302", "2053401", "2053501", "2053502", "2053601", "2053701", "2053801", "2053901", "2054001", "2054101", "2054201", "2054301", "2054401", "2054501", "2054601", "2054701", "2060101", "2060102", "2060201", "2060301", "2060401", "2060501", "2060601", "2060701", "2060702", "2060703", "2060704", "2060705", "2060801", "2060901", "2061001", "2061101", "2061201", "2061301", "2061401", "2061402", "2061501", "2061601", "2061701", "2061702", "2061703", "2061704", "2061801", "2061901", "2061902", "2061903", "2062001", "2062101", "2062201", "2062301", "2062401", "2062501", "2062601", "2062701", "2062801", "2062802", "2062901", "2062902", "2063001", "2063101", "2063201", "2063202", "2063301", "2063302", "2063401", "2063501", "2063601", "2063702", "2063801", "2063901", "2064001", "2064002", "2064101", "2064201", "2064301", "2070101", "2070201", "2070301", "2070401", "2070501", "2070502", "2070601", "2070602", "2070701", "2070702", "2070801", "2070802", "2070901", "2071001", "2071101", "2071201", "2071202", "2071203", "2071301", "2071401", "2071501", "2071601", "2071602", "2071603", "2071701", "2071801", "2071901", "2071902", "2072001", "2072002", "2080101", "2080301", "2080401", "2080501", "2080601", "2080602", "2080603", "2080604", "2080605", "2080701", "2080801", "2080901", "2081001", "2081101", "2081201", "2081202", "2081203", "2081204", "2081301", "2081401", "2081501", "2081502", "2081601", "2081701", "2081702", "2081703", "2081704", "2081705", "2081706", "2081801", "2081901", "2082001", "2082101", "2082102", "2082201", "2082202", "2082301", "2082401", "2082402", "2082501", "2082502", "2082503", "2082601", "2082701", "2082702", "2082703", "2082801", "2082802", "2082803", "2083001", "2083101", "2083201", "2083202", "2083203", "2083401", "2083402", "2083501", "2083502", "2083503", "2083601", "2083701", "2083801", "2083901", "2090101", "2090201", "2090301", "2090401", "2090501", "2090502", "2090601", "2090702", "2090703", "2090801", "2090802", "2090803", "2090901", "2091001", "2091002", "2091101", "2091201", "2091301", "2091401", "2091501", "2091502", "2091601", "2091602", "2091603", "2091701", "2091702", "2091801", "2091901", "2092001", "2092002", "2092101", "2092102", "2092201", "2092202", "2092301", "2092401", "2092402", "2092403", "2092404", "2092501", "2092601", "2092701", "2092801", "2092901", "2092902", "2093001", "2093002", "2093101", "2093102", "2093201", "2093301", "2093302", "2093303", "2093304", "2093305", "2093401", "2093402", "2093501", "2093502", "2093601", "2093602", "2093701", "2093702", "2093801", "2093802", "2093901", "2093902", "2094001", "2094002", "2094101", "2094201", "2094202", "2094203", "2094204", "2094205", "2094206", "2094301", "2094401", "2094501", "2094502", "2094601", "2094602", "2094603", "2094701", "2100101", "2100201", "2100301", "2100401", "2100501", "2100601", "2100701", "2100801", "2100901", "2101001", "2101002", "2101003", "2101101", "2101201", "2101301", "2101401", "2101402", "2101501", "2101601", "2101602", "2101701", "2101801", "2101802", "2101901", "2101902", "2102001", "2102101", "2102201", "2102202", "2102203", "2102204", "2102301", "2102401", "2102501", "2102502", "2102503", "2102601", "2102701", "2103001", "2103003", "2103004", "2103101", "2103201", "2103203", "2103403", "2103501", "2103502", "2103503", "2103602", "2103701", "2103703", "2103704", "2103801", "2103802", "2110101", "2110201", "2110301", "2110401", "2110501", "2110601", "2110701", "2110801", "2110802", "2110803", "2110901", "2110902", "2110903", "2110904", "2111001", "2111002", "2111003", "2111004", "2111101", "2111102", "2111103", "2111104", "2111105", "2111106", "2111107", "2111201", "2111202", "2111203", "2111204", "2111205", "2111206", "2111207", "2111301", "2111302", "2111401", "2120101", "2120201", "2120301", "2120401", "2120501", "2120601", "2120701", "2120801", "2120901", "2120902", "2121001", "2121002", "2121003", "2121101", "2121201", "2121301", "2121401", "2121501", "2121601", "2121701", "2121702", "2121801", "2121802", "2122001", "2122101", "2122102", "2122201", "2122202", "2122301", "2122401", "2122501", "2122801", "2122901", "2123201", "2123202", "2123301", "2123302", "2123401", "2123801", "2123802", "2123901", "2124101", "2124301", "2124401", "2124501", "2124601", "2124701", "2124801", "2124802", "2124901", "2125001", "2125101", "2125301", "2125302", "2125401", "2125402", "2125601", "2125602", "2125701", "2125801", "2125802", "2125901", "2125902", "2126001", "2126002", "2126101", "2126102", "2126201", "2126202", "2126301", "2126401", "2126501", "2126601", "2126701", "2130101", "2130102", "2130201", "2130302", "2130401", "2130402", "2130501", "2130601", "2130702", "2130802", "2130901", "2130902", "2131002", "2131003", "2131101", "2131201", "2131202", "2131203", "2131301", "2131401", "2131402", "2131403", "2131501", "2131601", "2131701", "2131801", "2131901", "2131902", "2132001", "2132101", "2132701", "2132802", "2132901", "2132902", "2133001", "2133002", "2133003", "2140101", "2140201", "2140301", "2140302", "2140303", "2140304", "2140401", "2140402", "2140501", "2140601", "2140701", "2140801", "2140802", "2140901", "2140902", "2140903", "2140904", "2140905", "2141001", "2141002", "2141101", "2141102", "2141201", "2141202", "2141301", "2141401", "2141501", "2141502", "2141601", "2141602", "2141604", "2141605", "2141702", "2141703", "2141801", "2141802", "2141803", "2141901", "2141902", "2142001", "2142101", "2142201", "2142301", "2142401", "2142402", "2142501", "2142601", "2142602", "2142701", "2142801", "2142802", "2142902", "2143001", "2143101", "2143201", "2143302", "2143401", "2143402", "2143403", "2143501", "2143601", "2143602", "2143701", "2143801", "2143802", "2143901", "2143902", "2143903", "2143904", "2143905", "2143906", "2143907", "2143908", "2150101", "2150102", "2150103", "2150201", "2150301", "2150302", "2150401", "2150501", "2150502", "2160101", "2160201", "2160203", "2160301", "2160401", "2160402", "2160404", "2160501", "2160503", "2160601", "2160701", "2160702", "2160703", "2160801", "2160901", "2161001", "2161101", "2161201", "2161202", "2161203", "2161301", "2161401", "2161501", "2161601", "2161701", "2161801", "2161802", "2161901", "2161902", "2162101", "2162201", "2162301", "2162501", "2162602", "2162701", "2162801", "2162901", "2163001", "2163002", "2163201", "2163202", "2163501", "2163701", "2163802", "2163901", "2163902", "2164101", "2164401", "2164501", "2164502"};
    }

    public static void output(Element one) {
        Elements info = one.getElementsByTag("td");
        String company = String.format("%-30s", info.get(0).text());
        String department = String.format("%-30s", info.get(1).text());
        String jobId = String.format("%-16s", info.get(3).text());
        String num = String.format("%-6s", info.get(4).text());
        String curr = String.format("%-8s", info.get(5).text());
        System.out.println(curr) ; //(jobId + num + curr + company + department);
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
