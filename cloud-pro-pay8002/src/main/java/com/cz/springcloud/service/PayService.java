package com.cz.springcloud.service;


import com.cz.springcloud.dao.PayDao;
import com.cz.springcloud.utils.PageData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PayService {

    @Resource
    private PayDao payDao;


    public boolean add(String ls) {
        payDao.addPayment(ls);
        return true;
    }


    public PageData get(Integer id) {
        return payDao.getById(id);
    }

}
