import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class Window extends JFrame {
	private Container myPane; //프레임
	
	public Window() {
		setTitle("마인드맵");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //닫으면 종료
		myPane = getContentPane();
		makeWindow();
		setSize(1400, 800);
		setVisible(true);
	}
	
	private void makeWindow() {
		JavaTree<JLabel> storage = new JavaTree();
		//메뉴
		JMenuBar menu = new JMenuBar();
		JButton menuNewFile = new JButton("새로 만들기");
		JButton menuOpen = new JButton("열기");
		JButton menuSave = new JButton("저장");
		JButton menuSaveName = new JButton("다른 이름으로 저장");
		JButton menuApply = new JButton("적용");
		JButton menuChange = new JButton("변경");
		JButton menuClose = new JButton("닫기");
		menu.add(menuNewFile);
		menu.add(menuOpen);
		menu.add(menuSave);
		menu.add(menuSaveName);
		menu.add(menuApply);
		menu.add(menuChange);
		menu.add(menuClose);
		setJMenuBar(menu);
	
		
		//툴바
		JToolBar tool = new JToolBar("TOOL BAR");
		tool.setFloatable(true);
		myPane.add(tool, BorderLayout.NORTH);
		JButton toolNewFile = new JButton("새로 만들기");
		JButton toolOpen = new JButton("열기");
		JButton toolSave = new JButton("저장");
		JButton toolSaveName = new JButton("다른 이름으로 저장");
		JButton toolApply = new JButton("적용");
		JButton toolChange = new JButton("변경");
		JButton toolClose = new JButton("닫기");
		tool.add(toolNewFile);
		tool.add(toolOpen);
		tool.add(toolSave);
		tool.add(toolSaveName);
		tool.add(toolApply);
		tool.add(toolChange);
		tool.add(toolClose);

		
		
		//페인
		JSplitPane BasePane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true);
		JSplitPane BasePane2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true);
		
		JPanel LeftPane = new JPanel(); //Text Editor Pane이 들어갈 곳
		JPanel CenterPane = new JPanel(); //MindMap Pane이 들어갈 곳
		JPanel RightPane = new JPanel(); //Attribute Pane이 들어갈 곳
		LeftPane.setLayout(new BorderLayout());
		CenterPane.setLayout(new BorderLayout());
		RightPane.setLayout(new BorderLayout());
		
		JTextArea TextArea = new JTextArea();
		JScrollPane TextPane = new JScrollPane(TextArea); //실제로 글씨 쓰는 곳
		JPanel MapPanel = new JPanel();
		JScrollPane MapPane = new JScrollPane(MapPanel); //마인드맵이 출력되는 곳
		JPanel Attribute = new JPanel(); //노드의 정보가 출력되는 곳
		
		Attribute.setLayout(new GridLayout(6, 2));
		JScrollPane AttributePane = new JScrollPane(Attribute);
		myPane.add(BasePane);

		BasePane.setLeftComponent(LeftPane); // Text Editor Pane 배치
		BasePane.setRightComponent(BasePane2);
		BasePane.setDividerLocation(300);
		BasePane.setDividerSize(3);
		
		LeftPane.add(new JLabel("Text Editor Pane", SwingConstants.CENTER), BorderLayout.NORTH);
		LeftPane.add(TextPane, BorderLayout.CENTER);
		LeftPane.add(new JButton("적용"), BorderLayout.SOUTH);

		BasePane2.setLeftComponent(CenterPane); // MindMap, Attribute Pane 배치
		BasePane2.setRightComponent(RightPane);
		BasePane2.setDividerLocation(700);
		BasePane2.setDividerSize(3);
		CenterPane.add(new JLabel("Mine Map Pane", SwingConstants.CENTER), BorderLayout.NORTH); //MindMap Pane 제작
		CenterPane.add(MapPane, BorderLayout.CENTER);
		RightPane.add(new JLabel("Attribute Pane", SwingConstants.CENTER), BorderLayout.NORTH); //Attribute Pane 제작
		RightPane.add(AttributePane, BorderLayout.CENTER);
		Attribute.add(new JLabel("TEXT:	")); 
		JTextField textBox = new JTextField();
		Attribute.add(textBox);
		Attribute.add(new JLabel("X:	"));
		JTextField xBox = new JTextField();
		Attribute.add(xBox);
		Attribute.add(new JLabel("Y:	"));
		JTextField yBox = new JTextField();
		Attribute.add(yBox);
		Attribute.add(new JLabel("W:	"));
		JTextField wBox = new JTextField();
		Attribute.add(wBox);
		Attribute.add(new JLabel("H:	"));
		JTextField hBox = new JTextField();
		Attribute.add(hBox);
		Attribute.add(new JLabel("Color:"));
		JTextField colorBox = new JTextField();
		Attribute.add(colorBox);
		RightPane.add(new JButton("변경"), BorderLayout.SOUTH);
		
		JLabel test = new JLabel("tset");
		test.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseDragged(MouseEvent e) {
				test.setLocation(test.getX()+e.getX(),test.getY()+ e.getY());
				
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		MapPanel.add(test);
		
		
		
		
	}
}

public class MindMap {
	public static void main(String[] args) {
		new Window();
		
	}
}
