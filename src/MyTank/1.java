package MyTank;

import java.util.Vector;

class Tank
{
	boolean isLive=true;
	int x=0;
	int y=0;
	int direct=0;//设置坦克反向
	public int getDirect() {
		return direct;
	}
	public void setDirect(int direct) {
		this.direct = direct;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	int speed=3;//设置坦克速度
	public Tank(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}




}
class Hero extends Tank
{
	public Hero(int x,int y)
	{
		super(x,y);
	}
	public void moveUp()//坦克移动
	{
		y-=speed;
	}
	public void moveRight() {
		x+=speed;
	}
	public void moveDown()
	{
		y+=speed;
	}
	public void moveLeft()
	{
		x-=speed;
	}
	Vector<Shot> ss=new Vector<Shot>();//定义子弹向量

	Shot s=null;//定义子弹

	public void ShotEnemy()//生成子弹方法
	{
		switch(direct)
		{
			case 0:
				s=new Shot(x+10,y,0);
				ss.add(s);//把子弹添加到向量
				break;
			case 1:
				s=new Shot(x+30,y+10,1);
				ss.add(s);
				break;
			case 2:
				s=new Shot(x+10,y+30,2);
				ss.add(s);
				break;
			case 3:
				s=new Shot(x,y+10,3);
				ss.add(s);
				break;

		}
		Thread t=new Thread(s);
		t.start();
	}

}
class EnemyTank extends Tank implements Runnable
{

	int speed=2;
	Vector<Shot> ss=new Vector<Shot>();//定义子弹向量
	public EnemyTank(int x,int y)
	{
		super(x,y);
	}






	//让坦克跑起来
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			switch(direct)
			{
				case 0:
					for(int i=0;i<60;i++)//让坦克一个方向跑30步
					{
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						if(y<580)
						{
							y+=speed;
						}
					}
					break;
				case 1:
					for(int i=0;i<60;i++)
					{
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						if(x<580)
						{
							x+=speed;
						}
					}
					break;
				case 2:
					for(int i=0;i<60;i++)
					{
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						if(y>0)
						{
							y-=speed;
						}
					}
					break;
				case 3:
					for(int i=0;i<60;i++)
					{
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						if(x>0)
						{
							x-=speed;
						}
					}
					break;
			}
			direct=(int) (Math.random()*4);
			if(isLive==false)
			{
				break;
			}
		}

	}
}
class Shot implements Runnable//子弹
{
	int x;
	int y;
	int direct;
	int speed=8;//子弹速度
	boolean isLive=true;
	public Shot(int x,int y,int direct)

	{
		this.x=x;
		this.y=y;
		this.direct=direct;

	}
	@Override
	public void run() {//子弹线程
		// TODO Auto-generated method stub
		while(true)
		{
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			switch(direct) {
				case 0:
					y-=speed;
					break;
				case 1:
					x+=speed;
					break;
				case 2:
					y+=speed;
					break;
				case 3:
					x-=speed;
					break;
			}
			//System.out.println("子弹坐标"+x+","+y);
			if(x<0||x>600||y<0||y>600)//判断子弹什么时候消失
			{
				isLive=false;
				break;
			}
		}
	}

}