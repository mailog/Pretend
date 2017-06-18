package com.inertia.gameobjects;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import java.io.PrintStream;

public class Bed
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
  private boolean messy;
  private final int width = 64;
  private final int height = 100;
  private Rectangle Bed;
  
  public Bed(float x, float y)
  {
    this.position = new Vector2(x, y);
    this.Bed = new Rectangle(x, y, 64.0F, 100.0F);
    
    this.top = new Rectangle(x, y, getWidth(), 1.0F);
    this.bottom = new Rectangle(x, y + 100.0F - 50.0F, getWidth(), 1.0F);
    this.left = new Rectangle(x, y - 50.0F, 1.0F, getHeight());
    this.right = new Rectangle(x + 64.0F, y - 50.0F, 1.0F, getHeight());
  }
  
  public Rectangle getBed()
  {
    return this.Bed;
  }
  
  public int getWidth()
  {
    return 64;
  }
  
  public int getHeight()
  {
    return 100;
  }
  
  public float getX()
  {
    return this.position.x;
  }
  
  public float getY()
  {
    return this.position.y;
  }
  
  public boolean getMessy()
  {
    return this.messy;
  }
  
  public void checkInteract(Nolan nolan)
  {
    if (nolan.getInteract().booleanValue()) {
      interact(nolan);
    }
  }
  
  public Object interact(Nolan nolan)
  {
    System.out.println("This is a bed.");
    this.messy = (!this.messy);
    nolan.setInteract(Boolean.valueOf(false));
    return Integer.valueOf(0);
  }
  
  public Vector2 getCenter()
  {
    return new Vector2(this.position.x + 32.0F, this.position.y + 50.0F);
  }
  
  public boolean checkCollides(Nolan nolan)
  {
    return Intersector.overlaps(nolan.getBoundingRect(), this.Bed);
  }
  
  public void collisionDirection(Nolan nolan)
  {
    this.topIntersect = Intersector.overlaps(this.top, nolan.getBoundingRect());
    this.bottomIntersect = Intersector.overlaps(this.bottom, nolan.getBoundingRect());
    this.rightIntersect = Intersector.overlaps(this.right, nolan.getBoundingRect());
    this.leftIntersect = Intersector.overlaps(this.left, nolan.getBoundingRect());
    
    this.posTop = (nolan.getY() + nolan.getHeight() <= getY() + 5.0F);
    this.posBottom = (nolan.getY() >= getY() + 100.0F - 55.0F);
    this.posRight = (nolan.getX() >= getX() + 64.0F - 55.0F);
    this.posLeft = (nolan.getX() + nolan.getWidth() <= getX() + 55.0F);
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
