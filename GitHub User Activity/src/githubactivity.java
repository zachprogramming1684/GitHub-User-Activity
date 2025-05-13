import java.io.IOException;
import java.lang.reflect.Type;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class githubactivity 
{
	public static void main(String[] args) throws Exception
	{
		try
		{
			HttpRequest getRequest = HttpRequest.newBuilder()
					.uri(new URI(args[0]))
					.header("accept", "application/vnd.github+json")
					.build();
					
			HttpClient h = HttpClient.newHttpClient();
			HttpResponse<String> getResponse = h.send(getRequest, BodyHandlers.ofString());
			String jsonString = getResponse.body();
			
			Gson g = new Gson();
			
	        Type eventListType = new TypeToken<ArrayList<GitHubEvent>>() {}.getType();
	        ArrayList<GitHubEvent> events = g.fromJson(jsonString, eventListType);
	        
	        for(GitHubEvent e : events)
	        {
	        	System.out.println(e.getType() + " at " + e.getRepo().getName() + " || Date: " + e.getCreatedAt().toString());
	        } 	
		}
		catch(Exception e)
		{
			System.out.println("Please ensure you have typed a correct GitHub API endpoint for user activity.");
		}
	}

}
