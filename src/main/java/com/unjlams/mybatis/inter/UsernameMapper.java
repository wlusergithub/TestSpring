package com.unjlams.mybatis.inter;

import com.unjlams.mybatis.table.Username;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by UnjlAms on 2017/9/10.
 */
public interface UsernameMapper {

//  Map进行多参数查询
//    public Username getMap(Map<String,Object> map);

//  查询
    public Username getUserById(@Param("id") Integer id);
//  添加
    public void addUsername(Username username);
//  修改
    public void updateUsername(Username username);
//  删除
    public boolean deleteUsername(Integer id);



//  查询多条数据
    public List<Username> getManyUsernmae(String name);

}
