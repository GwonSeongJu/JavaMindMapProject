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
	
	JPanel Attribute;
	JTextField textBox; //Attribute Pane ��ҵ�
	JTextField xBox;
	JTextField yBox;
	JTextField wBox;
	JTextField hBox;
	JTextField colorBox;
	JButton change;
	
	Font paneFont = new Font("����", Font.PLAIN, 40); //Attribute Pane�� ����� ��Ʈ
	Font labelFont = new Font("Arial", Font.BOLD, 30); //Pane �̸��� ����� ��Ʈ
	Font nodeFont = new Font("����", Font.PLAIN, 20); //node�� ����� ��Ʈ
	
	JavaTree<JLabel> storage;	//node�����
	
	JLabel labelPointer = null;
	
	JLabel pointW;
	
	public Window() {
		System.out.println("windowȣ��");
		storage = new JavaTree<JLabel>();
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
		setJMenuBar(menu);
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
		menuApply.addActionListener(new ApplyListener());
		menuChange.addActionListener(new ChangeListener());
		menuClose.addActionListener(new CloseListener());
		
	
		
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
		toolApply.addActionListener(new ApplyListener());
		toolChange.addActionListener(new ChangeListener());
		toolClose.addActionListener(new CloseListener());

		
		
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
		TextArea.setTabSize(4);
		JScrollPane TextPane = new JScrollPane(TextArea);
		TextArea.setFont(nodeFont);
		MapPanel = new JPanel(); //���ε���� ��µǴ� ��
		MapPanel.setLayout(null);
		JScrollPane MapPane = new JScrollPane(MapPanel);
		Attribute = new JPanel(); //����� ������ ��µǴ� ��
		
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
		MapPanel.addMouseListener(new BackgroundClickListener());
		JLabel attributeLabel = new JLabel("Attribute Pane", SwingConstants.CENTER);  //Attribute Pane ����
		attributeLabel.setFont(labelFont);
		RightPane.add(attributeLabel, BorderLayout.NORTH);
		RightPane.add(AttributePane, BorderLayout.CENTER);
		JLabel textLabel = new JLabel("TEXT:	"); //AttribuePane ����
		textLabel.setFont(paneFont);
		Attribute.add(textLabel);
		textBox = new JTextField();
		textBox.setFont(nodeFont);
		Attribute.add(textBox);
		JLabel xLabel = new JLabel("X:	");
		xLabel.setFont(paneFont);
		Attribute.add(xLabel);
		xBox = new JTextField();
		xBox.setFont(paneFont);
		Attribute.add(xBox);
		JLabel yLabel = new JLabel("Y:	");
		yLabel.setFont(paneFont);
		Attribute.add(yLabel);
		yBox = new JTextField();
		yBox.setFont(paneFont);
		Attribute.add(yBox);
		JLabel wLabel = new JLabel("W:	");
		wLabel.setFont(paneFont);
		Attribute.add(wLabel);
		wBox = new JTextField();
		wBox.setFont(paneFont);
		Attribute.add(wBox);
		JLabel hLabel = new JLabel("H:	");
		hLabel.setFont(paneFont);
		Attribute.add(hLabel);
		hBox = new JTextField();
		hBox.setFont(paneFont);
		Attribute.add(hBox);
		JLabel colorLabel = new JLabel("Color:");
		colorLabel.setFont(paneFont);
		Attribute.add(colorLabel);
		colorBox = new JTextField();
		colorBox.addMouseListener(new ColorListener());
		colorBox.setFont(paneFont);
		Attribute.add(colorBox);
		change = new JButton("����");
		change.addActionListener(new ChangeListener());
		RightPane.add(change, BorderLayout.SOUTH);
		

		apply.addActionListener(new ApplyListener());
	}
	
	class CloseListener implements ActionListener{	//�ݱ� ������
		
		@Override
		public void actionPerformed(ActionEvent arg) {
			System.exit(0);
		}
	}
	
	class ColorListener extends MouseAdapter	{	//���� ���� ������
		
		@Override
		public void mouseClicked(MouseEvent arg) {
			if(labelPointer != null) {
				JTextField t = (JTextField)arg.getSource();
				Color selectedColor = JColorChooser.showDialog(null, "Color", labelPointer.getBackground());
				if(selectedColor != null) {
					String color = String.format("%02X" + "%02X" + "%02X", selectedColor.getRed(), selectedColor.getBlue(), selectedColor.getGreen());
					t.setText(color);
					t.setBackground(selectedColor);
				}
			}
		}
	}
	
	class BackgroundClickListener extends MouseAdapter{	//����� Ŭ���ؼ� ��� ��Ȱ��ȭ�ϴ� ������
		
		@Override
		public void mouseClicked(MouseEvent arg) {
			if(labelPointer != null)
				labelPointer.setBorder(LineBorder.createBlackLineBorder());
			labelPointer = null;
			textBox.setText("");
			xBox.setText("");
			yBox.setText("");
			hBox.setText("");
			wBox.setText("");
			colorBox.setText("");
			colorBox.setBackground(Color.WHITE);
		}
	}
	
	class NodeClickListener extends MouseAdapter{	//��� Ŭ���ؼ� Ȱ��ȭ��Ű�� ���� ����ϴ� ������
		

		
		@Override
		public void mouseClicked(MouseEvent arg) {
			updateInformation(arg);
		}
	}
	
	void updateInformation(MouseEvent arg) {
		JLabel l = (JLabel)arg.getSource();
		if(labelPointer != null)
			labelPointer.setBorder(LineBorder.createBlackLineBorder());
		labelPointer = l;
		l.setBorder(new LineBorder(Color.BLACK, 5));
		textBox.setText(l.getText());
		xBox.setText(String.valueOf(l.getX()));
		yBox.setText(String.valueOf(l.getY()));
		hBox.setText(String.valueOf(l.getHeight()));
		wBox.setText(String.valueOf(l.getWidth()));
		String color = String.format("%02X" + "%02X" + "%02X", l.getBackground().getRed(), l.getBackground().getBlue(), l.getBackground().getGreen());
		colorBox.setText(color);
		colorBox.setBackground(l.getBackground());
		//MapPanel.updateUI();
		System.out.println(arg.getComponent().getLocation());
	}
	
	class ChangeListener implements ActionListener{	//���� ������
		
		@Override
		public void actionPerformed(ActionEvent arg) {
			if(labelPointer != null) {
				labelPointer.setLocation(Integer.parseInt(xBox.getText()), Integer.parseInt(yBox.getText()));
				labelPointer.setText(textBox.getText());
				labelPointer.setBounds(Integer.parseInt(xBox.getText()), Integer.parseInt(yBox.getText()), Integer.parseInt(wBox.getText()), Integer.parseInt(hBox.getText()));
				labelPointer.setBackground(colorBox.getBackground());
			}
		}
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
	
					preLabel.setBounds(10, 10, 100, 50);
					preLabel.setBorder(LineBorder.createBlackLineBorder());
					preLabel.setPreferredSize(new Dimension(100, 50));
					preLabel.setBackground(Color.WHITE);
					preLabel.setFont(nodeFont);;
					preLabel.setHorizontalAlignment(SwingConstants.CENTER);
					preLabel.addMouseListener(new NodeClickListener());
					preLabel.addMouseMotionListener(new NodeDrag());
					preLabel.addMouseListener(new NodeDrag());
					MapPanel.add(preLabel);
					MapPanel.repaint();
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
	
	class NodeDrag implements MouseMotionListener, MouseListener{	//��� ���콺 �巡�� ������
		@Override
		public void mouseDragged(MouseEvent e) {
			updateInformation(e);
			int movedPointX = e.getComponent().getX() + e.getX();
			int movedPointY = e.getComponent().getY()+ e.getY();;
			e.getComponent().setLocation(movedPointX,movedPointY);
			
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			
		}

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			MapPanel.repaint();
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			DrawNodeLine(MapPanel.getGraphics(),storage.rootNode.getNext(0));
		}
		
	};
	
	void DrawNodeLine(Graphics g,Node<JLabel> root) {
		if(root.getNextNumber()==0)
			return;
		g.setColor(Color.BLACK);
		for(int i=0;i<root.getNextNumber();i++) {
			DrawNodeLine(g,root.getNext(i));
			int x1,x2,y1,y2;
			x1=root.getData().getX()+root.getData().getWidth()/2;
			y1=root.getData().getY()+root.getData().getHeight()/2;
			x2=root.getNext(0).getData().getX() + root.getNext(0).getData().getWidth()/2;
			y2=root.getNext(0).getData().getY() + root.getNext(0).getData().getHeight()/2;
			g.drawLine(x1,y1,x2,y2);
			root.getData().repaint();
			root.getNext(i).getData().repaint();
		}
	}
	
	
}

public class MindMap {
	public static void main(String[] args) {
		new Window();
		
	}
}