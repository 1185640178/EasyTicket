package com;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import util.ServerConnector;

public class Login extends JFrame implements ActionListener
{
	JButton login = new JButton("��¼");
	JButton exit = new JButton("�˳�");
	JLabel  name = new JLabel("�û�����");
	JLabel password = new JLabel("���룺"); 
	JTextField JName = new JTextField(10); //�����˺�����
	JPasswordField JPassword = new JPasswordField(10); // �������������룻
	private  String phone;
	private String pwd;
	
	public Login() 
	{
		JPanel jp = new JPanel();
		jp.setLayout(new GridLayout(3,2));  //3��2�е����jp�����񲼾֣�
		
		name.setHorizontalAlignment(SwingConstants.RIGHT);  //���ø�����Ķ��뷽ʽΪ���Ҷ���
		password.setHorizontalAlignment(SwingConstants.RIGHT);
		
		jp.add(name);   //�����ݼӵ����jp��
		jp.add(JName);  
		jp.add(password);
		jp.add(JPassword);  
		jp.add(login);
		jp.add(exit);
		
		login.addActionListener(this); //��¼�����¼�����
		exit.addActionListener(this);	//�˳������¼�����
		
		this.add(jp,BorderLayout.CENTER);	//��������嶨�����м�
		
		this.setTitle("��¼����");
		this.setLocation(500,300);	//���ó�ʼλ��
		this.pack();  		//��ʾ��������Զ�������С
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e)  // ��ʱ����д���
	{
		if(e.getSource() == exit)
		{
			int i = JOptionPane.showConfirmDialog(null,"ȷ��Ҫ�˳���", "ȷ��", JOptionPane.YES_NO_OPTION);
			 phone = JName.getText();
			String msg = "Logout:/ClientLogout?phone="+phone;
			ServerConnector.sendMsgToConnector(msg);	 
			// ��ʾѡ��Ի���
			//System.exit(0);
		}
		else if(e.getSource() == login)
		{
			 phone = JName.getText();
			 pwd = String.valueOf(JPassword.getPassword());
			 String msg = "Login:/ClientLogin?phone="+phone+"&pwd="+pwd;
			 ServerConnector.sendMsgToConnector(msg);	 	 
		}
	}
	public static void main(String[] args)
	{
		JFrame.setDefaultLookAndFeelDecorated(true);
		new Login();
	}
}
