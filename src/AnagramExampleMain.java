
public class AnagramExampleMain {
	
	public static void main(String args[]) {
		
		boolean check = false;
		AnagramSolver anagram = new AnagramSolver();
		check = anagram.checkAnagram("Dormitory", "Dirty Room");
		
		if(check) {
			System.out.println("This is Anagram");
		} else {
			System.out.println("This is not Anagram");
		}
	}

}
