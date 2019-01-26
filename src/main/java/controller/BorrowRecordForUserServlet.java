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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/BorrowRecordForUser")
public class BorrowRecordForUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        User currentUser = (User) session.getAttribute("currentUser");
        System.out.println(currentUser);
        Administrator administrator = new Administrator(1);
        List<BorrowrecordEntity> borrowRecordEntityList = administrator.getUserBorrowRecord(currentUser.getUserInfo());
        System.out.println(borrowRecordEntityList);
        List<BorrowrecordEntity> borrowedRecordList = new ArrayList<>();
        for (BorrowrecordEntity borrowrecordEntity : borrowRecordEntityList) {
            if (borrowrecordEntity.getReturndate() == null) {
                borrowedRecordList.add(borrowrecordEntity);
            }
        }
        System.out.println("NOT RETURN RECORD: " + borrowedRecordList);
        session.setAttribute("borrowedRecordList", borrowedRecordList);
        request.getRequestDispatcher("/record/BorrowRecordForUser.jsp").forward(request, response);
    }
}
