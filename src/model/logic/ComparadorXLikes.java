package model.logic;

import java.util.Comparator;

public static class ComparadorXLikes implements Comparator<YoutubeVideo> {

	public ComparadorXLikes() {
		// TODO Auto-generated constructor stub
	}

   /** Comparador alterno de acuerdo al número de likes
	* @return valor 0 si video1 y video2 tiene los mismos likes.
	* valor negativo si video1 tiene menos likes que video2.
	* valor positivo si video1 tiene más likes que video2. */
	public int compare(YoutubeVideo video1, YoutubeVideo video2) {
	
		return video1.compareTo1(video2);
	}

}
