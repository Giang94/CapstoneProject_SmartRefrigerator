/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.Servlet;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.logging.LogFactory;
import sample.pojo.content;

/**
 *
 * @author Dell
 */
public class ScrappingServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String[] xpaths = request.getParameterValues("txtXPath");
            HttpSession session = request.getSession();
            String url = (String) session.getAttribute("URL");
            System.out.println(url);
            //System.out.println(sample.Tool.HtmlUnitParse.HtmlUnitParser());


            LogFactory.getFactory().setAttribute("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");

            WebClient webClient = new WebClient(BrowserVersion.FIREFOX_17);
            webClient.getOptions().setThrowExceptionOnScriptError(false);
            webClient.getOptions().setCssEnabled(false);//if you don't need css
            webClient.getOptions().setJavaScriptEnabled(false);//if you don't need js


            //Connect to page
            //HtmlPage page = webClient.getPage(url);

            String realPath = this.getServletContext().getRealPath("/");
            String htmlFilePath = realPath + "/tmp.html";
            File file = new File(htmlFilePath);
            HtmlPage page = webClient.getPage(file.toURL());

            page.getWebClient().addRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
            //Parse to List combine links
            //List<HtmlElement> categoryLinks = (List<HtmlElement>) page.getByXPath("//div[@class='detail_descipt col-lg-6 col-md-7 col-sm-12 col-xs-12']/h1[1]");
            List<String> contents = new ArrayList<String>();
            List<content> CONTENTS = new ArrayList<content>();
            List<HtmlElement> tmp = null;
            int count = 0, countTam = 0;
            content object;
            for (String xpath : xpaths) {
                count++;
                System.out.println(xpath + "thiendeptrai");
                //contents[i] = (List<HtmlElement>) page.getByXPath(xpath);
                tmp = (List<HtmlElement>) page.getByXPath(xpath);
                System.out.println(tmp.size());
                //tmp = (List<HtmlElement>) page.getByXPath("//div[@class='detail_ingredients col-lg-3 col-md-3 col-sm-12 col-xs-12']/ul[1]/li/span[1]");
                String tmpString;
                
                for (HtmlElement data : tmp) {
                    System.out.println(countTam);
                    countTam++;
                    if (count != 3) {
                        object = new content();
                        tmpString = data.asText();
                        switch (count) {
                            case 1:
                                object.setKey("NAME");
                                break;
                            case 2:
                                object.setKey("INTRODUCTION");
                                break;
                            case 4:
                                object.setKey("MATERIAL");
                                break;
                            case 5:
                                object.setKey("STEP");
                                break;
                        }
                        object.setValue(tmpString);
                        CONTENTS.add(object);
                        System.out.println(object.getValue());
                        //contents.add(tmpString);
                    } else {
                        tmpString = data.getAttribute("src");
                        object = new content();
                        object.setKey("IMAGE");
                        object.setValue(tmpString);
                        CONTENTS.add(object);
                        System.out.println(object.getValue());
                        //contents.add(tmpString);
                    }
                }
            }

            for (content ct : CONTENTS) {
                System.out.println(ct.getValue());
            }
            request.setAttribute("LIST", CONTENTS);
            RequestDispatcher rd = request.getRequestDispatcher("parseSuccess.jsp");
            rd.forward(request, response);
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
