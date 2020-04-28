package record.learn.design.builder;

public class Main {
	public static void main(String[] args) {
		MergeInfoBean build = new MergeInfoBean.MergeInfoBeanBuilder()
		.setCacheFlag("1")
        .setDataSourceRelult("2")
        .setDataSourceReturnCode("1")
		.setJiFeiFlag("1")
		.setLdResult("asda")
		.setQueryArams("abad")
		.setTimeCount("123")
		.build();
		System.out.println(build.toString());
	}
}
