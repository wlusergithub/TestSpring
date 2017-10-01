package com.unjlams.mybatis.inter;

import com.unjlams.mybatis.table.Department;
import com.unjlams.mybatis.table.Username;

import java.util.List;

/**
 * Created by UnjlAms on 2017/9/12.
 */
public interface Username2Mapper {

    public Username selectUsername(Integer id);


    public List<Username> leftAssociat();

    public Department selectDepartment(Integer id);

    public List<Department> rightAssociat();

    public List<Username> testIf(Username u);


    public List<Username> testForeach(List<Integer> list);

}
