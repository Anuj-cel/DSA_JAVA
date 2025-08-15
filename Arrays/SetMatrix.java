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

other approach: rowAffected and columnAffected
class Solution {
    public void setMatrixZeroes(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        
        boolean rowAffected = false;
        boolean colAffected = false;

        // Check if first row should be zero
        for (int j = 0; j < cols; j++) {
            if (mat[0][j] == 0) {
                rowAffected = true;
                break;
            }
        }

        // Check if first column should be zero
        for (int i = 0; i < rows; i++) {
            if (mat[i][0] == 0) {
                colAffected = true;
                break;
            }
        }

        // Mark rows and columns
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (mat[i][j] == 0) {
                    mat[i][0] = 0;
                    mat[0][j] = 0;
                }
            }
        }

        // Apply zeroes based on marks
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (mat[i][0] == 0 || mat[0][j] == 0) {
                    mat[i][j] = 0;
                }
            }
        }

        // Zero the first row if needed
        if (rowAffected) {
            for (int j = 0; j < cols; j++) {
                mat[0][j] = 0;
            }
        }

        // Zero the first column if needed
        if (colAffected) {
            for (int i = 0; i < rows; i++) {
                mat[i][0] = 0;
            }
        }
    }
}
// tc: O(N*M)
// sc: O(1)