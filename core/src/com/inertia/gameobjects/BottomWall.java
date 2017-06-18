package com.inertia.gameobjects;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class BottomWall
{
  private Nolan nolan;
  private Vector2 position;
  private final int width;
  private final int height;
  private Rectangle BottomWall;
  
  public BottomWall(float x, float y, int width, int height)
  {
    this.position = new Vector2(x, y);
    this.width = width;
    this.height = height;
    this.BottomWall = new Rectangle(x, y, width, height);
  }
  
  public Rectangle getBottomWall()
  {
    return this.BottomWall;
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
    if (this.position.y < nolan.getBoundingRect().y + nolan.getHeight()) {
      return Intersector.overlaps(nolan.getBoundingRect(), this.BottomWall);
    }
    return false;
  }
}
