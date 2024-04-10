package listeners;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.nio.channels.Channel;

public class EventListener extends ListenerAdapter {


    @Override
    public  void onMessageReceived(@NotNull MessageReceivedEvent event){
        if (event.getAuthor().isBot()) return;
        if (event.getGuildChannel().getId().equals("1226845594706907278")) return;
        Message message = event.getMessage();
        String content = message.getContentRaw();
        //Добавить сюда логирование onMessageRecieved (И так же разделить как и команды)
    }
}

