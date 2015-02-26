package com.app.handler;

import java.util.Random;

import javax.swing.JTextField;

import com.app.frame.Frame;

public class AlphabetToNumber {
	private Frame f;
	private JTextField output;

	public AlphabetToNumber(Frame f, JTextField output) {
		this.f = f;
		this.output = output;
	}

	public void encrypt(char[] input, JTextField output) {
		String returnType = "";
		for (int i = 0; i < input.length; i++) {
			char c = input[i];
			if (c >= 97 && c <= 122) {
				int x = c - 'a' + 1;
				returnType += x + " ";
			}
		}

		output.setText(returnType);
	}

	public void setOutput(String s) {
		output.setText(s);

	}

}
