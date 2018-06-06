import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class Window extends JFrame {
	private Container myPane; //프레임
	
	JMenuBar menu; //메뉴 버튼들
	JButton menuNewFile;
	JButton menuOpen;
	JButton menuSave;
	JButton menuSaveName;
	JButton menuApply;
	JButton menuChange;
	JButton menuClose;
	
	JButton toolNewFile; //툴바 버튼들
	JButton toolOpen;
	JButton toolSave;
	JButton toolSaveName;
	JButton toolApply;
	JButton toolChange;
	JButton toolClose;
	
	JTextArea TextArea; //Text Editor Pane 요소들
	
	JPanel MapPanel; //Mind Map Pane 요소들
	JButton apply;
	
	JTextField textBox; //Attribute Pane 요소들
	JTextField xBox;
	JTextField yBox;
	JTextField wBox;
	JTextField hBox;
	JTextField colorBox;
	JButton change;
	
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
		menuNewFile = new JButton("새로 만들기");
		menuOpen = new JButton("열기");
		menuSave = new JButton("저장");
		menuSaveName = new JButton("다른 이름으로 저장");
		menuApply = new JButton("적용");
		menuChange = new JButton("변경");
		menuClose = new JButton("닫기");
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
		toolNewFile = new JButton("새로 만들기");
		toolOpen = new JButton("열기");
		toolSave = new JButton("저장");
		toolSaveName = new JButton("다른 이름으로 저장");
		toolApply = new JButton("적용");
		toolChange = new JButton("변경");
		toolClose = new JButton("닫기");
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
		Font paneFont = new Font("Arial", Font.PLAIN, 30); //Attribute Pane에 적용된 폰트
		Font labelFont = new Font("Arial", Font.BOLD, 30); //Pane 이름에 적용된 폰트
		Font nodeFont = new Font("굴림", Font.PLAIN, 20); //node에 적용될 폰트
		
		JPanel LeftPane = new JPanel(); //Text Editor Pane이 들어갈 곳
		JPanel CenterPane = new JPanel(); //MindMap Pane이 들어갈 곳
		JPanel RightPane = new JPanel(); //Attribute Pane이 들어갈 곳
		LeftPane.setLayout(new BorderLayout());
		CenterPane.setLayout(new BorderLayout());
		RightPane.setLayout(new BorderLayout());
		
		TextArea = new JTextArea(); //글씨 쓰는 곳
		JScrollPane TextPane = new JScrollPane(TextArea);
		TextArea.setFont(nodeFont);
		MapPanel = new JPanel(); //마인드맵이 출력되는 곳
		JScrollPane MapPane = new JScrollPane(MapPanel);
		JPanel Attribute = new JPanel(); //노드의 정보가 출력되는 곳
		
		Attribute.setLayout(new GridLayout(6, 2));
		JScrollPane AttributePane = new JScrollPane(Attribute);
		myPane.add(BasePane);

		BasePane.setLeftComponent(LeftPane); // Text Editor Pane 배치
		BasePane.setRightComponent(BasePane2);
		BasePane.setDividerLocation(300);
		BasePane.setDividerSize(3);
		
		JLabel textEditorLabel = new JLabel("Text Editor Pane", SwingConstants.CENTER); //Text Editor Pane 제작
		textEditorLabel.setFont(labelFont);
		LeftPane.add(textEditorLabel, BorderLayout.NORTH);
		LeftPane.add(TextPane, BorderLayout.CENTER);
		apply = new JButton("적용");
		LeftPane.add(apply, BorderLayout.SOUTH);

		BasePane2.setLeftComponent(CenterPane); // MindMap, Attribute Pane 배치
		BasePane2.setRightComponent(RightPane);
		BasePane2.setDividerLocation(700);
		BasePane2.setDividerSize(3);
		JLabel mindMapLabel = new JLabel("Mine Map Pane", SwingConstants.CENTER); //MindMap Pane 제작
		mindMapLabel.setFont(labelFont);
		CenterPane.add(mindMapLabel, BorderLayout.NORTH);
		CenterPane.add(MapPane, BorderLayout.CENTER);
		JLabel attributeLabel = new JLabel("Attribute Pane", SwingConstants.CENTER);  //Attribute Pane 제작
		attributeLabel.setFont(labelFont);
		RightPane.add(attributeLabel, BorderLayout.NORTH);
		RightPane.add(AttributePane, BorderLayout.CENTER);
		JLabel textLabel = new JLabel("TEXT:	"); //AttribuePane 조립
		textLabel.setFont(paneFont);
		Attribute.add(textLabel);
		textBox = new JTextField();
		Attribute.add(textBox);
		JLabel xLabel = new JLabel("X:	");
		xLabel.setFont(paneFont);
		Attribute.add(xLabel);
		xBox = new JTextField();
		Attribute.add(xBox);
		JLabel yLabel = new JLabel("Y:	");
		yLabel.setFont(paneFont);
		Attribute.add(yLabel);
		yBox = new JTextField();
		Attribute.add(yBox);
		JLabel wLabel = new JLabel("W:	");
		wLabel.setFont(paneFont);
		Attribute.add(wLabel);
		wBox = new JTextField();
		Attribute.add(wBox);
		JLabel hLabel = new JLabel("H:	");
		hLabel.setFont(paneFont);
		Attribute.add(hLabel);
		hBox = new JTextField();
		Attribute.add(hBox);
		JLabel colorLabel = new JLabel("Color:");
		colorLabel.setFont(paneFont);
		Attribute.add(colorLabel);
		colorBox = new JTextField();
		Attribute.add(colorBox);
		change = new JButton("변경");
		RightPane.add(change, BorderLayout.SOUTH);
		
		
		JLabel test = new JLabel("tset");
		
		class NodeDrag implements MouseMotionListener{
			@Override
			public void mouseDragged(MouseEvent e) {
				test.setLocation(test.getX()+e.getX(),test.getY()+ e.getY());
				
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		};
		
		test.addMouseMotionListener(new NodeDrag());

			
		
		apply.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String[] nodes = TextArea.getText().split("\n");
				for(int i=0;i<nodes.length;i++) {
					JLabel tmp = new JLabel(nodes[i]);
					tmp.addMouseMotionListener(new NodeDrag());
					MapPanel.add(tmp);
			
				}
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