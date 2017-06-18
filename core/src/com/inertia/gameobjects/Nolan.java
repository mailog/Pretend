package com.inertia.gameobjects;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Nolan
{
  private Vector2 position;
  private Vector2 velocity;
  private int width;
  private int height;
  boolean standBack;
  boolean standFront;
  boolean standRight;
  boolean standLeft;
  boolean topStop;
  boolean bottomStop;
  boolean rightStop;
  boolean leftStop;
  boolean movingUp;
  boolean movingDown;
  boolean movingRight;
  boolean movingLeft;
  boolean inBedroom;
  boolean inHallway;
  boolean switchBedroom;
  boolean switchHallway;
  boolean interact;
  boolean collides;
  boolean pause;
  private Rectangle boundingRect;
  
  public Nolan(float x, float y, int width, int height)
  {
    this.inBedroom = true;
    this.standFront = true;
    this.width = width;
    this.height = height;
    this.position = new Vector2(x, y);
    this.velocity = new Vector2(0.0F, 0.0F);
    this.boundingRect = new Rectangle();
  }
  
  public void update(float delta)
  {
    if ((this.movingUp) && (!this.movingDown) && (!this.topStop))
    {
      this.velocity.y = -200.0F;
      this.position.add(this.velocity.cpy().scl(delta));
      this.boundingRect.set(this.position.x, this.position.y, this.width, this.height);
    }
    else if ((this.movingDown) && (!this.movingUp) && (!this.bottomStop))
    {
      this.velocity.y = 200.0F;
      this.position.add(this.velocity.cpy().scl(delta));
      this.boundingRect.set(this.position.x, this.position.y, this.width, this.height);
    }
    else if ((this.movingRight) && (!this.movingLeft) && (!this.rightStop))
    {
      this.velocity.x = 200.0F;
      this.position.add(this.velocity.cpy().scl(delta));
      this.boundingRect.set(this.position.x, this.position.y, this.width, this.height);
    }
    else if ((this.movingLeft) && (!this.movingRight) && (!this.leftStop))
    {
      this.velocity.x = -200.0F;
      this.position.add(this.velocity.cpy().scl(delta));
      this.boundingRect.set(this.position.x, this.position.y, this.width, this.height);
    }
    else
    {
      this.position.add(this.velocity.cpy().scl(delta));
      this.boundingRect.set(this.position.x, this.position.y, this.width, this.height);
    }
  }
  
  public void setPosition(float x, float y)
  {
    this.position.x = x;
    this.position.y = y;
  }
  
  public void setInteract(Boolean interaction)
  {
    this.interact = interaction.booleanValue();
  }
  
  public Boolean getInteract()
  {
    return Boolean.valueOf(this.interact);
  }
  
  public void setPause(){
	  pause = !pause;
  }
  
  public boolean getPause(){
	  return pause;
  }
  
  public Boolean getBedroom()
  {
    return Boolean.valueOf(this.inBedroom);
  }
  
  public void setBedroom(boolean location)
  {
    this.inBedroom = location;
  }
  
  public Boolean getHallway()
  {
    return Boolean.valueOf(this.inHallway);
  }
  
  public void setSwitchHallway(boolean location)
  {
    this.switchHallway = location;
  }
  
  public Boolean getSwitchBedroom()
  {
    return Boolean.valueOf(this.switchBedroom);
  }
  
  public void setSwitchBedroom(boolean location)
  {
    this.switchBedroom = location;
  }
  
  public Boolean getSwitchHallway()
  {
    return Boolean.valueOf(this.switchHallway);
  }
  
  public void setHallway(boolean location)
  {
    this.inHallway = location;
  }
  
  public void onUp()
  {
    if (!this.topStop) {
      this.velocity.y = -200.0F;
    }
    setMoving();
  }
  
  public void onDown()
  {
    if (!this.bottomStop) {
      this.velocity.y = 200.0F;
    }
    setMoving();
  }
  
  public void onRight()
  {
    if (!this.rightStop) {
      this.velocity.x = 200.0F;
    }
    setMoving();
  }
  
  public void onLeft()
  {
    if (!this.leftStop) {
      this.velocity.x = -200.0F;
    }
    setMoving();
  }
  
  public void offUp()
  {
    this.velocity.y = 0.0F;
    setStand(0);
  }
  
  public void offRight()
  {
    this.velocity.x = 0.0F;
    setStand(2);
  }
  
  public void offDown()
  {
    this.velocity.y = 0.0F;
    setStand(1);
  }
  
  public void offLeft()
  {
    this.velocity.x = 0.0F;
    setStand(3);
  }
  
  public void stop(){
	  if(movingUp){
		  topStop();
	  	  movingUp = false;
	  	  standBack = true;
	  }
	  	  if(movingDown){
		  bottomStop();
	  	  movingDown = false;
	  	  standFront = true;
	  }
	  	  if(movingRight){
		  rightStop();
	      movingRight = false;
	      standRight = true;
	  	  }
	   if(movingLeft){
		  leftStop();
	  	  movingLeft = false;
	  	  standLeft = true;
	   }
	 }

  public float getX()
  {
    return this.position.x;
  }
  
  public float getY()
  {
    return this.position.y;
  }
  
  public float getWidth()
  {
    return this.width;
  }
  
  public float getHeight()
  {
    return this.height;
  }
  
  public Vector2 getCenter()
  {
    return new Vector2(this.position.x + this.width / 2, this.position.y + this.height / 2);
  }
  
  public void topStop()
  {
    this.topStop = true;
    this.velocity.y = 0.0F;
  }
  
  public void bottomStop()
  {
    this.bottomStop = true;
    this.velocity.y = 0.0F;
  }
  
  public void rightStop()
  {
    this.rightStop = true;
    this.velocity.x = 0.0F;
  }
  
  public void leftStop()
  {
    this.leftStop = true;
    this.velocity.x = 0.0F;
  }
  
  public void setTopStop(boolean stop)
  {
    this.topStop = stop;
  }
  
  public boolean getTopStop()
  {
    return this.topStop;
  }
  
  public void setBottomStop(boolean stop)
  {
    this.bottomStop = stop;
  }
  
  public boolean getBottomStop()
  {
    return this.bottomStop;
  }
  
  public void setRightStop(boolean stop)
  {
    this.rightStop = stop;
  }
  
  public boolean getRightStop()
  {
    return this.rightStop;
  }
  
  public void setLeftStop(boolean stop)
  {
    this.leftStop = stop;
  }
  
  public boolean getLeftStop()
  {
    return this.leftStop;
  }
  
  public boolean getMovingUp()
  {
    return this.movingUp;
  }
  
  public boolean getMovingDown()
  {
    return this.movingDown;
  }
  
  public boolean getMovingRight()
  {
    return this.movingRight;
  }
  
  public boolean getMovingLeft()
  {
    return this.movingLeft;
  }
  
  public void setMovingUp(boolean move)
  {
    this.movingUp = move;
  }
  
  public void setMovingRight(boolean move)
  {
    this.movingRight = move;
  }
  
  public void setMovingLeft(boolean move)
  {
    this.movingLeft = move;
  }
  
  public void setMovingDown(boolean move)
  {
    this.movingDown = move;
  }
  
  public void setMoving()
  {
    this.standBack = false;
    this.standFront = false;
    this.standRight = false;
    this.standLeft = false;
  }
  
  public boolean isMovingUp()
  {
    return this.movingUp;
  }
  
  public boolean isMovingDown()
  {
    return this.movingDown;
  }
  
  public boolean isMovingRight()
  {
    return this.movingRight;
  }
  
  public boolean isMovingLeft()
  {
    return this.movingLeft;
  }
  
  public int getStand()
  {
    if (this.standBack) {
      return 0;
    }
    if (this.standFront) {
      return 1;
    }
    if (this.standRight) {
      return 2;
    }
    if (this.standLeft) {
      return 3;
    }
    return -1;
  }
  
  public void setStand(int s)
  {
    switch (s)
    {
    case 0: 
      this.standBack = true;
      this.standFront = false;
      this.standRight = false;
      this.standLeft = false;
      break;
    case 1: 
      this.standFront = true;
      this.standBack = false;
      this.standRight = false;
      this.standLeft = false;
      break;
    case 2: 
      this.standRight = true;
      this.standBack = false;
      this.standFront = false;
      this.standLeft = false;
      break;
    case 3: 
      this.standLeft = true;
      this.standBack = false;
      this.standFront = false;
      this.standRight = false;
      break;
    }
  }
  
  public void setStops(Boolean stop)
  {
    this.topStop = stop.booleanValue();
    this.bottomStop = stop.booleanValue();
    this.rightStop = stop.booleanValue();
    this.leftStop = stop.booleanValue();
  }
  
  public Rectangle getBoundingRect()
  {
    return this.boundingRect;
  }
}
