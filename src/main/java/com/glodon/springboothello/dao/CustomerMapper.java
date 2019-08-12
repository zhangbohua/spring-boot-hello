package com.glodon.springboothello.dao;

import com.glodon.springboothello.domain.Customer;

import java.util.List;

/**
 * @Auther: zhangbh
 * @Date: 2019/8/8 16:44
 * @Description:
 */
public interface CustomerMapper {
    public void save(Customer customer);

    public List<Customer> findAll();
    public List<Customer> pageFind(int currentpage, int pagesize);

    public Customer findById(Integer id);

    public Integer count();

    public void update(Customer customer);

    public void delete(Integer id);
}
