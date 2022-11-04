package test.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


/*
 *  1. JTextField 에 문자열을 입력하고 추가 버튼을 누르면
 *  입력한 문자열이 myFolder/memo.txt 파일에 append 되도록 해보세요.
 *  
 *  2. 불러오기 버튼을 누르면 myFolder/memo.txt 파일에 있는 모든 문자열을
 *  JTextArea에 출력하도록 해보세요.
 */
public class Test extends JFrame implements ActionListener{
	//필드
	JTextField tf;
	JTextArea ja;

	//생성자
	public Test(String title) {
		setLayout(new BorderLayout());
		
		JPanel topPanel=new JPanel();
		add(topPanel, BorderLayout.NORTH);
		topPanel.setBackground(Color.white);
		
		tf=new JTextField(20);
		topPanel.add(tf);
		
		JPanel bottomPalnel=new JPanel();
		
		bottomPalnel.setBackground(Color.black);
		ja=new JTextArea();		
		JScrollPane sc=new JScrollPane(ja);
		add(sc, BorderLayout.CENTER);
		ja.setEditable(false);
		
		JButton sendBtn=new JButton("추가");
		topPanel.add(sendBtn);		
		sendBtn.setActionCommand("send");
			
		JButton loadBtn=new JButton("불러오기");
		topPanel.add(loadBtn);
		loadBtn.setActionCommand("load");
		
		sendBtn.addActionListener(this);
		loadBtn.addActionListener(this);
					
		}
	public static void main(String[] args) {
		Test f=new Test("메모");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(100, 100, 500, 500);
		f.setVisible(true);
				
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//문자열을 저장할 파일을 만들기 위한 File 객체
		File memoFile=new File("c:/acorn202210/myFolder/memo.txt");
		//필요한 객체를 담을 지역 변수를 미리 만들기
		FileReader fr=null;
		BufferedReader br=null;
		FileWriter pw=null;
		try {
			String command = e.getActionCommand();
			if(command.equals("send")) {
				String str=tf.getText();
				pw = new FileWriter(memoFile, true);
				pw.write(str+"\r\n");
				pw.flush();
			}else if(command.equals("load")) {
				fr = new FileReader(memoFile);
				br = new BufferedReader(fr);
				ja.setText("");
				while(true) {
					String line=br.readLine();
					if(line == null) {
						break;
					}
					ja.append(line+"\r\n");
				}
			}							
		}catch (Exception e1) {
			e1.printStackTrace();
		}finally {
			try {
				if(br != null) br.close();
				if(fr != null) fr.close();
				if(pw != null) pw.close();
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	

}
