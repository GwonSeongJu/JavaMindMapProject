import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;

class Window extends JFrame {
	private Container myPane; //������
	
	JMenuBar menu; //�޴� ��ư��
	JButton menuNewFile;
	JButton menuOpen;
	JButton menuSave;
	JButton menuSaveName;
	JButton menuApply;
	JButton menuChange;
	JButton menuClose;
	
	JButton toolNewFile; //���� ��ư��
	JButton toolOpen;
	JButton toolSave;
	JButton toolSaveName;
	JButton toolApply;
	JButton toolChange;
	JButton toolClose;
	
	JTextArea TextArea; //Text Editor Pane ��ҵ�
	
	JPanel MapPanel; //Mind Map Pane ��ҵ�
	JButton apply;
	
	JTextField textBox; //Attribute Pane ��ҵ�
	JTextField xBox;
	JTextField yBox;
	JTextField wBox;
	JTextField hBox;
	JTextField colorBox;
	JButton change;
	
	Font paneFont = new Font("Arial", Font.PLAIN, 30); //Attribute Pane�� ����� ��Ʈ
	Font labelFont = new Font("Arial", Font.BOLD, 30); //Pane �̸��� ����� ��Ʈ
	Font nodeFont = new Font("����", Font.PLAIN, 20); //node�� ����� ��Ʈ
	
	JavaTree<JLabel> storage;	//node�����
	
	public Window() {
		storage = new JavaTree();
		setTitle("���ε��");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //������ ����
		myPane = getContentPane();
		makeWindow();
		setSize(1400, 800);
		setVisible(true);
	}
	
	private void makeWindow() {
		
		
		//�޴�
		JMenuBar menu = new JMenuBar();
		menuNewFile = new JButton("���� �����");
		menuOpen = new JButton("����");
		menuSave = new JButton("����");
		menuSaveName = new JButton("�ٸ� �̸����� ����");
		menuApply = new JButton("����");
		menuChange = new JButton("����");
		menuClose = new JButton("�ݱ�");
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
		toolNewFile = new JButton("���� �����");
		toolOpen = new JButton("����");
		toolSave = new JButton("����");
		toolSaveName = new JButton("�ٸ� �̸����� ����");
		toolApply = new JButton("����");
		toolChange = new JButton("����");
		toolClose = new JButton("�ݱ�");
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
		
		TextArea = new JTextArea(); //�۾� ���� ��
		JScrollPane TextPane = new JScrollPane(TextArea);
		TextArea.setFont(nodeFont);
		MapPanel = new JPanel(); //���ε���� ��µǴ� ��
		JScrollPane MapPane = new JScrollPane(MapPanel);
		JPanel Attribute = new JPanel(); //����� ������ ��µǴ� ��
		
		Attribute.setLayout(new GridLayout(6, 2));
		JScrollPane AttributePane = new JScrollPane(Attribute);
		myPane.add(BasePane);

		BasePane.setLeftComponent(LeftPane); // Text Editor Pane ��ġ
		BasePane.setRightComponent(BasePane2);
		BasePane.setDividerLocation(300);
		BasePane.setDividerSize(3);
		
		JLabel textEditorLabel = new JLabel("Text Editor Pane", SwingConstants.CENTER); //Text Editor Pane ����
		textEditorLabel.setFont(labelFont);
		LeftPane.add(textEditorLabel, BorderLayout.NORTH);
		LeftPane.add(TextPane, BorderLayout.CENTER);
		apply = new JButton("����");
		LeftPane.add(apply, BorderLayout.SOUTH);

		BasePane2.setLeftComponent(CenterPane); // MindMap, Attribute Pane ��ġ
		BasePane2.setRightComponent(RightPane);
		BasePane2.setDividerLocation(700);
		BasePane2.setDividerSize(3);
		JLabel mindMapLabel = new JLabel("Mine Map Pane", SwingConstants.CENTER); //MindMap Pane ����
		mindMapLabel.setFont(labelFont);
		CenterPane.add(mindMapLabel, BorderLayout.NORTH);
		CenterPane.add(MapPane, BorderLayout.CENTER);
		JLabel attributeLabel = new JLabel("Attribute Pane", SwingConstants.CENTER);  //Attribute Pane ����
		attributeLabel.setFont(labelFont);
		RightPane.add(attributeLabel, BorderLayout.NORTH);
		RightPane.add(AttributePane, BorderLayout.CENTER);
		JLabel textLabel = new JLabel("TEXT:	"); //AttribuePane ����
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
		change = new JButton("����");
		RightPane.add(change, BorderLayout.SOUTH);
		

		apply.addActionListener(new ApplyListener());
	}
	
	class ApplyListener implements ActionListener{	//���� ������

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String text = TextArea.getText();
			text = text + "\n\n";
			insertNode(text,storage.rootNode,0);
			MapPanel.updateUI();
		}
		
		private String insertNode(String stringData, Node<JLabel> rootNode, int depth) {
			Node<JLabel> preNode = null;
			
			while(true) {
				int tapCount = 0;
				if(stringData.charAt(0)=='\n') {
					return stringData;
				}
				for(int i=0;stringData.charAt(i)=='\t';i++) {
					tapCount++;
				}
				if(tapCount==depth) {
					stringData = stringData.substring(tapCount);
					JLabel preLabel = new JLabel(stringData.substring(0, stringData.indexOf('\n')));
					stringData = stringData.substring(stringData.indexOf('\n')+1);
					preNode = new Node<>();
					preNode.setData(preLabel);
					preLabel.setOpaque(true);
	
					preLabel.setBorder(LineBorder.createBlackLineBorder());
					preLabel.setPreferredSize(new Dimension(100, 50));
					preLabel.setBackground(Color.WHITE);
					preLabel.setFont(nodeFont);;
					preLabel.setHorizontalAlignment(SwingConstants.CENTER);
					preLabel.addMouseMotionListener(new NodeDrag());
					MapPanel.add(preLabel);
					storage.insertNode(rootNode, preNode);
				}
				if(tapCount>depth) {
					stringData = insertNode(stringData,preNode,depth+1);
				}
				if(tapCount<depth){
					return stringData;
				}
			}
		}
		
	}
	
	class NodeDrag implements MouseMotionListener{	//��� ���콺 �巡�� ������
		@Override
		public void mouseDragged(MouseEvent e) {
			e.getComponent().setLocation(e.getComponent().getX()+e.getX(),e.getComponent().getY()+ e.getY());
			
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	};
	
}

public class MindMap {
	public static void main(String[] args) {
		new Window();
		
	}
}