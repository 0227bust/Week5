package Application;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dao.ShowDao;
import entity.Show;
public class Menu {
		private ShowDao showDao = new ShowDao();
		private Scanner scanner = new Scanner(System.in);
		private List<String> options  = Arrays.asList(
				"Display All Shows Available" ,
				"Add A Show",
				"Update A show on the List" ,
				"Delete a Show on the List " );

		public void start () {
				String input = " ";
		do {
		printMenu();
		input = scanner.nextLine();
		try {
			if(input.equals("1")) {
				readShows();
			}else if (input.equals("2")) {
				addShow();
			}else if(input.equals("3")) {
				updateShow();
			}else if(input.equals("4")) {
				deleteShow();
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Press Enter to continue");
		scanner.nextLine();

	} while(!input.equals("-1"));

}

		private  void printMenu () {
				System.out.println("Select an Option:");
			for(int i = 0; i < options.size(); i++ ) {
				System.out.println(i + 1 + ") " + options.get(i) );
	}
}
		private void readShows() throws SQLException {
			List<Show> shows = showDao.getShows() ;
			for (Show show : shows ) {
				System.out.println(show.getShowId() + ": " + show.getShowName());
	}
}
		private void addShow() throws SQLException {
				System.out.println("Enter A Show Name You`d Like to Add:");
			String showName = scanner.nextLine();
			showDao.addNewShow(showName);
}
		private void updateShow() throws SQLException {
			System.out.println(" enter an Id for you to update a Show");
			int id = Integer.parseInt(scanner.nextLine());
				System.out.println(" enter your update for the show ");
			String showName = scanner.nextLine();
			showDao.updateShow(id, showName);

}
		private void deleteShow() throws SQLException {
				System.out.println("enter an Id for the show you`d like to delete");
				int id = Integer.parseInt(scanner.nextLine());
				showDao.deleteShow(id);
}

}
