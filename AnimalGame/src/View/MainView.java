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
		super("Main"); // 프로그램 명
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setSize(800,800);
		layeredPane.setLayout(null);
		setResizable(false);  //창 크기 고정
		
		try {
			img = ImageIO.read(new File("./image/mainimage.png"));
			setIconImage(Toolkit.getDefaultToolkit().getImage("./image/헌터.png"));
		}catch(IOException e) {
			JOptionPane.showMessageDialog(null, "이미지 불러오기 실패");
			System.exit(0);
		}
		myPanel panel = new myPanel();
		panel.setSize(800,800);
		layeredPane.add(panel);
		panel.setVisible(true);
		
		add(layeredPane);
		addKeyListener(this);  //frame에 KeyListener 장착
        
//        this.x = (int)getWidth() / 2;   //frame의 너비 얻기
//        this.y = (int)getHeight() / 2;

		this.x = x;
		this.y = y;
		
		
	}
	public void wantTogo() {// 창이 바뀌는 메소드
		if(x >= 40 && x <=110 && y >=445 && y<=615) {
			this.setVisible(false);
			new Forest().setVisible(true);//숲으로 이동
		}
		else if(x >=70 && x <=90 && y == 245) {
			this.setVisible(false);
			new Zoo().setVisible(true);//동물원으로 이동
		}
		else if(x >= 590 && x<=620 && y == 245) {
			this.setVisible(false);
			new Gym().setVisible(true);//수련원으로 이동
		}
		else if(x>=690 && x <=750 && y >= 385 && y <=425) {
			this.setVisible(false);
			new Home().setVisible(true);//집으로 이동
		}
		else if(x>=700 && x<=750 && y >= 565 && y<=575) {
			this.setVisible(false);
			new PetShop().setVisible(true);//펫샵으로 이동
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
                        key == e.VK_NUMPAD6 || //숫자키 NUMPAD
                               key == e.VK_KP_RIGHT) {
                  
                  x = (x < getWidth()-30)?x + 10 :x;
                  System.out.println(x+","+y);
                  }
                  else{int key1 = e.getKeyCode();
                               if(key1 == e.VK_LEFT ||
                                      key1 == e.VK_NUMPAD4 || //숫자키 NUMPAD 
                                             key1 == e.VK_KP_LEFT) {
                               
                               x = (x > 30)?x - 10 :x;
                               System.out.println(x+","+y);
                  }
                               int key2 = e.getKeyCode();
                               if(key2 == e.VK_UP ||
                                      key2 == e.VK_NUMPAD8 || //숫자키 NUMPAD 
                                             key2 == e.VK_KP_UP) {
                               
                               y = (y > 75)?y - 10 : y;
                               System.out.println(x+","+y);
                                      
                  }
                               int key3 = e.getKeyCode();
                               if(key3 == e.VK_DOWN ||
                                      key3 == e.VK_NUMPAD2 || //숫자키 NUMPAD 
                                             key3 == e.VK_KP_DOWN) {
                               
                               y = (y < getHeight()-40)?y + 10 : y;
                               System.out.println(x+","+y);
           
                               }
                  }
                  repaint(); //한번 실행하면 다시 원래 이미지로 복귀
                  wantTogo();
    	}
           
    
    @Override
    public void paint(Graphics g) {
    	super.paint(g);
           
        image = Toolkit.getDefaultToolkit().getImage("./image/헌터.png"); 
                  
           
           
           g.drawImage(image,
                        x - image.getWidth(this) / 2  ,
                        y - image.getHeight(this) / 2 , this);
    }
    
    @Override
    public void keyReleased(java.awt.event.KeyEvent arg0) {}
    @Override
    public void keyTyped(java.awt.event.KeyEvent arg0) {}
    
}
