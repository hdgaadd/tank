
package MyTank;
import java.awt.*;
import java.util.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
public class MyTankMain extends JFrame{
	MyPanel mp;//定义组件
	public static void main(String[] args) {
		MyTankMain mt=new MyTankMain();

	}
	public MyTankMain()
	{
		mp=new MyPanel();//创建组件
		this.add(mp);
		this.addKeyListener(mp);

		Thread t=new Thread(mp);//刷新画面的线程
		t.start();


		this.setTitle("hdgaadd~坦克大战");
		this.setSize(600,600);
		this.setLocation(200,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	class MyPanel extends JPanel implements KeyListener, Runnable
	{
		Hero hr;//定义我的坦克

		Vector<EnemyTank> ets=new Vector<EnemyTank>();//创建敌人坦克集合
		EnemyTank et;//定义敌人坦克/*ets是集合对象*/
		int ensize=10;//设置敌人坦克个数





		public MyPanel()//构造函数传值
		{
			hr=new Hero(270,460);//创建我的坦克对象

			for(int i=0;i<ensize;i++)//创建敌人坦克对象
			{

				et=new EnemyTank((i+1)*50,0);
				ets.add(et);
				et.setDirect(2);//设置敌人坦克方向


				Thread t=new Thread(et);//让坦克不断改变方向
				t.start();

				Shot s=new Shot(et.x+10,et.y+30,2);//给敌人坦克添加子弹
				et.ss.add(s);
				Thread t1=new Thread(s);
				t1.start();



			}

		}
		public void hitMe()
		{
			for(int i=0;i<this.ets.size();i++)
			{
				EnemyTank et=ets.get(i);
				for(int j=0;j<et.ss.size();j++)
				{
					Shot enemyShot=et.ss.get(j);
					this.hitTank(enemyShot, hr);
				}
			}
		}
		public void hitEnemyTank()
		{
			//使用线程全程去判断子弹是否击中
			for(int i=0;i<hr.ss.size();i++)
			{
				Shot myShot=hr.ss.get(i);//取出每颗子弹和每个坦克判断是否击中
				if(myShot.isLive==true)//必须是活的子弹
				{
					for(int j=0;j<ets.size();j++)
					{
						EnemyTank emTank=ets.get(j);
						if(emTank.isLive==true)//必须是活的坦克
						{
							this.hitTank(myShot, emTank);
						}
					}
				}
			}
		}


		//判断子弹是否击中坦克
		public void hitTank(Shot s,Tank et)//把子弹和坦克对象传进来
		{
			switch(et.direct)
			{
				case 0:
				case 2:
					if(s.x>et.x&&s.x<et.x+20&&s.y>et.y&&s.y<et.y+30)
					{
						//击中
						//子弹消失
						//坦克消失
						s.isLive=false;//必须是活的子弹才能被画出，所以该方法能使子弹消失
						et.isLive=false;//必须是活的坦克才能被画出，所以该方法能使坦克消失

					}
				case 1:
				case 3:
					if(s.x>et.x&&s.x<et.x+30&&s.y>et.y&&s.y<et.y+20)
					{
						//击中
						//子弹消失
						//坦克消失
						s.isLive=false;
						et.isLive=false;

					}
			}
		}

		public void paint(Graphics g)//重写JPanel的paint方法
		{
			super.paint(g);
			g.setColor(Color.black);
			g.fillRect(0,0,600,600);//设置黑色背景
			if(hr.isLive) {
				this.drawTank(hr.getX(), hr.getY(), g, hr.direct, 0);//画出我的坦克
			}

			for(int i=0;i<ensize;i++)
			{//画出敌人坦克再画出敌人的子弹，第二次画出不同的敌人坦克和不同的敌人子弹(每个敌人坦克的子弹都是不同的)

				EnemyTank et=ets.get(i);//取出一个坦克
				if(et.isLive==true)//必须是活的坦克
				{
					this.drawTank(et.getX(),et.getY(),g,et.getDirect(),1);
					for(int j=0;j<et.ss.size();j++)//画出子弹
					{//et.ss.size()指一个坦克对象属于它自己的子弹个数，默认该坦克的子弹个数是1
						Shot enemyShot=et.ss.get(j);//取出属于该坦克的子弹
						if(enemyShot.isLive==true)
						{
							g.draw3DRect(enemyShot.x, enemyShot.y, 1, 1, false);//画出该坦克的子弹
						}
						else
						{
							et.ss.remove(enemyShot);//如果敌人坦克子弹消失就把它的对象移除
						}

					}


				}
			}




			for(int i=0;i<hr.ss.size();i++)
			{
				Shot myShot=hr.ss.get(i);//从向量里拿出一颗子弹并画出
				if(myShot!=null&&myShot.isLive==true)//画出子弹
				{//“hr.s”指s对象是在Hero里创建的
					g.draw3DRect(myShot.x, myShot.y, 1, 1, false);
				}
				if(myShot.isLive==false)
				{
					hr.ss.remove(myShot);//让碰到边框的子弹的对象消失，才可以才生成新的子弹
				}

			}
		}
		//画出坦克
		public void drawTank(int x,int y,Graphics g,int direct,int type)
		{
			switch(type)//判断坦克类型
			{
				case 0:
					g.setColor(Color.GREEN);
					switch(direct)//判断方向
					{
						case 0://画出向上的坦克
							g.fill3DRect(x, y, 5, 30, false);
							g.fill3DRect(x+15, y, 5, 30, false);
							g.fill3DRect(x+5, y+5, 10, 20, false);



							g.drawLine(x,y+5, x+5, y+5);
							g.drawLine(x,y+10, x+5, y+10);
							g.drawLine(x,y+15, x+5, y+15);
							g.drawLine(x,y+20, x+5, y+20);
							g.drawLine(x,y+25, x+5, y+25);


							g.drawLine(x+15,y+5, x+20, y+5);
							g.drawLine(x+15,y+10, x+20, y+10);
							g.drawLine(x+15,y+15, x+20, y+15);
							g.drawLine(x+15,y+20, x+20, y+20);
							g.drawLine(x+15,y+25, x+20, y+25);


							g.fillOval(x+5, y+10, 10, 10);
							g.drawLine(x+10,y+15, x+10, y-3);
							break;
						//向下走的坦克
						case 2:
							//1、画出左边的矩形
							g.fill3DRect(x, y, 5, 30, false);
							//2、画出右边的矩形
							g.fill3DRect(x+15, y, 5, 30, false);
							//3、画出中间矩形
							g.fill3DRect(x+5, y+5, 10, 20, false);



							g.drawLine(x,y+5, x+5, y+5);
							g.drawLine(x,y+10, x+5, y+10);
							g.drawLine(x,y+15, x+5, y+15);
							g.drawLine(x,y+20, x+5, y+20);
							g.drawLine(x,y+25, x+5, y+25);


							g.drawLine(x+15,y+5, x+20, y+5);
							g.drawLine(x+15,y+10, x+20, y+10);
							g.drawLine(x+15,y+15, x+20, y+15);
							g.drawLine(x+15,y+20, x+20, y+20);
							g.drawLine(x+15,y+25, x+20, y+25);


							//4、画出中间圆形
							g.fillOval(x+5, y+10, 10, 10);
							//5、画出线(炮筒)
							g.drawLine(x+10, y+15, x+10, y+32);

							break;
						//向左走的坦克
						case 3:
							//1、画出上边的矩形
							g.fill3DRect(x, y, 30, 5, false);
							//2、画出下边的矩形
							g.fill3DRect(x, y+15, 30, 5, false);
							//3、画出中间矩形
							g.fill3DRect(x+5, y+5, 20, 10, false);



							g.drawLine(x+5,y, x+5, y+5);
							g.drawLine(x+10,y, x+10, y+5);
							g.drawLine(x+15,y, x+15, y+5);
							g.drawLine(x+20,y, x+20, y+5);
							g.drawLine(x+25,y, x+25, y+5);

							g.drawLine(x+5,y+15, x+5, y+20);
							g.drawLine(x+10,y+15, x+10, y+20);
							g.drawLine(x+15,y+15, x+15, y+20);
							g.drawLine(x+20,y+15, x+20, y+20);
							g.drawLine(x+25,y+15, x+25, y+20);


							//4、画出中间圆形
							g.fillOval(x+10, y+5, 10, 10);
							//5、画出线(炮筒)
							g.drawLine(x+15, y+10, x-3, y+10);

							break;
						//向右走的坦克
						case 1:
							//1、画出左边的矩形
							g.fill3DRect(x, y, 30, 5, false);
							//2、画出右边的矩形
							g.fill3DRect(x, y+15, 30, 5, false);
							//3、画出中间矩形
							g.fill3DRect(x+5, y+5, 20, 10, false);




							g.drawLine(x+5,y, x+5, y+5);
							g.drawLine(x+10,y, x+10, y+5);
							g.drawLine(x+15,y, x+15, y+5);
							g.drawLine(x+20,y, x+20, y+5);
							g.drawLine(x+25,y, x+25, y+5);

							g.drawLine(x+5,y+15, x+5, y+20);
							g.drawLine(x+10,y+15, x+10, y+20);
							g.drawLine(x+15,y+15, x+15, y+20);
							g.drawLine(x+20,y+15, x+20, y+20);
							g.drawLine(x+25,y+15, x+25, y+20);


							//4、画出中间圆形
							g.fillOval(x+10, y+5, 10, 10);
							//5、画出线(炮筒)
							g.drawLine(x+15, y+10, x+32, y+10);
							break;


					}
					break;
				case 1:
					g.setColor(Color.MAGENTA);
					switch(direct)//判断方向
					{
						case 0://画出向上的坦克
							g.fill3DRect(x, y, 5, 30, false);
							g.fill3DRect(x+15, y, 5, 30, false);
							g.fill3DRect(x+5, y+5, 10, 20, false);



							g.drawLine(x,y+5, x+5, y+5);
							g.drawLine(x,y+10, x+5, y+10);
							g.drawLine(x,y+15, x+5, y+15);
							g.drawLine(x,y+20, x+5, y+20);
							g.drawLine(x,y+25, x+5, y+25);


							g.drawLine(x+15,y+5, x+20, y+5);
							g.drawLine(x+15,y+10, x+20, y+10);
							g.drawLine(x+15,y+15, x+20, y+15);
							g.drawLine(x+15,y+20, x+20, y+20);
							g.drawLine(x+15,y+25, x+20, y+25);

							g.setColor(Color.yellow);
							g.fillOval(x+5, y+10, 10, 10);
							g.drawLine(x+10,y+15, x+10, y-3);
							break;
						//向下走的坦克
						case 2:
							//1、画出左边的矩形
							g.fill3DRect(x, y, 5, 30, false);
							//2、画出右边的矩形
							g.fill3DRect(x+15, y, 5, 30, false);
							//3、画出中间矩形
							g.fill3DRect(x+5, y+5, 10, 20, false);



							g.drawLine(x,y+5, x+5, y+5);
							g.drawLine(x,y+10, x+5, y+10);
							g.drawLine(x,y+15, x+5, y+15);
							g.drawLine(x,y+20, x+5, y+20);
							g.drawLine(x,y+25, x+5, y+25);


							g.drawLine(x+15,y+5, x+20, y+5);
							g.drawLine(x+15,y+10, x+20, y+10);
							g.drawLine(x+15,y+15, x+20, y+15);
							g.drawLine(x+15,y+20, x+20, y+20);
							g.drawLine(x+15,y+25, x+20, y+25);

							g.setColor(Color.yellow);
							//4、画出中间圆形
							g.fillOval(x+5, y+10, 10, 10);
							//5、画出线(炮筒)
							g.drawLine(x+10, y+15, x+10, y+32);

							break;
						//向左走的坦克
						case 3:
							//1、画出上边的矩形
							g.fill3DRect(x, y, 30, 5, false);
							//2、画出下边的矩形
							g.fill3DRect(x, y+15, 30, 5, false);
							//3、画出中间矩形
							g.fill3DRect(x+5, y+5, 20, 10, false);



							g.drawLine(x+5,y, x+5, y+5);
							g.drawLine(x+10,y, x+10, y+5);
							g.drawLine(x+15,y, x+15, y+5);
							g.drawLine(x+20,y, x+20, y+5);
							g.drawLine(x+25,y, x+25, y+5);

							g.drawLine(x+5,y+15, x+5, y+20);
							g.drawLine(x+10,y+15, x+10, y+20);
							g.drawLine(x+15,y+15, x+15, y+20);
							g.drawLine(x+20,y+15, x+20, y+20);
							g.drawLine(x+25,y+15, x+25, y+20);

							g.setColor(Color.yellow);
							//4、画出中间圆形
							g.fillOval(x+10, y+5, 10, 10);
							//5、画出线(炮筒)
							g.drawLine(x+15, y+10, x-3, y+10);

							break;
						//向右走的坦克
						case 1:
							//1、画出左边的矩形
							g.fill3DRect(x, y, 30, 5, false);
							//2、画出右边的矩形
							g.fill3DRect(x, y+15, 30, 5, false);
							//3、画出中间矩形
							g.fill3DRect(x+5, y+5, 20, 10, false);




							g.drawLine(x+5,y, x+5, y+5);
							g.drawLine(x+10,y, x+10, y+5);
							g.drawLine(x+15,y, x+15, y+5);
							g.drawLine(x+20,y, x+20, y+5);
							g.drawLine(x+25,y, x+25, y+5);

							g.drawLine(x+5,y+15, x+5, y+20);
							g.drawLine(x+10,y+15, x+10, y+20);
							g.drawLine(x+15,y+15, x+15, y+20);
							g.drawLine(x+20,y+15, x+20, y+20);
							g.drawLine(x+25,y+15, x+25, y+20);

							g.setColor(Color.yellow);
							//4、画出中间圆形
							g.fillOval(x+10, y+5, 10, 10);
							//5、画出线(炮筒)
							g.drawLine(x+15, y+10, x+32, y+10);
							break;


					}
					break;
			}


		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyPressed(KeyEvent e) {//内容写在keyPressed上
			// TODO Auto-generated method stub
			if(e.getKeyCode()==KeyEvent.VK_W)
			{
				this.hr.setDirect(0);
				this.hr.moveUp();
			}
			else if(e.getKeyCode()==KeyEvent.VK_D)
			{
				this.hr.setDirect(1);
				this.hr.moveRight();
			}
			else if(e.getKeyCode()==KeyEvent.VK_S)
			{
				this.hr.setDirect(2);
				this.hr.moveDown();
			}
			else if(e.getKeyCode()==KeyEvent.VK_A)
			{
				this.hr.setDirect(3);
				this.hr.moveLeft();
			}
			if(e.getKeyCode()==KeyEvent.VK_J)
			{
				if(hr.ss.size()<6) //控制子弹个数为6
				{
					this.hr.ShotEnemy();//调用子弹方法
				}


			}
			this.repaint();//重绘
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true)
			{
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}



				//为敌人坦克添加子弹
				for(int i=0;i<ets.size();i++)
				{
					EnemyTank et=ets.get(i);
					if(et.isLive)
					{
						if(et.ss.size()<1)
						{
							Shot s=null;
							switch(et.direct)
							{
								case 0:
									s=new Shot(et.x+10,et.y,0);
									et.ss.add(s);//把子弹添加到向量
									break;
								case 1:
									s=new Shot(et.x+30,et.y+10,1);
									et.ss.add(s);
									break;
								case 2:
									s=new Shot(et.x+10,et.y+30,2);
									et.ss.add(s);
									break;
								case 3:
									s=new Shot(et.x,et.y+10,3);
									et.ss.add(s);
									break;
							}
							Thread t=new Thread(s);
							t.start();
						}

					}
				}

				this.hitEnemyTank();
				this.hitMe();
				this.repaint();
			}
		}



	}
}