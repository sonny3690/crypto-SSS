package com.app.frame;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.app.handler.AlphabetToNumber;
import com.app.handler.Atbash;
import com.app.handler.CaesarCipher;

public class Frame extends JFrame {

	private JPasswordField input;
	private JTextField output;
	private Font textFieldFont;
	private JComboBox<String> optionSelect;

	private int screenWidth, screenHeight;
	public char [] password;

	// CLASS OBJECTS
	private CaesarCipher c0;
	private Atbash c1;
	private AlphabetToNumber c2;

	private String[] cryptOptions = { "Caesar Cipher", "Atbash Cipher", "Letters To Numbers" };

	public Frame() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setUndecorated(true);
		setLayout(null);
		initialize();
		setVisible(true);
	}

	public void initialize() {

		screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;

		textFieldFont = new Font("Serif", Font.PLAIN, 18);

		input = new JPasswordField(17);
		input.setFont(textFieldFont);
		input.setBounds(screenWidth / 2 - 200 / 2, screenHeight / 2 - 150, 200,
				40);
		input.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				password = input.getPassword();
				//System.out.println(password);
				runCipher(optionSelect.getSelectedIndex());
				}
			}
		);

		this.add(input);

		optionSelect = new JComboBox<String>(cryptOptions);
		optionSelect.setFont(textFieldFont);
		optionSelect.setSelectedIndex(0);
		optionSelect.setBounds(screenWidth / 2 - 200 / 2, screenHeight / 2,
				200, 40);
		optionSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// .showMessageDialog(null, optionSelect.getSelectedItem());
			}
		}

		);

		this.add(optionSelect);

		output = new JTextField(17);
		
		output.setFont(textFieldFont);
		output.setHorizontalAlignment(JTextField.CENTER);
		output.setBounds(screenWidth / 2 - 500 / 2, screenHeight / 2 + 150,
				500, 40);
		// output.add(new JScrollPane());
		output.setEditable(true);
		this.add(output);
	}

	public void runCipher(int i) {
		switch (i) {
		case 0:
			c0 = new CaesarCipher(this, output, password);
			break;
		case 1:
			c1 = new Atbash (this, output, password);
			break;
		case 2:
			c2 = new AlphabetToNumber (this, output, password);
			break;
		}
	}

	public void addPanel(JPanel pane) {
		this.add(pane);
	}

	public void removePane(JPanel pane) {
		this.remove(pane);
	}

	public static void main(String[] args) {
		new Frame();
	}
}
