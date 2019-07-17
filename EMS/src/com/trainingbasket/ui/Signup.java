package com.trainingbasket.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import java.awt.SystemColor;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.border.BevelBorder;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.border.EmptyBorder;
import javax.swing.JSeparator;
import javax.swing.JRadioButton;
import java.awt.Toolkit;
import javax.swing.ListSelectionModel;

public class Signup {

	public JFrame frame;
	private JTextField txtName;
	private JTextField txtAge;
	private JTextField contactNumber;
	private JTextField txtAddress;
	private JTextField txtUserId;
	private JTextField txtPassword;
	private JTextField txtEmail;
	private JTable table;

	public static DefaultTableModel buildTableModel(ResultSet rs) throws SQLException {

		ResultSetMetaData metaData = rs.getMetaData();

		// names of columns
		Vector<String> columnNames = new Vector<String>();
		int columnCount = metaData.getColumnCount();
		for (int column = 1; column <= columnCount; column++) {
			columnNames.add(metaData.getColumnName(column));
		}
		// data of the table
		Vector<Vector<Object>> data = new Vector<Vector<Object>>();
		while (rs.next()) {
			Vector<Object> vector = new Vector<Object>();
			for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
				vector.add(rs.getObject(columnIndex));
			}
			data.add(vector);
		}
		return new DefaultTableModel(data, columnNames);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Signup window = new Signup();
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
	public Signup() {
		initialize();
		try {
			Connection cn = ConnectionUtils.getConnection();
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("select * from student_details;");
			frame.getContentPane().setLayout(null);
			
			JPanel panel = new JPanel();
			panel.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 153, 204), new Color(102, 153, 204), new Color(102, 153, 204), new Color(102, 153, 204)));
			panel.setBounds(190, 84, 364, 209);
			frame.getContentPane().add(panel);
			panel.setLayout(new GridLayout(0, 2, 0, 0));
			
			JLabel lblUserId = new JLabel("User Id");
			lblUserId.setHorizontalAlignment(SwingConstants.LEFT);
			lblUserId.setFont(new Font("Consolas", Font.PLAIN, 14));
			lblUserId.setForeground(Color.BLACK);
			panel.add(lblUserId);
			
			txtUserId = new JTextField();
			txtUserId.setHorizontalAlignment(SwingConstants.CENTER);
			txtUserId.setText("Will Generate After You Save");
			panel.add(txtUserId);
			txtUserId.setColumns(10);
			
			JLabel lblName = new JLabel("Name");
			lblName.setHorizontalAlignment(SwingConstants.LEFT);
			lblName.setFont(new Font("Consolas", Font.PLAIN, 14));
			lblName.setForeground(Color.BLACK);
			panel.add(lblName);
			
			txtName = new JTextField();
			panel.add(txtName);
			txtName.setColumns(10);
			
			JLabel lblAge = new JLabel("Age");
			lblAge.setHorizontalAlignment(SwingConstants.LEFT);
			lblAge.setFont(new Font("Consolas", Font.PLAIN, 14));
			lblAge.setForeground(Color.BLACK);
			panel.add(lblAge);
			
			txtAge = new JTextField();
			panel.add(txtAge);
			txtAge.setColumns(10);
			
			JLabel lblContactNumber = new JLabel("Contact Number");
			lblContactNumber.setHorizontalAlignment(SwingConstants.LEFT);
			lblContactNumber.setFont(new Font("Consolas", Font.PLAIN, 14));
			lblContactNumber.setForeground(Color.BLACK);
			panel.add(lblContactNumber);
			
			contactNumber = new JTextField();
			panel.add(contactNumber);
			contactNumber.setColumns(10);
			
			JLabel lblAddress = new JLabel("Address");
			lblAddress.setHorizontalAlignment(SwingConstants.LEFT);
			lblAddress.setFont(new Font("Consolas", Font.PLAIN, 14));
			lblAddress.setForeground(Color.BLACK);
			panel.add(lblAddress);
			
			txtAddress = new JTextField();
			panel.add(txtAddress);
			txtAddress.setColumns(10);
			
			JLabel lblPassword = new JLabel("Password");
			lblPassword.setHorizontalAlignment(SwingConstants.LEFT);
			lblPassword.setFont(new Font("Consolas", Font.PLAIN, 14));
			lblPassword.setForeground(Color.BLACK);
			panel.add(lblPassword);
			
			txtPassword = new JTextField();
			panel.add(txtPassword);
			txtPassword.setColumns(10);
			
			JLabel lblEmailAddress = new JLabel("Email Address");
			lblEmailAddress.setHorizontalAlignment(SwingConstants.LEFT);
			lblEmailAddress.setFont(new Font("Consolas", Font.PLAIN, 14));
			lblEmailAddress.setForeground(Color.BLACK);
			panel.add(lblEmailAddress);
			
			txtEmail = new JTextField();
			panel.add(txtEmail);
			txtEmail.setColumns(10);
			
			JLabel lblGender = new JLabel("Gender");
			lblGender.setHorizontalAlignment(SwingConstants.LEFT);
			lblGender.setFont(new Font("Consolas", Font.PLAIN, 14));
			lblGender.setForeground(Color.BLACK);
			panel.add(lblGender);
			
			JPanel panel_2 = new JPanel();
			panel.add(panel_2);
			panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			
			JRadioButton rdbtnMale = new JRadioButton("Male");
			panel_2.add(rdbtnMale);
			
			JRadioButton rdbtnFemale = new JRadioButton("Female");
			panel_2.add(rdbtnFemale);
			
			JPanel pnlButtons = new JPanel();
			pnlButtons.setBounds(15, 313, 736, 33);
			frame.getContentPane().add(pnlButtons);
			pnlButtons.setLayout(new GridLayout(0, 4, 0, 0));
			
			JButton btnSave = new JButton("Save");
			pnlButtons.add(btnSave);
			
			JButton btnEdit = new JButton("Edit");
			pnlButtons.add(btnEdit);
			
			JButton btnUpdate = new JButton("Update");
			pnlButtons.add(btnUpdate);
			
			JButton btnRefresh = new JButton("Refresh");
			pnlButtons.add(btnRefresh);
			
			JPanel pnlGrid = new JPanel();
			pnlGrid.setBounds(5, 357, 749, 151);
			pnlGrid.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(51, 153, 153), null, null, null));
			frame.getContentPane().add(pnlGrid);
			pnlGrid.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			
			table = new JTable();
			table.setColumnSelectionAllowed(true);
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			table.setFont(new Font("Consolas", Font.PLAIN, 11));
			table.setFillsViewportHeight(true);
		
			table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			table.setForeground(new Color(0, 0, 0));
			table.setBackground(new Color(0, 128, 128));
			pnlGrid.add(table);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new EmptyBorder(1, 1, 1, 1));
			panel_1.setBounds(0, 0, 764, 73);
			frame.getContentPane().add(panel_1);
			
			JLabel lblNewLabel = new JLabel("Welcome Training Bassket ");
			lblNewLabel.setFont(new Font("Georgia", Font.BOLD, 17));
			lblNewLabel.setBackground(new Color(0, 51, 204));
			lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setIcon(new ImageIcon("C:\\Users\\dheeraj-thedev\\eclipse-workspace\\EMS\\src\\tbLogo.png"));
			panel_1.add(lblNewLabel);
			
			JSeparator separator = new JSeparator();
			separator.setBounds(5, 304, 749, 2);
			frame.getContentPane().add(separator);
			
			JSeparator separator_1 = new JSeparator();
			separator_1.setBounds(2, 354, 749, 2);
			frame.getContentPane().add(separator_1);
			
			table.setModel(buildTableModel(rs));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this.txtName, e.getMessage());
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\dheeraj-thedev\\eclipse-workspace\\EMS\\src\\tbLogo.png"));
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.getContentPane().setBackground(new Color(230, 230, 250));
		frame.getContentPane().setEnabled(false);
		frame.setBounds(100, 100, 777, 558);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
