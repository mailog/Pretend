package com.inertia.gameobjects;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class RightWall
{
  private Vector2 position;
  private final int width;
  private final int height;
  private Rectangle RightWall;
  
  public RightWall(float x, float y, int width, int height)
  {
    this.position = new Vector2(x, y);
    this.width = width;
    this.height = height;
    this.RightWall = new Rectangle(x, y, width, height);
  }
  
  public Rectangle getRightWall()
  {
    return this.RightWall;
  }
  
  public int getWidth()
  {
    return this.width;
  }
  
  public int getHeight()
  {
    return this.height;
  }
  
  public float getX()
  {
    return this.position.x;
  }
  
  public float getY()
  {
    return this.position.y;
  }
  
  public boolean collides(Nolan nolan)
  {
    if (this.position.x < nolan.getBoundingRect().x + nolan.getWidth()) {
      return Intersector.overlaps(nolan.getBoundingRect(), this.RightWall);
    }
    return false;
  }
}
