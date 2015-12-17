package com.im.entity;

import java.util.List;

public class PieChart {
List<String> labels;
List<String> data;
public PieChart(List<String> labels, List<String> data) {
	this.labels = labels;
	this.data = data;
}
public PieChart() {
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
	return "PolicyStatusChart [labels=" + labels + ", data=" + data + "]";
}

}
