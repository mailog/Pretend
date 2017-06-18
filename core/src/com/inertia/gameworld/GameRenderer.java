package com.inertia.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.utils.TiledDrawable;
import com.inertia.bihelpers.AssetLoader;
import com.inertia.gameobjects.*;
public class GameRenderer
{
  private GameWorld myWorld;
  private OrthographicCamera cam;
  private ShapeRenderer shapeRenderer;
  private TiledDrawable repeater;
  private Nolan nolan;
  private Bed Bed;
  private Bookshelf Bookshelf;
  private Desk Desk;
  private Tv Tv;
  private Window Window;
  private Door Door;
  private Door2 Door2;
  private TopWall TWall;
  private TopWall TWall2R1;
  private TopWall TWall2;
  private BottomWall BWall;
  private BottomWall BWall2;
  private OpenWall RWall;
  private OpenWall RWall2R1;
  private RightWall RWall2;
  private LeftWall LWall;
  private LeftWall LWall2;
  private SpriteBatch batcher;
  
  public GameRenderer(GameWorld world)
  {
    this.myWorld = world;
    
    updateCam(0.0F, 0.0F);
    
    initGameObjects();
  }
  
  public void updateCam(float x, float y)
  {
    this.cam = new OrthographicCamera();
    this.cam.setToOrtho(true, 1080.0F, 720.0F);
    this.cam.translate(x, y);
    this.cam.update();
    
    this.batcher = new SpriteBatch();
    this.batcher.setProjectionMatrix(this.cam.combined);
    
    this.shapeRenderer = new ShapeRenderer();
    this.shapeRenderer.setProjectionMatrix(this.cam.combined);
  }
  
  public void initGameObjects()
  {
    this.nolan = this.myWorld.getNolan();
    this.Bed = this.myWorld.getBed();
    this.Bookshelf = this.myWorld.getBookshelf();
    this.Desk = this.myWorld.getDesk();
    this.Tv = this.myWorld.getTv();
    this.Window = this.myWorld.getWindow();
    this.Door = this.myWorld.getDoor();
    this.Door2 = this.myWorld.getDoor2();
    
    this.TWall = this.myWorld.getTWall();
    this.TWall2R1 = this.myWorld.getTWall2R1();
    this.BWall = this.myWorld.getBWall();
    this.RWall = this.myWorld.getRWall();
    this.RWall2R1 = this.myWorld.getRWall2R1();
    this.LWall = this.myWorld.getLWall();
    
    this.TWall2 = this.myWorld.getTWall2();
    this.BWall2 = this.myWorld.getBWall2();
    this.RWall2 = this.myWorld.getRWall2();
    this.LWall2 = this.myWorld.getLWall2();
  }
  
  public void drawHitBoxes()
  {
    this.shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
    
    this.shapeRenderer.setColor(Color.BROWN);
    this.shapeRenderer.rect(this.BWall.getX(), this.BWall.getY(), this.BWall.getWidth(), this.BWall.getHeight());
    this.shapeRenderer.rect(this.TWall.getX(), this.TWall.getY(), this.TWall.getWidth(), this.TWall.getHeight());
    
    this.shapeRenderer.rect(this.RWall.getX(), this.RWall.getY(), this.RWall.getWidth(), this.RWall.getHeight());
    this.shapeRenderer.rect(this.LWall.getX(), this.LWall.getY(), this.LWall.getWidth(), this.LWall.getHeight());
    
    this.shapeRenderer.rect(this.BWall2.getX(), this.BWall2.getY(), this.BWall2.getWidth(), this.BWall2.getHeight());
    this.shapeRenderer.rect(this.TWall2.getX(), this.TWall2.getY(), this.TWall2.getWidth(), this.TWall2.getHeight());
    
    this.shapeRenderer.rect(this.RWall2.getX(), this.RWall2.getY(), this.RWall2.getWidth(), this.RWall2.getHeight());
    this.shapeRenderer.rect(this.LWall2.getX(), this.LWall2.getY(), this.LWall2.getWidth(), this.LWall2.getHeight());
    
    this.shapeRenderer.end();
    
    this.shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
    this.shapeRenderer.setColor(Color.RED);
    this.shapeRenderer.rect(this.nolan.getBoundingRect().getX(), this.nolan.getBoundingRect().getY(), this.nolan.getBoundingRect().getWidth(), this.nolan.getBoundingRect().getHeight());
    
    this.shapeRenderer.setColor(Color.BLUE);
    this.shapeRenderer.rect(this.Bed.getX(), this.Bed.getY(), this.Bed.getWidth(), this.Bed.getHeight());
    
    this.shapeRenderer.end();
  }
  
