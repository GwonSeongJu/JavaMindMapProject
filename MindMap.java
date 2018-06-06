import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class Window extends JFrame {
	private Container myPane; //������
	
	public Window() {
		setTitle("���ε��");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //������ ����
		myPane = getContentPane();
		makeWindow();
		setSize(1400, 800);
		setVisible(true);
	}
	
	private void makeWindow() {
		JavaTree<JLabel> storage = new JavaTree();
		//�޴�
		JMenuBar menu = new JMenuBar();
		JButton menuNewFile = new JButton("���� �����");
		JButton menuOpen = new JButton("����");
		JButton menuSave = new JButton("����");
		JButton menuSaveName = new JButton("�ٸ� �̸����� ����");
		JButton menuApply = new JButton("����");
		JButton menuChange = new JButton("����");
		JButton menuClose = new JButton("�ݱ�");
		menu.add(menuNewFile);
		menu.add(menuOpen);
		menu.add(menuSave);
		menu.add(menuSaveName);
		menu.add(menuApply);
		menu.add(menuChange);
		menu.add(menuClose);
		setJMenuBar(menu);
	
		
		//����
		JToolBar tool = new JToolBar("TOOL BAR");
		tool.setFloatable(true);
		myPane.add(tool, BorderLayout.NORTH);
		JButton toolNewFile = new JButton("���� �����");
		JButton toolOpen = new JButton("����");
		JButton toolSave = new JButton("����");
		JButton toolSaveName = new JButton("�ٸ� �̸����� ����");
		JButton toolApply = new JButton("����");
		JButton toolChange = new JButton("����");
		JButton toolClose = new JButton("�ݱ�");
		tool.add(toolNewFile);
		tool.add(toolOpen);
		tool.add(toolSave);
		tool.add(toolSaveName);
		tool.add(toolApply);
		tool.add(toolChange);
		tool.add(toolClose);

		
		
		//����
		JSplitPane BasePane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true);
		JSplitPane BasePane2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true);
		
		JPanel LeftPane = new JPanel(); //Text Editor Pane�� �� ��
		JPanel CenterPane = new JPanel(); //MindMap Pane�� �� ��
		JPanel RightPane = new JPanel(); //Attribute Pane�� �� ��
		LeftPane.setLayout(new BorderLayout());
		CenterPane.setLayout(new BorderLayout());
		RightPane.setLayout(new BorderLayout());
		
		JTextArea TextArea = new JTextArea();
		JScrollPane TextPane = new JScrollPane(TextArea); //������ �۾� ���� ��
		JPanel MapPanel = new JPanel();
		JScrollPane MapPane = new JScrollPane(MapPanel); //���ε���� ��µǴ� ��
		JPanel Attribute = new JPanel(); //����� ������ ��µǴ� ��
		
		Attribute.setLayout(new GridLayout(6, 2));
		JScrollPane AttributePane = new JScrollPane(Attribute);
		myPane.add(BasePane);

		BasePane.setLeftComponent(LeftPane); // Text Editor Pane ��ġ
		BasePane.setRightComponent(BasePane2);
		BasePane.setDividerLocation(300);
		BasePane.setDividerSize(3);
		
		LeftPane.add(new JLabel("Text Editor Pane", SwingConstants.CENTER), BorderLayout.NORTH);
		LeftPane.add(TextPane, BorderLayout.CENTER);
		LeftPane.add(new JButton("����"), BorderLayout.SOUTH);

		BasePane2.setLeftComponent(CenterPane); // MindMap, Attribute Pane ��ġ
		BasePane2.setRightComponent(RightPane);
		BasePane2.setDividerLocation(700);
		BasePane2.setDividerSize(3);
		CenterPane.add(new JLabel("Mine Map Pane", SwingConstants.CENTER), BorderLayout.NORTH); //MindMap Pane ����
		CenterPane.add(MapPane, BorderLayout.CENTER);
		RightPane.add(new JLabel("Attribute Pane", SwingConstants.CENTER), BorderLayout.NORTH); //Attribute Pane ����
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
		RightPane.add(new JButton("����"), BorderLayout.SOUTH);
		
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
