//package com.mygdx.game;
//
//import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.Input;
//import com.badlogic.gdx.graphics.Texture;
//import com.badlogic.gdx.math.Rectangle;
//import com.badlogic.gdx.utils.ScreenUtils;
//
//public class tank_choose22 extends tank_choose1{
//    // private Texture backgroundImage;
//    // private TextureRegion backgroundTexture;
//    Texture p2Image;
//    Rectangle p2;
//    public tank_choose22(final tank game) {
//        super(game);
//        p2Image = new Texture(Gdx.files.internal("plr2.png"));
//        p2= new Rectangle();
//        p2.x=200;
//        p2.y =420;
//        p2.width = 400;
//        p2.height = 50;
//        // backgroundTexture = new TextureRegion(backgroundImage, 0, 0, 256, 511);
//        // backgroundImage = new Texture(Gdx.files.internal("tank_Sel1.jpg"));
//    }
//
//
//    @Override
//    public void render(float delta) {
//        ScreenUtils.clear(0, 0, 0, 0);
//
//        camera.update();
//        game.batch.setProjectionMatrix(camera.combined);
//
//        game.batch.begin();
//        game.batch.draw(backgroundTexture, 0,0, 800, 480);
//        //game.font.draw(game.batch, "PLAYER2_TANK: ", 300, 420);
//        game.batch.draw(p2Image, p2.x, p2.y, p2.width, p2.height);
//        game.font.draw(game.batch, "Blazer-->1", 60, 80);
//        game.font.draw(game.batch, "T-34_edited-->2", 800/3+40, 80);
//        game.font.draw(game.batch, "Pumpkin_Tank_transparent-->3", 1600/3, 80);
//
//        game.batch.draw(tankaImage, tanka.x, tanka.y, tanka.width, tanka.height);
//        game.batch.draw(tankbImage, tankb.x, tankb.y, tankb.width, tankb.height);
//        game.batch.draw(tankcImage, tankc.x, tankc.y, tankc.width, tankc.height);
//
//        game.batch.end();
//
//
//        if (Gdx.input.isKeyPressed(Input.Keys.NUM_1)) {
//            game.setScreen(new GameScreen4(game));
//            dispose();
//        }
//        if (Gdx.input.isKeyPressed(Input.Keys.NUM_2)) {
//            game.setScreen(new GameScreen5(game));
//            dispose();
//        }
//        if (Gdx.input.isKeyPressed(Input.Keys.NUM_3)) {
//            game.setScreen(new GameScreen6(game));
//            dispose();
//        }
//        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
//            game.setScreen(new mainscreen(game));
//            dispose();
//        }
//    }
//}