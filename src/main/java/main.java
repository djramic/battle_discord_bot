import groovyjarjarantlr.debug.MessageEvent;
import groovyjarjarantlr.debug.MessageListener;
import groovyjarjarantlr.debug.TraceEvent;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.utils.Compression;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

import javax.security.auth.login.LoginException;


public class main extends ListenerAdapter {
    private static String token = "NzY1NTI4OTg0MzUxMTQ1OTg0.X4WIbA.C13ZCCfxp7wLqGmFkWKEE0KD7YY";
    public static void main(String args[]) {

        JDABuilder builder = JDABuilder.createDefault(token).addEventListeners(new main());
        try {
            builder.build();
        } catch (LoginException e) {
            e.printStackTrace();
        }

    }


    public void onMessageReceived(MessageReceivedEvent event)
    {
        if (event.isFromType(ChannelType.PRIVATE))
        {
            System.out.printf("[PM] %s: %s\n", event.getAuthor().getName(),
                    event.getMessage().getContentDisplay());
        }
        else
        {
            System.out.printf("[%s][%s] %s: %s\n", event.getGuild().getName(),
                    event.getTextChannel().getName(), event.getMember().getEffectiveName(),
                    event.getMessage().getContentDisplay());
        }
    }
}
