package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.ScreenUtils;


public class tank_choose1 implements  Screen{
    final tank game;
     Texture backgroundImage;
     //removed pvt
    Rectangle tanka,p1;
    Rectangle tankb;
    Rectangle tankc;

    Texture tankaImage;
    Texture tankbImage,p1Image;
    Texture tankcImage;
    TextureRegion backgroundTexture;
    //removed pvt
    OrthographicCamera camera;

    public tank_choose1(final tank game) {
        this.game = game;
        tankaImage = new Texture(Gdx.files.internal("tankfrost.png"));
        tankbImage = new Texture(Gdx.files.internal("Heliostank.png"));
        tankcImage = new Texture(Gdx.files.internal("Blazer.png"));
        backgroundImage = new Texture(Gdx.files.internal("tr.png"));
        //backgroundImage = new Texture(Gdx.files.internal("empty-dark-room-modern-futuristic-sci-fi-background-3d-illustration.jpg"));
        backgroundTexture = new TextureRegion(backgroundImage, 0, 0, 7680, 4320);

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);


        tanka= new Rectangle();
        //tank1.x = 800 / 2 - 64 / 2; // center the bucket horizontally
        tanka.x=60;
        tanka.y = 100; // bottom left corner of the bucket is 20 pixels above
        // the bottom screen edge
        tanka.width = 200;
        tanka.height = 150;


        tankb= new Rectangle();
        tankb.x = (1600/3-0)/2+20; // center the bucket horizontally
        tankb.y = 80; // bottom left corner of the bucket is 20 pixels above
        // the bottom screen edge
        tankb.width = 200;
        tankb.height = 150;

        tankc= new Rectangle();
        tankc.x =500;
        // center the bucket horizontally
        tankc.y = 100; // bottom left corner of the bucket is 20 pixels above
        // the bottom screen edge
        tankc.width = 200;
        tankc.height = 150;

        p1Image = new Texture(Gdx.files.internal("plar1.png"));
        p1= new Rectangle();
        p1.x=200;
        p1.y =420;
        p1.width = 400;
        p1.height = 50;

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
       // game.font.draw(game.batch, "PLAYER1_TANK: ", 300,420 );
        game.font.draw(game.batch, "Blazer-->A", 100, 80);
        game.font.draw(game.batch, "T-34_edited-->B", 800/3+40, 80);
        game.font.draw(game.batch, "Pumpkin_Tank_transparent-->C", 1600/3, 80);
        game.batch.draw(p1Image, p1.x, p1.y, p1.width, p1.height);
        game.batch.draw(tankaImage, tanka.x, tanka.y, tanka.width, tanka.height);
        game.batch.draw(tankbImage, tankb.x, tankb.y, tankb.width, tankb.height);
        game.batch.draw(tankcImage, tankc.x, tankc.y, tankc.width, tankc.height);

        game.batch.end();


        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            game.setScreen(new tank_choose2(game));
            dispose();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.B)) {
            game.setScreen(new tank_choose2(game));
            dispose();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.C)) {
            game.setScreen(new tank_choose2(game));
            dispose();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
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

