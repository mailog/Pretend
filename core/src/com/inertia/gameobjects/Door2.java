package com.inertia.gameobjects;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import java.io.PrintStream;

public class Door2
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
  private final int width = 70;
  private final int height = 90;
  private Rectangle Door2;
  
  public Door2(float x, float y)
  {
    this.position = new Vector2(x, y);
    this.Door2 = new Rectangle(x, y, 70.0F, 90.0F);
    
    this.top = new Rectangle(x, y, getWidth(), 1.0F);
    this.bottom = new Rectangle(x, y + 90.0F - 50.0F, getWidth(), 1.0F);
    this.left = new Rectangle(x, y - 50.0F, 1.0F, getHeight());
    this.right = new Rectangle(x + 70.0F, y - 50.0F, 1.0F, getHeight());
  }
  
  public Rectangle getDoor()
  {
    return this.Door2;
  }
  
  public int getWidth()
  {
    return 70;
  }
  
  public int getHeight()
  {
    return 90;
  }
  
  public float getX()
  {
    return this.position.x;
  }
  
  public float getY()
  {
    return this.position.y;
  }
  
  public Object interact(Nolan nolan)
  {
    System.out.println("This is a Door2.");
    nolan.setHallway(false);
    nolan.setBedroom(true);
    nolan.setSwitchBedroom(true);
    return Integer.valueOf(0);
  }
  
  public Vector2 getCenter()
  {
    return new Vector2(this.position.x + 35.0F, this.position.y + 45.0F);
  }
  
  public boolean checkCollides(Nolan nolan)
  {
    return Intersector.overlaps(nolan.getBoundingRect(), this.Door2);
  }
  
  public void collisionDirection(Nolan nolan)
  {
    this.topIntersect = Intersector.overlaps(this.top, nolan.getBoundingRect());
    this.bottomIntersect = Intersector.overlaps(this.bottom, nolan.getBoundingRect());
    this.rightIntersect = Intersector.overlaps(this.right, nolan.getBoundingRect());
    this.leftIntersect = Intersector.overlaps(this.left, nolan.getBoundingRect());
    
    this.posTop = (nolan.getY() + nolan.getHeight() <= getY() + 5.0F);
    this.posBottom = (nolan.getY() >= getY() + 90.0F - 55.0F);
    this.posRight = (nolan.getX() >= getX() + 70.0F - 55.0F);
    this.posLeft = (nolan.getX() + nolan.getWidth() <= getX() + 55.0F);
    if (this.posTop) {
      if (this.topIntersect)
      {
        interact(nolan);
        
        return;
      }
    }
    if (this.posBottom) {
      if (this.bottomIntersect)
      {
        interact(nolan);
        
        return;
      }
    }
    if (this.posRight) {
      if (this.rightIntersect)
      {
        interact(nolan);
        
        return;
      }
    }
    if (this.posLeft) {
      if (this.leftIntersect)
      {
        interact(nolan);
        
        return;
      }
    }
  }
}
