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

@WebServlet("/ReturnBook")
public class ReturnBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        User currentUser = (User) session.getAttribute("currentUser");
        int recordId = Integer.parseInt(request.getParameter("recordId"));
        List<BorrowrecordEntity> borrowedRecordList = (List<BorrowrecordEntity>) session.getAttribute("borrowedRecordList");
        BorrowrecordEntity returnRecord = null;
//        System.out.println("USER: " + currentUser);
//        System.out.println("RECORD ID: " + recordId);
//        System.out.println("BORROWED RECORD LIST: " + borrowedRecordList);
        for (BorrowrecordEntity borrowrecordEntity : borrowedRecordList) {
            if (borrowrecordEntity.getRid() == recordId) {
                returnRecord = borrowrecordEntity;
            }
        }
//        System.out.println("RETURN RECORD: " + returnRecord);
        double payment = currentUser.returnBook(returnRecord);
        String message = null;
        if(payment > 0){
            message = "You have to pay "+payment+" overdue penalty :(";
        }else{
            message = "You have returned this book successfully :)";
        }
        session.setAttribute("resultMessage", message);
        session.setAttribute("returnedRecord", returnRecord);
        request.getRequestDispatcher("/book/ReturnResult.jsp").forward(request, response);
    }
}
