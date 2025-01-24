package Array;


public class SetMatrixZero {
	//---------------Brute force Approach-------------------------
	static void setRow0(int i,int arr[][]) {
		for(int k=0;k<arr[0].length;k++) {
			if(arr[i][k]!=0) {
			arr[i][k]=-1;
			}
		}
	}
static void setCol0(int i,int arr[][]) {
	for(int k=0;k<arr.length;k++) {
		if(arr[k][i]!=0) {
		arr[k][i]=-1;
		}
	}
	}
	static void brute(int arr[][]) {
		int n=arr.length;
		int m=arr[0].length;
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(arr[i][j]==0) {
					setRow0(i,arr);
					setCol0(j,arr);
				}
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(arr[i][j]==-1) {
					arr[i][j]=0;
				}
			}
		}
		
		
	
	}
	//------------------Better--------------------------------------
	
	static void better(int arr[][]) {
		int n=arr.length;
		int m=arr[0].length;
		int row[]=new int[n];
		int col[]=new int[m];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(arr[i][j]==0) {
					row[i]=1;
					col[j]=1;
				}
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(row[i]==1||col[j]==1) {
					arr[i][j]=0;
				}
			}
		}
		
	}
	
	
	//-----------------Optimal------------------------
	
	
	static void optimal(int arr[][]) {
		int col=-1;
		int n=arr.length;
		int m=arr[0].length;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(arr[i][j]==0) {
					arr[i][0]=0;
					if(j!=0) {
						arr[0][j]=0;
					}
					else {
						col=0;
					}
					
				}
			}
		}
for(int i=1;i<n;i++) {
	for(int j=1;j<m;j++) {
		if(arr[i][j]!=0) {
			if(arr[i][0]==0||arr[0][j]==0) {
				arr[i][j]=0;
			}
		}
	}
}

if(arr[0][0]==0) {
	for(int k=0;k<m;k++) {
		arr[0][k]=0;
	}
}
if(col==0) {
	for(int k=0;k<n;k++) {
		arr[k][0]=0;
	}
}
		
	}
	
	//main method;
	
	public static void main(String args[]) {
	
		int arr[][]= {
				{0,1,2,0},
				{3,4,5,2},
				{1,3,1,5}
		};
		int n=arr.length;
		int m=arr[0].length;
		//brute(arr);
		//better(arr);
		optimal(arr);
		
		
		
		//print
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}
}
