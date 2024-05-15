package ZhangandAO;

import java.awt.*;

public class Bg {
    Image bg= Toolkit.getDefaultToolkit().getImage("imgs/bg.jpg");
    Image bg1= Toolkit.getDefaultToolkit().getImage("imgs/bg1.jpg");
    Image miner= Toolkit.getDefaultToolkit().getImage("imgs/miner.png");


    void paintSelf(Graphics g) {
        g.drawImage(bg,0,200,null);
        g.drawImage(bg1,0,0,null);
       g.drawImage(miner,290,35,null);
    }

}
