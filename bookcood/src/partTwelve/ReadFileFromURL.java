package partTwelve;

import java.util.Scanner;

public class ReadFileFromURL {
	@SuppressWarnings("resource")
	public static void main(String[] args){
		System.out.print("Enter a URL");
		String URLString = new Scanner(System.in).next();
		
		try{
			java.net.URL url = new java.net.URL(URLString);
			int count = 0;
			Scanner input = new Scanner(url.openStream());
			while(input.hasNext()){
				String line = input.nextLine();
				System.out.println(line);
				count += line.length();			
			}			
			input.close();
			System.out.println("The file size is " + count + " characters");
		}
		catch(java.net.MalformedURLException ex){
			System.out.println("I/O Errors: no such file");
		}
		catch(java.io .IOException ex){
			System.out.println("I/O Errors: no such file");
		}
	}
}
