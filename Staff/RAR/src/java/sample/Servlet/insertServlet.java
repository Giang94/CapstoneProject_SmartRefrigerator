/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sample.Utilities.DBUtils;

/**
 *
 * @author Dell
 */
public class insertServlet extends HttpServlet {

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
            String recipeName = request.getParameter("NAME");
            String recipeIntro = request.getParameter("INTRODUCTION");
            String recipeImage = request.getParameter("IMAGE");
            String[] materials = request.getParameterValues("MATERIAL");
            String[] steps = request.getParameterValues("STEP");
            int result = addRecipe(recipeName, recipeIntro, recipeImage);
            boolean addStep = false, addMate = false;
            if (result != -1) {
                addStep = addStep(result, steps, null);
                addMate = addIngre(result, 0, materials, 0, 0);
            }
            System.out.println(addStep);
            System.out.println(addMate);
            //getReturnId
        } finally {
            out.close();
        }
    }

    private int addRecipe(String recipeName, String recipeIntro, String recipeImage) {
        Date date = new Date();
        Timestamp orderDate = new Timestamp(date.getTime());
        Connection con = DBUtils.makeConnection();
        PreparedStatement stm = null;
        ResultSet rs = null;
        if (con != null) {
            String sql = "INSERT INTO [Recipe](RecipeName, Introduction, RecipeImage, ViewedNumber, DateAdded) VALUES(?,?,?,?,?);SELECT @@IDENTITY";
            try {
                stm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                stm.setString(1, recipeName);
                stm.setString(2, recipeIntro);
                stm.setString(3, recipeImage);
                stm.setInt(4, 0);
                stm.setTimestamp(5, orderDate);
                int row = stm.executeUpdate();
                if (row > 0) {
                    rs = stm.getGeneratedKeys();
                    if (rs.next()) {
                        return rs.getInt(1);
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(ex.getMessage());
            } finally {
                try {
                    if (stm != null) {
                        stm.close();
                    }
                    if (con != null) {
                        con.close();
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(ex.getMessage());
                }
            }
        }
        return -1;
    }

    private boolean addStep(int recipeID, String[] steps, String stepImage) {
        Connection con = DBUtils.makeConnection();
        PreparedStatement stm = null;
        int count = 0;
        System.out.println(steps.length);
        if (con != null) {
            for (int i = 0; i < steps.length; i++) {
                String sql = "INSERT INTO [RecipeStep](RecipeID, StepDetail, StepImage) VALUES(?,?,?)";
                try {
                    stm = con.prepareStatement(sql);
                    stm.setInt(1, recipeID);
                    stm.setString(2, steps[i]);
                    stm.setString(3, stepImage);
                    int row = stm.executeUpdate();
//                    if (row <= 0) {
//                        return false;
//                    }
                    count++;
                    if (count == steps.length) {
                        try {
                            if (stm != null) {
                                stm.close();
                            }
                            if (con != null) {
                                con.close();

                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(ex.getMessage());
                        }
                        return true;
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(ex.getMessage());
                }
            }
        }
        try {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();

            }
        } catch (SQLException ex) {
            Logger.getLogger(ex.getMessage());
        }

        return false;
    }
    
    private boolean addIngre(int recipeID, int mateId, String[] materials, int amount, int unit){
        Connection con = DBUtils.makeConnection();
        PreparedStatement stm = null;
        int count = 0;
        System.out.println(materials.length);
        if (con != null) {
            System.out.println("here");
            for (int i = 0; i < materials.length; i++) {
                String sql = "INSERT INTO [Ingredient](RecipeID, MaterialID, IngredientName, Amount, Unit) VALUES(?,?,?,?,?)";
                try {
                    stm = con.prepareStatement(sql);
                    stm.setInt(1, recipeID);
                    stm.setInt(2, mateId);
                    stm.setString(3, materials[i]);
                    stm.setInt(4, amount);
                    stm.setInt(5, unit);
                    int row = stm.executeUpdate();
                    System.out.println(row);
//                    if (row <= 0) {
//                        return false;
//                    }
                    count++;
                    System.out.println("count");
                    if (count == materials.length) {
                        System.out.println("true");
                        try {
                            if (stm != null) {
                                stm.close();
                            }
                            if (con != null) {
                                con.close();

                            }
                        } catch (SQLException ex) {
                            System.out.println(ex.toString());
                        }
                        return true;
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.toString());
                }
            }
        }
        try {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();

            }
        } catch (SQLException ex) {
            Logger.getLogger(ex.getMessage());
        }
        
        return false;
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
