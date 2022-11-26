public class Palindrome {
    public Deque<Character> wordToDeque(String word){
        Deque<Character> dq=new ArrayDeque<>();
        int len = word.length();
        for (int i = 0; i<len; i++) {
            dq.addLast(word.charAt(i));
        }
        return dq;
    }

    public boolean isPalindrome(String word) {
        if (word == null || word.length() <= 1) {
            return true;
        }

        String revers = "";
        int len = word.length();
        for (int i = 0; i<len; i++) {
            revers += word.charAt(len-i-1);
        }

        if (revers.equals(word)) {
            return true;
        }
        return false;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        if (word == null || word.length() <= 1) {
            return true;
        }

        int len = word.length();
        for (int i = 0; i<len/2; i++) {
            if (!cc.equalChars(word.charAt(i), word.charAt(len-i-1))) {
                return false;
            }
        }
        return true;
    }
}
