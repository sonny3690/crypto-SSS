package com.app.frame;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

import com.app.handler.AlphabetToNumber;
import com.app.handler.Atbash;
import com.app.handler.CaesarCipher;
import com.app.handler.MorseCode;

public class Frame extends JFrame {

	// GUI Variables
	private JPasswordField input;
	private JTextField output, eInput, keyField;
	private Font textFieldFont;
	private Font titleFont;
	private JComboBox<String> optionSelect;
	private JLabel encryptLabel, decryptLabel;
	private JButton inputButton, eInputButton;

	private int screenWidth, screenHeight;
	public char[] password;

	// CLASS OBJECTS
	private CaesarCipher c0;
	private Atbash c1;
	private AlphabetToNumber c2;
	private MorseCode c3;

	private String[] cryptOptions = { "Caesar Cipher", "Atbash Cipher",
			"Letters To Numbers", "Morse Code" };

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
		screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width / 2;
		screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
		textFieldFont = new Font("Comic Sans", Font.PLAIN, 18);
		titleFont = new Font("Times New Roman", Font.BOLD, 50);

		setLabels();
		setClasses();
		// INPUT PASSWORDFIELD
		input = new JPasswordField(17);
		input.setFont(textFieldFont);
		input.setBounds(screenWidth / 2 - 220 / 2, screenHeight / 2 - 150, 200,
				40);
		input.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				password = input.getPassword();
				// System.out.println(password);
				encrypt(optionSelect.getSelectedIndex());
			}
		});
		this.add(input);

		// INPUT BUTTON
		inputButton = new JButton("Enter");
		inputButton.setFont(textFieldFont);
		inputButton.setBounds(screenWidth / 2 + 110, screenHeight / 2 - 150,
				80, 40);
		inputButton.setToolTipText("Click to encode your password!");
		inputButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				password = input.getPassword();
				encrypt(optionSelect.getSelectedIndex());
			}
		});
		this.add(inputButton);

		// EINPUT BUTTON
		eInputButton = new JButton("Enter");
		eInputButton.setFont(textFieldFont);
		eInputButton.setBounds(screenWidth * 2 - 250, screenHeight / 2 - 150,
				80, 40);
		eInputButton.setToolTipText("Click to encode your password!");
		eInputButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		this.add(eInputButton);

		// OPTION SELECT COMBOBOX
		optionSelect = new JComboBox<String>(cryptOptions);
		optionSelect.setFont(textFieldFont);
		optionSelect.setSelectedIndex(0);
		optionSelect.setBounds(screenWidth / 2 - 200 / 2, screenHeight / 2,
				200, 40);
		optionSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				output.setText("");
				if (optionSelect.getSelectedIndex() >=2 ) {
					keyField.setVisible(false);
				}else {
					keyField.setVisible(true);
				}
			}
		});
		this.add(optionSelect);

		setTextFields();

		// Decryption Output Select Combobox

	}

	public void setLabels() {
		// ENCRYPT LABEL
		encryptLabel = new JLabel("Encrypt");
		encryptLabel.setFont(titleFont);
		encryptLabel.setBounds(screenWidth / 2 - 100, screenHeight / 2 - 320,
				200, 60);
		this.add(encryptLabel);
		encryptLabel.setVisible(true);

		// DECRYPT LABELS
		decryptLabel = new JLabel("Decrypt");
		decryptLabel.setFont(titleFont);
		decryptLabel.setBounds(screenWidth / 2 + 500, screenHeight / 2 - 320,
				200, 60);
		this.add(decryptLabel);
		decryptLabel.setVisible(true);
	}

	public void setClasses() {
		c0 = new CaesarCipher(this, output);
		c1 = new Atbash(this, output);
		c2 = new AlphabetToNumber(this, output);
		c3 = new MorseCode(this, output);
	}

	public void setTextFields() {
		// ENCRYPTION OUTPUT TEXTFIELD
		output = new JTextField(17);
		output.setFont(textFieldFont);
		output.setHorizontalAlignment(JTextField.CENTER);
		output.setBounds(screenWidth / 2 - 500 / 2, screenHeight / 2 + 150,
				500, 40);
		output.setEditable(false);
		this.add(output);

		// DECRYPTION INPUT TEXTFIELD
		eInput = new JTextField(50);
		eInput.setFont(textFieldFont);
		eInput.setHorizontalAlignment(JTextField.CENTER);
		eInput.setBounds(screenWidth / 2 + 450, screenHeight / 2 - 150, 300, 40);
		eInput.setVisible(true);
		this.add(eInput);

		keyField = new JTextField("KEY", 4);
		keyField.setFont(new Font("Serif", Font.ITALIC, 10));
		keyField.setHorizontalAlignment(JTextField.CENTER);
		keyField.setBounds(screenWidth / 2 + 120, screenHeight / 2, 40, 40);
		keyField.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				keyField.setText("");
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
			}

			@Override
			public void mouseExited(MouseEvent arg0) {

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

		});
		keyField.setVisible(true);
		this.add(keyField);

	}

	public void encrypt(int i) {
		switch (i) {
		case 0:
			c0.encrypt(password, output); // CAESAR CIPHER
			break;
		case 1:
			c1.encrypt(password, output); // ATBASH
			break;
		case 2:
			c2.encrypt(password, output);// ALPHA-NUMERO
			break;
		case 3:
			c3.encrypt(password, output); // MORSE CODE
			break;
		}

	}

	public static void setUI() {
		// sets up nimbus look and feel
		try {
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			System.err.println("UI ERROR");
		}
	}

	public static void main(String[] args) {
		setUI(); // set user interface
		new Frame(); // start application

	}
}
