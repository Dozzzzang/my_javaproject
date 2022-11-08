package test.frame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import test.dao.FriendDao;
import test.dto.FriendDto;
public class FriendFrame extends JFrame implements ActionListener, PropertyChangeListener{
	//필드
	JTextField inputName, inputPhone, inputBirth;
	DefaultTableModel model;
	JTable table;
	//생성자
	public FriendFrame() {
	    setLayout(new BorderLayout());
	      
	    JLabel label1=new JLabel("이름");
	    inputName=new JTextField(10);
	      
	    JLabel label2=new JLabel("전화번호");
	    inputPhone=new JTextField(10);
	    
	    JLabel label3=new JLabel("생일");
	    inputBirth=new JTextField(10);
	      
	    JButton saveBtn=new JButton("저장");
	    saveBtn.setActionCommand("save");
	    
	    JButton deleteBtn=new JButton("삭제");
	    deleteBtn.setActionCommand("delete");

	    JPanel panel=new JPanel();
	    panel.add(label1);
	    panel.add(inputName);
	    panel.add(label2);
        panel.add(inputPhone);
	    panel.add(label3);
        panel.add(inputBirth);
	    panel.add(saveBtn);
	    panel.add(deleteBtn);
	    //패널째로 프레임의 북쪽에 배치
	    add(panel, BorderLayout.NORTH);
	    
	    //표형식으로 정보를 출력하기 위한 JTable
	    table=new JTable();
	    //칼럼명을 String[] 에 순서대로 준비
	    String[] colNames= {"번호", "이름", "전화번호", "생일"};
	    //테이블에 연결할 모델객체(테이블에 출력할 데이터를 가지고 있는 객체)
	    model=new DefaultTableModel(colNames, 0) {
	    	@Override
	    	public boolean isCellEditable(int row, int column) {
	    		if(column==0) {// 0 번째 칼럼은 수정 불가능 하도록 false 리턴
	    			return false;	    		
	    		}else {// 나머지 칼럼은 수정 가능하도록 true 리턴
	    			return true;
	    		}
	    	}
	    };
	    
	    //모델을 테이블에 연결한다.
	    table.setModel(model);
	    //스크롤이 가능 하도록 테이블을 JScrollPane 에 감싼다.
	    JScrollPane scroll=new JScrollPane(table);
	    //JScrollPane 을 프레임의 가운데에 배치하기
	    add(scroll, BorderLayout.CENTER);
	    
	    
	    //버튼에 리스너 등록
	    saveBtn.addActionListener(this);
	    deleteBtn.addActionListener(this);
	    
	    displayFriend();
	    
	    table.addPropertyChangeListener(this);
	}
	
	public void displayFriend() {
		model.setRowCount(0);
		
		FriendDao dao=new FriendDao();
		List<FriendDto> list=dao.getList();
		
		for(FriendDto tmp:list) {
			Object[] row = {tmp.getNum(), tmp.getName(), tmp.getPhone(), tmp.getBirth()};
			model.addRow(row);
		}
	}
	//main 메소드
	public static void main(String[] args) {
		FriendFrame f=new FriendFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(100, 100, 800, 500);
		f.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String command=e.getActionCommand();
		if(command.equals("save")) {
			String name = inputName.getText();
			String phone = inputPhone.getText();
			String birth = inputBirth.getText();
			
			FriendDto dto=new FriendDto();
			dto.setName(name);
			dto.setPhone(phone);
			dto.setBirth(birth);					
			
			FriendDao dao=new FriendDao();
			
			boolean isSuccess=dao.insert(dto);
			if(isSuccess) {
				JOptionPane.showMessageDialog(FriendFrame.this, name+"의 전화번호와 생일을 추가했습니다.");
				displayFriend();
			}else {
				JOptionPane.showMessageDialog(FriendFrame.this, "추가 실패!");
			}
			inputName.setText("");
			inputPhone.setText("");
			inputBirth.setText("");			
		}else if(command.equals("delete")) {
			int sr=table.getSelectedRow();
			if(sr==-1) {
				JOptionPane.showMessageDialog(this, "삭제할 row 를 선택하세요.");
				return;
			}
			int result = JOptionPane.showConfirmDialog(this, "선택된 row 를 삭제 하시겠습니까?");
			if(result==JOptionPane.YES_OPTION){				
				int num=(int) model.getValueAt(sr, 0);				
				FriendDao dao=new FriendDao();
				dao.delete(num);				
				displayFriend();
			}
			
		}
		
		
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		System.out.println("property change!");
		System.out.println("property name:"+evt.getPropertyName());		
		System.out.println("isEditing:"+table.isEditing());
		
		if(evt.getPropertyName().equals("tableCellEditor") && !table.isEditing()) {

			int selectedIndex=table.getSelectedRow();			
			int num=(int) model.getValueAt(selectedIndex, 0);
			String name=(String) model.getValueAt(selectedIndex, 1);
			String phone=(String) model.getValueAt(selectedIndex, 2);
			String birth=(String) model.getValueAt(selectedIndex, 3);
			
			FriendDto dto=new FriendDto(num, name, phone, birth);
			
			new FriendDao().update(dto);
			//선택된 row clear
			table.clearSelection();
			displayFriend();
		}
	}	
}
