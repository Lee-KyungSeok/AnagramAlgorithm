# Anagram(아나그램) 알고리즘
아나그램 : 단어나 문장을 구성하고 있는 문자의 순서를 바꾸어 다른 단어나 문장을 만드는 놀이 </br>두개의 문자가 주어졌을 때 문자 개수가 같고 동일한 문자가 들어 있는 경우

## __문제__
두개의 문자열 입력을 받아서 두 개의 관계가 아나그램 관계인지 확인하는 프로그램을 개발
 * ex1> cat <-> act
 * ex2> was it a cat i saw <-> was it a cat i saw
 * ex3> listen <-> silent
 * ex4> dormitory <-> dirty room

### __풀이__
<알고리즘 >
0. (option : 받은 문자열의 공백제거 / 대소문자 구분 제거)
1. 받은 문자열의 길이 비교
2. 받은 문자열을 각각 문자 순서에 맞게 정렬
3. 정렬된 문자열을 비교

#### __소스 코드__
``` java
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
```

### __풀이-2__
정석 알고리즘을 활용하지 않은 풀이
0. (option : 받은 문자열의 공백제거 / 대소문자 구분 제거)
1. 받은 문자열의 길이 비교
2. 입력 받은 문자열을 각각의 문자로 분해
3. 쪼개진 두개의 문자열을 서로 비교하여 일치하는 문자가 있는 경우 배열에서 제거
4. 배열 내 요소 전부 문자가 존재하지 않는다면 true 반환</br> 하나라도 존재한다면 false 반환

#### __소스 코드__
``` java
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
```
