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
		/*
		 * Build a CLI to fetch recent activity of a GitHub user and display it in the terminal
		 * Should accept GitHub username as an argument, fetch the user's recent activity using the
		 * GitHub API and display it in the terminal.
		 */

		/*
		 * TODO:
		 * - Fix Gson exception
		 * - Figure out how to parse through data received from api
		 */
		int pushEventCounter = 0;
		int issueCommentEventCounter = 0;
		int issuesEventCounter = 0;
		int pullRequestEventCounter = 0;
		int createEventCounter = 0;
		int watchEventCounter = 0;
		
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
        System.out.println(events.size());
        
        for(GitHubEvent e : events)
        {
        	switch(e.getType())
        	{
        	case("PushEvent"):
        		pushEventCounter++;
        		
        	case("IssueCommentEvent"):
        		issueCommentEventCounter++;
        		
        	case("IssuesEvent"):
        		issuesEventCounter++;
        		
        	case("PullRequestEvent"):
        		pullRequestEventCounter++;
        		
        	case("CreateEvent"):
        		createEventCounter++;
        		
        	case("WatchEvent"):
        		watchEventCounter++;
        	}

        } 
        
        
			
	}

}
