
package com.mygdx.game;

        import com.badlogic.gdx.Gdx;
        import com.badlogic.gdx.Screen;
        import com.badlogic.gdx.graphics.OrthographicCamera;
        import com.badlogic.gdx.graphics.Texture;
        import com.badlogic.gdx.graphics.g2d.BitmapFont;
        import com.badlogic.gdx.graphics.g2d.SpriteBatch;
        import com.badlogic.gdx.graphics.g2d.TextureRegion;
        import com.badlogic.gdx.math.Rectangle;
        import com.badlogic.gdx.utils.ScreenUtils;
 public class vs_screen implements Screen {
SpriteBatch batch2;
BitmapFont font2;
String text;
    final tank game;

    private Texture backgroundImage,vs1Image,vs2Image;
     Rectangle vs2,vs1;
    private TextureRegion backgroundTexture;
    OrthographicCamera camera;

    public vs_screen(final tank game) {
        this.game = game;
        this.batch2=new SpriteBatch();
        vs1Image = new Texture(Gdx.files.internal("vs1.png"));
        vs1= new Rectangle();
        vs1.x=100;
        vs1.y =240;
        vs1.width = 100;
        vs1.height = 50;

        vs2Image = new Texture(Gdx.files.internal("vs2.png"));
        vs2= new Rectangle();
        vs2.x=600;
        vs2.y =240;
        vs2.width = 100;
        vs2.height = 50;



        //this.font2= TrueTypeFontFactory.createBitmapFont(Gdx.files.internal("front.fnt"));
        backgroundImage = new Texture(Gdx.files.internal("vs_screen.jpg"));
       // this.text="aayush";
        backgroundTexture = new TextureRegion(backgroundImage, 0, 0, 626, 357);
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
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
      // game.font.draw(game.batch, "PLAYER1", 100, 240);
      // game.font.draw(game.batch, "PLAYER2", 600, 240);
      // game.font.draw(game.batch, "aay", 50, 40);
        game.batch.draw(vs1Image, vs1.x, vs1.y, vs1.width, vs1.height);
        game.batch.draw(vs2Image, vs2.x, vs2.y, vs2.width, vs2.height);
       game.font.draw(game.batch, "Click anywhere to begin!", 300, 30);
       game.batch.end();






        if (Gdx.input.isTouched()) {
            game.setScreen(new GameScreen(game));
            dispose();
        }
    }

     public void resize(){

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
