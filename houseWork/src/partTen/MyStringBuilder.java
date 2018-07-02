package partTen;

public class MyStringBuilder {
	char[] s;	
	public MyStringBuilder(String s){
		this.s = s.toCharArray();
	}
	
	public MyStringBuilder  append(MyStringBuilder s){
		char[] S = new char[s.s.length + this.s.length];
		for(int i = 0; i < this.s.length; i++){
			S[i] = this.s[i];
		}
		
		for(int i = this.s.length ; i < s.s.length + this.s.length; i++){
			S[i] = s.s[i];
		}
		this.s = S;
		
		return this;
	}
	
	public MyStringBuilder append(int i	){
		char[] s = new char[this.s.length + 1];
		for(int j = 0; j < s.length; j++){
			s[j] = this.s[j];
		}
		s[this.s.length] = (char)i;
		return this;
	}
	
	public MyStringBuilder toLowerCase(){
		for(int i = 0; i < s.length; i++){
			if( s[i]  >= 'A' && s[i] <= 'Z'){
				s[i] = (char) (s[i] + 32);
			}
		}
		
		return this;
	}
	
	public MyStringBuilder subString(int begin , int end){
		char[]	S = new char[end - begin +1];
		for(int i = begin; i <= end; i++){
			S[i - begin] = s[i];
		}
		s = S;
		return this;	
	}
	
	public String toString(){
		String S = null;
		for(int i = 0; i < s.length; i++){
			S = s[i] + "";
		}
		return S;
	}
}
