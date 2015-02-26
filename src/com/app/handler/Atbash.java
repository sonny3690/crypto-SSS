package com.app.handler;

import javax.swing.JTextField;

import com.app.frame.Frame;

public class Atbash {

	private Frame f;
	private JTextField output;

	public Atbash(Frame f, JTextField output) {
		this.f = f;
		this.output = output;

	}

	public void encrypt(char[] input, JTextField output) {
		String returnType = "";
		for (int i = 0; i < input.length; i++) {
			char c = input[i];
			if (c >= 97 && c <= 122) {
				int x = 'z' - (c - 'a');
				returnType += (char) (x);
			}
		}
		output.setText(returnType);
	}

	public void setOutput(String s) {
		output.setText(s);

	}

}
