import java.util.*;

public class Playlist {
	private static final int MIN_CAPACITY = 3;
	private Song[] songs;
	private int numSongs;
	
	public Playlist() {
		this.songs = new Song[MIN_CAPACITY];
		this.numSongs = 0;
	}
	
	public Playlist(int capacity) {
		if (capacity < MIN_CAPACITY) {
			this.songs = new Song[MIN_CAPACITY];
		} else {
			this.songs = new Song[capacity];
		}
		this.numSongs = 0;
	}
	
	public int getCapacity() {
		return this.songs.length;
	}

	
	public int getNumSongs() {
		return this.numSongs;
	}
	
	public Song getSong(int i) {
		if (i < 0 || i >= this.numSongs) {
			return null;
		}
		return this.songs[i];
	}
	
	public boolean addSong(Song song) {
		if (song == null) {
			return false;
		}
		
		if (this.numSongs >= this.getCapacity()) {
			return false;
		}
		
		this.songs[this.numSongs] = song; 
		this.numSongs = this.numSongs + 1;
		return true;
	}
	
	public boolean addSong(int i, Song song) {
		if (song == null) {
			return false;
		}
		if (i < 0 || i > this.numSongs) {
			return false;
		}
		if (this.numSongs >= this.getCapacity()) {
			return false;
		}
		for (int j = this.numSongs; j > i; j = j - 1) {
			this.songs[j] = this.songs[j - 1];
		}
		
		this.songs[i] = song; 
		this.numSongs = this.numSongs + 1;
		return true;
	}
	
	public Song[] getSongs() {
		Song[] currentSongs = new Song[this.numSongs];
		for (int i = 0; i < this.numSongs; i = i + 1) {
			currentSongs[i] = this.songs[i];
		}
		return currentSongs;
	}
	
	public int addSongs(Playlist other) {
		if (other == null) {
			return 0;
		}
		
		int addCount = 0;
		int otherCount = other.getNumSongs();
		
		for (int i = 0; i < otherCount; i = i + 1) {
			Song currentSong = other.getSong(i);
			
			boolean songAdded = this.addSong(currentSong);
			if (songAdded) {
				addCount = addCount + 1;
			}
		}
		return addCount;
	}
	
	public Song removeSong() {
		if (this.numSongs == 0) {
			return null;
		}
		
		int lastI = this.numSongs - 1;
		Song removedSong = this.songs[lastI];
		
		this.songs[lastI] = null;
		this.numSongs = this.numSongs - 1;
		return removedSong;
	}
	
	public Song removeSong(int i) {
		if (i < 0 || i >= this.numSongs) {
			return null;
		}
		
		Song removedSong = this.songs[i];
		
		for (int j = i; j < this.numSongs - 1; j = j + 1 ) {
			this.songs[j] = this.songs[j + 1];
		}
		
		this.songs[this.numSongs - 1] = null;
		this.numSongs = this.numSongs - 1;
		
		return removedSong;
	}
	
	public static boolean sameSong(Song song1, Song song2) {
		if (song1 == null || song2 == null) {
			if (song1 == null && song2 == null) {
				return true;
			}
			return false;
		}
		String title1 = song1.getTitle();
		String title2 = song2.getTitle();
		if (title1.equals(title2) == false) {
			return false;
		}
		
		String artist1 = song1.getArtist();
		String artist2 = song2.getArtist();
		if (artist1.equals(artist2) == false) {
			return false;
		}
		
		int[] time1 = song1.getTime();
		int[] time2 = song2.getTime();
		if (time1.length != time2.length) {
			return false;
		}
		
		for (int idx = 0; idx < time1.length; ++idx) {
			if (time1[idx] != time2[idx]) {
				return false;
			}
		}
		return true;
	}

}
