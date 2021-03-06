package edu.virginia.cs.sgd.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

import edu.virginia.cs.sgd.Program;
import edu.virginia.cs.sgd.input.InputListener;
import edu.virginia.cs.sgd.util.SingletonAssetManager;

/**
 * The base class for all game screens.
 */
public abstract class AbstractScreen implements Screen, InputListener {
	public static final int VIEWPORT_WIDTH = 800,
			VIEWPORT_HEIGHT = 480;


	protected final Stage stage;
	protected Skin skin;

	private Class<? extends AbstractScreen> newScreen;
	
	public AbstractScreen() {
		int width = VIEWPORT_WIDTH;
		int height = VIEWPORT_HEIGHT;
		this.stage = new Stage(width, height, true);

	}

	protected String getName() {
		return getClass().getName();
	}

	@Override
	public void show() {
		Gdx.app.log(Program.LOG, "Showing screen: " + getName());

//        skin = SingletonAssetManager.getInstance().get("UISkin");
	}

	@Override
	public void resize(int width, int height) {
		Gdx.app.log(Program.LOG, "Resizing screen: " + getName() + " to: "
				+ width + " x " + height);
		
		stage.setViewport(width, height, false);
	}

	@Override
	public void render(float delta) {
		// (1) process the game logic

		// update the actors
		stage.act(delta);

		// (2) draw the result

		// clear the screen with the given RGB color (black)
		Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		// draw the actors
		stage.draw();

		// draw the table debug lines
		Table.drawDebug(stage);
	}

	@Override
	public void hide() {
		Gdx.app.log(Program.LOG, "Hiding screen: " + getName());

		// dispose the screen when leaving the screen;
		// note that the dipose() method is not called automatically by the
		// framework, so we must figure out when it's appropriate to call it
		dispose();
	}

	@Override
	public void pause() {
		Gdx.app.log(Program.LOG, "Pausing screen: " + getName());
	}

	@Override
	public void resume() {
		Gdx.app.log(Program.LOG, "Resuming screen: " + getName());
	}

	@Override
	public void dispose() {
		Gdx.app.log(Program.LOG, "Disposing screen: " + getName());
	}

	public void changeScreen(Class<? extends AbstractScreen> newScreen) {
		this.newScreen = newScreen;
	}
	
	public Class<? extends AbstractScreen> checkScreenChange() {
		return newScreen;
	}
	
	@Override
	public void keyDown(int keyCode) {

	}

	@Override
	public void keyUp(int keyCode) {
		
	}

	@Override
	public void touchDown(int screenX, int screenY, int pointer, int button) {
		
	}

	@Override
	public void touchUp(int screenX, int screenY, int pointer, int button, boolean dragging) {
		
	}

	@Override
	public void mouseMoved(int screenX, int screenY, int deltaX, int deltaY) {
		
	}

	@Override
	public void scrolled(int amount) {
		
	}
	
	@Override
	public void touchDragged(int screenX, int screenY, int pointer, int deltaX, int deltaY) {
		
	}
}
