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
import java.sql.Connection;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class DAOLogin extends JFrame {

	private JPanel contentPane;
	private JTextField IDTextField;
	private JPasswordField PWTextField;
	Memo memo = new Memo();		// 메모장

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DAOLogin frame = new DAOLogin();
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
	public DAOLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 855, 570);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 823, 482);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel IDLabel = new JLabel("ID :");
		IDLabel.setFont(new Font("굴림", Font.PLAIN, 35));
		IDLabel.setBounds(172, 139, 137, 35);
		panel.add(IDLabel);
		
		JLabel PWLabel = new JLabel("PW :");
		PWLabel.setFont(new Font("굴림", Font.PLAIN, 35));
		PWLabel.setBounds(172, 242, 137, 35);
		panel.add(PWLabel);
		
		IDTextField = new JTextField();
		IDTextField.setBounds(286, 138, 266, 41);
		panel.add(IDTextField);
		IDTextField.setColumns(10);
		
		// 로그인 버튼
		JButton LoginButton = new JButton("Login");
		LoginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					loginDAO(IDTextField, PWTextField);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		LoginButton.setBounds(286, 320, 191, 43);
		panel.add(LoginButton);
		
		// 회원가입 버튼
		JButton JoinButton = new JButton("Join us");
		JoinButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DAOTest dao = new DAOTest();
				dao.main(null);
			}
		});
		JoinButton.setBounds(286, 398, 191, 43);
		panel.add(JoinButton);
		
		PWTextField = new JPasswordField();
		PWTextField.setBounds(286, 236, 266, 41);
		panel.add(PWTextField);
	}
	
	// 로그인DAO Method
	public void loginDAO(JTextField IDTextField, JPasswordField PWTextField) throws Exception {
		MemberDAO dao = new MemberDAO();
		
		String id = IDTextField.getText();
		String pw = PWTextField.getText();

		try {
			boolean result = dao.loginMember(id, pw);
			System.out.println(result);
			
			if(result == true) { // 결과 값이 true이면
				JOptionPane.showMessageDialog(null, "login Completed!");
				memo.main(null);
			}else {
				if(pw.equals("")) { // 비밀번호 입력창에 아무것도 입력하지 않았을 때
					JOptionPane.showMessageDialog(null, "Fill the password");
				}else { // 비밀번호가 올바르지 않는 경우
					JOptionPane.showMessageDialog(null, "Failed login");
					IDTextField.setText("");
					PWTextField.setText("");
				}
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}
