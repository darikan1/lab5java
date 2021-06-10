
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.*;
import java.util.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class Main {
	static Writer writer;
	
	public static void main(String[] args) throws IOException {

		Worker worker = new Worker();
		 List<Book> allData = new ArrayList<Book>();
		 Scanner sc = new Scanner(System.in);
		 readData(allData);
		 while (true){
	            System.out.println("\nВиберіть дію:\n1 - Додати запис; \n2 - Редагувати запис; \n3 - Видалити запис; \n4 - Показати всі записи; \nq - Вихід; \ne - Вивести книги з програмування");
	            switch (sc.nextLine()){
	                case "1": {
	                	addBook(sc, allData);
	                    break;
	               	}
	                case "2": {
	                	edit(sc, allData);
	                	break;
	                }
	                case "3": {
	                	delete(sc, allData);
	                    break;
	                }
	                case "4": {
	                	showAll(allData);
	                    break;
	                }
	                case "q": {
	                    return;
	                }
	                case "e":{
	                	showAll(worker.GetProgramingBooks(allData));
	                    break;
	                }
	                default: {
	                    System.out.println("Неправильна дія! ");
	                    break;
	                }
	            }
		 }

	}
	
	private static void addBook(Scanner sc, List<Book> allData) {
		System.out.println("Введіть id");
		int id = Integer.parseInt(sc.nextLine());
		System.out.println("Введіть назву");
		String name = sc.nextLine();
		System.out.println("Введіть автора");
		String author = sc.nextLine();
		System.out.println("Введіть видавництво");
		String publisher = sc.nextLine();
		System.out.println("Введіть рік видання");
		int year = Integer.parseInt(sc.nextLine());
		Book book = new Book(id,name,author,publisher, year);
		allData.add(book);
		try {
			writeData(allData);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	} 
	private static void writeData(List<Book> allData) throws IOException {

	
		writer = new FileWriter("database.txt",true);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(allData);
		writer.write(json);
		writer.flush();
	}
	public static void readData(List<Book> allData) throws IOException {
		Gson gson = new Gson();
		String json ="";
			json = Files.readString(Path.of("database.txt"));
		
		Book [] array = gson.fromJson(json, Book[].class);
		for (int i = 0; i < array.length; i++) {
			allData.add(array[i]);
		}
		var a = 1;
	}
	private static void showAll(List<Book> allData) {
		for (Book book : allData) {
			book.preatyWrite();
		}
	}
	 private static void edit(Scanner sc, List<Book> allData) {
	        showAll(allData);
	        System.out.println("\nВиберіть номер запису для редагування: ");
	        int index = Integer.parseInt(sc.nextLine()) - 1;
	        Book book = allData.get(index);
	        
	        System.out.println("\n1 - Змінити назву; \n2 - Змінити автора; \n3 - Змінити видавництво; \n4 - Змінити рік видачі\n");
	        switch (sc.nextLine()){
	            case "1": {
	                System.out.println("Введіть нову назву");
	                book.setName(sc.nextLine());
	                break;
	            }
	            case "2": {
	                System.out.println("Введіть нового автора");
	                book.setAuthor(sc.nextLine());
	                break;
	            }
	            case "3": {
	                System.out.println("Введіть нове видавництво");
	                book.setPublisher(sc.nextLine());
	                break;
	            }
	            case "4": {
	                System.out.println("Введіть новий рік");
	                book.setYear(Integer.parseInt(sc.nextLine()));
	                break;
	            }
	        }
	}
	private static void delete(Scanner sc, List<Book> allData) {
        showAll(allData);
        System.out.println("Виберіть номер запису для видалення: ");
        int index = Integer.parseInt(sc.nextLine()) - 1;
        allData.remove(index);
        try {
			writeData(allData);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
