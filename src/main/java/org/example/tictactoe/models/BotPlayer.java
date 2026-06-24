package org.example.tictactoe.models;

import org.example.tictactoe.factories.BotPlayingStrategyFactory;
import org.example.tictactoe.strategies.botplaying.BotPlayingStrategy;

public class BotPlayer extends Player{
    private BotDifficultyLevel botDifficultyLevel;
    private BotPlayingStrategy botPlayingStrategy;
    public BotPlayer(String name,
                     Symbol symbol,
                     BotDifficultyLevel botDifficultyLevel) {
        super(name, symbol, PlayerType.BOT);
        this.botDifficultyLevel = botDifficultyLevel;
        this.botPlayingStrategy = BotPlayingStrategyFactory.createStrategy(botDifficultyLevel);
    }

    public BotDifficultyLevel getBotDifficultyLevel() {
        return botDifficultyLevel;
    }

    public BotPlayingStrategy getBotPlayingStrategy() {
        return botPlayingStrategy;
    }
}
