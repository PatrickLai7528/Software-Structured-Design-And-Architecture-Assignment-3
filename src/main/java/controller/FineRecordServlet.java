package controller;

import logic.logicmodel.Administrator;
import logic.logicmodel.User;
import model.FinerecordEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/FineRecord")
public class FineRecordServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        Administrator admin = new Administrator(1);
        String userId = request.getParameter("userId");
        User selectedUser = null;
        if(userId == null)
            userId = "1";
        selectedUser = new User(Integer.parseInt(userId));
        List<FinerecordEntity> fineRecordList = admin.getUserFineRecord(selectedUser.getUserInfo());
        session.setAttribute("fineRecordList", fineRecordList);
        request.getRequestDispatcher("/record/FineRecord.jsp").forward(request, response);
    }
}
