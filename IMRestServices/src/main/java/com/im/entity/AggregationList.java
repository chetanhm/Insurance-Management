package com.im.entity;

import java.util.List;

public class AggregationList {
List<String> labels;
List<String> data;
public AggregationList(List<String> labels, List<String> data) {
	this.labels = labels;
	this.data = data;
}
public AggregationList() {
	// TODO Auto-generated constructor stub
}
public List<String> getLabels() {
	return labels;
}
public void setLabels(List<String> labels) {
	this.labels = labels;
}
public List<String> getData() {
	return data;
}
public void setData(List<String> data) {
	this.data = data;
}
@Override
public String toString() {
	return "AggregationList [labels=" + labels + ", data=" + data + "]";
}

}
