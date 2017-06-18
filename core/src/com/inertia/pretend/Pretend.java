package com.inertia.pretend;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.inertia.bihelpers.AssetLoader;
import com.inertia.screens.Gamescreen;

public class Pretend
  extends Game
{
  public void create()
  {
    Gdx.app.log("Pretend", "Created");
    AssetLoader.load();
    setScreen(new Gamescreen());
  }
  
  public void dispose()
  {
    super.dispose();
    AssetLoader.dispose();
  }
}
