/**
 * Shanice
 * net.hunau.goodsmanager.biz
 * UserBiz.java
 * 创建人:Shanice
 * 时间：2018年12月7日-下午5:10:26 
 * 2018Shanice-版权所有
 */
package net.hunau.goodsmanager.biz;

import net.hunau.goodsmanager.bean.User;
import net.hunau.goodsmanager.dao.UserDao;
import net.hunau.goodsmanager.exception.UserAuthException;

/**
 * 
 * 实现业务逻辑类
 * 实现用户的登录验证
 * UserBiz
 * 创建人:Shanice
 * 时间：2018年12月7日-下午5:10:26 
 * @version 1.0.0
 * 
 */
public class UserBiz {
	
	private UserDao ud;
	
	/**
	 * 初始化
	 * 创建一个新的实例 UserBiz.
	 */
	public UserBiz(){
		ud = new UserDao();                                        
	}
	
	public User login(User user) throws UserAuthException{
		
		User tempUser = ud.getUser(user.getUsername(),user.getPassword());
		
		if(tempUser != null){
			return user;
		}else{
			throw new UserAuthException("用户名或密码错误!!");
		}
	}
	
	public void iscancelUser(String userName,int flag){
		
		User user = ud.getUser(userName); 
		if(user != null){
			user.setValidateFlag(flag);
			ud.updateUsers(user);
		}
	}
	
	/**
	 * 
	 * 测试名称是否正确
	 * 方法名：main
	 * 创建人：Shanice
	 * 时间：2018年12月10日-下午2:22:51 
	 * 手机:15873158820
	 * @param args void
	 * @exception 
	 * @since  1.0.0
	 */
	public static void main(String[] args) {
		UserBiz ub = new UserBiz();
		User user = new User();
		user.setUsername("peter");
		user.setPassword("123456");
		
		try {
			user = ub.login(user);
			System.out.println(user.getRoles());
		} catch (UserAuthException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
