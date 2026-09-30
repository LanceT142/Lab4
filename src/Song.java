import java.util.*;

public class Song {
	
	private final String title;
	private final String artist;
	private final int[] time;
	
	public Song(String title, String artist, int[] time) {
		this.title = title;
		this.artist = artist;
		if (time != null) {
			this.time = time.clone();
		} else {
			this.time = null;
		}
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getArtist() {
		return artist;
	}
	
	public int[] getTime() {
		if (time != null) {
			return time.clone();
		} else {
			return null;
		}
	}

}
