package com.glodon.springboothello.service;

import com.glodon.springboothello.domain.Customer;

import java.util.List;

/**
 * @Auther: zhangbh
 * @Date: 2019/8/8 16:53
 * @Description:
 */
public interface CustomerService {
    public void save(Customer customer);

    public List<Customer> findAll();
    public List<Customer> pageFind(int pageNum, int pagesize);

    public Customer findById(Integer id);

    public Integer count();

    public void delete(Integer id);

   /* PageInfo<Customer> selectCustomerList(Integer pageNum, Integer pagesize);*/
}
