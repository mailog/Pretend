package com.inertia.bihelpers;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetLoader
{
  public static Texture texture;
  public static TextureRegion bg;
  public static Animation nolanFrontAnimation;
  public static Animation nolanBackAnimation;
  public static Animation nolanRightAnimation;
  public static Animation nolanLeftAnimation;
  public static Animation TVon;
  public static TextureRegion nolanStandBack;
  public static TextureRegion nolanStandFront;
  public static TextureRegion nolanStandRight;
  public static TextureRegion nolanStandLeft;
  public static TextureRegion nolanFront1;
  public static TextureRegion nolanFront2;
  public static TextureRegion nolanFront3;
  public static TextureRegion nolanFront4;
  public static TextureRegion nolanBack1;
  public static TextureRegion nolanBack2;
  public static TextureRegion nolanBack3;
  public static TextureRegion nolanBack4;
  public static TextureRegion nolanRight1;
  public static TextureRegion nolanRight2;
  public static TextureRegion nolanRight3;
  public static TextureRegion nolanRight4;
  public static TextureRegion nolanRight5;
  public static TextureRegion nolanLeft1;
  public static TextureRegion nolanLeft2;
  public static TextureRegion nolanLeft3;
  public static TextureRegion nolanLeft4;
  public static TextureRegion nolanLeft5;
  public static TextureRegion cleanBed;
  public static TextureRegion Bed;
  public static TextureRegion Bookshelf;
  public static TextureRegion Desk;
  public static TextureRegion TV;
  public static TextureRegion TV1;
  public static TextureRegion TV2;
  public static TextureRegion TV3;
  public static TextureRegion Window;
  public static TextureRegion Blinds;
  public static TextureRegion Door;
  public static TextureRegion TopWall;
  public static TextureRegion BottomWall;
  public static TextureRegion RightWall;
  public static TextureRegion LeftWall;
  public static TextureRegion TopRightCorner;
  public static TextureRegion TopLeftCorner;
  public static TextureRegion TopTopWall;
  public static TextureRegion Floor;
  
  public static void load()
  {
    texture = new Texture(Gdx.files.internal("charactersheet.png"));
    nolanStandBack = new TextureRegion(texture, 121, 0, 40, 70);
    nolanStandBack.flip(false, true);
    nolanStandFront = new TextureRegion(texture, 0, 0, 40, 70);
    nolanStandFront.flip(false, true);
    nolanStandRight = new TextureRegion(texture, 81, 0, 40, 70);
    nolanStandRight.flip(false, true);
    nolanStandLeft = new TextureRegion(texture, 81, 0, 40, 70);
    nolanStandLeft.flip(true, true);
    
    nolanFront1 = new TextureRegion(texture, 0, 70, 40, 70);
    nolanFront1.flip(false, true);
    nolanFront2 = new TextureRegion(texture, 40, 70, 40, 70);
    nolanFront2.flip(false, true);
    nolanFront3 = new TextureRegion(texture, 80, 70, 40, 70);
    nolanFront3.flip(false, true);
    nolanFront4 = new TextureRegion(texture, 120, 70, 40, 70);
    nolanFront4.flip(false, true);
    
    TextureRegion[] nolanFront = { nolanFront1, nolanFront2, nolanFront1, nolanFront3, nolanFront4, nolanFront3 };
    nolanFrontAnimation = new Animation(0.12F, nolanFront);
    nolanFrontAnimation.setPlayMode(Animation.PlayMode.LOOP);
    
    nolanBack1 = new TextureRegion(texture, 0, 280, 40, 70);
    nolanBack1.flip(false, true);
    nolanBack2 = new TextureRegion(texture, 40, 280, 40, 70);
    nolanBack2.flip(false, true);
    nolanBack3 = new TextureRegion(texture, 80, 280, 40, 70);
    nolanBack3.flip(false, true);
    nolanBack4 = new TextureRegion(texture, 120, 280, 40, 70);
    nolanBack4.flip(false, true);
    
    TextureRegion[] nolanBack = { nolanBack1, nolanBack2, nolanBack1, nolanBack3, nolanBack4, nolanBack3 };
    nolanBackAnimation = new Animation(0.12F, nolanBack);
    nolanBackAnimation.setPlayMode(Animation.PlayMode.LOOP);
    
    nolanRight1 = new TextureRegion(texture, 0, 210, 40, 70);
    nolanRight1.flip(false, true);
    nolanRight2 = new TextureRegion(texture, 40, 210, 40, 70);
    nolanRight2.flip(false, true);
    nolanRight3 = new TextureRegion(texture, 80, 210, 40, 70);
    nolanRight3.flip(false, true);
    nolanRight4 = new TextureRegion(texture, 120, 210, 40, 70);
    nolanRight4.flip(false, true);
    nolanRight5 = new TextureRegion(texture, 160, 210, 40, 70);
    nolanRight5.flip(false, true);
    TextureRegion[] nolanRight = { nolanRight1, nolanRight2, nolanRight1, nolanRight3, nolanRight4, nolanRight5, nolanRight4, nolanRight3 };
    nolanRightAnimation = new Animation(0.1F, nolanRight);
    nolanRightAnimation.setPlayMode(Animation.PlayMode.LOOP);
    
    nolanLeft1 = new TextureRegion(texture, 0, 210, 40, 70);
    nolanLeft1.flip(true, true);
    nolanLeft2 = new TextureRegion(texture, 40, 210, 40, 70);
    nolanLeft2.flip(true, true);
    nolanLeft3 = new TextureRegion(texture, 80, 210, 40, 70);
    nolanLeft3.flip(true, true);
    nolanLeft4 = new TextureRegion(texture, 120, 210, 40, 70);
    nolanLeft4.flip(true, true);
    nolanLeft5 = new TextureRegion(texture, 160, 210, 40, 70);
    nolanLeft5.flip(true, true);
    TextureRegion[] nolanLeft = { nolanLeft1, nolanLeft2, nolanLeft1, nolanLeft3, nolanLeft4, nolanLeft5, nolanLeft4, nolanLeft3 };
    nolanLeftAnimation = new Animation(0.1F, nolanLeft);
    nolanLeftAnimation.setPlayMode(Animation.PlayMode.LOOP);
    
    texture = new Texture(Gdx.files.internal("objectsheet.png"));
    
    Bed = new TextureRegion(texture, 0, 200, 64, 100);
    Bed.flip(false, true);
    
    cleanBed = new TextureRegion(texture, 64, 200, 64, 100);
    cleanBed.flip(false, true);
    
    Bookshelf = new TextureRegion(texture, 0, 494, 70, 92);
    Bookshelf.flip(false, true);

    Desk = new TextureRegion(texture, 0, 586, 96, 104);
    Desk.flip(false, true);
    
    Window = new TextureRegion(texture, 0, 390, 76, 50);
    Window.flip(false, true);

    Blinds = new TextureRegion(texture, 0, 440, 76, 50);
    Blinds.flip(false, true);
    
    TV = new TextureRegion(texture, 76, 412, 42, 74);
    TV.flip(false, true);
    TV1 = new TextureRegion(texture, 118, 412, 42, 74);
    TV1.flip(false, true);
    TV2 = new TextureRegion(texture, 160, 412, 42, 74);
    TV2.flip(false, true);
    TV3 = new TextureRegion(texture, 202, 412, 42, 74);
    TV3.flip(false, true);
    
    TextureRegion[] TVloop = { TV2, TV3 };
    TVon = new Animation(0.1F, TVloop);
    TVon.setPlayMode(Animation.PlayMode.LOOP);
    
    Door = new TextureRegion(texture, 0, 300, 70, 90);
    Door.flip(false, true);
    
    TopWall = new TextureRegion(texture, 0, 100, 100, 100);
    TopWall.flip(false, true);
    TopTopWall = new TextureRegion(texture, 148, 16, 100, 16);
    TopTopWall.flip(false, true);
    BottomWall = new TextureRegion(texture, 148, 0, 100, 16);
    BottomWall.flip(false, true);
    RightWall = new TextureRegion(texture, 100, 102, 16, 96);
    RightWall.flip(false, true);
    LeftWall = new TextureRegion(texture, 100, 0, 16, 96);
    LeftWall.flip(false, true);
    
    TopRightCorner = new TextureRegion(texture, 132, 0, 16, 16);
    TopRightCorner.flip(false, true);
    TopLeftCorner = new TextureRegion(texture, 116, 16, 16, 16);
    TopLeftCorner.flip(false, true);
    
    Floor = new TextureRegion(texture, 0, 0, 50, 50);
    Floor.flip(false, true);
  }
  
  public static void dispose()
  {
    texture.dispose();
  }
}
