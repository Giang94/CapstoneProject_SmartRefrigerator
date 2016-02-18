/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.Servlet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang3.CharUtils;

/**
 *
 * @author Dell
 */
public class GetHTMLContentServlet extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            String str = request.getParameter("txtURL");
            System.out.println(str);
            URL url = new URL(str);
            //BufferedReader in;
            //InputStreamReader inputStreamReader = new InputStreamReader(url.openStream(), "UTF8");
            //in = new BufferedReader(inputStreamReader);

            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));

            String inputLine;
            StringBuffer res;
            res = new StringBuffer();

            //van de la o in.readLine()
            while ((inputLine = in.readLine()) != null) {
                //System.out.println(in.readLine());
                    res.append(htmlEncode(inputLine) + "\n");
                    //res.append(inputLine + "\n");
            }
            //System.out.println(res);
            in.close();


            //Save file
            System.out.println("start save");
            String realPath = this.getServletContext().getRealPath("/");
            String htmlFilePath = realPath + "/tmp.html";
            File file = new File(htmlFilePath);

            BufferedWriter bwr = new BufferedWriter(new FileWriter(file));

            //write contents of StringBuffer to a file
            bwr.write(res.toString());

            //flush the stream
            bwr.flush();

            //close the stream
            bwr.close();
            HttpSession session = request.getSession();
            session.setAttribute("URL", str);
            System.out.println("Content of StringBuffer written to File.");
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        } finally {
            out.close();
        }

//        String temp = "Thời tiết cuối năm se lạnh, bằng chút hơi ấm trong gian bếp";
//        System.out.println(temp);
    }

    private String htmlEncode(final String string) {
        final StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < string.length(); i++) {
            final Character character = string.charAt(i);
            if (CharUtils.isAscii(character)) {
                // Encode common HTML equivalent characters
                stringBuffer.append(
                        //StringEscapeUtils.escapeHtml4(character.toString()));
                        character.toString());
            } else {
                // Why isn't this done in escapeHtml4()?
                stringBuffer.append(
                        String.format("&#x%x;",
                        Character.codePointAt(string, i)));
            }
        }
        return stringBuffer.toString();
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
