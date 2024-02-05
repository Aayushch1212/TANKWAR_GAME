package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.ScreenUtils;
public class MainMenu implements Screen {

    final tank game;
    private Texture backgroundImage;
    private  Texture button1Image;
    private TextureRegion backgroundTexture;
    private TextureRegion button1Texture;

    Texture t1Image,wImage;
    Rectangle t1,w;
    OrthographicCamera camera;

    public MainMenu(final tank game) {
        this.game = game;
        backgroundImage = new Texture(Gdx.files.internal("mainback.jpg"));
        button1Image = new Texture(Gdx.files.internal("button1.jpeg"));
        backgroundTexture = new TextureRegion(backgroundImage, 0, 0, 600, 400);
        button1Texture = new TextureRegion(backgroundImage, 300, 140, 50, 50);
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);


        wImage = new Texture(Gdx.files.internal("logomain.png"));
        w= new Rectangle();
        w.x=0;
        w.y = 50;
        w.width = 350;
        w.height = 170;


        t1Image = new Texture(Gdx.files.internal("generatedtext (11).png"));
        t1= new Rectangle();
        t1.x=320;
        t1.y =70;
        t1.width =400;
        t1.height = 50;


    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 0);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        game.batch.draw(backgroundTexture, 0,0, 800, 480);
        game.batch.draw(button1Texture, 300,140, 50, 500);

       // game.font.draw(game.batch, "Welcome to tank_wars!", 300, 240);
        game.batch.draw(wImage, w.x, w.y, w.width, w.height);
        game.batch.draw(t1Image, t1.x, t1.y, t1.width, t1.height);
        //game.font.draw(game.batch, "Click HERE to begin!", 300, 140);
        game.batch.end();

        if (Gdx.input.isTouched()) {
            game.setScreen(new mainscreen(game));
            dispose();
        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

}
