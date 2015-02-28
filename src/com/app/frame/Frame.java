package com.app.frame;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

import com.app.handler.AlphabetToNumber;
import com.app.handler.Atbash;
import com.app.handler.Bruteforce;
import com.app.handler.CaesarCipher;
import com.app.handler.MorseCode;

public class Frame extends JFrame {

	private static final long serialVersionUID = -7354839013235461915L;

	// GUI Variables
	private JPasswordField input, pwCheck;
	private JTextField output, eInput, keyField, eKeyField, eOutput;
	private Font textFieldFont;
	private Font titleFont;
	private JComboBox<String> optionSelect, eOptionSelect;
	private JLabel encryptLabel, decryptLabel, enterLabel;
	private JButton inputButton, eInputButton, clearAll;

	private int screenWidth, screenHeight;
	public char[] password;
	private char[] encrypted_output;

	// CLASS OBJECTS
	private CaesarCipher c0;
	private Atbash c1;
	private AlphabetToNumber c2;
	private MorseCode c3;
	private Bruteforce c4;

	// CLASS INDEX
	private String[] cryptOptions = { "Caesar Cipher", "Atbash Cipher",
			"Letters To Numbers", "Morse Code" };
	private String[] eCryptOptions = { "Caesar Cipher", "Atbash Cipher",
			"Letters To Numbers", "Morse Code", "BRUTEFORCE" };

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
		input.setBounds(screenWidth / 2 - 200, screenHeight / 2 - 150, 300,
				40);
		input.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				password = input.getPassword();
				// System.out.println(password);
				encrypt(optionSelect.getSelectedIndex(), keyField.getText());
			}
		});
		this.add(input);

		pwCheck = new JPasswordField(17);
		pwCheck.setFont(textFieldFont);
		pwCheck.setBounds(screenWidth - 300, screenHeight - 50, 600, 40);
		pwCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (input.getPassword() != null
						&& pwCheck.getPassword() != null
						&& Arrays.equals(input.getPassword(),
								pwCheck.getPassword())) {
					accessPanel(true);

				} else {
					accessPanel(false);

				}
				;
				// System.out.println(password);
			}
		});
		this.add(pwCheck);

		setButtons();
		setOptions();
		setTextFields();

	}

	public void encrypt(int i, String s) {
		int key;
		try {
			key = Integer.parseInt(s);
		} catch (Exception e) {
			key = -1;
		}

		switch (i) {
		case 0:
			c0.encrypt(password, output, key); // CAESAR CIPHER
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

	public void decrypt(int i, int shift) {
		try {
			switch (i) {
			case 0:
				c0.decrypt(encrypted_output, eOutput, shift); // CAESAR CIPHER
				break;
			case 1:
				c1.decrypt(encrypted_output, eOutput); // ATBASH
				break;
			case 2:
				c2.decrypt(eInput.getText(), eOutput);// ALPHA-NUMERO
				break;
			case 3:
				c3.decrypt(eInput.getText(), eOutput); // MORSE CODE
				break;
			case 4:
				c4.start(input.getPassword()); // BRUTE FORCE!!!
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Invalid Input");
		}

	}

	public void accessPanel(boolean x) {
		if (x && encrypted_output.length > 1) {
			JOptionPane.showMessageDialog(this,
					"Access Granted! \nThe Secret is, I Like IceCream");
		} else {
			JOptionPane.showMessageDialog(this, "Access Denied!");
		}
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
		decryptLabel.setBounds(3*screenWidth/2-100 , screenHeight / 2 - 320,
				200, 60);
		this.add(decryptLabel);
		decryptLabel.setVisible(true);

		enterLabel = new JLabel("Enter the Password!");
		enterLabel.setFont(titleFont);
		enterLabel.setBounds(screenWidth-200, screenHeight - 130, 600, 40);
		enterLabel.setVisible(true);
		this.add(enterLabel);
	}

	public void setClasses() {
		c0 = new CaesarCipher(this, output);
		c1 = new Atbash(this, output);
		c2 = new AlphabetToNumber(this, output);
		c3 = new MorseCode(this, output);
		c4 = new Bruteforce(this, output);
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
		eInput.setBounds(screenWidth / 2 + 460, screenHeight / 2 - 150, 300, 40);
		eInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// System.out.println(password);
				encrypted_output = eInput.getText().toCharArray();
				try {
					decrypt(eOptionSelect.getSelectedIndex(),
							Integer.parseInt(eKeyField.getText()));
				} catch (NumberFormatException n) {
					decrypt(eOptionSelect.getSelectedIndex(), -1);
				}
			}
		});
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

		eKeyField = new JTextField("KEY", 4);
		eKeyField.setFont(new Font("Serif", Font.ITALIC, 10));
		eKeyField.setHorizontalAlignment(JTextField.CENTER);
		eKeyField.setBounds(eOptionSelect.getX()
				+ eOptionSelect.getSize().width + 75, eOptionSelect.getY(), 40,
				40);
		eKeyField.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				eKeyField.setText("");
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
		eKeyField.setVisible(true);
		this.add(eKeyField);

		eOutput = new JTextField(50);
		eOutput.setFont(textFieldFont);
		eOutput.setHorizontalAlignment(JTextField.CENTER);
		eOutput.setBounds(screenWidth+85, screenHeight / 2 + 150, 500,
				40);
		eOutput.setVisible(true);
		this.add(eOutput);

	}

	public void setOptions() {
		// OPTION SELECT COMBOBOX
		optionSelect = new JComboBox<String>(cryptOptions);
		optionSelect.setFont(textFieldFont);
		optionSelect.setSelectedIndex(0);
		optionSelect.setBounds(screenWidth / 2 - 170, screenHeight / 2,
				200, 40);
		optionSelect.setToolTipText("Set Encrypting Options...");
		optionSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				output.setText("");
				if (optionSelect.getSelectedIndex() >= 1) {
					keyField.setVisible(false);
				} else {
					keyField.setVisible(true);
				}
			}
		});
		this.add(optionSelect);

		// ENCRYPTION OPTION SELECT COMBOBOX
		eOptionSelect = new JComboBox<String>(eCryptOptions);
		eOptionSelect.setFont(textFieldFont);
		eOptionSelect.setSelectedIndex(0);
		eOptionSelect.setToolTipText("Set Decrypting Options...");
		eOptionSelect.setBounds(screenWidth + 170, screenHeight / 2, 200, 40);
		eOptionSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eOutput.setText("");
				if (eOptionSelect.getSelectedIndex() >= 1) {
					eKeyField.setVisible(false);
				} else {
					eKeyField.setVisible(true);
				}
			}
		});
		this.add(eOptionSelect);

	}

	public void setButtons() {
		// INPUT BUTTON
		inputButton = new JButton("Enter");
		inputButton.setFont(textFieldFont);
		inputButton.setBounds(screenWidth / 2 + 110, screenHeight / 2 - 150,
				80, 40);
		inputButton.setToolTipText("Click to encode your password!");
		inputButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				password = input.getPassword();
				encrypt(optionSelect.getSelectedIndex(), keyField.getText());
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
				encrypted_output = eInput.getText().toCharArray();
				try {
					decrypt(eOptionSelect.getSelectedIndex(),
							Integer.parseInt(eKeyField.getText()));
				} catch (NumberFormatException n) {
					decrypt(eOptionSelect.getSelectedIndex(), -1);
				}

			}
		});
		this.add(eInputButton);

		clearAll = new JButton("Clear");
		clearAll.setFont(textFieldFont);
		clearAll.setBounds(screenWidth * 2 - 120, screenHeight - 80, 80, 40);
		clearAll.setToolTipText("Clear All Textboxes");
		this.add(clearAll);
		clearAll.setVisible(true);
		clearAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eInput.setText("");
				output.setText("");
				keyField.setText("");
				eKeyField.setText("");
				eOutput.setText("");
				input.setText("");
				pwCheck.setText("");

			}
		});

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

	public char[] getEncrypted_output() {
		return encrypted_output;
	}

	public void setEncrypted_output(char[] encrypted_output) {
		this.encrypted_output = encrypted_output;
	}
}
