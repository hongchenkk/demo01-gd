package com.godink.demo01.model;

public class RecordDto {
    private String paramname; //参数名称
    private String paramtype; //参数类型
    private int length; //参数长度
    private String mustfill; //是否必须
    private String remark; //备注

    public RecordDto() {
    }

    public RecordDto(String paramname, String paramtype, String remark) {
        this.paramname = paramname;
        this.paramtype = paramtype;
        this.remark = remark;
    }
    
    public RecordDto(String paramname, String paramtype, int length, String mustfill, String remark) {
        this.paramname = paramname;
        this.paramtype = paramtype;
        this.length = length;
        this.mustfill = mustfill;
        this.remark = remark;
    }

    public String getParamname() {
        return paramname;
    }

    public void setParamname(String paramname) {
        this.paramname = paramname;
    }

    public String getParamtype() {
        return paramtype;
    }

    public void setParamtype(String paramtype) {
        this.paramtype = paramtype;
    }

    public String getMustfill() {
        return mustfill;
    }

    public void setMustfill(String mustfill) {
        this.mustfill = mustfill;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
}