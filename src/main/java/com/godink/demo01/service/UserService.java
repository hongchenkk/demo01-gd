package com.godink.demo01.service;

import com.godink.demo01.model.User;

/**
 * 用户服务接口
 * @ClassName: UserService 
 * @author: Hong.Chen
 * @date: 2021年3月30日 上午9:42:30
 */
public interface UserService {
	
	/**
	 * 异步任务1
	 * @author Hong.Chen
	 * @date 2021-03-30 09:45:27  
	 * @param user 
	 * @return void
	 */
	void asyncTask1(User user);
}
