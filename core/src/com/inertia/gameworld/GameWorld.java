package com.inertia.gameworld;

import com.inertia.gameobjects.*;

import java.io.PrintStream;

public class GameWorld
{
  private Nolan nolan;
  private Bed Bed;
  private Bookshelf Bookshelf;
  private Desk Desk;
  private Tv Tv;
  private Window window;
  private TopWall TWall;
  private TopWall TWall2R1;
  private TopWall TWall2;
  private BottomWall BWall;
  private BottomWall BWall2;
  private OpenWall RWall;
  private OpenWall RWall2R1;
  private RightWall RWall2;
  private LeftWall LWall;
  private LeftWall LWall2;
  private Door Door;
  private Door2 Door2;
  
  public GameWorld()
  {
    this.nolan = new Nolan(522.0F, 328.0F, 36, 64);
    this.TWall = new TopWall(390.0F, 160.0F, 350, 50);
    this.TWall2R1 = new TopWall(740.0F, 260.0F, 100, 50);
    this.BWall = new BottomWall(390.0F, 460.0F, 450, 16);
    this.RWall = new OpenWall(740.0F, 160.0F, 16, 199);
    this.RWall2R1 = new OpenWall(840.0F, 260.0F, 16, 199);
    this.LWall = new LeftWall(374.0F, 160.0F, 16, 300);
    
    this.TWall2 = new TopWall(1320.0F, 160.0F, 600, 50);
    this.BWall2 = new BottomWall(1320.0F, 460.0F, 600, 16);
    this.RWall2 = new RightWall(1920.0F, 160.0F, 16, 300);
    this.LWall2 = new LeftWall(1304.0F, 160.0F, 16, 300);
    
    this.Door2 = new Door2(this.TWall2.getX() + 50.0F, this.TWall2.getY() + 10.0F);
    this.Door = new Door(this.TWall2R1.getX() + this.TWall2R1.getWidth()/4 - 10, this.TWall2R1.getY() + 10.0F);
    this.Bed = new Bed(390.0F, 240.0F);
    this.Bookshelf = new Bookshelf(this.TWall.getX() + 220.0F, this.TWall.getY() + 50.0F,70,92);
    this.Desk = new Desk(this.TWall.getX()+5, this.TWall.getY() + 190.0F,96,104);
    this.Tv = new Tv(this.TWall.getX() + 170.0F, this.TWall.getY() + 50.0F);
    this.window = new Window(this.TWall.getX() + this.TWall.getWidth() - 275.0F, this.TWall.getY()+15, 76, 50);
  }
  
  public void update(float delta)
  {
    this.nolan.update(delta);
    if ((this.TWall.collides(this.nolan)) || (this.TWall2.collides(this.nolan) || (this.TWall2R1.collides(this.nolan)))) {
      this.nolan.topStop();
    } else {
      this.nolan.setTopStop(false);
    }
    if ((this.BWall.collides(this.nolan)) || (this.BWall2.collides(this.nolan))) {
      this.nolan.bottomStop();
    } else {
      this.nolan.setBottomStop(false);
    }
    if ((this.RWall2.collides(this.nolan))) {
      this.nolan.rightStop();
    } else {
      this.nolan.setRightStop(false);
    }
    if ((this.LWall.collides(this.nolan)) || (this.LWall2.collides(this.nolan))) {
      this.nolan.leftStop();
    } else {
      this.nolan.setLeftStop(false);
    }
    if (this.Bed.checkCollides(this.nolan)) {
      this.Bed.collisionDirection(this.nolan);
    }
    if (this.Bookshelf.checkCollides(this.nolan)) {
        this.Bookshelf.collisionDirection(this.nolan);
    }
    if (this.Tv.checkCollides(this.nolan)) {
      this.Tv.collisionDirection(this.nolan);
    }
    if (this.Desk.checkCollides(this.nolan)) {
        this.Desk.collisionDirection(this.nolan);
      }
    if (this.RWall.checkCollides(this.nolan)) {
        this.RWall.collisionDirection(this.nolan);
    }
    if (this.RWall2R1.checkCollides(this.nolan)) {
        this.RWall2R1.collisionDirection(this.nolan);
    }
    if (this.window.checkCollides(this.nolan)) {
        this.window.collisionDirection(this.nolan);
    }
    if (this.Door.checkCollides(this.nolan)) {
      this.Door.collisionDirection(this.nolan);
    }
    if (this.Door2.checkCollides(this.nolan)) {
      this.Door2.collisionDirection(this.nolan);
    }
    if (this.nolan.getSwitchHallway().booleanValue())
    {
      this.nolan.setPosition(this.Door2.getX() + 16.0F, this.Door2.getY() + this.Door2.getHeight());
      this.nolan.setSwitchHallway(false);
    }
    if (this.nolan.getSwitchBedroom().booleanValue())
    {
      this.nolan.setPosition(this.Door.getX() + 16.0F, this.Door.getY() + this.Door.getHeight());
      this.nolan.setSwitchBedroom(false);
    }
  }
  
  public Nolan getNolan()
  {
    return this.nolan;
  }
  
  public Bed getBed()
  {
    return this.Bed;
  }
  
  public Bookshelf getBookshelf()
  {
    return this.Bookshelf;
  }
  
  public Desk getDesk()
  {
    return this.Desk;
  }
  
  public Door getDoor()
  {
    return this.Door;
  }
  
  public Door2 getDoor2()
  {
    return this.Door2;
  }
  
  public Tv getTv()
  {
    return this.Tv;
  }
  
  public Window getWindow(){
	  return this.window;
  }
  
  public TopWall getTWall()
  {
    return this.TWall;
  }
  public TopWall getTWall2R1()
  {
	    return this.TWall2R1;
	  }
  
  public TopWall getTWall2()
  {
    return this.TWall2;
  }
  
  public BottomWall getBWall()
  {
    return this.BWall;
  }
  
  public BottomWall getBWall2()
  {
    return this.BWall2;
  }
  
  public OpenWall getRWall()
  {
    return this.RWall;
  }
  
  public OpenWall getRWall2R1()
  {
    return this.RWall2R1;
  }
  
  public RightWall getRWall2()
  {
    return this.RWall2;
  }
  
  public LeftWall getLWall()
  {
    return this.LWall;
  }
  
  public LeftWall getLWall2()
  {
    return this.LWall2;
  }
}
