package com.inertia.screens;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.inertia.bihelpers.InputHandler;
import com.inertia.gameworld.GameRenderer;
import com.inertia.gameworld.GameWorld;

public class Gamescreen
  implements Screen
{
  private GameWorld world;
  private GameRenderer renderer;
  private float runTime = 0.0F;
  
  public Gamescreen()
  {
    Gdx.app.log("GameScreen", "Attached");
    this.world = new GameWorld();
    this.renderer = new GameRenderer(this.world);
    
    Gdx.input.setInputProcessor(new InputHandler(this.world.getNolan()));
  }
  
  public void render(float delta)
  {
    this.runTime += delta;
    this.world.update(delta);
    this.renderer.render(this.runTime);
  }
  
  public void show()
  {
    Gdx.app.log("GameScreen", "Show called");
  }
  
  public void resize(int width, int height)
  {
    Gdx.app.log("GameScreen", "Resize called");
  }
  
  public void pause()
  {
    Gdx.app.log("GameScreen", "Pause called");
  }
  
  public void resume()
  {
    Gdx.app.log("GameScreen", "Resume called");
  }
  
  public void hide()
  {
    Gdx.app.log("GameScreen", "Hide called");
  }
  
  public void dispose() {}
}
