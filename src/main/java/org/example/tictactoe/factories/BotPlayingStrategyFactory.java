package org.example.tictactoe.factories;

import org.example.tictactoe.models.BotDifficultyLevel;
import org.example.tictactoe.strategies.botplaying.BotPlayingStrategy;
import org.example.tictactoe.strategies.botplaying.EasyBotPlayingStrategy;
import org.example.tictactoe.strategies.botplaying.HardBotPlayingStrategy;
import org.example.tictactoe.strategies.botplaying.MediumBotPlayingStrategy;

public class BotPlayingStrategyFactory {
    public static BotPlayingStrategy createStrategy(BotDifficultyLevel level) {
        return switch (level) {
            case EASY -> new EasyBotPlayingStrategy();
            case MEDIUM -> new MediumBotPlayingStrategy();
            case HARD -> new HardBotPlayingStrategy();
        };
    }
}
