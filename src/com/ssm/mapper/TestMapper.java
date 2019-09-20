package com.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.ssm.pojo.Test;

public interface TestMapper {
	/**
	 * 查询全部
	 * 
	 * @return
	 */
	@Select("select * from test") // 使用注解进行SQL语句的编写，相比使用Mapper文件来的简单一些
	List<Test> selectAll();

	/**
	 * 根据id值查询
	 * 
	 * @param id 传入的id值
	 * @return
	 */
	Test selectById(int id);

	/**
	 * 根据姓名查询
	 * 
	 * @param test 传入对象
	 * @return
	 */
	@Select("select * from test where name=#{name}")
	Test selectByName(Test test);

	/**
	 * 根据姓名删除
	 * 
	 * @param name 传入的name值
	 * @return
	 */
	int deleteByName(String name);

	/**
	 * 根据id对指定记录进行更新
	 * 
	 * @param id 传入的id值
	 * @return
	 */
	int updateById(Test test);

	/**
	 * 新增记录
	 * 
	 * @param test 传入的待插入对象值
	 * @return
	 */
	int insertNew(Test test);
}
