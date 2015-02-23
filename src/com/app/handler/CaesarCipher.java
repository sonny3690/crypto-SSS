package com.app.handler;

import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.app.frame.Frame;

public class CaesarCipher {
	private Frame f;
	private JTextField output;
	private char[] input;
	private Random rand;

	public CaesarCipher(Frame f, JTextField output, char[] pw) {
		this.f = f;
		this.output = output;
		this.input = pw;

		rand = new Random();
		setOutput(encrypt(input));
	}

	public String encrypt(char[] chars) {
		
		int shift = getRandomInteger() + 1;
		

		for (int i = 0; i < chars.length; i++) {
			char c = chars[i];
			if (c >= 97 && c <= 122) {
				int x = (c + shift - 19) % 26;

				chars[i] = (char) (x + 'a');

			}
		}
		return new String(chars);
	}

	public void setOutput(String s) {
		output.setText(s);

	}

	public int getRandomInteger() {
		return rand.nextInt(100);
	}

}
