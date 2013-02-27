package BigData;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;

public class OutputTweets {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Twitter twitter = TwitterFactory.getSingleton();
			User user = twitter.verifyCredentials();
			List<Status> statuses = twitter.getHomeTimeline();
			
			FileWriter output = new FileWriter("tweets.txt");
			BufferedWriter bw = new BufferedWriter(output);
			bw.append("@ " + user.getScreenName() +"'s tweets:\n");
			for(Status status : statuses) {
				bw.append("@" + status.getUser().getScreenName() + " - " + status.getText() + "\n");
			}
			bw.close();
			output.close();
			
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
