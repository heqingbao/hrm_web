/*
 * Copyright (c) 2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hqb.hrm.dao;

import com.hqb.hrm.dao.provider.DeptDynaSqlProvider;
import com.hqb.hrm.domain.Dept;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

import static com.hqb.hrm.util.common.HrmConstants.TABLE_DEPT;

/**
 * Created by heqingbao on 2017/9/8.
 */
public interface DeptDao {

    // 动态查询
    @SelectProvider(type = DeptDynaSqlProvider.class, method = "selectWhitParam")
    List<Dept> selectByPage(Map<String, Object> params);

    @SelectProvider(type = DeptDynaSqlProvider.class, method = "count")
    Integer count(Map<String, Object> params);

    @Select("select * from " + TABLE_DEPT + " ")
    List<Dept> selectAllDept();

    @Select("select * from " + TABLE_DEPT + " where ID = #{id}")
    Dept selectById(int id);

    // 根据id删除部门
    @Delete(" delete from " + TABLE_DEPT + " where id = #{id} ")
    void deleteById(Integer id);

    // 动态插入部门
    @SelectProvider(type = DeptDynaSqlProvider.class, method = "insertDept")
    void save(Dept dept);

    // 动态修改用户
    @SelectProvider(type = DeptDynaSqlProvider.class, method = "updateDept")
    void update(Dept dept);
}
