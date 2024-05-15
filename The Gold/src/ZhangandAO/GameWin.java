package ZhangandAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameWin extends JFrame {
//在此处导入图片
Bg bg=new Bg();
Line line=new Line(this);
Gold gold=new Gold();

//定义一张画布来解决窗口中的元素闪动对的问题
    Image offScreenImage;

    void launch()
    {
        this.setVisible(true);
        this.setSize(768,1000);
        this.setLocationRelativeTo(null);
        this.setTitle("黄金矿工小游戏");

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(e.getButton()==1)
                {
                    line.state=1;
                }
            }
        });

        while(true) {
            repaint();

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    //图片绘制方法
    public void paint(Graphics g) {
        offScreenImage=this.createImage(768,1000);
        Graphics gImage=offScreenImage.getGraphics();

       bg.paintSelf(g);
       line.paintSelf(g);
       gold.paintSelf(g);
    }
    public static void main(String[] args) {
        GameWin gameWin=new GameWin();
    gameWin.launch();
    }
}
