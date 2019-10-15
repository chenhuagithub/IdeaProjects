package com.atguitu.dao;

import com.atguitu.bean.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository()
public class BookDao extends BaseDao<Book> {


    public void saveBook(){
        System.out.println("图书已保存");
    }

    @Override
    public void save() {
        System.out.println("BookDao.....保存图书");
    }

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void updateBalance(String username, int price){
        String sql = "update account set balance = balance-? where username = ?";
        int update = jdbcTemplate.update(sql, price, username);
    }


    public int getPrice(String isbn){
        String sql = "select price from book where isbn = ?";
        return jdbcTemplate.queryForObject(sql, Integer.class, isbn);
    }


    public void updateStock(String isbn){
        String sql = "update book_stock set stock=stock - 1 where isbn = ?";
        jdbcTemplate.update(sql, isbn);
    }


    public void updatePrice(String isbn, int price){
        String sql = "update book set price = ? where isbn=?";
        jdbcTemplate.update(sql, isbn, price);
    }


}
