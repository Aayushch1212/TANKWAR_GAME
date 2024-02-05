package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.ScreenUtils;

public class player2wins extends mainscreen{
    Texture aImage;
    Rectangle a;
    Texture g1Image,g2Image,g3Image,eImage,sImage;
    Rectangle g1,g2,g3,e,s;

    public player2wins(tank game) {

        super(game);
        aImage = new Texture(Gdx.files.internal("logo.png"));
        a= new Rectangle();
        a.x=0;
        a.y = 50;
        a.width = 270;
        a.height = 200;

        nImage = new Texture(Gdx.files.internal("mainsc.png"));
        n= new Rectangle();
        n.x=530;
        n.y =240;
        n.width = 200;
        n.height = 50;


        eImage = new Texture(Gdx.files.internal("generatedtext (16).png"));
        e= new Rectangle();
        e.x=540;
        e.y =0;
        e.width = 80;
        e.height = 50;

        sImage = new Texture(Gdx.files.internal("player1wins.png"));
        s= new Rectangle();
        s.x=150;
        s.y =300;
        s.width = 500;
        s.height = 200;


    }
    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 0);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        game.batch.draw(mainscreenTexture, 0,0, 800, 480);
        //game.font.draw(game.batch, "TANK WARS", 300, 440);
      game.font.draw(game.batch, "PressM", 530, 230);
//        game.font.draw(game.batch, "Press2", 600, 180);
//        game.font.draw(game.batch, "Press3", 600, 110);
        game.font.draw(game.batch, "Esc", 600, 20);
        game.batch.draw(aImage, a.x, a.y, a.width, a.height);
        game.batch.draw(sImage, s.x, s.y, s.width, s.height);
//        game.batch.draw(g1Image, g1.x, g1.y, g1.width, g1.height);
//        game.batch.draw(g2Image, g2.x, g2.y, g2.width, g2.height);
//        game.batch.draw(g3Image, g3.x, g3.y, g3.width, g3.height);
        game.batch.draw(nImage, n.x, n.y, n.width, n.height);
        game.batch.draw(eImage, e.x, e.y, e.width, e.height);
        game.batch.end();

        if (Gdx.input.isKeyPressed(Input.Keys.M)) {
            game.setScreen(new mainscreen(game));
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
