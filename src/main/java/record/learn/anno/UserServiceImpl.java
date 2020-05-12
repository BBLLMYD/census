package record.learn.anno;

public class UserServiceImpl {
	
	public UserDaoImpl userDao;
	public UserDaoImpl user1Dao;

	// 字段上的注解,可以配置name属性
	@ZxfResource
	public UserDaoImpl user2Dao;

	// set方法上的注解，带有name属性
	@ZxfResource(name = "userDao")
	public void setUserDao(UserDaoImpl userDao) {
		this.userDao = userDao;
	}

	// set方法上的注解，没有配置name属性
	@ZxfResource
	public void setUser1Dao(UserDaoImpl user1Dao) {
		this.user1Dao = user1Dao;
	}

	public void show() {
		userDao.show();
		user1Dao.show();
		user2Dao.show();
		System.out.println("这里是Service方法........");
	}
}
