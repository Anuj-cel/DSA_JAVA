// Brute
class Solution {
    public void setMatrixZeroes(int[][] arr) {
        // code here
        int rowNumber=arr.length;
        int colNumber=arr[0].length;
        int row[]=new int[rowNumber];
        int col[]=new int[colNumber];
        for(int i=0;i<rowNumber;i++)
        {
            for(int j=0;j<colNumber;j++)
            {
                if(arr[i][j]==0)
                {
                    row[i]=1;
                    col[j]=1;
                }
            }
        }
        for(int i=0;i<rowNumber;i++)
        {
            for(int j=0;j<colNumber;j++)
            {
               
                if(row[i]==1||col[j]==1)
                {
                   arr[i][j]=0;
                }
            }
        }
        
    }
}

// Tc: O(N*M)
// Sc: O(N+M)
// algo: Simply mark rows and columns that need to be set to zero using two arrays.
// Then iterate through the matrix again to set the appropriate elements to zero based on the marked rows and columns.

// optimal solution:

class Solution {
    public void setMatrixZeroes(int[][] arr) {
        // code here
        int rowNumber=arr.length;
        int colNumber=arr[0].length;
        int c0=1;
        for(int i=0;i<rowNumber;i++)
        {
            for(int j=0;j<colNumber;j++)
            {
                if(arr[i][j]==0)
                {
                  //rows
                  arr[i][0]=0;
                  
                  //col
                  if(j==0)
                  {
                      c0=0;
                  }else {
                      arr[0][j]=0;
                  }
                }
                
            }
        }
        for(int i=1;i<rowNumber;i++)
        {
            for(int j=1;j<colNumber;j++)
            {
               
                if(arr[i][0]==0||arr[0][j]==0)
                {
                   arr[i][j]=0;
                }
            }
        }
        
        //first row
        if(arr[0][0]==0)
        {
            for(int j=0;j<colNumber;j++)
        {
            arr[0][j]=0;
        }
        
        }
        //first column
        if(c0==0)
        {
            for(int i=0;i<rowNumber;i++)
        {
            arr[i][0]=0;
        } 
        }
    }
}

// tc: O(N*M)
// sc: O(1)
// algo: Use the first row and first column to mark which rows and columns should be set to zero.
// take care of the first row and first column separately to avoid overwriting them during marking. 