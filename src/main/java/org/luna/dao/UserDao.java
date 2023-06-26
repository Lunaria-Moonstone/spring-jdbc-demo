package org.luna.dao;

import org.luna.beans.User;

import javax.sql.DataSource;
import java.util.List;

public interface UserDao {
    public void setDataSource(DataSource ds);
    public void create(String username, String password);
    public User getUser(Integer id);
    public List<User> listUsers();
    public void delete(Integer id);
    public void update(Integer id, User user);
}
