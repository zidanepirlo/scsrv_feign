package com.yuan.springcloud.scsrv.service.impl;

import com.yuan.springcloud.scsrv.dao.domain.IGradeDao;
import com.yuan.springcloud.scsrv.dao.domain.IUserDao;
import com.yuan.springcloud.scsrv.dao.entity.Grade;
import com.yuan.springcloud.scsrv.dao.entity.User;
import com.yuan.springcloud.scsrv.service.ITestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * TestService
 *
 * @author yuanqing
 * @create 2019-03-31 08:20
 **/
@Service
public class TestServiceImpl implements ITestService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IUserDao userDao;

    @Autowired
    private IGradeDao gradeDao;

    @Override
    @Transactional(propagation= Propagation.REQUIRED,rollbackFor=Exception.class)
    public String insertUserGradeForTransaction() throws Exception{

        try{
            User iUser = new User();
            iUser.setId("1111");
            iUser.setName("yuanqing");
            userDao.insert(iUser);

            Grade iGrade = new Grade();
            iGrade.setUser_id("1111");
            iGrade.setGrade_id("222222222222222222222222222222222222222222222222222222222222");
//            iGrade.setGrade_id("222");
            iGrade.setGrade_value(98);
            gradeDao.insertGrade(iGrade);

        }catch (Exception ex){
            logger.error(ex.getMessage(),ex);
            throw ex;
        }

        return "SUCCESS";
    }
}
