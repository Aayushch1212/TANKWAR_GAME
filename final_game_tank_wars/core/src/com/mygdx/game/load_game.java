package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.ScreenUtils;

public class load_game extends mainscreen{
    Texture aImage;
    Rectangle a;
    Texture g1Image,g2Image,g3Image,eImage,sImage;
    Rectangle g1,g2,g3,e,s;

    public load_game(tank game) {

        super(game);
        aImage = new Texture(Gdx.files.internal("logo.png"));
        a= new Rectangle();
        a.x=0;
        a.y = 50;
        a.width = 270;
        a.height = 200;

        g1Image = new Texture(Gdx.files.internal("1game.png"));
        g1= new Rectangle();
        g1.x=540;
        g1.y =250;
        g1.width = 80;
        g1.height = 50;

        g2Image = new Texture(Gdx.files.internal("2game.png"));
        g2= new Rectangle();
        g2.x=540;
        g2.y =180;
        g2.width = 80;
        g2.height = 50;

        g3Image = new Texture(Gdx.files.internal("3game.png"));
        g3= new Rectangle();
        g3.x=540;
        g3.y =110;
        g3.width = 80;
        g3.height = 50;


        eImage = new Texture(Gdx.files.internal("generatedtext (16).png"));
        e= new Rectangle();
        e.x=540;
        e.y =0;
        e.width = 80;
        e.height = 50;

        sImage = new Texture(Gdx.files.internal("save.png"));
        s= new Rectangle();
        s.x=500;
        s.y =350;
        s.width = 200;
        s.height = 50;

    }
    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 0);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        game.batch.draw(mainscreenTexture, 0,0, 800, 480);
        //game.font.draw(game.batch, "TANK WARS", 300, 440);
        game.font.draw(game.batch, "Press1", 600, 250);
        game.font.draw(game.batch, "Press2", 600, 180);
        game.font.draw(game.batch, "Press3", 600, 110);
        game.font.draw(game.batch, "Esc", 600, 20);
        game.batch.draw(aImage, a.x, a.y, a.width, a.height);
        game.batch.draw(sImage, s.x, s.y, s.width, s.height);
        game.batch.draw(g1Image, g1.x, g1.y, g1.width, g1.height);
        game.batch.draw(g2Image, g2.x, g2.y, g2.width, g2.height);
        game.batch.draw(g3Image, g3.x, g3.y, g3.width, g3.height);
        game.batch.draw(eImage, e.x, e.y, e.width, e.height);
        game.batch.end();

        if (Gdx.input.isKeyPressed(Input.Keys.NUM_1)) {
            game.setScreen(new GameScreen(game));
            dispose();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.NUM_2)) {
            game.setScreen(new GameScreen(game));
            dispose();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.NUM_3)) {
            game.setScreen(new GameScreen(game));
            dispose();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE) ){
            game.setScreen(new mainscreen(game));
            dispose();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
            game.setScreen(new MainMenu(game));
            dispose();
        }
    }
}
