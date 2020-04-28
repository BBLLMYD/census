package record.learn.design.observer.bf;

import java.util.Observable;

public class BlogUser extends Observable{
	public void publishBlog(Article article){
		System.out.println("博主发表了新的公开文章:"+article.getArticleTitle());
		this.setChanged();
		this.notifyObservers();
	}
}
