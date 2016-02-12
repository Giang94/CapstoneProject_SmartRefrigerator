/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.Servlet;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebRequest;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpRequest;
import sample.Tool.HtmlUnitParse;

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
            //System.out.println(sample.Tool.HtmlUnitParse.HtmlUnitParser());


            LogFactory.getFactory().setAttribute("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");

            WebClient webClient = new WebClient(BrowserVersion.FIREFOX_17);
            //webClient.addRequestHeader("Accept-Charset", "utf-8");
            //Connect to page
            HtmlPage page = webClient.getPage("http://monngonmoingay.com/be-thui-xao-sa-te-2/");
            page.getWebClient().addRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
            //Parse to List combine links
            //List<HtmlElement> categoryLinks = (List<HtmlElement>) page.getByXPath("//div[@class='detail_descipt col-lg-6 col-md-7 col-sm-12 col-xs-12']/h1[1]");
            List<String> contents = new ArrayList<String>();
            List<HtmlElement> tmp = null;

            for (String xpath : xpaths) {
                System.out.println(xpath + "thiendeptrai");
                //contents[i] = (List<HtmlElement>) page.getByXPath(xpath);
                tmp = (List<HtmlElement>) page.getByXPath(xpath);
                String tmpString;
                for (HtmlElement data : tmp) {
                    tmpString = data.asText();
                    contents.add(tmpString);
                }
            }

            ListIterator<String> listIterator = contents.listIterator();
            System.out.println(" ----- ");

            while (listIterator.hasNext()) {
                String value = listIterator.next();
                System.out.println("value:" + value);
            }
            request.setAttribute("LIST", listIterator);
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
