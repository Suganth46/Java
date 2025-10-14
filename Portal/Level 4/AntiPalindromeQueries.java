import java.util.*;
public class AntiPalindromeQueries{
    public static void main(String args[]){
        Scanner s=new Scanner(System.in);
        int T=s.nextInt();
        while(T-->0){
            int n=s.nextInt();
            int q=s.nextInt();
            int[] p1=new int[n+1];
            int[] p2=new int[n+1];
            int[] p3=new int[n+1];
            for(int i=1;i<=n;i++){
                int val=s.nextInt();
                p1[i]=p1[i-1];
                p2[i]=p2[i-1];
                p3[i]=p3[i-1];
                if(val==1) p1[i]++;
                else if(val==2) p2[i]++;
                else p3[i]++;
            }
            for(int i=0;i<q;i++){
                int l=s.nextInt();
                int r=s.nextInt();
                int m=r-l+1;
                if(m%2!=0){
                    System.out.println("No");
                    continue;
                }
                int half=m/2;
                int c1=p1[r]-p1[l-1];
                int c2=p2[r]-p2[l-1];
                int c3=p3[r]-p3[l-1];
                if(c1==half || c2==half || c3==half){
                    System.out.println("Yes");
                }
                else{
                    System.out.println("No");
                }
            }
        }
    }
}