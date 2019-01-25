package logic.logicmodel;

import dao.AdminDao;
import dao.BookDao;
import dao.EmailDao;
import daoImpl.AdminDaoImpl;
import daoImpl.BookDaoImpl;
import daoImpl.EmailDaoImpl;
import logic.visitorpattern.AcademicDepartment;
import logic.visitorpattern.FinanceDepartment;
import model.*;
import service.AdministratorService;

import java.util.ArrayList;

/**
 * Created by 82646 on 2019/1/23.
 * 逻辑对象管理员
 * 可以直接实现AdministratorService接口
 * 将原来getAdminDetail方法编程用一个id来初始化对象的方法
 */
public class Administrator implements AdministratorService{

    private AdministratorEntity administratorInfo;   //基础信息
    private ArrayList<EmailEntity> emails;
    private AcademicDepartment academicDepartment = new AcademicDepartment();
    private FinanceDepartment financeDepartment = new FinanceDepartment();

    private AdminDao adminDao = new AdminDaoImpl();
    private EmailDao emailDao = new EmailDaoImpl();
    private BookDao bookDao = new BookDaoImpl();

    //通过一个aid来初始化一个Admin,前端应该会调用这个方法
    public Administrator(int aid) {
        this.administratorInfo = adminDao.getAdminById(aid);
        emails = emailDao.getAdminEmails(aid);
    }

    public ArrayList<EmailEntity> getEmails() {
        return emails;
    }

    public void setEmails(ArrayList<EmailEntity> emails) {
        this.emails = emails;
    }

    public AcademicDepartment getAcademicDepartment() {
        return academicDepartment;
    }

    public void setAcademicDepartment(AcademicDepartment academicDepartment) {
        this.academicDepartment = academicDepartment;
    }

    public FinanceDepartment getFinanceDepartment() {
        return financeDepartment;
    }

    public void setFinanceDepartment(FinanceDepartment financeDepartment) {
        this.financeDepartment = financeDepartment;
    }

    public AdministratorEntity getAdministratorInfo() {
        return administratorInfo;
    }

    public void setAdministratorInfo(AdministratorEntity administratorInfo) {
        this.administratorInfo = administratorInfo;
    }

    @Override
    public void EditBookInfo(BookEntity book) {

        bookDao.updateBookInfo(book);

    }

    @Override
    public ArrayList<BorrowrecordEntity> getUserBorrowRecord(UserEntity user) {
        User theUser = this.academicDepartment.visit(user);
        return theUser.getBorrowRecords();
    }

    @Override
    public ArrayList<FinerecordEntity> getUserFineRecord(UserEntity user) {

        User theUser = this.financeDepartment.visit(user);
        return theUser.getFineRecords();

    }

    @Override
    public ArrayList<BookEntity> getBookList() {
        return bookDao.getAllBooks();
    }
}
