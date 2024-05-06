package code.problems.string;

public class KmpSearch {
    static int kmpSearch(char[] text, char[] pat){
        int[] lsp = computeLsp(pat);
        int i=0,j=0;
        while (i < text.length && j < pat.length){
            if (text[i] ==  pat[j]){
                i++;
                j++;
            }else{
                if (j != 0){
                    j = lsp[i-1];
                }else{
                    i++;
                }
            }
        }
        if (j == pat.length)  // pat found till its length
            return i-j;
        return -1;
    }

    static int[] computeLsp(char[] pat){
        int[] lsp = new int[pat.length];
        lsp[0] = 0;
        int i=1, j=0;
        while(i < pat.length){
            if (pat[i] ==  pat[j]){
                lsp[i] = j+1;
                i++;
                j++;
            }else{
                if (j != 0){
                    j = lsp[j-1];
                }else{
                    i++;
                }
            }
        }
        return lsp;
    }


}
