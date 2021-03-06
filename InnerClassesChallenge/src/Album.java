import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {
	private String name;
	private String artist;
	private SongList songList;

	public Album(String name, String artist) {
		super();
		this.name = name;
		this.artist = artist;
		this.songList = new SongList();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public SongList getSongList() {
		return songList;
	}

	public void addToPlaylist(String title, LinkedList<Song> playlist) {
		Song songToAddToPlaylist = findSong(title);
		if (songToAddToPlaylist == null) {
			System.out.println("No Song Found to Add!");
			;
		} else {
			playlist.add(songToAddToPlaylist);
		}
	}

	public void addSong(String title, double duration) {
		
			songList.addSong(title, duration);
		
	}


	public Song findSong(String title) { 
		Song foundSong = songList.findSong(title);
		return foundSong;
	}
	
	private class SongList {
		private ArrayList<Song> songListArray;

		public SongList() {
			super();
			songListArray = new ArrayList<Song>();
		}

		public Song findSong(String title) {
			for (int i = 0; i < songListArray.size(); i++) {
				if (title.equals(songListArray.get(i).getTitle())) {
					return songListArray.get(i);
				}
			}
			return null;
		}

		public void addSong(String title, double duration) {
			if (findSong(title) == null) {
				songListArray.add(new Song(title, duration));
			} else {
				System.out.println("Song already exists!");
			}
		}
	}
}
