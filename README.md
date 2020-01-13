# SubsetSum-Problem

# Definition Of The Problem

This problem is based on a set. Small subsets of elements of this set are created. The sum of the number of elements of this subset is calculated. This calculated total value is the largest number, smaller than the desired total value. If it is equal to the desired value, it is found. For example, 

Let this be our array set.  

set[ ] A = { 4, 2 , 10 , 12}  

Let our sum value be 20. When we calculate the elements of this set of subsets, none of them is equal to 20. So we need to find the subset with the largest value smaller than that. 

sub[ ] = { 12 , 4 , 2 } 

When we calculate 12 + 4 + 2 the result will be 18. There is no other subset smaller than 20 and greater than 18. 


# Code Implementation

Before you start writing the code, you should look at the shared algorithm on the "dp_examples" slide. In this algorithm, the base case sum value and array length are 0. In this case 0 must be returned. Another case is that the value of an element in the Array is greater than the sum value. In such a case, the index value of the array should be lowered and recursion should be done. Otherwise, decrease the index number by one, subtract the value of the array from the sum value and put it back into the recurison. Before doing this operation, add the int value resulting from this event with the value of the array in the index and compare the int value with the other recursion to get the maximum int value.

<img src="https://user-images.githubusercontent.com/36292743/72293285-0fbe7600-3608-11ea-8ee2-158c1ebc6423.png" width="600" height="100">

Recursion: Recursion solution can be done using the above algorithm. Base case was determined and returned to 0. The other case was then checked and the Recursion was called again. Finally, the comparison was made and the maximum value was obtained. This maximum value was also returned.

<img src="https://user-images.githubusercontent.com/36292743/72293514-8196bf80-3608-11ea-8a24-fa7e1f1c8c8e.png" width="600" height="200">

Dynamic Programing: This code should be written according to the algorithm given above. But unlike recursion, Dynamic 2D array is used. The length of this array is "sum x set.lenght". Recursion called recursion in every if case. In Dynamic, this 2D array is either updated or load up. 

<img src="https://user-images.githubusercontent.com/36292743/72293316-2369dc80-3608-11ea-98b5-39b6b522479d.png" width="600" height="200">

Memoized Recursion: HashMap is used in this solution. If the values are checked and the controls are used, the algorithm given above is used. However, these if cases are checked from within HashMap. 2 different int values are kept according to if cases. An int value that results from a reduced and recursion invocation of the index. This is called "exclude". Another is the int value, when the maximum is calculated (using the algorithm above). This is called include. HashMap keeps key and value. The key here is "size | sum". Value is the "exclude" and "include" values that we calculated before. Finally, the value in this HashMap is returned.

<img src="https://user-images.githubusercontent.com/36292743/72293562-96735300-3608-11ea-9dc6-d6eb7885a8ea.png" width="600" height="200">

When we run these solutions, the results are as follows. If the array length is 6 and the sum value is 100, they all calculate in 0 seconds.

<img src="https://user-images.githubusercontent.com/36292743/72293623-bb67c600-3608-11ea-8ff9-29bf3adf0f51.png" width="500" height="150">

When you increase the length and sum value of this array a bit, they will no longer work in 0 seconds. Except for the recursion, the values run again in 0 seconds. The recursion value works for about 1.5 seconds.

<img src="https://user-images.githubusercontent.com/36292743/72293651-d0dcf000-3608-11ea-8df2-37f28b57ab97.png" width="500" height="150">

When we increase these values a little more, recursion now works much slower. Recursion runs in 7 seconds. Others operate in 1 second again. Recursion gives an "Out Of Memory Error" error when higher values are given.

<img src="https://user-images.githubusercontent.com/36292743/72293677-df2b0c00-3608-11ea-8b9c-a1abfbcc451d.png" width="500" height="150">

Higher values must be given to determine whether it is dynamic or Memoized. Because the 2D array is created in the Dynamic algorithm and the length of this array is "sum x set.length", the larger the sum value, the slower Dynamic runs. Array length of 3500 and sum value of 177640 when we do a trial, Dynamic 3 seconds Memoized works in 0 seconds. Thus, the more sum value increases, the more dynamic we have seen.

<img src="https://user-images.githubusercontent.com/36292743/72293730-fcf87100-3608-11ea-8d87-f037f9649cf1.png" width="500" height="150">

# Asymptotic Complexities

The complexity of the algorithm written for recursion is as follows.

<img src="https://user-images.githubusercontent.com/36292743/72294117-c4a56280-3609-11ea-90ce-da6b93159262.png" width="500" height="250">


The total complexity is : T(n) = 3T(n-1) + 1. If the tree is drawn, the process can be solved easily. Since it is called 3 times, the length of the tree has to go down to 3 above k. That's why complexity is O(3^n). The complexity of the algorithm written for Dynamic is shown below. 

<img src="https://user-images.githubusercontent.com/36292743/72294130-c838e980-3609-11ea-8a2a-bb78243688d1.png" width="500" height="250">


The total complexity is : T(n) = 3(size x sum) +1 . This complexity also seems to be easy. The complexity is O(size x sum). Memoized's complexity is similar to that of dynamic. The difference between them is the use of maps and checking if cases with them. So the complexity is for Memoized O(size x sum).

# Actual Running Time Table

<img src="https://user-images.githubusercontent.com/36292743/72293864-392bd180-3609-11ea-8400-aa8350213e10.png" width="500" height="250">
