package View;

import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.border.EmptyBorder;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class MainView extends JFrame implements KeyListener{
	
	private JPanel contentPane;
	BufferedImage img = null;
	Image image;
    int x = 100, y = 100;
   
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
					MainView frame = new MainView(400,325);
					frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public MainView(int x, int y) {
		super("Main"); // ���α׷� ��
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setSize(800,800);
		layeredPane.setLayout(null);
		setResizable(false);  //â ũ�� ����
		
		try {
			img = ImageIO.read(new File("./image/mainimage.png"));
			setIconImage(Toolkit.getDefaultToolkit().getImage("./image/����.png"));
		}catch(IOException e) {
			JOptionPane.showMessageDialog(null, "�̹��� �ҷ����� ����");
			System.exit(0);
		}
		myPanel panel = new myPanel();
		panel.setSize(800,800);
		layeredPane.add(panel);
		panel.setVisible(true);
		
		add(layeredPane);
		addKeyListener(this);  //frame�� KeyListener ����
        
//        this.x = (int)getWidth() / 2;   //frame�� �ʺ� ���
//        this.y = (int)getHeight() / 2;

		this.x = x;
		this.y = y;
		
		
	}
	public void wantTogo() {// â�� �ٲ�� �޼ҵ�
		if(x >= 40 && x <=110 && y >=445 && y<=615) {
			this.setVisible(false);
			new Forest().setVisible(true);//������ �̵�
		}
		else if(x >=70 && x <=90 && y == 245) {
			this.setVisible(false);
			new Zoo().setVisible(true);//���������� �̵�
		}
		else if(x >= 590 && x<=620 && y == 245) {
			this.setVisible(false);
			new Gym().setVisible(true);//���ÿ����� �̵�
		}
		else if(x>=690 && x <=750 && y >= 385 && y <=425) {
			this.setVisible(false);
			new Home().setVisible(true);//������ �̵�
		}
		else if(x>=700 && x<=750 && y >= 565 && y<=575) {
			this.setVisible(false);
			new PetShop().setVisible(true);//�꼥���� �̵�
		}
		
	}
	
	class myPanel extends JPanel{
		public void paint(Graphics g) {
			super.paint(g);
			g.drawImage(img,0,0,null);
		}
	}
	class forestPanel extends JPanel{
		public void paint(Graphics g) {
			super.paint(g);
			g.drawImage(img, 0, 0, null);
		}
	}
	@Override
    public void keyPressed(java.awt.event.KeyEvent e) {
           int key = e.getKeyCode();
                  if(key == e.VK_RIGHT ||
                        key == e.VK_NUMPAD6 || //����Ű NUMPAD
                               key == e.VK_KP_RIGHT) {
                  
                  x = (x < getWidth()-30)?x + 10 :x;
                  System.out.println(x+","+y);
                  }
                  else{int key1 = e.getKeyCode();
                               if(key1 == e.VK_LEFT ||
                                      key1 == e.VK_NUMPAD4 || //����Ű NUMPAD 
                                             key1 == e.VK_KP_LEFT) {
                               
                               x = (x > 30)?x - 10 :x;
                               System.out.println(x+","+y);
                  }
                               int key2 = e.getKeyCode();
                               if(key2 == e.VK_UP ||
                                      key2 == e.VK_NUMPAD8 || //����Ű NUMPAD 
                                             key2 == e.VK_KP_UP) {
                               
                               y = (y > 75)?y - 10 : y;
                               System.out.println(x+","+y);
                                      
                  }
                               int key3 = e.getKeyCode();
                               if(key3 == e.VK_DOWN ||
                                      key3 == e.VK_NUMPAD2 || //����Ű NUMPAD 
                                             key3 == e.VK_KP_DOWN) {
                               
                               y = (y < getHeight()-40)?y + 10 : y;
                               System.out.println(x+","+y);
           
                               }
                  }
                  repaint(); //�ѹ� �����ϸ� �ٽ� ���� �̹����� ����
                  wantTogo();
    	}
           
    
    @Override
    public void paint(Graphics g) {
    	super.paint(g);
           
        image = Toolkit.getDefaultToolkit().getImage("./image/����.png"); 
                  
           
           
           g.drawImage(image,
                        x - image.getWidth(this) / 2  ,
                        y - image.getHeight(this) / 2 , this);
    }
    
    @Override
    public void keyReleased(java.awt.event.KeyEvent arg0) {}
    @Override
    public void keyTyped(java.awt.event.KeyEvent arg0) {}
    
}
