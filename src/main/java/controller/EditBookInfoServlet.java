package controller;

import logic.logicmodel.Administrator;
import model.BookEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.print.Book;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

@WebServlet("/EditBookInfo")
public class EditBookInfoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = new String(request.getParameter("name").getBytes(StandardCharsets.ISO_8859_1),
                StandardCharsets.UTF_8);
        String type = new String(request.getParameter("type").getBytes(StandardCharsets.ISO_8859_1),
                StandardCharsets.UTF_8);
        String description = new String(request.getParameter("description").getBytes(StandardCharsets.ISO_8859_1),
                StandardCharsets.UTF_8);
        String quantity = new String(request.getParameter("quantity").getBytes(StandardCharsets.ISO_8859_1),
                StandardCharsets.UTF_8);
        String fineRate = new String(request.getParameter("fineRate").getBytes(StandardCharsets.ISO_8859_1),
                StandardCharsets.UTF_8);

        HttpSession session = request.getSession(false);
        BookEntity selectedBook = (BookEntity) session.getAttribute("selectedBook");

        if(!name.isEmpty()) selectedBook.setBname(name);
        if(!type.isEmpty())  selectedBook.setType(type);
        if(!description.isEmpty()) selectedBook.setDescription(description);
        if(!quantity.isEmpty()) selectedBook.setQuantity(Integer.parseInt(quantity));
        if(!fineRate.isEmpty()) selectedBook.setFinerate(Double.parseDouble(fineRate));
        
        Administrator admin = new Administrator(1);
        admin.EditBookInfo(selectedBook);
        request.getRequestDispatcher("/home/AdminHome.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int bookId = Integer.parseInt(request.getParameter("bookId"));
        HttpSession session = request.getSession(false);
        List<BookEntity> bookList = (List<BookEntity>) session.getAttribute("bookList");
        BookEntity selectedBook = null;
        for (BookEntity bookEntity : bookList) {
            if (bookEntity.getBid() == bookId) {
                selectedBook = bookEntity;
            }
        }
        session.setAttribute("selectedBook", selectedBook);
        request.getRequestDispatcher("/book/EditBookInfo.jsp").forward(request, response);
    }
}
