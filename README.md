A Sudoku is a 9 × 9 quadratic structure with some numbers given in which the digits from 1 through 9 have to be ﬁlled so that in every row, in every column, and in 9 sub-squares of size 3×3 each digit occurs exactly once. For more details, see https://en.wikipedia.org/wiki/Sudoku. Let a fully solved Sudoku (of size 9 × 9) be given as a two-dimensional array of numbers between 1 and 9 so that each number occurs exactly once in each row, each column, and each of the 9 sub-squares. For instance, the following is a fully solved Sudoku: 

  
  
  Essentially there are two steps that your solver should apply:

• The fact that every number may occur only once in each row, column, or big square restricts the (a priori nine) possibilities for each single ﬁeld. If there is only one possibility left for a particular ﬁeld the solver enters that possibility.

• For a particular number check whether in a particular row/column/big square it has only one single place where it can go. If there is only one place the solver enters the number there.
