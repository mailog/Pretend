package com.inertia.pretend.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.inertia.pretend.Pretend;

public class DesktopLauncher
{
  public static void main(String[] arg)
  {
    LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
    config.height = 720;
    config.width = 1080;
    config.title = "Pretend";
    new LwjglApplication(new Pretend(), config);
  }
}
