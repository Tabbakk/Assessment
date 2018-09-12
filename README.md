# Assessment


Coding assessment



The runtime complexity of both functions is O(n), where n is the length of the string. The nested where loops on line 26, 35, 66 and 67 will in the worst case cycle every character of the elements of the array origninated from the split(), thus giving a worse case scenario once again of O(n).


Regarding the spatial analysis, even if the String object is passed by value, it is not a primitive: thus only one will be kept in memory while passed to the functions and will return to it's initial state when the functions return. int he functions themselves there will be the creation of a array of max c/2 strings by definition (worse case, every element is one char separated by commas), where c is the number of chars present in the input string.
