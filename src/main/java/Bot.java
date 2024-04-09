import commands.CommandManager;
import io.github.cdimascio.dotenv.Dotenv;
import listeners.EventListener;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;

import javax.security.auth.login.LoginException;


public class Bot {

    private  final Dotenv config;
    private final ShardManager shardManager;

    public Bot() throws LoginException {
        //Авторизация бота
        config = Dotenv.configure().ignoreIfMissing().load();
        String token = config.get("TOKEN");

        DefaultShardManagerBuilder LoadBot = DefaultShardManagerBuilder.createDefault(token);
        LoadBot.setStatus(OnlineStatus.ONLINE);
        LoadBot.setActivity(Activity.watching("Смотрю за семьёй"));
        LoadBot.enableIntents(GatewayIntent.GUILD_MEMBERS,GatewayIntent.MESSAGE_CONTENT,GatewayIntent.GUILD_PRESENCES);
        LoadBot.setMemberCachePolicy(MemberCachePolicy.ALL);
        LoadBot.setChunkingFilter(ChunkingFilter.ALL);
        shardManager = LoadBot.build();

        //Регистрация событий
        shardManager.addEventListener(new EventListener(), new CommandManager());
    }

    public  Dotenv getConfig() {
        return  config;
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
