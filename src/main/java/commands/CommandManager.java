package commands;

import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class CommandManager extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        String command = event.getName(); // /hello
        if (command.equals("Welcome")) {
            String userTag = event.getUser().getId();
            event.reply("Ты куда звонишь блять? А, **<@" + userTag + ">**!").queue();
        }
    }

    @Override
    public void onGuildReady(GuildReadyEvent event) {
        List<CommandData> commandData = new ArrayList<>();
        commandData.add(Commands.slash("welcome","Get welcomed by the bot"));
        event.getGuild().updateCommands().addCommands(commandData).queue();
    }

    //Global

    @Override
    public void onReady(ReadyEvent event) {
        List<CommandData> commandData = new ArrayList<>();
        commandData.add(Commands.slash("welcome","Get welcomed by the bot"));
        event.getJDA().updateCommands().addCommands(commandData).queue();
    }
}
