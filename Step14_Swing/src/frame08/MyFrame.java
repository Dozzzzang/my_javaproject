package frame08;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/*
 *  JTextField 객체의 메소드를 잘 활용해서
 *  
 *  메세지를 입력하고 눌러보셈 버튼을 누르면
 *  
 *  입력한 메세지가 알림창에 출력되도록 프로그래밍 해보세요
 */
public class MyFrame extends JFrame {
	//생성자
	public MyFrame(String title) {
		super(title);
		setBounds(100, 100, 500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//흐르듯이 배치하는 레이아웃		
		setLayout(new FlowLayout(FlowLayout.CENTER));
				
		//문자열을 한줄 입력할수 있는 JTextField
		JTextField inputMsg=new JTextField(10);
		JButton sendBtn=new JButton("전송");
		
		add(inputMsg);
		add(sendBtn);
				
		sendBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//입력한 문자열 읽어오기
				String msg = inputMsg.getText();
				//알림으로 띄우기
				JOptionPane.showMessageDialog(MyFrame.this, msg);
			}
		});
		
	}
	public static void main(String[] args) {
		MyFrame my=new MyFrame("나의 프레임8");
		my.setVisible(true);
	}
	
}
