package com.app.handler;

import java.util.Random;

import javax.swing.JOptionPane;
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
			case 'i':
				returnVal += "..";
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
		f.setEncrypted_output(chars);
		output.setText(returnVal);
	}

	public void decrypt (String s, JTextField output){
		String temp [] = s.split(" ");
		String returnVal = "";
		
		for (int i = 0; i< temp.length; i++){
			switch (temp[i]) {
			case ".-":
				returnVal += 'a';
				break;
			case "-...":
				returnVal += 'b';
				break;
			case "-.-.":
				returnVal += 'c';
				break;
			case "-..":
				returnVal += 'd';
				break;
			case ".":
				returnVal += 'e';
				break;
			case "..-.":
				returnVal += 'f';
				break;
			case "--.":
				returnVal += 'g';
				break;
			case "....":
				returnVal += 'h';
				break;
			case "..":
				returnVal += 'i';
				break;
			case ".---":
				returnVal += 'j';
				break;
			case "-.-":
				returnVal += 'k';
				break;
			case ".-..":
				returnVal += 'l';
				break;
			case "--":
				returnVal += 'm' ;
				break;
			case "-.":
				returnVal += 'n';
				break;
			case "---":
				returnVal += 'o';
				break;
			case ".--.":
				returnVal += 'p';
				break;
			case "--.-":
				returnVal += 'q';
				break;
			case ".-.":
				returnVal += 'r';
				break;
			case "...":
				returnVal += 's';
				break;
			case "-":
				returnVal += 't';
				break;
			case "..-":
				returnVal += 'u';
				break;
			case "...-":
				returnVal += 'v';
				break;
			case ".--":
				returnVal += 'w';
				break;
			case "-..-":
				returnVal += 'x';
				break;
			case "-.--":
				returnVal += 'y';
				break;
			case "--..":
				returnVal += 'z' ;
				break;
			case " ":
				returnVal += ' ';
				break;
			default:
				break;
			}
		}
		output.setText(returnVal);
	}
	
	
	public void setOutput(String s) {
		output.setText(s);
	}

}
