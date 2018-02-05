import java.util.*;
import java.io.*;

public class Magic_vowel {

	public String vowel = "aeiou";

	int vpos(char c)
	{
		char ch[]=vowel.toCharArray();
	    for (int i = 0; i < 5; ++i)
	        if (c == ch[i])
	            return i;
	    return -1;
	}

	int magical(String s)
	{
	    int l = s.length();
	    char ch[]=s.toCharArray();
	    int previndex[] = {-1, -1, -1, -1, -1};    // for each vowel
	    Vector<Integer> len =new Vector(l, 0);
	    Enumeration vEnum = len.elements();
	    int i = 0, maxlen = 0;

	    // finding first 'a'
	    while (ch[i] != 'a')
	    {
	        ++i;
	        if (i == l)
	            return 0;
	    }

	    previndex[0] = i;       //prev index of 'a'
	     len.add(i,1);

	    for ( ++i; i < l; ++i)
	    {
	        if (vpos(ch[i]) >= 0)    // a vowel
	        {
	            
	            if (previndex[vpos(s[i])] >= 0)
	                len.add(1+len[previndex[vpos(s[i])]]);

	            previndex[vpos(s[i])] = i;

	            if (s[i] != 'a')
	            {
	                if (previndex[vpos(s[i])-1] >= 0)
	                    len[i] = max(len[i], 1+len[previndex[vpos(s[i])-1]]);
	            }

	            maxlen = max(maxlen, len[i]);
	        }
	    }
	    return maxlen;
	}

	
	
}
