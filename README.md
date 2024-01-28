# Coin-Change-Algorithm
This algorithm involves creating an enumeration of coins change program using recursion. The user will be able to input a desired amount in cents and the program will count the different ways the money can be returned using various currencies. The default currency for this program is the Canadian currency but any other currency can be used. 




![image](https://github.com/itsnavid06/Coin-Change-Machine/assets/92177592/2865299b-2bed-4350-a341-7cc75194abaa)

I have specified the desired amount in cents, and the program has generated multiple combinations that can be collected.  

The recurseWays methods is our main method in this program. In this method we simply call other 
methods within the program to print out the sequence, insert into the sequence, delete from the 
sequence, and recursively calling the recurseWays method.
