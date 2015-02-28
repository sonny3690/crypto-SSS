package com.app.handler;

import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.app.frame.Frame;

public class CaesarCipher {
	private Frame f;
	private JTextField output;
	private Random rand;

	public CaesarCipher(Frame f, JTextField output) {
		this.f = f;
		this.output = output;

		rand = new Random();
	}

	public void encrypt(char[] chars, JTextField output, int shift) {
		if (shift < 0)
			shift = getRandomInteger() + 1;
		for (int i = 0; i < chars.length; i++) {
			char c = chars[i];
			if (c >= 97 && c <= 122) {
				int x = (c + shift - 19) % 26;
				chars[i] = (char) (x + 'a');
			}
		}
		f.setEncrypted_output(chars);
		output.setText(new String(chars));
	}

	public void decrypt(char[] chars, JTextField output, int shift) {
		if (shift == -1) {
			JOptionPane.showMessageDialog(f, "Please Select a Valid Key");
			return;
		}

		for (int i = 0; i < chars.length; i++) {
			char c = chars[i];

			if (c != ' ') {
				int x = (c - shift - 19) % 26;
				chars[i] = (char) (x + 'a');
			}else {
				chars[i] = ' ';
			}

		}

		output.setText(new String(chars));

	}

	public void setOutput(String s) {
		output.setText(s);

	}

	public int getRandomInteger() {
		return rand.nextInt(100);
	}

}
