package com.app.handler;

import java.util.Arrays;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.app.frame.Frame;

public class Bruteforce {

	private Frame frame;
	private JTextField output;
	private String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	private Random rand;
	private int givenLength = 0;
	private String temp;
	private boolean passwordFound = false;
	
	private long startTime = 0;
	private long timer = 0;
	
	
	private int counter = 1;
	
	public Bruteforce(Frame frame, JTextField output) {
		this.frame = frame;
		this.output = output;

		rand = new Random();
		

	}

	public void start(char pws[]) {
		setGivenLength(pws.length);
		temp = "";
		startTime = System.currentTimeMillis();
		while (!passwordFound) {
			temp = "";
			for (int i = 0; i < givenLength; i++) {
				temp += alphabet.charAt(getNumber());
			}
			
			updateTimer();
			System.out.println (String.format("Trial #%d: '%s' at %d milliseconds", counter,temp, timer));
			
			
			if (Arrays.equals (pws, temp.toCharArray())){
				passwordFound = true;
				updateTimer ();
				System.out.println (String.format("PASSWORD FOUND: %s after $d trials at %d milliseconds", temp.toString(), counter, timer));
			}else{
				counter ++;
			}
			
		}
	}

	public void setGivenLength(int i ) {
		//givenLength = rand.nextInt(9) + 1;
		givenLength = i;
	}
	
	public int getNumber (){
		return rand.nextInt(alphabet.length());
	}
	
	public void updateTimer (){
		timer = System.currentTimeMillis()-startTime;
	}

}
