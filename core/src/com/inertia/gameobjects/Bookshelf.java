package com.inertia.gameobjects;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import java.io.PrintStream;

public class Bookshelf
{
  private Vector2 position;
  private Vector2 topLeft;
  private Vector2 topRight;
  private Vector2 bottomLeft;
  private Vector2 bottomRight;
  private Rectangle top;
  private Rectangle bottom;
  private Rectangle right;
  private Rectangle left;
  private boolean topIntersect;
  private boolean bottomIntersect;
  private boolean rightIntersect;
  private boolean leftIntersect;
  private boolean posTop;
  private boolean posBottom;
  private boolean posRight;
  private boolean posLeft;
  private boolean on;
  private int power;
  private int incPower = 0;
  private float width;
  private float height;
  private Rectangle window;
  
  public Bookshelf(float x, float y,float w ,float h)
  {
    this.position = new Vector2(x, y);
    this.window = new Rectangle(x, y, w, h);
    
    width = w;
    height = h;
    
    this.top = new Rectangle(x, y, getWidth(),1);
    this.bottom = new Rectangle(x, y + height, getWidth(), 1.0F);
    this.left = new Rectangle(x, y, 1.0F, getHeight()-32);
    this.right = new Rectangle(x + width, y, 1.0F, getHeight()-32);
  }
  
  public Rectangle getTv()
  {
    return this.window;
  }
  
  public float getWidth()
  {
    return width;
  }
  
  public float getHeight()
  {
    return height;
  }
  
  public float getX()
  {
    return this.position.x;
  }
  
  public float getY()
  {
    return this.position.y;
  }
  
  public void increasePower()
  {
    if (this.power < 40) {
      this.power += 1;
    }
  }
  
  public int getPower()
  {
    return this.power;
  }
  
  public boolean getOn()
  {
    return this.on;
  }
  
  public void checkInteract(Nolan nolan)
  {
    if (nolan.getInteract().booleanValue()) {
      interact(nolan);
    }
  }
  
  public Object interact(Nolan nolan)
  {
    System.out.println("This is a bookshelf.");
    this.on = (!this.on);
    nolan.setInteract(Boolean.valueOf(false));
    return Integer.valueOf(0);
  }
  
  public Vector2 getCenter()
  {
    return new Vector2(this.position.x + 21.0F, this.position.y + 37.0F);
  }
  
  public boolean checkCollides(Nolan nolan)
  {
    return Intersector.overlaps(nolan.getBoundingRect(), this.window);
  }
  
  public void collisionDirection(Nolan nolan)
  {
    this.topIntersect = Intersector.overlaps(this.top, nolan.getBoundingRect());
    this.bottomIntersect = Intersector.overlaps(this.bottom, nolan.getBoundingRect());
    this.rightIntersect = Intersector.overlaps(this.right, nolan.getBoundingRect());
    this.leftIntersect = Intersector.overlaps(this.left, nolan.getBoundingRect());
    
    this.posTop = (nolan.getY() + nolan.getHeight() <= getY());
    this.posBottom = (nolan.getY() <= getY() + height - nolan.getHeight()/2);
    this.posRight = (nolan.getX() >= getX() + width - nolan.getWidth());
    this.posLeft = (nolan.getX() + nolan.getWidth() <= getX() + nolan.getWidth());
    if (this.posTop) {
      if (this.topIntersect)
      {
        checkInteract(nolan);
        nolan.bottomStop();
        
        return;
      }
    }
    if (this.posBottom) {
      if (this.bottomIntersect)
      {
        checkInteract(nolan);
        nolan.topStop();
        
        return;
      }
    }
    if (this.posRight) {
      if (this.rightIntersect)
      {
        checkInteract(nolan);
        nolan.leftStop();
        
        return;
      }
    }
    if (this.posLeft) {
      if (this.leftIntersect)
      {
        checkInteract(nolan);
        nolan.rightStop();
        
        return;
      }
    }
  }
}
