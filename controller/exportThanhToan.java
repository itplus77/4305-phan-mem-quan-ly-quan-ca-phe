/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author thanhphuong
 */
@WebServlet(name = "exportThanhToan", urlPatterns = {"/exportThanhToan"})
public class exportThanhToan extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            entities.ThanhToan thanhToan = new model.ThanhToan().getThanhToanByID(request.getParameter("id"));

            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>\n"
                    + "<html>\n"
                    + "<head>\n"
                    + "<meta charset=\\\"utf-8\\\">\n"
                    + "<style>\n"
                    + "table {\n"
                    + "    font-family: arial, sans-serif;\n"
                    + "    border-collapse: collapse;\n"
                    + "    width: 100%;\n"
                    + "}\n"
                    + "\n"
                    + "td, th {\n"
                    + "    border: 1px solid #dddddd;\n"
                    + "    text-align: left;\n"
                    + "    padding: 8px;\n"
                    + "}\n"
                    + "\n"
                    + "tr:nth-child(even) {\n"
                    + "    background-color: #dddddd;\n"
                    + "}\n"
                    + "</style>\n"
                    + "</head>\n"
                    + "<body>\n"
                    + "<h1>Quản lý đặt phòng online - khách sạn FairyBay</h1>\n"
                    + "<h2>Thanh toán tiền phòng</h2>\n"
                    + "<table>\n"
                    + "  <tr>\n"
                    + "    <th>Tên khách hàng</th>\n"
                    + "    <th>Số điện thoại</th>\n"
                    + "    <th>Email</th>\n"
                    + "    <th>CMND</th>\n"
                    + "    <th>Phòng</th>\n"
                    + "    <th>Ngày đặt</th>\n"
                    + "    <th>Ngày ra</th>\n"
                    + "    <th>Số tiền thanh toán</th>\n"
                    + "  </tr>");
            
            out.print("  <tr>\n"
                    + "    <td>" + thanhToan.getPhieuDat().getKhach().getNameK() + "</td>\n"
                    + "    <td>" + thanhToan.getPhieuDat().getKhach().getSdt()+ "</td>\n"
                    + "    <td>" + thanhToan.getPhieuDat().getKhach().getEmail()+ "</td>\n"
                    + "    <td>" + thanhToan.getPhieuDat().getKhach().getCmnd()+ "</td>\n"
                    + "    <td>" + thanhToan.getPhieuDat().getRoom().getType() +"("+ thanhToan.getPhieuDat().getRoom().getNameP()+")"+ "</td>\n"
                    + "    <td>" + thanhToan.getPhieuDat().getDatein() + "</td>\n"
                    + "    <td>" + thanhToan.getPhieuDat().getDateout() + "</td>\n"
                    + "    <td>" + thanhToan.getThanhTien() + " vnđ</td>\n"
                    + "  </tr>");
            
            out.print("</table>\n"
                    + "\n"
                    + "</body>\n"
                    + "</html>");
            
            String exportToExcel = request.getParameter("exportToExcel");
            if (exportToExcel != null
                    && exportToExcel.toString().equalsIgnoreCase("YES")) {
                response.setContentType("application/vnd.ms-excel");
                response.setHeader("Content-Disposition", "inline; filename="
                        + "excel.xls");
                
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
     * Handles the HTTP <code>POST</code> method.
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
