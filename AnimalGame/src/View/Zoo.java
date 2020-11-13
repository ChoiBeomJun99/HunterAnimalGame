package View;

import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.border.EmptyBorder;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Zoo extends JFrame implements KeyListener{

	private JPanel contentPane;
	BufferedImage img = null;
	Image image;
    int x = 100, y = 100;
   
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
					Zoo frame = new Zoo();
					frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public Zoo() {
		super("Zoo"); // ���α׷� ��
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
			img = ImageIO.read(new File("./image/Zoo.png"));
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
        
        x = (int)getWidth() / 2;   //frame�� �ʺ� ���
        y = (int)getHeight() / 2;
		
		
	}
	class myPanel extends JPanel{
		public void paint(Graphics g) {
			super.paint(g);
			g.drawImage(img,0,0,null);
		}
	}
	public void goMain() {
		 if(x ==420 && y >= 315 && y <=395) {
      	   this.setVisible(false);
      	   new MainView(80,275).setVisible(true);
		 }
	}
	@Override
    public void keyPressed(java.awt.event.KeyEvent e) {
		int key = e.getKeyCode();
        if(key == e.VK_RIGHT ||
              key == e.VK_NUMPAD6 || //����Ű NUMPAD
                     key == e.VK_KP_RIGHT) {
        
        	x = (x < getWidth()-380)?x + 10 :x;
        	System.out.println(x+","+y);
        }
        else{int key1 = e.getKeyCode();
                     if(key1 == e.VK_LEFT ||
                            key1 == e.VK_NUMPAD4 || //����Ű NUMPAD 
                                   key1 == e.VK_KP_LEFT) {
                     
                     x = (x > -320)?x - 10 :x;
                     System.out.println(x+","+y);
        }
                     int key2 = e.getKeyCode();
                     if(key2 == e.VK_UP ||
                            key2 == e.VK_NUMPAD8 || //����Ű NUMPAD 
                                   key2 == e.VK_KP_UP) {
                     
                     y = (y > 120)?y - 10 : y;
                     System.out.println(x+","+y);   
        }
                     int key3 = e.getKeyCode();
                     if(key3 == e.VK_DOWN ||
                            key3 == e.VK_NUMPAD2 || //����Ű NUMPAD 
                                   key3 == e.VK_KP_DOWN) {
                     
                     y = (y < getHeight()+10)?y + 10 : y;
                     
                     System.out.println(x+","+y);
                     }
        }
        repaint(); //�ѹ� �����ϸ� �ٽ� ���� �̹����� ����
        goMain();
    	}
           
    
    @Override
    public void paint(Graphics g) {
    	super.paint(g);
           
        image = Toolkit.getDefaultToolkit().getImage("./image/����.png"); 
                  
           
           
           g.drawImage(image,
                        x - image.getWidth(this) / 2 + 350,
                        y - image.getHeight(this) / 2 - 50, this);
    }
    
    @Override
    public void keyReleased(java.awt.event.KeyEvent arg0) {}
    @Override
    public void keyTyped(java.awt.event.KeyEvent arg0) {}
    
}
