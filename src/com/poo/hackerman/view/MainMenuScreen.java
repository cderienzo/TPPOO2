package com.poo.hackerman.view;


        import com.badlogic.gdx.Game;
        import com.badlogic.gdx.Gdx;
        import com.badlogic.gdx.Screen;
        import com.badlogic.gdx.graphics.Color;
        import com.badlogic.gdx.graphics.GL20;
        import com.badlogic.gdx.graphics.Texture;
        import com.badlogic.gdx.graphics.g2d.Batch;

public class MainMenuScreen implements Screen {

    private Game game;
    private Texture loadGameButtonActive;
    private Texture loadGameButtonInactive;
    private Texture playButtonActive;
    private Texture playButtonInactive;
    private Texture exitButtonActive;
    private Texture exitButtonInactive;
    private Texture hackermanTitle;
    private Batch batch;


    private static final int TITLE_WIDTH = 702;
    private static final int TITLE_HEIGHT = 86;
    private static final int BUTTON_WIDTH = 219;
    private static final int BUTTON_HEIGHT = 73;
    private static final int CENTER_X = 318;
    private static final int PLAY_Y = 375;
    private static final int LOAD_Y = 475;
    private static final int EXIT_Y = 575;
    private static final int buttonX = CENTER_X + BUTTON_WIDTH;
    private static final int playY = PLAY_Y - BUTTON_HEIGHT;
    private static final int loadY = LOAD_Y - BUTTON_HEIGHT;
    private static final int exitY = EXIT_Y - BUTTON_HEIGHT;

    public MainMenuScreen(Game game) {

        this.game = game;
        playButtonInactive = new Texture("core/assets/playinactive.png");
        playButtonActive = new Texture("core/assets/playactive.png");
        loadGameButtonActive = new Texture("core/assets/loadgameactive.png");
        loadGameButtonInactive = new Texture("core/assets/loadgameinactive.png");
        exitButtonActive = new Texture("core/assets/exitactive.png");
        exitButtonInactive = new Texture("core/assets/exitinactive.png");
        hackermanTitle = new Texture ("core/assets/hackerman.png");
    }

    @Override
    public void render(float delta) {
        clearScreen();

        this.batch.begin();
        draw();
        this.batch.end();
    }

    private void clearScreen() {
        Gdx.gl.glClearColor(Color.BLACK.r, Color.BLACK.g,
                Color.BLACK.b, Color.BLACK.a);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    public void draw() {
        this.batch.draw(hackermanTitle, 76, 450, TITLE_WIDTH, TITLE_HEIGHT);

        if (Gdx.input.getX() < buttonX && Gdx.input.getX() > CENTER_X
                && Gdx.input.getY() > playY && Gdx.input.getY() < PLAY_Y) {
            this.batch.draw(playButtonActive, CENTER_X, 300, BUTTON_WIDTH, BUTTON_HEIGHT);
            if (Gdx.input.isTouched()) {
                //this.dispose();
                //game.createGameScreen(this.game);
                //game.setScreen(game.gameScreen);
            }
        } else {
            this.batch.draw(playButtonInactive, CENTER_X, 300, BUTTON_WIDTH, BUTTON_HEIGHT);
        }
        if (Gdx.input.getX() < buttonX && Gdx.input.getX() > CENTER_X
                && Gdx.input.getY() > loadY && Gdx.input.getY() < LOAD_Y) {
            this.batch.draw(loadGameButtonActive, CENTER_X, 200, BUTTON_WIDTH, BUTTON_HEIGHT);
        } else {
            this.batch.draw(loadGameButtonInactive, CENTER_X, 200, BUTTON_WIDTH, BUTTON_HEIGHT);
        }
        if (Gdx.input.getX() < buttonX && Gdx.input.getX() > CENTER_X
                && Gdx.input.getY() > exitY && Gdx.input.getY() < EXIT_Y) {
            this.batch.draw(exitButtonActive, CENTER_X, 100, BUTTON_WIDTH, BUTTON_HEIGHT);
            if (Gdx.input.isTouched()) {
                this.dispose();
                Gdx.app.exit();
            }
        } else {
            this.batch.draw(exitButtonInactive, CENTER_X, 100, BUTTON_WIDTH, BUTTON_HEIGHT);
        }
    }

    @Override
    public void show() {

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