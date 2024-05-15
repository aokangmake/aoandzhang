package ZhangandAO;

import java.awt.*;

public class Line {
    //这是线的起始坐标
    int x=380;
    int y=180;
    //终点坐标
    int endx=500;
    int endy=500;

    //线长
    double lenth=100;//设置红线的长度
    double n=0;//设置角度
    //方向
    int dir=1;

    //红线的状态如果0 左右摇摆，1 抓取，2 收回 3.抓取返回
    int state;

    GameWin frame;

    Line(GameWin frame) {this.frame=frame;}

    //判断方法
    void logic(){
  if(endx>this.frame.gold.x&&endx<this.frame.gold.x+this.frame.gold.width&&
    endy>this.frame.gold.y&&endy<this.frame.gold.y+this.frame.gold.height)
      {
      state=3;
      }
    }

    void lines(Graphics g)
    {
        endx=(int) (x+lenth* Math.cos(n*Math.PI ));//前面的endx是int类型，需要强制转换
        endy=(int) (x+lenth* Math.sin(n*Math.PI ));
        g.setColor(Color.red);
        g.drawLine(x,y,endx,endy);
    }

    void paintSelf(Graphics g) {
        //线的状态
        logic();
        switch(state)
        {
            case 0:
                //后续如果红线摇摆角度较大，来改这个，n<0.1;n>0.9
                if(n<0.1){dir=1;}
                else if(n>0.9) {dir=-1;}

                n=n+0.005*dir;
               lines(g);
                break;
            case 1:
                if(lenth<500){
                    lenth=lenth+10;
                   lines(g);
                }else{state=2;}
                break;
            case 2:
                if(lenth>100){
                    lenth=lenth-10;
                   lines(g);
                }else
                {
                    state=0;
                }
                break;
            case 3:
                if(lenth>100){
                    lenth=lenth-10;
                    lines(g);
                    this.frame.gold.x=endx-26;
                    this.frame.gold.y=endy;
                }else
                {
                    this.frame.gold.x=-150;
                    this.frame.gold.y=-150;
                    state=0;
                }
                break;
        }

    }
}
