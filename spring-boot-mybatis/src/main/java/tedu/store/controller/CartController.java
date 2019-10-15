package tedu.store.controller;

import org.springframework.web.bind.annotation.*;
import tedu.store.entity.Cart;
import tedu.store.service.ICartService;
import tedu.store.util.ResponseResult;
import tedu.store.vo.CartVO;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.LinkedList;
import java.util.List;

/**
 * 处理购物车数据的控制器类
 */
@RestController
@RequestMapping("/carts")
public class CartController extends BaseController {

    @Autowired
    private ICartService cartService;


    @RequestMapping("/add")
    public ResponseResult<Void> addToCart(Cart cart, HttpSession session) {
        // 注意：客户端提交的cart只会包含gid, num
        // 从session中获取uid
        System.out.println("aaaaaaa");
        Integer uid = getUidFromSession(session);
        System.out.println("bbbbbbbb");
        // 从session中获取username
        String username = session.getAttribute("username").toString();
        System.out.println("ccccccccccc");
        // 将uid封装到cart中
        cart.setUid(uid);
        // 执行：service.addToCart(username, cart);
        cartService.addToCart(username, cart);
        // 返回
        return new ResponseResult<>(SUCCESS);
    }

    @RequestMapping("/{id}/add_num")
    public ResponseResult<Void> addNum(
            @PathVariable("id") Integer cid,
            HttpSession session) {
        // 从session中获取uid和username
        Integer uid = getUidFromSession(session);
        String username = session.getAttribute("username").toString();
        // 执行
        cartService.addNum(uid, username, cid);
        // 返回
        return new ResponseResult<>(SUCCESS);
    }

    @GetMapping("/")
    public ResponseResult<List<CartVO>> getByUid(HttpSession session, HttpServletRequest request) {
        // 从session中获取uid
        Integer uid = getUidFromSession(session);
        System.out.println("chnehualaile");
        // 执行：service.addToCart(username, cart);
        String page = request.getParameter("page");
        System.out.println("page=====>" + page);
        Integer pag = Integer.parseInt(page);
        Integer num = new Integer(2);
        List<CartVO> data = cartService.getByUid(uid, (pag - 1) * 5 + 1, (pag - 1) * 5 + 5);
        // 返回
        return new ResponseResult<>(SUCCESS, data);
    }

    @GetMapping("/collect")
    public ResponseResult<List<CartVO>> getByUidCollect(HttpSession session, HttpServletRequest request) {
        // 从session中获取uid
        Integer uid = getUidFromSession(session);
        System.out.println("chnehualaile");
        // 执行：service.addToCart(username, cart);
        String page = request.getParameter("page");
        System.out.println("page=====>" + page);
        Integer pag = Integer.parseInt(page);
        Integer num = new Integer(2);
        List<CartVO> data = cartService.getByUid(uid, (pag - 1) * 5, (pag - 1) * 2 + 5);
        // 返回
        return new ResponseResult<>(SUCCESS, data);
    }

    @RequestMapping("/search")
    public ResponseResult<List<CartVO>> getByNnme(HttpSession session, HttpServletRequest request) {
        // 从session中获取uid
        Integer uid = getUidFromSession(session);
        System.out.println("chnehualaile");
//		uid = 1;
        // 执行：service.addToCart(username, cart);
        String page = request.getParameter("page");
        System.out.println("page=====>" + page);
        Integer pag = Integer.parseInt(page);
        Integer num = new Integer(2);
        String title = request.getParameter("title");
        title = "%" + title + "%";
        System.out.println("title = " + title);
        List<CartVO> data = cartService.getByTitle(uid, title, (pag - 1) * 5, (pag - 1) * 2 + 5);
        // 返回
        return new ResponseResult<>(SUCCESS, data);
    }


    @GetMapping("/checked_list")
    public ResponseResult<List<CartVO>> getByCids(
            Integer[] cids) {
        // 执行
        List<CartVO> data = cartService.getByCids(cids);
        // 返回
        return new ResponseResult<>(SUCCESS, data);
    }

    @GetMapping("/getpage")
    public ResponseResult<List> getpage2(HttpServletRequest request) {
        String page = request.getParameter("page");
        System.out.println("page---->" + page);
        List data = new LinkedList();
        data.add("1");
        data.add("2");
        return new ResponseResult<>(SUCCESS, data);
    }

}






