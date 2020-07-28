package com.lagou.edu.controller;

import com.lagou.edu.dao.AccountDao;
import com.lagou.edu.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class AccountController {

    /**
     * Spring容器和SpringMVC容器是有层次的（父子容器）
     * Spring容器：service对象+dao对象
     * SpringMVC容器：controller对象，，，，可以引用到Spring容器中的对象
     */


    @Autowired
    private AccountDao accountDao;

    @RequestMapping("/queryAll")
    @ResponseBody
    public ModelAndView queryAll() throws Exception {
        List<Account> accounts = accountDao.getAll();
        return new ModelAndView("account.jsp", "list", accounts);
    }

    @RequestMapping("/login")
    public ModelAndView login(HttpServletRequest request, String username, String password) {
        if (accountDao.queryPasswordByUsername(username, password)) {
            request.getSession().setAttribute("login", username);
            return new ModelAndView("index.jsp");
        }
        return null;
    }

    @RequestMapping("/update")
    public void update(String cardNo, String name, String money) {
        Account account = accountDao.queryByCardNo(cardNo);
        account.setName(name);
        account.setMoney(Integer.valueOf(money));
        accountDao.update(account);
    }

    @RequestMapping("/delete")
    public void update(String cardNo) {
        accountDao.delete(cardNo);
    }

}
