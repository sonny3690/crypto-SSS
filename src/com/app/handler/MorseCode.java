package com.app.handler;

import java.util.Random;

import javax.swing.JTextField;

import com.app.frame.Frame;

public class MorseCode {

	private JTextField output;

	private Frame f;

	public MorseCode(Frame f, JTextField output) {
		this.f = f;
		this.output = output;

	}

	public void encrypt(char[] chars, JTextField output) {

		String returnVal = "";

		for (int i = 0; i < chars.length; i++) {
			switch (chars[i]) {
			case 'a':
				returnVal += ".-";
				break;
			case 'b':
				returnVal += "-...";
				break;
			case 'c':
				returnVal += "-.-.";
				break;
			case 'd':
				returnVal += "-..";
				break;
			case 'e':
				returnVal += ".";
				break;
			case 'f':
				returnVal += "..-.";
				break;
			case 'g':
				returnVal += "--.";
				break;
			case 'h':
				returnVal += "....";
				break;
			case 'j':
				returnVal += ".---";
				break;
			case 'k':
				returnVal += "-.-";
				break;
			case 'l':
				returnVal += ".-..";
				break;
			case 'm':
				returnVal += "--";
				break;
			case 'n':
				returnVal += "-.";
				break;
			case 'o':
				returnVal += "---";
				break;
			case 'p':
				returnVal += ".--.";
				break;
			case 'q':
				returnVal += "--.-";
				break;
			case 'r':
				returnVal += ".-.";
				break;
			case 's':
				returnVal += "...";
				break;
			case 't':
				returnVal += "-";
				break;
			case 'u':
				returnVal += "..-";
				break;
			case 'v':
				returnVal += "...-";
				break;
			case 'w':
				returnVal += ".--";
				break;
			case 'x':
				returnVal += "-..-";
				break;
			case 'y':
				returnVal += "-.--";
				break;
			case 'z':
				returnVal += "--..";
				break;
			default:
				break;
			}
			returnVal += " ";
		}
		output.setText(returnVal);
	}

	public void setOutput(String s) {
		output.setText(s);
	}

}
