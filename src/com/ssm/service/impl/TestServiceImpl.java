package com.ssm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.mapper.TestMapper;
import com.ssm.pojo.Test;
import com.ssm.service.TestService;

@Service // 服务层注解
public class TestServiceImpl implements TestService {
	@Resource
	private TestMapper testMapper;

	@Override
	public List<Test> selectAll() {
		return testMapper.selectAll();
	}

	@Override
	public Test selectById(int id) {
		return testMapper.selectById(id);
	}

	@Override
	public Test selectByName(Test test) {
		return testMapper.selectByName(test);
	}

	@Override
	public int deleteByName(String name) {
		return testMapper.deleteByName(name);
	}

	@Override
	public int updateById(Test test) {
		return testMapper.updateById(test);
	}

	@Override
	public int insertNew(Test test) {
		return testMapper.insertNew(test);
	}

}
