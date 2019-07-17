package com.trainingbasket.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JCheckBox;
import javax.swing.JTextPane;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import java.awt.Toolkit;

public class LoginPane {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPane window = new LoginPane();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginPane() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\dheeraj-thedev\\eclipse-workspace\\EMS\\src\\tbLogo.png"));
		frame.getContentPane().setBackground(new Color(102, 153, 204));
		frame.getContentPane().setForeground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(209, 56, 312, 74);
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblUserId = new JLabel(" User ID");
		panel.add(lblUserId);
		lblUserId.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 15));
		lblUserId.setForeground(Color.BLACK);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		panel.add(lblPassword);
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 15));
		
		passwordField = new JPasswordField();
		panel.add(passwordField);
		
		JSeparator separator = new JSeparator();
		panel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		panel.add(separator_1);
		
		JButton btnClear = new JButton("Clear");
		panel.add(btnClear);
		
		JButton btnNewButton = new JButton("Login");
		panel.add(btnNewButton);
		
		JLabel lblFdsf = new JLabel("");
		lblFdsf.setHorizontalAlignment(SwingConstants.CENTER);
		lblFdsf.setIcon(new ImageIcon("C:\\Users\\dheeraj-thedev\\eclipse-workspace\\EMS\\src\\lock.png"));
		lblFdsf.setBounds(10, 11, 208, 187);
		frame.getContentPane().add(lblFdsf);
		frame.setBounds(100, 100, 547, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
