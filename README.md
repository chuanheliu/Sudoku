A Sudoku is a 9 × 9 quadratic structure with some numbers given in which the digits from 1 through 9 have to be ﬁlled so that in every row, in every column, and in 9 sub-squares of size 3×3 each digit occurs exactly once. For more details, see https://en.wikipedia.org/wiki/Sudoku. Let a fully solved Sudoku (of size 9 × 9) be given as a two-dimensional array of numbers between 1 and 9 so that each number occurs exactly once in each row, each column, and each of the 9 sub-squares. For instance, the following is a fully solved Sudoku: 


++===+===+===++===+===+===++===+===+===++ 
|| 1 | 2 | 3 || 4 | 5 | 6 || 7 | 8 | 9 || 
++---+---+---++---+---+---++---+---+---++
|| 4 | 5 | 6 || 7 | 8 | 9 || 1 | 2 | 3 || 
++---+---+---++---+---+---++---+---+---++ 
|| 7 | 8 | 9 || 1 | 2 | 3 || 4 | 5 | 6 || 
++===+===+===++===+===+===++===+===+===++
|| 2 | 3 | 4 || 5 | 6 | 7 || 8 | 9 | 1 || 
++---+---+---++---+---+---++---+---+---++ 
|| 5 | 6 | 7 || 8 | 9 | 1 || 2 | 3 | 4 || 
++---+---+---++---+---+---++---+---+---++ 
|| 8 | 9 | 1 || 2 | 3 | 4 || 5 | 6 | 7 || 
++===+===+===++===+===+===++===+===+===++
|| 3 | 4 | 5 || 6 | 7 | 8 || 9 | 1 | 2 || 
++---+---+---++---+---+---++---+---+---++ 
|| 6 | 7 | 8 || 9 | 1 | 2 || 3 | 4 | 5 || 
++---+---+---++---+---+---++---+---+---++ 
|| 9 | 1 | 2 || 3 | 4 | 5 || 6 | 7 | 8 ||
++===+===+===++===+===+===++===+===+===++




e.g. by displaying the Sudoku by something such as the following, where originally given ﬁelds such as a2 are displayed by something like *2*, whereas user ﬁlled ﬁelds such as a1 by something like 1 . 

     1   2   3    4   5   6    7   8   9
  ++===+===+===++===+===+===++===+===+===++ 
a || 1 |*2*|*3*||*4*|*5*|*6*||*7*|   |*9*||
  ++---+---+---++---+---+---++---+---+---++ 
b ||*4*|*5*|*6*||*7*|*8*|*9*||*1*|*2*|   ||
  ++---+---+---++---+---+---++---+---+---++ 
c ||*7*|*8*|*9*||*1*|*2*|*3*||*4*|*5*| 6 ||
  ++===+===+===++===+===+===++===+===+===++
d ||*2*|*3*|*4*|| |*6*|*7*||*8*|*9*|*1*|  |
  ++---+---+---++---+---+---++---+---+---++ 
e ||*5*|*6*|*7*||*8*|*9*|*1*||   |*3*|*4*||
  ++---+---+---++---+---+---++---+---+---++
f ||*8*|*9*|*1*||*2*|   |*4*||*5*|*6*|*7*||
  ++===+===+===++===+===+===++===+===+===++
g ||*3*|*4*|   ||*6*|*7*|*8*||*9*|*1*|*2*||
  ++---+---+---++---+---+---++---+---+---++ 
h ||*6*|   |*8*||*9*|*1*|*2*||*3*|*4*|*5*||
  ++---+---+---++---+---+---++---+---+---++ 
i ||   |*1*|*2*||*3*|*4*|*5*||*6*|*7*|*8*||
  ++===+===+===++===+===+===++===+===+===++
  
  
  Essentially there are two steps that your solver should apply:

• The fact that every number may occur only once in each row, column, or big square restricts the (a priori nine) possibilities for each single ﬁeld. If there is only one possibility left for a particular ﬁeld the solver enters that possibility.

• For a particular number check whether in a particular row/column/big square it has only one single place where it can go. If there is only one place the solver enters the number there.
