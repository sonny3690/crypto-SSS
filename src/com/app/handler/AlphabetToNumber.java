package com.app.handler;

import java.util.Random;

import javax.swing.JTextField;

import com.app.frame.Frame;

public class AlphabetToNumber {
	private Frame f;
	private JTextField output;
	private char[] input;

	public AlphabetToNumber(Frame f, JTextField output, char[] pw) {
		this.f = f;
		this.output = output;
		this.input = pw;

		setOutput (encrypt());
	}

	public String encrypt() {
		String returnType = "" ;
		for (int i = 0; i < input.length; i++) {
			char c = input [i];
			if (c >= 97 && c <= 122){
				int x = c - 'a' + 1;
				returnType += x + " ";
			}
		}
		
		return returnType;
	}
	
	public void setOutput(String s) {
		output.setText(s);

	}

}
