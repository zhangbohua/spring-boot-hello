package com.glodon.springboothello.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.glodon.springboothello.domain.Customer;
import com.glodon.springboothello.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: zhangbh
 * @Date: 2019/8/8 16:59
 * @Description:
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Resource
    private CustomerService customerService;

    //跳转到input.html页面
    @RequestMapping("/input")
    public String input(Model model){
        model.addAttribute("cust", new Customer());
        return "input";
    }
    /**
     * 保存方法
     */
    @RequestMapping("/save")
    public String save(Customer customer){
        customerService.save(customer);
        return "succ";
    }

    /**
     * 列表展示
     */
    @RequestMapping("/list")
    public String list(Model model){
        List<Customer> list = customerService.findAll();
        model.addAttribute("list", list);
        return "list";
    }

    @RequestMapping("pageListByLimit")
    public String pageList(@RequestParam(value = "currentpage", defaultValue = "1", required = false) int currentpage,
                           @RequestParam(value = "pagesize", defaultValue = "10", required = false) int pagesize, Model model){
        int pageNum = (currentpage - 1) * pagesize;
        List<Customer> list = customerService.pageFind( pageNum, pagesize);
        model.addAttribute("currentpage", currentpage);
        model.addAttribute("pagesize", pagesize);
        model.addAttribute("list", list);
        int count = customerService.count();
        model.addAttribute("count", count);
        return "list";
    }
    /*@GetMapping("/queryPage")
    public String aueryPage(@RequestParam(required = true, value = "pageNum", defaultValue = "1") Integer pageNum,
                            @RequestParam(required = true, value = "pageSize", defaultValue = "10") Integer pageSize, Model model){
        PageInfo<Customer> pageInfo = customerService.selectCustomerList(pageNum, pageSize);
        model.addAttribute("pageInfo", pageInfo);
        return "pageList";
    }*/
    /*@RequestMapping("/pageListByPageInfo")
    public String list(Model model,@RequestParam(defaultValue="1")Integer pageNum){
        PageHelper.startPage (pageNum,5);
        List<Customer> list = customerService.findAll();
        PageInfo<Customer> pageInfo=new PageInfo<>(list);

        model.addAttribute("list", list);
        model.addAttribute ("pageInfo",pageInfo);
        return "pagelist";
    }*/
    @GetMapping("/pageListByPageInfo")
    public String pageListByPageInfo(Model model,
                                     @RequestParam(value = "pageNum", defaultValue = "1", required = false) Integer pageNum){
        PageHelper.startPage(pageNum, 5);
        List<Customer> list = customerService.findAll();
        PageInfo<Customer> pageInfo = new PageInfo<>(list);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("list", list);
        return "pageList";
    }
    /**
     * 根据id查询
     */
    @RequestMapping("/findById")
    public String findById(Integer id,Model model){
        Customer cust = customerService.findById(id);
        model.addAttribute("cust", cust);
        return "input";
    }

    /**
     * 删除客户
     */
    @RequestMapping("/delete")
    public String delete(Integer id){
        customerService.delete(id);
        return "redirect:/customer/list";
    }
}
