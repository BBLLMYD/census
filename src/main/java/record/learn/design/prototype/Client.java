package record.learn.design.prototype;

public class Client {

    public static void main(String[] args) {
        // 1.构建书本对象
        Book book1 = new Book();        
        // 2.编辑书本，添加图片
        book1.setTitle("书1");
        book1.addImage("图1");
        book1.showBook();

        // 以原型文档为原型，拷贝一份副本
        Book book2 = (Book) book1.clone();
        book2.showBook();
        // 修改图书副本，不会影响原始书本
        book2.setTitle("书2");
        book2.showBook();

        // 再次打印原始书本
        book1.showBook();
    }
}
