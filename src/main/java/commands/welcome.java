package commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import org.jetbrains.annotations.NotNull;

public class welcome {
    public welcome(@NotNull SlashCommandInteractionEvent event) {

        String userTag = event.getUser().getName();
        event.reply("Ты куда звонишь блять? А, **" + userTag + "**!?").queue();

    }
}
