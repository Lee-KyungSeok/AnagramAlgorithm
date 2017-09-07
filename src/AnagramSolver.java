import java.util.Arrays;

/**
 * 아나그램 알고리즘
 * 
 * 두개의 문자열 입력을 받아서 두 개의 관계가 아나그램 관계인지 확인하는 프로그램을 개발하세요
 * 아나그램 : 문자 개수가 같고 동일한 문자가 들어 있으면 아나그램이라고 함
 * ex1> cat -> act 
 * ex2> was it a cat i saw -> was it a cat i saw
 * ex3> listen -> silent
 * ex4> dormitory -> dirty room
 * 
 * <알고리즘 >
 * option : 받은 문자열의 공백제거
 * 1. 받은 문자열의 길이를 체크 -> 길이가 다르면 검사하지 않는다.
 * 2. 받은 문자열을 정렬
 * 3. 정렬된 문자열을 비교
 * 
 * @author Kyung
 * 
 */
public class AnagramSolver {
	
	public boolean checkAnagram(String a, String b){
		boolean result = false;
		
		// option1 : 대소문자 처리
		a=a.toLowerCase();
		b=b.toLowerCase();

		// option2 : 공백제거
		a=a.replace(" ", "");
		b=b.replace(" ", "");

		// 1. 길이 비교
		if(a.length() != b.length()) {
			return result;
		}
		// 2. 문자열을 순서대로 정렬
		// char 배열로 변경
		char aCharArray[] = a.toCharArray();
		char bCharArray[] = b.toCharArray();
		// 캐릭터 배열 정렬
		Arrays.sort(aCharArray);
		Arrays.sort(bCharArray);

		// 3. 문자열 비교
		result = Arrays.equals(aCharArray, bCharArray);
		
		return result;
	}
	
	// 알고리즘 외 풀이
	public boolean checkAnagram2(String a, String b) {
		boolean result = true;
		
		// 대소문자 처리
		a = a.toLowerCase();
		b = b.toLowerCase();
		
		// 공백 제거
		a = a.replace(" ", "");
		b = b.replace(" ", "");
		
		// 길이비교
		if(a.length() != b.length()) {
			return false;
		}
		
		// 입력받은 문자열을 각각의 Charactor로 분해
		String anaLangA[] = a.split("");
		String anaLangB[] = b.split("");
		
		// a문자열의 charactor 각각을 b문자열 charactor와 비교후
		// 같은 charactor 존재시 b의 값을 초기화
		for(int aIndex=0 ; aIndex<a.length() ; aIndex++) {
			for(int bIndex=0 ; bIndex<b.length() ; bIndex++) {
				if(anaLangA[aIndex].equals(anaLangB[bIndex])){
					anaLangB[bIndex]="";
					break;
				}
			}
		}
		
		// 모든 값이 초기화 되었을 경우  true
		// 하나라도 값이 존재하게 되면 false
		for(int bCheckingIndex=0; bCheckingIndex<b.length() ; bCheckingIndex++) {
			if(!anaLangB[bCheckingIndex].equals("")) {
				result = false;
			}
		}
		
		return result;
	}
}
