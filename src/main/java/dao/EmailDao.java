package dao;

import model.EmailEntity;

import java.util.ArrayList;

/**
 * Created by 82646 on 2019/1/24.
 */
public interface EmailDao {

    void addNewEmail(EmailEntity email);

    ArrayList<EmailEntity> getAdminEmails(int aid);

}
