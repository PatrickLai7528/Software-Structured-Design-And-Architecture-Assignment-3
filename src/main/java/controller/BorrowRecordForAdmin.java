package controller;

import logic.logicmodel.Administrator;
import logic.logicmodel.User;
import model.BorrowrecordEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/BorrowRecordForAdmin")
public class BorrowRecordForAdmin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        Administrator admin = new Administrator(1);
        String userId = request.getParameter("userId");
        User selectedUser = null;
        if(userId == null)
            userId = "1";
        selectedUser = new User(Integer.parseInt(userId));
        List<BorrowrecordEntity> borrowRecordList = admin.getUserBorrowRecord(selectedUser.getUserInfo());
        session.setAttribute("borrowedRecordList", borrowRecordList);
        request.getRequestDispatcher("/record/BorrowRecordForAdmin.jsp").forward(request, response);
    }
}
