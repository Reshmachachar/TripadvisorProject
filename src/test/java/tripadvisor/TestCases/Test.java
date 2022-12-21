package tripadvisor.TestCases;



public class Test {
	
	public static void main(String[] args) {
		String s="Welcome to city";
		String[] words=s.split(" ");
		String rev=" ";
		for(String part:words) {
			String reverseWord=" ";
			for(int i=part.length()-1;i>=0;i--) {
				reverseWord=reverseWord+part.charAt(i);
			}
			rev=rev+reverseWord+ " ";
			}
		System.out.println(rev);
		
		String str="Welcome To selenium";
		String[] words1=str.split(" ");
		String rev1=" ";
		for(String part1:words1) {
		StringBuilder sb=new StringBuilder(part1);
		sb.reverse();
		rev1=rev1+sb.toString()+" ";
		}
		System.out.println(rev1);
	
	}
}

