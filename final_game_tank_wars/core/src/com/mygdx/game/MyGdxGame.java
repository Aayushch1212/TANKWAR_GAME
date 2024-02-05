package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;



	 Sprite tank;
@Override
	public void create(){
		batch=new SpriteBatch();
		Texture tankTexture= new Texture("hilly.jpeg");
		tank=new Sprite(tankTexture);
		tank.setSize(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
	}




	@Override
	public void render () {
		//ScreenUtils.clear(0, 1, 0, 0);
		//batch.begin();
		//batch.draw(img);
		//batch.end();


		Gdx.gl.glClearColor(0,100,0,0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		tank.draw(batch);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		//tank.dispose();
	}
}





