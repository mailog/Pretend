package com.inertia.bihelpers;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.inertia.gameobjects.Nolan;

public class InputHandler
  implements InputProcessor
{
  private Nolan myNolan;
  private boolean up;
  private boolean right;
  private boolean down;
  private boolean left;
  
  public InputHandler(Nolan nolan)
  {
    this.myNolan = nolan;
  }
  
  public boolean keyDown(int keycode)
  {
    switch (keycode)
    {
    case Keys.W: 
    	if(!myNolan.getPause()){
    	this.myNolan.onUp();
    	this.myNolan.setMovingUp(true);
    	}
      break;
    case Keys.D: 
    	if(!myNolan.getPause()){
      this.myNolan.onRight();
      this.myNolan.setMovingRight(true);
    	}
      break;
    case Keys.S: 
    	if(!myNolan.getPause()){
      this.myNolan.onDown();
      this.myNolan.setMovingDown(true);
    	}
      break;
    case Keys.A: 
    	if(!myNolan.getPause()){
      this.myNolan.onLeft();
      this.myNolan.setMovingLeft(true);
    	}
      break;
    case Keys.SPACE: 
    	if(!myNolan.getPause()){
      this.myNolan.setInteract(Boolean.valueOf(true));
    	}
      break;
    case Keys.P: 
    	this.myNolan.setPause();
    	this.myNolan.stop();
    }
    if (this.up) {
      this.myNolan.onUp();
    }
    if (this.right) {
      this.myNolan.onRight();
    }
    if (this.down) {
      this.myNolan.onDown();
    }
    if (this.left) {
      this.myNolan.onLeft();
    }
    return true;
  }
  
  public boolean keyUp(int keycode)
  {
    switch (keycode)
    {
    case 51: if(!myNolan.getPause()){
      this.myNolan.offUp();
      this.myNolan.setMovingUp(false);
    }
      break;
    case 32:  if(!myNolan.getPause()){
      this.myNolan.offRight();
      this.myNolan.setMovingRight(false);
    }
      break;
    case 47:  if(!myNolan.getPause()){
      this.myNolan.offDown();
      this.myNolan.setMovingDown(false);
    }
      break;
    case 29:  if(!myNolan.getPause()){
      this.myNolan.offLeft();
      this.myNolan.setMovingLeft(false);
    }
      break;
    case 62:  if(!myNolan.getPause()){
      this.myNolan.setInteract(Boolean.valueOf(false));
    }
      break;
    }
    return true;
  }
  
  public boolean keyTyped(char character)
  {
    return false;
  }
  
  public boolean touchDown(int screenX, int screenY, int pointer, int button)
  {
    return false;
  }
  
  public boolean touchUp(int screenX, int screenY, int pointer, int button)
  {
    return false;
  }
  
  public boolean touchDragged(int screenX, int screenY, int pointer)
  {
    return false;
  }
  
  public boolean mouseMoved(int screenX, int screenY)
  {
    return false;
  }
  
  public boolean scrolled(int amount)
  {
    return false;
  }
}
