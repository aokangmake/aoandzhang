package ZhangandAO;

import java.awt.*;

//在此父类中定义岩石和金块的共同属性
public class Object {
    //坐标
    int x;
    int y;
    //宽高
    int width;
    int height;
    //图片
    Image img;

    void paintSelf(Graphics g)
    {
        g.drawImage(img,x,y,null);
    }

}
