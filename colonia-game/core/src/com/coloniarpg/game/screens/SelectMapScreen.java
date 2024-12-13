package com.coloniarpg.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.coloniarpg.game.AssetUtils;

public class SelectMapScreen implements Screen {
    private SpriteBatch batch;
    private Texture background;
    private Stage stage;
    private Game game;
    private FadeScreen fadeScreen;

    public SelectMapScreen(Game game) {
        this.game = game;
    }

    private void startScreenBattleTransition(Screen battleScreenInstance) {
        FadeScreen.FadeInfo fadeOut = new FadeScreen.FadeInfo(FadeScreen.FadeType.OUT, Color.BLACK, Interpolation.smoother, 1f);
        fadeScreen = new FadeScreen(game, fadeOut, this, battleScreenInstance);
        game.setScreen(fadeScreen);
    }

    @Override
    public void show() {
        AssetUtils.initAssets();
        batch = new SpriteBatch();
        background = AssetUtils.backgroundMenu;
        stage = new Stage(new ScreenViewport());

        float scaleGrow = 1.05f;
        float scaleNormal = 1f;

        // Texto "Selecionar Nível"
        TextureRegionDrawable selectLevelDrawable = new TextureRegionDrawable(new TextureRegion(AssetUtils.selectLevelText));
        Image textSelectLevel = new Image(selectLevelDrawable);

        // Botões de Nível
        TextureRegionDrawable[] buttonDrawables = {
            new TextureRegionDrawable(new TextureRegion(AssetUtils.levelButton1)),
            new TextureRegionDrawable(new TextureRegion(AssetUtils.levelButton2)),
            new TextureRegionDrawable(new TextureRegion(AssetUtils.levelButton3)),
            new TextureRegionDrawable(new TextureRegion(AssetUtils.levelButton4))
        };

        Screen[] battleScreens = new Screen[]{
            new BattleScreen1(game),
            new BattleScreen2(game),
            new BattleScreen3(game),
            new BattleScreen4(game)
        };

        Table table = new Table();
        table.setFillParent(true); // Ocupa a tela inteira
        stage.addActor(table);

        // Adiciona texto na tabela
        table.top().padTop(20); // Centraliza e adiciona padding superior
        table.add(textSelectLevel).colspan(4).center().padBottom(50); // Texto "Selecionar Nível"
        table.row(); // Próxima linha

        // Adiciona botões na tabela em uma única linha
        for (int i = 0; i < buttonDrawables.length; i++) {
            final int index = i;
            ImageButton levelButton = new ImageButton(buttonDrawables[i]);
            addButtonListeners(levelButton, scaleGrow, scaleNormal, () -> startScreenBattleTransition(battleScreens[index]));
            table.add(levelButton).width(280).height(280).pad(10); // Ajuste de tamanho e padding
        }

        Gdx.input.setInputProcessor(stage);
    }

    private void addButtonListeners(ImageButton button, float scaleGrow, float scaleNormal, Runnable onClick) {
        button.addListener(new ClickListener() {
            @Override
            public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
                button.getImage().setScale(scaleGrow);
                button.getImage().setOrigin(button.getImage().getWidth() / 2, button.getImage().getHeight() / 2);
            }

            @Override
            public void exit(InputEvent event, float x, float y, int pointer, Actor toActor) {
                button.getImage().setScale(scaleNormal);
            }

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                AssetUtils.songButton.play();
                
                // Animar o botão ao ser pressionado
                ((ImageButton) event.getListenerActor()).getImage().addAction(Actions.sequence(
                    Actions.scaleTo(0.9f, 0.9f, 0.1f, Interpolation.fade),
                    Actions.scaleTo(1f, 1f, 0.1f, Interpolation.fade)
                ));

                onClick.run();
                return true;
            }
        });
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        batch.draw(background, 0, 0);
        batch.end();

        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {}

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void hide() {}

    @Override
    public void dispose() {
        batch.dispose();
        stage.dispose();
    }
}
