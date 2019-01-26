package controller;

import logic.logicmodel.User;
import model.UserEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet("/EditProfile")
public class EditProfileServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("i am in posting");
        String name = new String(request.getParameter("name").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        String type = new String(request.getParameter("type").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        String gender =  new String(request.getParameter("gender").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        String department =  new String(request.getParameter("department").getBytes(StandardCharsets.ISO_8859_1),
                StandardCharsets.UTF_8);

        HttpSession session = request.getSession(false);
        User currentUser = (User) session.getAttribute("currentUser");
        UserEntity userEntity = currentUser.getUserInfo();
        System.out.println("BEFORE: " + userEntity);
        if (!name.isEmpty()) userEntity.setName(name);
        if (!type.isEmpty()) userEntity.setType(type);
        if (!gender.isEmpty()) userEntity.setSex(gender);
        if (!department.isEmpty()) userEntity.setDepartment(department);
        System.out.println("AFTER: " + userEntity);
        currentUser.setUserInfo(userEntity);
        currentUser.updateUserInfo();
        request.getRequestDispatcher("/home/UserHome.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/user/EditProfile.jsp").forward(request, response);
    }
}
