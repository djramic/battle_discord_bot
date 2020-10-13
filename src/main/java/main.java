import groovyjarjarantlr.debug.MessageEvent;
import groovyjarjarantlr.debug.MessageListener;
import groovyjarjarantlr.debug.TraceEvent;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.utils.Compression;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

import javax.security.auth.login.LoginException;
import java.util.ArrayList;


public class main extends ListenerAdapter {
    private static String token = "NzY1NTI4OTg0MzUxMTQ1OTg0.X4WIbA.C13ZCCfxp7wLqGmFkWKEE0KD7YY";
    private static String admin_id = "335178837228912651";
    private ArrayList<String> land_list = new ArrayList<>();
    private ArrayList<String> air_list = new ArrayList<>();
    private ArrayList<String> urban_list = new ArrayList<>();
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
        Message msg = event.getMessage();
        String msg_arr[] = msg.getContentRaw().split(" ",2);
        System.out.println("Komanda je : " + msg_arr[0]);
        //System.out.println("Poruka je  : " + msg_arr[1]);

        if(msg_arr[0].toLowerCase().equals("!land")){
            System.out.println("ID korisnika koji pise: " + event.getAuthor().getId());
            if(event.getAuthor().getId().equals(admin_id))
            {
                land_list.add(msg_arr[1]);
                System.out.println("dodao sam u listu land");
            }
            else
            {
                event.getChannel().sendMessage("Komanda je dostupna samo adminu").queue();
            }
        }
        if(msg_arr[0].toLowerCase().equals("!air")){
            System.out.println("ID korisnika koji pise: " + event.getAuthor().getId());
            if(event.getAuthor().getId().equals(admin_id))
            {
                air_list.add(msg_arr[1]);
            }
            else
            {
                event.getChannel().sendMessage("Komanda je dostupna samo adminu").queue();
            }
        }
        if(msg_arr[0].toLowerCase().equals("!urban")){
            System.out.println("ID korisnika koji pise: " + event.getAuthor().getId());
            if(event.getAuthor().getId().equals(admin_id))
            {
                urban_list.add(msg_arr[1]);
            }
            else
            {
                event.getChannel().sendMessage("Komanda je dostupna samo adminu").queue();
            }
        }

        if(msg_arr[0].toLowerCase().equals("!do")){
            event.getChannel()
                    .sendMessage("URBAN:\n" + urban_list + "\nAIR:\n" + air_list +"\nLAND:\n" + land_list)
                    .queue();
        }
        if(msg_arr[0].toLowerCase().equals("!clear")){
            urban_list.clear();
            air_list.clear();
            land_list.clear();
            event.getChannel()
                    .sendMessage("Liste su obrisane")
                    .queue();
        }
    }
}
