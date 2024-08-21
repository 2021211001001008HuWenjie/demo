package com.rabbiter.association.service;


import com.rabbiter.association.entity.Users_Hom;
import com.rabbiter.association.msg.PageData;

import com.rabbiter.association.entity.Users;

/**
 * 业务层处理
 * 系统用户
 */
public interface UsersService extends BaseService<Users, String> {

	/**
	 * 检查指定的用户是否可以删除
	 * 当用户不是社团成员可以进行删除
	 * @param userId 用户ID
	 * @return
	 */
	public Boolean isRemove(String userId);

	/**
	 * 依据用户名获取用户信息
	 * @param userName 用户账号
	 * @return
	 */
	public Users getUserByUserName(String userName);

	/**
	 * 鸿蒙系统依据用户名获取用户信息
	 * @param userName 用户账号
	 * @return
	 */
	public Users_Hom getUserByUserName_Hom(String userName);

	/**
	 * 分页查询系统用户信息
	 * @param pageIndex 当前页码
	 * @param pageSize 每页数据量
	 * @param users 模糊查询条件
	 * @return
	 */	
	public PageData getPageInfo(Long pageIndex, Long pageSize, Users users);

	/**
	 * 鸿蒙特供根据token获取到的id拿到Users_Hom
	 * 后端可以实现，但是传回前端莫名其妙被截断了，用下面的方法
	 * @return
	 */
	public Users_Hom getOne_Hom(String userId);

	/**
	 * 鸿蒙特供根据token获取到的id拿到头像链接Url
	 * @return
	 */
	public String getAvatar_Hom(String userId);

	public void  addUserAvatar_Hom(String userId);
}