package org.luna.daoImpl;

import org.luna.beans.User;
import org.luna.dao.UserDao;
import org.luna.mappers.UserMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private DataSource dataSource;
    private JdbcTemplate jdbc;
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbc = new JdbcTemplate(dataSource);
    }

    public void create(String username, String password) {
        String SQL = "insert into user (username, password) " +
                "values (?, ?)";
        jdbc.update(SQL, username, password);
        System.out.println("Created Record!");
        return;
    }

    public User getUser(Integer id) {
        String SQL = "select * from user where id=?";
        User user = jdbc.queryForObject(SQL,
                new Object[]{id}, new UserMapper());
        return user;
    }

    public List<User> listUsers() {
        String SQL = "select * from user";
        List<User> list = jdbc.query(SQL,
                new UserMapper());
        return list;
    }

    public void delete(Integer id) {
        String SQL = "delete from User where id=?";
        jdbc.update(SQL, id);
        System.out.println("Deleted Record");
        return;
    }

    public void update(Integer id, User user) {
        String SQL = "update user set username=?, password=? where id=?";
        jdbc.update(SQL, user.getUsername(), user.getPassword(), id);
        System.out.println("Updated Record");
        return;
    }
}
