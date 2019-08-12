package com.glodon.springboothello.service.impl;

import com.glodon.springboothello.dao.CustomerMapper;
import com.glodon.springboothello.domain.Customer;
import com.glodon.springboothello.service.CustomerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: zhangbh
 * @Date: 2019/8/8 16:53
 * @Description:
 */
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    //注入mapper接口的对象
    @Resource
    private CustomerMapper customerMapper;

    @Override
    public void save(Customer customer) {
        //判断是否添加还是修改
        if(customer.getId()!=null){
            //修改
            customerMapper.update(customer);
        }else{
            //添加
            customerMapper.save(customer);
        }
    }

    @Override
    public List<Customer> findAll() {
        return customerMapper.findAll();
    }

    @Override
    public List<Customer> pageFind(int pageNum, int pagesize) {
        return customerMapper.pageFind(pageNum, pagesize);
    }

    @Override
    public Customer findById(Integer id) {
        return customerMapper.findById(id);
    }

    @Override
    public Integer count() {
        return customerMapper.count();
    }

    @Override
    public void delete(Integer id) {
        customerMapper.delete(id);
    }

    /*@Override
    public PageInfo<Customer> selectCustomerList(Integer pageNum, Integer pagesize) {
        PageHelper.startPage(pageNum, pagesize);
        List<Customer> list = customerMapper.findAll();
        PageInfo<Customer> pageInfo = new PageInfo<>(list);
        return pageInfo;
     }*/

}