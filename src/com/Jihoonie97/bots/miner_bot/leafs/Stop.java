package com.Jihoonie97.bots.miner_bot.leafs;

import com.runemate.game.api.hybrid.RuneScape;
import com.runemate.game.api.script.framework.tree.LeafTask;

/**
 * NOTES:
 * Stop the bot
 */
public class Stop extends LeafTask {

    @Override
    public void execute() {
        RuneScape logout = new RuneScape();
        logout.logout();
    }
}
