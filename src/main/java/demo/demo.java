package demo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;



@Command(name = "taskcli", version = "taskcli 0.1", mixinStandardHelpOptions = true, subcommands = { Add.class })
public class demo implements Runnable {
    @Override
    public void run() {
        //create the config file
        if(!config.exists()){
            try {
                config.createNewFile();
            }catch (IOException e){
                System.out.println(e.getMessage());
            }
        }
    }
    public static int number = 0;
    public static String configPath = "D:\\TaskTrackerCLI\\config.json";
    public static File config = new File(configPath);
    public static JSONObject numberjson = new JSONObject();
    public static JSONObject TaskStatus = new JSONObject();
    public static JSONObject TaskDescription = new JSONObject();
    public static JSONObject TaskCreatedAt = new JSONObject();
    public JSONObject TaskUpdatedAt = new JSONObject();

    public static void main(String[] args){
        int exitCode = new CommandLine(new demo()).execute(args);
        System.exit(exitCode);
    }
}

@Command(name = "add", description = "add a new task")
class Add implements Runnable {
    @Parameters(paramLabel = "<task content>", defaultValue = "null")
    private String content = "null";

    @Override
    public void run() {
        demo.number ++;
        task tmp = new task();
        tmp.id = demo.number;
        tmp.description = content;
        tmp.status = "to-do";

        try {
            demo.numberjson.put("nums", demo.number);
            demo.TaskDescription.put("description", content);
            demo.TaskStatus.put("Status", tmp.status);
            demo.numberjson.put("Descriptions", demo.TaskDescription);
            demo.numberjson.put("StatusAll", demo.TaskStatus);

            Files.write(Path.of(demo.configPath), demo.numberjson.toString().getBytes());
        } catch (IOException io){
            System.out.println(io.getMessage());
        } catch (JSONException json){
            System.out.println(json.getMessage());
        }

    }
}

class task{
    public int id;
    public String description;
    public String status;
    private Date createdAt;
    private Date updatedAt;
}