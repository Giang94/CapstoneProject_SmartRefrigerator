/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.Tool;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import java.io.IOException;
import java.util.List;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author Dell
 */
public class HTMLUnitDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        LogFactory.getFactory().setAttribute("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");

        WebClient webClient = new WebClient(BrowserVersion.FIREFOX_17);
        //Connect to page
        HtmlPage page = webClient.getPage("http://monngonmoingay.com/be-thui-xao-sa-te-2/");

        //Parse to List combine links
        //List<HtmlElement> categoryLinks = (List<HtmlElement>) page.getByXPath("//div[@class='detail_descipt col-lg-6 col-md-7 col-sm-12 col-xs-12']/h1[1]");
        List<HtmlElement> content = (List<HtmlElement>) 
                page.getByXPath("//div[@class=\"detail_descipt col-lg-6 col-md-7 col-sm-12 col-xs-12\"]/p[1]");
        for (HtmlElement data:content){
            System.out.println(data.asText());
        }
        //        for (HtmlElement link : categoryLinks) {
//            System.out.println("Html: " + link.asXml());
//            System.out.println("Html: " + link.asText());
//            System.out.println("Html: " + link.getAttribute("href"));
//            System.out.println("=============================");
//        }
//        List<Category> categories = new ArrayList<Category>();
//        String webPage = "https://www.dienmayxanh.com";
//        for (HtmlElement link : categoryLinks){
//            Category cate = new Category(link.asText(), link.getAttribute("href"), webPage);
//            categories.add(cate);
//        }
//        
//        for (Category cate: categories){
//            System.out.println("Name: " + cate.getCategoryName());
//            System.out.println("Link: " + cate.getCategoryLink());
//            System.out.println("=======================");
//        }
    }
}
