package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.ScreenUtils;
public class mainscreen implements Screen {
    private TextureRegion terrain;

    final tank game;
    Texture aImage,nImage,n2Image,n3Image;
    Rectangle a,n,n2,n3;
    Texture mainscreenImage;
    //removed pvt
   TextureRegion mainscreenTexture;
   //removed pvt
    OrthographicCamera camera;

    public mainscreen(final tank game) {
        this.game = game;
        mainscreenImage = new Texture(Gdx.files.internal("mainscreen.jpg"));
        mainscreenTexture = new TextureRegion(mainscreenImage, 0, 0, 362, 240);
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
        aImage = new Texture(Gdx.files.internal("logo.png"));
        a= new Rectangle();
        a.x=0;
        a.y = 60;
        a.width = 270;
        a.height = 200;

        nImage = new Texture(Gdx.files.internal("new.png"));
        n= new Rectangle();
        n.x=530;
        n.y =240;
        n.width = 200;
        n.height = 50;

        n2Image = new Texture(Gdx.files.internal("load.png"));
        n2= new Rectangle();
        n2.x=540;
        n2.y =160;
        n2.width = 200;
        n2.height = 50;

       // n3Image = new Texture(Gdx.files.internal("exit.png"));
        n3Image = new Texture(Gdx.files.internal("generatedtext (16).png"));
        n3= new Rectangle();
        n3.x=540;
        n3.y =0;
        n3.width = 100;
        n3.height = 50;
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
        game.batch.draw(mainscreenTexture, 0,0, 800, 480);
        game.batch.draw(nImage, n.x, n.y, n.width, n.height);
        game.batch.draw(n2Image, n2.x, n2.y, n2.width, n2.height);
        game.batch.draw(n3Image, n3.x, n3.y, n3.width, n3.height);
        //game.font.draw(game.batch, "TANK WARS", 300, 440);
        game.batch.draw(aImage, a.x, a.y, a.width, a.height);
        game.font.draw(game.batch, "Press1", 600, 240);
        game.font.draw(game.batch, "Press2", 600, 160);
        game.font.draw(game.batch, "Press3", 600, 15);
        game.batch.end();

        if (Gdx.input.isKeyPressed(Input.Keys.NUM_1)) {
            game.setScreen(new tank_choose1(game));
            dispose();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.NUM_2)) {
            game.setScreen(new load_game(game));
            dispose();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.NUM_3)) {
            game.setScreen(new tank_choose1(game));
            dispose();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
            game.setScreen(new MainMenu(game));
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
mainscreenImage.dispose();
    }

}
