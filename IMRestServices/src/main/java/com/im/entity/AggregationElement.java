package com.im.entity;

public class AggregationElement {
private String _id;
private String total;


public AggregationElement(String _id, String total) {
	this._id = _id;
	this.total = total;
}

public String getTotal() {
	return total;
}

public void setTotal(String total) {
	this.total = total;
}

public AggregationElement() {
	// TODO Auto-generated constructor stub
}

public String get_id() {
	return _id;
}

public void set_id(String _id) {
	this._id = _id;
}

@Override
public String toString() {
	return "PolicyChart [_id=" + _id + ", total=" + total + "]";
}


}
