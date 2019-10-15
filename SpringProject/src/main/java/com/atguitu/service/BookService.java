package com.atguitu.service;


import com.atguitu.bean.Book;
import com.atguitu.dao.BaseDao;
import com.atguitu.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.PrimitiveIterator;

@Service
public class BookService extends BaseService<Book> {


    @Autowired
    BookDao bookDao;

    /**
     *         事务细节
     *         1. isolation-Isolation: 事务的隔离级别
     *              数据库事务并发问题
     *                  a. 脏读
     *                  b. 不可重复读
     *                  c. 幻读
     *
     *              隔离级别
     *                  a. 读未提交: READ UNCOMMITTED
     *                  b. 读已提交: READ COMMITTED
     *                  c. 可重复读: REPEATABLE READ
     *
     *         2. propagation-Propagation: 事务的传播行为
     *              propagation = Propagation.REQUIRED
     *              propagation = Propagation.REQUIRED_NEW
     *
     *         3. noRollbackFor-Class[]: 哪些异常事务可以不回滚
     *
     *         4. noRollbackForClassName-String[]: 哪些异常事务可以不回滚(全类名)
     *
     *          异常分类:
     *                  运行时异常(非检查异常): 可以不用处理, 默认都回滚
     *                  编译时异常(检查异常): 要么try-catch, 要么在方法上声明throws, 默认不回滚
     *
     *          事务的回滚:
     *              默认发生运行时异常都回滚, 发生编译时异常不会回滚
     *
     *
     *
     *         5. rollbackFor-Class[]: 哪些异常事务需要回滚
     *
     *         6. rollbackForClassName-String[]: 哪些异常事务需要回滚(全类名)
     *
     *         7. readOnly-boolean: 设置事务为只读事务
     *              可以进行事务优化:
     *                  readOnly=True, 加快查询速度, 不管事务那一堆操作
     *
     *         8. timeout-int(秒为单位): 超时, 事务超出指定执行时长后自动终止并回滚
     *
     */


    //事务管理器注解
//    @Transactional(timeout = 3, readOnly = false, noRollbackFor = {ArithmeticException.class, NullPointerException.class}, rollbackFor = {FileNotFoundException.class})
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void checkout(String username, String isbn){
        // 减库存
        bookDao.updateStock(isbn);
        int price = bookDao.getPrice(isbn);
        //减余额
        bookDao.updateBalance(username, price);

        //int i=1/0;
        try {
            new FileInputStream("/opt/aaa.aa");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    @Transactional(propagation = Propagation.REQUIRED)
    public void updatePrice(String isbn, int price){
        bookDao.updatePrice(isbn, price);
        int i = 1/0;
    }

}
