package com.mygdx.game;
import java.util.Iterator;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.TimeUtils;
import jdk.jshell.execution.Util;

import javax.swing.plaf.nimbus.State;

public class GameScreen implements Screen {
    final tank game;
    Texture tankaImage;
    Texture tankbImage,angleImage;
    Texture dropImage,dropImage2;
    private Texture backgroundImage;
    private TextureRegion backgroundTexture;
    Music Music;
    OrthographicCamera camera;
    Rectangle tanka;
    Rectangle tankb,angle;

    Array<Rectangle> fires;
    Array<Rectangle> fires2;
    long lastDropTime;
    //    long lastDropTime2;
//    int dropsGathered;
    int setangle;

    private  int player1health=500;
    private int player2health=500;
    int fuel1=1000,fuel2=1000;
    boolean mAKeyWasPressed ;

    boolean aKeyIsPressed;
    boolean pauseHelper,isPaused;
    int cnt=0,cnt2=0,move1=0,move2=0;

    public GameScreen(final tank game) {
        this.game = game;
        dropImage = new Texture(Gdx.files.internal("missile2.png"));
        dropImage2 = new Texture(Gdx.files.internal("missile3.jpeg"));
        angleImage = new Texture(Gdx.files.internal("angle2.png"));
        tankaImage = new Texture(Gdx.files.internal("tankfrost.png"));
        tankbImage = new Texture(Gdx.files.internal("blazer2.png"));

        //backgroundImage = new Texture(Gdx.files.internal("warback1.jpg"));
        backgroundImage = new Texture(Gdx.files.internal("gsback.jpg"));
        backgroundTexture = new TextureRegion(backgroundImage, 0, 0, 259, 194);



        Music = Gdx.audio.newMusic(Gdx.files.internal("warmusic.mp3"));
        Music.setLooping(true);


        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);


        tanka= new Rectangle();
        tanka.x=0;
        tanka.y =80;

        tanka.width = 90;
        tanka.height = 90;

        angle= new Rectangle();

        angle.x=-20;
        angle.y =-80;

        angle.width = 700;
        angle.height = 500;

        tankb= new Rectangle();
        tankb.x = 1600/3;
        tankb.y = 80;

        tankb.width = 90;
        tankb.height = 90;