  public void renderBedroom(float runTime)
  {
    this.batcher.begin();
    
    this.batcher.enableBlending();
    
    this.repeater = new TiledDrawable(AssetLoader.Floor);
    this.repeater.draw(this.batcher, this.TWall.getX() - this.LWall.getWidth() + 16.0F, this.TWall.getY() - this.TWall.getHeight() + 50.0F, this.TWall.getWidth(), this.LWall.getHeight());
    this.repeater.draw(this.batcher, this.TWall2R1.getX(), this.TWall2R1.getY() + this.TWall.getHeight() + 50, this.TWall2R1.getWidth(), 100);
    
    this.repeater = new TiledDrawable(AssetLoader.TopTopWall);
    this.repeater.draw(this.batcher, this.TWall.getX(), this.TWall.getY() - 16.0F, this.TWall.getWidth(), 16.0F);
    
    this.repeater = new TiledDrawable(AssetLoader.TopWall);
    
    this.repeater.draw(this.batcher, this.TWall.getX(), this.TWall.getY(), this.TWall.getWidth(), 100.0F);
    
    this.repeater.draw(this.batcher, this.TWall2R1.getX(), this.TWall2R1.getY(), this.TWall2R1.getWidth(), 100.0F);
    
    this.repeater.draw(this.batcher, this.RWall.getX() - 1.0F, this.RWall.getY() + this.RWall.getHeight() - 99.0F, this.RWall.getWidth(), 100.0F);
    
    this.repeater.draw(this.batcher, this.RWall2R1.getX() - 1.0F, this.RWall2R1.getY() + this.RWall2R1.getHeight() - 99.0F, this.RWall.getWidth(), 100.0F);
    
    this.repeater.draw(this.batcher, this.LWall.getX() + 1.0F, this.LWall.getY() + this.LWall.getHeight() - 99.0F, this.LWall.getWidth(), 100.0F);
    
    this.batcher.draw(AssetLoader.RightWall, this.RWall.getX(), this.RWall.getY(), this.RWall.getWidth(), this.RWall.getHeight() - 100);
    
    this.batcher.draw(AssetLoader.RightWall, this.RWall2R1.getX(), this.RWall2R1.getY(), this.RWall2R1.getWidth(), this.RWall2R1.getHeight() - 100);
    
    this.batcher.draw(AssetLoader.LeftWall, this.LWall.getX(), this.LWall.getY(), this.LWall.getWidth(), this.LWall.getHeight() - 100);
    
    this.batcher.draw(AssetLoader.TopRightCorner, this.TWall.getX() + this.TWall.getWidth(), this.TWall.getY() - 18.0F, 16.0F, 16.0F);
    
    this.batcher.draw(AssetLoader.TopLeftCorner, this.TWall.getX() - 16.0F, this.TWall.getY() - 18.0F, 16.0F, 16.0F);
    if (!this.Bed.getMessy()) {
      this.batcher.draw(AssetLoader.Bed, this.Bed.getX(), this.Bed.getY(), this.Bed.getWidth(), this.Bed.getHeight());
    } else {
      this.batcher.draw(AssetLoader.cleanBed, this.Bed.getX(), this.Bed.getY(), this.Bed.getWidth(), this.Bed.getHeight());
    }
    this.batcher.draw(AssetLoader.Window, this.Window.getX(), this.Window.getY(), 76.0F, 50.0F);
    if(!Window.getOn()){
    	this.batcher.draw(AssetLoader.Blinds, this.Window.getX(), this.Window.getY(), 76.0F, 50.0F);
    }
    if (!this.Tv.getOn())
    {
      this.Tv.increasePower();
      if ((this.Tv.getPower() >= 0) && (this.Tv.getPower() <= 10)) {
        this.batcher.draw(AssetLoader.TV, this.Tv.getX(), this.Tv.getY(), 42.0F, 74.0F);
      }
      if ((this.Tv.getPower() > 10) && (this.Tv.getPower() <= 20)) {
        this.batcher.draw(AssetLoader.TV1, this.Tv.getX(), this.Tv.getY(), 42.0F, 74.0F);
      }
      if ((this.Tv.getPower() > 20) && (this.Tv.getPower() <= 30)) {
        this.batcher.draw(AssetLoader.TV2, this.Tv.getX(), this.Tv.getY(), 42.0F, 74.0F);
      }
      if ((this.Tv.getPower() > 30) && (this.Tv.getPower() <= 40)) {
        this.batcher.draw(AssetLoader.TV3, this.Tv.getX(), this.Tv.getY(), 42.0F, 74.0F);
      }
      if (this.Tv.getPower() == 40) {
        this.batcher.draw(AssetLoader.TVon.getKeyFrame(runTime, true), this.Tv.getX(), this.Tv.getY(), 42.0F, 74.0F);
      }
    }
    else
    {
      this.batcher.draw(AssetLoader.TV, this.Tv.getX(), this.Tv.getY(), 42.0F, 74.0F);
    }
    this.batcher.draw(AssetLoader.Bookshelf, this.Bookshelf.getX(), this.Bookshelf.getY(), this.Bookshelf.getWidth(), this.Bookshelf.getHeight());
    
    this.batcher.draw(AssetLoader.Desk, this.Desk.getX(), this.Desk.getY(), this.Desk.getWidth(), this.Desk.getHeight());
    
    this.batcher.draw(AssetLoader.Door, this.Door.getX(), this.Door.getY(), this.Door.getWidth(), this.Door.getHeight());
    
    this.batcher.end();
  }
  
