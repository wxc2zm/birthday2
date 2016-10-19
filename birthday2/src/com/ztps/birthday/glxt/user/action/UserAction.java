package com.ztps.birthday.glxt.user.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import com.ztps.birthday.core.action.BaseAction;
import com.ztps.birthday.core.constant.Constant;
import com.ztps.birthday.glxt.user.entity.User;
import com.ztps.birthday.glxt.user.service.UserService;

public class UserAction extends BaseAction {
	
	private static final long serialVersionUID = 1L;

	@Resource
	private UserService userService;
	
	private User user; //得到传入的值
	private String loginResult;
	
	/**
	 * 跳转到登录页面
	 * @return
	 */
	public String toLoginUI() {
		return "loginUI";
	}
	
	/**
	 * 登录验证
	 * @return
	 */
	public String login() {
		
		if (user != null) {
			if (StringUtils.isNotBlank(user.getAccount()) && StringUtils.isNotBlank(user.getPassword())) {
				//根据用户的帐号和密码查询用户列表
				List<User> list = userService.findUserByAccountAndPassword(user.getAccount(), user.getPassword());
				if (list != null && list.size() > 0) {
					//登录成功
					User user = list.get(0);
					
					String result;
					
					//判断有效性
					if (user.getState().equals("1")) {
						//判断权限
						if (user.getPower().equals("a")) {
							result = "admin"; 	//跳转到客户列表
						} else {
							result = "client";	//跳转到增加客户列表
						}
						//登录用户插入session
						ServletActionContext.getRequest().getSession().setAttribute(Constant.USER, user);
						
						Log log = LogFactory.getLog(getClass());
						log.info("用户名称为：" + user.getAccount() + " 的用户登录了系统。");
						return result;
					} else {
						loginResult = "此账户无效，请联系管理员";
					}
	
				} else {
					loginResult = "用户名或密码错误，请重试！";
				}
			} else {
				loginResult = "用户名或密码不能为空";
			}
		}
		
		return toLoginUI();
	}
	
	//校验用户帐号唯一或存在
	public void verifyAccount() {
		try {
			//1、获取帐号
			if (user != null && StringUtils.isNotBlank(user.getAccount())) {
				//2、根据帐号到数据库中校验是否存在该帐号对应的用户
				List<User> list = userService.findUserByAccount(user.getAccount());
				String strResult = "true";
				if (list != null && list.size() > 0) {
					//说明该帐号已经存在
					strResult = "false";
				}
				//输出
				HttpServletResponse response = ServletActionContext.getResponse();
				response.setContentType("text/html");
				ServletOutputStream outputStream = response.getOutputStream();
				outputStream.write(strResult.getBytes());
				outputStream.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getLoginResult() {
		return loginResult;
	}
	public void setLoginResult(String loginResult) {
		this.loginResult = loginResult;
	}
}
