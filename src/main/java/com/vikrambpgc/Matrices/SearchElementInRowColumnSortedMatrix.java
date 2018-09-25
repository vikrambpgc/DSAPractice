package com.vikrambpgc.Matrices;
import java.util.ArrayList;

public class SearchElementInRowColumnSortedMatrix {
    public int searchMatrix(ArrayList<ArrayList<Integer>> a, int b) {
       int i = 0, j = a.get(0).size() -1;  //set indexes for top right element
       while ( i < a.size() && j >= 0 ) {
          if ( a.get(i).get(j) == b )
          {
             //printf("\n Found at %d, %d", i, j);
             return 1;
          }
          if ( a.get(i).get(j) > b )
            j--;
          else //  if mat[i][j] < x
            i++;
       }
     
       //printf("\n Element not found");
       return 0;  // if ( i==n || j== -1 )
    }
}
