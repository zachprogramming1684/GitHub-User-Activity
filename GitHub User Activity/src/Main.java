import java.io.IOException;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import com.google.gson.Gson;


public class Main 
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
		HttpRequest getRequest = HttpRequest.newBuilder()
				.uri(new URI("https://api.github.com/users/zachprogramming1684/events"))
				.header("accept", "application/vnd.github+json")
				.build();
				
		HttpClient h = HttpClient.newHttpClient();
		HttpResponse<String> getResponse = h.send(getRequest, BodyHandlers.ofString());
		System.out.println(getResponse.body());
		
		Gson g = new Gson();
		
	}

}
