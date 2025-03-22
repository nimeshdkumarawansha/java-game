package levels;

import main.Game;
import utils.LoadSave;

import java.awt.*;
import java.awt.image.BufferedImage;

public class LevelManager {
    private Game game;
    private BufferedImage[] levelSprite;
    private Level levelOne;

    public LevelManager(Game game) {
        this.game = game;
        loadOutsideSprites();
        levelOne = new Level(LoadSave.getLevelData());
    }

    private void loadOutsideSprites() {
        BufferedImage image = LoadSave.getSpriteAtlas(LoadSave.LEVEL_ATLAS);
        levelSprite = new BufferedImage[48];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 12; j++) {
                int index = i * 12 + j;
                levelSprite[index] = image.getSubimage(j * 32, i * 32, 32, 32);
            }
        }
    }

    public void draw(Graphics g) {
        for (int j = 0; j < Game.TILES_IN_HEIGHT; j++) {
            for (int i = 0; i < Game.TILES_IN_WIDTH; i++) {
                int index = levelOne.getSpriteIndex(i, j);
                g.drawImage(levelSprite[index], i * Game.TILES_SIZE, j * Game.TILES_SIZE,Game.TILES_SIZE,Game.TILES_SIZE, null);
            }
        }
    }

    public void update() {
    }
    public Level getCurrentLevel() {
        return levelOne;
    }
}
