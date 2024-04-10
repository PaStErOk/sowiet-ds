package commands;

import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
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
        if (command.equals("welcome")) new welcome(event);
        if (command.equals("quest")) new quest(event);
        if (command.equals("join")) new join(event);
    }

    @Override
    public void onGuildReady(GuildReadyEvent event) {
        List<CommandData> commandData = new ArrayList<>();
        commandData.add(Commands.slash("welcome","Тестовое сообщение от бота"));
        //commandData.add(Commands.slash("welcome","Тестовое сообщение от бота"));
        //commandData.add(Commands.slash("welcome","Тестовое сообщение от бота"));
        event.getGuild().updateCommands().addCommands(commandData).queue();
    }
}
