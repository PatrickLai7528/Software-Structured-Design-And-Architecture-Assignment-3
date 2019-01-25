package service;

import model.BookEntity;
import model.BorrowrecordEntity;
import model.FinerecordEntity;
import model.UserEntity;

import java.util.ArrayList;

/**
 * Created by 82646 on 2019/1/23.
 * 和管理员有关的服务
 */
public interface AdministratorService {

    //直接将修改完后的book信息当作参数传递，前端检查信息是否合法
    void EditBookInfo(BookEntity book);

    //得到用户的借阅记录
    ArrayList<BorrowrecordEntity> getUserBorrowRecord(UserEntity user);

    //得到用户的罚单记录
    ArrayList<FinerecordEntity> getUserFineRecord(UserEntity user);

    //得到管理员能看到的图书列表
    ArrayList<BookEntity> getBookList();
}
