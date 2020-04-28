package record.learn.design.observer.bf;

public class Main {

	public static void main(String[] args) {
		BlogUser bu = new BlogUser();
		bu.addObserver(new MyObserver());//将监听器和被监听者关联上
		Article article = new Article("老子是标题", "老子是正文");
		bu.publishBlog(article);
	}
	
}
