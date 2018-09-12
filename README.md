# Assessment


Coding assessment


Assumptions taken for the realization:

In order for the tree to be valid, the string given in input must, once trimmed, start with a '[' char and end with a ']' char (there may be spaces before and after, thus the once trimmed).
All values must be separated by a comma, last element (after the closing ']') excluded.
I am assuming that after the first bracket is closed, there can be no more elements in the input string (there can be only one tree inputed at a time).
There may be use of multiple indentation using mutliple '['s and ']'s in the input string (ie: [a,[[b,..] will see b with a double indentation), but there may not be spaces between the use of the indentation symbols ('[' & ']').



The runtime complexity of both functions is O(n), where n is the length of the string. The nested where loops on line 26, 35, 66 and 67 will in the worst case cycle every character of the elements of the array origninated from the split(), thus giving a worse case scenario once again of O(n).


Regarding the spatial analysis, even if the String object is passed by value, it is not a primitive: thus only one will be kept in memory while passed to the functions and will return to it's initial state when the functions return. int he functions themselves there will be the creation of a array of max c/2 strings by definition (worse case, every element is one char separated by commas), where c is the number of chars present in the input string.
