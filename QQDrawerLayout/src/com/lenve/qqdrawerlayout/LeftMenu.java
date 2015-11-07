package com.lenve.qqdrawerlayout;

public class LeftMenu {

	private int imageView;
	private String text;

	public int getImageView() {
		return imageView;
	}

	public void setImageView(int imageView) {
		this.imageView = imageView;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public LeftMenu(int imageView, String text) {
		this.imageView = imageView;
		this.text = text;
	}

	public LeftMenu() {
	}

}
