package record.learn.design.builder;

import java.util.Map;

/**
 * 合并信息的对象
 * 
 * @author xuxiaojia
 */
public class MergeInfoBean {
	/*
	 * 公共信息的map集合 funcode、merid。。。。
	 */
	private Map<String, String> commonInfoMap;
	/*
	 * 请求参数
	 */
	private String queryArams;
	/*
	 * 数据源返回码
	 */
	private String dataSourceReturnCode;
	/*
	 * 数据源返回结果
	 */
	private String dataSourceRelult;
	/*
	 * 联动转码结果
	 */
	private String ldResult;
	/*
	 * 计费标识
	 */
	private String jiFeiFlag;
	/*
	 * 缓存标识
	 */
	private String cacheFlag;
	/*
	 * 耗时
	 */
	private String timeCount;

	public Map<String, String> getCommonInfoMap() {
		return commonInfoMap;
	}

	public void setCommonInfoMap(Map<String, String> commonInfoMap) {
		this.commonInfoMap = commonInfoMap;
	}

	public String getQueryArams() {
		return queryArams;
	}

	public void setQueryArams(String queryArams) {
		this.queryArams = queryArams;
	}

	public String getDataSourceReturnCode() {
		return dataSourceReturnCode;
	}

	public void setDataSourceReturnCode(String dataSourceReturnCode) {
		this.dataSourceReturnCode = dataSourceReturnCode;
	}

	public String getDataSourceRelult() {
		return dataSourceRelult;
	}

	public void setDataSourceRelult(String dataSourceRelult) {
		this.dataSourceRelult = dataSourceRelult;
	}

	public String getLdResult() {
		return ldResult;
	}

	public void setLdResult(String ldResult) {
		this.ldResult = ldResult;
	}

	public String getJiFeiFlag() {
		return jiFeiFlag;
	}

	public void setJiFeiFlag(String jiFeiFlag) {
		this.jiFeiFlag = jiFeiFlag;
	}

	public String getCacheFlag() {
		return cacheFlag;
	}

	public void setCacheFlag(String cacheFlag) {
		this.cacheFlag = cacheFlag;
	}

	public String getTimeCount() {
		return timeCount;
	}

	public void setTimeCount(String timeCount) {
		this.timeCount = timeCount;
	}

	public MergeInfoBean(MergeInfoBeanBuilder builder) {
		this.commonInfoMap = builder.commonInfoMap;
		this.queryArams = builder.queryArams;
		this.dataSourceReturnCode = builder.dataSourceReturnCode;
		this.dataSourceRelult = builder.dataSourceRelult;
		this.ldResult = builder.ldResult;
		this.jiFeiFlag = builder.jiFeiFlag;
		this.cacheFlag = builder.cacheFlag;
		this.timeCount = builder.timeCount;
	}

	public static class MergeInfoBeanBuilder {
		/*
		 * 公共信息的map集合 funcode、merid。。。。
		 */
		private Map<String, String> commonInfoMap;
		/*
		 * 请求参数
		 */
		private String queryArams;
		/*
		 * 数据源返回码
		 */
		private String dataSourceReturnCode;
		/*
		 * 数据源返回结果
		 */
		private String dataSourceRelult;
		/*
		 * 联动转码结果
		 */
		private String ldResult;
		/*
		 * 计费标识
		 */
		private String jiFeiFlag;
		/*
		 * 缓存标识
		 */
		private String cacheFlag;
		/*
		 * 耗时
		 */
		private String timeCount;

		public MergeInfoBeanBuilder setCommonInfoMap(Map<String, String> commonInfoMap) {
			this.commonInfoMap = commonInfoMap;
			return this;
		}

		public MergeInfoBeanBuilder setQueryArams(String queryArams) {
			this.queryArams = queryArams;
			return this;
		}

		public MergeInfoBeanBuilder setDataSourceReturnCode(String dataSourceReturnCode) {
			this.dataSourceReturnCode = dataSourceReturnCode;
			return this;
		}

		public MergeInfoBeanBuilder setDataSourceRelult(String dataSourceRelult) {
			this.dataSourceRelult = dataSourceRelult;
			return this;
		}

		public MergeInfoBeanBuilder setLdResult(String ldResult) {
			this.ldResult = ldResult;
			return this;
		}

		public MergeInfoBeanBuilder setJiFeiFlag(String jiFeiFlag) {
			this.jiFeiFlag = jiFeiFlag;
			return this;
		}

		public MergeInfoBeanBuilder setCacheFlag(String cacheFlag) {
			this.cacheFlag = cacheFlag;
			return this;
		}

		public MergeInfoBeanBuilder setTimeCount(String timeCount) {
			this.timeCount = timeCount;
			return this;
		}

		public MergeInfoBean build() {
			return new MergeInfoBean(this);
		}

	}

	@Override
	public String toString() {
		return "MergeInfoBean [commonInfoMap=" + commonInfoMap + ", queryArams=" + queryArams
				+ ", dataSourceReturnCode=" + dataSourceReturnCode + ", dataSourceRelult=" + dataSourceRelult
				+ ", ldResult=" + ldResult + ", jiFeiFlag=" + jiFeiFlag + ", cacheFlag=" + cacheFlag + ", timeCount="
				+ timeCount + "]";
	}

}
