import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;

import javax.security.auth.login.LoginException;

public class Bot {

    private ShardManager shardManager;

    public Bot() throws LoginException {
        DefaultShardManagerBuilder LoadBot = DefaultShardManagerBuilder.createDefault(token.discordToken);
        LoadBot.setStatus(OnlineStatus.ONLINE);
        LoadBot.setActivity(Activity.watching("Смотрю за семьёй"));
        shardManager = LoadBot.build();
    }

    public  ShardManager getShardManager(){
        return  shardManager;
    }

    public static void main(String[] args) {
        try {
            Bot sowietBot = new Bot();
        } catch (LoginException e){
            System.out.println("ERROR: Provided bot token is invalid!");
        }
    }
}