  public void renderHallway(float runTime)
  {
    updateCam(1080.0F, 0.0F);
    this.batcher.begin();
    
    this.batcher.enableBlending();
    
    this.repeater = new TiledDrawable(AssetLoader.Floor);
    this.repeater.draw(this.batcher, this.TWall2.getX() - this.LWall2.getWidth() + 16.0F, this.TWall2.getY() - this.TWall2.getHeight() + 50.0F, this.TWall2.getWidth(), this.LWall2.getHeight());
    
    this.repeater = new TiledDrawable(AssetLoader.TopTopWall);
    this.repeater.draw(this.batcher, this.TWall2.getX(), this.TWall.getY() - 16.0F, this.TWall2.getWidth(), 16.0F);
    
    this.repeater = new TiledDrawable(AssetLoader.TopWall);
    
    this.repeater.draw(this.batcher, this.TWall2.getX(), this.TWall2.getY(), this.TWall2.getWidth(), 100.0F);
    
    this.repeater.draw(this.batcher, this.RWall2.getX() - 1.0F, this.RWall2.getY() + this.RWall2.getHeight() - 99.0F, this.RWall2.getWidth(), 100.0F);
    
    this.repeater.draw(this.batcher, this.LWall2.getX() + 1.0F, this.LWall2.getY() + this.LWall2.getHeight() - 99.0F, this.LWall2.getWidth(), 100.0F);
    
    this.batcher.draw(AssetLoader.RightWall, this.RWall2.getX(), this.RWall2.getY(), this.RWall2.getWidth(), this.RWall2.getHeight() - 100);
    
    this.batcher.draw(AssetLoader.LeftWall, this.LWall2.getX(), this.LWall2.getY(), this.LWall2.getWidth(), this.LWall2.getHeight() - 100);
    
    this.batcher.draw(AssetLoader.TopRightCorner, this.TWall2.getX() + this.TWall2.getWidth(), this.TWall2.getY() - 18.0F, 16.0F, 16.0F);
    
    this.batcher.draw(AssetLoader.TopLeftCorner, this.TWall2.getX() - 16.0F, this.TWall2.getY() - 18.0F, 16.0F, 16.0F);
    
    this.batcher.draw(AssetLoader.Door, this.Door2.getX(), this.Door2.getY(), this.Door2.getWidth(), this.Door2.getHeight());
    
    this.batcher.end();
  }
  
