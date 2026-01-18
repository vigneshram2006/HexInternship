package HEXlevel2;

import java.util.*;

class Movie {
	private String title;
	private int releasedYear;
	private String genre;
	private String language;
	private long duration;
	private int rating;

	Movie(String title, int releasedYear, String genre, String language, long duration, int rating) {
		this.releasedYear = releasedYear;
		this.title = title;
		this.duration = duration;
		this.genre = genre;
		this.rating = rating;
		this.language = language;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getReleasedYear() {
		return releasedYear;
	}

	public void setReleasedyear(int releasedYear) {
		this.releasedYear = releasedYear;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Movie [title=" + title + ", releasedYear=" + releasedYear + ", genre=" + genre + ", language="
				+ language + ", duration=" + duration + ", rating=" + rating + "]";
	}
}

class MovieService {
	List<Movie> movies = new ArrayList<>();

	public void addMovie(String title,int releasedYear,String genre,String language,long duration,int rating) {
		Movie movie= new Movie(title,releasedYear,genre,language, duration, rating);
		movies.add(movie);
	}
	public void displayMovies() {
		if(movies.isEmpty()) {
			System.out.println("List is empty");
		}else {
			
		
		System.out.println();
		for(Movie ms: movies) {
			System.out.println(ms);
		}}
	}
	public void searchMovie(String title) {
		boolean found=false;
		for (Movie mov:movies) {
			if(mov.getTitle().equalsIgnoreCase(title)) {
				System.out.println();
				System.out.println("Movie found: "+mov);
				found=true;
				break;
			}
		}
		if(!found) {
			System.out.println("Movie not found.");
		}
		
	}

}

public class MovieDataBase {

	public static void main(String[] args) {
		MovieService movserv= new MovieService();
		movserv.addMovie("Inception", 2010, "Sci-Fi", "English", 148, 9);
		movserv.addMovie("Interstellar", 2014, "Sci-Fi", "English", 169, 9);
		movserv.addMovie("Parasite", 2019, "Thriller", "Korean", 132, 9);
		movserv.addMovie("Bahubali: The Beginning", 2015, "Action", "Telugu", 159, 8);
		movserv.addMovie("Jai Bhim", 2021, "Drama", "Tamil", 164, 9);
		movserv.displayMovies();
		movserv.searchMovie("Jai bhim");
		
		


	}

}
