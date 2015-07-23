# team2WordScorer

Construct a basic SCRABBLE simulation

Stage 0:

Problem statement: Assume each alphabet is assigned a score. For a list of words, claculate the score of each word and sort it in order of the scores

Solution:
1.Store the score of each letter in a hash map.
2. Store the word as key and its calculated score as value in another hash map
3. Sort the map by value and write it to an output file.

Stage 1: Generate 7 random letters of the alphabet and generate all possible combinations of the letters in order of their maximum score.
