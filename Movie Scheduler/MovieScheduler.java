package Puzzles;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

public class MovieScheduler 
{
    //List of movies populated with the start and end times
	public Hashtable populateMovieSchedule1()
	{
		List movies1 = new ArrayList<>();
		movies1.add("Kal Ho Naho");
		movies1.add("Baazigar");
		movies1.add("Baadshah");
		movies1.add("Kabhi Kushi Kabhi Gham");
		movies1.add("Ra One");
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(1);
		list1.add(25);
		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(3);
		list2.add(7);
		List<Integer> list3 = new ArrayList<Integer>();
		list3.add(9);
		list3.add(14);
		List<Integer> list4 = new ArrayList<Integer>();
		list4.add(15);
		list4.add(17);
		List<Integer> list5 = new ArrayList<Integer>();
		list5.add(18);
		list5.add(23);		
		Hashtable movieSchedule1 = new Hashtable();
		movieSchedule1.put(movies1.get(0), list1);
		movieSchedule1.put(movies1.get(1), list2);
		movieSchedule1.put(movies1.get(2), list3);
		movieSchedule1.put(movies1.get(3), list4);
		movieSchedule1.put(movies1.get(4), list5);
		return movieSchedule1;
	}
	
	public Hashtable populateMovieSchedule2()
	{
		List movies1 = new ArrayList<>();
		movies1.add("Wanted");
		movies1.add("Ready");
		movies1.add("BodyGuard");
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(1);
		list1.add(10);
		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(8);
		list2.add(25);
		List<Integer> list3 = new ArrayList<Integer>();
		list3.add(23);
		list3.add(30);	
		Hashtable movieSchedule2 = new Hashtable();
		movieSchedule2.put(movies1.get(0), list1);
		movieSchedule2.put(movies1.get(1), list2);
		movieSchedule2.put(movies1.get(2), list3);
		return movieSchedule2;
		
	}
	//Check the hashtable for movies with earliest start time, add them to the list later remove
	//all the movies which intersect with the chosen movie
	
	
	public void selectedMovies(Hashtable movieSchedule)
	{
		int shortestCompletion,temp;
		int startTime,endTime;
		int selectedStartTime,selectedEndTime;
		List moviesSelected = new ArrayList<String>();
		String shortestMovieSelected,tempMovie;
		Enumeration movies,movies1;
		//movies = movieSchedule.keys();
		List list = new ArrayList<Integer>();
		//shortestMovieSelected = (String)movies.nextElement();
		//list = (List)movieSchedule.get(shortestMovieSelected);
		//shortestCompletion = (int)list.get(1);

		while(movieSchedule.size()>0)
		{
			movies = movieSchedule.keys();
			shortestMovieSelected = (String)movies.nextElement();
			list = (List)movieSchedule.get(shortestMovieSelected);
			shortestCompletion = (int)list.get(1);
			movies = movieSchedule.keys();
			while(movies.hasMoreElements())
			{
				tempMovie = (String)movies.nextElement();
				list = (List)movieSchedule.get(tempMovie);
				temp = (int)list.get(1);
				if(temp < shortestCompletion)
				{
					shortestCompletion = temp;
					shortestMovieSelected = tempMovie; 
				}
			}
			moviesSelected.add(shortestMovieSelected);
			list = (List)movieSchedule.get(shortestMovieSelected);
			selectedStartTime = (int)list.get(0);
			selectedEndTime = (int)list.get(1);
			movies1 = movieSchedule.keys();
			while(movies1.hasMoreElements())
			{
				tempMovie = (String)movies1.nextElement();
				if(tempMovie == shortestMovieSelected)
					continue;
				list = (List)movieSchedule.get(tempMovie);
				startTime = (int)list.get(0);
				endTime = (int)list.get(1);
				if((startTime > selectedStartTime) && (endTime < selectedEndTime) || (startTime > selectedStartTime) && (endTime < selectedEndTime) || (startTime < selectedEndTime))
				{
					movieSchedule.remove(tempMovie);
					movies1 = movieSchedule.keys();
				}
			}
			movieSchedule.remove(shortestMovieSelected);
		}
		System.out.println("The list of movies that needs to be selected to genrate maximum income are as below");
      for(int i=0;i<moviesSelected.size();i++)
      {
    	  System.out.println(moviesSelected.get(i));
      }
	}
	
	public static void main(String[] args) 
	{
		MovieScheduler obj = new MovieScheduler();
		Hashtable movieSchedule1 = obj.populateMovieSchedule1();
		Hashtable movieSchedule2 = obj.populateMovieSchedule2();
		obj.selectedMovies(movieSchedule1);
		obj.selectedMovies(movieSchedule2);		
	}

}
