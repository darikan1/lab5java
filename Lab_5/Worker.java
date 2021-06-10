import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Worker  implements IProgrammingFinder{



	@Override
	public List<Book> GetProgramingBooks(List<Book> allData) {
		List<Book> res = new ArrayList<>();
		for (Book book : allData) {
			if(book.Name.toLowerCase().contains("програмування")) {
				res.add(book);
				}
		}
		Collections.sort(res,  new Comparator<Book>() {
			@Override
			public int compare(Book o1, Book o2) {
				return o1.Year > o2.Year ? -1 : (o1.Year < o2.Year)? 1:0;
			}
		});
		
		return res;
	}

	
}
