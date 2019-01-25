package service;

import model.BookEntity;
import model.BorrowrecordEntity;

import java.util.ArrayList;

/**
 * Created by 82646 on 2019/1/23.
 * 处理和读者有关的方法  刚开始就返回一个User对象
 */
public interface UserService {

    //办理用户的借书，前端判断如果库存为0是不能借出的  返回0是正常 返回1是表示用户达到最大可借数目 返回2是表示库存为0
    int borrowBook(BookEntity book);

    //办理还书，如果没有超期则返回0，如果>0说明超期有欠款，前端显示欠款金额
    double returnBook(BorrowrecordEntity record);

    //type表示阅读类型分别是"Word","PDF","EPUB"   返回的内容前端直接照样显示就好
    String readOnline(BookEntity book,String type);

    //更新用户的信息，传入的是信息已经更新好的用户信息
    void updateUserInfo();

    //根据不同的用户返回不同的图书列表
    ArrayList<BookEntity> getBookList();   //根据用户id返回用户可以看到的当前书目

}
