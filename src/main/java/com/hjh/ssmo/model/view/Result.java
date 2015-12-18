package com.hjh.ssmo.model.view;

import com.hjh.ssmo.util.config.CompositeFactory;

/**
 * 操作处理结果
 * 
 * @author haojiahong
 * 
 * @createtime：2015-12-18 上午9:10:08
 * 
 * 
 */
public class Result {

	// 操作结果
	private String resultCode;

	// 返回前台信息
	private String info;

	// 附属对象
	private Object object;

	public Result(String resultCode, String info) {
		super();
		this.resultCode = resultCode;
		this.info = CompositeFactory.getString(info);
	}

	public Result(String resultCode, String errorInfo, Object object) {
		super();
		this.resultCode = resultCode;
		this.info = CompositeFactory.getString(errorInfo);
		this.object = object;
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

}
