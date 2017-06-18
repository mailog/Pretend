package com.inertia.gameobjects;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import java.io.PrintStream;

public class OpenWall
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
  private Rectangle Tv;
  
  public OpenWall(float x, float y, float w, float h)
  {
    this.position = new Vector2(x, y);
    this.Tv = new Rectangle(x, y, w, h);
    width = w;
    height = h;
    this.top = new Rectangle(x, y, getWidth(), 1.0F);
    this.bottom = new Rectangle(x, y + 74.0F - 50.0F, getWidth(), 1.0F);
    this.left = new Rectangle(x, y - 50.0F, 1.0F, getHeight());
    this.right = new Rectangle(x + 42.0F, y - 50.0F, 1.0F, getHeight());
  }
  
  public Rectangle getTv()
  {
    return this.Tv;
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
  
  public Vector2 getCenter()
  {
    return new Vector2(this.position.x + width/2.0F, this.position.y + height/2.0F);
  }
  
  public boolean checkCollides(Nolan nolan)
  {
    return Intersector.overlaps(nolan.getBoundingRect(), this.Tv);
  }
  
  public void collisionDirection(Nolan nolan)
  {
    this.topIntersect = Intersector.overlaps(this.top, nolan.getBoundingRect());
    this.bottomIntersect = Intersector.overlaps(this.bottom, nolan.getBoundingRect());
    this.rightIntersect = Intersector.overlaps(this.right, nolan.getBoundingRect());
    this.leftIntersect = Intersector.overlaps(this.left, nolan.getBoundingRect());
    
    this.posTop = (nolan.getY() + nolan.getHeight() <= getY() + 5.0F);
    this.posBottom = (nolan.getY() >= getY() + width - 55.0F);
    this.posRight = (nolan.getX() >= getX() + height - 55.0F);
    this.posLeft = (nolan.getX() + nolan.getWidth() <= getX() + 55.0F);
    if (this.posTop) {
      if (this.topIntersect)
      {
        nolan.bottomStop();
        
        return;
      }
    }
    if (this.posBottom) {
      if (this.bottomIntersect)
      {
        nolan.topStop();
        
        return;
      }
    }
    if (this.posRight) {
      if (this.rightIntersect)
      {
        nolan.leftStop();
        
        return;
      }
    }
    if (this.posLeft) {
      if (this.leftIntersect)
      {
        nolan.rightStop();
        
        return;
      }
    }
  }
}
