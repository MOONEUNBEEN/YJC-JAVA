package ProjectDAO;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class DAOTest extends JFrame {

	private JPanel contentPane;
	private JTextField IDField;
	private JTextField NameField;
	private JPasswordField PWField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DAOTest frame = new DAOTest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DAOTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 845, 569);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 813, 481);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel IDLabel = new JLabel("ID :");
		IDLabel.setFont(new Font("굴림", Font.PLAIN, 35));
		IDLabel.setBounds(223, 125, 137, 35);
		panel.add(IDLabel);
		
		JLabel lblNewLabel = new JLabel("PW :");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 35));
		lblNewLabel.setBounds(206, 213, 137, 35);
		panel.add(lblNewLabel);
		
		IDField = new JTextField();
		IDField.setBounds(318, 124, 266, 41);
		panel.add(IDField);
		IDField.setColumns(10);
		
		// 확인 버튼
		JButton CorrectButton = new JButton("Correct");
		CorrectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = IDField.getText();
				String pw = PWField.getText();
				String name = NameField.getText();
				
				Member m = new Member(id, pw, name);
				
				MemberDAO dao;
				
				try {
					dao = new MemberDAO();
					
					try {
						dao.insertMember(m);
						JOptionPane.showMessageDialog(null, "회원등록 성공");
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "회원등록 실패[" + e1.getMessage() + "]");
						e1.printStackTrace();
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		CorrectButton.setBounds(194, 392, 191, 43);
		panel.add(CorrectButton);
		
		JLabel NameLabel = new JLabel("Name :");
		NameLabel.setFont(new Font("굴림", Font.PLAIN, 35));
		NameLabel.setBounds(165, 296, 137, 35);
		panel.add(NameLabel);
		
		NameField = new JTextField();
		NameField.setBounds(318, 295, 266, 41);
		panel.add(NameField);
		NameField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\uD68C\uC6D0\uAC00\uC785");
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 33));
		lblNewLabel_1.setBounds(343, 45, 137, 35);
		panel.add(lblNewLabel_1);
		
		JButton ExitButton = new JButton("Exit");
		ExitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		ExitButton.setBounds(413, 392, 191, 43);
		panel.add(ExitButton);
		
		PWField = new JPasswordField();
		PWField.setBounds(318, 212, 266, 41);
		panel.add(PWField);
	}
}
