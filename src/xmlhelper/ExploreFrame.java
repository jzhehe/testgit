package xmlhelper;

import java.awt.Container;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class ExploreFrame extends JFrame implements ActionListener
{
	JFrame frame = new JFrame("xls导出xml");// 框架布局  
	JTabbedPane tabPane = new JTabbedPane();// 选项卡布局  
	Container con = new Container();//  
	JLabel label1 = new JLabel("选择导入文件");  
	JLabel label2 = new JLabel("选择输出文件");  
	JTextField text1 = new JTextField();// TextField 目录的路径  
	JTextField text2 = new JTextField();// 文件的路径  
	JButton button1 = new JButton("...");// 选择  
	JButton button2 = new JButton("...");// 选择  
	JFileChooser jfc1=new JFileChooser();
	JFileChooser jfc2=new JFileChooser();
	JButton button3 = new JButton("导出");// 
	String selectpath="";
	String explorepath="";
	public ExploreFrame()
	{
		jfc1.setCurrentDirectory(new File("C://Users//Administrator//Desktop"));// 文件选择器的初始目录定为d盘
		jfc2.setCurrentDirectory(new File("C://Users//Administrator//Desktop"));// 文件选择器的初始目录定为d盘
		double lx = Toolkit.getDefaultToolkit().getScreenSize().getWidth();  

		double ly = Toolkit.getDefaultToolkit().getScreenSize().getHeight();  

		frame.setLocation(new Point((int) (lx / 2) - 150, (int) (ly / 2) - 150));// 设定窗口出现位置  
		frame.setSize(330, 160);// 设定窗口大小  
		frame.setContentPane(tabPane);// 设置布局  
		label1.setBounds(10, 10, 150, 20);  
		text1.setBounds(100, 10, 120, 20);  
		button1.setBounds(230, 10, 50, 20);  
		label2.setBounds(10, 35, 150, 20);  
		text2.setBounds(100, 35, 120, 20);  
		button2.setBounds(230, 35, 50, 20);  
		button3.setBounds(10, 60, 60, 20);  
		button1.addActionListener(this); // 添加事件处理  
		button2.addActionListener(this); // 添加事件处理  
		button3.addActionListener(this); // 添加事件处理  
		con.add(label1);  
		con.add(text1);  
		con.add(button1);  
		con.add(label2);  
		con.add(text2);  
		con.add(button2);  
		con.add(button3);  
		frame.setVisible(true);// 窗口可见  
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 使能关闭窗口，结束程序  
		tabPane.add("1面板", con);// 添加布局1  
	}  
	public void actionPerformed(ActionEvent e) {  
        // TODO Auto-generated method stub  
        if (e.getSource().equals(button1)) {// 判断触发方法的按钮是哪个  
            jfc1.setFileSelectionMode(0);// 设定只能选择到文件  
            MyFileFilter xlsFilter = new MyFileFilter(".xls", "xls 文件 (*.xls)");
            MyFileFilter xlsxFilter = new MyFileFilter(".xlsx", "xlsx 文件 (*.xlsx)");
            jfc1.addChoosableFileFilter(xlsFilter);
            jfc1.addChoosableFileFilter(xlsxFilter);
            jfc1.setFileFilter(xlsFilter);
            int state = jfc1.showOpenDialog(null);// 此句是打开文件选择器界面的触发语句  
            if (state == 1) {  
                return;  
            } else {  
                File f = jfc1.getSelectedFile();// f为选择到的文件
                selectpath=f.getAbsolutePath();
                text1.setText(f.getAbsolutePath());  
            }  
        }  
        // 绑定到选择文件，先择文件事件  
        if (e.getSource().equals(button2)) {  
            jfc2.setFileSelectionMode(1);// 设定只能选择到文件夹
            int state = jfc2.showOpenDialog(null);// 此句是打开文件选择器界面的触发语句  
            if (state == 1) {  
                return;// 撤销则返回  
            } else {  
                File f = jfc2.getSelectedFile();// f为选择到的文目录 
                explorepath=f.getAbsolutePath();
                text2.setText(f.getAbsolutePath());  
            }  
        }  
        if (e.getSource().equals(button3)) {  
        	Excel2xml exc = new Excel2xml();  
        	exc.ret(selectpath,explorepath,this);

        }  
    } 
	public static void main(String[] args)
	{
		new ExploreFrame();
	}
}
