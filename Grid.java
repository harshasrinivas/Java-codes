// prints path from x1,y1 to x2,y2 in a grid/maze with obstacles
import java.util.Scanner;

public class Grid
{

	static int[][] a = new int[1000][1000];
	static int[][] sum = new int[1000][1000];
	static int x1,y1,x2,y2;
	static int n,m,h,t;
	static int[] q1 = new int[1000000];
	static int[] q2 = new int[1000000];
	public static void func(int x,int y)
	{
	    if(x>0)
	    if(a[x-1][y]==0)
	    {
	        if(sum[x-1][y]!=-1)
	        {
	            if((sum[x][y]+1)<sum[x-1][y])
	            {
	                sum[x-1][y]=sum[x][y]+1;
	                func(x-1,y);
	            }
	        }
	        else
	        {
	            sum[x-1][y]=sum[x][y]+1;
	            func(x-1,y);
	        }
	    }

	    if(x<n-1)
	    if(a[x+1][y]==0)
	    {
	        if(sum[x+1][y]!=-1)
	        {
	            if((sum[x][y]+1)<sum[x+1][y])
	            {
	                sum[x+1][y]=sum[x][y]+1;
	                func(x+1,y);
	            }
	        }
	        else
	        {
	            sum[x+1][y]=sum[x][y]+1;
	            func(x+1,y);
	        }
	    }

	    if(y>0)
	    if(a[x][y-1]==0)
	    {
	        if(sum[x][y-1]!=-1)
	        {
	            if((sum[x][y]+1)<sum[x][y-1])
	            {
	                sum[x][y-1]=sum[x][y]+1;
	                func(x,y-1);
	            }
	        }
	        else
	        {
	            sum[x][y-1]=sum[x][y]+1;
	            func(x,y-1);
	        }
	    }

	    if(y<m-1)
	    if(a[x][y+1]==0)
	    {
	        if(sum[x][y+1]!=-1)
	        {
	            if((sum[x][y]+1)<sum[x][y+1])
	            {
	                sum[x][y+1]=sum[x][y]+1;
	                func(x,y+1);
	            }
	        }
	        else
	        {
	            sum[x][y+1]=sum[x][y]+1;
	            func(x,y+1);
	        }
	    }
	}

	public static int check(int x,int y)
	{
		if(x>0)
			if(sum[x-1][y]==sum[x][y]-1)
			{
				q1[h+1]=x-1;
				q2[h+1]=y;
				h+=1;
				if((x-1==x1)&&(y==y1))
					{return 0;}
				check(x-1,y);
				return 0;
			}

		if(x<n-1)
			if(sum[x+1][y]==sum[x][y]-1)
			{
				q1[h+1]=x+1;
				q2[h+1]=y;
				h+=1;
				if((x+1==x1)&&(y==y1))
					{return 0;}
				check(x+1,y);
				return 0;
			}

		if(y>0)
			if(sum[x][y-1]==sum[x][y]-1)
			{
				q1[h+1]=x;
				q2[h+1]=y-1;
				h+=1;
				if((x==x1)&&(y-1==y1))
					{return 0;}
				check(x,y-1);
				return 0;
			}

		if(y<m-1)
			if(sum[x][y+1]==sum[x][y]-1)
			{
				q1[h+1]=x;
				q2[h+1]=y+1;
				h+=1;
				if((x==x1)&&(y+1==y1))
					{return 0;}
				check(x,y+1);
				return 0;
			}
			return 0;
	}

	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
    
        System.out.print("Number of Rows in Maze = ");
		n=in.nextInt();
		System.out.print("Number of Columns in Maze = ");
		m=in.nextInt();
		
		System.out.print("Enter the Maze values from (0,0) to (row-1,column-1) : \n");
		int i=1,j=1,s;
		for(i=0;i<n;i++)
		{
			for(j=0;j<m;j++)
			{
				sum[i][j]=-1;
				a[i][j]=in.nextInt();
			}
		}
		System.out.println("In this program, x co-ordinate refers to row and y co-ordinate refers to column");
		System.out.print("x co-ordinate of point A = ");
        x1=in.nextInt();
        System.out.print("y co-ordinate of point A = ");
        y1=in.nextInt();
        System.out.print("x co-ordinate of point B = ");
        x2=in.nextInt();
        System.out.print("y co-ordinate of point B = ");
        y2=in.nextInt();

		sum[x1][y1]=0;
    	func(x1,y1);
    	//System.out.println(sum[x2][y2]);
    	q1[0]=x2;
    	q2[0]=y2;
    	h=0;
    	check(x2,y2);
    	System.out.print("Shortest Path: ");
		for(i=h;i>=0;i--)
		{
			System.out.print(q1[i]);
			System.out.print(",");
			System.out.print(q2[i]);
			System.out.print(": ");
		}
		System.out.print("\n");
	}

}
