package com.app.handler;

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

		for (int i = 0; i < input.length; i++) {
			input[i] = returnType.charAt(i);
		}
		f.setEncrypted_output(input);
		output.setText(returnType);
	}

	public void decrypt(String s, JTextField output)  {
		String temp = s;
		String splited [] = temp.split(" ");
		String returnType = "";
		
		for (int i = 0; i < splited.length; i++){
			char c = (char)((Integer.parseInt(splited[i]) +  'a' - 1));
			returnType += c;
		}
			
		output.setText(returnType);
	}

	public void setOutput(String s) {
		output.setText(s);

	}

}
