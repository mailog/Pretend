package com.inertia.gameobjects;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class TopWall
{
  private Vector2 position;
  private final int width;
  private final int height;
  private Rectangle TopWall;
  
  public TopWall(float x, float y, int width, int height)
  {
    this.position = new Vector2(x, y);
    this.width = width;
    this.height = height;
    this.TopWall = new Rectangle(x, y, width, height);
  }
  
  public Rectangle getTopWall()
  {
    return this.TopWall;
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
    if (this.position.y + this.height > nolan.getBoundingRect().y) {
      return Intersector.overlaps(nolan.getBoundingRect(), this.TopWall);
    }
    return false;
  }
}
