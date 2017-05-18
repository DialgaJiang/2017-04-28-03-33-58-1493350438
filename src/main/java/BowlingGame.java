public class BowlingGame
{
    public int getBowlingScore(String bowlingCode)
    {
        int ans=0;
        String[] t=bowlingCode.split("\\|");
        int s[][]=new int[12][2];
        for (int i=0;i<10;i++)
        {
            if (t[i].charAt(0)=='X')
                s[i][0]=10;
            else if (t[i].charAt(0)=='-'&&t[i].charAt(1)=='-')
                s[i][1]=s[i][0]=0;
            else if (t[i].charAt(1)=='-')
                s[i][0]=t[i].charAt(0)-'0';
            else if (t[i].charAt(0)=='-')
                s[i][1]=t[i].charAt(1)-'0';
            else if (t[i].charAt(1)=='/')
            {
                s[i][0]=t[i].charAt(0)-'0';
                s[i][1]=10-s[i][0];
            }
            else
            {
                s[i][0]=t[i].charAt(0)-'0';
                s[i][1]=t[i].charAt(1)-'0';
            }
        }
        if (t.length==12)
        for (int i=0;i<=1;i++)
        {
            if (t[11].length()>i)
            {
                if (t[11].charAt(i)=='X')
                    s[10][i]=10;
                else if (t[11].charAt(i)=='-')
                    s[10][i]=0;
                else
                    s[10][i]=t[11].charAt(i)-'0';
            }
        }
        s[11][0]=s[10][1];
        for (int i=0;i<=9;i++)
        {
            if (t[i].charAt(0)=='X')
            {
                ans+=10+s[i+1][0];
                if (s[i+1][0]==10)
                    ans+=s[i+2][0];
                else
                    ans+=s[i+1][1];
            }
            else if (t[i].charAt(1)=='/')
                ans+=10+s[i+1][0];
            else
                ans+=s[i][0]+s[i][1];
        }
        return ans;
    }
    /*public static void main(String[] args)
    {
        new BowlingGame();
    }
    BowlingGame()
    {
        String s[]={"X|X|X|X|X|X|X|X|X|X||XX",
            "9-|9-|9-|9-|9-|9-|9-|9-|9-|9-||",
            "5/|5/|5/|5/|5/|5/|5/|5/|5/|5/||5",
            "X|72|9-|X|-8|8/|-6|X|X|X||81"};
        for (String t:s)
            System.out.println(getBowlingScore(t));
    }*/
}
