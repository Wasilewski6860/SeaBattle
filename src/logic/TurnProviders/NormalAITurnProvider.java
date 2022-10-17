package logic.TurnProviders;

import console.CLI;
import logic.Coordinate;
import logic.players.Player;
import logic.players.ai.NormalAI;

public class NormalAITurnProvider extends AITurnProvider {
    public NormalAITurnProvider(Player player) {
        super(player);
    }

}
