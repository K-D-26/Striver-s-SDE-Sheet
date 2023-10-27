// Method 1:

class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split(" +");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }
}


// Method 2:

class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length()-1; i++){
            char c = s.charAt(i);
            char a = s.charAt(i+1);
            if (c == ' ' && a == ' ') continue;
            if (c == ' ' && a != ' ') continue;
            if (c != ' ' && a != ' ') sb.append(c);
            if (c != ' ' && a == ' '){
                sb.append(c);
                sb.append(' ');
            }
        }
        if (s.charAt(s.length()-1) != ' ') sb.append(s.charAt(s.length()-1));
        
        String rev = sb.toString();
        String[] arr = rev.split(" ");
        StringBuilder sb2 = new StringBuilder();

        for (int i = arr.length-1; i >= 0; i--){
            sb2.append(arr[i]);
            sb2.append(' ');
        }
        sb2.deleteCharAt(sb2.length() - 1);

        return sb2.toString();
    }
}