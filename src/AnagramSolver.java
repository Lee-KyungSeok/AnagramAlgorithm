import java.util.Arrays;

/**
 * �Ƴ��׷� �˰���
 * 
 * �ΰ��� ���ڿ� �Է��� �޾Ƽ� �� ���� ���谡 �Ƴ��׷� �������� Ȯ���ϴ� ���α׷��� �����ϼ���
 * �Ƴ��׷� : ���� ������ ���� ������ ���ڰ� ��� ������ �Ƴ��׷��̶�� ��
 * ex1> cat -> act 
 * ex2> was it a cat i saw -> was it a cat i saw
 * ex3> listen -> silent
 * ex4> dormitory -> dirty room
 * 
 * <�˰��� >
 * option : ���� ���ڿ��� ��������
 * 1. ���� ���ڿ��� ���̸� üũ -> ���̰� �ٸ��� �˻����� �ʴ´�.
 * 2. ���� ���ڿ��� ����
 * 3. ���ĵ� ���ڿ��� ��
 * 
 * @author Kyung
 * 
 */
public class AnagramSolver {
	
	public boolean checkAnagram(String a, String b){
		boolean result = false;
		
		// option1 : ��ҹ��� ó��
		a=a.toLowerCase();
		b=b.toLowerCase();

		// option2 : ��������
		a=a.replace(" ", "");
		b=b.replace(" ", "");

		// 1. ���� ��
		if(a.length() != b.length()) {
			return result;
		}
		// 2. ���ڿ��� ������� ����
		// char �迭�� ����
		char aCharArray[] = a.toCharArray();
		char bCharArray[] = b.toCharArray();
		// ĳ���� �迭 ����
		Arrays.sort(aCharArray);
		Arrays.sort(bCharArray);

		// 3. ���ڿ� ��
		result = Arrays.equals(aCharArray, bCharArray);
		
		return result;
	}
	
	// �˰��� �� Ǯ��
	public boolean checkAnagram2(String a, String b) {
		boolean result = true;
		
		// ��ҹ��� ó��
		a = a.toLowerCase();
		b = b.toLowerCase();
		
		// ���� ����
		a = a.replace(" ", "");
		b = b.replace(" ", "");
		
		// ���̺�
		if(a.length() != b.length()) {
			return false;
		}
		
		// �Է¹��� ���ڿ��� ������ Charactor�� ����
		String anaLangA[] = a.split("");
		String anaLangB[] = b.split("");
		
		// a���ڿ��� charactor ������ b���ڿ� charactor�� ����
		// ���� charactor ����� b�� ���� �ʱ�ȭ
		for(int aIndex=0 ; aIndex<a.length() ; aIndex++) {
			for(int bIndex=0 ; bIndex<b.length() ; bIndex++) {
				if(anaLangA[aIndex].equals(anaLangB[bIndex])){
					anaLangB[bIndex]="";
					break;
				}
			}
		}
		
		// ��� ���� �ʱ�ȭ �Ǿ��� ���  true
		// �ϳ��� ���� �����ϰ� �Ǹ� false
		for(int bCheckingIndex=0; bCheckingIndex<b.length() ; bCheckingIndex++) {
			if(!anaLangB[bCheckingIndex].equals("")) {
				result = false;
			}
		}
		
		return result;
	}
}