        fires = new Array<Rectangle>();
        prefire();
        fires2 = new Array<Rectangle>();
        prefire2();

    }

    private void prefire() {
        Rectangle fire = new Rectangle();
        fire.x = tanka.x+40;
        fire.y = tanka.y+30;
        fire.width = 30;
        fire.height = 30;
        fires.add(fire);
        long now1=TimeUtils.nanoTime();
        lastDropTime =TimeUtils.nanosToMillis(now1);
    }

    private void prefire2() {
        Rectangle fire = new Rectangle();
        fire.x = tankb.x+10;
        fire.y = tankb.y+20;
        fire.width = 30;
        fire.height = 30;
        fires2.add(fire);
        long now2=TimeUtils.nanoTime();
        lastDropTime =TimeUtils.nanosToMillis(now2);
    }



    @Override
    public void render(float delta) {

        ScreenUtils.clear(0, 0, 0.2f, 1);

        camera.update();

        game.batch.setProjectionMatrix(camera.combined);


        game.batch.begin();

        game.batch.draw(backgroundTexture, 0, 0, 800, 480);
        game.font.draw(game.batch, "PLAYER1_HEALTH: " +player1health, 0, 480);
        game.font.draw(game.batch, "PLAYER2_HEALTH: " + player2health, 630, 480);
        game.font.draw(game.batch, "FUEL1: " +fuel1, 0, 420);
        game.font.draw(game.batch, "FUEL2: " + fuel2, 630, 450);
        game.font.draw(game.batch, "Press P to pause: " , 0, 460);
        game.batch.draw(tankaImage, tanka.x, tanka.y, tanka.width, tanka.height);
        game.batch.draw(tankbImage, tankb.x, tankb.y, tankb.width, tankb.height);
        // game.batch.draw(angleImage, angle.x, angle.y, angle.width, angle.height);
        for (Rectangle fire : fires) {
            game.batch.draw(dropImage, fire.x, fire.y,40,30);
        }
        for (Rectangle fire : fires2) {
            game.batch.draw(dropImage2, fire.x, fire.y,40,30);
        }
        game.batch.end();

        if (Gdx.input.isKeyPressed(Input.Keys.P)) {
            game.setScreen(new load_game(game));
            dispose();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){
            game.setScreen(new mainscreen(game));
            dispose();
        }




//        if (Gdx.input.isTouched()) {
//            Vector3 touchPos = new Vector3();
//            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
//            camera.unproject(touchPos);
//            tanka.x = touchPos.x - 64 / 2;
//        }
        if (Gdx.input.isKeyPressed(Keys.LEFT) && fuel2!=0 && cnt2%2!=0)
        { tankb.x -= (200 * Gdx.graphics.getDeltaTime());
            fuel2--;move1++;move2++;}
        if (Gdx.input.isKeyPressed(Keys.RIGHT) && fuel2!=0 && cnt2%2!=0)
        { tankb.x += (200 * Gdx.graphics.getDeltaTime());
            fuel2--;move1++;move2++;}


        if (tankb.x < 0)
            tankb.x = 0;
        if (tankb.x > 800 - 64)
            tankb.x = 800 - 64;

        if (Gdx.input.isKeyPressed(Keys.A) && fuel1!=0 && cnt%2==0 )
        { tanka.x -= (200 * Gdx.graphics.getDeltaTime());
            fuel1--;
            move1++;move2++;}
        if (Gdx.input.isKeyPressed(Keys.D) && fuel1!=0 && cnt%2==0)
        { tanka.x += (200 * Gdx.graphics.getDeltaTime());
            fuel1--;move1++;move2++;}



        if (tanka.x < 0)
            tanka.x = 0;
        if (tanka.x > 800 - 64)
            tanka.x = 800 - 64;

        if (tanka.x <=100) {
            tanka.y = 240;
        }
        if (100<tanka.x && tanka.x <150) {
            tanka.y = 220;
        }
        if(150 < tanka.x && tanka.x < 200){
            tanka.y = 270;
        }
        if (200<tanka.x && tanka.x <250) {
            tanka.y = 265;
        }
        if (250<tanka.x && tanka.x <=300) {
            tanka.y = 260;
        }
        if (300<tanka.x && tanka.x <= 350) {
            tanka.y = 245;
        }
        if (350<tanka.x && tanka.x <400) {
            tanka.y = 230;
        }
        if (400<tanka.x && tanka.x <450) {
            tanka.y = 210;
        }
        if (450<tanka.x && tanka.x <500) {
            tanka.y = 230;
        }
        if (500<tanka.x && tanka.x <600) {
            tanka.y = 260;
        }
        if (600<tanka.x && tanka.x <700) {
            tanka.y = 210;
        }


        if (700<tanka.x && tanka.x <800) {
            tanka.y = 250;
        }




        if (tankb.x <=100) {
            tankb.y = 240;
        }
        if (100<tankb.x && tankb.x <150) {
            tankb.y = 220;
        }
        if (150<tankb.x && tankb.x <200) {
            tankb.y = 270;
        }
        if (200<tankb.x && tankb.x <250) {
            tankb.y = 265;
        }
        if (250<tankb.x && tankb.x <=300) {
            tankb.y = 260;
        }
        if (300<tankb.x && tankb.x <= 350) {
            tankb.y = 245;
        }
        if (350<tankb.x && tankb.x <400) {
            tankb.y = 230;
        }
        if (400<tankb.x && tankb.x <450) {
            tankb.y = 210;
        }
        if (450<tankb.x && tankb.x <500) {
            tankb.y = 230;
        }
        if (500<tankb.x && tankb.x <600) {
            tankb.y = 260;
        }
        if (600<tankb.x && tankb.x <700) {
            tankb.y = 200;
        }
        if (700<tankb.x && tankb.x <800) {
            tankb.y =240;}


        long now = TimeUtils.nanoTime();



        //long nowConvertToMillis = ;

//        if (Gdx.input.isKeyPressed(Keys.X)){
//            //Gdx.app.log("#INFO", "My message.......");
//            //FOR 60*
//            if (Gdx.input.isKeyPressed(Keys.NUM_6)){
//        if (Gdx.input.isKeyPressed(Keys.F))
//            prefire();
//
//
//        Iterator<Rectangle> iter = fires.iterator();
//        while (iter.hasNext()) {
//            Rectangle fire = iter.next();
//            fire.x += 10 * Gdx.graphics.getDeltaTime();
//            if (fire.x + 10 >800)
//                iter.remove();
//            if (fire.overlaps(tankb)) {
//                player2health--;
//                iter.remove();
//            }
//        }}
////30*
//            if(Gdx.input.isKeyPressed(Keys.NUM_3)){
//                if (Gdx.input.isKeyPressed(Keys.F))
//                    prefire();
//
//
//                Iterator<Rectangle> iter = fires.iterator();
//                while (iter.hasNext()) {
//                    Rectangle fire = iter.next();
//                    fire.x += 10 * Gdx.graphics.getDeltaTime();
//                    if (fire.x + 10 >800)
//                        iter.remove();
//                    if (fire.overlaps(tankb)) {
//                        player2health--;
//                        iter.remove();
//                    }
//                }}
////90*
//            if (Gdx.input.isKeyPressed(Keys.NUM_9)){
        if (Gdx.input.isKeyPressed(Keys.F) && cnt%2==0)
        {prefire();cnt++;
            cnt2++;}
//
//
//                Iterator<Rectangle> iter = fires.iterator();
//                while (iter.hasNext()) {
//                    Rectangle fire = iter.next();
//                    fire.x += 10 * Gdx.graphics.getDeltaTime();
//                    if (fire.x + 10 >800)
//                        iter.remove();
//                    if (fire.overlaps(tankb)) {
//                        player2health--;
//                        iter.remove();
//                    }
//                }}
//45*




//30*
//        if(Gdx.input.isKeyPressed(Keys.NUM_3))
//            setangle=30;
//        else if(Gdx.input.isKeyPressed(Keys.NUM_9))
//            setangle=90;
//        else if(Gdx.input.isKeyPressed(Keys.NUM_4))
//            setangle=45;
//        else if(Gdx.input.isKeyPressed(Keys.NUM_6))
//            setangle=60;


        // if (Gdx.input.isKeyPressed(Keys.F))
//            mAKeyWasPressed = false;
//
//
//
////In method:
//        boolean aKeyIsPressed = Gdx.input.isKeyPressed(Keys.F);
//        if (aKeyIsPressed && !mAKeyWasPressed)
//            prefire();
//
//    mAKeyWasPressed = aKeyIsPressed;

//        if (Gdx.input.isKeyPressed(Input.Keys.P)) {
//            // Use a helper so that a held-down button does not continuously switch between states with every tick
//            if (pauseHelper) {
//                if (isPaused) {
//                    prefire();
//                   //Util.toConsole ("No longer paused");
//                    isPaused = false;
//                }
//                else {
//                    //Util.toConsole ("Now paused");
//                    isPaused = true;
//                }
//                pauseHelper = false;
//            }
//        }
//        else {
//            pauseHelper = true;
//        }


        if (Gdx.input.isKeyPressed(Keys.UP) && cnt2%2!=0)
        {prefire2();cnt++;cnt2++;}

        Iterator<Rectangle> i = fires.iterator();

        while (i.hasNext()) {
            Rectangle fire = i.next();

            fire.x += 50 * (Gdx.graphics.getDeltaTime()+0.01);
            if(fire.x<=400 && fire.y<=480){
                fire.y+=(50/(1.732))*(Gdx.graphics.getDeltaTime()+0.01);
            }

            if((fire.x>=400 && fire.y>=0)||(fire.y>=480) ){
                fire.y-=(50/(1.732))*(Gdx.graphics.getDeltaTime()+0.01);
            }

            if (fire.x + 10 >800)
                i.remove();
            if (fire.overlaps(tankb)) {
                player2health=player2health-5;
                i.remove();
            }}
        if (player1health<=0){
            game.setScreen(new player2wins(game));
            dispose();
        }
        if (player2health<=0){
            game.setScreen(new player1wins(game));
            dispose();
        }

        //fire2();
        Iterator<Rectangle> j = fires2.iterator();

        while (j.hasNext()) {
            Rectangle fire = j.next();

            fire.x -= 50 * (Gdx.graphics.getDeltaTime()+0.01);
            if(fire.x>=400 && fire.y<=480){
//                        if(setangle==30)
                fire.y+=(50/(1.732))*(Gdx.graphics.getDeltaTime()+0.01);
            }

            if((fire.x<=400 && fire.y>=0)||(fire.y>=480) ){
//                        if(setangle==30)
                fire.y-=(50/(1.732))*(Gdx.graphics.getDeltaTime()+0.01);
            }

            if (fire.x + 10 >800)
                j.remove();
            if (fire.overlaps(tanka)) {
                player1health=player1health-10;
                j.remove();

            }
        }


    }


    public void fire(){


        Iterator<Rectangle> iter = fires.iterator();

        while (iter.hasNext()) {
            Rectangle fire = iter.next();

            fire.x += 50 * (Gdx.graphics.getDeltaTime()+0.01);
            if(fire.x<=400 && fire.y<=480){
                fire.y+=(50/(1.732))*(Gdx.graphics.getDeltaTime()+0.01);
            }

            if((fire.x>=400 && fire.y>=0)||(fire.y>=480) ){
                fire.y-=(50/(1.732))*(Gdx.graphics.getDeltaTime()+0.01);
            }

            if (fire.x + 10 >800)
                iter.remove();
            if (fire.overlaps(tankb)) {
                player2health=player2health-5;
                iter.remove();
            }}
        if (player1health<=0){
            game.setScreen(new player2wins(game));
            dispose();
        }
        if (player2health<=0){
            game.setScreen(new player1wins(game));
            dispose();
        }
    }


    public void fire1(){
        Iterator<Rectangle> iter1 = fires2.iterator();

        while (iter1.hasNext()) {
            Rectangle fire = iter1.next();

            fire.x += 50 * (Gdx.graphics.getDeltaTime()+0.01);
            if(fire.x<=400 && fire.y<=480){
                fire.y+=(50/(1.732))*(Gdx.graphics.getDeltaTime()+0.01);
            }

            if((fire.x>=400 && fire.y>=0)||(fire.y>=480) ){
                fire.y-=(50/(1.732))*(Gdx.graphics.getDeltaTime()+0.01);
            }

            if (fire.x + 10 >800)
                iter1.remove();
            if (fire.overlaps(tankb)) {
                player2health=player2health-10;
                iter1.remove();

            }
        }

    }
    public void fire2(){
        Iterator<Rectangle> iter2 = fires2.iterator();

        while (iter2.hasNext()) {
            Rectangle fire = iter2.next();

            fire.x -= 50 * (Gdx.graphics.getDeltaTime()+0.01);
            if(fire.x>=400 && fire.y<=480){
                fire.y+=(50/(1.732))*(Gdx.graphics.getDeltaTime()+0.01);
            }

            if((fire.x<=400 && fire.y>=0)||(fire.y>=480) ){
                fire.y-=(50/(1.732))*(Gdx.graphics.getDeltaTime()+0.01);
            }

            if (fire.x + 10 >800)
                iter2.remove();
            if (fire.overlaps(tanka)) {
                player1health=player1health-10;
                iter2.remove();

            }
        }

    }



    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void show() {

        Music.play();
    }


    @Override
    public void hide() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
        tankbImage.dispose();
        tankaImage.dispose();

        Music.dispose();
    }

}