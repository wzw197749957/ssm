package com.lagou.edu.controller;

import com.lagou.edu.dao.AccountDao;
import com.lagou.edu.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/account")
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
    public List<Account> queryAll() throws Exception {
        return accountDao.getAll();
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request, String username, String password) {
        if (accountDao.queryPasswordByUsername(username, password)) {
            request.getSession().setAttribute("login", username);
            return "index.jsp";
        }
        return null;
    }

}