  public void renderNolan(float runTime)
  {
    this.batcher.begin();
    
    this.batcher.enableBlending();
    if (this.nolan.isMovingUp()) {
      this.batcher.draw(AssetLoader.nolanBackAnimation.getKeyFrame(runTime, true), this.nolan.getX(), this.nolan.getY(), this.nolan.getWidth(), this.nolan.getHeight());
    } else if (this.nolan.isMovingDown()) {
      this.batcher.draw(AssetLoader.nolanFrontAnimation.getKeyFrame(runTime, true), this.nolan.getX(), this.nolan.getY(), this.nolan.getWidth(), this.nolan.getHeight());
    } else if (this.nolan.isMovingRight()) {
      this.batcher.draw(AssetLoader.nolanRightAnimation.getKeyFrame(runTime, true), this.nolan.getX(), this.nolan.getY(), this.nolan.getWidth(), this.nolan.getHeight());
    } else if (this.nolan.isMovingLeft()) {
      this.batcher.draw(AssetLoader.nolanLeftAnimation.getKeyFrame(runTime, true), this.nolan.getX(), this.nolan.getY(), this.nolan.getWidth(), this.nolan.getHeight());
    } else {
      switch (this.nolan.getStand())
      {
      case 0: 
        this.batcher.draw(AssetLoader.nolanStandBack, this.nolan.getX(), this.nolan.getY(), this.nolan.getWidth(), this.nolan.getHeight());
        break;
      case 1: 
        this.batcher.draw(AssetLoader.nolanStandFront, this.nolan.getX(), this.nolan.getY(), this.nolan.getWidth(), this.nolan.getHeight());
        break;
      case 2: 
        this.batcher.draw(AssetLoader.nolanStandRight, this.nolan.getX(), this.nolan.getY(), this.nolan.getWidth(), this.nolan.getHeight());
        break;
      case 3: 
        this.batcher.draw(AssetLoader.nolanStandLeft, this.nolan.getX(), this.nolan.getY(), this.nolan.getWidth(), this.nolan.getHeight());
        break;
      }
    }
    this.batcher.end();
  }
  
  public void renderPause(float runTime){
	  this.batcher.begin();
	    
	    this.batcher.enableBlending();
	    
	    this.repeater = new TiledDrawable(AssetLoader.nolanStandFront);
	    if(nolan.getBedroom())
	    	this.repeater.draw(this.batcher, 135, 90, 810, 540);
	    if(nolan.getHallway())
	    	this.repeater.draw(this.batcher, 1215, 90, 810, 540);
	 batcher.end();
  }
  
  public void render(float runTime)
  {
    Gdx.gl.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    Gdx.gl.glClear(16384);
    if (this.nolan.getBedroom().booleanValue())
    {
      updateCam(0.0F, 0.0F);
      renderBedroom(runTime);
    }
    if (this.nolan.getHallway().booleanValue())
    {
      updateCam(1080.0F, 0.0F);
      renderHallway(runTime);
    }
    renderNolan(runTime);
    
    if(nolan.getPause())
    	renderPause(runTime);
  }
}
